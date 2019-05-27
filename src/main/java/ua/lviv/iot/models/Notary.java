package ua.lviv.iot.models;

public class Notary extends Lawyer {

    private String notaryDistrict;
    private int pricePerCase;

    public Notary() {

    }

    public Notary(int expirience, double raiting, String name, Lawsuit ls) {
        super(expirience, raiting, name, ls);
    }

    public final String getNotaryDistrict() {
        return notaryDistrict;
    }

    public final void setNotaryDistrict(String notaryDistrict) {
        this.notaryDistrict = notaryDistrict;
    }

    public final int getPricePerCase() {
        return pricePerCase;
    }

    public final void setPricePerCase(int pricePerCase) {
        this.pricePerCase = pricePerCase;
    }
}