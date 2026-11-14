import javax.swing.JOptionPane;

public class BahayNiKuyaV3 {

    static boolean gameEnded = false;

    //Inventory array elememts count and passkey variable
    static String[] inventory = new String[10];
    static int inventoryCount = 0;

    //confession room key lock
    static boolean hasKey = false;
    //garden area key lock
    static boolean hasGardenKey = false;
    // girls bedroom key lock
    static boolean hasGirlsBedroomKey = false;
    // boys bedroom key lock
    static boolean hasBoysBedroomKey = false;

    //passcode digit in the dining area
    static boolean foundDiningDigit = false;
    static String diningDigit = "Seven empty can";

    //confession room discoveries
    static boolean foundConfessionRiddle = false;
    static boolean foundPasscodeHint = false;

    //confession area passcode
    static String clockDigit = "Look at the Clock! The Clock stopped at NINE!";

    // garden statue riddle
    static boolean foundStatueRiddle = false;
    
    //garden area hidden room
    static boolean foundHiddenRoom = false; 

    // girls bedroom discoveries
    static boolean foundMirrorRiddle = false;
    static boolean foundBedPasscode = false;

    // Boys Bedroom discoveries
    static boolean foundNotebookRiddle = false;
    static boolean foundBookshelfPasscode = false;



    //notedbook ni kuya //boys bedroom //desk
    static boolean hasNotebook = false;

    //four digit passcode
    static String correctPasscode = "7943";







    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "BAHAY NI KUYA: MURDER MYSTERY\n\n" + "Kuya has been murdered. His body is missing.\n" + "Explore the house, find clues, and discover the truth.");

        //menu method, ara nadi tanan nga method nga gin ubra   
        gameMenu(null);




    }




    //living room menu method
    public static void getLivingRoom(String gameMenu) {

    String living = "";
    boolean menu = true;

    while (menu) {

        living = JOptionPane.showInputDialog(
            "LIVING ROOM\n\n" +
            "1. Sofa Area\n" +
            "2. Dining Area\n" +
            "3. Elevator Area\n" +
            "4. Back\n\n" +
            "Enter Choice:"
        );

        if (living == null) {
            return;
        }

        switch (living) {

            case "1":
                JOptionPane.showMessageDialog(null, "You are exploring the Sofa Area!");
                getSofaArea();
                break;

            case "2":
                JOptionPane.showMessageDialog(null, "You are exploring the Dining Area!");
                getDiningArea();
                break;

            case "3":
                JOptionPane.showMessageDialog(null, "You are exploring the Elevator Area!");
                getElevatorArea();
                break;

            case "4":
                menu = false;
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice!");
                break;
        }
    }
}


        //sofa area method for hidden key 

public static void getSofaArea() {

    String[] livingSofa = {
        "Pillow",
        "Rug",
        "Blanket",
        "Sofa"
    };

    boolean menu = true;

    while (menu) {

    String objects = "";

    for (int i = 0; i < livingSofa.length; i++) {objects += (i + 1) + ". " + livingSofa[i] + "\n";}

    objects += "5. Back";

    String choice = JOptionPane.showInputDialog("SOFA AREA - INVESTIGATION\n\n" + "Choose an object to investigate:\n\n" + objects + "\n\nEnter your choice:");

    if (choice == null) {
    return;}
    
        switch (choice) {
            
            case "1":
               
                JOptionPane.showMessageDialog(null,"You investigated the Pillow.\n\n" + "Nothing unusual was found.");
                break;

           
            case "2":
                
                if (!hasKey) { JOptionPane.showMessageDialog(null, "You lifted the Rug...\n\n" + "You discovered a HIDDEN KEY!\n\n" + "This key can unlock the CONFESSION ROOM!");
                
                hasKey = true;
                
                addToInventory("Confession Room Key", "A small mysterious key discovered underneath the Living Room rug. It unlocks the Confession Room.", 0 );

                } else {
                    
                JOptionPane.showMessageDialog(null,"You lifted the Rug again...\n\n" + "There is nothing else underneath it.");
                } break;

            case "3":
                
                JOptionPane.showMessageDialog(null,"You investigated the Blanket.\n\n" + "It looks ordinary.");
                break;
                
            case "4":
                
                JOptionPane.showMessageDialog(null,"You investigated the Sofa.\n\n" + "You found nothing suspicious.");
                break;
                        
            case "5":
                            
                menu = false;
                break;
                         
            default: JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");
                break;
            
            }
        
        }
    
    }

//Dining area method with 1 of the 4 digit password
public static void getDiningArea() {

String[] livingDining = {"Dining Table", "Dining Chair", "Cabinet", "Wall Decoration"};

boolean menu = true;

while (menu) {

String objects = "";

for (int i = 0; i < livingDining.length; i++) { objects += (i + 1) + ". " + livingDining[i] + "\n";}

objects += "5. Back";

String choice = JOptionPane.showInputDialog( "DINING AREA - INVESTIGATION\n\n" + "Choose an object to investigate:\n\n" + objects + "\nEnter your choice:");

if (choice == null) {
return;
}

switch (choice) {
    
    case "1":
        JOptionPane.showMessageDialog(null,"You investigated the Dining Table.\n\n" + "You found nothing unusual.");
        break;
                                
    case "2":
                                
        JOptionPane.showMessageDialog(null,"You investigated the Dining Chair.\n\n" + "It looks completely ordinary.");
        break;
                                
    case "3":
                                
        if (!foundDiningDigit) {
                                    
        JOptionPane.showMessageDialog(null,"You searched the Cabinet...\n\n" + "You have found!\n" + diningDigit); 
        foundDiningDigit = true;

        addToInventory(diningDigit, "A mysterious object found inside the Dining Area Cabinet. This is added to your Inventory",0);
    } else {
                                
        JOptionPane.showMessageDialog(null,"You searched the Cabinet again.\n\n" + "You already collected the password clue.");
    }  break;
                             
    case "4":
                                
        JOptionPane.showMessageDialog(null, "You investigated the Wall Decoration.\n\n" + "Nothing suspicious was found.");
        break;
                                
    case "5":
                                
    menu = false;
    break;
                                
    default:
                                    
        JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");
        break;
        } 
    }
}



public static void getElevatorArea() {

String[] livingElevator = {"Floor Indication","Elevator buttons","Elevator Door"};

boolean menu = true;

while (menu) {
    String objects = "";
    
    for (int i = 0; i < livingElevator.length; i++) {objects += (i + 1) + ". " + livingElevator[i] + "\n";}
    objects += "4. Back";
    
String choice = JOptionPane.showInputDialog("ELEVATOR AREA - INVESTIGATION\n\n" +"Choose an object to investigate:\n\n" + objects + "\nEnter your choice:");

if (choice == null) {
return;}

switch (choice){
    
    case "1":
        
        JOptionPane.showMessageDialog(null,"You investigated the Floor Indication.\n\n" + "The display shows the current floor number.");
        break;
        
    case "2":

        JOptionPane.showMessageDialog(null,"You investigated the Elevator buttons.\n\n" + "All buttons appear to be functioning normally.");
        break;
                                        
    case "3":
        
        JOptionPane.showMessageDialog(null,"You investigated the Elevator Door.\n\n" + "The doors are tightly closed. Nothing unusual was found.");
        break;
                                        
    case "4":
                                            
    menu = false;
    break;
                                        
    default:
        
    JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");
    break;

        }
    }
                        
}


//method for the confession area with riddle to get the key for garden area and passcode for the hidden room
public static void getConfessionArea(){

String[] confessionObjects = {"Broken Wall Clock","Confession Chair","Microphone","Camera","Side Cabinet","Wall Panels"};

boolean menu = true;

while (menu){

String objects = "";

for (int i = 0; i < confessionObjects.length; i++) {objects += (i + 1) + ". " + confessionObjects[i] + "\n";}

objects += "7. Back";

String choice = JOptionPane.showInputDialog("CONFESSION ROOM - INVESTIGATION\n\n" + "Choose an object to investigate:\n\n" + objects + "\nEnter your choice:");

if (choice == null) {
return;}

switch (choice){

    case "1":
        
        if (!foundConfessionRiddle) {
            
            JOptionPane.showMessageDialog(null,"You examined the Broken Wall Clock.\n\n" + "A mysterious riddle is written behind it:\n\n" + "RIDDLE:\n\n" + "I have hands but cannot clap.\n" + "I have a face but cannot smile.\n" + "What am I?");
            
            String answer = JOptionPane.showInputDialog("Enter your answer:");
            
            if (answer == null) {
                break;}
                
            if (answer.equalsIgnoreCase("clock")) {
                
            JOptionPane.showMessageDialog(null,"CORRECT!\n\n" + "You solved the riddle!\n" + "The clock may be connected to the murder.");
            
            addToInventory("Garden Key","A small compartment opens beneath the clock.\n" + "It unlocks the Garden.",0);

            hasGardenKey = true;
            foundConfessionRiddle = true;
        
        } else {
            
            JOptionPane.showMessageDialog(null,"WRONG ANSWER!\n\n" + "The riddle remains unsolved.");}

        } else {

            JOptionPane.showMessageDialog(null,"You examined the Broken Wall Clock again.\n\n" + "You have already solved its riddle.");
        }   break;

        case "2":
            
            JOptionPane.showMessageDialog(null,"You investigated the Confession Chair.\n\n" + "The chair has scratches on its armrests.\n" + "It looks like someone was tied to it.");
            break;
            
        case "3":
            
            JOptionPane.showMessageDialog(null,"You examined the Microphone.\n\n" + "You heard a faint recording:\n\n" + "\"I didn't mean to hurt him...\"\n\n" + "Someone made a confession here!");
            break;
            
        case "4":
            
            JOptionPane.showMessageDialog(null,"You examined the Camera.\n\n" + "The camera is still recording.\n" + "However, the footage has been deleted.");
            break;
        
        case "5":
            
            JOptionPane.showMessageDialog(null,"You searched the Side Cabinet.\n\n" + "You discovered an old confession document.\n" + "Most of its contents are unreadable.");
            break;

        case "6":

        if (!foundPasscodeHint) {

            JOptionPane.showMessageDialog(null,"You carefully examined the Wall Panels...\n\n" + "One panel feels loose.\n\n" + "Behind it, you discovered a hidden note!\n\n" + clockDigit);

            addToInventory("Clocks time","The broken clock stopped at NINE.",0);
            
            foundPasscodeHint = true;
        
        } else {
            
            JOptionPane.showMessageDialog(null, "You checked the Wall Panels again.\n\n" + "You already collected the password clue");}
            break;
            
        case "7":
            
        menu = false;
        break;

        default:

            JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");
            break;
        }
    }
}

//method for the garden area riddle and hidden room
public static void getGardenArea(){

String[] gardenObjects = {"Flower Bed","Garden Bench","Bird Bath","Watering Can","Garden Lamp","Garden Statue","Artificial Grass Floor"};

boolean menu = true;

while (menu && !gameEnded){

String objects = "";

for (int i = 0; i < gardenObjects.length; i++) {objects += (i + 1) + ". " + gardenObjects[i] + "\n";}

objects += "8. Back";

String choice = JOptionPane.showInputDialog("GARDEN AREA - INVESTIGATION\n\n" +"Choose an object to investigate:\n\n" +objects + "\nEnter your choice:");

if (choice == null) {
return;}

switch (choice){

    case "1":
        
        JOptionPane.showMessageDialog(null,"You investigated the Flower Bed.\n\n" + "The flowers look freshly watered.\n" + "Nothing unusual was found.");
        break;

    case "2":
        
        JOptionPane.showMessageDialog(null,"You investigated the Garden Bench.\n\n" + "The bench is slightly dusty.\n" + "It looks like someone recently sat here.");
        break;

    case "3":

        JOptionPane.showMessageDialog(null,"You investigated the Bird Bath.\n\n" + "There is dirty water inside.\n" + "You noticed some unusual footprints nearby.");
        break;

    case "4":
        
        JOptionPane.showMessageDialog(null,"You investigated the Watering Can.\n\n" + "It is empty and has some soil stuck to its sides.");
        break;

    case "5":
        
        JOptionPane.showMessageDialog(null,"You investigated the Garden Lamp.\n\n" + "The lamp is working, but its light flickers occasionally.");
        break;

    case "6":

        if (!foundStatueRiddle) {

        JOptionPane.showMessageDialog(null,"You examined the Garden Statue.\n\n" + "An inscription is carved at its base:\n\n" + "RIDDLE:\n\n" + "The more you take, the more you leave behind.\n" + "What am I?");

        String statueRiddle = JOptionPane.showInputDialog("Enter your answer:");

        if (statueRiddle == null) {
        break;}

        if (statueRiddle.equalsIgnoreCase("footsteps")) {

        JOptionPane.showMessageDialog(null,"CORRECT ANSWER!\n\n" + "The statue makes a clicking sound.\n" + "A small compartment opens beneath it!\n\n" + "You discovered a GIRLS BEDROOM KEY!");

        hasGirlsBedroomKey = true;

        addToInventory("Girls Bedroom Key","A mysterious key discovered inside the Garden Statue. " +"It unlocks the Girls Bedroom.",0);

        foundStatueRiddle = true;

        } else {
            
        JOptionPane.showMessageDialog(null,"WRONG ANSWER!\n\n" + "Nothing happened.\n" + "The statue remains silent.");}

        } else {
        
        JOptionPane.showMessageDialog(null,"You examined the Garden Statue again.\n\n" + "You already collected the Girls Bedroom Key.");}

    break;


    case "7":

        if (!hasNotebook) {

        JOptionPane.showMessageDialog(null,"You examined the Artificial Grass Floor.\n\n" + "Something seems unusual underneath it.\n" + "However, you don't know how to open it.\n\n" + "You need to find Kuya's Notebook first!");

        } else if (!foundHiddenRoom) {
            
        JOptionPane.showMessageDialog(null,"You examined the Artificial Grass Floor.\n\n" + "Kuya's Notebook contains instructions on how to " + "open this hidden entrance.\n\n" + "You must enter the four-digit passcode.");

        String passcode = JOptionPane.showInputDialog("ENTER THE FOUR-DIGIT PASSCODE:");

        if (passcode == null) {
         break;}

        if (passcode.equals(correctPasscode)) { JOptionPane.showMessageDialog(null,"CORRECT PASSCODE!\n\n" + "You entered the correct code.\n" + "The artificial grass floor opens!\n\n" + "You discovered a HIDDEN ROOM!");

            foundHiddenRoom = true;

        // hidden room method
        getHiddenRoom();

        } else {
            
            JOptionPane.showMessageDialog(null,"INCORRECT PASSCODE!\n\n" + "The artificial grass floor remains closed.\n" + "Check the clues in your inventory.");}

        } else { 
            
            JOptionPane.showMessageDialog(null,"The hidden entrance is already open!\n\n" + "You can now access the Hidden Room.");

        }

        break;


        case "8":

        menu = false;
        break;

        default:

            JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");
            break;

            }
        }
    }


// Girls Bedroom method with riddle and hidden passcode
public static void getGirlsBedroom() {

String[] girlsObjects = {"Wardrobe","Bed","Nightstand","Vanity Table","Vanity Mirror","Window"};

boolean menu = true;

while (menu) {

String objects = "";

for (int i = 0; i < girlsObjects.length; i++) {objects += (i + 1) + ". " + girlsObjects[i] + "\n";}

objects += "7. Back";

String choice = JOptionPane.showInputDialog("GIRLS BEDROOM - INVESTIGATION\n\n" +"Choose an object to investigate:\n\n" + objects + "\nEnter your choice:");

if (choice == null) {
return;}

switch (choice) {

        case "1":
            
            JOptionPane.showMessageDialog(null,"You investigated the Wardrobe.\n\n" + "The clothes are neatly arranged.\n" + "Nothing unusual was found.");
            break;

        case "2":

            if (!foundBedPasscode) {

            JOptionPane.showMessageDialog(null,"You examined the Bed.\n\n" + "You lifted the pillow and discovered a folded note!\n\n" + "The note reads:\n\n" + "\"The answer lies in the number of letters " + "in the word KUYA.\"\n\n" + "You think this might be another clue to the " + "four-digit passcode.");

            addToInventory("Girls Bedroom Passcode Hint", "A folded note discovered underneath the pillow. " + "It says: The answer lies in the number of letters " + "in the word KUYA. This is another digit of the four-digit passcode.",0);

            foundBedPasscode = true;

        } else {

            JOptionPane.showMessageDialog(null,"You checked the Bed again.\n\n" + "You already collected the passcode hint.");
            }break;

        case "3":

            JOptionPane.showMessageDialog(null,"You investigated the Nightstand.\n\n" + "There are a few personal belongings inside.\n" + "Nothing suspicious was found.");
            break;

        case "4":

            JOptionPane.showMessageDialog(null,"You investigated the Vanity Table.\n\n" + "There are makeup products and a hairbrush.\n" + "Everything looks ordinary.");
            break;

        case "5":

            if (!foundMirrorRiddle) {

            JOptionPane.showMessageDialog(null,"You examined the Vanity Mirror.\n\n" +"A strange message appears on the mirror:\n\n" + "RIDDLE:\n\n" + "I show you your face, but I have no eyes.\n" + "I copy your movements, but I cannot move.\n" + "What am I?");

            String mirrorAnswer = JOptionPane.showInputDialog("Enter your answer:");

            if (mirrorAnswer == null) {
            break;}

            if (mirrorAnswer.equalsIgnoreCase("mirror")) {

            JOptionPane.showMessageDialog(null,"CORRECT ANSWER!\n\n" + "The mirror slides open!\n" + "A small key is hidden behind it!\n\n" + "You discovered the BOYS BEDROOM KEY!");

            hasBoysBedroomKey = true;

            addToInventory("Boys Bedroom Key","A small key hidden behind the Vanity Mirror. " +"It unlocks the Boys Bedroom.",0);

            foundMirrorRiddle = true;

        } else {

            JOptionPane.showMessageDialog(null,"WRONG ANSWER!\n\n" + "The mirror remains closed.\n" + "Try solving the riddle again.");}

        } else {

            JOptionPane.showMessageDialog(null,"You examined the Vanity Mirror again.\n\n" + "You already solved its riddle and collected the Boys Bedroom Key.");}

            break;

        case "6":

            JOptionPane.showMessageDialog(null,"You investigated the Window.\n\n" + "The window is locked from the inside.\n" + "Nothing unusual was found.");

             break;

        case "7":

            menu = false;
            break;

        default:

            JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");

            break;
        }
    }
}

//boys bedroom method with riddle to acquire the notebook and also the last digit password
public static void getBoysBedroom() {

String[] boysObjects = {"Study Desk","Bed","Nightstand","Bookshelf","Sports Bag","window"};

boolean menu = true;

while (menu) {

String objects = "";

for (int i = 0; i < boysObjects.length; i++) {objects += (i + 1) + ". " + boysObjects[i] + "\n";}

objects += "7. Back";

String choice = JOptionPane.showInputDialog("BOYS BEDROOM - INVESTIGATION\n\n" +"Choose an object to investigate:\n\n" +objects + "\nEnter your choice:");

if (choice == null) {
return;}

switch (choice) {

        case "1":

            if (!hasNotebook) {
                
            JOptionPane.showMessageDialog(null,"You investigated the Study Desk.\n\n" +"You noticed a hidden compartment.\n" + "A mysterious riddle is written on it:\n\n" + "RIDDLE:\n\n" + "I have many pages, but I am not a tree.\n" + "I contain knowledge, but I cannot speak.\n" + "What am I?");

            String answer = JOptionPane.showInputDialog("Enter your answer:");

            if (answer == null) {
            break;}

            if (answer.equalsIgnoreCase("book")) {
                
            JOptionPane.showMessageDialog(null,"CORRECT ANSWER!\n\n" + "The hidden compartment opens!\n" + "Inside, you discovered KUYA'S NOTEBOOK!\n\n" + "This notebook may contain instructions " + "for opening the hidden room in the Garden.");

            hasNotebook = true;

            addToInventory("Kuya's Notebook","An old notebook discovered inside the hidden " +"compartment of the Boys Bedroom Study Desk. " +  "It contains instructions on how to open " + "the hidden entrance beneath the Garden.",0);

        } else {

            JOptionPane.showMessageDialog(null,"WRONG ANSWER!\n\n" + "The compartment remains locked.\n" + "Try solving the riddle again.");}

         } else {

            JOptionPane.showMessageDialog(null,"You examined the Study Desk again.\n\n" + "You already discovered Kuya's Notebook.");}

            break;

        case "2":

            JOptionPane.showMessageDialog(null,"You investigated the Bed.\n\n" + "The bed looks messy.\n" + "Nothing unusual was found.");

            break;

        case "3":

            JOptionPane.showMessageDialog(null,"You investigated the Nightstand.\n\n" + "There are a few personal belongings inside.\n" + "Nothing suspicious was found.");

            break;

        case "4":

            if (!foundBookshelfPasscode) {

            JOptionPane.showMessageDialog(null,"You examined the Bookshelf.\n\n" +"One book looks different from the others.\n" + "You pulled it out and discovered a hidden note!\n\n" +"The note reads:\n\n" +"Three sides of a silent shape.\n\n" + "You believe this is the final clue " + "for the four-digit passcode.");

            addToInventory("Bookshelf Passcode Clue","A mysterious phrase discovered inside a book " +"on the Boys Bedroom Bookshelf. It says: " + "Three sides of a silent shape. This represents " +"the final digit of the four-digit passcode.", 0);

            foundBookshelfPasscode = true;

            } else {

            JOptionPane.showMessageDialog(null,"You checked the Bookshelf again.\n\n" +"You already collected the final passcode clue.");}

            break;

        case "5":

            JOptionPane.showMessageDialog(null,"You investigated the Sports Bag.\n\n" + "It contains old sports equipment.\n" + "Nothing unusual was found.");
            
            break;

        case "6":

            JOptionPane.showMessageDialog(null,"You investigated the Window.\n\n" + "The window is slightly open.\n" + "You can hear the wind outside.");

            break;

        case "7":

            menu = false;
            break;

        default:

            JOptionPane.showMessageDialog(null,"Invalid choice! Please try again.");

            break;


            }
        }
    }


//hidden room method
public static void getHiddenRoom() {

JOptionPane.showMessageDialog(null,"You slowly open the hidden entrance...\n\n" + "The room is dark and silent. The air feels heavy.\n" +  "You notice a strange smell coming from the corner.");

JOptionPane.showMessageDialog(null,"You slowly walk toward the corner.\n\n" + "There is something covered with a bloodstained cloth.");

JOptionPane.showMessageDialog(null,"With trembling hands, you remove the cloth...\n\n" +"You freeze in shock.\n\n" + "IT IS KUYA'S BODY!");

JOptionPane.showMessageDialog(null,"You finally discovered the truth.\n\n" +"Kuya was inside the house all along.\n" +"The mystery behind his disappearance has finally been solved.");

JOptionPane.showMessageDialog(null,
"================================\n" +
    "             THE END\n" +
"================================");

gameEnded = true;


}


//recursive method adding Item sa Inventory
public static void addToInventory(String item, String description, int index) {

// Base case: inventory is full
if (index >= inventory.length) {JOptionPane.showMessageDialog(null,"Your inventory is full!");
return;}

// Find an empty inventory slot
if (inventory[index] == null) {

inventory[index] = item + "\nDescription: " + description;
inventoryCount++;

JOptionPane.showMessageDialog(null,item + " successfully added to inventory!");

return;}

// Recursive call: check the next slot
addToInventory(item, description, index + 1);

}






//main game menu method
public static void gameMenu(String gameMenu) {

String choice = "";
boolean menu = true;

while (menu && !gameEnded) {

String confessionStatus;
String gardenStatus;
String girlsBedroomStatus;
String boysBedroomStatus;

        
//if else statement sa locked nga confession room
if (hasKey) {
        confessionStatus = "2. Confession Room [UNLOCKED]";
    } else {
        confessionStatus = "2. Confession Room [LOCKED]";
    }

//if else statment sa locked nga garden area
if(hasGardenKey){
        gardenStatus = "3. Garden [UNLOCKED]";
    } else {
         gardenStatus = "3. Garden [LOCKED]";
    }

//if else statement sa locked nga girls bedroom
if(hasGirlsBedroomKey) {
        girlsBedroomStatus = "4. Girls Bedroom [UNLOCKED";
    } else {
        girlsBedroomStatus = "4. Girls Bedroom [LOCKED]";
    }

//if else statement sa locked nga boys bedroom
if (hasBoysBedroomKey) {
        boysBedroomStatus = "5. Boys Bedroom [UNLOCKED]";
    } else {
        boysBedroomStatus = "5. Boys Bedroom [LOCKED]";
    }

    choice = JOptionPane.showInputDialog(
            "GAME MENU\n\n" +
            "1. Living Room\n" +
            confessionStatus + "\n" +
            gardenStatus + "\n" +
            girlsBedroomStatus + "\n" +
            boysBedroomStatus + "\n" +
            "6. Inventory\n" +
            "7. Quit\n\n" +
            "Enter your Choice:");

if (choice == null) {
return;}

switch (choice) {

        case "1":
                getLivingRoom(choice);
                break;

        case "2":

                if (hasKey) {

                    JOptionPane.showMessageDialog(null, "You used the Hidden Key!\n\n" + "The Confession Room is now unlocked.");

                    getConfessionArea();

                } else {
                    JOptionPane.showMessageDialog(null,"ACCESS DENIED!\n\n" + "The Confession Room is locked.\n" + "You need to find the Hidden Key first.");
                }

                break;

        case "3":
                
                if (hasGardenKey) {
                    
                    JOptionPane.showMessageDialog(null,"You used the Garden Key!\n\n" + "The Garden is now unlocked.");
                    
                    getGardenArea();
                
                } else {
                    JOptionPane.showMessageDialog(null,"ACCESS DENIED!\n\n" + "The Garden is locked.\n" + "You need to find the Garden Key first.");
                }
                
                break;

        case "4":

                if (hasGirlsBedroomKey) {

                    JOptionPane.showMessageDialog(null,"You used the Girls Bedroom Key!\n\n" + "The Girls Bedroom is now unlocked.");

                    getGirlsBedroom();

                } else {

                JOptionPane.showMessageDialog(null,"ACCESS DENIED!\n\n" + "The Girls Bedroom is locked.\n" + "You need to find the Girls Bedroom Key first.");}

                break;

        case "5":

                if (hasBoysBedroomKey) {

                    JOptionPane.showMessageDialog(null,"You used the Boys Bedroom Key!\n\n" + "The Boys Bedroom is now unlocked.");

                    getBoysBedroom();

                } else {

                    JOptionPane.showMessageDialog(null,"ACCESS DENIED!\n\n" + "The Boys Bedroom is locked.\n" + "You need to find the Boys Bedroom Key first.");
                
                }

                break;

        case "6":
                
                String items = "";

                if (inventoryCount == 0) {

                JOptionPane.showMessageDialog(null,"YOUR INVENTORY\n\n" + "You haven't collected any items yet.");

                } else {

                items = "YOUR INVENTORY\n\n";

                for (int i = 0; i < inventoryCount; i++) {items += "ITEM " + (i + 1) + "\n";items += inventory[i] + "\n"; items += "--------------------------\n";}

                JOptionPane.showMessageDialog(null, items);
            }
            
            break;

        case "7":
                
                menu = false;

                JOptionPane.showMessageDialog(null,"Thanks for playing!");
                break;

        default:

                JOptionPane.showMessageDialog(null,"Invalid choice!");
                break;

        }
    }
}

}
