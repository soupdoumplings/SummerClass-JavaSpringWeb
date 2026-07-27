package io.herald.MySpringWeb.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalleryController {

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
    public String galleryPost(HttpServletRequest request, Model m)
    {
        HttpSession session = request.getSession();

        return "galleryPage.html";
    }
}
