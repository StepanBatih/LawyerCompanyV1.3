package ua.lviv.iot.models;

public abstract class Lawyer {

    private int expirience;
    private double raiting;
    private String name;
    private Lawsuit ls;

    public Lawyer() {
    }

    public Lawyer(final int expirience, double raiting, String name, Lawsuit ls) {
        super();
        this.expirience = expirience;
        this.raiting = raiting;
        this.name = name;
        this.ls = ls;

    }

    public final Lawsuit getLs() {
        return ls;
    }

    public final void setLs(Lawsuit ls) {
        this.ls = ls;
    }

    public final int getExpirience() {
        return expirience;
    }

    public final void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    public final double getRaiting() {
        return raiting;
    }

    public final void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }
}