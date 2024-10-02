import java.util.*;
class Main {
    public static void main(String[] args) {

        // Create a new Library object
        Library library = new Library();

        // Repeat the main menu until the user quits the program
        do {
            // Display the main menu
            library.displayMainMenu();

            // Get the user's menu choice
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            // Add a book to the library
            if (choice == 1) {
                // Create a new Book object
                Book book = new Book();
                // Display the book menu and get the book's details from the user
                book.bookMenu();
                // Add the book to the library
                library.addBook(book);

            // Find a book in the library
            } else if (choice == 2) {
                // Ask the user for the serial number of the book they want to find
                System.out.println("Enter the books serial Number that you want to find : ");
                int userChoice = sc.nextInt();
                // Search for the book in the library and get its index
                int indexUser = library.findBook(userChoice);
                // Print the details of the book with the given serial number
                System.out.println("The book with the given Serial Number is: " + "\r\n" + library.getBook(library.findBook(userChoice)));

            // Update a book in the library
            } else if (choice == 3) {
                // Ask the user for the serial number of the book they want to update
                System.out.println("Enter the books serial Number that you want to Update : ");
                int userChoice = sc.nextInt();
                // Get the Book object from the library using its serial number
                Book book = library.getBook(library.findBook(userChoice));
                // Display the update menu for the book and get the user's update choice
                book.userUpdateDisplay();
                System.out.println("What do you want to update. ");
                int updateUserChoice = sc.nextInt();
                // Update the book's serial number
                if (updateUserChoice == 1) {
                    System.out.println("Enter the new serial number for the book:  ");
                    int newsNo = sc.nextInt();
                    book.setsNo(newsNo);
                // Update the book's name
                } else if (updateUserChoice == 2) {
                    System.out.println("Enter the New Book Name: ");
                    String newBookName = sc.next();
                    book.setBookName(newBookName);
                // Update the book's author
                } else if (updateUserChoice == 3) {
                    System.out.println("Enter the new Author Name: ");
                    String newAuthorName = sc.next();
                    book.setAuthorName(newAuthorName);
                }
                // Print the updated book details
                System.out.println("The updated Book is : " + library.getBook(userChoice));

            // Remove a book from the library
            } else if (choice == 4) {
                // Ask the user for the serial number of the book they want to delete
                System.out.println("Enter the books serial Number that you want to Delete : ");
                int userChoice = sc.nextInt();
                // Get the Book object from the library using its serial number
                Book book = library.getBook(library.findBook(userChoice));
                // Remove the book from the library
                library.removeBook(book);

            // List all books in the library
            } else if(choice == 5) {
                library.getAllBook();
            }
        } while (true); // Keep repeating the main menu until the program
                        // is terminated by the user. This is achieved by
                        // using a while loop with a condition of true.
                        // The loop will keep running until the user
                        // terminates the program by manually ending it or
                        // entering a specific input to indicate program termination.
  }
}
//L|ibrary
class Library {
// Declaring an array of objects of class Book and a variable count
Book[] books;
public int count;

// Constructor of the class Library
public Library() {
    // Initializing the array with size 90 and count with 0
    books = new Book[90];
    count = 0;
}

// A method to return the number of books in the library
public int countBooks() {
    return count;
}

// A method to find a book with a given serial number and return its index, or -1 if not found
public int findBook(int sNo) {
    for (int i = 0; i < count; i++) {
        if (books[i].getsNo() == sNo) {
            return i;
        }
    }
    return -1;
}

// A method to get a book at a specific index, returns null if out of bounds
public Book getBook(int index) {
    if (index >= 0 && index <= count) {
        return books[index];
    }
    return null;
}

// A method to add a book to the library, returns true if added successfully, false otherwise
public boolean addBook(Book b) {
    if (count < books.length && findBook(b.getsNo()) == -1) {
        books[count] = b;
        count++;
        return true;
    }
    return false;

}

// A method to remove a book from the library, returns true if removed successfully, false otherwise
public boolean removeBook(Book b){
    int index = findBook(b.getsNo());
    if (index != -1) {
        for (int i = index; i < (count - 1); i++) {
            books[i] = books[i+1]; // Shift left.
        }
        count--;
        return true;
    }
    return false;
}

// A method to print information of all books in the library
public void getAllBook() {
    System.out.println("All the book in the system are: " + "\r\n");

    for(int i = 0; i < count; i++){
        System.out.println(books[i]);
        System.out.println("\r\n");
    }

}

// A method to display the main menu of the library system
public void displayMainMenu(){
    System.out.println("********************Welcome To The Library************************");
    System.out.println("         Library Menu");
    System.out.println("1: Add a book.");
    System.out.println("2: Get a book information.");
    System.out.println("3: Update a book information.");
    System.out.println("4: Delete the book.");
    System.out.println("5: Print all books.");
    System.out.println("**********" + "\r\n");
}
}
// Book
class Book {

//instance variables
private int sNo;
private String bookName;
private String authorName;

//parameterized constructor
Book(int sN, String bookN,String authorN){
    //assigning values to instance variables
    this.sNo = sN;
    this.bookName = bookN;
    this.authorName = authorN;
}

//Default constructor
Book(){

}

//getter method to return value of instance variable sNo
public int getsNo(){
    return sNo;
}

//getter method to return value of instance variable bookName
public String getBookName(){
    return bookName;
}

//getter method to return value of instance variable authorName
public String getAuthorName(){
    return authorName;
}

//setter method to assign value to instance variable sNo
public void setsNo(int sNo){
    this.sNo = sNo;
}

//setter method to assign value to instance variable bookName
public void setBookName(String bookName){
    this.bookName = bookName;
}

//setter method to assign value to instance variable authorName
public void setAuthorName(String authorName){
    this.authorName = authorName;
}

//creating an object of Scanner class to take input from user
Scanner sc = new Scanner(System.in);

//method to display book menu
public void bookMenu() {
    System.out.println("1: Enter Serial Number of a Book.");
    //taking integer input from user and assigning it to instance variable sNo
    this.sNo = sc.nextInt();
    System.out.println("2: Enter Book Name: ");
    //taking string input from user and assigning it to instance variable bookName
    this.bookName = sc.next();
    System.out.println("3: Enter Author Name: ");
    //taking string input from user and assigning it to instance variable authorName
    this.authorName = sc.next();
}

//method to display update options
public void userUpdateDisplay(){
    System.out.println("1: To change the Serial Number of Book.");
    System.out.println("2: To change the Book Name.");
    System.out.println("3: To change the Author Name.");
}

//override toString method to print Book information
@Override
public String toString(){
    return " Serial Number: " + sNo + "\r\n" + " Book Title: " + bookName + "\r\n" + " Author Name: "+ authorName;
}
}