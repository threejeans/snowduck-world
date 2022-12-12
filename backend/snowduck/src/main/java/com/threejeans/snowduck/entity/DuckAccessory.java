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
public class DuckAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duck_accessory_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duck_id")
    private Duck duck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

    @Builder
    public DuckAccessory(Duck duck, Accessory accessory) {
        this.duck = duck;
        this.accessory = accessory;
    }
}
