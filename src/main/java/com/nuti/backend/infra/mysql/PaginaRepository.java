package com.nuti.backend.infra.mysql;

import com.nuti.backend.domain.Pagina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaginaRepository extends CrudRepository<Pagina, Long> {
}
