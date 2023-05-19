BEGIN CODE
    INT a
    SCAN: a
    SWITCH(a)
    BEGIN SWITCH
        CASE 10:
            DISPLAY: 'Succeeded '
            IF(a > 5)
            BEGIN IF
                DISPLAY: 'Really Succeeded'
            END IF
            BREAK
        CASE 3:
            DISPLAY: 'FAILED'
            BREAK
    END SWITCH
END CODE