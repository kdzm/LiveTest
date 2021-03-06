package com.readyidu.source.local.shanghai.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class StvSource extends Source {

    private static final String CACHE_NAME = "source_";


    public StvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String stv = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        switch (sourceId) {
            case SourceConstants.SOURCE_STV_STV1:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=084_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV2:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=089_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV3:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=090_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV4:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=454_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV5:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=453_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV6:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=092_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV7:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=091_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_STV_STV8:
                stv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=460_" + date, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://live.kankanews.com/huikan/");
                break;
            default:
                break;
        }
        JSONObject stvObject = JSON.parseObject(stv);
        String url = stvObject.getString("live");
        String paras = stvObject.getString("paras");
        if (NullUtil.isNullObject(url) || NullUtil.isNullObject(paras)) {
            return null;
        }
        return url + paras +"-";
    }

}
