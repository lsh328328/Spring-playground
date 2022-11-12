package com.sopt31th.server.domain.chat;

import com.sopt31th.server.domain.common.AuditingTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chat extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String chatImage;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @Builder
    public Chat(String chatImage, String name, String content) {
        this.chatImage = chatImage;
        this.name = name;
        this.content = content;
    }
}
