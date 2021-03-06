package com.readyidu.source.local.cctv.source;

import com.alibaba.fastjson.JSON;
import com.readyidu.source.base.Source;
import com.readyidu.source.model.CNTV;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.DyMethodUtil;
import com.readyidu.util.HttpUtil;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

/**
 * 2017/6/15
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class CNTVSource extends Source {
    private static final Logger log = LoggerFactory.getLogger(CNTVSource.class);
    public static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static DecimalFormat df = new DecimalFormat("######0");

    public CNTVSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String source = sourceId;

        if (TextUtils.isEmpty(source)) {
            return null;
        }


        // Sources url: http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdcctv2&client=html5
        String javascript = "http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdcctv" + source + "&client=html5";
        String scriptResult = HttpUtil.httpGet(javascript);
        scriptResult = scriptResult.replace("var html5VideoData='", "");
        scriptResult = scriptResult.replace("';getHtml5VideoData(html5VideoData);", "");
        String cha = null;
        try {
            cha = df.format(jse.eval("new Fingerprint2().get(function(result, components){})"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        CNTV cctv = JSON.parseObject(scriptResult, CNTV.class);

        if (cctv.getAck().equals("yes")) {
            for (String value : cctv.getFlv_url().values()) {
                String result = parseURL(value);
                if (result != null) {
                    return result;
                }
            }

            for (String value : cctv.getHds_url().values()) {
                String result = parseURL(value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private String parseURL(String value) {
        try {
            URL url = new URL(value);
            String[] component = url.getPath().split("/");
            if (!component[component.length - 1].contains(".")) {
                log.debug(value);
                return value;
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
