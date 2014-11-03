# hello-world

This hello-world is a simple Ring-Compojure exploration of Routes and Map
Destructuring.

For the purpose of our Muzak project, we will need to know how to parse
GET Query strings, or otherwise receive function arguments from the client.

We can expect to need to parse things like "Genre = Pop" and "BPM > 160"

## Learning Compojure

The server receives the client's request as a clojure map. The Uri can be
matched against defined Compojure "Routes" to determine what the server should
reply with (i.e. google.com/photos serves up different content than
google.com/hangouts).

The simplest way to see the request map, is to define a compojure route as
follows:
```
(GET "/" request (str request))
```

This route example shows how to interpret part of the Client's request Uri as
a parameter (client URL might be "localhost:3000/user/22")
```
(GET "/user/:id" [id] (str "<h1>Hello user " id " </h1>"))
```

## Further Reading
Routes info...
https://github.com/weavejester/compojure/wiki/Routes-In-Detail

Destructuring Syntax:
https://github.com/weavejester/compojure/wiki/Destructuring-Syntax

Fancier Routes:
http://stackoverflow.com/questions/4089162/destructuring-forms-and-compojure


## Prerequisites

You will need lein installed (instructions needed)

## Running

To start a web server for the application, run (from the project folder):

    lein ring server-headless
or
    lein ring server

## License

Copyright © 2014 FIXME
