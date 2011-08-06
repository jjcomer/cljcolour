(ns ^{:doc "Add some colour to your output"
      :author "Josh Comer <joshjcomer@gmail.com>"}
    cljcolour)

(def black {:fore "2;30" :back "22;40"})
(def red {:fore "2;31" :back "22;41"})
(def green {:fore "2;32" :back "22;42"})
(def yellow {:fore "2;33" :back "22;43"})
(def blue {:fore "2;34" :back "22;44"})
(def purple {:fore "2;35" :back "22;45"})
(def cyan {:fore "2;36" :back "22;46"})
(def lightgrey {:fore "2;37" :back "22;47"})
(def darkgrey {:fore "01;30" :back "1;40"})
(def boldred {:fore "01;31" :back "1;41"})
(def boldgreen {:fore "01;32" :back "1;42"})
(def boldyellow {:fore "01;33" :back "1;43"})
(def boldblue {:fore "01;34" :back "1;44"})
(def boldpurple {:fore "01;35" :back "1;45"})
(def boldcyan {:fore "01;36" :back "1;46"})
(def white {:fore "01;37" :back "1;47"})

(defn create-new-colour
	"Create a new colour from existing colours"
	[{foreground :fore} {background :back}]
	{:fore foreground :back background})

(defn add-foreground-colour
	"Add foreground colour to the string"
	[{foreground :fore} text]
	(str "\u001b[" foreground "m" text "\u001b[m"))

(defn add-background-colour
	"Add background colour to the string"
	[{background :back} text]
	(str "\u001b[" background "m" text "\u001b[m"))

(defn add-colour
	"Add foreground and background colours to a string"
	[{foreground :fore} {background :back} text]
	(str "\u001b[" background "m\u001b[" foreground "m" text "\u001b[m\u001b[m"))

(defn create-painter
	"Partially apply colours to the add-colour function"
	([foreground background]
	(partial add-colour foreground background))
	([custom-colour]
	(partial add-colour custom-colour custom-colour)))
