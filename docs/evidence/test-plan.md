# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## User choice, exit or play game. - VALID

I will choose whether to play or exit.

### Test Data To Use

I will enter the expected characters P (Play) or E (Exit).

### Expected Test Result

The code should proceed to the player username select if the player chose P, or exit if the chose E.

---

## User choice, exit or play game. - INVALID

I will enter incorrect inputs to ensure that they are rejected, the user will be prompted to enter the correct input until they do.

### Test Data To Use

Entering random characters. 
Entering nothing.

### Expected Test Result

It should display an error message prompting them to select a valid choice until they do so.

---

## Username input - VALID

I will enter a username that follow the parameters set in the code.

### Test Data To Use

Entering a username within 13 characters and not blank.
I will do this for player 1 and player 2.

### Expected Test Result

It should accept the username entered showing no errors to the user.

---

## Username input - Boundary

I will enter a username that is on the 13-character limit.

### Test Data To Use

Entering a username 13 characters in length.
I will do this for player 1 and player 2.

### Expected Test Result

It should accept the username entered showing no errors to the user.

---

## Username input - Boundary

I will enter a username that is on the 1 character minimum.

### Test Data To Use

Entering a username 1 character in length.
I will do this for player 1 and player 2.

### Expected Test Result

It should accept the username entered showing no errors to the user.

---

## Username input - INVALID

I will enter a username that is over the 13-character limit.

### Test Data To Use

Entering a username over 13 characters and not blank.
I will do this for player 1 and player 2.

### Expected Test Result

It shouldn't accept the username entered showing the character limit error to the user.

---

## Username input - INVALID

I will enter a username that blank.

### Test Data To Use

Entering a username that is blank.
I will do this for player 1 and player 2.

### Expected Test Result

It shouldn't accept the username entered showing the user an error telling them they can't leave it blank.

---
## Username input - BOUNDARY

I will enter a username that is on the 13-character limit.

### Test Data To Use

Entering a username on the 13-character limit and not blank.
I will do this for player 1 and player 2.

### Expected Test Result

It should accept the username entered not showing the character limit error to the user or the blank error.


---
## Username input - BOUNDARY

I will enter a username that is on the 1 character minimum.

### Test Data To Use

Entering a character on the minimum and not blank.
I will do this for player 1 and player 2.

### Expected Test Result

It should accept the username entered not showing the blank error.

---

## Gameplay: Player Piece Movement - VALID

I will move a piece without breaking any rules.

### Test Data To Use

From a cell that has a piece in it, to the left to a cell that is blank/unoccupied.
I will do this for player 1 and player 2.

### Expected Test Result

It should allow the piece to be moved from the cell the user selected, to the cell that is blank/unoccupied.

---

## Gameplay: Player Piece Movement - INVALID

I will move a piece to the right.

### Test Data To Use

From a cell that has a piece in it, to the right to a cell.
I will do this for player 1 and player 2.

### Expected Test Result

It shouldn't allow the piece to be moved from the cell the user selected, to the right. It should also show the error message that tells the user they cannot move to the right.

---

## Gameplay: Player Piece Movement - INVALID

I will move a piece into a cell that is occupied by another piece.

### Test Data To Use

From a cell that has a piece in it, to a cell occupied.
I will do this for player 1 and player 2.

### Expected Test Result

It shouldn't allow the piece to be moved from the cell the user selected, to the right.

---

## Gameplay: Player Piece Movement - INVALID

I will jump over a piece or pieces on the board to a cell.

### Test Data To Use

From a cell that has a piece in it, over other pieces to the left, to a cell.
I will do this for player 1 and player 2.

### Expected Test Result

It shouldn't allow the pieces to be jump over other pieces, while moving to the left. It should display the user an error message saying that they cannot jump over pieces.

---
## Gameplay: Player Piece Movement - INVALID

I will move a cell that doesn't have anything in it.

### Test Data To Use

I will move a blank cell that doesn't have anything in it.

### Expected Test Result

It won't let you select a cell that is blank, it should respond with an error message telling them to do a valid move.


---

## Gameplay: Player Piece Movement - BOUNDARY/VALID

I will move a piece from a cell, to cell 1. This will test whether the first cell can hold a piece that the player has moved.

### Test Data To Use

From a cell that has a piece in it, to cell 1.
I will do this for player 1 and player 2.

### Expected Test Result

It should move to the cell without displaying any error messages or removing the piece.

---

## Gameplay: Player removing a piece - BOUNDARY

I will move cell 1, removing it from the board.

### Test Data To Use

Select cell 1.
I will do this for player 1 and player 2.

### Expected Test Result

It should remove cell 1 when it is selected by the user. It should not ask where they want to move it.

## Gameplay: Player removing the winning piece - BOUNDARY

I will move the winning piece black(*) to cell 1, then on the next players turn they can remove it.

### Test Data To Use

Select cell 1.
I will do this for player 1 and player 2.

### Expected Test Result

It should remove cell 1 when it is selected by the user. It should not ask where they want to move it.




