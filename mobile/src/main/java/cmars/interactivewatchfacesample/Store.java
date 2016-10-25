package cmars.interactivewatchfacesample;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by cmars on 10/25/16.
 */

public class Store {
    public static final String KEY="key";

    FirebaseDatabase database;
    DatabaseReference reference;
    private boolean value;

    private Store() {
        database = FirebaseDatabase.getInstance();
        reference=database.getReference(KEY);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean value = (Boolean) dataSnapshot.getValue();
                Store.this.value = value != null ? value : false;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setValue(boolean value) {
        reference.setValue(value);
    }

    public boolean getValue() {
        return value;
    }

    private static class InstanceHolder {
        private final static Store INSTANCE = new Store();
    }

    public static Store getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
