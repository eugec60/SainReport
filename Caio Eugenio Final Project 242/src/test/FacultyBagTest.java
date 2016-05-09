package test;


import static org.junit.Assert.*;
import model.Faculty;
import model.FacultyBag;

import org.junit.Test;

public class FacultyBagTest {

	@Test
	public void test() {
		FacultyBag fb = new FacultyBag();
		Faculty expected = new Faculty("Caio", "Caio", "Caio", "Caio", "username", "password", "Caio", "Caio", "Caio", "Caio");
		fb.add(expected);
		Faculty actual = fb.facultyLogin(expected.getUsername(), expected.getPassword());
		assertEquals(actual,expected);
	}

}
