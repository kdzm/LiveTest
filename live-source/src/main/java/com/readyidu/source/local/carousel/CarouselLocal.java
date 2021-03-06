package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by BNDYH on 2017/8/16.
 */
public class CarouselLocal extends Local{
    public CarouselLocal(){
        managerId = "carousel";
        Channel channel1 = new CarouselChannels();
        Channel channel2 = new LeCarousel();
        Channel channel3 = new WtvCarouseChannels();
        Channel channel4 = new YichengCarouselChannels();
        Channel channel5 = new CarouselSelfChannel();
        channels = new HashMap<>();
        channels.put(channel1.getId(),channel1);
        channels.put(channel2.getId(),channel2);
        channels.put(channel3.getId(),channel3);
        channels.put(channel4.getId(),channel4);
        channels.put(channel5.getId(),channel5);
    }
    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
