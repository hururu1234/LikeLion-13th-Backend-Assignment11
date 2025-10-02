package com.likelion.multipartfile_assignment.iamge.member.domain;

import com.likelion.multipartfile_assignment.iamge.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @Builder
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Member-Image 양방향 관계 설정
    public void updateImage(Image image) {
        if (this.image != null) {
            this.image.updateMember(null);
        }
        this.image = image;
        if (image != null && image.getMember() != this) {
            image.updateMember(this);
        }
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}