package com.nbchand.brs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-02-24
 */
@Entity
@Table(name = "tbl_author", uniqueConstraints = {
        @UniqueConstraint(name = "UK_Author_Email", columnNames = {"email"}),
        @UniqueConstraint(name = "UK_Author_Mobile", columnNames = {"mobileNumber"})
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Author_SEQ_GEN")
    @SequenceGenerator(name = "Author_SEQ_GEN", sequenceName = "Author_SEQ", allocationSize = 1)
    private Integer id;

    private String name;

    private String email;

    private String mobileNumber;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;
}
