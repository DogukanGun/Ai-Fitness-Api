package com.deu.aifitness.model.request.menu.tag;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMenuTagRequest {

    private String tag;

    private Integer menuItemId;
}
