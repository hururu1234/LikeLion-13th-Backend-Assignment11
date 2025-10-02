package com.likelion.multipartfile_assignment.iamge.domain;


import com.likelion.multipartfile_assignment.iamge.member.domain.Member;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;    // 원본 파일 이름

    private String savedFileName;       // 파일 저장 이름

    private String savedPath;           // 파일 경로

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Image(String originalFileName, String savedFileName, String savedPath) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.savedPath = savedPath;
    }

    // Image-Member 양방향 관계 설정
    public void updateMember(Member member) {
        this.member = member;
        if (member != null && member.getImage() != this) {
            member.updateImage(this);
        }
    }
}