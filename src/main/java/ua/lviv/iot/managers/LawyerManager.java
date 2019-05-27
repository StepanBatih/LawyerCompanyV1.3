package ua.lviv.iot.managers;

import java.util.List;

import ua.lviv.iot.models.Lawsuit;
import ua.lviv.iot.models.Lawyer;

public interface LawyerManager {

    List<Lawyer> searchAdvocateServices(List<Lawyer> list, Lawsuit ls);

    List<Lawyer> searchNotaryServices(List<Lawyer> list, Lawsuit ls);

    void addlawyer(Lawyer lawyer);

    List<Lawyer> sortbyName(List<Lawyer> lawyers);

    List<Lawyer> sortbyExpirience(List<Lawyer> lawyers);
}