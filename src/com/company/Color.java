package com.company;

public enum Color {
    WHITE("белый"),
    BLACK("черный") ,
    GREY("серый"),
    RED("красный"),
    BLUE("синий");

    private String translate;

    Color(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
