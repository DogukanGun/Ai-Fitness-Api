package com.deu.aifitness.model.dto.menu;


import com.deu.aifitness.model.entity.menu.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuTagDto {

    private Integer id;

    private String tag;

    private MenuItemDto menuItemDto;
}
