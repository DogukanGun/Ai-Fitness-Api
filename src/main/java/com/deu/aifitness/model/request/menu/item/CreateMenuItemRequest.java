package com.deu.aifitness.model.request.menu.item;

import com.deu.aifitness.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMenuItemRequest {

    private String menuItemName;

    private UserType userType;

    private Integer menuId;
}
