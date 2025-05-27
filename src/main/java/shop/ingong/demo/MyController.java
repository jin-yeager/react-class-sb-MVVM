package shop.ingong.demo;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {
	
   @GetMapping("/")
    public void index(HttpServletResponse resp) throws IOException {
       PrintWriter out = resp.getWriter();
       out.println("Hello, WORLD");
   }

/*   
   @GetMapping("/thymeleaf")
   public String thymeleaf(HttpServletResponse resp) throws IOException {
      return "thymeleaf";
  }
*/
   
   @GetMapping("/java")
   public String jsp(HttpServletResponse resp) throws IOException {
      return "java";
  } 
   
  
}

