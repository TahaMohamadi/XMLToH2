package com.taha.hamrahavaltest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "mo_tree")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MOTreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MO_TREE_ID")
    private List<MOEntity> moList;
}
