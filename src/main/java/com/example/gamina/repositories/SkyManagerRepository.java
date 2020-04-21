package com.example.gamina.repositories;

import com.example.gamina.tableObjects.SkyManager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkyManagerRepository extends CrudRepository<SkyManager, Integer> {
    List<SkyManager> findByManagerId(Integer id);

    List<SkyManager> findByManagerIdAndFirstName(Integer id, String firstName);

    List<SkyManager> findByManagerIdAndLastName(Integer id, String lastName);

    List<SkyManager> findByFirstName(String firstName);

    List<SkyManager> findByLastName(String lastName);

    List<SkyManager> findByFirstNameAndLastName(String firstName, String lastName);

    List<SkyManager> findByManagerIdAndFirstNameAndLastName(Integer id, String firstName, String lastName);

    void deleteByManagerId(Integer id);

    @Modifying
    @Query("update SkyManager m set m.firstName = ?1 where m.managerId = ?2")
    void setFirstNameFor(String firstName, Integer id);

    @Modifying
    @Query("update SkyManager m set m.lastName = ?1 where m.managerId = ?2")
    void setLastNameFor(String lastName, Integer id);

    @Modifying
    @Query("update SkyManager m set m.email = ?1 where m.managerId = ?2")
    void setEmailFor(String email, Integer id);

    @Modifying
    @Query("update SkyManager m set m.phoneNumber = ?1 where m.managerId = ?2")
    void setPhoneNumberFor(String phoneNumber, Integer id);


}
