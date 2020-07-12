package com.form.form_submission.feed_module;
import com.form.form_submission.FirestoreInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Repository
public class FeedRepositioryIml implements FeedRepository{
    private final String FEED= "feed";
    private final String SLASH = "/";
    private final String UNDERSCORE = "_";
    private final String DOT = ".";


    private Firestore firestoreDb;

    @Autowired
    public FeedRepositioryIml(final FirestoreInitializer fireStoreInitializer){
        firestoreDb = fireStoreInitializer.getDb();
    }


    @Override
    public List<FeedEntity> getlist(String name) {
        return null;
    }
    @Override
    public boolean save(FeedEntity savefeedpost) throws ExecutionException, InterruptedException {
        WriteBatch batch = firestoreDb.batch();

        //write to blog list collection
        DocumentReference documentReference = firestoreDb.collection(FEED)
                .document();
        batch.set(documentReference, savefeedpost);




        ApiFuture<List<WriteResult>> future = batch.commit();
        for (WriteResult result :future.get()) {
//            System.out.println("Update time : " + result.getUpdateTime());
            if (Objects.isNull(result.getUpdateTime())){
                return false;
            }
        }
        return true;
    }
}

