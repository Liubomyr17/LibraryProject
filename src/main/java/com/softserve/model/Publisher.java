package com.softserve.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 512, nullable = false)
    private String name;

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                '}';
    }
}
