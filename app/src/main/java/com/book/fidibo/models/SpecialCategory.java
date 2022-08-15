package com.book.fidibo.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_specialCategory")
public class SpecialCategory implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    private int book_id;

    public SpecialCategory(){}

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("cat_id")
    @Expose
    @ColumnInfo(name = "cat_id")
    private String catId;

    @SerializedName("book_type")
    @Expose
    @ColumnInfo(name = "book_type")
    private String bookType;

    @SerializedName("book_title")
    @Expose
    @ColumnInfo(name = "book_title")
    private String bookTitle;

    @SerializedName("book_url")
    @Expose
    @ColumnInfo(name = "book_url")
    private String bookUrl;

    @SerializedName("book_thumbnail_b")
    @Expose
    @ColumnInfo(name = "book_thumbnail_b")
    private String bookThumbnailB;

    @SerializedName("book_thumbnail_s")
    @Expose
    @ColumnInfo(name = "book_thumbnail_s" )
    private String bookThumbnailS;

    @SerializedName("book_numbers")
    @Expose
    @ColumnInfo(name = "book_numbers" )
    private String bookNumbers;

    @SerializedName("book_publisher")
    @Expose
    @ColumnInfo(name = "book_publisher")
    private String bookPublisher;

    @SerializedName("book_description")
    @Expose
    @ColumnInfo(name = "book_description")
    private String bookDescription;

    @SerializedName("total_rate")
    @Expose
    @ColumnInfo(name = "total_rate")
    private String totalRate;

    @SerializedName("rate_avg")
    @Expose
    @ColumnInfo(name = "rate_avg")
    private String rateAvg;

    @SerializedName("total_views")
    @Expose
    @ColumnInfo(name = "total_views")
    private String totalViews;

    @SerializedName("total_download")
    @Expose
    @ColumnInfo(name = "total_download")
    private String totalDownload;

    @SerializedName("cid")
    @Expose
    @ColumnInfo(name = "cid")
    private String cid;

    @SerializedName("category_name")
    @Expose
    @ColumnInfo(name = "category_name")
    private String categoryName;


    @SerializedName("category_image")
    @Expose
    @ColumnInfo(name = "category_image")
    private String categoryImage;

    @SerializedName("category_image_thumb")
    @Expose
    @ColumnInfo(name = "category_image_thumb")
    private String categoryImageThumb;

    @Ignore
    public SpecialCategory(int book_id, String id, String catId, String bookType, String bookTitle, String bookUrl, String bookThumbnailB, String bookThumbnailS, String bookNumbers, String bookPublisher, String bookDescription, String totalRate, String rateAvg, String totalViews, String totalDownload, String cid, String categoryName, String categoryImage, String categoryImageThumb) {
        this.book_id = book_id;
        this.id = id;
        this.catId = catId;
        this.bookType = bookType;
        this.bookTitle = bookTitle;
        this.bookUrl = bookUrl;
        this.bookThumbnailB = bookThumbnailB;
        this.bookThumbnailS = bookThumbnailS;
        this.bookNumbers = bookNumbers;
        this.bookPublisher = bookPublisher;
        this.bookDescription = bookDescription;
        this.totalRate = totalRate;
        this.rateAvg = rateAvg;
        this.totalViews = totalViews;
        this.totalDownload = totalDownload;
        this.cid = cid;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryImageThumb = categoryImageThumb;
    }

    public SpecialCategory(String id, String catId, String bookType, String bookTitle, String bookUrl, String bookThumbnailB, String bookThumbnailS, String bookNumbers, String bookPublisher, String bookDescription, String totalRate, String rateAvg, String totalViews, String totalDownload, String cid, String categoryName, String categoryImage, String categoryImageThumb) {
        this.id = id;
        this.catId = catId;
        this.bookType = bookType;
        this.bookTitle = bookTitle;
        this.bookUrl = bookUrl;
        this.bookThumbnailB = bookThumbnailB;
        this.bookThumbnailS = bookThumbnailS;
        this.bookNumbers = bookNumbers;
        this.bookPublisher = bookPublisher;
        this.bookDescription = bookDescription;
        this.totalRate = totalRate;
        this.rateAvg = rateAvg;
        this.totalViews = totalViews;
        this.totalDownload = totalDownload;
        this.cid = cid;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryImageThumb = categoryImageThumb;
    }


    protected SpecialCategory(Parcel in) {
        book_id = in.readInt();
        id = in.readString();
        catId = in.readString();
        bookType = in.readString();
        bookTitle = in.readString();
        bookUrl = in.readString();
        bookThumbnailB = in.readString();
        bookThumbnailS = in.readString();
        bookNumbers = in.readString();
        bookPublisher = in.readString();
        bookDescription = in.readString();
        totalRate = in.readString();
        rateAvg = in.readString();
        totalViews = in.readString();
        totalDownload = in.readString();
        cid = in.readString();
        categoryName = in.readString();
        categoryImage = in.readString();
        categoryImageThumb = in.readString();
    }

    public static final Creator<SpecialCategory> CREATOR = new Creator<SpecialCategory>() {
        @Override
        public SpecialCategory createFromParcel(Parcel in) {
            return new SpecialCategory(in);
        }

        @Override
        public SpecialCategory[] newArray(int size) {
            return new SpecialCategory[size];
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
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

    public String getBookThumbnailB() {
        return bookThumbnailB;
    }

    public void setBookThumbnailB(String bookThumbnailB) {
        this.bookThumbnailB = bookThumbnailB;
    }

    public String getBookThumbnailS() {
        return bookThumbnailS;
    }

    public void setBookThumbnailS(String bookThumbnailS) {
        this.bookThumbnailS = bookThumbnailS;
    }

    public String getBookNumbers() {
        return bookNumbers;
    }

    public void setBookNumbers(String bookNumbers) {
        this.bookNumbers = bookNumbers;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(String totalDownload) {
        this.totalDownload = totalDownload;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryImageThumb() {
        return categoryImageThumb;
    }

    public void setCategoryImageThumb(String categoryImageThumb) {
        this.categoryImageThumb = categoryImageThumb;
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
        parcel.writeString(bookType);
        parcel.writeString(bookTitle);
        parcel.writeString(bookUrl);
        parcel.writeString(bookThumbnailB);
        parcel.writeString(bookThumbnailS);
        parcel.writeString(bookNumbers);
        parcel.writeString(bookPublisher);
        parcel.writeString(bookDescription);
        parcel.writeString(totalRate);
        parcel.writeString(rateAvg);
        parcel.writeString(totalViews);
        parcel.writeString(totalDownload);
        parcel.writeString(cid);
        parcel.writeString(categoryName);
        parcel.writeString(categoryImage);
        parcel.writeString(categoryImageThumb);
    }
}
