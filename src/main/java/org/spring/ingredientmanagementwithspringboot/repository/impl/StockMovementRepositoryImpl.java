package org.spring.ingredientmanagementwithspringboot.repository.impl;

import org.spring.ingredientmanagementwithspringboot.datasource.Datasource;
import org.spring.ingredientmanagementwithspringboot.entity.Enum.UnitType;
import org.spring.ingredientmanagementwithspringboot.entity.MovementTypeEnum;
import org.spring.ingredientmanagementwithspringboot.entity.StockMovement;
import org.spring.ingredientmanagementwithspringboot.entity.StockValue;
import org.spring.ingredientmanagementwithspringboot.repository.StockMovementRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockMovementRepositoryImpl implements StockMovementRepository {
    private final Datasource datasource;
    public StockMovementRepositoryImpl(Datasource datasource) {
        this.datasource = datasource;
    }
    @Override
    public List<StockMovement> findByIngredientAndDateBetween(int ingredientId, Instant from, Instant to) {
        String sql = """
            select id, id_ingredient, quantity, type, unit, creation_datetime
            from stockmovement
            where id_ingredient = ?
            and creation_datetime >= ?
            and creation_datetime <= ?;
            """;

        try (Connection conn = datasource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, ingredientId);
            preparedStatement.setTimestamp(2, java.sql.Timestamp.from(from));
            preparedStatement.setTimestamp(3, java.sql.Timestamp.from(to));

            List<StockMovement> stockMovements = new ArrayList<>();

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    StockMovement stockMovement = new StockMovement();

                    stockMovement.setId(rs.getInt("id"));

                    StockValue stockValue = new StockValue();
                    stockValue.setQuantity(rs.getDouble("quantity"));
                    stockValue.setUnit(UnitType.valueOf(rs.getString("unit")));

                    stockMovement.setValue(stockValue);
                    stockMovement.setType(MovementTypeEnum.valueOf(rs.getString("type")));
                    stockMovement.setCreationDatetime(
                            rs.getTimestamp("creation_datetime").toInstant()
                    );

                    stockMovements.add(stockMovement);
                }
            }

            return stockMovements;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StockMovement> findOneByIngredientId(int id) {
        return List.of();
    }

    @Override
    public List<StockMovement> findByIngredientAndDateBetween(Long ingredientId, Instant from, Instant to) {
        return List.of();
    }
}
