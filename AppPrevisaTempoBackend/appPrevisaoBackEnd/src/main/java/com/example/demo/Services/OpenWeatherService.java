package com.example.demo.Services;

import com.example.demo.DTOs.OpenWeatherDTO;
import com.example.demo.DTOs.PrevisaoChuvaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenWeatherService {
    @Value("${openweather.api.url}")
    private String openWeatherApiUrl;

    @Value("${openweather.api.key}")
    private String openWeatherApiKey;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public OpenWeatherService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public OpenWeatherDTO getWeather(String city) {
        String url = openWeatherApiUrl + "?q=" + city + "&appid=" + openWeatherApiKey + "&units=metric&lang=pt_br";
        ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);

        JsonNode json = response.getBody();
        JsonNode cityInfo = json.get("city");
        JsonNode previsoes = json.get("list");
        JsonNode agora = previsoes.get(0);

        OpenWeatherDTO dto = new OpenWeatherDTO();

        dto.setCidade(cityInfo.get("name").asText());
        dto.setPais(cityInfo.get("country").asText());
        dto.setTemperatura(agora.get("main").get("temp").asDouble());
        dto.setSensacaoTermica(agora.get("main").get("feels_like").asDouble());
        dto.setHumidade(agora.get("main").get("humidity").asInt());
        dto.setVelocidadeVento(agora.get("wind").get("speed").asDouble());

        List<PrevisaoChuvaDTO> listaPrevisoes = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm")
                .withZone(ZoneId.of("America/Sao_Paulo"));

        for (int i = 0; i < 10 && i < previsoes.size(); i++) { // até 48 horas (16 previsões) máximo de 40 previsões
            JsonNode previsao = previsoes.get(i);
            long timestamp = previsao.get("dt").asLong() * 1000L;

            double pop = previsao.has("pop") ? previsao.get("pop").asDouble() * 100 : 0.0;
            String descricao = previsao.get("weather").get(0).get("description").asText();

            PrevisaoChuvaDTO previsaoDTO = new PrevisaoChuvaDTO();
            previsaoDTO.setDataHora(formatter.format(Instant.ofEpochMilli(timestamp)));
            previsaoDTO.setPrecitacao(String.format("%.0f%%", pop));
            previsaoDTO.setDescricao(descricao);

            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (int j = 0; j < 8 && j < previsoes.size(); j++) {
                JsonNode previsaoMinMax = previsoes.get(j);
                double tempMin = previsaoMinMax.get("main").get("temp_min").asDouble();
                double tempMax = previsaoMinMax.get("main").get("temp_max").asDouble();

                if (tempMin < min) min = tempMin;
                if (tempMax > max) max = tempMax;
            }

            dto.setTempMinima(min);
            dto.setTempMaxima(max);


            listaPrevisoes.add(previsaoDTO);
        }

        dto.setPrevisoesChuva(listaPrevisoes);
        return dto;
    }
}
