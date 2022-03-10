package com.springboot.report;

import java.util.List;
import com.springboot.report.entities.Topperdata;
import com.springboot.report.entities.subtopper;
import com.springboot.report.services.subtopperservice;
import com.springboot.report.services.topperService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReportApplicationTests {
	@Autowired
	private topperService t;

	@Autowired
	private subtopperservice s;

	@Autowired
	private

	@Test void contextLoads() {
	}

	// Testing Topper Service
	@Test
	void testtoppercase1() {
		// Expected
		Topperdata testVariable = new Topperdata(17, "Mayank", 5, "Fifth Grade", 82);
		int testsize = 1;
		// actual result where classId=5
		List<Topperdata> list = t.gettopper(5);
		assertThat(testsize).isEqualTo(list.size());
		// Bcoz expect one output only
		Topperdata actualVariable = list.get(0);
		// Equating actual to expected
		assertThat(actualVariable.getClassid()).isEqualTo(testVariable.getClassid());
		assertThat(actualVariable.getClass()).isEqualTo(testVariable.getClass());
		assertThat(actualVariable.getStudentid()).isEqualTo(testVariable.getStudentid());
		assertThat(actualVariable.getStudent()).isEqualTo(testVariable.getStudent());
		assertThat(actualVariable.getTotalmarks()).isEqualTo(testVariable.getTotalmarks());
	}

	@Test
	void testtoppercase2() {
		// Expected case with two outputs at classId=11
		Topperdata testVariable1 = new Topperdata(29, "Sunny", 11, "Junior Secondary", 81);
		Topperdata testVariable2 = new Topperdata(32, "Madhuri", 11, "Junior Secondary", 81);
		int testsize = 2;
		// actual result where classId=11
		List<Topperdata> list = t.gettopper(11);
		assertThat(testsize).isEqualTo(list.size());
		Topperdata actualVariable1 = list.get(0);
		Topperdata actualVariable2 = list.get(1);
		// first check
		assertThat(actualVariable1.getClassid()).isEqualTo(testVariable1.getClassid());
		assertThat(actualVariable1.getClass()).isEqualTo(testVariable1.getClass());
		assertThat(actualVariable1.getStudentid()).isEqualTo(testVariable1.getStudentid());
		assertThat(actualVariable1.getStudent()).isEqualTo(testVariable1.getStudent());
		assertThat(actualVariable1.getTotalmarks()).isEqualTo(testVariable1.getTotalmarks());
		// second check
		assertThat(actualVariable2.getClassid()).isEqualTo(testVariable2.getClassid());
		assertThat(actualVariable2.getClass()).isEqualTo(testVariable2.getClass());
		assertThat(actualVariable2.getStudentid()).isEqualTo(testVariable2.getStudentid());
		assertThat(actualVariable2.getStudent()).isEqualTo(testVariable2.getStudent());
		assertThat(actualVariable2.getTotalmarks()).isEqualTo(testVariable2.getTotalmarks());

	}

	// Testing Subtopper Service
	@Test
	void subtopper() {
		// Expected
		subtopper testVariable = new subtopper(33, "Ankita", 11, "Junior Secondary", "Social Science", 97);
		// actual result where classId=11 and subjectId=5
		List<subtopper> list = s.getsubtopper(11, 5);
		// Bcoz expect one output only
		subtopper actualVariable = list.get(list.size() - 1);
		// Equating actual to expected
		assertThat(actualVariable.getClassid()).isEqualTo(testVariable.getClassid());
		assertThat(actualVariable.getClass()).isEqualTo(testVariable.getClass());
		assertThat(actualVariable.getStudentid()).isEqualTo(testVariable.getStudentid());
		assertThat(actualVariable.getStudent()).isEqualTo(testVariable.getStudent());
		assertThat(actualVariable.getMarksAchieved()).isEqualTo(testVariable.getMarksAchieved());
		assertThat(actualVariable.getSubjectName()).isEqualTo(testVariable.getSubjectName());

	}

}
