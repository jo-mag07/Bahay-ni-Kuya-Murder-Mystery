```
Riddle ID: RD-001

Associated Key: KY-001 — Confession Room Key

Puzzle location: Sofa Area → Rug → Hidden Wooden Compartment.
```

### Riddle displayed to the player

```
[RD-001 — THE HIDDEN COMPARTMENT]

"I have a face, but I cannot see.
I have hands, but I cannot hold.
I tell you when, but never why.

What am I?"

Enter your answer:
```

__Answer: `CLOCK`__

<>

### Incorrect answer behavior

```
[INCORRECT ANSWER]

That doesn't seem to be the correct answer.

The compartment remains locked.

Think carefully and try again.

[1] Try Again
[2] Return
```

- The key is not awarded.
    
- The player can retry indefinitely.
    
- The answer should be case-insensitive.
    
- Spaces before and after the answer should be ignored.
    
- Returning does not reset the puzzle's progress.
    

### Correct answer behavior

```
[CORRECT ANSWER]

The compartment clicks open.

Inside, you discover a small key.

You carefully retrieve it.

ITEM OBTAINED:
CONFESSION ROOM KEY

This key grants access to the Confession Room.
```

Reward: KY-001

The key is added to the player's inventory.

Important: Once collected, the compartment should no longer award another key. Revisiting it should display:

```
The compartment is already open.

There is nothing else inside.
```