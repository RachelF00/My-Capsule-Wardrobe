package ui;
// Main class to run the program

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new WardrobeApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        }

    }
}
