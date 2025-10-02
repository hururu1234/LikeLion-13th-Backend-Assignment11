package com.likelion.multipartfile_assignment.iamge.member.api.dto.response;

import com.likelion.multipartfile_assignment.iamge.api.dto.response.ImageResponseDto;

public record MemberResponseDto(
        Long id,
        String email,
        String name,
        ImageResponseDto image
) {}
