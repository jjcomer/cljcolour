(ns ^{:doc "Add some colour to your output"
      :author "Josh Comer <joshjcomer@gmail.com>"}
    cljcolour)

(def black {:fore "02;30" :back "02;40"})
(def red {:fore "02;31" :back "02;41"})
(def green {:fore "02;32" :back "02;42"})
(def yellow {:fore "02;33" :back "02;43"})
(def blue {:fore "02;34" :back "02;44"})
(def purple {:fore "02;35" :back "02;45"})
(def cyan {:fore "02;36" :back "02;46"})
(def lightgrey {:fore "02;37" :back "02;47"})
(def darkgrey {:fore "01;30" :back "01;40"})
(def boldred {:fore "01;31" :back "01;41"})
(def boldgreen {:fore "01;32" :back "01;42"})
(def boldyellow {:fore "01;33" :back "01;43"})
(def boldblue {:fore "01;34" :back "01;44"})
(def boldpurple {:fore "01;35" :back "01;45"})
(def boldcyan {:fore "01;36" :back "01;46"})
(def white {:fore "01;37" :back "01;47"})

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
	(str "\u001b[" background ";" foreground "m" text "\u001b[m"))

(defn create-painter
	"Partially apply colours to the add-colour function"
	([foreground background]
	(partial add-colour foreground background))
	([custom-colour]
	(partial add-colour custom-colour custom-colour)))
