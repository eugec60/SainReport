package test;

import static org.junit.Assert.assertEquals;
import model.Student;
import model.StudentBag;

import org.junit.After;
import org.junit.Test;

public class StudentBagTest {
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StudentBag sb = new StudentBag();

		Student expected = new Student("Caio", "Caio", "Caio", "Caio", "Caio",
				"Caio", 1, "Caio", 2);
		sb.add(expected);
		Student actual = sb.find(1);

		assertEquals(actual, expected);

	}

}
