package com.deu.aifitness.model.mapper;


import com.deu.aifitness.model.dto.menu.MenuDto;
import com.deu.aifitness.model.dto.menu.MenuItemDto;
import com.deu.aifitness.model.dto.menu.MenuTagDto;
import com.deu.aifitness.model.entity.menu.Menu;
import com.deu.aifitness.model.entity.menu.MenuItem;
import com.deu.aifitness.model.entity.menu.MenuTag;
import com.deu.aifitness.model.request.menu.UpdateCreateMenuRequest;
import com.deu.aifitness.model.request.menu.item.CreateMenuItemRequest;
import com.deu.aifitness.model.request.menu.item.UpdateMenuItemRequest;
import com.deu.aifitness.model.request.menu.tag.CreateMenuTagRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuMapper MENU_MAPPER = Mappers.getMapper(MenuMapper.class);

    //Menu
    MenuDto convertToMenuDto(Menu menu);

    Menu createMenu(UpdateCreateMenuRequest updateCreateMenuRequest);

    void updateMenu(@MappingTarget Menu menu,UpdateCreateMenuRequest updateCreateMenuRequest);

    //Menu Item
    MenuItem createMenuItem(CreateMenuItemRequest createMenuItemRequest);

    MenuItemDto convertToMenuItemDto(MenuItem menuItem);

    void updateMenuItem(@MappingTarget MenuItem menuItem, UpdateMenuItemRequest updateMenuItemRequest);

    //Menu Tag
    MenuTagDto convertToMenuTagDto(MenuTag menuTag);

    MenuTag createMenuTag(CreateMenuTagRequest createMenuTagRequest);
}
