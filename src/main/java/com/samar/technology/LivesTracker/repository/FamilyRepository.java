package com.samar.technology.LivesTracker.repository;

import com.samar.technology.LivesTracker.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long> {
}