## Room Information

```
- Room ID: RM-003
- Room Name: Garden
- Progression: Third investigation location
- Access Requirement: Garden Key (KY-002)
- Next Location: Girls Bedroom
- Next Key Reward: Girls Bedroom Key (KY-003)
- Design Status: Confirmed
```

## Room Description

```
The Garden is a peaceful outdoor area surrounded by greenery.

A small flower bed adds color to the space, while a garden bench and several outdoor fixtures complete the surroundings.

The area appears calm and undisturbed, offering a brief change of atmosphere from the rooms inside the house.

Take a closer look around. Even the quietest places may hold something worth discovering.
```

## Investigatable Objects
| Object        | Type            | Description / Function                                                                                                                                                   |
| ------------- | --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Flower Bed    | Clue Object     | A small flower bed containing exactly four flowers. Each one stands neatly among the surrounding greenery.                                                               |
| Garden Bench  | Ordinary Object | A simple wooden bench placed in the garden. It provides a quiet place to sit and enjoy the surrounding greenery.                                                         |
| Bird Bath     | Ordinary Object | A shallow basin filled with water, intended for birds to drink and bathe.                                                                                                |
| Watering Can  | Ordinary Object | A watering can used to keep the garden plants hydrated. A few drops of water remain inside.                                                                              |
| Garden Lamp   | Ordinary Object | An outdoor lamp positioned to illuminate the garden when the sun goes down.                                                                                              |
| Garden Statue | Puzzle Object   | A stone statue stands quietly among the garden decorations. Its surface shows signs of age, but it remains firmly in place. Something about its structure seems unusual. |

## Main Puzzle

```
- Puzzle ID: RD-003
- Object: Garden Statue
- Riddle Answer: STATUE
- Reward: Girls Bedroom Key (KY-003)

When the player answers correctly, the statue's concealed compartment opens and reveals the Girls Bedroom Key.

An incorrect answer does not grant the key. The player may try again or return to the Garden menu.
```


## Repeat Investigation Behavior

```
When the player investigates the Garden Statue after obtaining the Girls Bedroom Key:

The statue's concealed compartment is already open. The Girls Bedroom Key has already been collected.

The riddle must not appear again, and the key must not be awarded again.
```
## Numerical Clue

```
- Clue ID: CL-003
- Object: Flower Bed
- Displayed Value: 4
- Meaning: One of the four numerical clues needed for the final password.
- The game must not explicitly tell the player that this number is part of a password.
```

## Hidden Passage — Conditional Investigation

The Artificial Grass Floor is a special investigatable object.

### First Visit

- The Artificial Grass Floor is not displayed as an investigation option.
- The player cannot investigate or discover the hidden passage yet.

### After Notebook Puzzle Completion

- The player solves the Notebook puzzle in the Boys Bedroom.
- The player returns to the Garden.
- The Artificial Grass Floor becomes an available investigation option.
- Investigating it reveals a concealed door and the final password riddle.

The concealed door requires the final password: `9364`.

## Room Completion Conditions

```
The Garden's normal progression is completed when:

1. The player solves RD-003.
2. The player obtains the Girls Bedroom Key (KY-003).

The hidden passage is a separate, later progression event. It must only become available after the Notebook puzzle is completed.
```

## Related Documentation

- [[Location Registry]]
- [[Key Registry]]
- [[Game Progression]]
- [[Garden Clues]]
- [[Garden Riddles]]

<>

## Final Investigation — Conditional Garden Event

### Activation Requirement

The player must successfully access Notebook (IT-001) in the Boys Bedroom.

### Newly Available Object

Artificial Grass Floor

- Available only after the Notebook puzzle is solved.
- Investigating it reveals a concealed door.
- The concealed door contains a keypad and final password inscription.

### Concealed Door Password

- Password ID: PW-001
- Password: 9364
- Sequence: Confession Room → Living Room → Girls Bedroom → Garden

### Hidden Chamber

After entering the correct password, the concealed door opens.

The player enters a hidden chamber beneath the Garden and encounters the final riddle.

### Final Discovery

- Riddle ID: RD-006
- Answer: `KUYA`

A correct answer reveals Kuya and immediately ends the game.

### Important Rules

- The Artificial Grass Floor is unavailable before Notebook access.
- The password must be entered in the prescribed order.
- Incorrect password attempts have no penalty.
- Unlimited attempts are allowed.
- The final answer is KUYA, not KUYA'S BODY.
- No investigation of the murderer's identity, motive, or guilt takes place.