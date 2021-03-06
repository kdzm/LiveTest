package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.FjtvSource;
import com.readyidu.source.local.stv.source.Shiting5Source;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class HaixiaStvChannel extends Channel {

    private static final String CHANNEL_ID = "haixiastv";

    public HaixiaStvChannel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new FjtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
