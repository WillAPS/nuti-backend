package com.nuti.backend.usecase;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Log4j2
@AllArgsConstructor
public class UrlService {

    private final TagService tagService;
    private final PaginaService paginaService;
    public String[] sendToUrlService(String[] urls){
        for (var url: urls) {
            getBodyUrl(url);
        }
        return urls;
    }
    public void getBodyUrl(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            Elements allTags = doc.getAllElements();
            Map<String, Integer> tagCountMap = new LinkedHashMap<>();
            getTagsPorPagina(allTags, tagCountMap);
            var page = paginaService.getPagina(url);
            tagService.saveTags(page, tagCountMap);
        } catch (Exception e) {
            log.info("Erro ao obter a página: " + e.getMessage());
        }
    }
    private static void getTagsPorPagina(Elements allTags, Map<String, Integer> tagCountMap) {
        for (Element element : allTags) {
            var tagName = element.tagName();
            if(!tagName.equals("#root")){
                tagCountMap.put(tagName, tagCountMap.getOrDefault(tagName, 0) + 1);
            }
        }
    }
}
