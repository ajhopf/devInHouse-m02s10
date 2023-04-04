package com.devinhouse.m02s10.repositories;

import com.devinhouse.m02s10.repositories.model.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
}
