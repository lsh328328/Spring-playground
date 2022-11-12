package com.sopt31th.server.domain.music;

import com.sopt31th.server.domain.common.AuditingTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Music extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String singer;

    @Column(nullable = false)
    private String image;

    @Builder
    public Music(String title, String singer, String image) {
        this.title = title;
        this.singer = singer;
        this.image = image;
    }
}
