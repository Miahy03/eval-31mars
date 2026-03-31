package org.spring.ingredientmanagementwithspringboot.repository;

import org.spring.ingredientmanagementwithspringboot.entity.StockMovement;

import java.time.Instant;
import java.util.List;

public interface StockMovementRepository {
    List<StockMovement> findByIngredientAndDateBetween(int ingredientId, Instant from, Instant to);

    public List<StockMovement> findOneByIngredientId(int id);
    List<StockMovement> findByIngredientAndDateBetween(Long ingredientId, Instant from, Instant to);
}
