package com.example.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "banner_item", schema = "missyou", catalog = "")
public class BannerItemEntity extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "keyword")
    private String keyword;
    @Basic
    @Column(name = "type")
    private Integer type;

    @Basic
    @Column(name = "banner_id")
    private Long bannerId;
    @Basic
    @Column(name = "name")
    private String name;

}
