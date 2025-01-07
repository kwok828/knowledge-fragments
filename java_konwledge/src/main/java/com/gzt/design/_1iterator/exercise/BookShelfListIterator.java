package com.gzt.design._1iterator.exercise;

import com.gzt.design._1iterator.Iterator;

public class BookShelfListIterator implements Iterator {

    private BookShelfList bookShelfList;

    private int index;

    public BookShelfListIterator(BookShelfList bookShelfList) {
        this.bookShelfList = bookShelfList;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelfList.getSize();
    }

    @Override
    public Object next() {
        return bookShelfList.getBook(index++);
    }
}
