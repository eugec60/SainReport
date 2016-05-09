package test;

import static org.junit.Assert.assertEquals;
import model.Course;
import model.CourseBag;
import model.Student;

import org.junit.Test;

public class CourseBagTest {

	@Test
	public void test() {
		CourseBag cb = new CourseBag();

		Course expected = new Course("Caio", "Caio", "Caio", "Caio", 2);
		cb.add(expected);
		Course actual = cb.getCourseList().get(0);

		assertEquals(actual, expected);
	}

}
