package com.readyidu.source.local.guangdong.qingyuan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.guangdong.qingyuan.source.GdtvSource;
import com.readyidu.source.local.guangdong.qingyuan.source.Qingyuan0763FSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Qingyuan2Channel extends Channel {

    private static final String CHANNEL_ID = "qingyuan2";

    public Qingyuan2Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new GdtvSource(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        source = new Qingyuan0763FSource(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        return null;
    }
}
