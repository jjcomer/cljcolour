# cljcolour

A simple Clojure library to add some colour to your terminal output.

I have only tested this on a mac, so I have no idea if it works in windows :)
I have also noticed that the lein repl will only allow one colour (either fore or background) to be applied at once. Both colour application work when acutally running the scripts.

## Usage
The easiest usage is to create painters for your text
```clojure
    (def yellow-blue (create-painter yellow blue))
    (yellow-blue "Hello World")
```

The following colours are avaliable:
* black
* red
* green
* yellow
* blue
* purple
* cyan
* lightgrey
* darkgrey
* boldred
* boldgreen
* boldyellow
* boldblue
* boldpurple
* boldcyan
* white

## License

Copyright (C) 2011 Josh Comer

Distributed under the Eclipse Public License, the same as Clojure.
