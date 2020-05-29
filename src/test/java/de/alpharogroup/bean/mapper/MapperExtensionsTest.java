package de.alpharogroup.bean.mapper;

import de.alpharogroup.test.objects.Member;
import de.alpharogroup.test.objects.Person;
import de.alpharogroup.test.objects.enums.Gender;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MapperExtensionsTest
{

	@Test public void testMap()
	{
	}

	@Test public void testTestMap()
	{
		Member actual;
		Member expected;
		Person asterix = Person.builder().name("asterix").build();
		actual = MapperExtensions.map(DozerBeanMapperSingleton.getInstance(), asterix, Member.class);
		expected = Member.buildMember().about("").name("asterix").gender(Gender.UNDEFINED).married(false).nickname("").build();
		assertEquals(actual, expected);
	}
}