var Calculator = {
    Model: {
        currentInput: "",
        lastOperation: "",
        lastValue: "",
        lastResult: "",
        justEvaluated: false,
        wasRead: false
    },

    View: {
        screen: {id: "decimal-screen", tag: "div", value: "", row: 0, onclick: ""},

        seven: {id: "decimal-seven", tag: "button", value: 7, row: 1, onclick: ""},
        eight: {id: "decimal-eight", tag: "button", value: 8, row: 1, onclick: ""},
        nine: {id: "decimal-nine", tag: "button", value: 9, row: 1, onclick: ""},
        add: {id: "decimal-add", tag: "button", value: "+", row: 1, onclick: ""},

        four: {id: "decimal-four", tag: "button", value: 4, row: 2, onclick: ""},
        five: {id: "decimal-five", tag: "button", value: 5, row: 2, onclick: ""},
        six: {id: "decimal-six", tag: "button", value: 6, row: 2, onclick: ""},
        subtract: {id: "decimal-subtract", tag: "button", value: "-", row: 2, onclick: ""},

        three: {id: "decimal-three", tag: "button", value: 3, row: 3, onclick: ""},
        two: {id: "decimal-two", tag: "button", value: 2, row: 3, onclick: ""},
        one: {id: "decimal-one", tag: "button", value: 1, row: 3, onclick: ""},
        multiply: {id: "decimal-multiply", tag: "button", value: "*", row: 3, onclick: ""},

        zero: {id: "decimal-zero", tag: "button", value: 0, row: 4, onclick: ""},
        decimal: {id: "decimal-decimal", tag: "button", value: ".", row: 4, onclick: ""},
        equal: {id: "decimal-equal", tag: "button", value: "=", row: 4, onclick: ""},
        divide: {id: "decimal-divide", tag: "button", value: "/", row: 4, onclick: ""},

        clearScreen: {id: "decimal-clearScreen", tag: "button", value: "C", row: 5, onclick: ""},
        readMem: {id: "decimal-readMem", tag: "button", value: "MR", row: 5, onclick: ""},
        subFromMem: {id: "decimal-subFromMem", tag: "button", value: "M-", row: 5, onclick: ""},
        addToMem: {id: "decimal-addToMem", tag: "button", value: "M+", row: 5, onclick: ""},

        clearMem: {id: "decimal-clearMem", tag: "button", value: "MC", row: 6}
    },

    Controller: {

    },

    run: function(){
        Calculator.attachHandlers();
        return Calculator.buildView();
    },

    buildView: function(){
        var v = "";
        v += '<div class="calc-body">';
        for (var r = 0; r < 7; r++){
            v += '<div class="calc-row">';
                for(element in Calculator.View){
                    if(Calculator.View.hasOwnProperty(element)
                        && Calculator.View[element].hasOwnProperty('row')
                        && Calculator.View[element].row == r) {
                        v += Calculator.buildElement(Calculator.View[element]);
                    }
                }
            v += '</div>';
        }
        v += '</div>';
        return v;
    },

    buildElement: function(element){
        var el = '<' + element.tag + ' ';
        el += 'id="' + element.id + '"';
        el += 'onclick="' + element.onclick + '"';
        el += '>' + element.value;
        el += '</' + element.tag + '>';
        return el;
    },

    attachHandlers: function() {
        Calculator.View.one.onclick = "Calculator.input(Calculator.View.one.value, true)";
        Calculator.View.two.onclick = "Calculator.input(Calculator.View.two.value, true)";
        Calculator.View.three.onclick = "Calculator.input(Calculator.View.three.value, true)";
        Calculator.View.four.onclick = "Calculator.input(Calculator.View.four.value, true)";
        Calculator.View.five.onclick = "Calculator.input(Calculator.View.five.value, true)";
        Calculator.View.six.onclick = "Calculator.input(Calculator.View.six.value, true)";
        Calculator.View.seven.onclick = "Calculator.input(Calculator.View.seven.value, true)";
        Calculator.View.eight.onclick = "Calculator.input(Calculator.View.eight.value, true)";
        Calculator.View.nine.onclick = "Calculator.input(Calculator.View.nine.value, true)";
        Calculator.View.zero.onclick = "Calculator.input(Calculator.View.zero.value, true)";
        Calculator.View.decimal.onclick = "Calculator.input(Calculator.View.decimal.value, true)";

        Calculator.View.add.onclick = "Calculator.input(Calculator.View.add.value, false)";
        Calculator.View.subtract.onclick = "Calculator.input(Calculator.View.subtract.value, false)";
        Calculator.View.multiply.onclick = "Calculator.input(Calculator.View.multiply.value, false)";
        Calculator.View.divide.onclick = "Calculator.input(Calculator.View.divide.value, false)";

        Calculator.View.equal.onclick = "Calculator.evaluateInput()";
        Calculator.View.clearScreen.onclick = "Calculator.clearScreenOp()";
        Calculator.View.clearMem.onclick = "Calculator.clearMemory()";
        Calculator.View.readMem.onclick = "Calculator.readMemory()";
        Calculator.View.addToMem.onclick = "Calculator.addToMemory()";
        Calculator.View.subFromMem.onclick = "Calculator.subtractFromMemory()";
    },

    input: function(value, isNum) {
        isNum = (typeof isNum !== 'undefined') ? isNum : false;
        if (!isNum) {
            document.getElementById(Calculator.View.screen.id).innerHTML = '';
            Calculator.Model.lastOperation = value;
            Calculator.Model.lastValue = '';
        } else if(Calculator.Model.justEvaluated){
            Calculator.Model.justEvaluated = false;
            document.getElementById(Calculator.View.screen.id).innerHTML = value;
            Calculator.Model.lastValue = '' + value;
        }else {
            document.getElementById(Calculator.View.screen.id).innerHTML += value;
            Calculator.Model.lastValue += value;
        }
        Calculator.Model.currentInput += value;
    },

    evaluateInput: function(){
        if(Calculator.Model.justEvaluated) {
            Calculator.Model.currentInput = Calculator.Model.lastResult + Calculator.Model.lastOperation + Calculator.Model.lastValue;
        }
        Calculator.Model.lastResult = eval(Calculator.Model.currentInput);
        document.getElementById(Calculator.View.screen.id).innerHTML = Calculator.Model.lastResult;
        Calculator.Model.justEvaluated = true;
        Calculator.Model.currentInput = '';
    },
    
    clearScreenOp: function(){
        document.getElementById(Calculator.View.screen.id).innerHTML = '';
        if (!Calculator.Model.wasRead) {
            Calculator.Model.currentInput = Calculator.Model.currentInput.substring(0, Calculator.Model.currentInput.length - Calculator.Model.lastValue.length);
            Calculator.Model.lastValue = '';
            Calculator.Model.justEvaluated = false;
        }
    },

    clearMemory: function(){
        Calculator.Model.currentInput = '';
        Calculator.Model.lastValue = '';
        Calculator.Model.lastOperation = '';
        Calculator.Model.lastResult = '';
        Calculator.Model.justEvaluated = false;
    },

    readMemory: function(){
        document.getElementById(Calculator.View.screen.id).innerHTML = Calculator.Model.currentInput;
        Calculator.Model.wasRead = true;
    },

    addToMemory: function(){
        Calculator.Model.currentInput += document.getElementById(Calculator.View.screen.id).innerHTML;
        Calculator.Model.justEvaluated = false;
    },

    subtractFromMemory: function(){
        Calculator.Model.currentInput.replace(document.getElementById(Calculator.View.screen.id).innerHTML, '');
        Calculator.Model.justEvaluated = false;
    }

};