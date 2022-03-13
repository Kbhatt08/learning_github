package com.springboot.report;

import java.util.List;

import com.springboot.report.entities.Topper;
import com.springboot.report.services.dataService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReportApplicationTests {
	@Autowired
	private dataService t;

	@Test
	void contextLoads() {
	}

	// Testing Topper Service
	@Test
	void testtoppercase1() {
		// Expected
		Topper testVariable = new Topper(17, "Mayank", 5, 82);
		int testsize = 1;
		// actual result where classId=5
		List<Topper> list = t.gettop(5);
		assertThat(testsize).isEqualTo(list.size());
		// Bcoz expect one output only
		Topper actualVariable = list.get(0);
		// Equating actual to expected
		assertThat(actualVariable.getClassid()).isEqualTo(testVariable.getClassid());
		assertThat(actualVariable.getStudentid()).isEqualTo(testVariable.getStudentid());
		assertThat(actualVariable.getStudent()).isEqualTo(testVariable.getStudent());
		assertThat(actualVariable.getTotalmarks()).isEqualTo(testVariable.getTotalmarks());
	}

	@Test
	void testtoppercase2() {
		// Expected case with two outputs at classId=11
		Topper testVariable1 = new Topper(29, "Sunny", 11, 81);
		Topper testVariable2 = new Topper(32, "Madhuri", 11, 81);
		int testsize = 2;
		// actual result where classId=11
		List<Topper> list = t.gettop(11);
		assertThat(testsize).isEqualTo(list.size());
		Topper actualVariable1 = list.get(0);
		Topper actualVariable2 = list.get(1);
		// first check
		assertThat(actualVariable1.getClassid()).isEqualTo(testVariable1.getClassid());
		assertThat(actualVariable1.getStudentid()).isEqualTo(testVariable1.getStudentid());
		assertThat(actualVariable1.getStudent()).isEqualTo(testVariable1.getStudent());
		assertThat(actualVariable1.getTotalmarks()).isEqualTo(testVariable1.getTotalmarks());
		// second check
		assertThat(actualVariable2.getClassid()).isEqualTo(testVariable2.getClassid());
		assertThat(actualVariable2.getStudentid()).isEqualTo(testVariable2.getStudentid());
		assertThat(actualVariable2.getStudent()).isEqualTo(testVariable2.getStudent());
		assertThat(actualVariable2.getTotalmarks()).isEqualTo(testVariable2.getTotalmarks());

	}

	// Testing Subtopper Service

}
