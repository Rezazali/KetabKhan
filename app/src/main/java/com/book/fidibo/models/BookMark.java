package com.book.fidibo.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_book_mark")
public class BookMark implements Parcelable{


    @PrimaryKey(autoGenerate = true)
    private int book_id;

    public BookMark(){

    }

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("cat_id")
    @Expose
    @ColumnInfo(name = "cat_id")
    private String catId;


    @SerializedName("book_title")
    @Expose
    @ColumnInfo(name = "book_title")
    private String bookTitle;

    @SerializedName("book_url")
    @Expose
    @ColumnInfo(name = "book_url")
    private String bookUrl;


    @SerializedName("book_thumbnail_s")
    @Expose
    @ColumnInfo(name = "book_thumbnail_s" )
    private String bookThumbnailS;


    @SerializedName("book_publisher")
    @Expose
    @ColumnInfo(name = "book_publisher")
    private String bookPublisher;


    @SerializedName("category_name")
    @Expose
    @ColumnInfo(name = "category_name")
    private String categoryName;


    @SerializedName("book_description")
    @Expose
    @ColumnInfo(name = "book_description")
    private String bookDescription;


    @Ignore
    public BookMark(int book_id, String id, String catId, String bookTitle, String bookUrl, String bookThumbnailS, String bookPublisher, String categoryName, String bookDescription) {
        this.book_id = book_id;
        this.id = id;
        this.catId = catId;
        this.bookTitle = bookTitle;
        this.bookUrl = bookUrl;
        this.bookThumbnailS = bookThumbnailS;
        this.bookPublisher = bookPublisher;
        this.categoryName = categoryName;
        this.bookDescription = bookDescription;
    }

    public BookMark(String id, String catId, String bookTitle, String bookUrl, String bookThumbnailS, String bookPublisher, String categoryName, String bookDescription) {
        this.id = id;
        this.catId = catId;
        this.bookTitle = bookTitle;
        this.bookUrl = bookUrl;
        this.bookThumbnailS = bookThumbnailS;
        this.bookPublisher = bookPublisher;
        this.categoryName = categoryName;
        this.bookDescription = bookDescription;
    }

    protected BookMark(Parcel in) {
        book_id = in.readInt();
        id = in.readString();
        catId = in.readString();
        bookTitle = in.readString();
        bookUrl = in.readString();
        bookThumbnailS = in.readString();
        bookPublisher = in.readString();
        categoryName = in.readString();
        bookDescription = in.readString();
    }

    public static final Creator<BookMark> CREATOR = new Creator<BookMark>() {
        @Override
        public BookMark createFromParcel(Parcel in) {
            return new BookMark(in);
        }

        @Override
        public BookMark[] newArray(int size) {
            return new BookMark[size];
        }
    };

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookThumbnailS() {
        return bookThumbnailS;
    }

    public void setBookThumbnailS(String bookThumbnailS) {
        this.bookThumbnailS = bookThumbnailS;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(book_id);
        parcel.writeString(id);
        parcel.writeString(catId);
        parcel.writeString(bookTitle);
        parcel.writeString(bookUrl);
        parcel.writeString(bookThumbnailS);
        parcel.writeString(bookPublisher);
        parcel.writeString(categoryName);
        parcel.writeString(bookDescription);
    }
}
