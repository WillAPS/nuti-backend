package com.nuti.backend.usecase.dto;

import com.nuti.backend.domain.Pagina;
import com.nuti.backend.domain.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {
    public Tag map(String nome, Integer quantidade, Pagina page) {
        return Tag
                .builder()
                .nome(nome)
                .quantidade(quantidade)
                .pagina(page)
                .build();
    }
}
