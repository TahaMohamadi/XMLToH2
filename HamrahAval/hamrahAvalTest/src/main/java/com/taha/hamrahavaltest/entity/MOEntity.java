package com.taha.hamrahavaltest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mo_entity")
public class MOEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String fdn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MOTreeEntity moTree;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MO_ID")
    private List<AttrEntity> attrs;

}