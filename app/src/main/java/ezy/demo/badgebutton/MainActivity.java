package ezy.demo.badgebutton;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;



import ezy.ui.view.BadgeButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        addTabItem(tabs, "首页", R.mipmap.list_1, false, "");
        addTabItem(tabs, "分类", R.mipmap.list_2, false, "");
        addTabItem(tabs, "消息", R.mipmap.list_3, true, "9");
        addTabItem(tabs, "发现", R.mipmap.list_4, false, "");
        addTabItem(tabs, "我的", R.mipmap.list_5, true, "");
        tabs.getTabAt(0).select();
     }

    void addTabItem(TabLayout tabs, String text, int icon, boolean visible, String badge) {
        BadgeButton item = (BadgeButton) getLayoutInflater().inflate(R.layout.item_tab, tabs, false);
        item.setIcon(wrap(icon));
        item.setText(text);
        item.setBadgeText(badge);
        item.setBadgeVisible(visible);
        item.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tabs.addTab(tabs.newTab().setCustomView(item));
    }

    ColorStateList mTint;

    Drawable wrap(int icon) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),icon, getTheme());
        if (mTint == null) {
            mTint = ResourcesCompat.getColorStateList(getResources(), R.color.tab, getTheme());
        }
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(drawable, mTint);
        }
        return drawable;
    }

    @Override
    public void onClick(View v) {
    }
}
