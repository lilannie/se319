var BinCalc = {
    Model: {
        currentInput: "",
        lastOperation: "",
        lastValue: "",
        lastResult: "",
        justEvaluated: false,
        wasRead: false
    },

    View: {
        screen: {id: "binary-screen", tag: "div", value: "", row: 0, onclick: ""},

        one: {id: "binary-one", tag: "button", value: 1, row: 1, onclick: ""},
        zero: {id: "binary-zero", tag: "button", value: 0, row: 1, onclick: ""},
        not: {id: "binary-not", tag: "button", value: "~", row: 1, onclick: ""},

        add: {id: "binary-add", tag: "button", value: "+", row: 2, onclick: ""},
        mod: {id: "binary-mod\" disabled=\"disabled", tag: "button", value: "%", row: 2, onclick: ""},
        shiftLeft: {id: "binary-shiftLeft", tag: "button", value: "<<", row: 2, onclick: ""},

        shiftRight: {id: "binary-shiftRight", tag: "button", value: ">>", row: 3, onclick: ""},
        subtract: {id: "binary-substract", tag: "button", value: "-", row: 3, onclick: ""},
        and: {id: "binary-and", tag: "button", value: "&", row: 3, onclick: ""},

        or: {id: "binary-or", tag: "button", value: "|", row: 4, onclick: ""},
        multiply: {id: "binary-multiply", tag: "button", value: "*", row: 4, onclick: ""},
        divide: {id: "binary-divide", tag: "button", value: "/", row: 4, onclick: ""},

        readMem: {id: "binary-readMem", tag: "button", value: "MR", row: 5, onclick: ""},
        subFromMem: {id: "binary-subFromMem", tag: "button", value: "M-", row: 5, onclick: ""},
        addToMem: {id: "binary-addToMem", tag: "button", value: "M+", row: 5, onclick: ""},

        clearScreen: {id: "binary-clearScreen", tag: "button", value: "C", row: 6, onclick: ""},
        clearMem: {id: "binary-clearMem", tag: "button", value: "MC", row: 6},
        equal: {id: "binary-equal", tag: "button", value: "=", row: 6, onclick: ""}
    },

    Controller: {

    },

    run: function(){
        BinCalc.attachHandlers();
        return BinCalc.buildView();
    },

    buildView: function(){
        var v = "";
        v += '<div class="calc-body">';
        for (var r = 0; r < 7; r++){
            v += '<div class="calc-row">';
            for(element in BinCalc.View){
                if(BinCalc.View.hasOwnProperty(element)
                    && BinCalc.View[element].hasOwnProperty('row')
                    && BinCalc.View[element].row == r) {
                    v += BinCalc.buildElement(BinCalc.View[element]);
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
        BinCalc.View.one.onclick = "BinCalc.input(BinCalc.View.one.value, true)";
        BinCalc.View.zero.onclick = "BinCalc.input(BinCalc.View.zero.value, true)";

        BinCalc.View.not.onclick = "BinCalc.input(BinCalc.View.not.value, false)";
        BinCalc.View.add.onclick = "BinCalc.input(BinCalc.View.add.value, false)";
        BinCalc.View.mod.onclick = "BinCalc.input(BinCalc.View.mod.value, false)";
        BinCalc.View.shiftLeft.onclick = "BinCalc.input(BinCalc.View.shiftLeft.value, false)";
        BinCalc.View.shiftRight.onclick = "BinCalc.input(BinCalc.View.shiftRight.value, false)";
        BinCalc.View.subtract.onclick = "BinCalc.input(BinCalc.View.subtract.value, false)";
        BinCalc.View.and.onclick = "BinCalc.input(BinCalc.View.and.value, false)";
        BinCalc.View.or.onclick = "BinCalc.input(BinCalc.View.or.value, false)";
        BinCalc.View.multiply.onclick = "BinCalc.input(BinCalc.View.multiply.value, false)";
        BinCalc.View.divide.onclick = "BinCalc.input(BinCalc.View.divide.value, false)";

        BinCalc.View.equal.onclick = "BinCalc.evaluateInput()";
        BinCalc.View.clearScreen.onclick = "BinCalc.clearScreenOp()";
        BinCalc.View.clearMem.onclick = "BinCalc.clearMemory()";
        BinCalc.View.readMem.onclick = "BinCalc.readMemory()";
        BinCalc.View.addToMem.onclick = "BinCalc.addToMemory()";
        BinCalc.View.subFromMem.onclick = "BinCalc.subtractFromMemory()";
    },

    input: function(value, isNum) {
        isNum = (typeof isNum !== 'undefined') ? isNum : false;
        if (!isNum) {
            document.getElementById(BinCalc.View.screen.id).innerHTML = '';
            BinCalc.Model.lastOperation = value;
            BinCalc.Model.lastValue = '';
        } else if(BinCalc.Model.justEvaluated){
            BinCalc.Model.justEvaluated = false;
            document.getElementById(BinCalc.View.screen.id).innerHTML = value;
            BinCalc.Model.lastValue = '' + value;
        }else {
            document.getElementById(BinCalc.View.screen.id).innerHTML += value;
            BinCalc.Model.lastValue += value;
        }
        BinCalc.Model.currentInput += value;
    },

    evaluateInput: function(){
        //TODO: Binary Evaluation
        if(BinCalc.Model.justEvaluated) {
            BinCalc.Model.currentInput = BinCalc.Model.lastResult + BinCalc.Model.lastOperation + BinCalc.Model.lastValue;
        }
        BinCalc.Model.lastResult = eval(BinCalc.Model.currentInput);
        document.getElementById(BinCalc.View.screen.id).innerHTML = BinCalc.Model.lastResult;
        BinCalc.Model.justEvaluated = true;
        BinCalc.Model.currentInput = '';
    },

    clearScreenOp: function(){
        document.getElementById(BinCalc.View.screen.id).innerHTML = '';
        if (!BinCalc.Model.wasRead) {
            BinCalc.Model.currentInput = BinCalc.Model.currentInput.substring(0, BinCalc.Model.currentInput.length - BinCalc.Model.lastValue.length);
            BinCalc.Model.lastValue = '';
            BinCalc.Model.justEvaluated = false;
        }
    },

    clearMemory: function(){
        BinCalc.Model.currentInput = '';
        BinCalc.Model.lastValue = '';
        BinCalc.Model.lastOperation = '';
        BinCalc.Model.lastResult = '';
        BinCalc.Model.justEvaluated = false;
    },

    readMemory: function(){
        document.getElementById(BinCalc.View.screen.id).innerHTML = BinCalc.Model.currentInput;
        BinCalc.Model.wasRead = true;
    },

    addToMemory: function(){
        BinCalc.Model.currentInput += document.getElementById(BinCalc.View.screen.id).innerHTML;
        BinCalc.Model.justEvaluated = false;
    },

    subtractFromMemory: function(){
        BinCalc.Model.currentInput.replace(document.getElementById(BinCalc.View.screen.id).innerHTML, '');
        BinCalc.Model.justEvaluated = false;
    }


};