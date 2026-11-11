## Room Information

- **Room ID:** RM-004
- **Room Name:** Girls Bedroom
- **Progression:** Fourth investigation location
- **Access Requirement:** Girls Bedroom Key (KY-003)
- **Next Location:** Boys Bedroom
- **Next Key Reward:** Boys Bedroom Key (KY-004)
- **Design Status:** Confirmed

## Room Description

```
The Girls Bedroom is a private and comfortable space inside Bahay ni Kuya.

The room contains familiar bedroom furniture, personal belongings, and a vanity area.

Everything seems neatly arranged, giving the room an ordinary and peaceful appearance.

Take your time to look around. There may be more to discover than what first meets the eye.
```

## Investigatable Objects

| Object        | Type            | Description / Function                                                                                                                                                                                                    |
| ------------- | --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Wardrobe      | Clue Object     | A wardrobe containing exactly six pieces of clothing, neatly arranged inside.                                                                                                                                             |
| Bed           | Ordinary Object | A neatly arranged bed with pillows and blankets. It appears to be a comfortable place to rest.                                                                                                                            |
| Nightstand    | Ordinary Object | A small bedside table with a drawer for keeping personal belongings.                                                                                                                                                      |
| Vanity Table  | Puzzle Object   | Contains a concealed compartment with the Boys Bedroom Key.                                                                                                                                                               |
| Vanity Mirror | Ordinary Object | A vanity table sits neatly arranged in the bedroom. Its surface holds a few personal items, while its drawers appear to provide storage for smaller belongings. One part of the table seems worth examining more closely. |
| Window        | Ordinary Object | A window overlooking the outside of Bahay ni Kuya. Sunlight passes through the glass.                                                                                                                                     |

## Main Puzzle

- **Puzzle ID:** RD-004
- **Object:** Vanity Table
- **Riddle Answer:** MIRROR
- **Reward:** Boys Bedroom Key (KY-004)

```
The player must solve the riddle associated with the Vanity Table.

When answered correctly, a concealed compartment opens and reveals the Boys Bedroom Key.

An incorrect answer does not grant the key. The player may try again or return to the room menu.
```

## Repeat Investigation Behavior

```
When the player investigates the Vanity Table after obtaining the Boys Bedroom Key:

The concealed compartment is already open. The Boys Bedroom Key has already been collected.

The riddle must not appear again, and the key must not be awarded again.
```
## Numerical Clue

- **Clue ID:** CL-004
- **Object:** Wardrobe
- **Displayed Value:** 6
- **Meaning:** One of the four numerical values needed for the final password.
- The game must not explicitly tell the player that this number is part of a password.

## Room Completion Conditions

```
The room's progression is completed when:

1. The player investigates the Vanity Table.
2. The player solves RD-004.
3. The concealed compartment opens.
4. The player obtains the Boys Bedroom Key (KY-004).
```

## Related Documentation

- [[Location Registry]]
- [[Key Registry]]
- [[Game Progression]]
- [[Girls Bedroom Clues]]
- [[Girls Bedroom Riddles]]