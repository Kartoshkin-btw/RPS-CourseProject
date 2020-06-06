package com.controller;

import com.dao.ImageDAO;
import com.dao.UsersDAO;
import com.model.Image;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("/image")
public class ImageController {

    @Autowired
    private ImageDAO imageDAO;
    @Autowired
    private UsersDAO usersDAO;


    //Полный список изображений
    @RequestMapping(value = "/listImages", method = RequestMethod.GET)
    public ModelAndView listImages(ModelAndView model){
        List<Image> listImage = imageDAO.imageList();
        model.addObject("imageThemes", imageDAO.getImageThemes());
        model.addObject("listImages", listImage);
        model.setViewName("clientViews/listImages");

        return model;
    }


    //Полный список изображений
    @RequestMapping(value = "/myImages", method = RequestMethod.GET)
    public ModelAndView myImages(ModelAndView model){

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Users currentUser = usersDAO.findByUserName(username);
        List<Image> listImage = imageDAO.getImagesByAuthor(currentUser.getLogin());

        model.addObject("listImages", listImage);
        model.setViewName("clientViews/myImages");

        return model;
    }

    //Список изображений по выбранной теме
    @RequestMapping(value = "/listImagesByTheme", method = RequestMethod.GET)
    public ModelAndView listImagesByTheme(HttpServletRequest request, ModelAndView model){
        String theme = request.getParameter("theme");
        List<Image> listImageByTheme = imageDAO.getImageByTheme(theme);
        model.addObject("imageThemes", imageDAO.getImageThemes());
        model.addObject("listImages", listImageByTheme);
        model.setViewName("clientViews/listImages");

        return model;
    }
}