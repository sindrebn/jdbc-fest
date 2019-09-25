package com.github.sindrebn;

public class Faggruppe {

    public final int id;
    public final String navn;

    public Faggruppe(int id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Faggruppe #" + id + ": " + navn;
    }
}
