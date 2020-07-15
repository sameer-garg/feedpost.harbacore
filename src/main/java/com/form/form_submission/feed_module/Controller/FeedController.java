package com.form.form_submission.feed_module.Controller;

import com.form.form_submission.feed_module.RequestVO.FeedRequestVO;
import com.form.form_submission.feed_module.Service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@Controller
public class FeedController {
    @Autowired
   private FeedService service;


    @RequestMapping(value = "/feedpost")
    public ModelAndView getForm() throws ExecutionException, InterruptedException {                           // the url being localhost:8080/show-form?pg-id={the page id}
        FeedRequestVO feedpost= new FeedRequestVO();               // creating an object to store data from UI
        ModelAndView mav= new ModelAndView();
        mav.addObject("feedpost", feedpost);
        mav.addObject("posts", service.getListOfFeedPost());// sending the feedpost object to store the required user details and the feedpost
        mav.setViewName("formfeedpost");                                        // rendering the form template where the user enter details
        return mav;
    }

    @PostMapping(value = "/feedposted")
    public String postForm(@ModelAttribute("feedpost") FeedRequestVO feedpost) throws ExecutionException, InterruptedException {
        if(service.dataPersistObject(feedpost))                          // calling service methods to persist data which return true if persist was a success
            return "feedpostadded";
        else
            return "fail";
    }
}