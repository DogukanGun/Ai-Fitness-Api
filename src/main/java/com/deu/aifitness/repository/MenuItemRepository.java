package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.menu.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {
}
