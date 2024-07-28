package com.patient.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patient.entity.Medicine;
import com.patient.entity.Patient;
import com.patient.service.MedicineService;

import jakarta.persistence.EntityManager;


@Controller
@RequestMapping("/medicines")
public class MedicineController
{
    private MedicineService medicineService;
    private List<Medicine> themedicines;

    @Autowired
    private EntityManager em;

    public MedicineController(MedicineService medicineService)
    {
        //this.medicineRepository = medicineRepository;
        this.medicineService = medicineService;
    }

    @GetMapping("/list")
    public String listmedicines(Model theModel)
    {
        //HttpServletRequest request,
//        int page = 0; //default page number is 0 (yes it is weird)
//        int size = 10; //default page size is 10
//
//        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//            page = Integer.parseInt(request.getParameter("page")) - 1;
//        }
//
//        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//            size = Integer.parseInt(request.getParameter("size"));
//        }
        themedicines = medicineService();
        //medicineRepository.findAll(PageRequest.of(page, size))
        theModel.addAttribute("medicines", themedicines);
        return "medicine/list-medicines";
    }

    private List<Medicine> medicineService() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/addMedicine")
    public String getmedicineForm(Model model)
    {
        Medicine themedicine = new Medicine();
        model.addAttribute("medicine",themedicine);
        return "medicine/addMedicine";
    }

    @PostMapping("/save")
    public String savemedicine(@ModelAttribute("medicine") Medicine themedicine)
    {
        medicineService(themedicine);
        return "redirect:/medicines/list";
    }

    private void medicineService(Medicine themedicine) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("medicineId") int theID,Model model)
    {
        Medicine medicine = medicineService(theID);
        model.addAttribute("medicine",medicine);
        return "medicine/addMedicine";
    }

    private Medicine medicineService(int theID) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/delete")
    public String deletemedicine(@RequestParam("medicineId") int theID)
    {
        Medicine a = em.find(Medicine.class, theID);
        for (Patient b : a()) {
            if (b.getMedicineList().size() == 1) {
                em.remove(b);
            } else {
                b.getMedicineList().remove(a);
            }
        }
        em.remove(a);
        medicineService.deleteById(theID);
        return "redirect:/medicines/list";
    }

	private Patient[] a() {
		// TODO Auto-generated method stub
		return null;
	}


}
