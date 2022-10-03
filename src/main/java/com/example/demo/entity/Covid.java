package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "covid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Covid {

    @Id
    private Long id;

    private String country;

    private String continent;

    private Integer active;

    private Integer death;

    private Integer recovered;
}
