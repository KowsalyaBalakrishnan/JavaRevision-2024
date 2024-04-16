package org.patterns.design.solid.SRP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Book {    // Book DTO

    private int isbn;
    private String name;
    private String author;

    @Override
    public String toString() {
        return
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", author='" + author;
    }
}

// Maintaining Book Records - Add / Remove
@Data
class BookRecords {

    private final List<Book> books = new ArrayList<>();

    public void addNewBook(Book book) {
        books.add(book);
    }

    public void addMoreBooks(List<Book> bookList) {
        books.addAll(bookList);
    }

    public void removeBook(Book book) {
        Optional<Book> existingBook = books.stream()
                .filter(streamData -> streamData.getIsbn() == book.getIsbn())
                .findFirst();

        if (existingBook.isPresent()) {
            books.remove(book);
        }
    }

    public List<Book> getBookList() {
        return this.books;
    }
}

// Separation of Concerns
class FilePersistence {
    public void saveBooksToFile(List<Book> books) {

        try (FileWriter fileWriter = new FileWriter("books.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Book book : books) {
                bufferedWriter.write(book.toString() + System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class SingleResponsibilityImpl {

    public static void main(String[] args) throws IOException {
        Book book1 = new Book(1, "Atomic Habits", "James Clear");
        Book book2 = new Book(2, "5am Club", "Robert");
        Book book3 = new Book(3, "SOLID Principles", "Martin");

        BookRecords bookRecords = new BookRecords();
        bookRecords.addMoreBooks(Arrays.asList(book1, book2, book3));

        Book book4 = new Book(4, "Agile Methodologies", "Sarannia");
        bookRecords.addNewBook(book4);

        System.out.println("*********All Books*********");
        bookRecords.getBookList().forEach(System.out::println);

        bookRecords.removeBook(book4);
        System.out.println("*********After Removal*********");
        bookRecords.getBookList().forEach(System.out::println);

        System.out.println("*********Writing Data to File*********");
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveBooksToFile(bookRecords.getBookList());
        System.out.println("*********File Written*********");

    }
}
