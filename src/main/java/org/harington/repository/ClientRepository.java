package org.harington.repository;

import org.harington.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE c.name=:name AND c.secondName=:secName")
    public Client findClientByNameSecName(@Param("name") String name,@Param("secName") String secName);

}
