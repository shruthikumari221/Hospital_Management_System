package com.patient.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patient.entity.Doctor;
import com.patient.entity.Medicine;
import com.patient.entity.Patient;
import com.patient.service.DoctorService;
import com.patient.service.MedicineService;
import com.patient.service.PatientService;

@Controller
@RequestMapping("reports")
public class ReportsController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicineService medicineService;

    @RequestMapping(value = "/patient-report", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public void patientReport()
    {

        List<Patient> patients = patientService();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = Patient-Report.pdf");

      
    }

    private List<Patient> patientService() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/doctor-report", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> doctorReport(InputStreamSource bis)
    {

        List<Doctor> doctors = doctorService();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = Doctor-Report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    private List<Doctor> doctorService() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/medicine-report", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> medicineReport(InputStreamSource bis)
    {

        List<Medicine> medicines = medicineService();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = Medicine-Report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    private List<Medicine> medicineService() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/doctor-report")
    public String getDoctorReports()
    {

        return "report/doctor-report";
    }

    @GetMapping("/patient-report")
    public String getPatientReports()
    {
        return "report/patient-report";
    }

    @GetMapping("/medicine-report")
    public String getMedicineReports()
    {
        return "report/medicine-report";
    }

}