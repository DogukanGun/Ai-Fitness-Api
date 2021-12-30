package com.deu.aifitness.model.entity.menu;


import com.deu.aifitness.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_tag")
@SuperBuilder
@SQLDelete(sql="Update menu_tag SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class MenuTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tag;

    @Column(name = "menu_item_id")
    private Integer menuItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id",insertable = false,updatable = false)
    private MenuItem menuItem;


}

