package modules;

import model.Holiday;
import model.Country;
import model.Tradition;

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
    /**
     * @param tradition Изменяемая традиция
     * @param newDescription Новое описание
     */
    //change description.
    public void edit(Tradition tradition, string newDescription){
        int index = searchIndex(tradition);
        tradition.setDescription(newDescription);
        //Замена элемента.
        t_list.set(index, tradition);
    }
    //change country.
    public void edit(Tradition tradition, Country newCountry){
        int index = searchIndex(tradition);
        tradition.setCountry(newCountry);
        t_list.set(index, tradition);
    }
    //change country name.
    public void edit(Tradition tradition, string newCountry){
        int index = searchIndex(tradition);
        tradition.getCountry().setName(newCountry);
        t_list.set(index, tradition);
    }
    //change holiday -> name
    public void edit(Tradition tradition, string newName){
        int index = searchIndex(tradition);
        tradition.getHoliday().setName(newName);
        t_list.set(index, tradition);
    }
    //change holiday -> dateStart
    public void edit(Tradition tradition, date dateStart){
        int index = searchIndex(tradition);
        tradition.getHoliday().setStartDate(dateStart);
        t_list.set(index, tradition);
    }
    //change holiday -> dateEnd
    public void edit(Tradition tradition, date dateEnd){
        int index = searchIndex(tradition);
        tradition.getHoliday().setStartDate(dateEnd);
        t_list.set(index, tradition);
    }
    //remove
    public void remove(Tradition tradition){
        int index = searchIndex(tradition);
        t_list.remove(index);
    }
}
