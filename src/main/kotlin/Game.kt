//before the game starts, what do we need. one time initialization stuff goes in here. iterative should not
class Game(var players: MutableList<Player>){
    var imageCards = mutableListOf<String>("image1", "image2", "image3", "image4", "image5", "image6") //eventually pull these in from a file(from the internet)
    var sentenceCards = mutableListOf<String>("sentence1", "sentence2", "sentence3", "sentence4", "sentence5", "sentence6", "sentence7", "sentence8", "sentence9", "sentence10", "sentence11", "sentence12", "sentence13", "sentence14", "sentence15", "sentence16")
    //var mapOfPlayers: HashMap<String, Player> //{name: PlayerObj}
    var mapOfPlayers = players.associateBy{it.name} //takes listOfPlayers and makes it a map(it is a single object within the list) {name: PlayerObj}
    var winningPlayer = ""
    //when is game over?? -> game needs to know
    fun checkIfWinner(): Boolean{
        for(player in players){
            if(player.score == 2){
                winningPlayer = player.name
                return true
            }
        }
        return false
    }
    fun play(){
        //while one player hasn't hit 5 points, keep running rounds, initialize a brand new round each time
        while(!checkIfWinner()){ //top player doesn't have 5 points
            //select an image card for the round -> you can pass this to round, but this way is better
            println("ROUND")
            val selectedImageCard = imageCards.removeLast()
            //initialize a round
            val round = Round(selectedImageCard, sentenceCards, players)
            //round.setAllHostToFalse()
            round.findHost()
            round.dealOutCardsToPlayers()
            val submittedCards = round.playersSubmitACard() //[(PlayerObj, "sentence")]
            val winnerOfRound = round.hostPicksWinner(submittedCards) //(PlayerObj, "sentence")
            println("The winning card is ${winnerOfRound.second} from ${winnerOfRound.first.name}")
            //update the winning players score
            mapOfPlayers[winnerOfRound.first.name]!!.score++ //ASK ABOUT NULL //associateby creates a nullable map
            println(players)
            round.resetHost()

        }
        println("You have finished the game! ${winningPlayer} is the winner!")
        //can then return whoever won the game
    }

}

//better practice to send data into constructor instead of setting it later

//List<Players> -> Map<String(name), Player>
//winner -> Pair<Sentence, Name> -> map.get(player_name) = player object
//{ player.name }
//for (i = 0; i < list.length; i++ ) { it = list[i] }

