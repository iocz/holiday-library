package modules;

import model.Holiday;
import model.Country;
import model.HolidayType;
import model.Tradition;

import java.io.PrintWriter;
import java.util.List;
import java.util.Date;
import java.util.ResourceBundle;

public class Functionality {
    //private static List<Holiday> h_list;
    //private static List<Country> c_list;
    //private static List<Tradition> t_list;
    protected static ResourceBundle stringsBundle = null;
    private static PrintWriter out = new PrintWriter(System.out, true);
    /*****************************
     * Constructors
     *****************************/
    //public Functionality() { }
    /****************************
     * Methods
     ****************************/
    //Заполняем списки.
    //Добавить новую страну.
    public static void add(String name, List<Country> list){
        try {
            Country country = new Country(name);
            list.add(country);
        }
        //catch (RuntimeException exc) {out.println(stringsBundle.getString("ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    /*
    public static void add(Country country, List<Country> c_list){
        c_list.add(country);
    }
    */
    //Добавить новый праздник.
    public static void add(List<Holiday> h_list, String name ){
        try {
            Holiday holiday = new Holiday(name);
            h_list.add(holiday);
        }
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void add(List<Holiday> h_list, String name, int typeNum){
        try {
            Holiday holiday = new Holiday(name, typeNum);
            h_list.add(holiday);
        }
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void add(List<Holiday> h_list, String name, Date start,  Date end, int typeNum){
        try {
            Holiday holiday = new Holiday(name, start, end, typeNum);
            h_list.add(holiday);
        }
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    //Добавить традицию.
    public static void add(Holiday holiday, Country country, List<Tradition> t_list){
        try {
            Tradition tradition = new Tradition(holiday, country);
            t_list.add(tradition);
        }
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void add(Holiday holiday, String description, Country country, List<Tradition> t_list){
        try {
            Tradition tradition = new Tradition(holiday, country);
            tradition.setDescription(description);
            t_list.add(tradition);
        }
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    private static int searchIndex(Tradition tradition, List<Tradition> t_list){
        int index = -1;
            for (Tradition item : t_list) {
                //tradition.equals(item) ? index = t_list.indexOf(item) : continue;
                if (tradition.equals(item))
                    index = t_list.indexOf(item);
            }
            if (index == -1) throw new IllegalArgumentException("Index not found");
        return index;
    }
    private static int searchIndex(Holiday holiday, List<Holiday> h_list){
        int index = -1;
        for (Holiday item : h_list){
            //tradition.equals(item) ? index = t_list.indexOf(item) : continue;
            if (holiday.equals(item))
                index = h_list.indexOf(item);
        }
        if (index == -1) throw new IllegalArgumentException("Index not found");
        return index;
    }
    private static int searchIndex(Country country, List<Country> c_list){
        int index = -1;
        for (Country item : c_list){
            //tradition.equals(item) ? index = t_list.indexOf(item) : continue;
            if (country.equals(item))
                index = c_list.indexOf(item);
        }
        if (index == -1) throw new IllegalArgumentException("Index not found");
        return index;
    }
    public static void edit(List<Tradition> t_list, Tradition tradition, String newStr, int param){
        try {
            int index = searchIndex(tradition, t_list);
            switch (param) {
                case 1:
                    tradition.setDescription(newStr);
                    break;
                case 2:
                    tradition.getCountry().setName(newStr);
                    break;
                case 3:
                    tradition.getHoliday().setName(newStr);
                    break;
                default:
                    break;
            }
            t_list.set(index, tradition);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    //Изменение страны.
    public static void edit(List<Country> c_list, Country country, String newName){
        try {
            int index = searchIndex(country, c_list);
            country.setName(newName);
            c_list.set(index, country);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    //Изменение праздника.
    public static void edit(List<Holiday> h_list, Holiday holiday, String newName){
        try {
            int index = searchIndex(holiday, h_list);
            holiday.setName(newName);
            h_list.set(index, holiday);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void edit(List<Holiday> h_list, Holiday holiday, String newName,
                                        HolidayType type){
        try {
            int index = searchIndex(holiday, h_list);
            holiday.setName(newName);
            holiday.setType(type);
            h_list.set(index, holiday);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void edit(List<Holiday> h_list, Holiday holiday, String newName,
                            Date start, Date end, HolidayType type){
        try {
            int index = searchIndex(holiday, h_list);
            holiday.setName(newName);
            holiday.setType(type);
            holiday.setStartDate(start);
            holiday.setEndDate(end);
            h_list.set(index, holiday);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    //remove
    public static void remove(Tradition tradition, List<Tradition> t_list,
                              List<Country> c_list, List<Holiday> h_list){
        try {
            int index = searchIndex(tradition, t_list);
            t_list.remove(index);
            remove(tradition.getCountry(), c_list);
            remove(tradition.getHoliday(), h_list);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void remove(Country country, List<Country> c_list){
        try {
            int index = searchIndex(country, c_list);
            c_list.remove(index);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
    public static void remove(Holiday holiday, List<Holiday> h_list){
        try {
            int index = searchIndex(holiday, h_list);
            h_list.remove(index);
        }
        catch (IllegalArgumentException exc) {out.println(stringsBundle.getString("Index_ERROR"));}
        catch (Exception exc) {out.println(stringsBundle.getString("ERROR"));}
    }
}
