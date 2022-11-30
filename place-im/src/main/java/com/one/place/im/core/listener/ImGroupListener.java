package com.one.place.im.core.listener;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.packets.Group;

public interface ImGroupListener {
  /**
   * 绑定群组后回调该方法
   * @param imChannelContext IM通道上下文
   * @param group 绑定群组对象
   */
  void onAfterBind(ImChannelContext imChannelContext, Group group) throws Exception;

  /**
   * 解绑群组后回调该方法
   * @param imChannelContext IM通道上下文
   * @param group 绑定群组对象
   */
  void onAfterUnbind(ImChannelContext imChannelContext, Group group) throws Exception;
}
