package com.book.fidibo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryModel {

    public CategoryModel(){}
    @SerializedName("ONLINE_Book")
    @Expose
    private List<Category> categoryList = null;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> oNLINEBook) {
        this.categoryList = oNLINEBook;
    }


}
