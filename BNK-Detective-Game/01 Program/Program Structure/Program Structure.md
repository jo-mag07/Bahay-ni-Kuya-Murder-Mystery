> [!warning] SUPERSEDED DOCUMENT  
> This document is outdated and must not be used as an implementation reference.
> 
> The authoritative technical reference is `Java Technical Specification.md`.
> 
> Follow Section 10 — Method Responsibilities for the approved method structure and responsibilities.
> 
> Do not implement outdated methods or structures from this document unless the project owner explicitly approves a change.

```
## Main Class
- Starts the game.
- Requests detective name.
- Initializes game state.
- Controls the main game loop.

## Methods

| Method | Responsibility |
|---|---|
| main() | Game initialization |
| startGame() | Starts the storyline |
| livingRoom() | Living Room menu |
| confessionRoom() | Confession Room menu |
| garden() | Garden menu |
| girlsBedroom() | Girls Bedroom menu |
| boysBedroom() | Boys Bedroom menu |
| checkKey() | Checks room access |
| solveRiddle() | Processes riddle answers |
| inventory() | Displays collected keys and clues |

## Data Management
- Player name
- Inventory
- Collected keys
- Discovered clues
- Unlocked rooms
- Notebook access
- Final password
```

<>