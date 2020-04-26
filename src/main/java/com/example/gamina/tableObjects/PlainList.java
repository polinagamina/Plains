package com.example.gamina.tableObjects;

import lombok.Data;


@Data
public class PlainList {
    private String hexId;
    private String flight;
    private String altitude;
    private String speed;
    private String latitude;
    private String longitude;
    private String track;
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlainList other = (PlainList) obj;
        if (hexId != other.hexId)
            return false;
        if (flight != other.flight)
            return false;
        return true;
    }
}
