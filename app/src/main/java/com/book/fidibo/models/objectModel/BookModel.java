package com.book.fidibo.models.objectModel;

import com.book.fidibo.models.Book;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookModel {

    public BookModel(){}
    @SerializedName("ONLINE_Book")
    @Expose
    private List<Book> oNLINEBook = null;

    public List<Book> getONLINEBook() {
        return oNLINEBook;
    }

    public void setONLINEBook(List<Book> oNLINEBook) {
        this.oNLINEBook = oNLINEBook;
    }

}

