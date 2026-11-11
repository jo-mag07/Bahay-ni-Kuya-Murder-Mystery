```


flowchart TD
    A([Living Room Hub]) --> B[Select Go To]
    B --> C[Display Location Menu]
    C --> D{Select Location}

    D -->|Confession Room| E{Have KY-001?}
    D -->|Garden| F{Have KY-002?}
    D -->|Girls Bedroom| G{Have KY-003?}
    D -->|Boys Bedroom| H{Have KY-004?}
    D -->|Return| A

    E -->|No| I[Display Locked Room Message]
    F -->|No| I
    G -->|No| I
    H -->|No| I
    I --> C

    E -->|Yes| J[Enter Confession Room]
    F -->|Yes| K[Enter Garden]
    G -->|Yes| L[Enter Girls Bedroom]
    H -->|Yes| M[Enter Boys Bedroom]

    J --> N[Room Investigation Flowchart]
    K --> N
    L --> N
    M --> N

    N --> O[Return to Living Room Hub]
    O --> A

    subgraph KEY_REFERENCE["Key Acquisition Reference"]
        P["Living Room Rug: CLOCK → KY-001"]
        Q["Confession Room Side Cabinet: MICROPHONE → KY-002"]
        R["Garden Statue: STATUE → KY-003"]
        S["Girls Bedroom Vanity Table: MIRROR → KY-004"]
    end

    subgraph SPECIAL_ITEM["Special Progression Item"]
        T["Boys Bedroom Study Desk: NOTEBOOK"]
        T --> U["IT-001: Special Progression Item"]
        U --> V["Activates Final Investigation Phase"]
    end


```

`Image:`
![[mermaid-diagram (15).png]]
