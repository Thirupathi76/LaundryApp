package com.marolix.laundryapp.models.Products;

public class CategoryModel {
    private String categoryBrief = "";
    private String categoryId = "";
    private String categoryImage = "";
    private String categoryName = "";

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getCategoryImage() {
        return this.categoryImage;
    }

    public void setCategoryImage(String str) {
        this.categoryImage = str;
    }

    public String getCategoryBrief() {
        return this.categoryBrief;
    }

    public void setCategoryBrief(String str) {
        this.categoryBrief = str;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }
}
