package org.premiumapp.celeba.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import org.premiumapp.celeba.R;
import org.premiumapp.celeba.view.search.SearchFragment;
import org.premiumapp.celeba.view.search.BlankFragment2;

public class MainActivity extends AppCompatActivity {

//    private TextView mTextMessage;

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

        if (null != findViewById(R.id.content)) {
            if (savedInstanceState != null) {
                return;
            }
            SearchFragment searchFragment = new SearchFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, searchFragment)
                    .commit();
        }


//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
