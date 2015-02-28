package modules;

import model.Holiday;
import model.Country;
import model.Tradition;
import java.util.List;
import java.util.Date;

public class Functionality {
    private List<Holiday> h_list;
    private List<Country> c_list;
    private List<Tradition> t_list;
    /*****************************
     * Constructors
     *****************************/
    public Functionality() { }
    /****************************
     * Methods
     ****************************/
    //Заполняем списки.
    public void add(Tradition tradition,
                    List<Holiday> h_list, List<Country> c_list, List<Tradition> t_list){
        this.h_list = h_list;
        this.c_list = c_list;
        this.t_list = t_list;
        h_list.add(tradition.getHoliday());
        c_list.add(tradition.getCountry());
        t_list.add(tradition);
    }
    /*
    public void add(Holiday holiday, Country country, Tradition tradition,
                    List<Holiday> h_list, List<Country> c_list, List<Tradition> t_list){
        this.h_list = h_list;
        this.c_list = c_list;
        this.t_list = t_list;
        h_list.add(holiday);
        c_list.add(country);
        t_list.add(tradition);
    }
    */
    private int searchIndex(Tradition tradition){
        int index = -1;
        for (Tradition item : t_list){
            //tradition.equals(item) ? index = t_list.indexOf(item) : continue;
            if (tradition.equals(item))
                index = t_list.indexOf(item);
        }
        return index;
    }
    //change country.
    public void edit(Tradition tradition, Country newCountry){
        int index = searchIndex(tradition);
        tradition.setCountry(newCountry);
        t_list.set(index, tradition);
    }
    /**
     * 
     * @param tradition Изменяемая традиция.
     * @param newStr Новое строковое значение.
     * @param param 1 - set new description;
     *              2 - set new country name;
     *              3 - set new holiday name.
     */
    public void edit(Tradition tradition, String newStr, int param){
        int index = searchIndex(tradition);
        switch (param) {
            case 1 : tradition.setDescription(newStr); break;
            case 2 : tradition.getCountry().setName(newStr); break;
            case 3 : tradition.getHoliday().setName(newStr); break;
            default: break;
        }
        t_list.set(index, tradition);
    }
    //change holiday -> dateStart

    /**
     * 
     * @param tradition Изменяемая традиция
     * @param newDate Новая дата.
     * @param param 1 - change start date;
     *              2 - change end date.
     */
    public void edit(Tradition tradition, Date newDate, int param){
        int index = searchIndex(tradition);
        switch (param){
            case 1 : tradition.getHoliday().setStartDate(newDate); break;
            case 2 : tradition.getHoliday().setEndDate(newDate); break;
            default: break;
        }
        t_list.set(index, tradition);
    }
    //remove
    public void remove(Tradition tradition){
        int index = searchIndex(tradition);
        t_list.remove(index);
    }
}
