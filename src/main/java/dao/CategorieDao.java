package dao;

import beans.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieDao extends JpaRepository<Categorie,Long> {

}
