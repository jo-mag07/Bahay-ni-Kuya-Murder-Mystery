```
• DEC-001 - Fixed Key Distribution

Date: 2026-11-09 | Time: 8:47PM
Status: Confirmed

### Decision
Keys will have fixed locations and will never be
randomly generated.

### Reason
The game requires a predetermined puzzle sequence.

### Impact
- Key locations must be documented.
- Puzzle rewards must remain consistent.
- Room progression must follow the established order.

### Related Files
- [[Game Mechanics]]
- [[Key Registry]]
- [[Main Game Flow]]
```

// We'll also maintain a separate chronological `Development Log.md` for actual progress.

<>

```
DEC-002 — Password System

Date: 2026-11-09 | Time: 9:25PM
Status: Confirmed

# 9364

Only one password puzzle exists.

|Clue source|Number|
|---|---|
|Confession Room — Wall Clock|9|
|Living Room — Floor Indicator|3|
|Girls Bedroom — Wardrobe|6|
|Garden — Flower Bed|4|

- The player must remember the numbers.
    
- A riddle establishes their correct sequence.
    
- The bloody numerical clues are discarded.
    
- No additional password puzzle will be invented.
    
    DEC-003 — Key Distribution
    
    Confirmed
    
- I can choose suitable objects to contain keys.
    
- I can design the corresponding riddles.
    
- Keys have predetermined locations and rewards.
    
- Other objects may provide descriptions, observations or useful clues without awarding keys.
    
- Each key must correspond to its designated room.
```

<>

```
DEC-003

EMPTY
```

<>

```
DEC-004 — Living Room Design

**Date:** 2026-11-11  
**Status:** Proposed  
**Category:** Location Design

### Decisions and Proposals

- Established three Living Room areas: Sofa, Dining and Elevator.
    
- Established eleven investigatable objects.
    
- Assigned the Confession Room Key to the Sofa Area's Rug.
    
- Created RD-001 with the answer CLOCK.
    
- Assigned CL-001 (Floor Indicator = 3).
    
- Established the Living Room as the starting navigation hub.
    

### Gameplay Behavior

- Ordinary objects display descriptions and a Return option.
    
- The Rug contains a hidden compartment.
    
- Incorrect answers allow retries.
    
- Correct answers award KY-001.
    
- The player can access the Confession Room after obtaining KY-001.
    

### Related Documentation

- [[Living Room]]
    
- [[Key Registry]]
    
- [[Game Progression]]
    
- [[Clue Registry]]
    
- [[Riddle Registry]]
    

### Approved Decisions

- Riddle answer: CLOCK.
- Dining Area: Four ordinary objects, no additional puzzle.
- Riddle retries: Unlimited attempts without penalty.

Status: Approved by project owner.
```

<>

```
## DEC-005 — Confession Room Design

**Date:** 2026-11-11

**Status:** Proposed

### Design Decisions

- Established six investigatable objects.
- Assigned the Garden Key to the Side Cabinet.
- Created RD-002 with the answer MICROPHONE.
- Assigned CL-002 (Wall Clock = 9 PM).
- Established the Confession Room as the second location.

### Gameplay Rules

- Ordinary objects display descriptions.
- The Side Cabinet contains the Garden Key puzzle.
- Incorrect answers allow unlimited retries.
- Correct answers award KY-002.
- The Garden remains locked until KY-002 is obtained.

### Related Documentation

- [[Confession Room]]
- [[Key Registry]]
- [[Game Progression]]
- [[Clue Registry]]
- [[Riddle Registry]]

### Pending Approval

Final approval of the Confession Room design.
```

<>

```
DEC-006 — Garden Design Approval

- **Decision ID:** DEC-006
- **Date:** 2026-11-11
- **Status:** Confirmed
- **Affected Location:** Garden (RM-003)

### Approved Decisions

1. The Garden contains six investigatable objects:
   - Flower Bed
   - Garden Bench
   - Bird Bath
   - Watering Can
   - Garden Lamp
   - Garden Statue
2. The Flower Bed displays four flowers, recording numerical clue CL-003.
3. The Garden Statue contains the Girls Bedroom Key puzzle.
4. The riddle answer is STATUE.
5. Correctly solving the riddle rewards Girls Bedroom Key (KY-003).
6. Incorrect answers have no penalty, and retries are unlimited.
7. Artificial Grass Floor becomes investigatable only after the Notebook puzzle in the Boys Bedroom is completed.
8. Investigating Artificial Grass Floor reveals the concealed passage and final password riddle.

### Notes

The Garden has two progression purposes: obtaining the Girls Bedroom Key and later discovering the concealed passage leading toward the final objective.

The hidden passage must remain unavailable during the first visit.

### Final Password

9364

The password itself must not be revealed to the player prematurely.
```

<>

```
DEC-007 — Girls Bedroom Design Approval

- **Decision ID:** DEC-007
- **Date:** 2026-11-11
- **Status:** Confirmed
- **Affected Location:** Girls Bedroom (RM-004)

### Approved Decisions

1. The Girls Bedroom contains six investigatable objects:
   - Wardrobe
   - Bed
   - Nightstand
   - Vanity Table
   - Vanity Mirror
   - Window
2. The Wardrobe displays six clothes, recording numerical clue CL-004.
3. The Vanity Table contains the Boys Bedroom Key puzzle.
4. The riddle answer is MIRROR.
5. Correctly solving the riddle rewards Boys Bedroom Key (KY-004).
6. Incorrect answers have no penalty, and retries are unlimited.
7. The key can only be collected once.

### Notes

The Vanity Table puzzle uses the mirror as its answer, making the player connect an object in the room to the concealed compartment.

The numerical clue must not be explicitly identified as part of the final password.
```

<>

```
DEC-008 — Boys Bedroom Design Approval

- **Decision ID:** DEC-008
- **Date:** 2026-11-11
- **Status:** Confirmed
- **Affected Location:** Boys Bedroom (RM-005)

### Approved Decisions

1. The Boys Bedroom contains six investigatable objects:
   - Study Desk
   - Bed
   - Nightstand
   - Bookshelf
   - Sports Bag
   - Window
2. The Study Desk contains the special Notebook.
3. The Notebook riddle answer is NOTEBOOK.
4. The Notebook is a special progression item, not a key.
5. Correctly solving the riddle grants access to the Notebook contents.
6. The Notebook message activates the final investigation phase.
7. The Artificial Grass Floor becomes available in the Garden only after the Notebook is accessed.
8. Unlimited retries are allowed, with no penalty for incorrect answers.
9. No additional key is rewarded in the Boys Bedroom.

### Notes

The Boys Bedroom is the final normal investigation location.

Its main purpose is to transition the player from the normal room-and-key progression into the final investigation phase.
```

<>

```
DEC-009 — Final Garden Investigation Approval

- **Decision ID:** DEC-009
- **Date:** 2026-11-11
- **Status:** Confirmed
- **Affected Location:** Garden (RM-003)
- **Affected Phase:** Final Investigation (FP-001)

### Approved Decisions

1. Artificial Grass Floor becomes investigatable only after Notebook access.
2. Investigating Artificial Grass Floor reveals a concealed door.
3. The concealed door displays the approved four-room inscription.
4. The final password is 9364.
5. The password sequence is:
   - Confession Room — 9
   - Living Room — 3
   - Girls Bedroom — 6
   - Garden — 4
6. Correct password entry opens the concealed door.
7. The player enters a hidden chamber beneath the Garden.
8. The final riddle answer is KUYA.
9. Correctly answering KUYA reveals Kuya and immediately ends the game.
10. Unlimited password and riddle attempts are allowed, with no penalty.

### Final Riddle

"I was hidden from every eye.

Beneath the place where flowers lie.

No footsteps lead to where I stay.

Yet here I rest, concealed away.

What is it that you have come to find?"

**Answer:** KUYA

### Ending Rules

- The investigation ends immediately after Kuya is discovered.
- No additional detective report or investigation follows.
- The game does not investigate the murderer's identity, motive, or guilt.

### Notes

This decision completes the game's main investigation progression, from the Living Room through the final discovery beneath the Garden.
```

<>

```
DEC-010 — Implementation Audit Decisions

- **Status:** Confirmed
    
- **Purpose:** Establish consistent rules for resolving ISS-001 through ISS-025 before Claude implementation.
    

### Confirmed Decisions

1. Use `Main Living Room Menu` as the authoritative Living Room menu.
    
2. Inventory displays acquired keys and the Notebook only. Numerical clues are not inventory items.
    
3. Mark `exe.md` as superseded. Retain only its locked-room message as a reference for ISS-008.
    
4. Use IT-001 as the Notebook's correct item ID.
    
5. Use the confirmed Garden documentation as the authoritative object list.
    
6. RD-006 incorrect answer: offer Try Again or Return. Return leads to the Garden menu.
    
7. Incorrect final password: display an error message and allow another attempt.
    
8. Main menu Exit requires confirmation.
    
9. Room menus contain their available objects, Inventory, and Return to Living Room.
    
10. Follow Java Technical Specification §10 instead of outdated method registries and program structure tables.
    
11. Designer-only labels must not appear in player-facing descriptions.
    
12. Display riddle titles without internal IDs.
    
13. Use 9:00 PM for the Confession Room Wall Clock.
    
14. Optional riddle hints will not be implemented.
    
15. Use the detective name in the introduction and dialog title bars without modifying approved narrative text.
    
16. Use English throughout the game.
    
17. Empty input and dialog cancellation must be handled separately.
    
18. Use `System.exit(0)` for confirmed game termination and after the final discovery.
    
19. Use ASCII hyphens in source strings or compile with UTF-8 encoding.
    
20. Use typed numerical menu input through `JOptionPane.showInputDialog()`.
    

### Related Issues

ISS-001 through ISS-025.

### Implementation Rule

These decisions must be followed unless the project owner explicitly approves a change.
```

<>

```
DEC-011 — Implementation Answers (A1–A10)

- **Date:** 2026-11-11
- **Status:** Confirmed (except item marked PROPOSED)

### Confirmed Decisions

1. Girls Bedroom: the "A vanity table sits neatly arranged..." text belongs to the Vanity Table.
   Vanity Mirror (PROPOSED, awaiting approval):
   "A mirror is mounted above the vanity table. Its glass is clean, and it shows nothing but your own reflection."
2. The Confession Room clock is named "Broken Wall Clock" in all docs and in the game.
3. Confession Room shows only §1.2 Room Entry Message in-game. §1.1 Overview is developer documentation.
4. Opening order: Dialogue 1 → detective name → Dialogue 2 → Dialogue 3 → Opening Room Description.
   Only the three Dialogue blocks of the Storyline are displayed.
5. Every puzzle object has an action option (like "Lift the Rug"), then discovery text, then the riddle:

| Object | Action | Discovery Text |
|---|---|---|
| Rug | Lift the Rug | (existing approved text) |
| Side Cabinet | Open the Cabinet | You open the cabinet and look through its contents. / Behind the ordinary items, you discover a small compartment built into the back of the cabinet. It appears to have been deliberately concealed. / A short riddle is written on its surface. / Perhaps solving it will reveal what is inside. |
| Garden Statue | Inspect the Statue's Base | You kneel down and inspect the base of the statue. / Near the bottom, you notice a thin seam in the stone, as if part of the base could open. / A short riddle is carved beside it. / Perhaps solving it will reveal what is inside. |
| Vanity Table | Check the Drawers | You open the drawers one by one. They contain only small personal belongings. / As you close the last drawer, you notice a small compartment hidden beneath the surface of the table. / A short riddle is written on its cover. / Perhaps solving it will reveal what is inside. |
| Study Desk | Pick Up the Notebook | You pick up the Notebook from the desk. / Its cover is held shut by a small clasp. A short riddle is written across the front. / Perhaps solving it will let you read what is inside. |

6. Revisiting a solved puzzle (after choosing its action):
   - Rug: "The compartment is already open. There is nothing else inside."
   - Side Cabinet: "The concealed compartment is already open. The Garden Key has already been collected."
   - Garden Statue: "The statue's concealed compartment is already open. The Girls Bedroom Key has already been collected."
   - Vanity Table: "The concealed compartment is already open. The Boys Bedroom Key has already been collected."
   - Study Desk: "The Notebook has already been read."
7. RD-003, RD-004 and RD-005 correct responses start with "[CORRECT ANSWER]", like RD-001/002.
   RD-003 and RD-004 end with:
   ITEM OBTAINED: GIRLS BEDROOM KEY / This key grants access to the Girls Bedroom.
   ITEM OBTAINED: BOYS BEDROOM KEY / This key grants access to the Boys Bedroom.
8. All menus, including exit confirmation, use typed "[1]" / "[2]" numbering.
9. Ordinary and clue objects use a message dialog; pressing OK returns to the menu.
10. Concealed door follows Final Garden Investigation §4.1 and the flowchart (inscription via
    "Read Inscription"). The correct password response leads straight to the final riddle.
```