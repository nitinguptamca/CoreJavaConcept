package com.immutable;

class MutableBook {
    private String title;

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}

public class ImmutableReader {
    private final MutableBook readersBook;
    private final int page;

    public ImmutableReader(MutableBook book) {
        this(book, 0);
    }

    private ImmutableReader(MutableBook book, int page){
        this.page = page;

        // Make copy to ensure this books state won't change.
        MutableBook bookCopy = new MutableBook();
        bookCopy.setTitle(book.getTitle());
        this.readersBook = bookCopy;
    }


    public MutableBook getBook() {
        // Do not return the book, but a new copy. Do not want the readers
        // book to change it's state if developer changes book after this call.
        MutableBook bookCopy = new MutableBook();
        bookCopy.setTitle(this.readersBook.getTitle());
        return bookCopy;
    }

    public int getPage() {
        // primitives are already immutable.
        return page;
    }

    /**
    * Must return reader instance since it's state has changed.
    **/ 
    public ImmutableReader turnPage() {
        return new ImmutableReader(this.readersBook, page + 1);
    }
}
