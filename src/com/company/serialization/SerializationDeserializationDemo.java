package com.company.serialization;

import java.io.*;

public class SerializationDeserializationDemo {
    public static void main(String[] args) {
        Student student = new Student("D valens", 30, "Gatsibo");
        student.setX(10);

        String filename = "./serdeser.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);

            objOut.close();
            fileOut.close();

            System.out.println("Object has been serialised successfully : \n" + student);

        } catch (IOException ex) {
            System.out.println("IOException caught " + ex.getMessage());
        }

        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try{
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);

            Student object = (Student) objIn.readObject();

            objIn.close();
            fileIn.close();

            System.out.println("Object has been deserialized successfully: \n" + object);
            System.out.println("Value of x : " + object.getX());

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException caught " + ex.getMessage());
        }
    }
}
