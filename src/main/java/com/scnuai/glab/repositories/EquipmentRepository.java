package com.scnuai.glab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scnuai.glab.models.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
