data class Player(val name: String, var score: Int = 0) { //we don't put players cards here, we wouldn't deal out cards before initializing a player. same with host
    var playersCards: List<String> = listOf()
    var isHost: Boolean = false

    fun setPlayerCards(dealtCards: List<String>){//take a list of cards 7 cards to assign to the player
        playersCards = dealtCards
    }
    fun selectCard(): Int{
        var randomIdx = (0 until playersCards.size).random()
        return randomIdx
    }

}




















//each player will have a name and an initial score of 0


//doesnt need to be a data class because we are going to do be doing things with player
//a card class would be a data class because it is just a container of data that are getting passed around by real classes that are taking real actions


//fun setHost(areYouHost: Boolean){
//        isHost = areYouHost
//
//    }

