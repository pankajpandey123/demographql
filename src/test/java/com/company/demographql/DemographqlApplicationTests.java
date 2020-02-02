package com.company.demographql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemographqlApplicationTests {

	@Autowired
	MockMvc mockmvc;
	@Test
	void listFoods() throws Exception {
		String expectedResponse="";
	}

}
