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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String password;

    @OneToOne
    @JoinColumn(name = "duck_id")
    private Duck duck;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mail> receivedMails  = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mail> sendMails  = new ArrayList<>();

    @Builder
    public User(String name, String email, String password, Duck duck, List<Mail> receivedMails, List<Mail> sendMails) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.duck = duck;
        this.receivedMails = receivedMails;
        this.sendMails = sendMails;
    }
}
