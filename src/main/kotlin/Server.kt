//the way that i'm interacting
//all of Object oriented stuff should be comletly isolated from the api stuff

fun main(){//will handle the interactions between the humans and the game
    /***NEW GAME***/
    //create new players - you don't want to start a game with zero players
    val players = mutableListOf(Player(name = "Samantha"), Player(name = "Tom"), Player(name = "Cole"))

    //create a new instance of a Game with those players
    val newGame = Game(players) //should take in a list of players

    /***START GAME***/
    newGame.play()



//Next Steps:
//in the main function, have it take in args, list of names which are strings and then create the objects from there





























//    //creating a host
//    findingHost(newGame)
//
//    //shuffle the image and sentence cards
//    shuffleCards(newGame, "imageCards")
//    shuffleCards(newGame, "sentenceCards")
//
//    //set the currentImage card
//    newGame.currentImage = newGame.imageCards.removeLast()
//
//    //deal out the sentence cards -> 2 per player
//    var count = 0
//    while(count < newGame.players.size){
//        val card1 = newGame.sentenceCards.removeLast()
//        val card2 = newGame.sentenceCards.removeLast()
//        if(!newGame.players[count].isHost){ //we're not dealing cards out to the host
//            newGame.players[count].setPlayerCards(card1, card2)
//        }
//
//        count++
//    }
//
//    println(newGame.players)
//
//
//    println("Hello")
}

//my game...
/*
There will be 4 players->this should be a class, each player will have 7 sentence cards and a beginning score of 0.
The game will have one image card where each place needs to select a sentence card to submit
EAch round will have a host, that will select the winning card
If your card is the one selected, then that player gets a point
The first player to 5 points wins the game


Rounds.. -> this should be a class
The start of everyround should select the host -> reset everyones host to false then reselect
Each round consists of one image card and a 7 sentence cards for each player
After a winner is selected for a round, a new round starts with one new image card and 7 new cards for each player
*
* round -> this will happen n number of times
- select host
- shuffle cards
- deal image card for the round
- deal cards to players for the round
- tells the judge to pick a winner
- a winner is selected and points are awarded accordingly
*
* how does a game know when to start a new round?
* */


/*
First Notes...
what type of classes do we need...
- Game class
    - list of all the players []
    - host
    - selected cards all
    - image cards all
    - current image


- Player class
    - name
    - sentenceCards [7]
    - score

*
*
*
* */
