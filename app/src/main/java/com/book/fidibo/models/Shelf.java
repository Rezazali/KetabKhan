package com.book.fidibo.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_shelf")
public class Shelf {

    @PrimaryKey(autoGenerate = true)
    private
    int Shelf_id;

    public Shelf(){

    }

    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "shelfTitle")
    private String shelfTitle;

    @ColumnInfo(name = "number")
    private int number;

    public Shelf(String shelfTitle) {

        this.shelfTitle = shelfTitle;

    }

    public int getShelf_id() {
        return Shelf_id;
    }

    public void setShelf_id(int shelf_id) {
        Shelf_id = shelf_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShelfTitle() {
        return shelfTitle;
    }

    public void setShelfTitle(String shelfTitle) {
        this.shelfTitle = shelfTitle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
