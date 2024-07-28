package com.patient.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Committed in git.

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="patient_name")
    private String patientName;
    @Column(name="father_name")
    private String fatherName;
    @Column(name="gender")
    private String gender;
    @Column(name="cnic")
    private String cnic;
    @Column(name="date_of_birth")
    //@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name="disease_history")
    private String DiseaseHistory;
    @Column(name="priscription")
    private String Prescription;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="doctor_name")
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "patient_disease",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private List<Disease> diseaseList;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "patient_medicine",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicineList;

    public Patient()
    {

    }

    // conveniece method for medicines

    public void addDisease(Disease disease)
    {
        if(diseaseList == null)
        {
            diseaseList = new ArrayList<>();
        }
        diseaseList.add(disease);
    }

    // conveniece method for medicines
    public void addMedicine(Medicine medicine)
    {
        if(medicineList==null)
        {
            medicineList=new ArrayList<>();
        }
        medicineList.add(medicine);
    }
    public Patient(String name, String fatherName, String gender, String CNIC, Date dateOfBirth, String diseaseHistory, String prescription)
    {
        patientName = name;
        this.fatherName = fatherName;
        this.gender = gender;
        this.cnic = CNIC;
        this.dateOfBirth = dateOfBirth;
        DiseaseHistory = diseaseHistory;
        Prescription = prescription;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return patientName;
    }

    public void setName(String name)
    {
        patientName = name;
    }

    public String getFatherName()
    {
        return fatherName;
    }

    public void setFatherName(String fatherName)
    {
        this.fatherName = fatherName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCNIC()
    {
        return cnic;
    }

    public void setCNIC(String CNIC)
    {
        this.cnic = CNIC;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public String getDiseaseHistory()
    {
        return DiseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory)
    {
        DiseaseHistory = diseaseHistory;
    }

    public String getPrescription()
    {
        return Prescription;
    }

    public void setPrescription(String prescription)
    {
        Prescription = prescription;
    }

    public List<Medicine> getMedicineList()
    {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList)
    {
        this.medicineList = medicineList;
    }
}