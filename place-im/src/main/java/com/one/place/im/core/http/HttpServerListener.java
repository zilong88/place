package com.one.place.im.core.http;

public interface HttpServerListener {
  /**
   * 在执行org.tio.http.server.handler.IHttpRequestHandler.handler(HttpRequestPacket, RequestLine, ChannelContext<HttpSessionContext, HttpPacket, Object>)后会调用此方法，业务层可以统一在这里给HttpResponsePacket作一些修饰
   * @param packet
   * @param requestLine
   * @param httpResponse
   * @return
   * @throws Exception
   * @author wchao
   */
   void doAfterHandler(HttpRequest packet, RequestLine requestLine, HttpResponse httpResponse) throws Exception;

  /**
   * 在执行org.tio.http.server.handler.IHttpRequestHandler.handler(HttpRequestPacket, RequestLine, ChannelContext<HttpSessionContext, HttpPacket, Object>)前会先调用这个方法<br>
   * 如果返回了HttpResponsePacket对象，则后续都不再执行，表示调用栈就此结束<br>
   * @param packet
   * @param requestLine
   * @param httpResponseFromCache 从缓存中获取到的HttpResponse对象
   * @return
   * @throws Exception
   * @author wchao
   */
   HttpResponse doBeforeHandler(HttpRequest packet, RequestLine requestLine, HttpResponse httpResponseFromCache) throws Exception;
}
