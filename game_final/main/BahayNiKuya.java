import javax.swing.JOptionPane;

/*
 * Bahay ni Kuya - Murder Mystery
 * A text-based detective game that uses JOptionPane for every interaction.
 *
 * Progression:
 *   Living Room (Rug -> CLOCK) gives the Confession Room Key
 *   Confession Room (Side Cabinet -> MICROPHONE) gives the Garden Key
 *   Garden (Garden Statue -> STATUE) gives the Girls Bedroom Key
 *   Girls Bedroom (Vanity Table -> MIRROR) gives the Boys Bedroom Key
 *   Boys Bedroom (Study Desk -> NOTEBOOK) opens the Notebook
 *   Garden (Artificial Grass Floor) -> Concealed Door (9364) -> Final Riddle (KUYA)
 *
 * All source strings use plain ASCII characters so the file compiles the
 * same way on Windows and other systems.
 */
public class BahayNiKuya {

    // =====================================================================
    // FIXED GAME DATA (ARRAYS)
    // =====================================================================

    static final String GAME_TITLE = "Bahay ni Kuya - Murder Mystery";

    // Room index: 0 = Living Room, 1 = Confession Room, 2 = Garden,
    //             3 = Girls Bedroom, 4 = Boys Bedroom
    static final int LIVING_ROOM = 0;
    static final int GARDEN = 2;
    static final int BOYS_BEDROOM = 4;

    static final String[] LOCATION_NAMES = {
        "Living Room", "Confession Room", "Garden", "Girls Bedroom", "Boys Bedroom"
    };

    // KEY_NAMES[i] unlocks LOCATION_NAMES[i + 1].
    static final String[] KEY_NAMES = {
        "Confession Room Key", "Garden Key", "Girls Bedroom Key", "Boys Bedroom Key"
    };

    static final String NOTEBOOK = "Notebook";

    // ---------------- Living Room areas ----------------

    static final String[] AREA_NAMES = { "Sofa Area", "Dining Area", "Elevator Area" };

    static final String[] AREA_HEADERS = {
        "[SOFA AREA]\n\n"
            + "The sofa area appears undisturbed at first glance. Several household items "
            + "are scattered around the seating area.",
        "[DINING AREA]\n\n"
            + "The dining area contains a table and several chairs. Everything appears "
            + "to have been left as it was after the last meal.",
        "[ELEVATOR AREA]\n\n"
            + "A modern elevator stands beside the Living Room.\n\n"
            + "Its doors remain closed, and a small indicator panel is mounted above the entrance."
    };

    static final String[][] AREA_OBJECTS = {
        { "Pillow", "Rug", "Blanket", "Sofa" },
        { "Dining Table", "Dining Chairs", "Cabinet", "Wall Decoration" },
        { "Floor Indicator", "Elevator Buttons", "Elevator Door" }
    };

    static final String[][] AREA_DESCRIPTIONS = {
        {
            "The pillow looks ordinary. You inspect its surface and turn it over, "
                + "but nothing unusual catches your attention.",
            "The rug appears slightly uneven. Upon closer inspection, you notice a small "
                + "section that seems to have been disturbed.\n\n"
                + "Something might be concealed underneath.",
            "A blanket rests on the sofa. It appears to have been used recently, although "
                + "there is nothing particularly unusual about it.",
            "You examine the cushions and the spaces between them.\n"
                + "Nothing appears to be hidden inside. The sofa seems to be in its usual condition."
        },
        {
            "The dining table has a few faint marks on its surface. They appear to be "
                + "ordinary signs of everyday use.",
            "You inspect the chairs one by one. One of them is slightly pulled away from "
                + "the table, but there is nothing else worth noting.",
            "The cabinet contains several household utensils and dining supplies. "
                + "Everything appears to be in its proper place.",
            "A decorative piece hangs on the wall. You examine it carefully, but find "
                + "nothing unusual."
        },
        {
            "The digital floor indicator displays the number 3.\n"
                + "The elevator appears to be stationary on the third floor.",
            "Several buttons are arranged on the elevator panel. They correspond to the "
                + "available floors of the house.\n"
                + "The elevator controls appear to be inactive.",
            "You inspect the elevator doors. They are firmly closed, and there is no "
                + "indication that the elevator is currently operational."
        }
    };

    // The Rug (Sofa Area, object index 1) holds puzzle 0.
    static final int SOFA_AREA = 0;
    static final int RUG_INDEX = 1;

    // ---------------- Other rooms (index 1 to 4) ----------------
    // Index 0 is empty because the Living Room uses its own areas.

    static final String[] ROOM_ENTRY_TEXTS = {
        "",
        "The Confession Room door opens.\n\n"
            + "You step inside and take a moment to examine your surroundings.\n\n"
            + "The room is quiet, with recording equipment and furniture arranged throughout the space.\n\n"
            + "Perhaps something here will help you continue the investigation.",
        "The Garden is a peaceful outdoor area surrounded by greenery.\n\n"
            + "A small flower bed adds color to the space, while a garden bench and several "
            + "outdoor fixtures complete the surroundings.\n\n"
            + "The area appears calm and undisturbed, offering a brief change of atmosphere "
            + "from the rooms inside the house.\n\n"
            + "Take a closer look around. Even the quietest places may hold something worth discovering.",
        "The Girls Bedroom is a private and comfortable space inside Bahay ni Kuya.\n\n"
            + "The room contains familiar bedroom furniture, personal belongings, and a vanity area.\n\n"
            + "Everything seems neatly arranged, giving the room an ordinary and peaceful appearance.\n\n"
            + "Take your time to look around. There may be more to discover than what first meets the eye.",
        "The Boys Bedroom is another private space inside Bahay ni Kuya.\n\n"
            + "The room contains familiar bedroom furniture, personal belongings, and a study area.\n\n"
            + "At first glance, everything appears ordinary and undisturbed.\n\n"
            + "Look around carefully. Something in this room may hold information that changes "
            + "the course of your investigation."
    };

    static final String[][] ROOM_OBJECTS = {
        {},
        { "Broken Wall Clock", "Confession Chair", "Microphone", "Camera", "Side Cabinet", "Wall Panels" },
        { "Flower Bed", "Garden Bench", "Bird Bath", "Watering Can", "Garden Lamp", "Garden Statue" },
        { "Wardrobe", "Bed", "Nightstand", "Vanity Table", "Vanity Mirror", "Window" },
        { "Study Desk", "Bed", "Nightstand", "Bookshelf", "Sports Bag", "Window" }
    };

    static final String[][] ROOM_OBJECT_DESCRIPTIONS = {
        {},
        {
            "An old wall clock hangs above the room. Its hands have stopped moving, frozen "
                + "at exactly 9:00 PM.\n\n"
                + "The clock no longer works, but the displayed time remains visible.",
            "A chair placed in front of the recording equipment, where housemates would sit "
                + "during their confession sessions.",
            "A microphone used to capture the words spoken during confession sessions. "
                + "It appears to be in working condition.",
            "A camera positioned to record activities inside the room. Its lens faces the "
                + "confession area.",
            "A small cabinet stands against the wall. Its contents appear ordinary at first, "
                + "but something about it suggests there may be more hidden inside.",
            "Soundproof panels cover the walls, helping keep conversations inside the room private."
        },
        {
            "A small flower bed containing exactly four flowers. Each one stands neatly "
                + "among the surrounding greenery.",
            "A simple wooden bench placed in the garden. It provides a quiet place to sit "
                + "and enjoy the surrounding greenery.",
            "A shallow basin filled with water, intended for birds to drink and bathe.",
            "A watering can used to keep the garden plants hydrated. A few drops of water "
                + "remain inside.",
            "An outdoor lamp positioned to illuminate the garden when the sun goes down.",
            "A stone statue stands quietly among the garden decorations. Its surface shows "
                + "signs of age, but it remains firmly in place. Something about its structure "
                + "seems unusual."
        },
        {
            "A wardrobe containing exactly six pieces of clothing, neatly arranged inside.",
            "A neatly arranged bed with pillows and blankets. It appears to be a comfortable "
                + "place to rest.",
            "A small bedside table with a drawer for keeping personal belongings.",
            "A vanity table sits neatly arranged in the bedroom. Its surface holds a few "
                + "personal items, while its drawers appear to provide storage for smaller "
                + "belongings. One part of the table seems worth examining more closely.",
            // PROPOSED TEXT - awaiting project owner approval (Vanity Mirror had no description).
            "A mirror is mounted above the vanity table. Its glass is clean, and it shows "
                + "nothing but your own reflection.",
            "A window overlooking the outside of Bahay ni Kuya. Sunlight passes through the glass."
        },
        {
            "A study desk sits in one corner of the bedroom. Several items are arranged "
                + "across its surface, including a notebook. It looks like a place where "
                + "someone might keep personal thoughts or important information.",
            "A simple bed with neatly arranged pillows and blankets.",
            "A small bedside table used for keeping personal belongings within reach.",
            "A shelf filled with books and reading materials arranged in several rows.",
            "A sports bag placed near the furniture. It appears to contain personal belongings.",
            "A window overlooking the outside of Bahay ni Kuya. The view is quiet and undisturbed."
        }
    };

    // Which object in each room is the puzzle object (-1 = none; Living Room uses RUG_INDEX).
    // Confession = Side Cabinet, Garden = Garden Statue, Girls = Vanity Table, Boys = Study Desk.
    static final int[] PUZZLE_OBJECT_INDEX = { -1, 4, 5, 3, 0 };

    // ---------------- Puzzles 0 to 4 (one per room, same index as the room) ----------------

    static final String[] PUZZLE_ACTIONS = {
        "Lift the Rug",
        "Open the Cabinet",
        "Inspect the Statue's Base",
        "Check the Drawers",
        "Pick Up the Notebook"
    };

    static final String[] PUZZLE_DISCOVERY_TEXTS = {
        "You carefully lift the rug.\n\n"
            + "Beneath it, you discover a small wooden compartment. It appears to have been "
            + "deliberately concealed.\n\n"
            + "A short riddle is written on its surface.\n\n"
            + "Perhaps solving it will reveal what is inside.",
        "You open the cabinet and look through its contents.\n\n"
            + "Behind the ordinary items, you discover a small compartment built into the back "
            + "of the cabinet. It appears to have been deliberately concealed.\n\n"
            + "A short riddle is written on its surface.\n\n"
            + "Perhaps solving it will reveal what is inside.",
        "You kneel down and inspect the base of the statue.\n\n"
            + "Near the bottom, you notice a thin seam in the stone, as if part of the base could open.\n\n"
            + "A short riddle is carved beside it.\n\n"
            + "Perhaps solving it will reveal what is inside.",
        "You open the drawers one by one. They contain only small personal belongings.\n\n"
            + "As you close the last drawer, you notice a small compartment hidden beneath the "
            + "surface of the table.\n\n"
            + "A short riddle is written on its cover.\n\n"
            + "Perhaps solving it will reveal what is inside.",
        "You pick up the Notebook from the desk.\n\n"
            + "Its cover is held shut by a small clasp. A short riddle is written across the front.\n\n"
            + "Perhaps solving it will let you read what is inside."
    };

    static final String[] PUZZLE_ALREADY_SOLVED_TEXTS = {
        "The compartment is already open.\n\nThere is nothing else inside.",
        "The concealed compartment is already open. The Garden Key has already been collected.",
        "The statue's concealed compartment is already open. The Girls Bedroom Key has already been collected.",
        "The concealed compartment is already open. The Boys Bedroom Key has already been collected.",
        "The Notebook has already been read."
    };

    // Reward for each puzzle: the four keys, then the Notebook.
    static final String[] PUZZLE_REWARDS = {
        KEY_NAMES[0], KEY_NAMES[1], KEY_NAMES[2], KEY_NAMES[3], NOTEBOOK
    };

    // ---------------- Riddles 0 to 5 (RD-001 to RD-006) ----------------

    static final int NOTEBOOK_RIDDLE = 4;
    static final int FINAL_RIDDLE = 5;

    static final String[] RIDDLE_TITLES = {
        "THE HIDDEN COMPARTMENT",
        "THE SILENT WITNESS",
        "THE SILENT FIGURE",
        "THE KEEPER OF REFLECTIONS",
        "THE KEEPER OF THOUGHTS",
        "THE FINAL DISCOVERY"
    };

    static final String[] RIDDLE_TEXTS = {
        "\"I have a face, but I cannot see.\n"
            + "I have hands, but I cannot hold.\n"
            + "I tell you when, but never why.\n\n"
            + "What am I?\"",
        "\"I capture words but have no voice.\n"
            + "I hear your secrets without a choice.\n"
            + "I turn your whispers into sound,\n"
            + "Yet I am silent when no one is around.\n\n"
            + "What am I?\"",
        "\"I have no voice, yet I tell a tale.\n"
            + "I stand in place through sun and gale.\n"
            + "I never walk, yet I may be moved.\n"
            + "What am I?\"",
        "\"I show your face but have no eyes.\n"
            + "I copy your movements, yet never try.\n"
            + "I follow your every pose,\n"
            + "But disappear when darkness grows.\n"
            + "What am I?\"",
        "\"I have no mind, yet hold your thoughts.\n"
            + "I have no voice, yet tell what was taught.\n"
            + "I keep the past from fading away.\n"
            + "What am I?\"",
        "\"I was hidden from every eye.\n\n"
            + "Beneath the place where flowers lie.\n\n"
            + "No footsteps lead to where I stay.\n\n"
            + "Yet here I rest, concealed away.\n\n"
            + "What is it that you have come to find?\""
    };

    static final String[] RIDDLE_ANSWERS = {
        "CLOCK", "MICROPHONE", "STATUE", "MIRROR", "NOTEBOOK", "KUYA"
    };

    static final String[] RIDDLE_INCORRECT_TEXTS = {
        "[INCORRECT ANSWER]\n\n"
            + "That doesn't seem to be the correct answer.\n\n"
            + "The compartment remains locked.\n\n"
            + "Think carefully and try again.",
        "[INCORRECT ANSWER]\n\n"
            + "That doesn't seem to be the correct answer.\n\n"
            + "The compartment remains locked.\n\n"
            + "Think carefully and try again.",
        "Nothing happens. The statue remains still.",
        "Nothing happens. The vanity table remains locked.",
        "The Notebook remains closed. You cannot make out its contents.",
        "The answer does not seem right.\n\n"
            + "You look around the hidden chamber, trying to understand the clue."
    };

    static final String[] RIDDLE_CORRECT_TEXTS = {
        "[CORRECT ANSWER]\n\n"
            + "The compartment clicks open.\n\n"
            + "Inside, you discover a small key.\n\n"
            + "You carefully retrieve it.\n\n"
            + "ITEM OBTAINED:\nCONFESSION ROOM KEY\n\n"
            + "This key grants access to the Confession Room.",
        "[CORRECT ANSWER]\n\n"
            + "You hear a faint clicking sound.\n\n"
            + "The concealed compartment opens.\n\n"
            + "Inside, you discover a small key.\n\n"
            + "ITEM OBTAINED:\nGARDEN KEY\n\n"
            + "This key grants access to the Garden.",
        "[CORRECT ANSWER]\n\n"
            + "The statue makes a faint clicking sound.\n\n"
            + "A small compartment opens beneath its base.\n\n"
            + "Inside, you discover a key.\n\n"
            + "ITEM OBTAINED:\nGIRLS BEDROOM KEY\n\n"
            + "This key grants access to the Girls Bedroom.",
        "[CORRECT ANSWER]\n\n"
            + "You hear a faint click from the vanity table.\n\n"
            + "A small compartment opens beneath its surface.\n\n"
            + "Inside, you discover a key.\n\n"
            + "ITEM OBTAINED:\nBOYS BEDROOM KEY\n\n"
            + "This key grants access to the Boys Bedroom.",
        "[CORRECT ANSWER]\n\n"
            + "You carefully open the Notebook.\n\n"
            + "Inside, a handwritten message catches your attention.",
        "Your eyes widen.\n\n"
            + "The truth of the suspect's final clue becomes clear.\n\n"
            + "Hidden beneath the Garden, you finally discover Kuya.\n\n"
            + "Your investigation is complete."
    };

    // ---------------- Story and final investigation text ----------------

    static final String DIALOGUE_1 =
        "Something terrible has happened inside Bahay ni Kuya.\n\n"
        + "Kuya, the most important person in the house, has been murdered.\n\n"
        + "However, one important detail remains unresolved.\n\n"
        + "Kuya's body has not been found.\n\n"
        + "One of the suspects eventually revealed something that changed the direction of the investigation.\n\n"
        + "The body is hidden somewhere inside Bahay ni Kuya.\n\n"
        + "But finding it will not be easy.";

    static final String DIALOGUE_2 =
        "Several keys have been concealed throughout the house.\n\n"
        + "Each key provides access to another restricted location, but finding them will require solving puzzles.\n\n"
        + "The suspect refused to reveal anything more.\n\n"
        + "The remaining task is yours, Detective [Name].\n\n"
        + "Find Kuya's hidden body.";

    static final String DIALOGUE_3 =
        "You have been assigned to investigate the disappearance of Kuya's body.\n\n"
        + "Your objectives are:\n\n"
        + "1. Explore the accessible locations inside Bahay ni Kuya.\n"
        + "2. Discover the hidden keys and solve their puzzles.\n"
        + "3. Examine objects that may contain important information.\n"
        + "4. Remember numerical clues discovered throughout the house.\n"
        + "5. Gain access to every restricted room.\n"
        + "6. Discover the significance of the Notebook.\n"
        + "7. Locate the concealed area and find Kuya's body.\n\n"
        + "Your investigation begins in the Living Room.\n\n"
        + "Good luck, Detective [Name].";

    static final String OPENING_ROOM_DESCRIPTION =
        "[LIVING ROOM]\n\n"
        + "You enter the Living Room of Bahay ni Kuya.\n\n"
        + "The room is spacious, with several pieces of furniture arranged throughout the area. "
        + "A sofa occupies one side of the room, while a dining area sits nearby.\n\n"
        + "At the far end, an elevator provides access to other parts of the house.\n\n"
        + "Everything appears relatively ordinary, but you know that something important is "
        + "hidden somewhere inside this house.\n\n"
        + "The suspect's statement mentioned that several keys had been concealed throughout Bahay ni Kuya.\n\n"
        + "Perhaps the Living Room is a good place to begin.\n\n"
        + "What would you like to investigate?";

    static final String NOTEBOOK_CONTENTS =
        "[NOTEBOOK]\n\n"
        + "You have access to every room in this house.\n\n"
        + "But finding the keys was only the beginning.\n\n"
        + "Return to each room. Look closely. There is evidence you have yet to understand.\n\n"
        + "Do not overlook anything.";

    static final String ARTIFICIAL_GRASS = "Artificial Grass Floor";

    static final String GRASS_DISCOVERY_TEXT =
        "Something feels unusual beneath your feet.\n\n"
        + "You kneel down and inspect the artificial grass more closely.\n\n"
        + "Part of the flooring seems loose.\n\n"
        + "After lifting it, you discover a concealed door underneath.";

    static final String DOOR_INSCRIPTION =
        "[INSCRIPTION]\n\n"
        + "\"Four rooms hold what you seek.\n\n"
        + "First, where secrets are confessed.\n\n"
        + "Then, where everyone gathers.\n\n"
        + "Next, where the mirrors tell their tales.\n\n"
        + "Finally, where flowers quietly bloom.\n\n"
        + "Remember what you have seen.\n\n"
        + "Let their numbers reveal the way.\"";

    static final String FINAL_PASSWORD = "9364";

    static final String PASSWORD_CORRECT_TEXT =
        "A mechanical clicking sound echoes beneath the floor.\n\n"
        + "The concealed door slowly unlocks.\n\n"
        + "You carefully pull it open.";

    static final String PASSWORD_INCORRECT_TEXT =
        "Nothing happens.\n\n"
        + "The concealed door remains locked.";

    // =====================================================================
    // GAME STATE
    // =====================================================================

    static String detectiveName = null;
    static String currentLocation = LOCATION_NAMES[LIVING_ROOM];

    // Up to four keys plus the Notebook.
    static String[] inventory = new String[5];
    static int inventoryCount = 0;

    static boolean notebookAccessed = false;
    static boolean finalInvestigationActive = false;
    static boolean doorDiscovered = false;
    static boolean doorUnlocked = false;
    static boolean gameRunning = true;

    // The Opening Room Description is shown only the first time the hub appears.
    static boolean firstHubVisit = true;

    // =====================================================================
    // MAIN AND OPENING SEQUENCE
    // =====================================================================

    public static void main(String[] args) {
        startGame();

        // Main game loop: the Living Room hub repeats until the player exits.
        do {
            showMainMenu();
        } while (gameRunning);

        System.exit(0);
    }

    static void startGame() {
        showMessage(DIALOGUE_1);
        enterDetectiveName();
        displayStoryline();
    }

    static void enterDetectiveName() {
        String name;
        do {
            name = showInput("Enter your detective name:");

            if (name == null) {
                // Cancelled: ask whether to exit. If No, ask for the name again.
                confirmExit();
            } else if (name.trim().isEmpty()) {
                showMessage("Please enter your detective name.");
                name = null;
            } else {
                name = name.trim();
            }
        } while (name == null);

        detectiveName = name;
    }

    static void displayStoryline() {
        showMessage(DIALOGUE_2.replace("[Name]", detectiveName));
        showMessage(DIALOGUE_3.replace("[Name]", detectiveName));
    }

    // =====================================================================
    // LIVING ROOM HUB
    // =====================================================================

    static void showMainMenu() {
        currentLocation = LOCATION_NAMES[LIVING_ROOM];

        String header;
        if (firstHubVisit) {
            header = OPENING_ROOM_DESCRIPTION;
            firstHubVisit = false;
        } else {
            header = "[LIVING ROOM]\n\nWhat would you like to investigate?";
        }

        String menu = header + "\n\n"
            + "[1] Investigate Sofa Area\n"
            + "[2] Investigate Dining Area\n"
            + "[3] Investigate Elevator Area\n"
            + "[4] Go To\n"
            + "[5] Inventory\n"
            + "[6] Exit";

        int choice = readMenuChoice(menu, 6);

        if (choice == -1 || choice == 6) {
            // Cancel and Exit both ask for confirmation.
            confirmExit();
        } else if (choice >= 1 && choice <= 3) {
            showAreaMenu(choice - 1);
        } else if (choice == 4) {
            showLocationMenu();
        } else if (choice == 5) {
            displayInventory();
        }
    }

    static void showAreaMenu(int area) {
        boolean inArea = true;
        do {
            String menu = AREA_HEADERS[area] + "\n\nWhat would you like to investigate?\n\n";
            for (int i = 0; i < AREA_OBJECTS[area].length; i++) {
                menu += "[" + (i + 1) + "] " + AREA_OBJECTS[area][i] + "\n";
            }
            int returnOption = AREA_OBJECTS[area].length + 1;
            menu += "[" + returnOption + "] Return";

            int choice = readMenuChoice(menu, returnOption);

            if (choice == -1 || choice == returnOption) {
                inArea = false; // back to the Living Room hub
            } else {
                int objectIndex = choice - 1;
                String name = AREA_OBJECTS[area][objectIndex];
                String description = AREA_DESCRIPTIONS[area][objectIndex];

                if (area == SOFA_AREA && objectIndex == RUG_INDEX) {
                    investigatePuzzleObject(LIVING_ROOM, name, description);
                } else {
                    displayObjectDescription(name, description);
                }
            }
        } while (inArea);
    }

    // =====================================================================
    // ROOM NAVIGATION
    // =====================================================================

    static void showLocationMenu() {
        boolean choosing = true;
        do {
            String menu = "[GO TO]\n\nWhere would you like to go?\n\n";
            for (int i = 1; i < LOCATION_NAMES.length; i++) {
                menu += "[" + i + "] " + LOCATION_NAMES[i] + "\n";
            }
            int returnOption = LOCATION_NAMES.length;
            menu += "[" + returnOption + "] Return";

            int choice = readMenuChoice(menu, returnOption);

            if (choice == -1 || choice == returnOption) {
                choosing = false;
            } else {
                String requiredKey = KEY_NAMES[choice - 1];
                if (hasItem(requiredKey)) {
                    enterRoom(choice);
                    choosing = false; // leaving a room always returns to the hub
                } else {
                    showMessage("The door is locked. You need the " + requiredKey
                        + " to enter this location.");
                }
            }
        } while (choosing);
    }

    static void enterRoom(int room) {
        currentLocation = LOCATION_NAMES[room];
        showMessage("[" + LOCATION_NAMES[room].toUpperCase() + "]\n\n" + ROOM_ENTRY_TEXTS[room]);
        showRoomMenu(room);
        currentLocation = LOCATION_NAMES[LIVING_ROOM];
    }

    static void showRoomMenu(int room) {
        boolean inRoom = true;
        do {
            // The Artificial Grass Floor appears in the Garden only after the Notebook is read.
            boolean showGrass = (room == GARDEN && finalInvestigationActive);

            String menu = "[" + LOCATION_NAMES[room].toUpperCase() + "]\n\n"
                + "What would you like to investigate?\n\n";

            int option = 1;
            for (int i = 0; i < ROOM_OBJECTS[room].length; i++) {
                menu += "[" + option + "] " + ROOM_OBJECTS[room][i] + "\n";
                option++;
            }
            int grassOption = -1;
            if (showGrass) {
                grassOption = option;
                menu += "[" + grassOption + "] " + ARTIFICIAL_GRASS + "\n";
                option++;
            }
            int inventoryOption = option;
            int returnOption = option + 1;
            menu += "[" + inventoryOption + "] Inventory\n";
            menu += "[" + returnOption + "] Return to Living Room";

            int choice = readMenuChoice(menu, returnOption);

            if (choice == -1 || choice == returnOption) {
                inRoom = false;
            } else if (choice == inventoryOption) {
                displayInventory();
            } else if (choice == grassOption) {
                investigateArtificialGrass();
            } else {
                investigateObject(room, choice - 1);
            }
        } while (inRoom);
    }

    // =====================================================================
    // OBJECT INVESTIGATION
    // =====================================================================

    static void investigateObject(int room, int objectIndex) {
        String name = ROOM_OBJECTS[room][objectIndex];
        String description = ROOM_OBJECT_DESCRIPTIONS[room][objectIndex];

        if (objectIndex == PUZZLE_OBJECT_INDEX[room]) {
            investigatePuzzleObject(room, name, description);
        } else {
            // Ordinary objects and numerical clue objects both show their description.
            displayObjectDescription(name, description);
        }
    }

    static void displayObjectDescription(String name, String description) {
        showMessage("[" + name.toUpperCase() + "]\n\n" + description);
    }

    /*
     * Handles the Rug, Side Cabinet, Garden Statue, Vanity Table and Study Desk.
     * The puzzle number is the same as the room number (0 to 4).
     */
    static void investigatePuzzleObject(int puzzle, String name, String description) {
        String menu = "[" + name.toUpperCase() + "]\n\n" + description + "\n\n"
            + "[1] " + PUZZLE_ACTIONS[puzzle] + "\n"
            + "[2] Return";

        int choice = readMenuChoice(menu, 2);
        if (choice != 1) {
            return; // Return or Cancel goes back to the object menu
        }

        String reward = PUZZLE_REWARDS[puzzle];

        // Prevent the same reward from being collected twice.
        if (hasItem(reward)) {
            showMessage(PUZZLE_ALREADY_SOLVED_TEXTS[puzzle]);
            return;
        }

        showMessage(PUZZLE_DISCOVERY_TEXTS[puzzle]);

        boolean solved = showRiddle(puzzle);
        if (solved) {
            addInventoryItem(reward);
            showMessage(RIDDLE_CORRECT_TEXTS[puzzle]);

            if (puzzle == NOTEBOOK_RIDDLE) {
                showMessage(NOTEBOOK_CONTENTS);
                activateFinalInvestigation();
            }
        }
    }

    // =====================================================================
    // RIDDLES
    // =====================================================================

    /*
     * Shows a riddle until the player answers correctly or chooses Return.
     * Returns true for a correct answer, false for Return or Cancel.
     */
    static boolean showRiddle(int riddle) {
        String prompt = "[" + RIDDLE_TITLES[riddle] + "]\n\n"
            + RIDDLE_TEXTS[riddle] + "\n\n"
            + "Enter your answer:";

        boolean tryAgain;
        do {
            tryAgain = false;
            String answer = showInput(prompt);

            if (answer == null) {
                return false; // Cancel goes back to the current room's object menu
            }

            if (answer.trim().isEmpty()) {
                showMessage("Please enter an answer.");
                tryAgain = true;
            } else if (validateAnswer(answer, RIDDLE_ANSWERS[riddle])) {
                return true;
            } else {
                String retryMenu = RIDDLE_INCORRECT_TEXTS[riddle] + "\n\n"
                    + "[1] Try Again\n"
                    + "[2] Return";
                int choice = readMenuChoice(retryMenu, 2);
                tryAgain = (choice == 1); // Return or Cancel leaves the riddle
            }
        } while (tryAgain);

        return false;
    }

    static boolean validateAnswer(String answer, String correctAnswer) {
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }

    // =====================================================================
    // INVENTORY
    // =====================================================================

    static void addInventoryItem(String item) {
        if (!hasItem(item) && inventoryCount < inventory.length) {
            inventory[inventoryCount] = item;
            inventoryCount++;
        }
    }

    static boolean hasItem(String item) {
        return containsItemRecursive(item, 0);
    }

    /*
     * Recursive search through the inventory.
     * Base case 1: reached the end of the filled slots -> not found.
     * Base case 2: the current slot matches -> found.
     * Otherwise, check the next slot.
     */
    static boolean containsItemRecursive(String target, int index) {
        if (index >= inventoryCount) {
            return false;
        }
        if (inventory[index].equals(target)) {
            return true;
        }
        return containsItemRecursive(target, index + 1);
    }

    static void displayInventory() {
        if (inventoryCount == 0) {
            showMessage("[INVENTORY]\n\nYour inventory is empty.");
            return;
        }

        String list = "[INVENTORY]\n\n";
        for (int i = 0; i < inventoryCount; i++) {
            list += (i + 1) + ". " + inventory[i] + "\n";
        }
        showMessage(list);
    }

    // =====================================================================
    // FINAL INVESTIGATION
    // =====================================================================

    static void activateFinalInvestigation() {
        notebookAccessed = true;
        finalInvestigationActive = true;
    }

    static void investigateArtificialGrass() {
        // The discovery sequence plays only once.
        if (!doorDiscovered) {
            showMessage("[" + ARTIFICIAL_GRASS.toUpperCase() + "]\n\n" + GRASS_DISCOVERY_TEXT);
            doorDiscovered = true;
        }
        investigateHiddenDoor();
    }

    /*
     * Concealed Door Interaction Menu.
     * Leaving this method always returns the player to the Garden menu.
     */
    static void investigateHiddenDoor() {
        boolean atDoor = true;
        do {
            String menu = "[CONCEALED DOOR]\n\n"
                + "The concealed door contains a numerical keypad and an inscription.\n\n"
                + "What would you like to do?\n\n"
                + "[1] Read Inscription\n"
                + "[2] Enter Password\n"
                + "[3] Return to Garden";

            int choice = readMenuChoice(menu, 3);

            if (choice == -1 || choice == 3) {
                atDoor = false;
            } else if (choice == 1) {
                showMessage(DOOR_INSCRIPTION);
            } else if (choice == 2) {
                if (doorUnlocked) {
                    // An unlocked door does not ask for the password again.
                    startFinalDiscovery();
                    atDoor = false;
                } else if (enterPassword()) {
                    startFinalDiscovery();
                    atDoor = false;
                }
            }
        } while (atDoor);
    }

    /*
     * Returns true when the correct password is entered.
     * A wrong password or Cancel returns false (back to the door menu).
     */
    static boolean enterPassword() {
        String input;
        do {
            input = showInput("[KEYPAD]\n\nEnter the password:");

            if (input == null) {
                return false;
            }
            if (input.trim().isEmpty()) {
                showMessage("Please enter a password.");
            }
        } while (input.trim().isEmpty());

        if (input.trim().equals(FINAL_PASSWORD)) {
            doorUnlocked = true;
            showMessage(PASSWORD_CORRECT_TEXT);
            return true;
        }

        showMessage(PASSWORD_INCORRECT_TEXT);
        return false;
    }

    /*
     * Hidden chamber: the final riddle.
     * Return or Cancel goes back to the Garden menu; KUYA ends the game.
     */
    static void startFinalDiscovery() {
        if (showRiddle(FINAL_RIDDLE)) {
            showMessage(RIDDLE_CORRECT_TEXTS[FINAL_RIDDLE]);
            gameRunning = false;
            System.exit(0);
        }
    }

    // =====================================================================
    // INPUT, DIALOGS AND EXIT
    // =====================================================================

    static String dialogTitle() {
        if (detectiveName == null) {
            return GAME_TITLE;
        }
        return "Bahay ni Kuya - Detective " + detectiveName;
    }

    static void showMessage(String text) {
        JOptionPane.showMessageDialog(null, text, dialogTitle(), JOptionPane.PLAIN_MESSAGE);
    }

    static String showInput(String text) {
        return JOptionPane.showInputDialog(null, text, dialogTitle(), JOptionPane.PLAIN_MESSAGE);
    }

    /*
     * Shows a numbered menu and returns the chosen number (1 to maxOption).
     * Returns -1 if the player presses Cancel or closes the dialog.
     * Invalid input shows an error and the same menu again.
     */
    static int readMenuChoice(String menuText, int maxOption) {
        int choice = 0;
        do {
            String input = showInput(menuText + "\n\nEnter your choice:");

            if (input == null) {
                return -1;
            }

            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice < 1 || choice > maxOption) {
                showMessage("Invalid choice. Please enter a number from 1 to " + maxOption + ".");
                choice = 0;
            }
        } while (choice == 0);

        return choice;
    }

    /*
     * Asks whether to exit. Yes ends the game; No or Cancel returns
     * to whatever the player was doing.
     */
    static void confirmExit() {
        int choice = readMenuChoice(
            "Are you sure you want to exit the game?\n\n[1] Yes\n[2] No", 2);

        if (choice == 1) {
            gameRunning = false;
            System.exit(0);
        }
    }
}