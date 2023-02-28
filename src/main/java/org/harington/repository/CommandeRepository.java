package org.harington.repository;

import org.harington.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    @Query("SELECT c FROM Commande c WHERE c.client.id=:id")
    List<Commande> findCommandeByClient(Long id);
}
