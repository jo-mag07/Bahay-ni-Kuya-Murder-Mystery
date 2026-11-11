- **Project:** Bahay ni Kuya — Murder Mystery
- **Date:** 2026-11-11 | 6:52 PM
- **Phase:** 1 — Documentation Review (no code yet)
- **Status:** `Awaiting project owner decisions`
- **Reviewed:** All 65 files in `00 Main`, `01 Program`, `02 Flowchart`, `03 Logs`, `05 Hint Guide`

---

## 1. Understanding of the Game

- The player types a detective name and reads the opening story.
- The player starts in the **Living Room (RM-001)**, which is the hub. Every room exits back to it.
- Rooms unlock in a fixed chain. Each key comes from one riddle:

|Order|Room|Needs|Key/Item Found There|Riddle|Answer|
|---|---|---|---|---|---|
|1|Living Room|—|KY-001 Confession Room Key (Sofa Area → Rug)|RD-001|CLOCK|
|2|Confession Room|KY-001|KY-002 Garden Key (Side Cabinet)|RD-002|MICROPHONE|
|3|Garden|KY-002|KY-003 Girls Bedroom Key (Garden Statue)|RD-003|STATUE|
|4|Girls Bedroom|KY-003|KY-004 Boys Bedroom Key (Vanity Table)|RD-004|MIRROR|
|5|Boys Bedroom|KY-004|IT-001 Notebook (Study Desk)|RD-005|NOTEBOOK|

- The rooms also hold four numbers: Floor Indicator **3**, Wall Clock **9**, Flower Bed **4**, Wardrobe **6**. They appear in object descriptions only. The game never calls them password digits.
- Opening the Notebook starts **FP-001**. The **Artificial Grass Floor** then appears in the Garden and leads to the concealed door. The door inscription gives the order, so the password is **9364**.
- In the hidden chamber the player answers RD-006 (**KUYA**). Kuya is revealed and the game ends right away. There is no report, no culprit and no motive.

---

## 2. Intended Program Structure

One class, `BahayNiKuya.java`, no package, runnable in VS Code. Methods follow [[Java Technical Specification]] §10.

### 2.1 Fixed data (arrays)

```
KEY_IDS[]          = KY-001 … KY-004
KEY_NAMES[]        = Confession Room Key, Garden Key, Girls Bedroom Key, Boys Bedroom Key
LOCATION_NAMES[]   = Living Room, Confession Room, Garden, Girls Bedroom, Boys Bedroom
SOFA_OBJECTS[], DINING_OBJECTS[], ELEVATOR_OBJECTS[]
CONFESSION_OBJECTS[], GARDEN_OBJECTS[], GIRLS_OBJECTS[], BOYS_OBJECTS[]
```

`LOCATION_NAMES[i]` (i = 1–4) requires `KEY_NAMES[i - 1]`, so one array lookup does the room-access check.

### 2.2 Game state

|Variable|Type|Purpose|
|---|---|---|
|`detectiveName`|String|Player's name|
|`currentLocation`|String|Room the player is in|
|`inventory`|String[5]|Up to 4 keys + Notebook|
|`inventoryCount`|int|Number of filled slots|
|`notebookAccessed`|boolean|RD-005 solved|
|`finalInvestigationActive`|boolean|FP-001 started (set at the same time as `notebookAccessed`; both kept because the spec names both)|
|`doorUnlocked`|boolean|**Proposed** — see ISS-007|
|`gameRunning`|boolean|Main loop control|

### 2.3 Where each required construct is used

|Construct|Real purpose in this game|
|---|---|
|`JOptionPane`|Every dialog|
|Arrays|Keys, locations, room objects, inventory|
|`do-while`|Hub menu, room menus, riddle retries, password retries|
|`for`|Builds menu text from object arrays; lists inventory|
|Recursion|`containsItemRecursive(items, count, target, index)`. Base cases: `index >= count` → false, match → true. Used for the room-key check and for duplicate-reward prevention|
|Methods|One job each (see the spec §10 table)|

### 2.4 Reusable riddle method

A single `askRiddle(...)` handles the input, the trim + case-insensitive check, the incorrect message, Try Again/Return, and Cancel. Each puzzle object passes in its own approved text. This keeps all six riddles consistent without repeating code.

---

## 3. Issues — Blocking (missing player-facing content)

The master prompt says _do not invent missing content_. The Living Room is fully written. The other four rooms only have design notes.

|ID|Missing|Affected Docs|
|---|---|---|
|ISS-001|**Opening story text.** [[Storyline]] is a narrative draft marked _"subject to review and approval."_ Which parts get shown on screen?|Storyline|
|ISS-002|**Room entry text** for Confession Room, Garden, Girls Bedroom and Boys Bedroom. The existing "Room Description" blocks give away clue and key locations (e.g. "a wardrobe holding an important numerical clue"), so they can't be shown as written.|4 room docs|
|ISS-003|**Ordinary object descriptions: 17 missing.** Confession (Chair, Microphone, Camera, Wall Panels), Garden (Bench, Bird Bath, Watering Can, Lamp), Girls (Bed, Nightstand, Vanity Mirror, Window), Boys (Bed, Nightstand, Bookshelf, Sports Bag, Window). The docs only say "Displays an ordinary description."|4 room docs|
|ISS-004|**Clue object text** for Wall Clock (9:00 PM), Flower Bed (four flowers) and Wardrobe (six clothes). Only the facts exist. The Floor Indicator is the only one with full text.|Clue registries|
|ISS-005|**Puzzle object text before the riddle** for Side Cabinet, Garden Statue, Vanity Table and Study Desk. The Rug has its description, a "Lift the Rug" option and discovery text. The other four have none of these.|4 room docs|
|ISS-006|**Text for revisiting a solved puzzle.** Only RD-001 has one ("The compartment is already open…"). Also undefined: what the Study Desk shows after the Notebook has been read.|Riddle registries|
|ISS-007|**The concealed door interaction is undefined.** The cancel rule says _"return to the concealed door interaction,"_ but no doc defines it. The player may also need to leave and re-check numbers. Proposed menu: `[1] Read Inscription [2] Enter Password [3] Return to Garden`. Also needed: (a) whether a second Artificial Grass visit repeats the discovery text, and (b) whether an already-unlocked door goes straight to the chamber (this needs `doorUnlocked`).|Final Garden Investigation, flowchart|
|ISS-008|**Locked-room message** appears only in `exe.md` ("The door is locked. You need the ___ Key to enter this location.").|exe.md|

---

## 4. Issues — Conflicts

|ID|Conflict|Recommendation|
|---|---|---|
|ISS-009|There are 3 versions of the hub menu: [[Living Room]] §3 has 4 options, [[Main Living Room Menu]] has 6, and `exe.md` has 7|Use **Main Living Room Menu** (6 options)|
|ISS-010|Main Living Room Menu says Inventory shows "keys **and recorded clues**." The Java Spec §6.1 says clues are _not_ inventory items, and the player must remember them.|**Keys + Notebook only.** Listing clues would defeat the memory mechanic.|
|ISS-011|`exe.md` contradicts approved design (Plates, Security Panel, folded paper, Sofa as "evidence," 7-option menu, "investigation notes")|Mark `exe.md` **superseded**. Keep only its locked-room message (ISS-008).|
|ISS-012|[[Key Registry]] lists the Notebook as **IT-005** with "Puzzle: Pending design." Every other doc says IT-001 / RD-005.|Use **IT-001**. Fix the Key Registry.|
|ISS-013|[[Storyline]] §5 Garden lists _Fountain, Potted Plants_. The confirmed [[Garden]] (DEC-006) lists Bird Bath, Watering Can, Garden Lamp and Garden Statue.|Use **Garden.md**|
|ISS-014|The RD-006 registry gives _Try Again / Return_ on a wrong answer, but the Final Investigation flowchart loops straight back to the riddle. The flowchart also loops a wrong password straight back to input.|RD-006: **Try Again / Return** (Return → Garden menu). Password: wrong → message → re-enter. Cancel → door interaction.|
|ISS-015|Main Game Flowchart: Exit → END with no confirmation. Menu doc: "exits after confirmation."|**Ask for confirmation** (matches the cancel rules)|
|ISS-016|The Room Investigation flowchart puts **Inventory** in room menus. Room docs never define a room menu layout.|Room menu = objects + `Inventory` + `Return to Living Room`|
|ISS-017|[[Method Registry]] / [[Program Structure]] (older) list `firstPassword()`, `checkNotes()` and others. That breaks DEC-002 (one password only) and ISS-010.|Follow **Java Spec §10**. Mark the older tables superseded.|

---

## 5. Minor — Proceeding With Default Unless Objected

|ID|Item|Default|
|---|---|---|
|ISS-018|Tags like `(Ordinary object)` and `(Numerical clue: 3)` sit inside the description blocks|Treat them as designer notes and **don't show them**. Showing "Numerical clue: 3" would break the no-reveal rule.|
|ISS-019|The RD-001 display shows its internal ID (`[RD-001 — THE HIDDEN COMPARTMENT]`). The others have titles (_The Silent Witness_…) but no display header.|Show the **title only, no ID**, the same way for all six|
|ISS-020|Wall Clock shows "9 PM" in one doc and "9:00 PM" in another|Use **9:00 PM** ([[Confession Room Clues]])|
|ISS-021|Optional hints exist for RD-002–005 but not RD-001/006, and no flow offers them|**Not implemented**|
|ISS-022|Spec says to use the detective name "throughout," but no approved text has a `[Name]` placeholder|Use it in the **intro** and in **dialog title bars** (e.g. `Bahay ni Kuya — Detective Juan`). Approved lines stay unedited.|
|ISS-023|[[Game Idea]] says English/Hiligaynon; [[Storyline]] says English|**English**|
|ISS-024|These files are empty: Location Registry, Game Mechanics, Game Rules, Game Variables, Array Registry, Program Progress, Room Navigation, Key & Unlock System, Puzzle & Riddle Flow, Boys Bedroom Clues, Final Door Password|Not blocking. The content exists elsewhere.|

---

## 6. Implementation Concerns

1. **How menus take input (decision needed, ISS-025).** The docs show _"Enter your choice:"_, which means typed numbers via `showInputDialog`. The spec suggests `showOptionDialog` (buttons). Rooms have 8 options with Inventory and Return, and 8 buttons is a very wide dialog. The spec's "invalid menu selections" check only makes sense with typed input. **Recommend typed numbers.**
2. **Cancel vs. empty input.** `showInputDialog` returns `null` for both Cancel and the X button, and `""` for an empty OK. The code will treat these differently: null → cancel rule; empty → "please enter an answer"; anything else → check the answer.
3. **Clean exit.** JOptionPane can leave the Swing thread alive. The game will call `System.exit(0)` on exit and after KUYA.
4. **Windows encoding.** Em dashes (—) in strings can turn into garbage characters when compiled on Windows. Strings will use plain ASCII (`-`), or compile with `javac -encoding UTF-8`.

---

## 7. Proposed Phase 2 Sections

|#|Section|Blocked by|
|---|---|---|
|S1|Skeleton, arrays, state, recursion, name input, intro, hub menu, inventory, exit confirmation|ISS-001, ISS-009, ISS-010, ISS-025|
|S2|Living Room areas, RD-001, Go To menu, locked rooms|ISS-008|
|S3|Confession Room + RD-002|ISS-002 – 006|
|S4|Garden (first visit) + RD-003|ISS-002 – 006|
|S5|Girls Bedroom + RD-004|ISS-002 – 006|
|S6|Boys Bedroom + RD-005 + Notebook activation|ISS-002 – 006|
|S7|Artificial Grass → door → 9364 → RD-006 → ending|ISS-007, ISS-014|
|S8|Phase 3 verification checklist|—|

Each section delivers the **complete, updated** `BahayNiKuya.java` plus a short progress note.

---

## Related

- [[Master Implementation Prompt]]
- [[Java Technical Specification]]
- [[Documentation Audit]] (its unchecked item _"No conflicting information"_ is covered by §4 above)
- [[Issues & Questions]]