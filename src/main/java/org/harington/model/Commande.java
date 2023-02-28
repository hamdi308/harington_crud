package org.harington.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "commandes")
@Data
@Builder
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    private Client client;
    @OneToMany(mappedBy = "id")
    private List<Product> product;
}
