/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-10-27 13:42:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Title</title>\n");
      out.write("    <script src=\"js/jquery-3.4.1.js\"></script>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#button01\").click(\n");
      out.write("                function () {\n");
      out.write("                    $.ajax({\n");
      out.write("                        // json\n");
      out.write("                        url:\"request/testAjax\",\n");
      out.write("                        contentType:\"application/json;charset=UTF-8\",\n");
      out.write("                        data:'{\"name\":\"zrx\",\"age\":20}',\n");
      out.write("                        dataType:\"json\",\n");
      out.write("                        type:\"POST\",\n");
      out.write("                        success:function (data) {\n");
      out.write("                            $(\"#div01\").html(data);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            );\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h3>入门程序</h3>\n");
      out.write("<a href=\"hello\">入门</a><br/>\n");
      out.write("<a href=\"getparams\">拿到请求参数</a><br/>\n");
      out.write("<form action=\"getparams\" method=\"post\">\n");
      out.write("    username:<input type=\"text\" name=\"username\"><br/>\n");
      out.write("    password:<input type=\"password\" name=\"password\"><br/>\n");
      out.write("    birthday:<input type=\"text\" name=\"birthday\"><br/>\n");
      out.write("    <input type=\"submit\" name=\"submit\">\n");
      out.write("</form>\n");
      out.write("<br>\n");
      out.write("<a href=\"rest/get/233\">入门</a><br/>\n");
      out.write("<br>\n");
      out.write("<a href=\"request/returnString\">返回字符串</a><br/>\n");
      out.write("<br>\n");
      out.write("<a href=\"request/returnVoid\">返回void</a><br/>\n");
      out.write("</body>\n");
      out.write("<a href=\"request/returnModelAndView\">返回ModelAndView</a><br/>\n");
      out.write("<hr/>\n");
      out.write("<button id=\"button01\">发送ajax异步请求</button>\n");
      out.write("<div id=\"div01\"></div>\n");
      out.write("<hr>\n");
      out.write("<form action=\"file/test3\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("    选择文件<input type=\"file\" name=\"upload21\">\n");
      out.write("    <input type=\"submit\" value=\"上传\">\n");
      out.write("</form>\n");
      out.write("<hr>\n");
      out.write("<a href=\"exception/test1\">异常学习</a>\n");
      out.write("<hr>\n");
      out.write("<a href=\"interceptor/test01\">拦截器学习</a>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}