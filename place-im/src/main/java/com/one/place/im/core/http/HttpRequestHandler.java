package com.one.place.im.core.http;

import com.one.place.im.core.exception.ImException;

public interface HttpRequestHandler {
  /**
   *
   * @param packet
   * @param requestLine
   * @return
   * @throws ImException
   * @author wchao
   */
   HttpResponse handler(HttpRequest packet, RequestLine requestLine) throws ImException;

  /**
   *
   * @param request
   * @param requestLine
   * @return
   * @author wchao
   */
   HttpResponse resp404(HttpRequest request, RequestLine requestLine);

  /**
   *
   * @param request
   * @param requestLine
   * @param throwable
   * @return
   * @author wchao
   */
   HttpResponse resp500(HttpRequest request, RequestLine requestLine, Throwable throwable);

  /**
   * 清空静态资源缓存，如果没有缓存，可以不处理
   * @param request
   * @author: wchao
   */
   void clearStaticResCache(HttpRequest request);
}
