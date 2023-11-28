package WS;

import beans.Appareil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AppareilService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appareils")
public class AppareilWS {

    @Autowired
    private AppareilService apS;

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Appareil appareil) {
        int result = apS.save(appareil);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Appareil saved successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid input data");
        }
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Appareil> findById(@PathVariable Long id) {
        Optional<Appareil> appareil = apS.findById(id);
        return appareil.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        apS.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("")
    public List<Appareil> findAll() {
        return apS.findAll();
    }

    @DeleteMapping("")
    public void deleteAll() {
        apS.deleteAll();
    }
}
