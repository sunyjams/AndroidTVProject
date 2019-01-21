package com.sunyjams.domain.model.req;

import com.sunyjams.domain.config.APIConfig;
import com.sunyjams.domain.http.HttpRequest;
import com.sunyjams.domain.http.api.MovieService;
import com.sunyjams.domain.model.resp.MovieIntro;
import com.sunyjams.domain.model.resp.TheatersEntity;

import java.util.HashMap;
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

    public interface MovieListener{
        void movie(MovieIntro movie);
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
                if(listener != null){
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

    public static void movieInfo(String id, final String city, final String udid, final MovieListener listener){
        HttpRequest httpRequest = new HttpRequest<MovieIntro>() {

            @Override
            public Map<String, Object> createJson() {
                Map<String, Object> map = new HashMap<>();
                map.put("apikey", APIConfig.API_KEY);
                map.put("city", city);
                map.put("udid", udid);
                return map;
            }

            @Override
            protected void onSuccess(MovieIntro o) {
                if(listener != null){
                    if(o != null){
                        listener.movie(o);
                    }else{
                        listener.movie(null);
                    }
                }
            }

            @Override
            protected void onFail(int code, String msg) {
                if(listener != null){
                    listener.movie(null);
                }
            }
        };
        httpRequest.get(MovieService.class, "getMovieInfo", id);
    }
}
