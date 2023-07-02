package br.com.imd.pd.bus.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.imd.pd.bus.models.Parada;
import br.com.imd.pd.bus.models.Rota;

public class HttpUtils {
    public static String post(String url, Map<String, String> headers, String body) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Define o método HTTP para POST
        con.setRequestMethod("POST");

        // Adiciona os headers da requisição
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        // Habilita o envio do corpo da requisição
        con.setDoOutput(true);

        // Define o corpo da requisição
        con.getOutputStream().write(body.getBytes("UTF-8"));

        // Realiza a requisição HTTP e recebe a resposta
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static List<Rota> getRotas(String url, Map<String, String> headers) throws IOException {
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    // Define o método HTTP para GET
    con.setRequestMethod("GET");

    // Adiciona os headers da requisição
    if (headers != null) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    // Realiza a requisição HTTP e recebe a resposta
    int responseCode = con.getResponseCode();
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();

    // Converte a resposta JSON em uma lista de objetos Rota
    ObjectMapper mapper = new ObjectMapper();
    List<Map<String, Object>> rotaMapList = mapper.readValue(response.toString(), new TypeReference<List<Map<String, Object>>>() {});
    List<Rota> rotas = new ArrayList<>();

    for (Map<String, Object> rotaMap : rotaMapList) {
        String id = (String) rotaMap.get("id");
        String type = (String) rotaMap.get("type");
        String identificador = (String) ((Map<String, Object>) rotaMap.get("identificador")).get("value");
        List<Map<String, Object>> paradasMapList = (List<Map<String, Object>>) ((Map<String, Object>) rotaMap.get("paradas")).get("value");
        List<Parada> paradas = new ArrayList<>();

        for (Map<String, Object> paradaMap : paradasMapList) {
            List<String> horarios = (List<String>) ((Map<String, Object>) paradaMap.get("horarios")).get("value");
            String nomepara = (String) ((Map<String, Object>) paradaMap.get("nomepara")).get("value");
            double latitude = (double) ((Map<String, Object>) paradaMap.get("latitude")).get("value");
            double longitude = (double) ((Map<String, Object>) paradaMap.get("longitude")).get("value");

            Parada parada = new Parada(horarios, nomepara, latitude, longitude);
            paradas.add(parada);
        }

        Rota rota = new Rota(id, type, identificador, paradas);
        rotas.add(rota);
    }

    return rotas;
}


}
