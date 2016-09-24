var testCard = {front: "Pretend front", back: "Pretend back"};
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
                cards: [testCard, testCard]
            },
            {
                id: 1,
                name: 'Example Name',
                classes: 'COM S 363',
                descriptions: 'Example Description',
                cards: [testCard, testCard]
            }
        ];

        /**
         * Card = {Front, Back}
         * @type {Array}
         */
        $scope.cards = [];

        $scope.deck_counter = 2;
        $scope.active_deck = null;

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
        };

        $scope.saveCardModal = function () {
            $scope.cards.push({
                front: $scope.card_front != "" ? $scope.card_front : "Default Card Front",
                back: $scope.card_back != "" ? $scope.card_back : "Default Card Back"
            });
            $scope.closeCardModal();
        }
    });