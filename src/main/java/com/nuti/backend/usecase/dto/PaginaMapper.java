package com.nuti.backend.usecase.dto;

import com.nuti.backend.domain.Pagina;
import org.springframework.stereotype.Component;

@Component
public class PaginaMapper {
    public Pagina map(String url) {
        return Pagina
                .builder()
                .url(url)
                .build();
    }
}
