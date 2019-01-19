package com.sunyjams.domain.model.req;

import com.sunyjams.domain.config.APIConfig;
import com.sunyjams.domain.http.HttpRequest;
import com.sunyjams.domain.http.api.MovieService;
import com.sunyjams.domain.model.resp.Theater;
import com.sunyjams.domain.model.resp.TheatersEntity;
import com.sunyjams.domain.sys.log.MyLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James
 * Date 2019/1/19.
 * description
 */

public class TheaterRequest {

    public interface TheaterListener{
        void theaters(TheatersEntity entity);
    }

    public static void theaterByLocation(final String city, final int start, final int count, final String udid, final TheaterListener listener){
        HttpRequest httpRequest = new HttpRequest<TheatersEntity>() {

            @Override
            public Map<String, Object> createJson() {
                Map<String, Object> map = new HashMap<>();
                map.put("apikey", APIConfig.API_KEY);
                map.put("city", city);
                map.put("start", start);
                map.put("count", count);
                map.put("udid", udid);
                return map;
            }

            @Override
            protected void onSuccess(TheatersEntity o) {
                if(listener != null && !o.getSubjects().isEmpty()){
                    if (!o.getSubjects().isEmpty()){
                        listener.theaters(o);
                    }else{
                        listener.theaters(null);
                    }
                }
            }

            @Override
            protected void onFail(int code, String msg) {
                if(listener != null){
                    listener.theaters(null);
                }
            }
        };
        httpRequest.get(MovieService.class, "getInTheaters");
    }
}
