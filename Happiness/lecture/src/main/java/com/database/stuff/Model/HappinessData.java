package com.database.stuff.Model;

public class HappinessData {

    private int id;
    private String country_name;
    private double total_score;
    private double pure_dystopia;
    private double dystopia_residual;
    private double gdp;
    private double corruption;
    private double life_expectancy;
    private double social_support;
    private double generosity;
    private double personal_autonomy;

    public HappinessData(int id, String country_name, double total_score, double dystopia, double residual, double gdp, double corruption, double life_expectancy, double social_support, double generosity, double personal_autonomy) {
        this.id = id;
        this.country_name = country_name;
        this.total_score = total_score;
        this.pure_dystopia = dystopia;
        this.dystopia_residual = residual;
        this.gdp = gdp;
        this.corruption = corruption;
        this.life_expectancy = life_expectancy;
        this.social_support = social_support;
        this.generosity = generosity;
        this.personal_autonomy = personal_autonomy;
    }



    public HappinessData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public double getDystopia() {
        return pure_dystopia;
    }

    public void setDystopia(double dystopia) {
        this.pure_dystopia = dystopia;
    }

    public double getResidual() {
        return dystopia_residual;
    }

    public void setResidual(double residual) {
        this.dystopia_residual = residual;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public double getCorruption() {
        return corruption;
    }

    public void setCorruption(double corruption) {
        this.corruption = corruption;
    }

    public double getLife_expectancy() {
        return life_expectancy;
    }

    public void setLife_expectancy(double life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public double getSocial_support() {
        return social_support;
    }

    public void setSocial_support(double social_support) {
        this.social_support = social_support;
    }

    public double getGenerosity() {
        return generosity;
    }

    public void setGenerosity(double generosity) {
        this.generosity = generosity;
    }

    public double getPersonal_autonomy() {
        return personal_autonomy;
    }

    public void setPersonal_autonomy(double personal_autonomy) {
        this.personal_autonomy = personal_autonomy;
    }

    @Override
    public String toString() {
        return "HappinessData{" +
                "id=" + id +
                ", country_name='" + country_name + '\'' +
                ", total_score=" + total_score +
                ", dystopia=" + pure_dystopia +
                ", residual=" + dystopia_residual +
                ", gdp=" + gdp +
                ", corruption=" + corruption +
                ", life_expectancy=" + life_expectancy +
                ", social_support=" + social_support +
                ", generosity=" + generosity +
                ", personal_autonomy=" + personal_autonomy +
                '}';
    }
}
