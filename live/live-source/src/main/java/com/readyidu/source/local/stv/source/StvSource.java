package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class StvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public StvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_STV_STV:
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(new Date());
                    String stvStv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=081_" + date);
                    JSONObject stvObject = JSON.parseObject(stvStv);
                    CacheUtil.set(CACHE_NAME + sourceId, stvObject.getString("live"), CHACHE_TIMEOUT);
                    return stvObject.getString("live");
                default:
                    return null;
            }
        } else {
            return cacheSource;
        }
    }
}
