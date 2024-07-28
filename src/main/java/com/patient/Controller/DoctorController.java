package com.patient.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patient.entity.Doctor;
import com.patient.service.DiseaseService;
import com.patient.service.DoctorService;
import com.patient.service.PatientService;


@Controller
@RequestMapping("/doctors")
public class DoctorController
{

    // load employee data
    private DoctorService doctorService;
    private PatientService patientService;
    private DiseaseService diseaseService;
    private List<Doctor> theDoctors;

    public DoctorController(DoctorService doctorService, PatientService patientService, DiseaseService diseaseService)
    {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/list")
    public String listDoctors(Model theModel)
    {
        theDoctors = doctorService();
        theModel.addAttribute("doctors", theDoctors);
        //theModel.addAttribute("diseaseList",diseaseService.getAllDiseases());
        return "doctors/list-doctors";
    }

    private List<Doctor> doctorService() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/addDoctor")
    public String getDoctorForm(Model model)
    {
        Doctor Doctor = new Doctor();
        model.addAttribute("diseaseList",diseaseService());
        model.addAttribute("doctor",Doctor);
        return "doctors/addDoctor";
    }

    private Object diseaseService() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/save")
    public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor)
    {

        return "redirect:/doctors/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("doctorId") int theID,Model model)
    {
        List<Doctor> doctor = doctorService();
        model.addAttribute("diseaseList",diseaseService());
        model.addAttribute("doctor",doctor);
        return "doctors/addDoctor";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("doctorId") int theID)
    {
        doctorService.deleteById(theID);
        return "redirect:/doctors/list";
    }


}
