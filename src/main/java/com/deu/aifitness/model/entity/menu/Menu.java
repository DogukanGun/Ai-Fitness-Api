package com.deu.aifitness.model.entity.menu;


import com.deu.aifitness.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
@SuperBuilder
@SQLDelete(sql="Update menu SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String menuName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "menu")
    private List<MenuItem> menuItems;


}
