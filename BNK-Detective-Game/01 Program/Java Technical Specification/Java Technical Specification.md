# Bahay ni Kuya — Java Technical Specification

## 1. Document Information

```
- **Project:** Bahay ni Kuya — Murder Mystery
    
- **Programming Language:** Java
    
- **User Interface:** JOptionPane
    
- **Development Environment:** Visual Studio Code
    
- **Specification Status:** Draft
    
- **Purpose:** Define the technical requirements, program structure, data organization, and implementation rules for the game.
```

---

## 2. Project Overview

Bahay ni Kuya is a text-based detective and exploration game developed in Java.

The player assumes the role of a detective whose objective is to discover Kuya's hidden body somewhere inside Bahay ni Kuya.

The game uses JOptionPane for all player interactions, including:

```
- Displaying story and descriptions.
    
- Presenting menus and choices.
    
- Receiving player answers.
    
- Displaying clues and riddles.
    
- Showing inventory.
    
- Confirming game progression.
```

The game follows a fixed progression through five locations. Players obtain predetermined keys by solving riddles and eventually unlock the final investigation.

The game does not investigate the murderer's identity, motive, or guilt.

---

## 3. Required Java Constructs

The implementation must demonstrate the following programming constructs:

|Java Construct|Required Purpose|
|---|---|
|`JOptionPane`|All player-facing interactions|
|Methods|Separate game operations into manageable functions|
|`do-while` loop|Repeat menus and allow unlimited riddle attempts|
|`for` loop|Iterate through arrays, inventory, and room objects|
|Recursion|Perform a recursive inventory-item search|
|Arrays|Store room information, objects, keys, and inventory data|

### 3.1 User Input and Dialog Methods

The game must use `JOptionPane` for all player interactions.

#### Menu Selections

All game menus must use `JOptionPane.showInputDialog()` for numerical input.

The player must type the number corresponding to their desired option.

Examples include:

```
- Main Living Room Menu
    
- Room Investigation Menus
    
- Go To Location Menu
    
- Inventory Menu, if applicable
    
- Puzzle retry and return choices
    
- Concealed Door Interaction Menu
    
- Exit Confirmation Menu
```

Do not use `showOptionDialog()` or button-based selection menus for game navigation.

#### Input Validation

```
- Validate that the player's input is a valid number.
    
- Validate that the selected number corresponds to an available menu option.
    
- If the input is invalid, display an appropriate error message and show the current menu again.
    
- Invalid input must not crash or terminate the game.
```

#### Text-Based Input

Use `JOptionPane.showInputDialog()` for text-based responses, including:

```
- Detective name
    
- Riddle answers
    
- Final password
```

#### Cancellation and Empty Input

Handle cancellation and empty input separately.

- A cancelled dialog returns `null` and must follow the cancellation rules in Section 12.
    
- An empty submission returns an empty string and must be handled as invalid or empty input.
    
- Neither condition must cause an unexpected game termination or program crash.
    

The cancellation behavior defined in Section 12 remains authoritative.

### 3.2 Methods

Separate responsibilities into methods rather than placing the entire game inside `main()`.

Each method should have one clear responsibility.

### 3.3 do-while Loop

Use do-while loops for:

```
- Repeating the main game menu.
    
- Repeating room object menus.
    
- Allowing unlimited riddle attempts.
    
- Allowing unlimited final password attempts.
```

### 3.4 for Loop

Use for loops to:

```
- Display available room objects.
    
- Display inventory items.
    
- Search through stored game data.
    
- Process arrays of keys and room information.
```

### 3.5 Recursion

```
Use recursion for a bounded inventory-item search.

For example, a recursive method can check whether a specific key exists in the inventory array.

The search must stop when the target is found or the end of the array is reached.

Recursion must have a clear base case to prevent infinite recursion.
```

### 3.6 Arrays

Use arrays to organize:

```
- Location names and identifiers.
    
- Room object names.
    
- Key identifiers and names.
    
- Inventory entries.
    
- Other fixed game data where appropriate.
```

Avoid unnecessary duplication of information.

---

## 4. Game Structure

The game consists of five normal investigation locations and one final investigation phase.

|Location ID|Location|Access Requirement|
|---|---|---|
|RM-001|Living Room|Initially accessible|
|RM-002|Confession Room|KY-001|
|RM-003|Garden|KY-002|
|RM-004|Girls Bedroom|KY-003|
|RM-005|Boys Bedroom|KY-004|
|FP-001|Final Garden Investigation|Notebook accessed|

### 4.1 Living Room

The Living Room is the starting location and main hub.

It contains three investigation areas:

```
- Sofa Area
    
- Dining Area
    
- Elevator Area
```

The Sofa Area contains the Rug puzzle, which awards the Confession Room Key.

The Elevator Area contains the Floor Indicator numerical clue (3).

The Dining Area contains four ordinary objects.

### 4.2 Confession Room

Contains six objects.

```
- Wall Clock — Numerical clue (9 PM).
    
- Confession Chair — Ordinary object.
    
- Microphone — Ordinary object.
    
- Camera — Ordinary object.
    
- Side Cabinet — Puzzle object; awards Garden Key.
    
- Wall Panels — Ordinary object.
```

### 4.3 Garden

Contains six objects.

```
- Flower Bed — Numerical clue (4).
    
- Garden Bench — Ordinary object.
    
- Bird Bath — Ordinary object.
    
- Watering Can — Ordinary object.
    
- Garden Lamp — Ordinary object.
    
- Garden Statue — Puzzle object; awards Girls Bedroom Key.
```

The Artificial Grass Floor becomes available only after the Notebook has been accessed.

### 4.4 Girls Bedroom

Contains six objects.

```
- Wardrobe — Numerical clue (6).
    
- Bed — Ordinary object.
    
- Nightstand — Ordinary object.
    
- Vanity Table — Puzzle object; awards Boys Bedroom Key.
    
- Vanity Mirror — Ordinary object.
    
- Window — Ordinary object.
```

### 4.5 Boys Bedroom

Contains six objects.

```
- Study Desk — Special puzzle object containing the Notebook.
    
- Bed — Ordinary object.
    
- Nightstand — Ordinary object.
    
- Bookshelf — Ordinary object.
    
- Sports Bag — Ordinary object.
    
- Window — Ordinary object.
```

The Notebook is a special progression item, not a room key.

---

## 5. Key and Inventory System

There are four fixed keys.

|Key ID|Key Name|Obtained From|Unlocks|
|---|---|---|---|
|KY-001|Confession Room Key|Living Room Rug|Confession Room|
|KY-002|Garden Key|Confession Room Side Cabinet|Garden|
|KY-003|Girls Bedroom Key|Garden Statue|Girls Bedroom|
|KY-004|Boys Bedroom Key|Girls Bedroom Vanity Table|Boys Bedroom|

### 5.1 Key Rules

```
- Each key has a predetermined location and reward.
    
- Keys cannot be obtained randomly.
    
- Each key unlocks only its designated room.
    
- A key is added to inventory only after solving its corresponding riddle.
    
- Duplicate key collection must be prevented.
    
- Incorrect answers never award keys.
```

### 5.2 Notebook

```
- **Item ID:** IT-001
    
- **Item Name:** Notebook
    
- **Item Type:** Special Progression Item
    
- **Obtained From:** Boys Bedroom Study Desk
    
- **Purpose:** Activates the final investigation phase.
```

The Notebook must not be treated as an ordinary room-unlocking key.

### 5.3 Inventory Display Rules

The player's inventory must display only:

```
1. Acquired room keys.
    
2. The Notebook (IT-001), if successfully accessed.
```

```
Numerical clues must not appear in the inventory.

The player must remember numerical clues independently and may revisit the corresponding rooms to inspect them again.

The inventory must not display uncollected keys or items.

Previously acquired keys and the Notebook must remain recorded when the player revisits rooms.
```

---

## 6. Clue and Password System

The game contains four numerical clues.

|Clue ID|Location|Object|Numerical Value|
|---|---|---|---|
|CL-001|Living Room|Floor Indicator|3|
|CL-002|Confession Room|Wall Clock|9|
|CL-003|Garden|Flower Bed|4|
|CL-004|Girls Bedroom|Wardrobe|6|

### 6.1 Numerical Clue Rules

```
- Display the numerical value when the player investigates its corresponding object.
    
- Do not explicitly identify the value as part of a password.
    
- The player must remember the discovered values.
    
- The clues are not collectible inventory items.
    
- Players may revisit the rooms and inspect the objects again.
```

### 6.2 Final Password

```
- **Password ID:** PW-001
    
- **Password:** 9364
```

Required sequence:

```
1. Confession Room — 9
    
2. Living Room — 3
    
3. Girls Bedroom — 6
    
4. Garden — 4
```

The final password must be validated when the player investigates the concealed door.

---

## 7. Riddle System

The game contains six riddles.

|Riddle ID|Location / Object|Correct Answer|Reward|
|---|---|---|---|
|RD-001|Living Room Rug|CLOCK|KY-001|
|RD-002|Confession Room Side Cabinet|MICROPHONE|KY-002|
|RD-003|Garden Statue|STATUE|KY-003|
|RD-004|Girls Bedroom Vanity Table|MIRROR|KY-004|
|RD-005|Boys Bedroom Study Desk|NOTEBOOK|IT-001|
|RD-006|Final Hidden Chamber|KUYA|Completes Game|

### 7.1 Answer Validation

```
- Answers must be case-insensitive.
    
- Remove unnecessary leading and trailing spaces before comparison.
    
- Incorrect answers must not grant rewards.
    
- Riddle attempts are unlimited.
    
- Incorrect answers have no penalty.
    
- The player may choose Try Again or Return where applicable.
    
- Previously obtained rewards must not be awarded again.
```

### 7.2 Riddle Rewards

```
Each puzzle has one predetermined result.

The program must not generate random rewards or substitute a different key.
```

---

## 8. General Object Investigation Rules

### 8.1 Ordinary Objects

When an ordinary object is selected:

```
1. Display its approved description.
    
2. Provide a Return option.
    
3. Return the player to the current room's object menu.
```

### 8.2 Numerical Clue Objects

When a numerical clue object is selected:

```
1. Display the approved observation.
    
2. Reveal its numerical value.
    
3. Allow the player to return to the current room's object menu.
```

### 8.3 Puzzle Objects

When a puzzle object is selected:

```
1. Display its approved riddle.
    
2. Receive the player's answer.
    
3. Validate the answer.
    
4. If incorrect, offer Try Again or Return.
    
5. If correct, provide the predetermined reward.
    
6. Return the player to the current room's object menu.
```

### 8.4 Room Navigation

```
- The player enters rooms through the Go To menu.
    
- Rooms require their designated keys.
    
- Selecting a locked room displays an appropriate message.
    
- Returning from a room takes the player back to the Living Room hub.
    
- Returning from an object takes the player back to the current room's object menu.
```

### 8.5 Room Menu Contents

Every investigation room must display a room-specific menu containing:

```
1. All investigatable objects available in that room.
    
2. Inventory.
    
3. Return to Living Room.
```

The menu must use numbered options. The player selects an option by entering its corresponding number.

#### Special Menu Rules

```
- The Living Room uses the `Main Living Room Menu` defined in `00 Main/Living Room.md`. Do not replace it with the standard room menu.
    
- The Garden must display the Artificial Grass Floor as an additional investigation option only after the Notebook (IT-001) has been successfully accessed.
    
- The Artificial Grass Floor must not appear in the Garden menu before the Final Investigation Phase is activated.
    
- Each room menu must display only the objects belonging to that room, along with the applicable menu options.
    
- Selecting Inventory displays the player's currently acquired keys and the Notebook, if accessed.
    
- Selecting Return to Living Room returns the player to the Living Room hub.
```

The room menu must remain consistent when the player revisits a location. Previously collected keys and accessed items must retain their progress.

### 8.6 Player-Facing Display Rules

The game must display only descriptions and messages intended for the player.

The following are developer-only labels and must never appear in player-facing dialogs, menus, or object descriptions:

```
- Ordinary object
    
- Numerical clue
    
- Puzzle object
    
- Special progression item
    
- Internal object IDs
    
- Internal clue IDs
    
- Internal riddle IDs
    
- Internal key IDs
```

These labels exist only to help organize and document the game's implementation.

When displaying an object, show its approved player-facing name and description without developer annotations.

When displaying acquired items, use their player-facing names rather than internal IDs.

### 8.7 Riddle Display Rules

When presenting a puzzle to the player:

```
- Display the approved riddle title.
    
- Display the riddle text exactly as documented in the Riddle Registry.
    
- Never display the internal riddle ID (RD-001, RD-002, etc.).
    
- Do not display the answer or developer-only notes.
    
- Do not display optional hints. Optional hints are documentation-only and are not part of the gameplay.
```

Internal riddle IDs must only be used for documentation and implementation reference.

### 8.8 Detective Name Usage

The detective name entered at the beginning of the game must be retained and used throughout the appropriate player-facing interactions.

Rules:
```
- Use the detective's chosen name in the game introduction where `[Name]` is specified.
    
- Use the detective's chosen name in dialog title bars where appropriate.
    
- Replace `[Name]` placeholders in approved dialogue with the player's actual detective name.
    
- Do not arbitrarily insert the detective's name into other approved narrative text.
    
- Do not modify the wording of approved narrative messages merely to include the detective's name.
```

---

## 9. Final Investigation System

`The final investigation begins after the player solves RD-005 and accesses IT-001.`

### 9.1 Notebook Contents

```
Display the following text:

"You have access to every room in this house.

But finding the keys was only the beginning.

Return to each room. Look closely. There is evidence you have yet to understand.

Do not overlook anything."
```

### 9.2 Notebook Activation

After accessing the Notebook:

```
- Activate the final investigation phase.
    
- Allow the player to revisit the rooms.
    
- Make the Artificial Grass Floor available in the Garden.
    
- Preserve the player's previously obtained keys and progress.
```

### 9.3 Concealed Door

When the player investigates the Artificial Grass Floor:

```
1. Display the approved discovery description.
    
2. Reveal the concealed door.
    
3. Display the door inscription.
    
4. Let the player determine the numerical clue order.
    
5. Receive the final password.
    
6. Validate PW-001 (9364).
```

`Incorrect passwords must not unlock the door. The player may retry without penalty.`

### 9.4 Final Hidden Chamber

After the concealed door is unlocked:

```
1. Allow the player to enter the hidden chamber.
    
2. Display RD-006.
    
3. Receive the player's answer.
    
4. Validate the answer KUYA.
```

If the answer is incorrect, allow another attempt.

If the answer is correct:

```
- Reveal Kuya's hidden body.
    
- Display the investigation completion message.
    
- Immediately terminate the game.
```

No additional detective report or post-discovery investigation is required.

---

## 10. Proposed Program Organization

The initial implementation should prioritize readability and manageable complexity.

The recommended starting structure is one main Java class with clearly separated methods.

Suggested method responsibilities:

|Method|Responsibility|
|---|---|
|`main()`|Start the game and initialize its state|
|`startGame()`|Handle the opening sequence|
|`enterDetectiveName()`|Receive the detective name|
|`displayStoryline()`|Present the introduction and suspect's clue|
|`showMainMenu()`|Display the Living Room hub options|
|`showLocationMenu()`|Display available locations|
|`enterRoom()`|Handle entering a selected room|
|`showRoomMenu()`|Display a room's available objects|
|`investigateObject()`|Handle object selection|
|`displayObjectDescription()`|Display ordinary object descriptions|
|`showRiddle()`|Display a puzzle and receive an answer|
|`validateAnswer()`|Compare the player's answer|
|`addInventoryItem()`|Add an obtained item|
|`containsItemRecursive()`|Recursively search the inventory|
|`displayInventory()`|Display acquired keys and items|
|`displayClue()`|Display a numerical clue|
|`activateFinalInvestigation()`|Update the final investigation state|
|`investigateHiddenDoor()`|Handle the concealed door and password|
|`startFinalDiscovery()`|Handle the final riddle and ending|

These are proposed responsibilities, not mandatory final method signatures. They may be adjusted during implementation as long as all required functionality remains intact.

---

## 11. Game State and Data Management

The program must maintain the following information while running:

```
- Detective name.
    
- Current location.
    
- Acquired keys.
    
- Inventory items.
    
- Notebook access status.
    
- Final investigation activation status.
    
- Game-running status.
```

Suggested Boolean state variables:

- `notebookAccessed`
    
- `finalInvestigationActive`
    
- `gameRunning`

Key ownership and inventory information must remain consistent.

The game must not reset acquired keys or Notebook progress when the player revisits a room.

All game progress is maintained during the current game session. Persistent saving and loading are not required in the initial version.

---

## 12. Input Validation, Cancellation, and Error Handling

The program must handle invalid input and dialog cancellation consistently.

### 12.1 General Input Validation

The program must handle:

```
- Empty detective names.
    
- Empty riddle answers.
    
- Incorrect riddle answers.
    
- Incorrect passwords.
    
- Invalid menu selections.
    
- Attempts to enter locked rooms.
    
- Attempts to collect an already-owned key.
    
- Cancellation of an input or option dialog.
```

Invalid input must not accidentally grant rewards, unlock rooms, or corrupt game progress.

### 12.2 Dialog Cancellation Rules

When the player presses Cancel or closes a dialog, the program must follow these behaviors:

|Situation|Required Behavior|
|---|---|
|Cancel detective name|Ask whether to exit the game. If No, return to detective name input.|
|Cancel main menu|Ask whether to exit the game. If No, return to the main menu.|
|Cancel room menu|Return to the Living Room hub.|
|Cancel riddle answer|Return to the current room's object menu.|
|Cancel password input|Return to the concealed door interaction.|

### 12.3 Exit Confirmation

When the player cancels the detective name input or main menu, display an exit confirmation dialog.

```
- If the player selects Yes, terminate the game.
    
- If the player selects No, return to the appropriate input or menu.
    
- Do not terminate the game merely because a dialog was cancelled.
```

### 12.4 Cancellation and Game Progress

```
- Cancelling a dialog must not grant a reward.
    
- Cancelling a dialog must not remove previously acquired keys.
    
- Cancelling a dialog must not reset Notebook access.
    
- Cancelling a dialog must not reset the final investigation phase.
    
- Returning from a dialog must follow the specified destination.
    
- Cancellation must not cause the program to crash or become stuck in an unintended menu.
```

### 12.5 Additional Error Handling

All menu selections and player inputs must be validated before the program performs the corresponding action.

The game must handle cancellation separately from ordinary incorrect answers.

---

## 13. Technical Restrictions

The initial version must:

```
- Use Java.
    
- Use JOptionPane for player interaction.
    
- Avoid console-based Scanner input.
    
- Avoid unnecessary external libraries.
    
- Avoid database integration.
    
- Avoid network access.
    
- Avoid randomized keys, clues, riddles, or rewards.
    
- Follow the approved game documentation.
    
- Keep methods readable and responsibilities separated.
    
- Use the required Java constructs meaningfully.
```

---

## 14. Related Documentation

- [[Storyline]]
    
- [[Location Registry]]
    
- [[Living Room]]
    
- [[Confession Room]]
    
- [[Garden]]
    
- [[Girls Bedroom]]
    
- [[Boys Bedroom]]
    
- [[Game Progression]]
    
- [[Key Registry]]
    
- [[Notebook]]
    
- [[Final Garden Investigation]]
    
- [[Documentation Audit]]
    

### Flowcharts

- [[Main Game Flowchart (Direct)]]
    
- [[Room Investigation Flowchart]]
    
- [[Key Location Flowchart]]
    
- [[Final Investigation]]

### Hint Guide

- [[Clues]]
    
- [[Riddles]]
    
- [[Password]]
    
- [[Key Registry]]


---

## 15. Specification Approval

- [x] Program structure reviewed.
- [x] Required Java constructs confirmed.
- [x] Data organization confirmed.
- [x] Input and error handling confirmed.
- [x] Technical restrictions confirmed.
- [x] Ready for testing documentation.
- [x] Ready for Claude prompt engineering.

**Specification Status:** `Approved`