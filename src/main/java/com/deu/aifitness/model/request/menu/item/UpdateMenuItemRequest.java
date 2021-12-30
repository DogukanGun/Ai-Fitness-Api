package com.deu.aifitness.model.request.menu.item;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMenuItemRequest {

    private String menuItemName;

    private Integer menuId;

    private Integer tagId;
}
