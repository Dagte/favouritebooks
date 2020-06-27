package com.miku.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer bookId;

    @Column
    private String title;

    @Column
    private String genre;

    @Column
    private Integer rating;

    @Column
    private Date dateRead;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId", insertable = false, updatable = false)
    @ToString.Exclude
    private AuthorEntity authorOfBooks;

    @Column
    private Integer authorId;

    @Column
    private Integer seriesId;

}

