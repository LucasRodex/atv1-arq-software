package com.atv1.ArqSoftware.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atv1.ArqSoftware.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    

}
