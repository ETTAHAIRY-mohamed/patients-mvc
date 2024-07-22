package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}



@Bean
	CommandLineRunner commandLineRunner (PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null, "mohamed", "123", new Date(), false, 50));
			patientRepository.save(new Patient(null, "ahmed", "456", new Date(), true, 60));
			patientRepository.save(new Patient(null, "ali", "789", new Date(), false, 70));
			patientRepository.save(new Patient(null, "omar", "012", new Date(), true, 80));
			patientRepository.save(new Patient(null, "mohamed", "345", new Date(), false, 50));
			patientRepository.save(new Patient(null, "ahmed", "678", new Date(), true, 60));
			patientRepository.save(new Patient(null, "ali", "901", new Date(), false, 70));
			patientRepository.save(new Patient(null, "omar", "234", new Date(), true, 80));
			patientRepository.save(new Patient(null, "mohamed", "567", new Date(), false, 50));
			patientRepository.save(new Patient(null, "ahmed", "890", new Date(), true, 60));
			patientRepository.save(new Patient(null, "ali", "123", new Date(), false, 70));
			patientRepository.save(new Patient(null, "omar", "456", new Date(), true, 80));


	List<Patient> patients = patientRepository.findAll();
			for (Patient patient : patients) {
				System.out.println(patient.getNom());
			}
		};



	}
@Bean
	PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();

}
}
