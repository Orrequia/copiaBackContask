package com.fot.backcontask;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fot.backcontask.dao.PrivilegeDAO;
import com.fot.backcontask.dao.RoleDAO;
import com.fot.backcontask.dao.UserDAO;
import com.fot.backcontask.model.Privilege;
import com.fot.backcontask.model.Role;
import com.fot.backcontask.model.User;

@SpringBootApplication
@EnableAutoConfiguration
public class BackConTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackConTaskApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PrivilegeDAO privilegeDAO, RoleDAO roleDAO, UserDAO userDAO) {
		return args -> {
			
			Role r1 = new Role();
			r1.setName("ADMIN");
			List<Privilege> apr1 = new ArrayList<>();
			
			Role r2 = new Role();
			r2.setName("SUPPORT");
			List<Privilege> apr2 = new ArrayList<>();
			
			
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
		};
	}
}
