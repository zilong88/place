package com.one.place;

import wiki.xsx.core.pdf.component.layout.XEasyPdfLayoutComponent;
import wiki.xsx.core.pdf.component.layout.XEasyPdfVerticalLayout;
import wiki.xsx.core.pdf.component.text.XEasyPdfText;
import wiki.xsx.core.pdf.doc.XEasyPdfDocument;
import wiki.xsx.core.pdf.doc.XEasyPdfPage;
import wiki.xsx.core.pdf.doc.XEasyPdfPositionStyle;
import wiki.xsx.core.pdf.handler.XEasyPdfHandler;

public class PdfTest {

  public static void main(String[] args) {
    PdfTest test = new PdfTest();
    test.testPdf();
  }

  public void testPdf(){
    XEasyPdfDocument document = XEasyPdfHandler.Document.build();

    XEasyPdfPage page = XEasyPdfHandler.Page.build();
    XEasyPdfText text = XEasyPdfHandler.Text.build("wen");
    text.setHorizontalStyle(XEasyPdfPositionStyle.CENTER);


    // 垂直布局
    XEasyPdfVerticalLayout layout = XEasyPdfHandler.Layout.Vertical.build();
// 布局组件
    XEasyPdfLayoutComponent layoutComponent = XEasyPdfHandler.Layout.Component.build(100, 300);
// 设置组件
    layoutComponent.setComponent(text);
// 添加到垂直布局
    layout.addLayoutComponent(layoutComponent);

   // page.addComponent(layout);
    page.addComponent(text);
    document.addPage(page);
   document.save("/Users/songzilong/Documents/图片/pdf.pdf");
  }
}
