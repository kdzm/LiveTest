package com.readyidu.source.local.guangdong.zhaoqing.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class GrtnSource extends Source {

    public GrtnSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_GRTN_ZHAOQING1:
                return HttpUtil.httpGet("http://live.grtn.cn/drm.php?refererurl=http%3A%2F%2Fwww%2Egrtn%2Ecn%2Flive%2Fzhaoqing%2F&hash=e60ed245aa8145167a99a6c09de4e9b9&url=http%3A%2F%2Fdslive%2Egrtn%2Ecn%2Fzqzh%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03");
            default:
                return null;
        }
    }
}
