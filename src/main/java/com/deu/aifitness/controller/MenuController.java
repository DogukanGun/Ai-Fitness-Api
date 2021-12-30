package com.deu.aifitness.controller;

import com.deu.aifitness.model.dto.menu.MenuDto;
import com.deu.aifitness.model.dto.menu.MenuItemDto;
import com.deu.aifitness.model.dto.menu.MenuTagDto;
import com.deu.aifitness.model.request.menu.UpdateCreateMenuRequest;
import com.deu.aifitness.model.request.menu.item.CreateMenuItemRequest;
import com.deu.aifitness.model.request.menu.item.UpdateMenuItemRequest;
import com.deu.aifitness.model.request.menu.tag.CreateMenuTagRequest;
import com.deu.aifitness.model.response.Response;
import com.deu.aifitness.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("menu")
public class MenuController {
    private final MenuService menuService;

    //menu
    @PostMapping("menu")
    public ResponseEntity<MenuDto> createMenu(@RequestBody UpdateCreateMenuRequest updateCreateMenuRequest){
        return menuService.createMenu(updateCreateMenuRequest);
    }
    @PostMapping("menuUpdate/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable int id, @RequestBody UpdateCreateMenuRequest updateCreateMenuRequest){
        return menuService.updateMenu(id, updateCreateMenuRequest);
    }
    @GetMapping("menu/{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable int id){
        return menuService.getMenuDto(id);
    }
    @DeleteMapping("menu/{id}")
    public ResponseEntity<Response> deleteMenu(@PathVariable int id){
        return menuService.deleteMenu(id);
    }

    //menu item
    @PostMapping("menuItem")
    public ResponseEntity<MenuItemDto> createMenuItem(@RequestBody CreateMenuItemRequest createMenuItemRequest){
        return menuService.createMenuItem(createMenuItemRequest);
    }
    @PostMapping("menuItemUpdate/{id}")
    public ResponseEntity<MenuItemDto> updateMenuItem(@PathVariable int id, @RequestBody UpdateMenuItemRequest updateMenuItemRequest){
        return menuService.updateMenuItem(id,updateMenuItemRequest);
    }
    @GetMapping("menuItem/{id}")
    public ResponseEntity<MenuItemDto> getMenuItem(@PathVariable int id){
        return menuService.getMenuItemDto(id);
    }
    @DeleteMapping("menuItem/{id}")
    public ResponseEntity<Response> deleteMenuItem(@PathVariable int id){
        return menuService.deleteMenuItem(id);
    }

    //menu tag
    @PostMapping("menuTag")
    public ResponseEntity<MenuTagDto> createMenuTag(@RequestBody CreateMenuTagRequest createMenuTagRequest){
        return menuService.createMenuTag(createMenuTagRequest);
    }
    @GetMapping("menuTag")
    public ResponseEntity<MenuTagDto> getMenuTag(@PathVariable int id){
        return menuService.getMenuTagDto(id);
    }
    @DeleteMapping("menuTag/{id}")
    public ResponseEntity<Response> deleteMenuTag(@PathVariable int id){
        return menuService.deleteMenuTag(id);
    }

}
