package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.CNTVSource;
import com.readyidu.source.local.cctv.source.Shiting5Source;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * 2017/6/15
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class CCTVShitingChannels extends Channel {

    public CCTVShitingChannels() {
        channelId = "cctv_shiting";
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new Shiting5Source(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
