Functional Requirements
1. Add a Book
Description: Allow users to add a new book to the library inventory.
Input Details:
Book ID (unique identifier, integer)
Title (string)
Author (string)
Publication Year (integer)
Genre (string)
Output: Confirmation message with the book details.

2. Remove a Book
Description: Allow users to remove a book by its ID or Title.
Input Details:
Book ID (integer) or Title (string).
Output:
If found: Confirmation message with removed book details.
If not found: Error message.
Used Collections and used exception handling.

4. Search for a Book
Description: Allow users to search for a book by one or more criteria.
Search Criteria:
Title (string, partial matches allowed).
Author (string, exact match).
Publication Year (integer, optional filter).
Output: Display a list of books matching the criteria or an error message if none found.

5. Display All Books
Description: Display all books in the inventory with their details.
Output: A formatted list of books showing:
Book ID, Title, Author, Publication Year, Genre.
Sorted by Publication year in latest/Desc order. 

6. Exception Handling
Scenarios Handled:
Adding a book with duplicate ID.
Removing a book that doesn't exist.

7. Singleton Design Pattern
Ensured that the library inventory management system has only one instance to manage data throughout the application lifecycle.
Implementation:
Used the Singleton pattern for the Library class.

8. Factory Design Pattern
Description: Used a factory pattern to create Book objects dynamically.
Implementation:
Create a BookFactory class to handle book creation.

9. Exit the Program
Description: Provided an option to safely exit the program.
