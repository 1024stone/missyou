package com.example.missyou.api.v1;

import com.example.missyou.exception.http.NotFoundException;
import com.example.missyou.model.BannerEntity;
import com.example.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public BannerEntity getByName(@PathVariable String name){
        BannerEntity bannerEntity = bannerService.getByName(name);
        if (bannerEntity==null){
            throw new NotFoundException(30005);
        }
        return bannerService.getByName(name);
    }


}
