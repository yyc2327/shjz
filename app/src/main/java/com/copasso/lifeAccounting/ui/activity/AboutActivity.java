package com.copasso.lifeAccounting.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.copasso.lifeAccounting.BuildConfig;
import com.copasso.lifeAccounting.R;

import androidx.annotation.NonNull;
import me.drakeet.multitype.Items;
import me.drakeet.support.about.AbsAboutActivity;
import me.drakeet.support.about.Card;
import me.drakeet.support.about.Category;

/**
 * 关于activity
 */
public class AboutActivity extends AbsAboutActivity {
    @Override
    protected void onCreateHeader(@NonNull ImageView icon, @NonNull TextView slogan, @NonNull TextView version) {
        icon.setImageResource(R.mipmap.ic_launcher);
        slogan.setText("生活记账APP");
        version.setText("v " + BuildConfig.VERSION_NAME);
    }

    @Override
    protected void onItemsCreated(@NonNull Items items) {
        items.add(new Category("About and Help"));
        items.add(new Card(getString(R.string.about_introduce)));
    }
}
