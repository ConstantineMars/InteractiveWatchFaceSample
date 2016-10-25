package cmars.interactivewatchfacesample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import cmars.interactivewatchfacesample.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    private Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        binding.setPresenter(presenter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        presenter.init();
    }
}
