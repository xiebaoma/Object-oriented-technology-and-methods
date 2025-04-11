import java.util.ArrayList;

class Book {
    String author;
    boolean isBorrowed;
    String name;
    double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.isBorrowed = false; // Initially, the book is not borrowed
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowStatus() {
        return isBorrowed ? "未还" : "可借";
    }

    public String getInfo() {
        return name + "，" + author + "著，" + price + "元，" + getBorrowStatus();
    }
}

class Reader {
    String name;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Library library, String bookName) {
        Book bookToBorrow = library.findBook(bookName);
        if (bookToBorrow != null && !bookToBorrow.isBorrowed()) {
            bookToBorrow.setBorrowed(true);
            System.out.println(name + " 借了《" + bookToBorrow.getName() + "》");
        } else if (bookToBorrow != null && bookToBorrow.isBorrowed()) {
            System.out.println("《" + bookToBorrow.getName() + "》已被借出。");
        } else {
            System.out.println("图书馆里没有找到《" + bookName + "》。");
        }
    }

    public void returnBook(Library library, String bookName) {
        Book bookToReturn = library.findBook(bookName);
        if (bookToReturn != null && bookToReturn.isBorrowed()) {
            bookToReturn.setBorrowed(false);
            System.out.println(name + " 还了《" + bookToReturn.getName() + "》");
        } else if (bookToReturn != null && !bookToReturn.isBorrowed()) {
            System.out.println("《" + bookToReturn.getName() + "》本来就没有被借走。");
        } else {
            System.out.println("图书馆里没有找到《" + bookName + "》。");
        }
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void getAllBooksInfo() {
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // (1) 创建一个Library的类的实例，myLittleLibrary,其中预存有以下三本书：
        Library myLittleLibrary = new Library();
        myLittleLibrary.addBook(new Book("Java程序设计", "张三", 45.0));
        myLittleLibrary.addBook(new Book("Java核心设计", "李四", 50.0));
        myLittleLibrary.addBook(new Book("Java程序设计", "王五", 38.0));

        // (2) 显示图书馆所有图书的信息
        System.out.println("图书馆所有图书信息：");
        myLittleLibrary.getAllBooksInfo();

        // (3) 创建一个Reader类的实例oneBeautifulGril，她先在myLittleLibrary中查找《Java程序设计》；
        Reader oneBeautifulGril = new Reader("小美");
        Book foundBook = myLittleLibrary.findBook("Java程序设计");
        if (foundBook != null) {
            System.out.println(oneBeautifulGril.getName() + " 找到了《" + foundBook.getName() + "》这本书。");
        } else {
            System.out.println(oneBeautifulGril.getName() + " 没有找到《Java程序设计》这本书。");
        }

        // (4) 当oneBeautifulGril借了张三著的那一本书时，显示当前图书馆所有图书的信息；
        oneBeautifulGril.borrowBook(myLittleLibrary, "Java程序设计");
        System.out.println("\n" + oneBeautifulGril.getName() + " 借书后，图书馆所有图书信息：");
        myLittleLibrary.getAllBooksInfo();

        // (5) oneBeautifulGril把书还了，再次显示图书馆中图书信息；
        oneBeautifulGril.returnBook(myLittleLibrary, "Java程序设计");
        System.out.println("\n" + oneBeautifulGril.getName() + " 还书后，图书馆所有图书信息：");
        myLittleLibrary.getAllBooksInfo();
    }
}