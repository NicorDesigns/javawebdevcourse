# 3. Creating Multi-player Games with WebSockets

### Tomcat Code Examples:

[https://github.com/apache/tomcat/tree/9.0.x/webapps/examples/WEB-INF/classes/websocket](https://github.com/apache/tomcat/tree/9.0.x/webapps/examples/WEB-INF/classes/websocket)


### Games and IOT require heavy responsiveness:

(Think about a relevant example to a large online database of South African Charities or a smart road network or better yet a building such as a church)

The Wrox Multiplayer Game Example:

Tic-Tac-Toe or Noughts and Crosses uses Graphics and Style Sheets:
it also requires JQuery/Bootstrap

The game project in Eclipse:

[https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-websockets-finish/charity-game-site](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-websockets-finish/charity-game-site)

## Implementing the basic Tic-Tac-Toe Algorithm

We won't be developing an AI gaming engine that can play Tic-Tac-Toe. We will just create an algorithm for two human or non-human opponents that will play Tic Tac Toe against each other.

The core algorithm is contained in the TicTacToeGame class, which encapsulate the game-play and contains no WebSocket logic

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeGame.java](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeGame.java)

## Creating the Server End-point

The Java WebSocket code is contained in the:

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeServer.java](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeServer.java)

class, which acts as an gateway for two WebSocket sessions for the TicTacToe game above.

In this architectural design:

The inner class Move are always messages sent from the browser to the server.
The implementation of the abstract class Messages are always sent from the browser to the server.
WebSocket Messages are exchanged in text format, the Jackson Data Processor library serializes Message classes into outgoing messages and de-serialize incoming messages int Move classes.

*onMessage()* mean the player has made a move and  and it was sent to the server endpoint
The server endpoint registers the move with with the TicTacToeGame
The server endpoint notifies the opponent of the move by sending a WebSocket message to its session
If it is Game Over at this stage the server endpoint sends both players either a GameOverMessage or a GameIsDrawMessage and then closes both sessions.
If a connection is closed by one of the players - *onClose()* ensures that either the game is over or it was never started. If a user closed his connection whilst a game is in progress then he automatically loses the game.

## Writing the JavaScript Game Console

First you need a TicTacToeServlet for logging in and joining or starting a new game:

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeServlet.java](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/java/com/nicordesigns/TicTacToeServlet.java)

and of course the UI *list.jsp* to interact with the said Servlet 
[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/WEB-INF/jsp/view/ticTacToe/list.jsp](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/WEB-INF/jsp/view/ticTacToe/list.jsp)

This UI is where the User can enter his user-name for his session, the Servlet then adds the game to a list of pending games. 
Another player can then choose to join this game from a list of pending games. When the second Player Joins the pending game then the Servlet moves the status from pending to in-progress.


The actual game interface is in the *game.jsp*
[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/WEB-INF/jsp/view/ticTacToe/game.jsp](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/WEB-INF/jsp/view/ticTacToe/game.jsp)

we make use of a stylesheet here : *ticTacToe.css*

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/resource/stylesheet/ticTacToe.css](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-websockets-finish/charity-game-site/src/main/webapp/resource/stylesheet/ticTacToe.css)

We also use the JQuery JavaScript library and the Bootstrap Java Library:

		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>

as we see we access the libraries on the web and we do not download them and serve them locally. 

The whole game UI is contained in:

 *<div id="gameContainer">* with 3 rows and 3 columns, where clicking on a square commits the players move.
 
The embedded JavaScript function at the bottom of this page does the following.
Once the document is fully loaded it checks to see if WebSockets are supported by the current browser. 
Then it connects to the Server using a WebSocket.

We can also look at the logic of the following included JavaScript functions:

			window.onbeforeunload = function()
                
			server.onclose = function(event) 

            server.onerror = function(event) 

			server.onmessage = function(event) which shows as all the types of messages that can be sent.

			move = function(row, column) 
            


