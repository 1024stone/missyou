package com.example.missyou.service;

import com.example.missyou.model.BannerEntity;
import com.example.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService{

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public BannerEntity getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
