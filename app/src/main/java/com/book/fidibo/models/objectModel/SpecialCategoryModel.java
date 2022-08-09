package com.book.fidibo.models.objectModel;

import com.book.fidibo.models.Category;
import com.book.fidibo.models.SpecialCategory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpecialCategoryModel {


    public SpecialCategoryModel(){}
    @SerializedName("ONLINE_Book")
    @Expose
    private List<SpecialCategory> specialCategories = null;

    public List<SpecialCategory> getSpecialCategories() {
        return specialCategories;
    }

    public void setSpecialCategory(List<SpecialCategory> oNLINEBook) {
        this.specialCategories = oNLINEBook;
    }
}
