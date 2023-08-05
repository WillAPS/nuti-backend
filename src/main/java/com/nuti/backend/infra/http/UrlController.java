package com.nuti.backend.infra.http;

import com.nuti.backend.usecase.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UrlController {

    private final UrlService urlService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<String[]> getUrls(@RequestBody String urls){
        var urlsRecebidas = urlService.sendToUrlService(urls.split("\n"));
        return ResponseEntity.status(HttpStatus.CREATED).body(urlsRecebidas);
    }
}
