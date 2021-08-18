//sample class for writing tests
class Sample{
    fun sum(num1:Int, num2:Int): Int{
        return num1 + num2
    }
}


//chose a random index to make the host

//these should belong to a seperate class
//fun findingHost(newGame: Game){
//    val idx = (0 until newGame.players.size - 1).random()
//    newGame.players[idx].isHost = true
//}

//shuffle function -> don't need to do this anymore
//fun shuffleCards(newGame: Game, cards: String){
//    when(cards){
//        "imageCards" -> newGame.imageCards = newGame.imageCards.shuffled().toMutableList()
//        "sentenceCards" -> newGame.sentenceCards = newGame.sentenceCards.shuffled().toMutableList()
//    }
//}



/*THESE WERE THE ORIGINAL FUNCTIONS, BUT I HAVE NOW OPTIMIZED THEM IN THE ROUND CLASS*/
//set all hosts to false (try: foreach with lambda)
//fun setAllHostToFalse(){//reset host at the end of the round -> change just the host to save on runtimeO(1) not O(n)
//this works as well
//        for(player in players){
//            player.isHost = false
//        }

//players.forEach{it.isHost = false}
//}
//each player will submit a card, except the host
//storing selected cards in a hash map is doing more than we have to, just create an array of pairs. i'm not using the hashmap for O(1) lookup so it doesn't
//really make sense to use it. if i have an array i could just pick an idx to win
//fun playersSubmitACard(): HashMap<String, String>{
//    //if you dont initialize the map, it would break
//    //var selectedCards: HashMap<String, String> //this just says the map exists, we don't want to use this
//    val selectedCards = HashMap<String, String>() //this is initialized as an empty hash map and it has a space in memory for it
//    for(player in players){
//        //take into account the host
//        if(!player.isHost){
//            val idxOfCard = player.selectCard()
//            selectedCards.put( player.playersCards[idxOfCard], player.name,) //{"sentence" : "name"}
//        }
//    }
//    println("players submitted cards $selectedCards")
//    return selectedCards //{sentence1: Samantha, sentence2: Name}
//}
//
//fun hostPicksWinner(submittedCards: HashMap<String, String>): Pair<String, String>?{ //i'm going to be returning two things so i'll use a pair
//    //returning a pair - set of a key and val of map
//    //func should only be picking winner, don't update score here
//    //randomly select a winner from the map
//    val winner = (1..submittedCards.size).random()
//    var count = 1
//    var result: Pair<String, String>? = null //don't want to initialize placeholder, because they may return
//    for((key, value) in submittedCards){
//        if(winner == count){
//            result = Pair(key, value)
//            break
//        }
//        count++
//    }
//    return result //if we didn't break, we could just return in the conditional and then return null here, it would be the same thing
//    //return Pair("Necessary", "Return")
//    //have the option to put an exception here -> it would stop my software though
//    //return null //best practice is to return null if you know your code will return elsewhere.. if you hit null you know your func didn't do what it was supposed to. Error handling
//}