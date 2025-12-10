//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.service.ChefService;
//import mk.ukim.finki.wp.lab.service.DishService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "chefDetailsServlet", urlPatterns = "/chefDetails")
//class ChefDetailsServlet extends HttpServlet{
//
//    private final ChefService chefService;
//    private final DishService dishService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ChefDetailsServlet(ChefService chefService, DishService dishService, SpringTemplateEngine springTemplateEngine){
//        this.chefService = chefService;
//        this.dishService = dishService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Long chefId = Long.parseLong(req.getParameter("chefId"));
//        String dishID = req.getParameter("dishId");
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        Chef updateChef = chefService.addDishToChef(chefId,dishID);
//
//        context.setVariable("chef", updateChef);
//        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());
//    }
//
//
//}