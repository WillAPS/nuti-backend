package com.nuti.backend.infra.mysql;

import com.nuti.backend.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    List<Tag> findAllByPaginaId(Integer id);
}
