package service;

import beans.Appareil;
import dao.AppareilDao;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AppareilService {

    final
    AppareilDao appareilDao;

    public AppareilService(AppareilDao appareilDao) {
        this.appareilDao = appareilDao;
    }

    public int save(Appareil appareil) {
        if (appareil == null) return -1;
        else {
            appareilDao.save(appareil);
            return 1;
        }
    }

    public Optional<Appareil> findById(Long id) {
        return appareilDao.findById(id);
    }

    public List<Appareil> findAll() {
        return appareilDao.findAll();
    }

    public void deleteById(Long id) {
        appareilDao.deleteById(id);
    }

    public void deleteAll() {
        appareilDao.deleteAll();
    }

    @PutMapping("id/{id}")
    public void SwitchOn(Appareil ap) {
        Optional<Appareil> appareilOptional = appareilDao.findById(ap.getId());
        if (appareilOptional.isPresent()) {
            Appareil appareil = appareilOptional.get();
            if (!appareil.isState()) {
                appareil.setState(true);
                appareilDao.save(appareil);
                // Log success or other relevant information
            }
        }
    }

    public void SwitchOff(Appareil ap) {
        Optional<Appareil> appareilOptional = appareilDao.findById(ap.getId());
        if (appareilOptional.isPresent()) {
            Appareil appareil = appareilOptional.get();
            if (appareil.isState()) {
                appareil.setState(false);
                appareilDao.save(appareil);
                // Log success or other relevant information
            }
        }
    }
    public void SwitchAllOn(){
        List<Appareil> appareils = appareilDao.findAll();
        for (Appareil appareil : appareils) {
            // Set state to "on"
            appareil.setState(true);
        }
        appareilDao.saveAll(appareils);
    }
    public void SwitchAllOff(){
        List<Appareil> appareils = appareilDao.findAll();
        for (Appareil appareil : appareils) {
            // Set state to "off"
            appareil.setState(false);
        }
        appareilDao.saveAll(appareils);
    }
}
