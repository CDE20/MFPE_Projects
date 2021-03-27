package com.cts.benchmark.swaggerconfig;
/**
 * Tests if swagger configuration class is working or not
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class SpringFoxConfigTest {
	
	@Mock
	Environment env;
	
	@InjectMocks
	SpringFoxConfig config;
	
	@Test
	public void contextLoads() {
		assertNotNull(config);
	}
	

	@Test
	public void testDocket() {
		assertNotNull(config.api());
	}


}
