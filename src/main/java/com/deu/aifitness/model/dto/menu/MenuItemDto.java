package com.deu.aifitness.model.dto.menu;

import com.deu.aifitness.model.entity.menu.MenuTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemDto {

    private Integer id;

    private String menuItemName;

    private ArrayList<MenuTagDto> tags;
}
