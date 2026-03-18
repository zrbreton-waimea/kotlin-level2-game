# Pinned!

by Zander Breton

---

This is a programming project for **NCEA Level 2**, assessed against standard [91896](task/as91896.pdf).

The project is written in the [Kotlin](https://kotlinlang.org) programming language and demonstrates a number of **advanced programming techniques**:
- Modifying data stored in collections
- Storing multi-dimensional data in collections
- Creating functions that use parameters and/or return values
- Using non-trivial string manipulation
- Using additional non-core libraries

** EDIT LIST ABOVE TO MATCH YOUR PROJECT**

---

## Project Files

- Program source code can be found in the [src](src/) folder
- Program test plan is in [test-plan.md](docs/test-plan.md) in the docs folder
- Program test evidence is in [test-results.md](docs/test-results.md) in the docs folder

---

## Project Description

The game rules...

## The Squeeze🗜️

### Game Setup
- A row of 15 squares, numbered 1 to 15 from left to right
- Player 1 places 3 counters at squares 5, 7, and 9
- Player 2 places 3 counters at squares 6, 8, and 10
- Decide who goes first

### Gameplay
- Players take turns. You may not skip your turn
- On your turn you must do exactly one of the following:
  - Move one of your counters exactly one square left or right into an empty square
  - Swap one of your counters with an adjacent opponent counter, moving your counter into their square and their counter into yours, but...
  - You may not swap an opponent counter into a danger zone square (the end squares)
- After both players have taken their turn, the board shrinks - the square at each end is removed. Any counter on a removed square is 'crushed' and eliminated

### Win Condition
- The last player with at least one counter remaining on the board wins


