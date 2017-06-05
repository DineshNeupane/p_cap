package com.neupanedinesh.models;


import java.io.Serializable;

public class CardItemModel implements Serializable {

    public String title;
    public String content;

    public CardItemModel(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
