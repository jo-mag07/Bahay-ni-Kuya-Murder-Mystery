## Stage 01 — Living Room

**Initial State:** Unlocked

### Available Areas

- Sofa Area
    
- Dining Area
    
- Elevator Area
    

### Required Objective

Investigate the Sofa Area and solve the riddle hidden underneath the Rug.

### Required Answer

CLOCK

### Reward

Confession Room Key (KY-001)

### Additional Discovery

Floor Indicator displays 3 (CL-001).

### Next Destination

Confession Room.

### Completion Condition

The player obtains the Confession Room Key.

---

## Stage 02 — Confession Room

**Unlock Requirement:** Confession Room Key (KY-001)

### Available Objects

1. Wall Clock
2. Confession Chair
3. Microphone
4. Camera
5. Side Cabinet
6. Wall Panels

### Required Objective

Investigate the Side Cabinet and solve RD-002.

### Required Answer

MICROPHONE

### Reward

Garden Key (KY-002).

### Additional Discovery

Wall Clock displays 9 PM (CL-002).

### Next Destination

Garden.

### Completion Condition

The player obtains the Garden Key.

---

## Stage 03 — Garden

**Room ID:** RM-003  
**Access Requirement:** Garden Key (KY-002)  
**Next Key Reward:** Girls Bedroom Key (KY-003)

### Investigation Objects

1. Flower Bed — numerical clue CL-003, value 4.
2. Garden Bench — ordinary object.
3. Bird Bath — ordinary object.
4. Watering Can — ordinary object.
5. Garden Lamp — ordinary object.
6. Garden Statue — puzzle object.

### Required Puzzle

- **Puzzle ID:** RD-003
- **Object:** Garden Statue
- **Correct Answer:** STATUE
- **Reward:** Girls Bedroom Key (KY-003)

### Completion Conditions

1. Player investigates the Garden Statue.
2. Player solves RD-003.
3. The concealed compartment opens.
4. Player obtains KY-003.
5. Girls Bedroom becomes accessible.

### Important Numerical Clue

- CL-003: Flower Bed displays 4.
- The game does not explain its password significance.

### Conditional Return Event — After Notebook Puzzle

The Artificial Grass Floor must not be available during the player's first Garden visit.

After the player solves the Notebook puzzle in the Boys Bedroom:

1. The player is informed that all rooms are now open and should be revisited for crucial evidence.
2. The player returns to the Garden.
3. Artificial Grass Floor becomes an available investigation option.
4. Investigating it reveals a concealed door.
5. The concealed door presents the final password riddle.
6. The player must enter the correct password: 9364.

**Important:** The Garden's hidden passage is part of the final objective, not the normal key progression.

---

## Stage 04 — Girls Bedroom

**Room ID:** RM-004  
**Access Requirement:** Girls Bedroom Key (KY-003)  
**Next Key Reward:** Boys Bedroom Key (KY-004)

### Investigation Objects

1. Wardrobe — numerical clue CL-004, value 6.
2. Bed — ordinary object.
3. Nightstand — ordinary object.
4. Vanity Table — puzzle object.
5. Vanity Mirror — ordinary object.
6. Window — ordinary object.

### Required Puzzle

- **Puzzle ID:** RD-004
- **Object:** Vanity Table
- **Correct Answer:** MIRROR
- **Reward:** Boys Bedroom Key (KY-004)

### Completion Conditions

1. Player investigates the Vanity Table.
2. Player solves RD-004.
3. The concealed compartment opens.
4. Player obtains KY-004.
5. Boys Bedroom becomes accessible.

### Important Numerical Clue

- CL-004: Wardrobe displays six clothes.
- The game does not explain its password significance.

### Retry Rules

- Unlimited attempts.
- No penalty for incorrect answers.
- Player may return without losing progress.
- The key can only be collected once.

---

## Stage 05 — Boys Bedroom

## Stage 05 — Boys Bedroom

**Room ID:** RM-005  
**Access Requirement:** Boys Bedroom Key (KY-004)  
**Key Reward:** None  
**Special Item:** Notebook (IT-001)

### Investigation Objects

1. Study Desk — special puzzle object containing the Notebook.
2. Bed — ordinary object.
3. Nightstand — ordinary object.
4. Bookshelf — ordinary object.
5. Sports Bag — ordinary object.
6. Window — ordinary object.

### Required Puzzle

- **Puzzle ID:** RD-005
- **Object:** Study Desk
- **Special Item:** Notebook (IT-001)
- **Correct Answer:** NOTEBOOK
- **Reward:** Access to Notebook contents.

### Completion Conditions

1. Player investigates the Study Desk.
2. Player discovers the Notebook.
3. Player solves RD-005.
4. Notebook contents are displayed.
5. The final investigation phase is activated.

### Notebook Message

"You have access to every room in this house.

But finding the keys was only the beginning.

Return to each room. Look closely. There is evidence you have yet to understand.

Do not overlook anything."

### Stage 05 Completion Effect

After the Notebook is accessed:

- The player can revisit previously explored rooms.
- The Artificial Grass Floor becomes available in the Garden.
- The player can investigate the Artificial Grass Floor.
- The concealed door and final password riddle are revealed.

### Important Rules

- The Notebook is a special progression item, not a key.
- No additional room key is rewarded in this stage.
- The Notebook puzzle has unlimited retries.
- Incorrect answers have no penalty.
- The Notebook only needs to be accessed once.
- The Artificial Grass Floor must not appear before the Notebook puzzle is solved.

### Next Objective

Return to the Garden and investigate the newly available Artificial Grass Floor.

---

## Stage 06 — Final Investigation

# Final Phase — Garden Concealed Passage

**Phase ID:** FP-001  
**Location:** Garden  
**Trigger:** Notebook (IT-001) accessed in Boys Bedroom.

## Stage 06 — Return to Garden

### Activation Conditions

1. Player solves RD-005 in the Boys Bedroom.
2. Notebook contents are displayed.
3. Final investigation phase is activated.
4. Player returns to the Garden.

### Newly Available Investigation Object

- Artificial Grass Floor

### Discovery

When investigated, the Artificial Grass Floor reveals a concealed door beneath it.

The door contains a numerical keypad and an inscription.

## Stage 07 — Concealed Door

### Door Inscription

"Four rooms hold what you seek.

First, where secrets are confessed.

Then, where everyone gathers.

Next, where the mirrors tell their tales.

Finally, where flowers quietly bloom.

Remember what you have seen.

Let their numbers reveal the way."

### Required Password

- **Password ID:** PW-001
- **Correct Password:** 9364

### Password Sequence

1. Confession Room — 9
2. Living Room — 3
3. Girls Bedroom — 6
4. Garden — 4

### Completion Condition

The player enters 9364 correctly.

The concealed door unlocks and the player enters the hidden chamber.

## Stage 08 — Hidden Chamber

### Final Riddle

- **Riddle ID:** RD-006
- **Correct Answer:** KUYA

"I was hidden from every eye.

Beneath the place where flowers lie.

No footsteps lead to where I stay.

Yet here I rest, concealed away.

What is it that you have come to find?"

### Final Discovery

When the player correctly answers KUYA:

1. Kuya is discovered beneath the Garden.
2. The investigation is marked complete.
3. The game ends immediately.

### Final Rules

- Unlimited password attempts.
- Unlimited final riddle attempts.
- Incorrect answers have no penalty.
- The game does not investigate the murderer's identity, motive, or guilt.
- No additional investigation follows the discovery of Kuya.