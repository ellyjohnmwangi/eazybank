package com.mwas.repository;

import com.mwas.model.Cards;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
    List<Cards> findByCustomerId(int customerId);
}
