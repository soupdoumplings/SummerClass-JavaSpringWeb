package io.rushi.SpringWebProject.RController;

import io.rushi.SpringWebProject.Model.UserTable;
import io.rushi.SpringWebProject.Repository.ImageRepository;
import io.rushi.SpringWebProject.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RControllerClass {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/getAllUsers")
    public List<UserTable> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/api/saveUser")
    public String saveUser(@RequestBody UserTable userTable) {
        //@RequestBody -> JSON ma data aako xa vani RequestBody lekhna parxa
        userRepository.save(userTable);
        return "Saved Successfully";
    }

}
