package com.emergentes.modelo;

public class Registro {

    private int id;
    private String nombre;
    private int primer;
    private int segundo;
    private int exfinal;
    int suma = 0;
    int suma1 = 0;

    public Registro() {
        id=0;
        nombre="";
        primer=0;
        segundo=0;
        exfinal=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimer() {
        return primer;
    }

    public void setPrimer(int primer) {
        this.primer = primer;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getExfinal() {
        return exfinal;
    }

    public void setExfinal(int exfinal) {
        this.exfinal = exfinal;
    }

    public int suma(int primer, int segundo, int exfinal) {
        suma = primer + segundo + exfinal;
        suma1 = suma;
        return suma;
    }

}
