package com.sunyjams.domain.http.api;

import com.sunyjams.domain.config.APIConfig;
import com.sunyjams.domain.model.resp.TheatersEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by James
 * Date 2019/1/18.
 * description
 */
public interface MovieService {

    @GET(APIConfig.CONST.IN_THREATERS)
    Observable<TheatersEntity> getInTheaters(@QueryMap Map<String, Object> map);
}
