package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jdk.nashorn.api.tree.NewTree;
import ua.lviv.iot.managers.LawyerManager;
import ua.lviv.iot.managers.LawyerManagerImpl;
import ua.lviv.iot.managers.Main;
import ua.lviv.iot.models.Advocate;
import ua.lviv.iot.models.Lawsuit;
import ua.lviv.iot.models.Lawyer;
import ua.lviv.iot.models.Notary;

class LawyerManagerTest {

    static LawyerManager lawyer;

    @BeforeAll
    public static void setUp() {
        Lawyer stepan = new Advocate(0, 0.0, "Stepan", Lawsuit.EVIDECECOLLECTION, 10);
        Lawyer vlad = new Advocate(3, 10.0, "Vlad", Lawsuit.CONTRUCTCONSULTION, 12);
        Lawyer taras = new Advocate(2, 10.0, "Taras", Lawsuit.CONTRUCTCONSULTION, 11);

        lawyer = new LawyerManagerImpl();

        lawyer.addlawyer(vlad);
        lawyer.addlawyer(stepan);
        lawyer.addlawyer(taras);
		
		File file = new File("C:\\lawyerlist.csv");
        LawyerWriter.writeToFile(lawyer.getLawyerList());
        assertTrue(file.exists());

    }

    @Test
    void testAdd() {
        LawyerManagerImpl LMI = new LawyerManagerImpl();
        Lawyer vlad = new Advocate(2, 10.0, "Vlad", Lawsuit.CONTRUCTCONSULTION, 12);
        Lawyer taras = new Advocate(2, 10.0, "Taras", Lawsuit.CONTRUCTCONSULTION, 11);
        LMI.addlawyer(vlad);
        LMI.addlawyer(taras);
        assert (LMI.getLawyerList().get(0).getName() == "Vlad");
        assertEquals(LMI.getLawyerList().get(1).getName(), "Taras");
        List<Lawyer> ll = new LinkedList<Lawyer>();
        ll.add(vlad);
        ll.add(taras);
    }

    @Test
    void testSortByNames() {
        lawyer.sortbyName(lawyer.getLawyerList());
        assertEquals("Stepan", lawyer.getLawyerList().get(0).getName());
        assertEquals("Taras", lawyer.getLawyerList().get(1).getName());
        assertEquals("Vlad", lawyer.getLawyerList().get(2).getName());
    }

    @Test
    void testSortByExpeAsc() {
        lawyer.sortbyExpirience(lawyer.getLawyerList());
        assertEquals(0, lawyer.getLawyerList().get(0).getExpirience());
        assertEquals(2, lawyer.getLawyerList().get(1).getExpirience());
        assertEquals(3, lawyer.getLawyerList().get(2).getExpirience());
    }

    @Test
    void testSerch() {

        Lawyer stepan = new Advocate(0, 0.0, "Stepan", Lawsuit.EVIDECECOLLECTION, 10);
        Lawyer vlad = new Advocate(2, 10.0, "Vlad", Lawsuit.CONTRUCTCONSULTION, 12);
        LawyerManagerImpl LMI = new LawyerManagerImpl();
        LMI.addlawyer(vlad);
        LMI.addlawyer(stepan);
        assertEquals(LMI.searchAdvocateServices(LMI.getLawyerList(), Lawsuit.EVIDECECOLLECTION).get(0), stepan);
        assertEquals(LMI.searchAdvocateServices(LMI.getLawyerList(), Lawsuit.CONTRUCTCONSULTION).get(0), vlad);
        assertNotEquals(LMI.searchNotaryServices(LMI.getLawyerList(), Lawsuit.EVIDECECOLLECTION).get(0), vlad);

    }

    @Test
    void testSet() {
        LawyerManagerImpl LMI = new LawyerManagerImpl();
        Lawyer vlad = new Advocate(2, 10.0, "Vlad", Lawsuit.CONTRUCTCONSULTION, 12);
        Lawyer atos = new Notary(2, 4.3, "Atos", Lawsuit.MAKINGCLAIM);
        List<Lawyer> ll = new LinkedList<Lawyer>();
        ll.add(vlad);
        ll.add(atos);
        LMI.setLawyerList(ll);
        assert (LMI.getLawyerList().get(0) == vlad);
        assert (LMI.getLawyerList().get(1) == atos);
    }

    @Test
    void testMainSet() {

        Notary n = new Notary();
        n.setExpirience(100);
        n.setNotaryDistrict("Lviv");
        n.setPricePerCase(1234);
        assertEquals(n.getExpirience(), 100);
        assertEquals(n.getNotaryDistrict(), "Lviv");
        assertEquals(n.getPricePerCase(), 1234);
        n.setLs(Lawsuit.MAKINGCLAIM);
        assert (n.getLs() == Lawsuit.MAKINGCLAIM);
        n.setName("Serhiy");
        assertEquals(n.getName(), "Serhiy");
        Lawyer la = new Advocate();
        la.setRaiting(1.1);
        assertEquals(la.getRaiting(), 1.1);
    }
}
