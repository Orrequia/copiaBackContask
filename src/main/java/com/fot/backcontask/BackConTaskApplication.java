package com.fot.backcontask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fot.backcontask.dao.*;
import com.fot.backcontask.model.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
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
								  StoreDAO storeDAO, ContractDAO contractDAO,
								  PopulationDAO populationDAO, ContractTypeDAO contractTypeDAO,
								  ProvinceDAO provinceDAO, ContractLineDAO contractLineDAO,
								  DongleTypeDAO dongleTypeDAO, DongleDAO dongleDAO,
								  DongleModuleDAO dongleModuleDAO) {
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
			juan.setEmail("juan@null.com");
			juan.setPhone("645783156");
			employeeDAO.save(juan);
			empleadosPotasio.add(juan);


			//Provinces
			Province cadiz = new Province();
			cadiz.setName("Cádiz");
			provinceDAO.save(cadiz);

			//Population
			Population chiclana = new Population();
			chiclana.setName("Chiclana de la Frontera");
			chiclana.setProvince(cadiz);
			populationDAO.save(chiclana);

			Population rota = new Population();
			rota.setName("Rota");
			rota.setProvince(cadiz);
			populationDAO.save(rota);

			Population jerez = new Population();
			jerez.setName("Jerez de la Frontera");
			jerez.setProvince(cadiz);
			populationDAO.save(jerez);

			//Stores
			List<Store> storesCyR = new ArrayList<>();
			List<Store> storesCPB = new ArrayList<>();

			Store tiendaJerez = new Store();
			tiendaJerez.setName("CyR Jerez");
			tiendaJerez.setAddress("Calle los Jorobados nº300");
			tiendaJerez.setEmail("jerez@cocinasyreformas.es");
			tiendaJerez.setEmployee(empleadosPotasio);
			tiendaJerez.setResponsible(juan);
			tiendaJerez.setPopulation(jerez);
			storeDAO.save(tiendaJerez);
			storesCyR.add(tiendaJerez);

			Store tiendaChiclana = new Store();
			tiendaChiclana.setName("CyR Chiclana");
			tiendaChiclana.setAddress("Avenida la música Nº3, Bloque 2 BJO C");
			tiendaChiclana.setEmail("chiclana@cocinasyreformas.es");
			tiendaChiclana.setEmployee(empleadosSodio);
			tiendaChiclana.setResponsible(francisco);
			tiendaChiclana.setPopulation(chiclana);
			storeDAO.save(tiendaChiclana);
			storesCyR.add(tiendaChiclana);

			Store tiendaRota = new Store();
			tiendaRota.setName("CPB Rota");
			tiendaRota.setAddress("Calle los desemparados Nº20");
			tiendaRota.setEmail("rota@cocinaselpinarbarranca.es");
			tiendaRota.setEmployee(empleadosDioxidoDeCarbono);
			tiendaRota.setResponsible(pepe);
			tiendaRota.setPopulation(rota);
			storeDAO.save(tiendaRota);
			storesCPB.add(tiendaRota);

			//Companies
			Company empresaCyR = new Company();
			empresaCyR.setName("Cocinas y Reformas S.L");
			empresaCyR.setNif("M49074001");
			empresaCyR.setCompanyType(autonomo);
			empresaCyR.setOwner(francisco);
			empresaCyR.setStore(storesCyR);
			companyDAO.save(empresaCyR);

			Company empresaCPB = new Company();
			empresaCPB.setName("Cocinas el Pinar de la Barranca S.A");
			empresaCPB.setNif("K49074002");
			empresaCPB.setCompanyType(empresa);
			empresaCPB.setOwner(pepe);
			empresaCPB.setStore(storesCPB);
			companyDAO.save(empresaCPB);

			//Tipo contratos
			ContractType asistencia = new ContractType();
			asistencia.setName("Asistencia");
			contractTypeDAO.save(asistencia);

			ContractType mantenimiento = new ContractType();
			mantenimiento.setName("Mantenimiento");
			contractTypeDAO.save(mantenimiento);

			ContractType mantenimientoConNosotros = new ContractType();
			mantenimientoConNosotros.setName("Mantenimiento con nosotros");
			contractTypeDAO.save(mantenimientoConNosotros);

			//Modulos de mochilas
			DongleModule disenio = new DongleModule();
			disenio.setName("Diseño");
			disenio.setReferenceCode(400);
			dongleModuleDAO.save(disenio);

			DongleModule fabricacion = new DongleModule();
			fabricacion.setName("Fabricación");
			fabricacion.setReferenceCode(501);
			dongleModuleDAO.save(fabricacion);

			//Tipos de mochilas
			DongleType prohasp = new DongleType();
			prohasp.setName("Prohasp");
			dongleTypeDAO.save(prohasp);


			DongleType nethasp = new DongleType();
			nethasp.setName("Nethasp");
			dongleTypeDAO.save(nethasp);


			DongleType superpro = new DongleType();
			superpro.setName("Superpro");
			dongleTypeDAO.save(superpro);


			DongleType time = new DongleType();
			time.setName("Time");
			dongleTypeDAO.save(time);


			//Mochilas
			Dongle mochila1 = new Dongle();
			mochila1.setDongleModule(disenio);
			mochila1.setDongleType(superpro);
			mochila1.setLicense("ESTAE-SLALI-CENCI-APARA-LAMOC");
			dongleDAO.save(mochila1);

			Dongle mochila2 = new Dongle();
			mochila2.setDongleModule(fabricacion);
			mochila2.setDongleType(superpro);
			mochila2.setLicense("ESTAE-SLALI-C40CI-3P201-FR4M9");
			dongleDAO.save(mochila2);

			Dongle mochila3 = new Dongle();
			mochila3.setDongleModule(disenio);
			mochila3.setDongleType(time);
			mochila3.setLicense("CENCI-5GTR4-LAMOC-HILAN-UMRO3");
			dongleDAO.save(mochila3);

			Dongle mochila4 = new Dongle();
			mochila4.setDongleModule(fabricacion);
			mochila4.setDongleType(prohasp);
			mochila4.setLicense("ENCIA-PARAL-AMOCH-ILANU-MERO4");
			dongleDAO.save(mochila4);

			//LineaContratos
			ContractLine compramosMochila1 = new ContractLine();
			compramosMochila1.setContractType(asistencia);
			compramosMochila1.setDongle(mochila1);
			compramosMochila1.setPrice(94.4f);
			contractLineDAO.save(compramosMochila1);

			ContractLine compramosMochila2 = new ContractLine();
			compramosMochila2.setContractType(mantenimiento);
			compramosMochila2.setDongle(mochila2);
			compramosMochila2.setPrice(194.4f);
			contractLineDAO.save(compramosMochila2);

			ContractLine compramosMochila3 = new ContractLine();
			compramosMochila3.setContractType(mantenimientoConNosotros);
			compramosMochila3.setDongle(mochila3);
			compramosMochila3.setPrice(98.5f);
			contractLineDAO.save(compramosMochila3);

			ContractLine compramosMochila4 = new ContractLine();
			compramosMochila4.setContractType(mantenimiento);
			compramosMochila4.setDongle(mochila4);
			compramosMochila4.setPrice(263.4f);
			contractLineDAO.save(compramosMochila4);

			ContractLine compramosMochila1nuevamente = new ContractLine();
			compramosMochila1nuevamente.setContractType(mantenimiento);
			compramosMochila1nuevamente.setDongle(mochila1);
			compramosMochila1nuevamente.setPrice(394.4f);
			contractLineDAO.save(compramosMochila1nuevamente);

			ContractLine compramosMochila2nuevamente = new ContractLine();
			compramosMochila2nuevamente.setContractType(asistencia);
			compramosMochila2nuevamente.setDongle(mochila2);
			compramosMochila2nuevamente.setPrice(94.7f);
			contractLineDAO.save(compramosMochila2nuevamente);

			ContractLine compramosMochila3nuevamente = new ContractLine();
			compramosMochila3nuevamente.setContractType(mantenimientoConNosotros);
			compramosMochila3nuevamente.setDongle(mochila3);
			compramosMochila3nuevamente.setPrice(494.4f);
			contractLineDAO.save(compramosMochila3nuevamente);

			ContractLine compramosMochila4nuevamente = new ContractLine();
			compramosMochila4nuevamente.setContractType(asistencia);
			compramosMochila4nuevamente.setDongle(mochila4);
			compramosMochila4nuevamente.setPrice(91.9f);
			contractLineDAO.save(compramosMochila4nuevamente);

			List<ContractLine> lineaPrimerContratoParaCyR = new ArrayList<>();
			lineaPrimerContratoParaCyR.add(compramosMochila2);
			lineaPrimerContratoParaCyR.add(compramosMochila3);

			List<ContractLine> lineaSegundoContratoParaCyR = new ArrayList<>();
			lineaSegundoContratoParaCyR.add(compramosMochila2nuevamente);
			lineaSegundoContratoParaCyR.add(compramosMochila3nuevamente);

			List<ContractLine> lineaPrimerContratoParaCPB = new ArrayList<>();
			lineaPrimerContratoParaCPB.add(compramosMochila1);
			lineaPrimerContratoParaCPB.add(compramosMochila4);

			List<ContractLine> lineaSegundoContratoParaCPB = new ArrayList<>();
			lineaSegundoContratoParaCPB.add(compramosMochila1nuevamente);
			lineaSegundoContratoParaCPB.add(compramosMochila4nuevamente);

			//Contratos
			Contract primerContratoConCyR = new Contract();
			primerContratoConCyR.setStartDate(new Date(1512910825000L));
			primerContratoConCyR.setPaid(true);
			primerContratoConCyR.setContractLine(lineaPrimerContratoParaCyR);
			contractDAO.save(primerContratoConCyR);

			Contract secunContratoConCyR = new Contract();
			secunContratoConCyR.setStartDate(new Date(1544443225000L));
			secunContratoConCyR.setPaid(false);
			secunContratoConCyR.setContractLine(lineaSegundoContratoParaCyR);
			contractDAO.save(secunContratoConCyR);

			Contract primerContratoConCPB = new Contract();
			primerContratoConCPB.setStartDate(new Date(1477735225000L));
			primerContratoConCPB.setPaid(true);
			primerContratoConCPB.setContractLine(lineaPrimerContratoParaCPB);
			contractDAO.save(primerContratoConCPB);

			Contract secunContratoConCPB = new Contract();
			secunContratoConCPB.setStartDate(new Date(1544443225000L));
			secunContratoConCPB.setPaid(true);
			secunContratoConCPB.setContractLine(lineaSegundoContratoParaCPB);
			contractDAO.save(secunContratoConCPB);


			tiendaChiclana.setDongle(Collections.singletonList(mochila2));
			storeDAO.save(tiendaChiclana);

			tiendaJerez.setDongle(Collections.singletonList(mochila3));
			storeDAO.save(tiendaJerez);

			List<Dongle> listaMochilasCPB = new ArrayList<>();
			listaMochilasCPB.add(mochila1);
			listaMochilasCPB.add(mochila4);

			tiendaRota.setDongle(listaMochilasCPB);
			storeDAO.save(tiendaRota);


			List<Contract> contracts = new ArrayList<>();
			contracts.add(primerContratoConCPB);
			contracts.add(secunContratoConCPB);

			empresaCPB.setContract(contracts);
			companyDAO.save(empresaCPB);

			List<Contract> contracts2 = new ArrayList<>();
			contracts2.add(primerContratoConCyR);
			contracts2.add(secunContratoConCyR);

			empresaCyR.setContract(contracts2);
			companyDAO.save(empresaCyR);
		};
	}
}
