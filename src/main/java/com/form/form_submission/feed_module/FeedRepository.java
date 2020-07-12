package com.form.form_submission.feed_module;


import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FeedRepository  {
    public  boolean save(FeedEntity savefeedpost) throws ExecutionException, InterruptedException;

    public List<FeedEntity> getlist(String name);
}
