package com.nuti.backend.usecase;

import com.nuti.backend.domain.Pagina;
import com.nuti.backend.domain.Tag;
import com.nuti.backend.infra.mysql.TagRepository;
import com.nuti.backend.usecase.dto.TagMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;
    public void saveTags(Pagina page, Map<String, Integer> tagCountMap) {
        for (var entry: tagCountMap.entrySet()){
            var tag = tagMapper.map(entry.getKey(), entry.getValue(), page);
            tagRepository.save(tag);
        }
    }

    public List<Tag> buscarTodasAsTagReverentePagina(Integer id) {
        return tagRepository.findAllByPaginaId(id);
    }

}
