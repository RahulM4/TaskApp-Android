package com.rahul.task.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.rahul.task.R;

public class UsersActivity extends SingleFragmentActivity {

    public static final String TAG_USERS_FRAGMENT = "tag_users_fragment";

    public static Intent newIntent(Context context) {
        return new Intent(context, UsersActivity.class);
    }

    @Override
    public Fragment getFragment() {
        return UsersFragment.newInstance();
    }

    @Override
    public String getTagName() {
        return TAG_USERS_FRAGMENT;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_manu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.userMenu_back:
                    finish();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
