package com.cts.benchmark;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 
  * This class contains test cases for the AuditBenchmarkApplication application class.
 *
 */
@SpringBootTest
class AuditBenchmarkApplicationTests {

	@Mock
	AuditBenchmarkApplication auditBenchmarkApplication;
	@Test
	void contextLoads() {
		assertNotNull(auditBenchmarkApplication);
	}

}
