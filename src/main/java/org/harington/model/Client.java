package org.harington.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @OneToMany(mappedBy = "id")
    private List<Commande> Listcommandes;
}
