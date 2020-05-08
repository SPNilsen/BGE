package org.bge.ccportal.model;

public class GlobalFlag {

    private int id;
    private boolean emergency;
    private boolean weather;

    public GlobalFlag() {
    }

    public GlobalFlag(int id, boolean emergency, boolean weather) {
        this.id = id;
        this.emergency = emergency;
        this.weather = weather;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the emergency
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * @param emergency the emergency to set
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     * @return the weather
     */
    public boolean isWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(boolean weather) {
        this.weather = weather;
    }

    public String describe(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ")
                .append(this.id)
                .append(", Weather: ")
                .append(this.weather)
                .append(", Emergency: ")
                .append(this.emergency);
        return sb.toString();
    }
}
