package service;

import exceptions.DuplicateItemException;
import exceptions.ItemDoesntExistException;
import models.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static Library instance;
    private List<Book>inventory = new ArrayList<>();

    private Library(){}
    public static Library getInstance(){
        if(instance == null){
            instance = new Library();
        }
        return instance;
    }

    public void AddBook(Book book){
        if(inventory.stream().anyMatch(bookObj->bookObj.getBookId() == book.getBookId())){
            throw new DuplicateItemException("Book ID already Exists: "+book.getBookId());
        }
        inventory.add(book);
        System.out.println("New Book added with following details:\n"+book);
    }

    public void RemoveBookByIdOrTitle(String idOrTitle){
        Book objectToRemove = inventory
                .stream()
                .filter(a->a.getTitle().toLowerCase() == idOrTitle.toLowerCase()
                 || String.valueOf(a.getBookId()).equals(idOrTitle))
                .findFirst()
                .orElseThrow(()->new ItemDoesntExistException("Book with given Info Doesnt Exist! "));
        inventory.remove(objectToRemove);
        System.out.println("Book Removed with details: "+objectToRemove);
    }
    public List<Book> SearchBooksByCriteria(String title,String author,Integer year){
        return inventory.stream().filter(book->(title == null || book.getTitle().toLowerCase().contains(title.toLowerCase()))
                            && (year == null || book.getPublicationYear() == year)
                            && (author == null || book.getAuthor().toLowerCase().equals(author.toLowerCase()))).collect(Collectors.toList());
    }

    public List<Book>ShowAllBooksSortedByYearDesc(){
        return inventory.stream().sorted(Comparator.comparingInt(Book::getPublicationYear))
                .collect(Collectors.toList());
    }



}
