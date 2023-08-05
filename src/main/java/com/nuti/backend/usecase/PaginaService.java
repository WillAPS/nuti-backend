package com.nuti.backend.usecase;

import com.nuti.backend.domain.Pagina;
import com.nuti.backend.infra.mysql.PaginaRepository;
import com.nuti.backend.usecase.dto.PaginaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaginaService {

    private final PaginaMapper paginaMapper;
    private final PaginaRepository paginaRepository;

    public Pagina getPagina(String url) {
        var pagina = paginaMapper.map(url);
        return paginaRepository.save(pagina);
    }

    public List<Pagina> buscarTodasAsPaginas() {
        return (List<Pagina>) paginaRepository.findAll();
    }

}
