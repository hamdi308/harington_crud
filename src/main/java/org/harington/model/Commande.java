package org.harington.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "client")
    private Client client;
    @Column(name="products"n )
    private List<Product> product;
}
