package com.springRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patient.entity.Disease;
import com.patient.entity.Doctor;
import com.patient.service.DiseaseService;
import com.patient.service.DoctorService;
import com.patient.service.PatientService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Controller
@RequestMapping("/diseases")
public class ReportsController
{
    // load employee data
    private DoctorService doctorService;
    private PatientService patientService;
    private DiseaseService diseaseService;
    private List<Disease> theDiseases;

    public ReportsController(DoctorService doctorService, PatientService patientService, DiseaseService diseaseService)
    {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/list")
    public String listDoctors(Model theModel)
    {
        theModel.addAttribute("diseaseList",diseaseService.getAllDiseases());
        return "disease/list-disease";
    }

    @GetMapping("/addDisease")
    public String getDoctorForm(Model model)
    {
        Disease disease = new Disease();
        model.addAttribute("disease",disease);
        return "disease/addDisease";
    }

    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute("disease") Disease theDoctor)
    {
        diseaseService.save(theDoctor);
        return "redirect:/diseases/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("diseaseId") int theID,Model model)
    {
        model.addAttribute("disease",diseaseService.findById(theID));
        return "disease/addDisease";
    }

    @Autowired
    @PersistenceContext
    private EntityManager em;
    @GetMapping("/delete")
    @Transactional
    public String deleteDoctor(@RequestParam("diseaseId") int theID)
    {
        Disease a = em.find(Disease.class, theID);
        for (Doctor b : a()) {
            if (b.getDisease() !=null)
            {
                em.remove(a);
            }
        }
        em.remove(a);
        //diseaseService.deleteById(theID);
        return "redirect:/diseases/list";
    }

	private Doctor[] a() {
		// TODO Auto-generated method stub
		return null;
	}
}
