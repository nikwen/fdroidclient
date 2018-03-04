package org.fdroid.fdroid.views.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.fdroid.views.hiding.HidingManager;

public class SearchViewBinder {

    public SearchViewBinder(final AppCompatActivity activity, FrameLayout parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.main_tab_search, parent, true);

        FloatingActionButton searchFab = (FloatingActionButton) view.findViewById(R.id.btn_search);
        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, AppListActivity.class));
            }
        });
        searchFab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (Preferences.get().hideOnLongPressSearch()) {
                    HidingManager.showHideDialog(activity);
                    return true;
                } else {
                    return false;
                }
            }
        });

    }

    public void bind() {}

    public void unbind() {}
}
