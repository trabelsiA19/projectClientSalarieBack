package com.example.demo.services.impl;
import com.example.demo.models.Salarie;
import com.example.demo.repository.SalarieRepository;
import com.example.demo.services.SalarieService;
import com.example.demo.util.SalarieRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalarieServiceImpl implements SalarieService {

    @Autowired
    private SalarieRepository salarieRepository;

    /**
     * The get All Salaries  method.
     *
     */
    public List<Salarie> getAllSalaries() {
        return salarieRepository.findAll();
    }

    /**
     * The  get Salarie By Id  method.
     * {@Param id}
     */
    public Salarie getSalarieById(Long id) {
        return salarieRepository.findById(id).orElse(null);
    }


    /**
     * The  save Salarie  method.
     * {@Param salarie}
     */
    public Salarie saveSalarie(Salarie salarie) {
        if (salarie.getBirthDate() != null) {
            int age = calculateAge(salarie.getBirthDate());
            if (age < 100) {
                return salarieRepository.save(salarie);
            } else {
                throw new SalarieRegistrationException("L'âge du salarié dépasse 100 ans.");
            }
        } else {
            // Handle the case where birthDate is null
            // You might want to log an error, display a message, or take appropriate action.
            throw new IllegalArgumentException("Birth date cannot be null.");
        }
    }


    /**
     * The  delete Salarie  method.
     * {@Param id}
     */
    public void deleteSalarie(Long id) {
        salarieRepository.deleteById(id);
    }

    /**
     * The  calculate Age  method.
     * {@Param birthDate}
     */
    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.minusYears(birthDate.getYear()).getYear();
    }
}
