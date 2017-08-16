package org.premiumapp.celeba.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.premiumapp.celeba.R;
import org.premiumapp.celeba.view.search.SearchFragment;
import org.premiumapp.celeba.view.search.BlankFragment2;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    //    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {

        switch (item.getItemId()) {
            case R.id.navigation_home:

                SearchFragment searchFragment = new SearchFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.content, searchFragment).commit();
                //                    mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:

                System.out.println("Heloooooooooooooooooooooooooooooooooooooooo");
                BlankFragment2 blankFragment2 = new BlankFragment2();

                getSupportFragmentManager().beginTransaction().replace(R.id.content, blankFragment2).commit();
                //                    mTextMessage.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                //                    mTextMessage.setText(R.string.title_notifications);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        if (null != findViewById(R.id.content)) {
//            if (savedInstanceState != null) {
//                return;
//            }
//            SearchFragment searchFragment = new SearchFragment();
//
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.content, searchFragment)
//                    .commit();
//        }


//        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        actionBar = getSupportActionBar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.toolbarSearch:

                hideVidgets();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                                android.R.anim.fade_in, android.R.anim.fade_out)
                        .add(R.id.container, new SearchFragment())
                        .addToBackStack(null)
                        .commit();

                break;
        }
        return true;
    }

    public void hideVidgets() {
        actionBar.hide();
        navigation.setVisibility(View.GONE);
    }

    public void showVidgets() {
        actionBar.show();
        navigation.setVisibility(View.VISIBLE);
    }
}
