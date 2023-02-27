package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/register")
    public String showForm(Model model) {
        FormData formData = new FormData();
        model.addAttribute("formdata", formData);
        return "form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("formdata") FormData formData, Model model) {

        DrawField result = DrawFieldService.getDrawField(formData);
        model.addAttribute("result", result);
        return "result";
    }

}
