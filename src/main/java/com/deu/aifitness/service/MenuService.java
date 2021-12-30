package com.deu.aifitness.service;

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
import com.deu.aifitness.model.response.Response;
import com.deu.aifitness.repository.MenuItemRepository;
import com.deu.aifitness.repository.MenuRepository;
import com.deu.aifitness.repository.MenuTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.deu.aifitness.model.mapper.MenuMapper.MENU_MAPPER;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuTagRepository menuTagRepository;

    public ResponseEntity<MenuDto> getMenuDto(Integer integer){
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuDto(getMenu(integer)));
    }

    public ResponseEntity<MenuItemDto> getMenuItemDto(Integer integer){
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuItemDto(getMenuItem(integer)));
    }

    public ResponseEntity<MenuTagDto> getMenuTagDto(Integer integer){
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuTagDto(getMenuTag(integer)));
    }

    public ResponseEntity<MenuDto> createMenu(UpdateCreateMenuRequest updateCreateMenuRequest){
        Menu menu = MENU_MAPPER.createMenu(updateCreateMenuRequest);
        menuRepository.save(menu);
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuDto(menu));
    }

    public ResponseEntity<MenuItemDto> createMenuItem(CreateMenuItemRequest createMenuItemRequest){
        MenuItem menuItem = MENU_MAPPER.createMenuItem(createMenuItemRequest);
        menuItemRepository.save(menuItem);
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuItemDto(menuItem));
    }

    public ResponseEntity<MenuTagDto> createMenuTag(CreateMenuTagRequest createMenuTagRequest){
        MenuTag menuTag = MENU_MAPPER.createMenuTag(createMenuTagRequest);
        menuTagRepository.save(menuTag);
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuTagDto(menuTag));
    }

    public ResponseEntity<MenuDto> updateMenu(int id, UpdateCreateMenuRequest updateCreateMenuRequest){
        Menu menu = getMenu(id);
        MENU_MAPPER.updateMenu(menu,updateCreateMenuRequest);
        menuRepository.save(menu);
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuDto(menu));
    }

    public ResponseEntity<MenuItemDto> updateMenuItem(int id, UpdateMenuItemRequest updateMenuItemRequest){
        MenuItem menuItem = getMenuItem(id);
        MENU_MAPPER.updateMenuItem(menuItem,updateMenuItemRequest);
        menuItemRepository.save(menuItem);
        return ResponseEntity.ok(MENU_MAPPER.convertToMenuItemDto(menuItem));
    }

    private MenuItem getMenuItem(Integer integer){
        return menuItemRepository.findById(integer).orElseThrow(()->new NotFoundException(""));
    }

    private MenuTag getMenuTag(Integer integer){
        return menuTagRepository.findById(integer).orElseThrow(()->new NotFoundException(""));
    }

    private Menu getMenu(Integer integer){
        return menuRepository.findById(integer).orElseThrow(()->new NotFoundException(""));
    }

    public ResponseEntity<Response> deleteMenu(int id){
        try {
            menuRepository.deleteById(id);
            return ResponseEntity.ok(Response.builder()
                    .message("")
                    .status(HttpStatus.OK)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(Response.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }
    public ResponseEntity<Response> deleteMenuItem(int id){
        try {
            menuItemRepository.deleteById(id);
            return ResponseEntity.ok(Response.builder()
                    .message("")
                    .status(HttpStatus.OK)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(Response.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }
    public ResponseEntity<Response> deleteMenuTag(int id){
        try {
            menuTagRepository.deleteById(id);
            return ResponseEntity.ok(Response.builder()
                    .message("")
                    .status(HttpStatus.OK)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(Response.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }
}
