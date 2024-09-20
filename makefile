all: Main.java User.java Product.java Inventory.java Game.java Customer.java Cart.java Admin.java Utility.java Serialization.java 
	javac Main.java User.java Product.java Inventory.java Game.java Customer.java Cart.java Admin.java Utility.java Serialization.java 

run: all
	java Main

clean:
	rm *.class
	rm *.ser
