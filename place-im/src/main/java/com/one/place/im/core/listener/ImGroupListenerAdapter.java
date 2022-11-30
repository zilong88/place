package com.one.place.im.core.listener;

import com.one.place.im.core.ImConst;
import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.packets.Group;
import org.tio.core.ChannelContext;
import org.tio.core.intf.GroupListener;

public class ImGroupListenerAdapter implements GroupListener, ImConst {
  private ImGroupListener imGroupListener;

  public ImGroupListenerAdapter(ImGroupListener imGroupListener){
    this.imGroupListener = imGroupListener;
  }

  @Override
  public void onAfterBind(ChannelContext channelContext, String group) throws Exception {
    ImChannelContext imChannelContext = (ImChannelContext)channelContext.get(Key.IM_CHANNEL_CONTEXT_KEY);
    imGroupListener.onAfterBind(imChannelContext, Group.newBuilder().groupId(group).build());
  }

  @Override
  public void onAfterUnbind(ChannelContext channelContext, String group) throws Exception {
    ImChannelContext imChannelContext = (ImChannelContext)channelContext.get(Key.IM_CHANNEL_CONTEXT_KEY);
    imGroupListener.onAfterUnbind(imChannelContext, Group.newBuilder().groupId(group).build());
  }
}
