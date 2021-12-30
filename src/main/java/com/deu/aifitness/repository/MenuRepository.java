package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
