package com.book.fidibo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    public Book(){}
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("book_type")
    @Expose
    private String bookType;
    @SerializedName("book_title")
    @Expose
    private String bookTitle;
    @SerializedName("book_url")
    @Expose
    private String bookUrl;
    @SerializedName("book_thumbnail_b")
    @Expose
    private String bookThumbnailB;
    @SerializedName("book_thumbnail_s")
    @Expose
    private String bookThumbnailS;
    @SerializedName("book_numbers")
    @Expose
    private String bookNumbers;
    @SerializedName("book_publisher")
    @Expose
    private String bookPublisher;
    @SerializedName("book_description")
    @Expose
    private String bookDescription;
    @SerializedName("total_rate")
    @Expose
    private String totalRate;
    @SerializedName("rate_avg")
    @Expose
    private String rateAvg;
    @SerializedName("total_views")
    @Expose
    private String totalViews;
    @SerializedName("total_download")
    @Expose
    private String totalDownload;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_image_thumb")
    @Expose
    private String categoryImageThumb;

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

}

