package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsServicesImpl implements PatientsServices{

    private final PatientsRepository patientsRepository;


   // @Override
   // public Patients findById(Long id){
      //  return patientsRepository.getOne(id);
   // }


    /**
     * Получить всех поциентов из БД
     * @return список пациентов
     */
    @Override
    public List<Patients> getAll() {
        return patientsRepository.findAll(); //аналог SELEST * from patients;
    }

   // @Override
   // public Patients savePatients(Patients patients){
       // return patientsRepository.save(patients);
  //  }

  //  @Override
   // public void update() {

   // }


  //  @Override
   // public void deleteById(Long id){
      //  patientsRepository.deleteById(id);
   // }
}
