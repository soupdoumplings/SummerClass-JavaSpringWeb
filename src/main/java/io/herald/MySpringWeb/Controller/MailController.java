package io.herald.MySpringWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @GetMapping("/mail")
    public String mailGet()
    {
        return "mailPage.html";
    }
}
