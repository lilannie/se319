angular.module('studyShare', []).controller('studyShareController',
    function StudyShareController($scope) {
        /**
         * Deck = {id, name, classes, descriptions, Cards[]}
         * @type {Array}
         */
        $scope.decks = [
            {
                id: 0,
                name: 'Example Name',
                classes: 'COM S 363',
                descriptions: 'Example Description',
                cards: [
                    {front: "Pretend front", back: "Pretend back"},
                    {front: "Pretend front", back: "Pretend back"}
                ]
            },
            {
                id: 1,
                name: 'Example Name',
                classes: 'COM S 363',
                descriptions: 'Example Description',
                cards: [{front: "Pretend front", back: "Pretend back"},
                    {front: "Pretend front", back: "Pretend back"}
                ]
            }
        ];

        /**
         * Card = {Front, Back}
         * @type {Array}
         */
        $scope.cards = [];

        $scope.deck_counter = 2;
        $scope.active_deck = null;
        $scope.card_error = false;

        $scope.init = function () {
            $scope.closeError();
        };

        $scope.closeDeckModal = function () {
            $scope.deck_name = "";
            $scope.deck_classes = "";
            $scope.deck_description = "";
        };

        $scope.saveDeckModal = function () {
            $scope.decks.push({
                id: $scope.deck_counter,
                name: $scope.deck_name != "" ? $scope.deck_name : "Default Name",
                classes: $scope.deck_classes != "" ? $scope.deck_classes : "Default Classes",
                description: $scope.deck_description != "" ? $scope.deck_description : "Default Description" ,
                cards: []
            });
            $scope.active_deck = $scope.deck_counter;
            $scope.closeDeckModal();
            $scope.deck_counter++;
        };

        $scope.closeCardModal = function () {
            $scope.card_front = "";
            $scope.card_back = "";
            $('#notecardModal').hide();
        };

        $scope.saveCardModal = function () {
            if ($scope.active_deck == null) {
                $("#form_error").show();
                console.log("null");
                return;
            }
            var deck = $scope.findDeck($scope.active_deck.id);
            deck.cards.push({
                front: $scope.card_front != "" ? $scope.card_front : "Default Card Front",
                back: $scope.card_back != "" ? $scope.card_back : "Default Card Back"
            });
            $scope.closeCardModal();
        };

        $scope.view = function(deck_id) {
            if ($scope.active_deck != null)
                $scope.active_deck.hide();
            $scope.active_deck =  $('#collapse'+deck_id);
            $scope.active_deck.show();
        };

        $scope.findDeck = function(deck_id) {
            var i = 0;
            while(i < $scope.decks.length) {
                if ($scope.decks[i].id == deck_id){
                    return $scope.decks[i];
                }
                i++;
            }
            return null;
        };

        $scope.closeError = function() {
            $('#form_error').hide();
        }
    });