FlAGS = -g 
COMPIL= javac
EXECUTE = java -cp "mariadb-client.jar:."


.SUFFIXES: .java .class

.java.class:
	$(COMPIL) $(FLAGS) $*.java


CLASS = \
	Action.java\
	ActionText.java\
	AllCarton.java\
	BoutListen.java \
	CarreRond.java \
	Cartons.java \
	Fenetre.java \
	Change.java\
	ChangeCarton.java\
	Control.java\
	Desc.java\
	Fenetre.java\
	Img.java\
	Inventaire.java\
	JCheck.java\
	Labb.java\
	Listen.java\
	Menu.java\
	Meuble.java\
	Model.java\
	Mouse.java\
	Mousse.java\
	Mousse.java\
	Moussse.java\
	Move.java\
	Movve.java\
	Movvve.java\
	NewCarton.java\
	NewNewCarton.java\
	NewMeuble.java\
	NewPanMeuble.java\
	ObCarton.java\
	PanMeuble.java\
	Slide.java\
	Surbrillance.java\

default: class

class: $(CLASS:.java=.class)

test:
	$(EXECUTE) Control

clean:
	$(RM) *.class