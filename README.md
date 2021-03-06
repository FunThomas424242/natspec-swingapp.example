natspec-swingapp.example
===================

Dies soll ein Beispielprojekt für angewandtes Lean Modeling von GUI Dialogen mittels NatSpec werden. 
Die hier benutzte Methode wird in
[Lean Modeling: mit natürlicher Sprache zum Model](http://www.bibsonomy.org/bibtex/220fe16bb76f4ef5d8c911c0c7a246a05/funthomas424242)
beschrieben.

NatSpec ist eine Modellierungssprache welche sich durch ihre Flexibilität selbst zur Modellierung 
von Domain Spezifischen Sprachen (DSLs) eignet. Der Umfang der jeweiligen Sprache ist dabei abhängig
von den implementierten Mappings natürlich sprachlicher Sätze auf Java Methoden. 


Projektstatus
-------------
[![Build Status](https://travis-ci.org/FunThomas424242/natspec-swingapp.example.png?branch=master)](https://travis-ci.org/FunThomas424242/natspec-swingapp.example)

Mit dem Beispielprojekt soll gezeigt werden, wie eine einfache Generierung von Swing Applikationen
erfolgen kann. Dabei soll entsprechend der Ideen von Lean Modelling mittels NatSpec je eine DSL
zur Beschreibung der GUI, der Businesslogik und der Entities realisiert werden. 

Idealerweise wird dabei vollständig auf eine separate Codegenerierungsphase verzichtet, da NatSpec 
on the fly die Spezifikation in entsprechende Factoryklassen übersetzt. 

Die entscheidende Herausforderung wird sein die 3 DSLs so sinnvoll zu verzahnen damit mit möglichst wenig 
manuellen Anpassungen eine Applikation entsteht. Die Hauptarbeit bei der Entwicklung soll auf dem 
Beschreiben der Applikation in den DSLs und der Implementierung der Mapping Klassen liegen.

Im [Beispielprojekt](https://github.com/DevBoost/JavaMagazin_Lean_Modeling_Example) der NatSpec 
Founder werden bereits sehr ansprechende Beispiele gezeigt. 

Architekturentscheidungen
-------------------------

Bei der Implementierung wurden folgende Entscheidungen bewusst getroffen:
* Die Abhängigkeiten wurden nicht wie üblich implemtiert: GUI->Business->Entity sondern es wurde sich dafür entschieden den Business Layer von
dem GUI und dem Entity Layer abhängig zu machen. Im Gegenzug dürfen GUI und Entity Layer keine Abhängigkeit in den Business Layer aufweisen.

Entsprechende Projektreports zur Überprüfung befinden sich auf den [gh-pages](http://funthomas424242.github.io/natspec-swingapp.example/jdepend-report.html).


