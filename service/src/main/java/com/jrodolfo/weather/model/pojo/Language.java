package com.jrodolfo.weather.model.pojo;

public enum Language {
    EN("English", "e"), FR("French", "f");
    
    private final String name;
    private final String oneLetterCode;

    Language(String name, String letter) {
        this.name = name;
        this.oneLetterCode = letter;
    }
    public String getName() {
        return name;
    }
    public String getOneLetterCode() {
        return oneLetterCode;
    }
}
