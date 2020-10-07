package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requestors.WeatherRequester;

public class WeatherStepDefs {
    private String city;
    private String country;
    private Response response;

    @Given("city is: {string}")
    public void set_city(String city) {

        this.city = city;
    }

    @Given("country is: {string}")
    public void set_country(String country) {

        this.country = country.toLowerCase();
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city,country);
    }

    @Then("lon is: {double}")
    public void check_lon(Double lon) {

        Assertions.assertEquals(lon, response.getCoord().getLon(),"Wrong lon value");
    }

    @Then("lat is: {double}")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat value");

    }

    @Then("weathers id is: {int}")
    public void check_id(int id) {
        Assertions.assertEquals(id, response.getWeathers().get(0).getId(), "Wrong id value in weathers list");
    }

    @Then("main is: {string}")
    public void check_main(String main) {
        Assertions.assertEquals(main, response.getWeathers().get(0).getMain(), "Wrong main value");

    }

    @Then("description is: {string}")
    public void check_description(String description) {
        Assertions.assertEquals(description, response.getWeathers().get(0).getDescription(), "Wrong description value");
    }

    @Then("icon is: {string}")
    public void check_icon(String icon) {
        Assertions.assertEquals(icon, response.getWeathers().get(0).getIcon(), "Wrong icon");
            }

    @Then("base is: {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base value");
    }

    @Then("temp is: {double}")
    public void check_temp(Double temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong temp value");
    }

    @Then("pressure is: {double}")
    public void check_pressure(Double pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure value");
    }

    @Then("humidity is: {double}")
    public void check_humidity(Double humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong humidity value");
    }

    @Then("temp_min is: {double}")
    public void check_temp_min(Double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong temp_min value");
    }

    @Then("temp_max is: {double}")
    public void check_temp_max(Double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong temp_max value");
    }

    @Then("visibility is: {double}")
    public void check_visibility(Double visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility value");
    }

    @Then("speed is: {double}")
    public void check_speed(Double speed) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong speed value");
    }

    @Then("deg is: {double}")
    public void check_deg(Double deg) {
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong deg value");
    }

    @Then("all is: {double}")
    public void check_all(Double all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "Wrong all value");
    }

    @Then("dt is: {double}")
    public void check_dt(Double dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt value");
    }

    @Then("type is: {double}")
    public void check_type(Double type) {
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong type value");
    }

    @Then("sys id is: {double}")
    public void check_id_1(Double id) {
        Assertions.assertEquals(id, response.getSys().getId(), "Wrong id value in Sys object");
    }

    @Then("message is: {double}")
    public void check_message(Double message) {
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong message value");
    }

    @Then("sys country is: {string}")
    public void check_country(String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong country value in Sys object");
    }

    @Then("sunrise is: {double}")
    public void check_sunrise(Double sunrise) {
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise value");
    }

    @Then("sunset is: {double}")
    public void check_sunset(Double sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong sunset value");
    }

    @Then("id is: {double}")
    public void check_id_2(Double id) {
        Assertions.assertEquals(id, response.getId(), "Wrong id value in response");
    }

    @Then("name is: {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name value");
    }

    @Then("cod is: {double}")
    public void check_cod(Double cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod value");
    }

}
