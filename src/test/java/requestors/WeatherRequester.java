package requestors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";

    //Prepare URL - PREFIX + city + "," + country + POSTFIX
    public Response requestWeather(String city, String country) throws JsonProcessingException {
        String url = PREFIX + city + "," + country + POSTFIX;

        // Send Request and receive answer
        RestTemplate restTemplate = new RestTemplate();
        // v getForEntity mi kladjom 2 vida dannix - url i Json
        String responseToParse = restTemplate.getForEntity(url, String.class).getBody();

        // konvertiruem json v object response
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseToParse, Response.class);

    }


}
