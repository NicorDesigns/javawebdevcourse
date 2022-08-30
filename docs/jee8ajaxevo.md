# 1. Evolution from Ajax to WebSockets

## Intro
Jakarta WebSocket Documentation
https://jakarta.ee/specifications/websocket/

Jakarta JEE8 Websocket documentation

https://jakarta.ee/specifications/websocket/1.1/

This looks empty: https://jakarta.ee/specifications/websocket/1.1/  

(Reach out to the Eclipse Foundation and Update it)

therefore we will be looking at :

https://jakarta.ee/specifications/websocket/2.0/websocket-spec-2.0.html

documentation as guidance

Maven Co-ordinates:
https://search.maven.org/artifact/jakarta.websocket/jakarta.websocket-api/1.1.2/jar

https://search.maven.org/artifact/jakarta.websocket/jakarta.websocket-client-api/1.1.2/jar


AJAX -  Asynchronous JavaScript and XML alows async coms with a server using JavaScript.
XML is part of the name but JSON are more commonly used. 
This allows parts of a web page to communicate with the back end and update  without the whole page needing to refresh.
The original example is Google Maps that got the uphand over the old MapQuest website by incorporating AJAX.

However we still have the stateless http protocol issue to contend with as in when the back-end data gets changed or updated the web page still won't know to GET the new fresh datasets. 
The same goes for the browser, if the data changes here the server does not know until it has been POSTed to the server

To resolve this problem we can

a) Check the back end server every second to see if there are updates and waste a tremendous amount of bandwith

b) We can update the back end data with the front end data every time the browser POST data back to the server, which means our data could be out of sync and we would still run into huge datasets that needs to be updated, it is also not quite compatible with the http async protocol and could cause intermittent problems

c) We could use the http1.1 Transfer-Encoding: chunked header together with JavaScript XMLhttprequest which are better than a) and b) but obviously more programming intense and error prone


## WebSockets to the rescue

Some history:

https://www.ietf.org/rfc/rfc2616.txt

Section 14.42 included the feature 

*HTTP/1.1 Upgrade*

Which when included in the Request Header allowed the client/browser to 'upgrade' or switch to a different protocol than HTTP. Which the Server response with 

*101 Switching protocols*

and the Upgrade Response to what protocol the Server supports

This is kind of a hole in the original stateless protocol design which allows switching out to something like a full state network TCP/IP stack of course this would have been to ludricous to even think about and this is how the WebSocket Protocol came to be.


WebSocket introduced the URI schemes *ws* and *wss* that runs on *http* and *https* ports and uses the 

https://www.rfc-editor.org/rfc/rfc6455

Upgrade:WebSocket

header

https://levelup.gitconnected.com/websockets-demystified-part-1-understanding-the-protocol-fccca2ca75eb  here I need to create my own diagram using the tool I used for the other diagram.

This allows for an open peer to peer connection between the client and server and for messages texts or binary to pass either way.

The Pros of WebSockets

1. It runs on http and https ports 80 and 443 so no firewall issues
2. It is already part of modern web browsers 
3. Heartbeat acks and nacks maintains connection
4. No Message encapsulation rules
5. A close connection message that contains the reason why
6. Allows for cross domain connections, because it is not a http protocol (Scary!)
7. Newer Protocols such as STOMP https://stomp.github.io/stomp-specification-1.2.html that enables IOT , Gaming and other types of "data firehoses" to connect to. For example a vehicle liscene plate reader lots of other application that require high connectivity and high throughput with data, ie Smart Grids etc 


Now describe the steps here from : 

https://levelup.gitconnected.com/websockets-demystified-part-1-understanding-the-protocol-fccca2ca75eb and match them up with the book.

