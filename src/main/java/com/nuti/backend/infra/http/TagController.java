package com.nuti.backend.infra.http;

import com.nuti.backend.domain.Tag;
import com.nuti.backend.infra.mysql.TagRepository;
import com.nuti.backend.usecase.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TagController {

    private final TagService tagService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dados-tag")
    public ResponseEntity<List<Tag>> getTags(@RequestParam Integer idPagina){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tagService.buscarTodasAsTagReverentePagina(idPagina));
    }



}
