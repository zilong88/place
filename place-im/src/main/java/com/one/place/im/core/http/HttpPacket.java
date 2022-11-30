package com.one.place.im.core.http;

import com.one.place.im.core.ImPacket;
import java.util.HashMap;
import java.util.Map;

public class HttpPacket extends ImPacket {

  private static final long serialVersionUID = 6210675954496916510L;
  //	public static final int MAX_LENGTH_OF_BODY = (int) (1024 * 1024 * 5.1); //只支持多少M数据

  /**
   * @param args
   */
  public static void main(String[] args) {

  }
  private String headerString;

  protected Map<String, String> headers = new HashMap<>();

  public HttpPacket() {

  }

  public void addHeader(String key, String value) {
    headers.put(key, value);
  }

  public void addHeaders(Map<String, String> headers) {
    if (headers != null) {
      this.headers.putAll(headers);
    }
  }

  public String getHeader(String key) {
    return headers.get(key);
  }

  /**
   * @return the headers
   */
  public Map<String, String> getHeaders() {
    return headers;
  }

  public String getHeaderString() {
    return headerString;
  }

  public void removeHeader(String key, String value) {
    headers.remove(key);
  }

  /**
   * @param headers the headers to set
   */
  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public void setHeaderString(String headerString) {
    this.headerString = headerString;
  }
}
