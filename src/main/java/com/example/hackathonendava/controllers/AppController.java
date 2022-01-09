package com.example.hackathonendava.controllers;

import com.example.hackathonendava.model.ImageOCR;
import com.example.hackathonendava.ocr.ImageToText;
import com.example.hackathonendava.registration.User;
import com.example.hackathonendava.registration.UserRepository;
import com.example.hackathonendava.repository.CourseRepository;
import com.example.hackathonendava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.*;
import java.util.List;

@Controller
public class AppController {

    private String path;
    String res;

    private String currentUser = "none";

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private CourseRepository courseRepo;

    private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    @GetMapping("")
    public String viewHomePage(User user) {
        return "home_page";
    }

    @GetMapping("/home")
    public String viewHome() {
        return "home_page";
    }



    @GetMapping("/notes")
    public ModelAndView viewNotes(Model model) {
        ImageToText imageOCR = new ImageToText();
        imageOCR.setResult("bb");
        if(path != null) {
            String res = imageOCR.imageToText(path);
        }
        ModelAndView mav = new ModelAndView("notes");
        mav.addObject("imageOCR", imageOCR);
        model.addAttribute("resultText",res);

        return mav;
    }

    @RequestMapping( "/image" )
    public String image () {
        return "/image" ;
    }

    @PostMapping ("/upload")
    public RedirectView StringhandleFileUpload (Model model, @RequestParam( "image" ) MultipartFile file ) {
        ImageToText imageOCR = new ImageToText();
        if (!file.isEmpty ()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();

                res = imageOCR.imageToText(file.getOriginalFilename());

            } catch (FileNotFoundException e ) {
                e.printStackTrace ();

            } catch (IOException e ) {
                e .printStackTrace ();
            }
        }
        return new RedirectView("/notes",true);
    }

    @GetMapping("/professors")
    public String viewProfessors() {

        return "professors";
    }

    @GetMapping("/quizes")
    public String viewQuizes() {

        return "quizes";
    }
    @GetMapping("/quiz_solve")
    public String viewQuizSolve() {

        return "quiz_solve";
    }

    @GetMapping("/deadlines")
    public String viewDeadlines() {
        return "tasks";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register_form";
    }
    @GetMapping("/login_page")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login_page";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println(user.getEmail());
        user.setEnabled(true);
        try {
            userRepo.save(user);
        }
        catch (Exception e) {
            return "register_error";
        }

        return "login_page";
    }

    @GetMapping({"/management"})
    public ModelAndView listUsers() {
        ModelAndView mav = new ModelAndView("management");
        mav.addObject("listUsers", (List<User>) userRepo.findAll());
        return mav;

    }

}
