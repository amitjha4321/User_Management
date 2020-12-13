package com.example.usermanagement.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.usermanagement.NavFragments.DashboardFragment;
import com.example.usermanagement.NavFragments.ProfileFragment;
import com.example.usermanagement.NavFragments.UsersFragment;
import com.example.usermanagement.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DashboardFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.dashboard:
                fragment=new DashboardFragment();
                break;
            case R.id.users:
                fragment=new UsersFragment();
                 break;
            case R.id.profile:
                fragment=new ProfileFragment();
                break;
        }
        if (fragment!=null){
            loadFragment(fragment);
        }
        return true;
    }

    //method to load fragment in our relative layout for navigation
    void loadFragment(Fragment fragment){
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, fragment).commit();
    }



}