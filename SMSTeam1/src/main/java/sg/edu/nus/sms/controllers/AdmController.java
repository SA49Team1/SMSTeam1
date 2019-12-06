package sg.edu.nus.sms.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sg.edu.nus.sms.model.Course;
import sg.edu.nus.sms.model.Faculty;
import sg.edu.nus.sms.model.Students;
import sg.edu.nus.sms.repo.CourseRepository;
import sg.edu.nus.sms.repo.FacultyRepository;
import sg.edu.nus.sms.repo.StudentsRepository;

@Controller
@SessionAttributes("user")
@RequestMapping("/admin")
public class AdmController {
	
	
	@Autowired
	private StudentsRepository sturepo;
	
	@Autowired
	private FacultyRepository facrepo;
	
	@Autowired
	private CourseRepository courepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		
	}
	
	//////////////////////////////////////////Student
	
	@GetMapping("/studentlist")
	public String liststudents(Model model) {

		ArrayList<Students> stulist=new ArrayList<Students>();
		stulist.addAll(sturepo.findAll());
		model.addAttribute("students",stulist);
		return "studentlist";
	}
	
	@GetMapping("/addstudent")
	public String addStudentForm(Model model) {
		Students stu=new Students();
		model.addAttribute("student",stu);
				
		return "studentform";
	}
	
	@RequestMapping(value="/savestudent",path="/savestudent", method= {RequestMethod.GET, RequestMethod.POST}, produces="text/html")
	public String saveStudent(@Valid @ModelAttribute Students stu, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			return "studentform";
		}
		
		Students s1= sturepo.findByStudentID(stu.getStudentID());
		
		if(s1!=null) stu.setId(s1.getId());
		
		sturepo.save(stu);
		
		return "forward:/admin/studentlist";
	}

	@GetMapping("/editstudent/{id}")
	public String editStudentForm(Model model, @PathVariable("id") Integer id) {
		Students stu=sturepo.findById(id).get();
		model.addAttribute("student",stu);
				
		return "studentform";
	}

	
	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(Model model, @PathVariable("id") Integer id) {
		Students stu=sturepo.findById(id).get();
		sturepo.delete(stu);
		
		
		
		return "forward:/admin/studentlist";
	}
	
	/////////////////////////////////////////////////////faculty
	
	@GetMapping("/facultylist")
	public String listfaculty(Model model) {

		ArrayList<Faculty> faclist=new ArrayList<Faculty>();
		faclist.addAll(facrepo.findAll());
		model.addAttribute("faculties",faclist);
		return "facultylist";
	}
	
	
	@GetMapping("/addfaculty")
	public String addFacultyForm(Model model) {
		Faculty fac=new Faculty();
		model.addAttribute("faculty",fac);
				
		return "facultyform";
	}
	
	@GetMapping("/editfaculty/{id}")
	public String editFacultyForm(Model model, @PathVariable("id") Integer id) {
		Faculty fac=facrepo.findById(id).get();
		model.addAttribute("faculty",fac);
				
		return "facultyform";
	}
	
	@GetMapping("/deletefaculty/{id}")
	public String deleteFaculty(Model model, @PathVariable("id") Integer id) {
		Faculty fac=facrepo.findById(id).get();
		facrepo.delete(fac);
		return "forward:/admin/facultylist";
	}
	
	
	@RequestMapping(value="/savefaculty",path="/savefaculty", method= {RequestMethod.GET, RequestMethod.POST}, produces="text/html")
	public String saveFaculty(@Valid @ModelAttribute Faculty fac, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			return "facultyform";
		}
		
        Faculty f1= facrepo.findByFacultyID(fac.getFacultyID());
		
		if(f1!=null) fac.setId(f1.getId());
		facrepo.save(fac);
		
		return "forward:/admin/facultylist";
	}
	
	///////////////////////////////////////////Course
	
	@GetMapping("/courselist")
	public String listcourse(Model model) {

		ArrayList<Course> coulist=new ArrayList<Course>();
		coulist.addAll(courepo.findAll());
		model.addAttribute("courses",coulist);
		return "courselist";
	}
	
	
	@GetMapping("/addcourse")
	public String addCourseForm(Model model) {
		Course cou=new Course();
		model.addAttribute("course",cou);
				
		return "courseform";
	}
	
	@GetMapping("/editcourse/{id}")
	public String editCourseForm(Model model, @PathVariable("id") Integer id) {
		Course cou=courepo.findById(id).get();
		model.addAttribute("course",cou);
				
		return "courseform";
	}
	
	@GetMapping("/deletecourse/{id}")
	public String deleteCourse(Model model, @PathVariable("id") Integer id) {
		Course cou=courepo.findById(id).get();
		courepo.delete(cou);
		return "forward:/admin/courselist";
	}
	
	
	@RequestMapping(value="/savecourse",path="/savecourse", method= {RequestMethod.GET, RequestMethod.POST}, produces="text/html")
	public String saveCourse(@Valid @ModelAttribute Course cou, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			return "courseform";
		}
		
		Course c1= courepo.findByCourseCode(cou.getCourseCode());
		
		if(c1!=null) cou.setId(c1.getId());
		
		
		courepo.save(cou);
		
		return "forward:/admin/courselist";
	}
	
	
	/////////////////////////////////////////Leave application
	@GetMapping("/applicationlist")
	public String listcourseapplication() {
		
		return "applicationlist";
	}
}
