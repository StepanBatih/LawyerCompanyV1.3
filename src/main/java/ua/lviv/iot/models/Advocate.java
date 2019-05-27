package ua.lviv.iot.models;

public class Advocate extends Lawyer {

    private String companyName;
    private int pricePerHour;
    private Specialization specialization;

    public Advocate() {

    }

    public Advocate(int expirience, double raiting, String name, Lawsuit ls, int pricePerHour) {
        super(expirience, raiting, name, ls);
        this.pricePerHour = pricePerHour;

    }

    public Advocate(int i, double d, String string, Specialization sp, int j) {

    }

    public final String getCompanyName() {
        return companyName;
    }

    public final void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public final int getPricePerHour() {
        return pricePerHour;
    }

    public final void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public final Specialization getSpecialization() {
        return specialization;
    }

    public final void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}