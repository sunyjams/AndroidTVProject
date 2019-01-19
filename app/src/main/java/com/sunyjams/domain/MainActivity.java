package com.sunyjams.domain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunyjams.domain.config.APIConfig;
import com.sunyjams.domain.http.HttpRequest;
import com.sunyjams.domain.http.api.MovieService;
import com.sunyjams.domain.model.resp.TheatersEntity;
import com.sunyjams.domain.sys.log.MyLog;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private Button actionButton;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = findViewById(R.id.floating_btn);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpRequest httpRequest = new HttpRequest<TheatersEntity>() {

                    @Override
                    public Map<String, Object> createJson() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("apikey", APIConfig.API_KEY);
                        map.put("city", "深圳");
                        map.put("start", 1);
                        map.put("count", 30);
                        map.put("udid", "");
                        return map;
                    }

                    @Override
                    protected void onSuccess(TheatersEntity o) {
                        MyLog.i("", o.toString());
                    }

                    @Override
                    protected void onFail(int code, String msg) {

                    }
                };
                httpRequest.get(MovieService.class, "getInTheaters");
            }
        });
    }
}
