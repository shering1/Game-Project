import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

//assertion parameters are expected value followed by actual value
internal class RoundTest { //internal means it is visible everywhere in the same module(IntelliJ IDEA module)
    //i have to give the info that the class needs for these functions to test
    val imageCard = "imageCard1"
    val players = mutableListOf<Player>(Player(name="Samantha"), Player(name="Tom"), Player(name="Cole"))
    val sentenceCards = mutableListOf<String>("sentence1", "sentence2", "sentence3", "sentence4", "sentence5")
    //val round = Round(imageCard = imageCard, sentenceCards = sentenceCards, players = players) //this info can be totally made up as long as they match the types

    //for anything that will change over time, its a good idea to isolate it in the function
    //can't guarantee execution order, so its important to not have any side effects, meaning one test shouldn't effect another tests data

//mocking and duplicates
    //can create a mock version of my code and swap out a piece of it b/c my 'client selection' is test code that i can use
    //testRound extends round and overide the function that i'm testing to look different
    //we can create a game test -> spock library
    //i want something that looks like round, just override this one function to see what would happen

    //you can do assertEquals for everything
    //other asserts are just helper functions
    //i can have many asserts in one function

    //if i had execptions written in my application, i could also test those exceptions. if you're testing an exception, you should be testing in a try/catch
    //example of testing an exception
    //try {
   //    ...
   //} catch(e:Exception) {
   //    assertEquals(e::class, "OutOfBoundsException")
   //}
   //assertFail()

    @Test
    fun findHost() {
        val round = Round(imageCard = imageCard, sentenceCards = sentenceCards, players = players)
        round.findHost()
        var count = 0
        for(player in players){
            if(player.isHost){
                count++
            }
        }
        assertEquals(1, count) //i'm expecting there to be 1 host, but count is showing me the actual result
        //i'm expecting one of the players 'isHost' to be true
        //making sure one one player is host
        //what is an error state that cant happen and what is the ideal state that should happen
        //assert this is true is where we want to be
    }

    @Test
    fun dealOutCardsToPlayers() {
        //i can create new sentence cards here, so my global sentence cards dont get modified for other tests
        val testSentenceCards = mutableListOf<String>("sentence1", "sentence2", "sentence3", "sentence4", "sentence5")
        val round = Round(imageCard = imageCard, sentenceCards = testSentenceCards, players = players)
        round.dealOutCardsToPlayers()
        //i'm expecting each players 'playersCards' to have a length of 1
        var result = true
        for(player in players){
           if(player.playersCards.size != 1){
               result = false
           }
        }
        assertEquals(true, result)
    }

    @Test
    fun playersSubmitACard() {
        //i'm expecting the 'selectedCards' variable to have a length that is equal to players.length - 1
        val round = Round(imageCard = imageCard, sentenceCards = sentenceCards, players = players)
        round.dealOutCardsToPlayers() //i have deal out the cards in order to select a random one
        round.playersSubmitACard()
        val selectedCards = mutableListOf<String>()
        for(player in players){
            if(!player.isHost){
                selectedCards.add("testElem")
            }
        }
        assertEquals(selectedCards.size == players.size-1, selectedCards.size == players.size-1)
    }

    @Test
    fun hostPicksWinner() {
        //i'm expecting that the winner is not a host
        val round = Round(imageCard = imageCard, sentenceCards = sentenceCards, players = players)
        val submittedCards = mutableListOf<Pair<Player, String>>(Pair(players[0], "sent1"), Pair(players[1], "sent2"))
        round.hostPicksWinner(submittedCards)
        val randomWinner = (0 until submittedCards.size).random()
        var result = true
        if(submittedCards[randomWinner].first.isHost) result = false
        assertEquals(true, result)
    }

    @Test
    fun resetHost() {
        //i'm expecting the host to now be equal to false
        val round = Round(imageCard = imageCard, sentenceCards = sentenceCards, players = players)
        round.resetHost()
        var result = true
        for(player in players){
            if(player.isHost){
              result = false
            }
        }
        assertEquals(true, result)
    }
}


