package com.example.family;

public class Animal {
    public String aName;
//    private String aSpeak;
//    private int aIcon;

    public Animal() {
    }


    public Animal(String aname
//            , String aspeak, int aicon
    ) {
        this.aName = aname;
//        this.aSpeak = aspeak;
//        this.aIcon = aicon;
    }

    public String getaName() {
        return aName;
    }
//
//    public String getaSpeak(){return aSpeak;}
//
//    public int getaIcon(){return aIcon;}

    public void setaName(String aName) {
        this.aName = aName;
    }
//
//    public void setaSpeak(String aSpeak) {
//        this.aSpeak = aSpeak;
//    }
//
//    public void setaIcon(int aIcon) {
//        this.aIcon = aIcon;
//    }
}

