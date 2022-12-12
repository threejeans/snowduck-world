package com.threejeans.snowduck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(length = 50)
    private String senderName;

    @Column(length = 50)
    private String title;

    private String content;

    @CreatedDate
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_id")
    private Emotion emotion;

    @OneToOne
    @JoinColumn(name = "duck_id")
    private Duck duck;

    @Builder
    public Mail(User receiver, User sender, String senderName, String title, String content, LocalDateTime created, Emotion emotion, Duck duck) {
        this.receiver = receiver;
        this.sender = sender;
        this.senderName = senderName;
        this.title = title;
        this.content = content;
        this.created = created;
        this.emotion = emotion;
        this.duck = duck;
    }
}
