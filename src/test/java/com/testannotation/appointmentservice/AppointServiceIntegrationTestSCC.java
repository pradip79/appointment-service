package com.testannotation.appointmentservice;

import com.testannotation.appointmentservice.client.PatientClient;
import com.testannotation.appointmentservice.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.testannotation:patient-service:+:7070",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class AppointServiceIntegrationTestSCC {
    @Autowired
    PatientClient patientClient;

    @Test
    public void scheduleAppointment(){
        //Given
        String MRN = "2009120401";

        //When
        ResponseEntity<Patient> response = patientClient.searchPatient(MRN);

        //Then
        then(response.getStatusCode().equals(200));
        then(response.getBody().getMRN().equals(MRN));
        then(response.getBody().getDateOfRegistration().equals("04/12/2009"));
    }

}
