package com.example.missyou.api.v1;

import com.example.missyou.dto.PersonDTO;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @PostMapping("/test/{id}")
    public PersonDTO test(@PathVariable(name = "id") @Range(min = 1,max = 10,message = "1-10之间") Integer id,
                          @RequestParam String name,
                          @RequestBody @Validated PersonDTO person) {

//        PersonDTO personDTO2 = new PersonDTO("echo");
        return person;
    }
}
