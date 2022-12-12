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
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "accessory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DuckAccessory> duckAccessories = new ArrayList<>();

    @Builder
    public Accessory(String name, List<DuckAccessory> duckAccessories) {
        this.name = name;
        this.duckAccessories = duckAccessories;
    }
}
