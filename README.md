project-1(simple projects):
-------------------------
Library Management System:
-------------------------

Overview:
--------
This is a simple Library Management System implemented in Java using a linked list data structure. 
The system allows users to:
Add new books
Remove books
Search for books by title
Display all books
Display available (not borrowed) books
Borrow and return books

Features:
Add Book: Allows adding a new book with a unique ID, title, and author.
Remove Book: Removes a book from the library by its ID.
Search Book: Finds a book by title and displays its details.
Display All Books: Shows the list of all books in the library.
Display Available Books: Lists books that are not currently borrowed.
Borrow Book: Allows a user to borrow a book if it is available.
Return Book: Returns a borrowed book and makes it available again.
Exit: Closes the system.

Technologies Used:
Java
Linked List data structure
Scanner for user input


project-2(simple projects):
-------------------------
Sudoku solver:
-------------------------

Overview:
--------
This is a Java-based Sudoku Solver that uses a backtracking algorithm to solve a given 9x9 Sudoku puzzle. The program recursively attempts to place numbers from 1 to 9 in empty cells while ensuring the Sudoku rules are met.
How It Works

isSafe Method:
---------------
Checks if placing a number in a specific cell is valid based on Sudoku rules:
* The number should not be present in the same row.
* The number should not be present in the same column.
* The number should not be present in the 3x3 sub-grid.
helper Method:
--------------
Implements the recursive backtracking algorithm:
* If the last row is reached, the solution is found.
* Moves to the next row if the current row is completed.
* If the cell is already filled, move to the next cell.
* Attempts to place numbers from 1 to 9 in empty cells, checking validity using isSafe.
* If a valid placement leads to a solution, it is retained; otherwise, it backtracks.
printSudoku Method:
-------------------
* Prints the solved Sudoku grid to the console.

main Method:
------------
* Initializes a Sudoku puzzle with pre-filled numbers.

* Calls the helper function to solve the puzzle.

* Prints the solved Sudoku if a solution exists; otherwise, prints a message indicating no 
 solution.

sample input:
------------
![image](https://github.com/user-attachments/assets/f08ea481-df31-4cbd-9aba-3adb97d37eb6)

sample output:
-------------
![image](https://github.com/user-attachments/assets/4825607a-1de1-4256-984c-b16e5173ff25)

