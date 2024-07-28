package com.patient.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patient.entity.Patient;
import com.patient.service.DiseaseService;
import com.patient.service.DoctorService;
import com.patient.service.PatientService;

import jakarta.persistence.EntityManager;


@Controller
@RequestMapping("/patients")
public class PatientController
{

    // load employee data
    private PatientService patientService;
    private DoctorService doctorService;
    private DiseaseService diseaseService;
    private List<Patient> thePatients;
    @Autowired
    private EntityManager em;

    public PatientController(PatientService patientService, DoctorService doctorService, DiseaseService diseaseService)
    {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.setDiseaseService(diseaseService);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        thePatients = patientService();
        theModel.addAttribute("patients", thePatients);
        return "patients/list-patients";
    }

    private List<Patient> patientService() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/addPatient")
    public String getPatientForm(Model model)
    {
        Patient patient = new Patient();
        model.addAttribute("doctorList",doctorService());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    private Object doctorService() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient thePatient)
    {

        patientService(thePatient);
        return "redirect:/patients/list";
    }

    private void patientService(Patient thePatient) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("patientId") int theID,Model model)
    {
        Patient patient = patientService(theID);
        model.addAttribute("doctorList",doctorService());
        model.addAttribute("patient",patient);
        return "patients/addPatient";
    }

    private Patient patientService(int theID) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/delete")
    public String deletePatient(@RequestParam("patientId") int theID)
    {
        patientService.deleteById(theID);
        return "redirect:/patients/list";
    }

	public DiseaseService getDiseaseService() {
		return diseaseService;
	}

	public void setDiseaseService(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

}