package de.nilix.simplebackup;

import android.app.ActionBar;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nico99 on 16.07.17.
 */

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        supportPostponeEnterTransition();

        PackageManager pm = getPackageManager();

        Bundle extras = getIntent().getExtras();
        ApplicationInfo applicationInfo = extras.getParcelable(Tab1Fragment.EXTRA_APP_ITEM);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView appTitle = (TextView) findViewById(R.id.appTitle);

        appTitle.setText(applicationInfo.loadLabel(pm).toString());
        imageView.setImageDrawable(applicationInfo.loadIcon(pm));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(applicationInfo.loadLabel(pm).toString());
        supportStartPostponedEnterTransition();

    }
}
