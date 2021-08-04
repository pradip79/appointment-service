package com.testannotation.appointmentservice;

import com.testannotation.appointmentservice.client.PatientClient;
import com.testannotation.appointmentservice.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWireMock (port = 9090)
public class AppointServiceIntegrationTestWiremock {
    @Autowired
    PatientClient patientClient;

    @BeforeEach
    public void createStub(){
        stubFor(get(urlPathEqualTo("/patient-service/patient"))
                .withQueryParam("MRN", equalTo("2009120409"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\n"+
                            "\"firstName\": \"John\",\n"+
                            "\"lastName\": \"Smart\",\n"+
                            "\"birthDate\": \"02/02/1997\",\n"+
                            "\"dateOfRegistration\": \"04/12/2009\",\n"+
                            "\"address\": \"15 Foreshore Road, Philadelphia, PA, 19101\",\n"+
                            "\"mrn\": \"2009120401\"\n"+
                             "}")
                )
        );
    }

    @Test
    public void givenMRN_whenSearchForPatient_shouldReturnAPatient(){
        //Given
        String MRN = "2009120409";

        //When
        ResponseEntity<Patient> response = patientClient.searchPatient(MRN);

        //Then
        then(response.getStatusCode().equals(200));
        then(response.getBody().getMRN().equals(MRN));
        then(response.getBody().getRegistrationDate().equals("04/12/2009"));
    }

}
