package bg.borismilanov.battleships.repositories;

import bg.borismilanov.battleships.models.Category;
import bg.borismilanov.battleships.models.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(ShipType name);
}
