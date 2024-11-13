package com.samar.technology.LivesTracker.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table(name="family")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @CollectionTable(name = "family_members_relations", joinColumns = @JoinColumn(name = "family_id"))
    @MapKeyColumn(name = "relation")
    @Column(name = "person_name")
    private Map<String, String> members;


}
