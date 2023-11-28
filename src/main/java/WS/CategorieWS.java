package WS;

import beans.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import service.CategorieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
public class CategorieWS {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("")
    public int save(Categorie categorie) {
        return categorieService.save(categorie);
    }

    @GetMapping("id/{id}")
    public Optional<Categorie> findById(Long id) {
        return categorieService.findById(id);
    }

    @GetMapping("")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @DeleteMapping ("id/{id}")
    public void deleteById(Long id) {
        categorieService.deleteById(id);
    }

    @DeleteMapping("")
    public void deleteAll() {
        categorieService.deleteAll();
    }
}
