//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.ChefService;
//import mk.ukim.finki.wp.lab.service.DishService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "DishServlet", urlPatterns = "/dish")
//class DishServlet extends HttpServlet{
//
//    private final DishService dishService;
//    private final ChefService chefService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public DishServlet(DishService dishService, ChefService chefService, SpringTemplateEngine springTemplateEngine){
//        this.dishService = dishService;
//        this.chefService = chefService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        Long chefId = Long.parseLong(req.getParameter("chefId"));
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("chef", chefService.findById(chefId));
//        context.setVariable("dishes", dishService.listDishes());
//        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
//
////        resp.sendRedirect("/servlet/category");
//    }
//
//}