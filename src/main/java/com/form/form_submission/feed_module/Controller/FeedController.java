package com.form.form_submission.feed_module.Controller;

import com.form.form_submission.feed_module.Beans.RequestVO.FeedRequestVO;
import com.form.form_submission.feed_module.Service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@Controller
public class  FeedController {
    @Autowired
    private FeedService service;


    @RequestMapping(value = "/addpost")                             // url to add a post
    public ModelAndView getForm() throws ExecutionException, InterruptedException {
        FeedRequestVO feedpost = new FeedRequestVO();               // creating an RequestVO object "feedpost" to store data from UI
        ModelAndView mav = new ModelAndView();
        mav.addObject("feedpost", feedpost);            // sending the feedpost object to store the required user details and the feedpost
        mav.setViewName("formfeedpost");                            // rendering the form template where the user enter details
        return mav;
    }

    @PostMapping(value = "/feedposted")
    public String postForm(@ModelAttribute("feedpost") FeedRequestVO feedpost) throws ExecutionException, InterruptedException {
        if (service.dataPersistObject(feedpost)) {                   // calling service methods to persist data which return true if persist was a success
            return "redirect:/listfeed";                             // redirecting to the listfeed page if the post is added
        }
        else
            return "fail";                                           // redirecting to template displaying the
                                                                     // message that post saving  not successful
    }


    @RequestMapping(value = "/listfeed")                             // the listing feed url
    public ModelAndView listfeed() throws ExecutionException, InterruptedException {
        ModelAndView mavFeedList = new ModelAndView();
        mavFeedList.addObject
                ("posts", service.getListOfFeedPost());   // simultaneous calling and passing of list named "posts" consiting of posts sorted acc to latest update time
        mavFeedList.setViewName("feedlist");                          // rendering the form template where the user enter details
        return mavFeedList;
    }
}
