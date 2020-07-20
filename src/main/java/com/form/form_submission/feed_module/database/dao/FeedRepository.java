package com.form.form_submission.feed_module.database.dao;


import com.form.form_submission.feed_module.bean.dto.FeedDTO;
import com.form.form_submission.feed_module.database.model.FeedEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FeedRepository {
    public boolean save(FeedEntity savefeedpost)
            throws ExecutionException, InterruptedException; // function prototype for saving a post data

    public List<FeedDTO> getlist()
            throws ExecutionException, InterruptedException; // function prototype for creating a list of 5 latest posts
}
