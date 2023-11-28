package service;


import beans.Categorie;
import dao.CategorieDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    final
    CategorieDao categorieDao;

    public CategorieService(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }
    public int save(Categorie categorie) {
        if (categorie == null) return -1;
        else {
            categorieDao.save(categorie);
            return 1;
        }
    }

    public Optional<Categorie> findById(Long id) {
        return categorieDao.findById(id);
    }
    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }

    public void deleteById(Long id) {
        categorieDao.deleteById(id);
    }

    public void deleteAll() {
        categorieDao.deleteAll();
    }
}
