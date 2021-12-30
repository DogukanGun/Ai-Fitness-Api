package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.menu.MenuTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTagRepository extends JpaRepository<MenuTag,Integer> {
}
