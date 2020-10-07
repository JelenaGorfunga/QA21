package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private Coord coord;

    @JsonProperty("weather")
    private List<Weather> weathers;
    private String base;
    private Main main;
    private Double visibility;
    private Wind wind;
    private Clouds clouds;
    private Double dt;
    private Sys sys;
    private Double id;
    private String name;
    private Double cod;


    public Coord getCoord() {

        return coord;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCod() {
        return cod;
    }

    public void setCod(Double cod) {
        this.cod = cod;
    }

    public void setCoord(Coord coord) {

        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
