package com.form.form_submission.feed_module.DAO;


import com.form.form_submission.feed_module.DTO.FeedDTO;
import com.form.form_submission.feed_module.Model.FeedEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FeedRepository  {
    public  boolean save(FeedEntity savefeedpost) throws ExecutionException, InterruptedException;

    public List<FeedDTO> getlist() throws ExecutionException, InterruptedException;
}
