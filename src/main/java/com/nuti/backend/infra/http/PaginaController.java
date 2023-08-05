package com.nuti.backend.infra.http;

import com.nuti.backend.domain.Pagina;
import com.nuti.backend.infra.mysql.PaginaRepository;
import com.nuti.backend.usecase.PaginaService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Log4j2
public class PaginaController {

    private final PaginaService paginaService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dados-pagina")
    public ResponseEntity<List<Pagina>> getPaginas(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paginaService.buscarTodasAsPaginas());
    }



}
