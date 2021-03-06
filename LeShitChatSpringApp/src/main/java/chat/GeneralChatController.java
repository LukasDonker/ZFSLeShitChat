package chat;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author ldonker
 *
 */
@Controller
public class GeneralChatController {

	@GetMapping("/generalchat")
    public String generalChat(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "generalchat";
    }
	
}
