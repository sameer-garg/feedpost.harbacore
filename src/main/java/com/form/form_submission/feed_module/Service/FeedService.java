package com.form.form_submission.feed_module.Service;

import com.form.form_submission.feed_module.Database.DAO.FeedRepository;
import com.form.form_submission.feed_module.DTO.FeedDTO;
import com.form.form_submission.feed_module.Database.Model.FeedEntity;
import com.form.form_submission.feed_module.RequestVO.FeedRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FeedService {
    @Autowired
    private FeedRepository repo;

    public Date getCurrentTimeUsingDate() {
        long date = System.currentTimeMillis();  // tge format for date in epoc time
        Date currentEpocTime = new Date(date);
        return currentEpocTime;
    }

    public boolean dataPersistObject(FeedRequestVO feedpost) {
        FeedEntity savefeedpost = new FeedEntity();                  // creating an object of entity class  for persisting it into database
        savefeedpost.name = feedpost.name;
        savefeedpost.image = feedpost.image;
        savefeedpost.content = feedpost.content;
        savefeedpost.date = getCurrentTimeUsingDate();
        return dataPersistObjectPopulate(savefeedpost);   // true if the data is saved and false if its not
    }

    public boolean dataPersistObjectPopulate(FeedEntity savefeedpost) {
        return save(savefeedpost);
    }

    public boolean save(FeedEntity savefeedpost) {
        try {
            repo.save(savefeedpost);
            return true;
        } catch (Exception Submitfailed) {
            return false;
        }
    }

    public List<FeedDTO> getListOfFeedPost() throws ExecutionException, InterruptedException {
        return repo.getlist();
    }
}
