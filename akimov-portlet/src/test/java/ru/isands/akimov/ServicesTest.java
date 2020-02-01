package ru.isands.akimov;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

/**
 * @author akimov
 * created at 26.01.20 11:53
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {FooLocalServiceUtil.class,})
public class ServicesTest {


	@Before
	public void setService() {
		Foo foo = mock(Foo.class);
		PowerMockito.when(foo.toString()).thenReturn("toString");

		PowerMockito.mockStatic(FooLocalServiceUtil.class);
		PowerMockito.when(FooLocalServiceUtil.createFoo(anyInt())).thenReturn(foo);
	}

	@Test
	public void testService() throws ReflectiveOperationException {
		Foo foo = FooLocalServiceUtil.createFoo(0);
		System.out.println(foo);
	}

}
