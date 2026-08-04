package io.rushi.SpringWebProject.RController;

import io.rushi.SpringWebProject.Model.UserTable;
import io.rushi.SpringWebProject.Repository.ImageRepository;
import io.rushi.SpringWebProject.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RControllerClass {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/getAllUsers")
    public List<UserTable> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserTable userTable) {
        //@RequestBody -> JSON ma data aako xa vani RequestBody lekhna parxa
        userRepository.save(userTable);
        return "Saved Successfully";
    }

    @GetMapping("/getOne/{id}")
    public  UserTable getOne(@PathVariable int id) {
        UserTable userTable = userRepository.findById(id).get();
        return userTable;
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getId(@PathVariable int id) {

        // UserTable userTable = userRepository.findById(id).get();
        if (userRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(userRepository.findById(id).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID NOT FOUND!!");
        }

    }

}
