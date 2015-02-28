package main;

import model.Country;
import model.Holiday;
import model.Tradition;

import java.util.ArrayList;
import java.util.LinkedList;

import static modules.UserInterface.init;

public class MainClass {

    public static LinkedList<Holiday> holidays = new LinkedList<Holiday>();
    private static LinkedList<Country> countries = new LinkedList<Country>();
    private static ArrayList<Tradition> traditions = new ArrayList<Tradition>();

    public static void main(String[] args) {
        init();
    }
}
