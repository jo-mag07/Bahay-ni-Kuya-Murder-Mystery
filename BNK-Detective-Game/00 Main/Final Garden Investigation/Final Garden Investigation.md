## Investigation Information

- **Phase ID:** FP-001
- **Location:** Garden
- **Trigger:** Notebook (IT-001) successfully accessed
- **Investigation Object:** Artificial Grass Floor
- **Final Password:** 9364
- **Final Riddle ID:** RD-006
- **Final Riddle Answer:** KUYA
- **Status:** Confirmed

## 1. Activation Condition

```
The final investigation phase becomes available only after the player solves the Notebook puzzle in the Boys Bedroom.

Once activated:

1. The player receives the Notebook's message.
2. The player returns to the Garden.
3. Artificial Grass Floor becomes available as an investigation option.

The object must remain unavailable before this condition is met.
```

## 2. Artificial Grass Floor

```
When investigated, the game displays:

"Something feels unusual beneath your feet.

You kneel down and inspect the artificial grass more closely.

Part of the flooring seems loose.

After lifting it, you discover a concealed door underneath."

The concealed door contains a numerical keypad and an inscription.
```

## 3. Concealed Door Inscription

```
"Four rooms hold what you seek.

First, where secrets are confessed.

Then, where everyone gathers.

Next, where the mirrors tell their tales.

Finally, where flowers quietly bloom.

Remember what you have seen.

Let their numbers reveal the way."
```

### Password Sequence

| Order | Location | Clue | Value |
|---|---|---|---:|
| 1 | Confession Room | Wall Clock | 9 |
| 2 | Living Room | Floor Indicator | 3 |
| 3 | Girls Bedroom | Wardrobe | 6 |
| 4 | Garden | Flower Bed | 4 |

**Final Password:** `9364`

## 4. Password Validation

- **Password ID:** PW-001
- **Correct Password:** 9364
- Incorrect answers do not open the door.
- Unlimited attempts are allowed.
- Incorrect attempts have no penalty.

### Correct Response

```
"A mechanical clicking sound echoes beneath the floor.

The concealed door slowly unlocks.

You carefully pull it open."
```

### Incorrect Response

```
"Nothing happens.

The concealed door remains locked."
```

## 4.1 Concealed Door Interaction

```
After discovering the concealed door, the player can interact with it through the following options:

1. Read Inscription
    
2. Enter Password
    
3. Return to Garden
```

### Read Inscription

```
- Display the concealed door inscription.
    
- After displaying it, return to the concealed door interaction menu.
```

### Enter Password

```
- Display the password input dialog.
    
- The player may enter the final password.
    
- If the password is incorrect, display the incorrect response and return to the concealed door interaction menu.
    
- If the password is correct, set the door's state to unlocked and display the correct response.
    
- The player then enters the Hidden Chamber.
```

### Return to Garden

```
- Return the player to the Garden menu.
    
- The concealed door remains discovered.
```

### Cancellation

```
If the player cancels the password input, return to the concealed door interaction menu without changing the door's state.
```

### Door State and Repeated Interaction

```
- Before discovery, the concealed door cannot be interacted with.
    
- After discovery, the door remains available even if the player leaves the Garden.
    
- Once unlocked, the door must not require the password again.
    
- If the player interacts with an already-unlocked door, allow entry into the Hidden Chamber without requesting the password again.
    
- The Artificial Grass Floor discovery sequence must not repeat after the concealed door has already been discovered.
```

## 5. Hidden Chamber

```
After opening the concealed door, the player enters a hidden chamber beneath the Garden.

Inside, the player discovers the final riddle.
```

## 6. Final Riddle

- **Riddle ID:** RD-006
- **Answer:** `KUYA`

### Riddle Text

```
"I was hidden from every eye.

Beneath the place where flowers lie.

No footsteps lead to where I stay.

Yet here I rest, concealed away.

What is it that you have come to find?"
```

### Correct Answer

`KUYA`

### Final Discovery Response

```
"Your eyes widen.

The truth of the suspect's final clue becomes clear.

Hidden beneath the Garden, you finally discover Kuya.

Your investigation is complete."
```

## 7. Game Ending

```
The game ends immediately after the player correctly answers the final riddle.

- Kuya's body is discovered.
- The investigation is marked complete.
- No additional investigation follows.
- The game does not investigate the murderer's identity, motive, or guilt.
```

## Related Documentation

- [[Garden]]
- [[Game Progression]]
- [[Password Registry]]
- [[Garden Clues]]
- [[Garden Riddles]]
- [[Notebook]]