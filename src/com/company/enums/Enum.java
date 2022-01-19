package com.company.enums;

enum Color{
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    public String value;

    Color(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class Enum {
    public static void main(String args[]) throws Exception{
        Color cl = Color.RED;

        System.out.println("Red enum value : " + cl.getValue());

        for(Color clr : Color.values()){
            System.out.println("Enum value is: " + clr.getValue());
        }
    }

}
