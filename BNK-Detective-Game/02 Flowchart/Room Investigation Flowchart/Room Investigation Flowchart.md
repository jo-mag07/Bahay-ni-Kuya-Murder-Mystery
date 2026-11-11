```

flowchart TD
    A([ENTER ROOM]) --> B[Display Room Description]
    B --> C[Display Available Objects]
    C --> D{Choose an Option}

    D -->|Investigate Object| E{Select Object Type}
    D -->|Inventory| F[Display Inventory]
    F --> C
    D -->|Return| G([Return to Living Room Hub])

    E -->|Ordinary Object| H[Display Object Description]
    H --> C

    E -->|Numerical Clue Object| I[Display Clue Observation and Value]
    I --> J[Player Remembers Numerical Value]
    J --> C

    E -->|Puzzle Object| K[Identify Room-Specific Puzzle]
    K --> L[Display Riddle]
    L --> M[/Enter Answer/]
    M --> N{Correct Answer?}

    N -->|No| O{Choose an Option}
    O -->|Try Again| L
    O -->|Return| C

    N -->|Yes| P{Reward Type}
    P -->|Fixed Key| Q[Check Key Ownership]
    Q --> R{Already Owned?}
    R -->|Yes| S[Prevent Duplicate Collection]
    R -->|No| T[Add Designated Key to Inventory]
    S --> U[Display Reward Status]
    T --> U
    U --> C

    P -->|Notebook IT-001| V[Access Notebook Contents]
    V --> W[Display Critical Evidence Instruction]
    W --> X[Activate Final Investigation Phase]
    X --> C

    E -->|Conditional Garden Object| Y{Notebook Accessed?}
    Y -->|No| Z[Artificial Grass Floor Unavailable]
    Z --> C
    Y -->|Yes| AA[Display Artificial Grass Floor]
    AA --> AB[Investigate Artificial Grass Floor]
    AB --> AC[Open Final Investigation Flowchart]

    subgraph PUZZLE_REFERENCE["Room-Specific Puzzle Assignments"]
        P1["Living Room: Rug → CLOCK → KY-001"]
        P2["Confession Room: Side Cabinet → MICROPHONE → KY-002"]
        P3["Garden: Statue → STATUE → KY-003"]
        P4["Girls Bedroom: Vanity Table → MIRROR → KY-004"]
        P5["Boys Bedroom: Study Desk → NOTEBOOK → IT-001"]
    end

    subgraph CLUE_REFERENCE["Numerical Clue Assignments"]
        C1["Living Room: Floor Indicator → 3"]
        C2["Confession Room: Wall Clock → 9"]
        C3["Girls Bedroom: Wardrobe → 6"]
        C4["Garden: Flower Bed → 4"]
    end

```

`Image:`
![[mermaid-diagram (13).png]]
