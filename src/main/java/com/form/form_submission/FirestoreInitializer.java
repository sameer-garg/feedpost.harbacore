package com.form.form_submission;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirestoreInitializer {

    @Value("${gcp.projectId}")
    public String projectId;

    private Firestore db;

    /**
     * Initialize Firestore using default project ID.
     */
    public FirestoreInitializer() {
        System.out.println("Initializing this");
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(projectId)
                        .build();
        Firestore db = firestoreOptions.getService();
        this.db = db;
    }

    /**
     * Get firestore db
     * @return
     */
    public Firestore getDb() {
        return db;
    }

}