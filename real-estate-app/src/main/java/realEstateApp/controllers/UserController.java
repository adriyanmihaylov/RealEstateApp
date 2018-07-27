package realEstateApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import realEstateApp.models.User;
import realEstateApp.services.base.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<User> getAll(){
       return service.findAll();
    }
    @GetMapping("/get")
    public User findById(@RequestParam(value = "id") String id){
        return service.findById(Long.parseLong(id));
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
