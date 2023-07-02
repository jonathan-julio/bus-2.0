package br.com.imd.pd.bus.models;

import java.util.List;

public class Parada {
    private List<String> horarios;
    private String nomepara;
    private double latitude;
    private double longitude;

    public Parada() {
    }

    public Parada(List<String> horarios, String nomepara, double latitude, double longitude) {
        this.horarios = horarios;
        this.nomepara = nomepara;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public String getNomepara() {
        return nomepara;
    }

    public void setNomepara(String nomepara) {
        this.nomepara = nomepara;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
