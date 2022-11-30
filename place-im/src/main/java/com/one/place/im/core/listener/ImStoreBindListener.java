package com.one.place.im.core.listener;

import com.one.place.im.core.context.ImChannelContext;
import com.one.place.im.core.packets.Group;
import com.one.place.im.core.packets.ImUser;

public interface ImStoreBindListener {
  /**
   * 绑定群组后持久化回调该方法
   * @param imChannelContext 通道上下文
   * @param group 绑定群组信息
   * @throws Exception
   */
  void onAfterGroupBind(ImChannelContext imChannelContext, Group group) throws Exception;

  /**
   * 解绑群组后持久化回调该方法
   * @param imChannelContext 通道上下文
   * @param group 解绑群组信息
   * @throws Exception
   */
  void onAfterGroupUnbind(ImChannelContext imChannelContext, Group group) throws Exception;
  /**
   * 绑定用户后持久化回调该方法
   * @param imChannelContext 通道上下文
   * @param user 绑定用户信息
   * @throws Exception
   */
  void onAfterUserBind(ImChannelContext imChannelContext, ImUser user) throws Exception;

  /**
   * 解绑用户后回调该方法
   * @param imChannelContext 通道上下文
   * @param user 解绑用户信息
   * @throws Exception
   */
  void onAfterUserUnbind(ImChannelContext imChannelContext, ImUser user) throws Exception;
}
