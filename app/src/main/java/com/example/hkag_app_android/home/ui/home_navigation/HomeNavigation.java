package com.example.hkag_app_android.home.ui.home_navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hkag_app_android.R;
import com.example.hkag_app_android.home.domain.NavigationItem;
import com.example.hkag_app_android.information.ui.beadhouse_information.BeadHouseActivity;
import com.example.hkag_app_android.home.ui.home_navigation.widget.NavigationAdapter;
import com.example.hkag_app_android.information.ui.contact_information.ContactInformationActivity;
import com.example.hkag_app_android.information.ui.latest_events.LatestEventsActivity;
import com.example.hkag_app_android.information.ui.online_learning_brief.OnLineLearningBriefActivity;
import com.example.hkag_app_android.information.ui.project_brief.ProjectBriefActivity;
import com.example.hkag_app_android.information.ui.video_play.VideoPlayActivity;
import com.example.hkag_app_android.information.ui.website_information.WebsiteInformationActivity;
import com.example.hkag_app_android.information.ui.workshop_brief.WorkshopBriefActivity;
import com.example.hkag_app_android.setting.ui.setting.AppSettingActivity;
import com.example.hkag_app_android.utility.Launcher;


public class HomeNavigation extends AppCompatActivity {

    private ListView _navigationItemListView;
    private Launcher _launcher = new Launcher();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_navigation);


        _navigationItemListView = (ListView) findViewById(R.id.navigationItemList);

        NavigationItem[] data = {
                new NavigationItem(R.drawable.beadhouse_icon, "選擇安老院舍"),
                new NavigationItem(R.drawable.video_icon, "護老技巧示範短片"),
                new NavigationItem(R.drawable.online_icon, "院舍網上學習平台"),
                new NavigationItem(R.drawable.event_icon, "最新活動資訊"),
                new NavigationItem(R.drawable.workshop_icon, "護老者工作坊"),
                new NavigationItem(R.drawable.information_icon, "護老者資訊"),
                new NavigationItem(R.drawable.project_icon, "計劃簡介"),
                new NavigationItem(R.drawable.contact_icon, "聯絡我們")};

        NavigationAdapter navigationAdapter = new NavigationAdapter(this, R.layout.item_navigation, data);
        _navigationItemListView.setAdapter(navigationAdapter);

        _navigationItemListView.setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));

        _navigationItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(HomeNavigation.this, id + "", Toast.LENGTH_LONG).show();

                Class<?> _targetActivity = null;

                switch ((int) id) {
                    case 0:
                        _targetActivity = BeadHouseActivity.class;
                        break;
                    case 1:
                        _targetActivity = VideoPlayActivity.class;
                        break;
                    case 2:
                        _targetActivity = OnLineLearningBriefActivity.class;
                        break;
                    case 3:
                        _targetActivity = LatestEventsActivity.class;
                        break;
                    case 4:
                        _targetActivity = WorkshopBriefActivity.class;
                        break;
                    case 5:
                        _targetActivity = WebsiteInformationActivity.class;
                        break;
                    case 6:
                        _targetActivity = ProjectBriefActivity.class;
                        break;
                    case 7:
                        _targetActivity = ContactInformationActivity.class;
                        break;
                    default:
                        break;
                }
                _launcher.navigateToPage(HomeNavigation.this, _targetActivity);
            }
        });
    }


    public void onNavigateToSettingPage(View view) {
        _launcher.navigateToPage(HomeNavigation.this, AppSettingActivity.class);
    }
}