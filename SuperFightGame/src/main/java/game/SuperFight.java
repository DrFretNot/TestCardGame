//package game;

import java.util.*;
import java.io.*;
import java.util.Random;

public class SuperFight {
//to avoid confusion, I will refer to Characters in the game as gameCharacters to avoid confusion with java character

//**********************************************************************
//functions

public static String readCardsFromFile(String fileName, String toString) throws FileNotFoundException, IOException{
		Scanner readFile = new Scanner(new File(fileName));
		while(readFile.hasNextLine()){
			toString += readFile.nextLine();
		}
		readFile.close();
		return toString;
	}

//sends the String to a String[] and properly formats it
private static String[] addElementsToArray(String[] arrayName, String toString){
		arrayName = toString.split("(new)");
		for(int position = 0; position < arrayName.length; position++){
			arrayName[position] = arrayName[position].replace("(","");
			arrayName[position] = arrayName[position].replace(")","");
		}
		return arrayName;
	}


//**********************************************************************
public static void main(String[] args){
	
		Random ran = new Random();
		String CharacterCards = "";
		String AttributeCards = "";
		String[] GameAttributeArray= new String[385];
		String[] GameCharacterArray = new String[228];
		
	//read in AttributeCards.txt and 385 lines, each line is one item
		 try{
			AttributeCards = readCardsFromFile("AttributeCards.txt", AttributeCards);}
		catch(Exception e){
			System.out.println(e.getMessage());}
			
	//place items in GameAttributes String[]
		GameAttributeArray = addElementsToArray(GameAttributeArray, AttributeCards);
		/*for(int position = 0; position < GameAttributeArray.length; position++){
			System.out.println(GameAttributeArray[position]);
		}*/
		
	//read in CharacterCards.txt and 228 lines, each line is one item
		try{
			CharacterCards = readCardsFromFile("CharacterCards.txt", CharacterCards);}
		catch(Exception e){
			System.out.println(e.getMessage());}

	//place items in gameCharacters String[]
		GameCharacterArray = addElementsToArray(GameCharacterArray, CharacterCards);

		/*for(int position = 0; position < GameCharacterArray.length; position++){
			System.out.println(GameCharacterArray[position]);
		}*/

//builds a temp Game Array with 3 Characters, 1 space, 5 Attributes
		
	//picks 3 random, non-same items from GameCharacters 
		String[] tempGameArray = new String[9];
		for(int position = 0; position < 3; position++){
			int randomNumber = ran.nextInt(GameCharacterArray.length);
			tempGameArray[position] = GameCharacterArray[randomNumber];
			if(position == 1 ){
				while( tempGameArray[position] == tempGameArray[position-1]){
					randomNumber = ran.nextInt(GameCharacterArray.length);
					tempGameArray[position] = GameCharacterArray[randomNumber];
				}
			}
			else if(position == 2){
				while( tempGameArray[position] == tempGameArray[position-1] || tempGameArray[position] == tempGameArray[position-2]){
					randomNumber = ran.nextInt(GameCharacterArray.length);
					tempGameArray[position] = GameCharacterArray[randomNumber];
				}
			}
			
		}
	
	//adds Space to separate
		tempGameArray[3] = "  ";
		
	//picks 5 random, non-same items from GameAttributes
		for(int position = 4; position < 9; position++){
			int randomNumber = ran.nextInt(GameAttributeArray.length);
			tempGameArray[position] = GameAttributeArray[randomNumber];
			if(position == 5 ){
				while( tempGameArray[position] == tempGameArray[position-1]){
					randomNumber = ran.nextInt(GameAttributeArray.length);
					tempGameArray[position] = GameAttributeArray[randomNumber];
				}
			}
			else if(position == 6){
				while( tempGameArray[position] == tempGameArray[position-1] || tempGameArray[position] == tempGameArray[position-2]){
					randomNumber = ran.nextInt(GameAttributeArray.length);
					tempGameArray[position] = GameAttributeArray[randomNumber];
				}
			}
			if(position == 7 ){
				while( tempGameArray[position] == tempGameArray[position-1] || tempGameArray[position] == tempGameArray[position-2]
					 || tempGameArray[position] == tempGameArray[position-3]){
					randomNumber = ran.nextInt(GameAttributeArray.length);
					tempGameArray[position] = GameAttributeArray[randomNumber];
				}
			}
			else if(position == 8){
				while( tempGameArray[position] == tempGameArray[position-1] || tempGameArray[position] == tempGameArray[position-2]
					|| tempGameArray[position] == tempGameArray[position-3] || tempGameArray[position] == tempGameArray[position-4]){
					randomNumber = ran.nextInt(GameAttributeArray.length);
					tempGameArray[position] = GameAttributeArray[randomNumber];
				}
			}
		}
		
	//prints out the Game cards array	
		System.out.println("\n Your Character Cards are:\n");
		for(int position = 0; position < 3; position++){
			System.out.println(tempGameArray[position]);
		}
		System.out.println("\n Your Attribute Cards are:\n");
		for(int position = 4; position < 9; position++){
			System.out.println(tempGameArray[position]);
		}
			
	}


//**********************************************************************


}