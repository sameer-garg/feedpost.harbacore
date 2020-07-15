package com.form.form_submission;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirestoreInitializer {

    @Value("${gcp.projectId}")
    // to store value of gcp.projectId(project name) defined in application.propertied file in projectID variable
    public String projectId;
    private Firestore db;

    // Initialize Firestore using default project ID.
    public FirestoreInitializer() {
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(projectId)
                        .build();
        Firestore db = firestoreOptions.getService();
        this.db = db;
    }

    public Firestore getDb() {
        return db;
    }

}