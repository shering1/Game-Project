

class Round(val imageCard: String, val sentenceCards: MutableList<String>, val players: MutableList<Player>) {
    var host = players[0] //initialize host at player[0], this will be reset

    //randomly assign a host
    fun findHost(){
        val idx = (0 until players.size - 1).random()
        println("the host is,  ${players[idx]}" )
        players[idx].isHost = true
        host = players[idx]
    }

    //assign the sentence cards to players -> we don't need to shuffle, they are already set in memory
    fun dealOutCardsToPlayers(){
        for(player in players){
            val cards = listOf(sentenceCards.removeLast())
            player.setPlayerCards(cards)
        }
    }

    //each player will submit a card, except the host
    fun playersSubmitACard(): MutableList<Pair<Player, String>>{
        var selectedCards = mutableListOf<Pair<Player, String>>() //array of pairs
        for(player in players){
            //take into account the host
            if(!player.isHost){
                val selectedIdx = player.selectCard()
                selectedCards.add(Pair(player, player.playersCards[selectedIdx])) //(PlayerObj, sentenceCard)
            }
        }
        println("Selected Cards -> $selectedCards")
        return selectedCards
    }

    fun hostPicksWinner(submittedCards: MutableList<Pair<Player, String>>): Pair<Player, String>{
        val winnerIdx = (0 until submittedCards.size-1).random()
        return submittedCards[winnerIdx]
    }


    fun resetHost(){
        host.isHost = false
    }



    //functions should be doing only one things

    //initialized means memory has been allocated for it


    //tell players to select a card
    //tell host to select a winning card
    //raise the score to the winning player
    //reset all hosts back to false for next round
}

//should be in round to iteratively go through and select a card to play for the round


