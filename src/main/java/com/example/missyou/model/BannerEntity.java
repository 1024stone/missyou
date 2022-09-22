package com.example.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "banner", schema = "missyou", catalog = "")
public class BannerEntity extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "img")
    private String img;

    @JoinColumn(name = "banner_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<BannerItemEntity> items;



}
