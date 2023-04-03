package com.example.travelagency2.model;


public enum Type {
    BB("bed & breakfast"),
    HB("half board"),
    FB("full board"),
    AI("all inclusive"),
    OV("overnight"),
    SC("self catering");

    private final String description;

    Type(final String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
}
