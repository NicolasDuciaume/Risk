  
# SYSC3110 Group project


To play the game, follow the following steps: 

-> In the current directory, open a terminal. 
-> Enter the following command:
	"java -jar game.jar"
-> Play the game through the GUI interface.


To view the code; follow the following steps:
-> unzip the Risk.zip folder. 
-> Add the "Risk" folder to the IDE and view the code.


# Contributors

- Hussain Al-Baidhani: hussainalbaidhani@cmail.carleton.ca
- Nicolas Duciaume: nicolasduciaume@cmail.carleton.ca
- Kamran Sagheir: kamransagheir@cmail.carleton.ca
- Christopher D'silva: chrisdsilva@cmail.carleton.ca

# Changes since previous Deliverable

- Added a method to save and load the game
- Added a method to import custom maps through json or xml


# Rest of the deliverables for Iteration 4:

The rest of the deliverables for this iteration are as follows:

- Source Code
- Executeable Jar file called, "game.jar"
- UML Diagram
- Sequence Diagram
- Documentation

# Known Issues: 

There is 2 known issues that effect the funcitonality of the Risk game. The Risk game is designed as per the rules specified by the document; "SYSC 3110 Project – RISK!".

- If the image does not load you have to add the specified directory of the image to the json or xml under "File".
    i.e. for the normal game it will be in testRisk.json seeing that it what is loaded for a default game 
- At the movement phase we were only able to add in the adjacent tiles and not the paths because of a lack of understanding of recursion in java thus will have to investigate this further

# Usage of Custom games

To play a custom game you must enter the file path of where the json or xml file is stored thus in my case the file is called
RiskMile4 thus the path entered would be /RiskMile4/AmongUs.json

# Possible issue:

For the json reading I added two external package: commons-io-2.8.0.jar and json-20201115.jar thus if any issue happens when loading
the game it might just be that you must manually add these two jar files to your dependencies
