package com.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvc.controller.EmployeeCtrl;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class SpringbootJarApplicationTests {

	@Autowired
	private EmployeeCtrl employeeCtrl;

	@Test
	public void contexLoads() throws Exception {
		assertThat(employeeCtrl).isNotNull();
	}

}