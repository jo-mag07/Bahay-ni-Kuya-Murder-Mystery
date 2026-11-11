```

flowchart TD
    A([Enter Boys Bedroom]) --> B[Boys Bedroom Object Menu]
    B --> C[Investigate Study Desk]
    C --> D[Discover Notebook]
    D --> E[Display Notebook Riddle]
    E --> F[/Enter Answer/]
    F --> G{Correct Answer?}

    G -->|No| H{Choose an Option}
    H -->|Try Again| E
    H -->|Return| B
    F -->|Cancel| B

    G -->|Yes| I[Access Notebook IT-001]
    I --> J[Display Notebook Contents]
    J --> K[Activate Final Investigation Phase]
    K --> L[Revisit All Rooms and Review Existing Evidence]
    L --> M[Return to Garden]
    
    M --> N[Display Updated Garden Menu]
    N --> O[Artificial Grass Floor Available]
    O --> P[Investigate Artificial Grass Floor]
    P --> Q{Concealed Door Already Discovered?}
    Q -->|No| R[Display Discovery Description]
    R --> S[Discover Concealed Door]
    Q -->|Yes| T[Concealed Door Interaction Menu]
    S --> T

    T --> U{Choose an Option}
    U -->|Read Inscription| V[Display Door Inscription]
    V --> T
    U -->|Enter Password| W{Door Already Unlocked?}
    W -->|Yes| X[Enter Hidden Chamber]
    W -->|No| Y[/Enter Final Password/]
    Y --> Z{Password Correct?}

    Z -->|No| AA[Display Incorrect Password Message]
    AA --> T
    Y -->|Cancel| T

    Z -->|Yes| AB[Unlock Concealed Door]
    AB --> AC[Display Door Unlocking Description]
    AC --> X

    U -->|Return to Garden| N

    X --> AD[Display Final Riddle]
    AD --> AE[/Enter Answer/]
    AE --> AF{Answer is KUYA?}

    AF -->|No| AG{Choose an Option}
    AG -->|Try Again| AD
    AG -->|Return| N

    AF -->|Yes| AH[Reveal Kuya's Hidden Body]
    AH --> AI[Display Investigation Complete Message]
    AI --> AJ([END GAME])

```

`Image:`
![[mermaid-diagram (16).png]]


<>

// Notice that the Artificial Grass Floor is not simply another ordinary Garden option. It is a conditional game event.

// We need to implement that condition explicitly in Java, probably through a boolean variable such as:

```
boolean notebookAccessed = false;
```

// After solving the Notebook riddle:

```
notebookAccessed = true;
```

// Then the Garden menu checks that variable before displaying the fifth option.