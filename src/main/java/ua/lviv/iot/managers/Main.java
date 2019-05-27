package ua.lviv.iot.managers;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.models.Advocate;
import ua.lviv.iot.models.Lawsuit;
import ua.lviv.iot.models.Lawyer;

public class Main {

    public static void main(String[] args) {
        LawyerManagerImpl manager = new LawyerManagerImpl();
        List<Lawyer> listOfLawyers = new LinkedList<Lawyer>();
        Lawyer stepan = new Advocate(0, 0.0, "Stepan", Lawsuit.EVIDECECOLLECTION, 10);
        Lawyer vlad = new Advocate(2, 10.0, "Vlad", Lawsuit.CONSTRUCTCONSULTION, 12);
        Lawyer taras = new Advocate(3, 10.0, "Taras", Lawsuit.CONSTRUCTCONSULTION, 11);
        Lawyer mykola = new Advocate(2, 10.0, "Mikhael", Lawsuit.CONSTRUCTCONSULTION, 23);
        Lawyer nord = new Advocate(10, 10.0, "Daniel", Lawsuit.CONSTRUCTCONSULTION, 12);
        listOfLawyers.add(stepan);
        listOfLawyers.add(vlad);
        listOfLawyers.add(taras);
        listOfLawyers.add(mykola);
        listOfLawyers.add(nord);

        List<Lawyer> listResult = manager.searchAdvocateServices(listOfLawyers, Lawsuit.CONSTRUCTCONSULTION);
        for (int i = 0; i < listResult.size(); i++) {
            System.out.println(listResult.get(i).getName());
        }

        List<Lawyer> listResults = manager.sortbyName(listResult);

        for (int i = 0; i < listResults.size(); i++) {
            System.out.println(listResults.get(i).getName());
        }

        List<Lawyer> listResultes = manager.sortbyExpirience(listResult);

        for (int i = 0; i < listResultes.size(); i++) {
            System.out.println(listResultes.get(i).getExpirience());
        }
    }
}