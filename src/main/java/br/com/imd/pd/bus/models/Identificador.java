package br.com.imd.pd.bus.models;

import java.util.Map;

public class Identificador {
    private String type;
    private String value;
    private Map<String, Object> metadata;

    public Identificador() {
    }

    public Identificador(String type, String value, Map<String, Object> metadata) {
        this.type = type;
        this.value = value;
        this.metadata = metadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
