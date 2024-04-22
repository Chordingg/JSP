# JSP(Java Server Pages) <br>

#### : 동적 웹 페이지를 생성하기 위한 기술로, HTML 안에 Java 코드를 삽입하여 웹 애플리케이션을 개발하는 기술입니다. 
#### JSP 파일은 웹 서버에서 Java Servlet으로 변환되어 실행되며, 서블릿과 유사한 방식으로 동작합니다. <br><br>

---

* ### JSP 작동 원리 :
  * #### 클라이언트 요청 : 사용자가 웹 브라우저를 통해 특정 JSP 페이지를 요청합니다.
    
  * #### 서버 처리 : 웹 서버는 요청된 JSP 페이지를 서블릿으로 변환합니다. 이 변환은 자바 컴파일러에 의해 수행됩니다.

  * #### 서블릿 실행 : 변환된 서블릿은 서블릿 컨테이너에 의해 실행됩니다.
 
  * #### HTML 생성 : 서블릿은 Java 코드를 실행하여 동적으로 HTML을 생성합니다.

  * ####  클라이언트 응답 : 생성된 HTML이 클라이언트로 전송되어 브라우저에 표시됩니다.<br><br>
 
---
 
    
* ### JSP의 주요 특징 :
  * #### 동적 콘텐츠 생성 : JSP를 사용하면 동적으로 HTML 콘텐츠를 생성할 수 있습니다. <br> 이를 통해 사용자에게 동적으로 변하는 콘텐츠를 제공할 수 있습니다.

  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>동적 콘텐츠 생성 예제</title>
  </head>
  <body>
      <h1>현재 시간</h1>
      <% java.util.Date now = new java.util.Date(); %>
      <p>현재 시간은 <%= now %></p>
  </body>
  </html>
  ```

  * #### 코드 삽입 : JSP 파일 안에는 HTML 코드뿐만 아니라 Java 코드도 삽입할 수 있습니다.<br> 이를 통해 데이터베이스 조회, 조건문, 반복문 등을 사용하여 동적 콘텐츠를 생성할 수 있습니다.

  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>코드 삽입 예제</title>
  </head>
  <body>
      <% int number = 10; %>
      <p>10 이상의 숫자 출력: 
          <% if (number > 10) { %>
              <%= number %>
          <% } else { %>
              10 미만입니다.
          <% } %>
      </p>
  </body>
  </html>
  ```

  * #### 재사용성 : JSP는 서블릿으로 변환되어 실행되므로 서블릿과 동일한 재사용성을 가집니다.<br> 따라서 JSP에서 작성한 코드는 다른 JSP나 서블릿에서 재사용할 수 있습니다.

  #### [include.jsp]
  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>Include 예제</title>
  </head>
  <body>
      <h1>이것은 include된 JSP 파일입니다.</h1>
      <p>여기에는 어떤 내용이든 들어갈 수 있습니다.</p>
  </body>
  </html>
  ```
  #### [main.jsp]

  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>Include를 통한 재사용성 예제</title>
  </head>
  <body>
      <h1>Include 예제</h1>
      <%@ include file="include.jsp" %>
  </body>
  </html>
  ```
  

  * #### 커스텀 태그 : JSP에서는 커스텀 태그를 사용하여 자주 사용되는 기능을 재사용할 수 있습니다.<br> 이를 통해 코드의 가독성을 높이고 유지보수를 쉽게 할 수 있습니다.

  #### [CustomTag.jsp]
  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="my" uri="/WEB-INF/custom-tag.tld" %>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>커스텀 태그 예제</title>
  </head>
  <body>
      <h1>커스텀 태그 예제</h1>
      <my:greet />
  </body>
  </html>
  ```
  
  #### [custom-tag.tld]
  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <taglib xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_1.xsd" version="2.1">
      <tlib-version>1.0</tlib-version>
      <short-name>custom</short-name>
      <uri>/WEB-INF/custom-tag.tld</uri>
      <tag>
          <name>greet</name>
          <tag-class>com.example.GreetTag</tag-class>
          <body-content>empty</body-content>
      </tag>
  </taglib>
  ```

  #### [GreetTag.java]
  ```
  package com.example;
  
  import javax.servlet.jsp.tagext.SimpleTagSupport;
  import java.io.IOException;
  
  public class GreetTag extends SimpleTagSupport {
      public void doTag() throws IOException {
          getJspContext().getOut().write("안녕하세요!");
      }
  }
  ```


  * #### 스크립트릿 : JSP 파일 안에는 <% %> 태그를 사용하여 자바 코드를 삽입할 수 있습니다.<br> 이를 통해 복잡한 로직을 구현할 수 있습니다.

  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>스크립트릿 예제</title>
  </head>
  <body>
      <% 
          String name = "John";
          out.println("<h1>Hello, " + name + "!</h1>");
      %>
  </body>
  </html>
  ```

  * #### 태그 라이브러리 : JSP에서는 자체적으로 태그 라이브러리를 사용하여 UI 컴포넌트를 개발할 수 있습니다.<br> 이를 통해 코드의 재사용성을 높이고 개발 시간을 단축할 수 있습니다.
 
  #### [ListTag.jsp]
  ```
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="my" uri="/WEB-INF/list-tag.tld" %>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>태그 라이브러리 예제</title>
  </head>
  <body>
      <h1>태그 라이브러리 예제</h1>
      <my:list>
          <my:item>항목 1</my:item>
          <my:item>항목 2</my:item>
          <my:item>항목 3</my:item>
      </my:list>
  </body>
  </html>
  ```

  #### [list-tag.tld]
  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <taglib xmlns="http://java.sun.com/xml/ns/javaee"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_3_0.xsd"
          version="3.0">
      <tlib-version>1.0</tlib-version>
      <short-name>list</short-name>
      <uri>/WEB-INF/list-tag.tld</uri>
  
      <tag>
          <name>list</name>
          <tag-class>com.example.ListTag</tag-class>
          <body-content>scriptless</body-content>
      </tag>
  
      <tag>
          <name>item</name>
          <tag-class>com.example.ItemTag</tag-class>
          <body-content>scriptless</body-content>
          <variable>
              <name-given>item</name-given>
              <variable-class>java.lang.String</variable-class>
              <declare>true</declare>
          </variable>
      </tag>
  </taglib>
  ```

  #### [ListTag.java]
  ```
  package com.example;
  
  import javax.servlet.jsp.JspException;
  import javax.servlet.jsp.tagext.SimpleTagSupport;
  import java.io.IOException;
  
  public class ListTag extends SimpleTagSupport {
      public void doTag() throws JspException, IOException {
          getJspContext().getOut().write("<ul>");
          getJspBody().invoke(null);
          getJspContext().getOut().write("</ul>");
      }
  }
  ```

  #### [ItemTag.java]
  ```
  package com.example;
  
  import javax.servlet.jsp.JspException;
  import javax.servlet.jsp.tagext.SimpleTagSupport;
  import java.io.IOException;
  
  public class ItemTag extends SimpleTagSupport {
      private String item;
  
      public void setItem(String item) {
          this.item = item;
      }
  
      public void doTag() throws JspException, IOException {
          getJspContext().getOut().write("<li>" + item + "</li>");
      }
  }  
  ```

---
    
