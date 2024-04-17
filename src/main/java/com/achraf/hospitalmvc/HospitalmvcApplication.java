package com.achraf.hospitalmvc;

import com.achraf.hospitalmvc.entities.Patient;
import com.achraf.hospitalmvc.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalmvcApplication implements CommandLineRunner {

	private PatientRepository patientRepository;

	public HospitalmvcApplication(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HospitalmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Yassine",new Date(),false,123));
		patientRepository.save(new Patient(null,"Amine",new Date(),true,123));
		patientRepository.save(new Patient(null,"Hanane",new Date(),false,123));
		// En utilisant Builder
		Patient patient1 = Patient.builder()
				.nom("Aziz")
				.dateNaissance(new Date())
				.score(56)
				.malade(true)
				.build();
	}
}
