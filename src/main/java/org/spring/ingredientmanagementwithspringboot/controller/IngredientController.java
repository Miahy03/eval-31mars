package org.spring.ingredientmanagementwithspringboot.controller;

import org.spring.ingredientmanagementwithspringboot.entity.Enum.UnitType;
import org.spring.ingredientmanagementwithspringboot.entity.Ingredient;
import org.spring.ingredientmanagementwithspringboot.entity.StockMovement;
import org.spring.ingredientmanagementwithspringboot.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<?> getStockValueAt(
            @PathVariable int id,
            @RequestParam(required = false) Instant at,
            @RequestParam(required = false) UnitType unit) {

        if (at == null || unit == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Paramètres 'at' et 'unit' obligatoires");
        }

        return ResponseEntity.ok(
                ingredientService.getStockMovementAt(id, at, unit)
        );
    }

    @GetMapping("/{id}/stockMovements")
    public ResponseEntity<List<StockMovement>> getStockMovements(
            @PathVariable int id,
            @RequestParam Instant from,
            @RequestParam Instant to) {

        return ResponseEntity.ok(
                ingredientService.getStockMovements(id, from, to)
        );
    }
}