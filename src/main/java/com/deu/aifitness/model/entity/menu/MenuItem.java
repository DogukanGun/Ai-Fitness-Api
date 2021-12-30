package com.deu.aifitness.model.entity.menu;


import com.deu.aifitness.model.entity.BaseEntity;
import com.deu.aifitness.model.enums.UserType;
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
@Table(name = "menu_item")
@Entity
@SuperBuilder
@SQLDelete(sql="Update menu_item SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class MenuItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String menuItemName;

    private UserType userType;

    @Column(name = "tag_id")
    private Integer tagId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "menuItem")
    private List<MenuTag> tags;

    @Column(name = "menu_id",insertable = false,updatable = false)
    private Integer menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id",insertable = false,nullable = false)
    private Menu menu;


}
