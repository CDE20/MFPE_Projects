package com.cognizant.medicalrepresentativeschedule.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.controller.MedRepScheduleController;
import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.feignclient.AuthenticationFeignClient;
import com.cognizant.medicalrepresentativeschedule.model.JwtResponse;
import com.cognizant.medicalrepresentativeschedule.model.MedicalRepresentative;
import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;

@RunWith(SpringRunner.class)
class MedRepServiceImplTest {

	@Mock
	private AuthenticationFeignClient authenticationFeignClient;

	@InjectMocks
	private MedRepScheduleController medicalRepresenativeScheduleController;

	@Mock
	private RepSchedule repSchedule;

	@Mock
	private List<RepSchedule> medicineStockList;

	@MockBean
	private MedRepScheduleServiceImpl medicalRepresentativeScheduleService;
	
	@MockBean
	private MedRepServiceImpl medicalRepresentativeService;

	@Test
	public void testGetMedicalRepresentatives() throws TokenValidationFailedException {

		when(authenticationFeignClient.verifyToken("token")).thenReturn(new JwtResponse("1", "admin", true));
		when(new MedRepServiceImpl().isValidSession("token")).thenReturn(false);

		List<MedicalRepresentative> medicalRepresentatives = medicalRepresentativeService
				.getMedicalRepresentatives("token");
		assertNotNull(medicalRepresentatives);

	}

	public Boolean testIsValidSession(String token) throws TokenValidationFailedException {

		JwtResponse response = authenticationFeignClient.verifyToken(token);

		if (!response.isValid()) {

			throw new TokenValidationFailedException("Invalid Token");
		}

		return true;
	}

}
