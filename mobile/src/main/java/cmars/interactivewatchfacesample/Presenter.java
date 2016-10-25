package cmars.interactivewatchfacesample;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by cmars on 10/25/16.
 */

public class Presenter {
    private Store store;
    private ObservableField<String> label = new ObservableField<>();

    public void toggle(View view) {
        boolean value = !store.getValue();
        store.setValue(value);

        label.set(String.valueOf(value));
    }

    public ObservableField<String> getLabel() {
        return label;
    }

    public void init() {
        store = Store.getInstance();
    }
}
