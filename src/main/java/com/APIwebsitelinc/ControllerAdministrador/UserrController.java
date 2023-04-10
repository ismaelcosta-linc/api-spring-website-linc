//package com.APIwebsitelinc.ControllerAdministrador;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.APIwebsitelinc.Model.Administrador;
//import com.APIwebsitelinc.Model.Userr;
//import com.APIwebsitelinc.Repository.UserrRepository;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class UserrController {
//	
//	@Autowired
//	private UserrRepository userrrepository;
//	
//	
//	@GetMapping("/users")
//    public List<Userr> getUsers() {
//        return (List<Userr>) userrrepository.findAll();
//    }
//
//    @PostMapping("/users")
//    void addUser(@RequestBody Userr userr) {
//        userrrepository.save(userr);
//    }
//	
//	
//}
