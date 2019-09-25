package com.github.sindrebn;

public class Ansatt {

    public final int id;
    public final String fornavn;
    public final int faggrupe;

    public Ansatt(int id, String fornavn, int faggrupe) {
        this.id = id;
        this.fornavn = fornavn;
        this.faggrupe = faggrupe;
    }

    @Override
    public String toString() {
        return "Ansatt #" + id + ": " + fornavn;
    }
}
