var BinaryCalculator = {
    Model: {

    },

    View: {
        screen: {id: "binary-screen", tag: "div", value: "", row: 0, onclick: ""},

        one: {id: "binary-one", tag: "button", value: 1, row: 1, onclick: ""},
        zero: {id: "binary-zero", tag: "button", value: 0, row: 1, onclick: ""},
        not: {id: "binary-not", tag: "button", value: "~", row: 1, onclick: ""},

        add: {id: "binary-add", tag: "button", value: "+", row: 2, onclick: ""},
        mod: {id: "binary-mod", tag: "button", value: "%", row: 2, onclick: ""},
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
        BinaryCalculator.attachHandlers();
        return BinaryCalculator.buildView();
    },

    buildView: function(){
        var v = "";
        v += '<div class="calc-body">';
        for (var r = 0; r < 7; r++){
            v += '<div class="calc-row">';
            for(element in BinaryCalculator.View){
                if(BinaryCalculator.View.hasOwnProperty(element)
                    && BinaryCalculator.View[element].hasOwnProperty('row')
                    && BinaryCalculator.View[element].row == r) {
                    v += BinaryCalculator.buildElement(BinaryCalculator.View[element]);
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

    }


};