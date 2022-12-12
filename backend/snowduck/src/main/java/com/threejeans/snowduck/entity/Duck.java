package com.threejeans.snowduck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Duck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duck_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String color;

    @OneToMany(mappedBy = "duck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DuckAccessory> duckAccessories = new ArrayList<>();

    @OneToOne(mappedBy = "duck")
    private User user;

    @OneToOne(mappedBy = "duck")
    private Mail mail;

    @Builder
    public Duck(String name, String color, List<DuckAccessory> duckAccessories, User user, Mail mail) {
        this.name = name;
        this.color = color;
        this.duckAccessories = duckAccessories;
        this.user = user;
        this.mail = mail;
    }
}
