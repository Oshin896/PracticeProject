package com.example.pagination.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "json_data")
public class PagingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;
}
