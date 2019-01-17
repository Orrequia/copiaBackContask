package com.fot.backcontask;

import java.util.ArrayList;
import java.util.List;

import com.fot.backcontask.dao.*;
import com.fot.backcontask.model.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackConTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackConTaskApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PrivilegeDAO privilegeDAO, RoleDAO roleDAO,
								  UserDAO userDAO, CompanyDAO companyDAO,
								  CompanyTypeDAO companyTypeDAO, EmployeeDAO employeeDAO,
								  StoreDAO storeDAO) {
		return args -> {

			//Roles
			Role r1 = new Role();
			r1.setName("ADMIN");
			List<Privilege> apr1 = new ArrayList<>();
			
			Role r2 = new Role();
			r2.setName("SUPPORT");
			List<Privilege> apr2 = new ArrayList<>();
			
			//Privileges
			Privilege p1 = new Privilege();
			p1.setName("GET_COMPANY");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("POST_COMPANY");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_COMPANY");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_COMPANY");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_USER");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_USER");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_USER");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_USER");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_STORE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("POST_STORE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_STORE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_STORE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_COMPANY_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_COMPANY_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_COMPANY_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_COMPANY_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_CONTRACT");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_CONTRACT");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_CONTRACT");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_CONTRACT");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_CONTRACT_LINE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_CONTRACT_LINE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_CONTRACT_LINE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_CONTRACT_LINE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_CONTRACT_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_CONTRACT_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_CONTRACT_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_CONTRACT_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_EMPLOYEE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("POST_EMPLOYEE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_EMPLOYEE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			apr2.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_EMPLOYEE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_DONGLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_DONGLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_DONGLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_DONGLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_DONGLE_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_DONGLE_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_DONGLE_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_DONGLE_TYPE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_POPULATION");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_POPULATION");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_POPULATION");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_POPULATION");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_PRIVILEGE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_PRIVILEGE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_PRIVILEGE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_PRIVILEGE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_PROVINCE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_PROVINCE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_PROVINCE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_PROVINCE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			p1 = new Privilege();
			p1.setName("GET_ROLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("POST_ROLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("PUT_ROLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			p1 = new Privilege();
			p1.setName("DELETE_ROLE");
			privilegeDAO.save(p1);
			apr1.add(p1);
			
			r1.setPrivilege(apr1);
			roleDAO.save(r1);
			
			r2.setPrivilege(apr2);
			roleDAO.save(r2);

			//Users
			User orrequia = new User();
			User valeria = new User();
			
			orrequia.setName("Francisco");
			orrequia.setUsername("orrequia");
			orrequia.setPassword(DigestUtils.sha1Hex("1234"));
			orrequia.setRole(r1);
			userDAO.save(orrequia);
			
			valeria.setName("Valeria");
			valeria.setUsername("valeria");
			valeria.setPassword(DigestUtils.sha1Hex("4321"));
			valeria.setRole(r2);
			userDAO.save(valeria);


			//Company types
			CompanyType autonomo = new CompanyType();
			autonomo.setName("Autonomo");
			companyTypeDAO.save(autonomo);

			CompanyType empresa = new CompanyType();
			empresa.setName("Empresa");
			companyTypeDAO.save(empresa);

			//Employee
			List<Employee> empleadosPotasio = new ArrayList<>();
			List<Employee> empleadosSodio = new ArrayList<>();
			List<Employee> empleadosDioxidoDeCarbono = new ArrayList<>();

			Employee pepe = new Employee();
			pepe.setName("José Martín Villanueva");
			pepe.setEmail("pepe@gmail.com");
			pepe.setPhone("646783109");
			employeeDAO.save(pepe);
			empleadosPotasio.add(pepe);
			empleadosDioxidoDeCarbono.add(pepe);

			Employee francisco = new Employee();
			francisco.setName("Francisco Gonzalez Alba");
			francisco.setEmail("francisco@gmail.com");
			francisco.setPhone("646785679");
			employeeDAO.save(francisco);
			empleadosSodio.add(francisco);
			empleadosDioxidoDeCarbono.add(francisco);

			Employee juan = new Employee();
			juan.setName("Juan Paniagua Pérez");
			juan.setEmail("juan@gmail.com");
			juan.setPhone("645783156");
			employeeDAO.save(juan);
			empleadosPotasio.add(juan);

			//Stores
			List<Store> storesMercurio = new ArrayList<>();
			List<Store> storesVenus = new ArrayList<>();

			Store potasio = new Store();
			potasio.setName("CyR Jerez");
			potasio.setAddress("Calle los Jorobados nº300");
			potasio.setEmail("jerez@cocinasyreformas.es");
			potasio.setEmployee(empleadosPotasio);
			storeDAO.save(potasio);
			storesMercurio.add(potasio);

			Store sodio = new Store();
			sodio.setName("CyR Chiclana");
			sodio.setAddress("Avenida la música Nº3, Bloque 2 BJO C");
			sodio.setEmail("chiclana@cocinasyreformas.es");
			sodio.setEmployee(empleadosSodio);
			storeDAO.save(sodio);
			storesMercurio.add(sodio);

			Store dioxidoDeCarbono = new Store();
			dioxidoDeCarbono.setName("CPB Rota");
			dioxidoDeCarbono.setAddress("Calle los desemparados Nº20");
			dioxidoDeCarbono.setEmail("rota@cocinaselpinarbarranca.es");
			dioxidoDeCarbono.setEmployee(empleadosDioxidoDeCarbono);
			storeDAO.save(dioxidoDeCarbono);
			storesVenus.add(dioxidoDeCarbono);

			//Companies
			Company mercurio = new Company();
			mercurio.setName("Cocinas y Reformas S.L");
			mercurio.setNif("M49074001");
			mercurio.setCompanyType(autonomo);
			mercurio.setOwner(francisco);
			mercurio.setStore(storesMercurio);
			companyDAO.save(mercurio);

			Company venus = new Company();
			venus.setName("Cocinas el Pinar de la Barranca S.A");
			venus.setNif("K49074002");
			venus.setCompanyType(empresa);
			venus.setOwner(pepe);
			venus.setStore(storesVenus);
			companyDAO.save(venus);
		};
	}
}
