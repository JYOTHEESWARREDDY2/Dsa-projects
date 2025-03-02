import java.util.*;
class Book{
    int id;
    String author;
    String title;
    boolean isBorrowed;
    Book next;
    boolean borrow;
    public Book(int id,String title,String author){
        this.id=id;
        this.author=author;
        this.title=title;
        this.borrow=false;
        this.next=null;
    }

}
class Library{
    private static Book head;
     public static Book findId(int id){
        Book temp=head;
        while(temp!=null){
            if(temp.id==id){
                return temp;
            }
            temp=temp.next;
        }
        return null;
     }
     public static void addTheBook(int id,String title,String author){
        if(findId(id)!=null){
            System.out.print("Book"+id+"already existed");
            return;
        }
        else{
            Book newBook=new Book(id,title,author);
             if(head==null){
              head=newBook;

             }
             else{
                 Book temp=head;
                 while(temp.next!=null){
                     temp=temp.next;
                 }
                 temp.next=newBook;
             }
            System.out.println("Book added successfully");
         }
     }
     public static void removeBook(int id){
         Book  temp=head;
         if(head==null){
             System.out.println("Library is empty");
         }
         if(head.id==id){
             System.out.println("Book removed successfully.");
             return;
         }
         while(temp.next!=null && temp.next.id!=id){
             temp=temp.next;
         }
         if(temp.next==null){
             System.out.println("Book not found");
         }
         else{
             Book delete=temp.next;
             temp.next=temp.next.next;
             delete.next=null;
             System.out.println("Book removed successfully");

         }
     }
     public static void searchBook(String title){
         Book temp=head;
         if(temp==null){
             System.out.println("Book is not existed");
         }
         while(temp!=null){
             if(temp.title.equalsIgnoreCase(title)){
                 System.out.println("Book Found: ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author+"borrowed:"+((temp.isBorrowed)?"Yes":"No"));
                return;
             }
             temp=temp.next;
         }
     }
     public static int  totalBooks(){
         Book temp=head;
         int count=0;
         while(temp!=null){
             temp=temp.next;
             count++;
         }
         return count;
     }
     public static void displayBook(){
         Book temp=head;
         while(temp!=null){
             System.out.println("ghh");
             System.out.println("Book: ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author+"borrowed:"+((temp.isBorrowed)?"Yes":"No"));
             temp=temp.next;
         }
     }
     public static void displayAvailableBooks(){
         if(head==null){
             System.out.println("No book available");
             return;
         }
         Book temp=head;
         boolean found=false;
         while(temp!=null){
           if(!temp.isBorrowed){
               System.out.println("Book: ID=" + temp.id + ", Title=" + temp.title + ", Author=" + temp.author);
               found=true;
           }
           temp=temp.next;
           if(!found){
               System.out.println("no books are currently available");
           }
         }
     }

     public static void borrow(int id){
         Book temp=findId(id);
         if(temp==null){
             System.out.println("Book with ID " + id + " not found.");
             return;
         }
        if(temp.isBorrowed){
            System.out.println("Sorry, '" + temp.title + "' is already borrowed.");
        }
        else{
            temp.isBorrowed=true;
            System.out.println("You have borrowed '" + temp.title + "' by " + temp.author + ".");
        }
     }
    public static void returnBook(int id){
        Book temp=findId(id);
        if(temp==null){
            System.out.println("Book with ID " + id + " not found.");
            return;
        }
        if(temp.isBorrowed){
            temp.isBorrowed = false;
            System.out.println("Book '" + temp.title + "' has been returned.");
        }
        else{
            System.out.println("This book was not borrowed.");
        }
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Library l=new Library();
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
            System.out.println("8. total no of books");
            System.out.println("9.Exit");
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
                    l.addTheBook(id, title, author);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    l.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = scanner.nextLine();
                    l.searchBook(searchTitle);
                    break;
                case 4:
                    l.displayBook();
                    break;
                case 5:
                    l.displayAvailableBooks();
                    break;
                case 6:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    l.borrow(borrowId);
                    break;
                case 7:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    l.returnBook(returnId);
                    break;
                case 8:
                    System.out.println("Total no of books are:"+l.totalBooks());
                    break;
                case 9:
                    System.out.println("Exit from the library");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 8);
    }
}
