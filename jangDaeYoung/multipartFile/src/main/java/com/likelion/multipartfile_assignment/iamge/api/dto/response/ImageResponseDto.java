package com.likelion.multipartfile_assignment.iamge.api.dto.response;
public record ImageResponseDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {}