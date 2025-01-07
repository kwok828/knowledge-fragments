package com.gzt.design._1iterator.exercise;

import com.gzt.design._1iterator.Aggregate;
import com.gzt.design._1iterator.Book;
import com.gzt.design._1iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelfList implements Aggregate {

    private List<Book> books;

    private int index;

    public BookShelfList(int capacity) {
        this.books = new ArrayList<Book>(capacity);
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getSize() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfListIterator(this);
    }
}
