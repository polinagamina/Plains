package com.example.gamina.tableObjects;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

}
