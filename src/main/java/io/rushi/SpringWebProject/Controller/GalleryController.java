package io.rushi.SpringWebProject.Controller;

import io.rushi.SpringWebProject.Model.ImageTable;
import io.rushi.SpringWebProject.Repository.ImageRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class GalleryController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/gallery")
    public String galleryGet(HttpServletRequest request, Model m)
    {
        HttpSession session = request.getSession();

        if(session.getAttribute("username") == null){
            m.addAttribute("message", "You are not logged in!!");
            return "login";
        }
        return "galleryPage.html";
    }

    @PostMapping("/gallery")
    public String galleryPost(@RequestParam("image") MultipartFile image, HttpSession session)
    {
        try{

            byte[] imageBytes = image.getBytes();
            //Base64 encoder to encode the information of file into the string
            //Base64 decoder to decode it back

            String imageString  = Base64.getEncoder().encodeToString(imageBytes);

            ImageTable img = new ImageTable();
            img.setImage(imageString);

            imageRepository.save(img);

        }catch(IOException ex){
            ex.printStackTrace();
        }
        session.setAttribute("totalImages", imageRepository.findAll());
        return "galleryPage.html";
    }
}
