package com.example.gamina.tableObjects;


import javax.persistence.*;

@Entity
@Table(name = "plains")

public class Plain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Plain_id")
    private Integer plainId;

    @Column(name = "HEX_id", nullable = false)
    private String HexId;

    @Column(name = "Flight")
    private String flight;

    @Column(name = "Altitude")
    private String altitude;

    @Column(name = "Speed")
    private String speed;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "Track")
    private String track;




    public Integer getPlainId() {
        return plainId;
    }

    public void setPlainId(Integer plainId) {
        this.plainId = plainId;
    }

    public String getHexId() {
        return HexId;
    }

    public void setHexId(String hexId) {
        HexId = hexId;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }



}
