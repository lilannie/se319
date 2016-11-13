angular.module('studyShare', []).controller('studyShareController',
    function StudyShareController($scope) {
        /**
         * Deck = {id, name, classes, descriptions, Cards[]}
         * @type {Array}
         */
        $scope.decks = [
            {
                id: 0,
                name: 'Software User Interfaces',
                classes: 'COM S 319, S E 319',
                descriptions: 'Course Terms',
                cards: [
                    {
                        front: "POST Request",
                        back: "POST is one of many request methods supported by " +
                        "the HTTP protocol used by the World Wide Web. " +
                        "By design, the POST request method requests that a " +
                        "web server accepts and stores the data enclosed in " +
                        "the body of the request message. It is often used when " +
                        "uploading a file or submitting a completed web form."
                    },
                    {
                        front: "GET Request",
                        back: "Can be cached. Remain in the browser history. " +
                        "Can be bookmarked. Should never be used when dealing " +
                        "with sensitive data. Have length restrictions. " +
                        "Should be used only to retrieve data"
                    }
                ]
            },
            {
                id: 1,
                name: 'Groceries for Beginners',
                classes: 'Children 101',
                descriptions: 'Terms of different Grocery items',
                cards: [
                    {
                        front: "Apples",
                        back: "The round fruit of a tree of " +
                        "the rose family, which typically has thin red or green " +
                        "skin and crisp flesh. "
                    },
                    {
                        front: "Cherries",
                        back: "A small, round stone fruit that is typically bright or dark red."
                    }
                ]
            },
            {
                id: 2,
                name: 'States and Capitols',
                classes: 'American Studies',
                descriptions: 'States on Front, Capitols on Back',
                cards: [
                    {
                        front: "Nebraska",
                        back: "Lincoln"
                    },
                    {
                        front: "Iowa",
                        back: "Des Moines"
                    }
                ]
            }
        ];

        /**
         * Card = {Front, Back}
         * @type {Array}
         */
        $scope.cards = [];

        $scope.deck_counter = 3;
        $scope.active_deck = null;
        $scope.card_error = false;

        $scope.init = function () {
            $scope.closeError();
            for (var i = 0; i < $scope.decks.length; i++) {
                $('#collapse' + $scope.decks[i].id).hide();
                $('.deck-button').hover(function () {
                    $(this).css("background-color", "#A1887F");
                });
            }
        };

        $scope.closeDeckModal = function () {
            $scope.deck_name = "";
            $scope.deck_classes = "";
            $scope.deck_description = "";
        };

        $scope.saveDeckModal = function () {
            $scope.active_deck = {
                id: $scope.deck_counter,
                name: $scope.deck_name != "" ? $scope.deck_name : "Default Name",
                classes: $scope.deck_classes != "" ? $scope.deck_classes : "Default Classes",
                description: $scope.deck_description != "" ? $scope.deck_description : "Default Description",
                cards: []
            };
            $scope.decks.push($scope.active_deck);
            $scope.deck_counter++;
            $('#deck-button' + $scope.active_deck.id).hover(function () {
                $(this).css("background-color", "#A1887F");
            });
            $scope.closeDeckModal();
        };

        $scope.openCardModal = function () {
            if ($scope.active_deck == null) {
                $("#form_error").show();
                console.log("null");
            }
        };

        $scope.closeCardModal = function () {
            $scope.card_front = "";
            $scope.card_back = "";
            $('#notecardModal').modal('hide');
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

        $scope.view = function (deck_id) {
            console.log("deck_id: " + deck_id);
            var collapseid = null;
            if ($scope.active_deck != null) {
                collapseid = $('#collapse' + $scope.active_deck.id);
                collapseid.hide();
            }
            $scope.active_deck = $scope.findDeck(deck_id);
            collapseid = $('#collapse' + $scope.active_deck.id);
            collapseid.show();
            console.log("active_deck: " + $scope.active_deck.id);
        };

        $scope.findDeck = function (deck_id) {
            var min_index = 0;
            var max_index = $scope.decks.length - 1; //$scope.decks instead of this
            var current_index;
            var current_deck;
            while (min_index <= max_index) {
                current_index = (min_index + max_index) / 2 | 0;
                console.log("current_index: " + current_index);
                current_deck = $scope.decks[current_index];
                if (current_deck.id < deck_id) { //current_deck.id instead of just current.deck
                    min_index = current_index + 1;
                } else if (current_deck.id > deck_id) { //current_deck.id instead of just current.deck
                    max_index = current_index - 1;
                } else {
                    return current_deck;
                }
            }
            return -1;
        };

        $scope.closeError = function () {
            $('#form_error').hide();
        };

        //creates a little card display on hover. Not really the best way to do it, but kind of fun.
        $scope.indicateCards = function (event, deck) {
            element = event.currentTarget;
            cards = deck.cards.length;
            cardList = document.createElement("div");
            cardList.className = 'deck-hover-wrapper';
            element.appendChild(cardList);
            var i = 0;
            var loop = function () {
                setTimeout(function () {
                    card = document.createElement('div');
                    card.className = 'deck-hover-display';
                    card.style.zIndex = cards - i;
                    card.style.backgroundColor = 'rgba(109,76,65,' + (0.6 - i * (0.6 / 5)) + ')';
                    card.style.width = (element.offsetWidth - i * 2) + 'px';
                    card.style.height = (30 - i * 2) + 'px';
                    cardList.appendChild(card);
                    i++;
                    if (i < 5) {
                        loop();
                    }
                }, 20);
            };
            loop();
        }

    });

function removeCardDisplay(element) {
    cards = element.childNodes[1];
    if (!cards) {
        return;
    }
    var i = cards.childNodes.length - 1;
    var loop = function () {
        setTimeout(function () {
            // cards = element.childNodes[1];
            cards.removeChild(cards.childNodes[i]);
            i--;
            if (i > 0) {
                loop();
            } else {
                element.removeChild(cards);
            }
        }, 20);
    };
    loop();
}
