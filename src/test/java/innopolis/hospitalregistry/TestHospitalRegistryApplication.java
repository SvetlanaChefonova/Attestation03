package innopolis.hospitalregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHospitalRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.from(HospitalRegistryApplication::main).with(TestHospitalRegistryApplication.class).run(args);
	}

}
