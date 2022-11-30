package com.one.place.im.core.cluster;

import com.one.place.im.config.ImClusterConfig;

public abstract class ImCluster implements Cluster{
  /**
   * IM集群配置
   */
  protected ImClusterConfig clusterConfig;

  public ImCluster(ImClusterConfig clusterConfig){
    this.clusterConfig = clusterConfig;
  }
  public ImClusterConfig getClusterConfig() {
    return clusterConfig;
  }
}
