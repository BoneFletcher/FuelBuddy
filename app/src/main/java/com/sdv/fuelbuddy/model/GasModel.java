package com.sdv.fuelbuddy.model;



public class GasModel {
    private String cost, hours, icon, name, adress, distance;
    private double lat, lng;

    public GasModel() {
    }

    public GasModel(String cost, String hours, String icon, String name, String adress, String distance, double lat, double lng) {
        this.cost = cost;
        this.hours = hours;
        this.icon = icon;
        this.name = name;
        this.adress = adress;
        this.distance = distance;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCost() {
        return cost;
    }

    public String getHours() {
        return hours;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getDistance() {
        return distance;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GasModel gasModel = (GasModel) o;

        if (Double.compare(gasModel.lat, lat) != 0) return false;
        if (Double.compare(gasModel.lng, lng) != 0) return false;
        if (cost != null ? !cost.equals(gasModel.cost) : gasModel.cost != null) return false;
        if (hours != null ? !hours.equals(gasModel.hours) : gasModel.hours != null) return false;
        if (icon != null ? !icon.equals(gasModel.icon) : gasModel.icon != null) return false;
        if (name != null ? !name.equals(gasModel.name) : gasModel.name != null) return false;
        if (adress != null ? !adress.equals(gasModel.adress) : gasModel.adress != null)
            return false;
        return distance != null ? distance.equals(gasModel.distance) : gasModel.distance == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cost != null ? cost.hashCode() : 0;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
