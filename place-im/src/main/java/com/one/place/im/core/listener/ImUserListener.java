package com.one.place.im.core.listener;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.packets.ImUser;

public interface ImUserListener {
  /**
   * 绑定用户后回调该方法
   * @param imChannelContext IM通道上下文
   * @param user 绑定用户信息
   * @throws Exception
   */
  void onAfterBind(ImChannelContext imChannelContext, ImUser user) throws Exception;

  /**
   * 解绑用户后回调该方法
   * @param imChannelContext IM通道上下文
   * @param user 解绑用户信息
   * @throws Exception
   */
  void onAfterUnbind(ImChannelContext imChannelContext, ImUser user) throws Exception;
}
