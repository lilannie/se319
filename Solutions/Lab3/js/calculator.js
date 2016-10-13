var Calc = {
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
        Calc.attachHandlers();
        return Calc.buildView();
    },

    buildView: function(){
        var v = "";
        v += '<div class="calc-body">';
        for (var r = 0; r < 7; r++){
            v += '<div class="calc-row">';
                for(element in Calc.View){
                    if(Calc.View.hasOwnProperty(element)
                        && Calc.View[element].hasOwnProperty('row')
                        && Calc.View[element].row == r) {
                        v += Calc.buildElement(Calc.View[element]);
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
        Calc.View.one.onclick = "Calc.input(Calc.View.one.value, true)";
        Calc.View.two.onclick = "Calc.input(Calc.View.two.value, true)";
        Calc.View.three.onclick = "Calc.input(Calc.View.three.value, true)";
        Calc.View.four.onclick = "Calc.input(Calc.View.four.value, true)";
        Calc.View.five.onclick = "Calc.input(Calc.View.five.value, true)";
        Calc.View.six.onclick = "Calc.input(Calc.View.six.value, true)";
        Calc.View.seven.onclick = "Calc.input(Calc.View.seven.value, true)";
        Calc.View.eight.onclick = "Calc.input(Calc.View.eight.value, true)";
        Calc.View.nine.onclick = "Calc.input(Calc.View.nine.value, true)";
        Calc.View.zero.onclick = "Calc.input(Calc.View.zero.value, true)";
        Calc.View.decimal.onclick = "Calc.input(Calc.View.decimal.value, true)";

        Calc.View.add.onclick = "Calc.input(Calc.View.add.value, false)";
        Calc.View.subtract.onclick = "Calc.input(Calc.View.subtract.value, false)";
        Calc.View.multiply.onclick = "Calc.input(Calc.View.multiply.value, false)";
        Calc.View.divide.onclick = "Calc.input(Calc.View.divide.value, false)";

        Calc.View.equal.onclick = "Calc.evaluateInput()";
        Calc.View.clearScreen.onclick = "Calc.clearScreenOp()";
        Calc.View.clearMem.onclick = "Calc.clearMemory()";
        Calc.View.readMem.onclick = "Calc.readMemory()";
        Calc.View.addToMem.onclick = "Calc.addToMemory()";
        Calc.View.subFromMem.onclick = "Calc.subtractFromMemory()";
    },

    input: function(value, isNum) {
        isNum = (typeof isNum !== 'undefined') ? isNum : false;
        if (!isNum) {
            document.getElementById(Calc.View.screen.id).innerHTML = '';
            Calc.Model.lastOperation = value;
            Calc.Model.lastValue = '';
        } else if(Calc.Model.justEvaluated){
            Calc.Model.justEvaluated = false;
            document.getElementById(Calc.View.screen.id).innerHTML = value;
            Calc.Model.lastValue = '' + value;
        }else {
            document.getElementById(Calc.View.screen.id).innerHTML += value;
            Calc.Model.lastValue += value;
        }
        Calc.Model.currentInput += value;
    },

    evaluateInput: function(){
        if(Calc.Model.justEvaluated) {
            Calc.Model.currentInput = Calc.Model.lastResult + Calc.Model.lastOperation + Calc.Model.lastValue;
        }
        Calc.Model.lastResult = eval(Calc.Model.currentInput);
        document.getElementById(Calc.View.screen.id).innerHTML = Calc.Model.lastResult;
        Calc.Model.justEvaluated = true;
        Calc.Model.currentInput = '';
    },

    clearScreenOp: function(){
        document.getElementById(Calc.View.screen.id).innerHTML = '';
        if (!Calc.Model.wasRead) {
            Calc.Model.currentInput = Calc.Model.currentInput.substring(0, Calc.Model.currentInput.length - Calc.Model.lastValue.length);
            Calc.Model.lastValue = '';
            Calc.Model.justEvaluated = false;
        }
    },

    clearMemory: function(){
        Calc.Model.currentInput = '';
        Calc.Model.lastValue = '';
        Calc.Model.lastOperation = '';
        Calc.Model.lastResult = '';
        Calc.Model.justEvaluated = false;
    },

    readMemory: function(){
        document.getElementById(Calc.View.screen.id).innerHTML = Calc.Model.currentInput;
        Calc.Model.wasRead = true;
    },

    addToMemory: function(){
        Calc.Model.currentInput += document.getElementById(Calc.View.screen.id).innerHTML;
        Calc.Model.justEvaluated = false;
    },

    subtractFromMemory: function(){
        Calc.Model.currentInput.replace(document.getElementById(Calc.View.screen.id).innerHTML, '');
        Calc.Model.justEvaluated = false;
    }

};