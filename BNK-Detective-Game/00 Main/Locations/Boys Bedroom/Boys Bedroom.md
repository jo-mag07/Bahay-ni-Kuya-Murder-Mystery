## Room Information

- **Room ID:** RM-005
- **Room Name:** Boys Bedroom
- **Progression:** Fifth and final normal investigation location
- **Access Requirement:** Boys Bedroom Key (KY-004)
- **Next Location:** Garden (return visit)
- **Key Reward:** None
- **Design Status:** Confirmed

## Room Description

```
The Boys Bedroom is another private space inside Bahay ni Kuya.

The room contains familiar bedroom furniture, personal belongings, and a study area.

At first glance, everything appears ordinary and undisturbed.

Look around carefully. Something in this room may hold information that changes the course of your investigation.
```

## Investigatable Objects

| Object     | Type                  | Description / Function                                                                                                                                                                                          |
| ---------- | --------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Study Desk | Special Puzzle Object | A study desk sits in one corner of the bedroom. Several items are arranged across its surface, including a notebook. It looks like a place where someone might keep personal thoughts or important information. |
| Bed        | Ordinary Object       | A simple bed with neatly arranged pillows and blankets.                                                                                                                                                         |
| Nightstand | Ordinary Object       | A small bedside table used for keeping personal belongings within reach.                                                                                                                                        |
| Bookshelf  | Ordinary Object       | A shelf filled with books and reading materials arranged in several rows.                                                                                                                                       |
| Sports Bag | Ordinary Object       | A sports bag placed near the furniture. It appears to contain personal belongings.                                                                                                                              |
| Window     | Ordinary Object       | A window overlooking the outside of Bahay ni Kuya. The view is quiet and undisturbed.                                                                                                                           |

## Special Progression Item — Notebook

- **Item ID:** IT-001
- **Item Name:** Notebook
- **Found At:** Study Desk
- **Item Type:** Special Progression Item
- **Riddle ID:** RD-005
- **Riddle Answer:** NOTEBOOK

The Notebook is already present on the Study Desk. The player must solve its riddle to access its contents.

### Repeat Investigation Behavior

```
When the player investigates the Study Desk after accessing the Notebook:

The Notebook has already been read. Its contents do not need to be displayed again.

The Notebook riddle must not appear again, and the final investigation phase must not be activated repeatedly.
```

### Notebook Contents

```
"You have access to every room in this house.

But finding the keys was only the beginning.

Return to each room. Look closely. There is evidence you have yet to understand.

Do not overlook anything."
```

## Final Investigation Phase

After the player solves RD-005:

```
1. The Notebook is marked as accessed.
2. Its contents are displayed.
3. The final investigation phase is activated.
4. The player can revisit previously explored rooms.
5. The Artificial Grass Floor becomes available for investigation in the Garden.
6. Investigating it reveals the concealed door and final password riddle.
```

## Important Rules

```
- The Notebook is not a key.
- It does not unlock another room.
- It does not reveal the murderer's identity or motive.
- Its purpose is to trigger the final investigation phase.
- The Artificial Grass Floor must remain unavailable until the Notebook has been accessed.
- The final password is 9364.
```

## Room Completion Conditions

```
The Boys Bedroom's normal progression is completed when:

1. The player investigates the Study Desk.
2. The player solves RD-005.
3. The Notebook contents are displayed.
4. The final investigation phase is activated.
```

## Related Documentation

- [[Location Registry]]
- [[Game Progression]]
- [[Garden]]
- [[Garden Clues]]
- [[Garden Riddles]]
- [[Boys Bedroom Clues]]
- [[Boys Bedroom Riddles]]