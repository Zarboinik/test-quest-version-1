package foo.bar.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("index.html")
    public String getMainPage(Model model){
        model.addAttribute("test", "test2");
        return "WEB-INF/index.jsp";
    }
}
