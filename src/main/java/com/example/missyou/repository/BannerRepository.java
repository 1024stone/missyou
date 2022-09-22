package com.example.missyou.repository;

import com.example.missyou.model.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BannerRepository extends JpaRepository<BannerEntity,Long> {

    BannerEntity findOneById(Long id);

    BannerEntity findOneByName(String name);



}
