**Location ID:** RM-001  
**Status:** Proposed Design  
**Role:** Starting Location / Main Hub


## 1. Overview
```
The Living Room is the starting location of the detective's investigation inside Bahay ni Kuya.

It serves as the main navigation hub, allowing the player to investigate three different areas and access other locations once the required keys have been collected.
```

## 2. Available Areas

### A. Sofa Area

```
Investigatable Objects:

1. Pillow
2. Rug
3. Blanket
4. Sofa

Important Object:

- Rug

Purpose:

- Contains a concealed wooden compartment.
- The compartment contains RD-001.
- Correct answer awards KY-001 (Confession Room Key).
```

### B. Dining Area

```
Investigatable Objects:

1. Dining Table
2. Dining Chairs
3. Cabinet
4. Wall Decoration

Purpose:

- Provides environmental observations.
- No key or mandatory puzzle currently assigned.
```

### C. Elevator Area

```
Investigatable Objects:

1. Floor Indicator
2. Elevator Buttons
3. Elevator Door

Important Object:

- Floor Indicator

Purpose:

- Displays Floor 3.
- Contains CL-001, a numerical clue associated with PW-001.
```

## 3. Area Navigation

```
[Living Room Main Menu]

[1] Sofa Area  
[2] Dining Area  
[3] Elevator Area  
[4] Go To
```

```
[Go To Menu]

[1] Confession Room  
[2] Garden  
[3] Girls Bedroom  
[4] Boys Bedroom  
[5] Return
```

// Room access requires its corresponding key.

## 4. Key Reward
```
**Key ID:** KY-001  
**Key Name:** Confession Room Key  
**Found In:** Sofa Area  
**Object:** Rug  
**Riddle:** RD-001  
**Correct Answer:** CLOCK  
**Unlocks:** Confession Room
```

## 5. Numerical Clue

```
**Clue ID:** CL-001

- Object: Floor Indicator
    
- Area: Elevator Area
    
- Displayed Number: 3
    
- Password Association: PW-001
```

// The number must be remembered by the player.

## 6. Investigation Rules
```
1. The player may freely access all three Living Room areas.
    
2. Investigating ordinary objects displays their descriptions.
    
3. Ordinary objects provide a Return option.
    
4. Puzzle objects provide additional investigation options.
    
5. Correct riddle answers award predetermined rewards.
    
6. Incorrect answers do not award rewards.
    
7. Players may retry riddles without losing collected items.
    
8. The Confession Room remains inaccessible until KY-001 is obtained.
```

## 7. Related Documentation

### Clues

- [[Living Room Clues]]
### Riddles

- [[Living Room Riddles]]
### Keys

- [[Key Registry]]
### Game Progression

- [[Game Progression]]
### Other Locations

- [[Confession Room]]
- [[Garden]]
- [[Girls Bedroom]]
- [[Boys Bedroom]]