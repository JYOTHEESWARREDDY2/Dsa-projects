import java.util.Scanner;

class Book {
    int id;
    String author;
    String title;
    boolean isBorrowed;
    Book next;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isBorrowed = false;
        this.next = null;
    }
}

class Library {
    private static Book head;

    public static Book findId(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void addTheBook(int id, String author, String title) {
        if (findId(id) != null) {
            System.out.println("Book " + id + " already exists.");
            return;
        }
        Book newBook = new Book(id, author, title);
        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
        }
        System.out.println("Book added successfully.");
    }

    public static void removeBook(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Book removed successfully.");
            return;
        }
        Book temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Book not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Book removed successfully.");
        }
    }

    public static void searchBook(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author +
                        ", Borrowed: " + (temp.isBorrowed ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void displayBook() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author +
                    ", Borrowed: " + (temp.isBorrowed ? "Yes" : "No"));
            temp = temp.next;
        }
    }

    public static void displayAvailableBooks() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (!temp.isBorrowed) {
                System.out.println("ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    public static void borrow(int id) {
        Book temp = findId(id);
        if (temp == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }
        if (temp.isBorrowed) {
            System.out.println("Sorry, '" + temp.title + "' is already borrowed.");
        } else {
            temp.isBorrowed = true;
            System.out.println("You have borrowed '" + temp.title + "' by " + temp.author + ".");
        }
    }

    public static void returnBook(int id) {
        Book temp = findId(id);
        if (temp == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }
        if (temp.isBorrowed) {
            temp.isBorrowed = false;
            System.out.println("Book '" + temp.title + "' has been returned.");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Display Available Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    Library.addTheBook(id, author, title);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    Library.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = scanner.nextLine();
                    Library.searchBook(searchTitle);
                    break;
                case 4:
                    Library.displayBook();
                    break;
                case 5:
                    Library.displayAvailableBooks();
                    break;
                case 6:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    Library.borrow(borrowId);
                    break;
                case 7:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    Library.returnBook(returnId);
                    break;
                case 8:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
