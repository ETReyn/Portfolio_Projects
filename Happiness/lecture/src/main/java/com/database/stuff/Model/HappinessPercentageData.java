package com.database.stuff.Model;

public class HappinessPercentageData {

    private int id;
    private String country_name;
    private double total_score;
    private double residual_percentage;
    private double gdp_percentage;
    private double corruption_percentage;
    private double life_expectancy_percentage;
    private double social_support_percentage;
    private double generosity_percentage;
    private double personal_autonomy_percentage;

    public HappinessPercentageData(int id, String country_name, double total_score, double residual_percentage, double gdp_percentage, double corruption_percentage, double life_expectancy_percentage, double social_support_percentage, double generosity_percentage, double personal_autonomy_percentage) {
        this.id = id;
        this.country_name = country_name;
        this.total_score = total_score;
        this.residual_percentage = residual_percentage;
        this.gdp_percentage = gdp_percentage;
        this.corruption_percentage = corruption_percentage;
        this.life_expectancy_percentage = life_expectancy_percentage;
        this.social_support_percentage = social_support_percentage;
        this.generosity_percentage = generosity_percentage;
        this.personal_autonomy_percentage = personal_autonomy_percentage;
    }

    public HappinessPercentageData()
    {

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

    public double getResidual_percentage() {
        return residual_percentage;
    }

    public void setResidual_percentage(double residual_percentage) {
        this.residual_percentage = residual_percentage;
    }

    public double getGdp_percentage() {
        return gdp_percentage;
    }

    public void setGdp_percentage(double gdp_percentage) {
        this.gdp_percentage = gdp_percentage;
    }

    public double getCorruption_percentage() {
        return corruption_percentage;
    }

    public void setCorruption_percentage(double corruption_percentage) {
        this.corruption_percentage = corruption_percentage;
    }

    public double getLife_expectancy_percentage() {
        return life_expectancy_percentage;
    }

    public void setLife_expectancy_percentage(double life_expectancy_percentage) {
        this.life_expectancy_percentage = life_expectancy_percentage;
    }

    public double getSocial_support_percentage() {
        return social_support_percentage;
    }

    public void setSocial_support_percentage(double social_support_percentage) {
        this.social_support_percentage = social_support_percentage;
    }

    public double getGenerosity_percentage() {
        return generosity_percentage;
    }

    public void setGenerosity_percentage(double generosity_percentage) {
        this.generosity_percentage = generosity_percentage;
    }

    public double getPersonal_autonomy_percentage() {
        return personal_autonomy_percentage;
    }

    public void setPersonal_autonomy_percentage(double personal_autonomy_percentage) {
        this.personal_autonomy_percentage = personal_autonomy_percentage;
    }

    @Override
    public String toString() {
        return "HappinessPercentageData{" +
                "id=" + id +
                ", country_name='" + country_name + '\'' +
                ", total_score=" + total_score +
                ", residual_percentage=" + residual_percentage +
                ", gdp_percentage=" + gdp_percentage +
                ", corruption_percentage=" + corruption_percentage +
                ", life_expectancy_percentage=" + life_expectancy_percentage +
                ", social_support_percentage=" + social_support_percentage +
                ", generosity_percentage=" + generosity_percentage +
                ", personal_autonomy_percentage=" + personal_autonomy_percentage +
                '}';
    }
}
