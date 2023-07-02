package br.com.imd.pd.bus.models;

import java.util.List;

public class Rota {
    private String id;
    private String type;
    private String identificador;
    private List<Parada> paradas;

    public Rota() {
    }

    public Rota(String id, String type, String identificador, List<Parada> paradas) {
        this.id = id;
        this.type = type;
        this.identificador = identificador;
        this.paradas = paradas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }
}
