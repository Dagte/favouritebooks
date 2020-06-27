package com.miku.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "series")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
public class SeriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer authorId;
}
