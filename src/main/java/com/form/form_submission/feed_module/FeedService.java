package com.form.form_submission.feed_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FeedService {
    @Autowired
    private FeedRepository repo;

    public String  getCurrentTimeUsingDate() {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  a");
    String formattedDate= dateFormat.format(date);
    return formattedDate;
    }
    public boolean dataPersistObject(FeedRequestVO feedpost) {
        FeedEntity savefeedpost=new FeedEntity();                  // creating an object of entity class  for persisting it into database
        savefeedpost.name=feedpost.name;
        savefeedpost.image=feedpost.image;
        savefeedpost.content=feedpost.content;
        savefeedpost.date= getCurrentTimeUsingDate();
        return dataPersistObjectPopulate(savefeedpost);
    }

    public  boolean  dataPersistObjectPopulate(FeedEntity savefeedpost){
        return save(savefeedpost);
    }

    public boolean save(FeedEntity savefeedpost){
        try{
            repo.save(savefeedpost);
            return true;
        }
        catch (Exception Submitfailed)
        {
            return false;
        }
    }
}
