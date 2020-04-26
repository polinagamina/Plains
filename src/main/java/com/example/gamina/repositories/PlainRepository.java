package com.example.gamina.repositories;

import com.example.gamina.tableObjects.Plain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlainRepository extends CrudRepository<Plain,Integer> {

    List<Plain> findByPlainId(Integer plainId);
    List<Plain> findByHexId(String hexId);



    List<Plain> findByFlight(String flight);

    void deleteByPlainId(Integer id);
    void deleteByHexId(String hexId);

    @Modifying
    @Query("update Plain m set m.flight = ?1 where m.hexId = ?2")
    void setFlightF(String flight, String id);

    @Modifying
    @Query("update Plain m set m.speed = ?1 where m.hexId = ?2")
    void setSpeedF(String speed, String id);

    @Modifying
    @Query("update Plain m set m.altitude = ?1 where m.hexId = ?2")
    void setAltitudeF(String altitude, String id);

    @Modifying
    @Query("update Plain m set m.latitude = ?1 where m.hexId = ?2")
    void setLatitudeF(String latitude, String id);

    @Modifying
    @Query("update Plain m set m.longitude = ?1 where m.hexId = ?2")
    void setLongitudeF(String longitude, String id);

    @Modifying
    @Query("update Plain m set m.track = ?1 where m.hexId = ?2")
    void setTrackF(String track, String id);
    @Modifying
    @Query("update Plain m set m.hexId = ?1 where m.plainId = ?2")
    void setHexIdFor(String hexId, Integer id);

    @Modifying
    @Query("update Plain m set m.flight = ?1 where m.plainId = ?2")
    void setFlightFor(String flight, Integer id);

    @Modifying
    @Query("update Plain m set m.speed = ?1 where m.plainId = ?2")
    void setSpeedFor(String speed, Integer id);

    @Modifying
    @Query("update Plain m set m.altitude = ?1 where m.plainId = ?2")
    void setAltitudeFor(String altitude, Integer id);

    @Modifying
    @Query("update Plain m set m.latitude = ?1 where m.plainId = ?2")
    void setLatitudeFor(String latitude, Integer id);

    @Modifying
    @Query("update Plain m set m.longitude = ?1 where m.plainId = ?2")
    void setLongitudeFor(String longitude, Integer id);

    @Modifying
    @Query("update Plain m set m.track = ?1 where m.plainId = ?2")
    void setTrackFor(String track, Integer id);
}

