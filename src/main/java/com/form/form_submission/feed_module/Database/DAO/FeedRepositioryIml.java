package com.form.form_submission.feed_module.Database.DAO;

import com.form.form_submission.FirestoreInitializer;
import com.form.form_submission.feed_module.DTO.FeedDTO;
import com.form.form_submission.feed_module.Database.Model.FeedEntity;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Repository
public class FeedRepositioryIml implements com.form.form_submission.feed_module.Database.DAO.FeedRepository {
    private final String FEED = "feed"; // name of the collection stored in variable FEED
    private Firestore firestoreDb;

    @Autowired
    public FeedRepositioryIml(final FirestoreInitializer fireStoreInitializer) {
        firestoreDb = fireStoreInitializer.getDb();
    }


    @Override
    public List<FeedDTO> getlist() throws ExecutionException, InterruptedException {
        List<FeedDTO> feedDTOList = new ArrayList<FeedDTO>();                       // creating a list of object of dto class to store posts
        CollectionReference collectionReference = firestoreDb.collection(FEED);
        Query query = collectionReference.orderBy("date", Query.Direction.DESCENDING).limit(5); // getting the doc reference of top  5 latest posts
        ApiFuture<QuerySnapshot> future = query.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        if (Objects.isNull(documents) || documents.size() == 0) {
            return null;
        } else {
            for (QueryDocumentSnapshot documentSnapshot : documents) {
                feedDTOList.add(documentSnapshot.toObject(FeedDTO.class));  // adding documents data as an dto object in list
            }
            return feedDTOList;
        }
    }

    @Override
    public boolean save(FeedEntity savefeedpost) throws ExecutionException, InterruptedException {

      /*  WriteBatch batch = firestoreDb.batch();
        DocumentReference documentReference = firestoreDb.collection(FEED)
                .document();
        batch.set(documentReference, savefeedpost);
        ApiFuture<List<WriteResult>> future = batch.commit();*/

        ApiFuture<WriteResult> future = firestoreDb.collection(FEED).document().set(savefeedpost); //saving the requestVO object data in a document in firestore
        if (Objects.isNull(future.get().getUpdateTime())) {
            return false;
        }

        return true;
    }
}

