package com.likelion.multipartfile_assignment.iamge.domain.repository;


import com.likelion.multipartfile_assignment.iamge.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<Image, Long> {
}