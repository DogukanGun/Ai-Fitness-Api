package com.deu.aifitness.model.dto.menu;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {

    private Integer id;

    private String menuName;

    private ArrayList<MenuItemDto> menuItems;


}
