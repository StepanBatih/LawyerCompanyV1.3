package ua.lviv.iot.managers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.models.Lawsuit;
import ua.lviv.iot.models.Lawyer;

public class LawyerManagerImpl implements LawyerManager {

    private List<Lawyer> lawyerList = new LinkedList<Lawyer>();

    public final void addlawyer(Lawyer lawyer) {
        lawyerList.add(lawyer);
    }

    public final List<Lawyer> sortbyName(List<Lawyer> lawyers) {

        Collections.sort(lawyers, Comparator.comparing(Lawyer::getName));
        return lawyers;
    }

    public final List<Lawyer> sortbyExpirience(List<Lawyer> lawyersss) {

        Collections.sort(lawyersss, Comparator.comparing(Lawyer::getExpirience));
        return lawyersss;
    }

    public final List<Lawyer> searchAdvocateServices(List<Lawyer> list, Lawsuit ls) {
        List<Lawyer> searchedList = new LinkedList<Lawyer>();
        for (Lawyer lawyer : list) {
            if (ls.equals(lawyer.getLs())) {
                searchedList.add(lawyer);
            }
        }
        return searchedList;
    }

    public final List<Lawyer> searchNotaryServices(List<Lawyer> list, Lawsuit ls) {
        List<Lawyer> searchedList = new LinkedList<Lawyer>();
        for (Lawyer lawyer : list) {
            if (ls.equals(lawyer.getLs())) {
                searchedList.add(lawyer);
            }
        }
        return searchedList;

    }

    public final List<Lawyer> getlawyerList() {
        return lawyerList;
    }

    public final void setlawyerList(List<Lawyer> lawyerList) {
        this.lawyerList = lawyerList;
    }
}