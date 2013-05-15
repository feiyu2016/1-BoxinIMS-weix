package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class treeselect_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", com.thinkgem.jeesite.common.config.Global.class, "getAdminPath", new Class[] {});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getCache", com.thinkgem.jeesite.modules.sys.utils.UserUtils.class, "getCache", new Class[] {java.lang.String.class, java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/include/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/shiros.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fns.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fnc.tld");
  }

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String id;
  private java.lang.String name;
  private java.lang.String value;
  private java.lang.String labelName;
  private java.lang.String labelValue;
  private java.lang.String title;
  private java.lang.String url;
  private java.lang.Boolean checked;
  private java.lang.String extId;
  private java.lang.Boolean notAllowSelectRoot;
  private java.lang.Boolean notAllowSelectParent;
  private java.lang.String module;
  private java.lang.Boolean selectScopeModule;
  private java.lang.String cssClass;
  private java.lang.String cssStyle;

  public java.lang.String getId() {
    return this.id;
  }

  public void setId(java.lang.String id) {
    this.id = id;
    jspContext.setAttribute("id", id);
  }

  public java.lang.String getName() {
    return this.name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
    jspContext.setAttribute("name", name);
  }

  public java.lang.String getValue() {
    return this.value;
  }

  public void setValue(java.lang.String value) {
    this.value = value;
    jspContext.setAttribute("value", value);
  }

  public java.lang.String getLabelName() {
    return this.labelName;
  }

  public void setLabelName(java.lang.String labelName) {
    this.labelName = labelName;
    jspContext.setAttribute("labelName", labelName);
  }

  public java.lang.String getLabelValue() {
    return this.labelValue;
  }

  public void setLabelValue(java.lang.String labelValue) {
    this.labelValue = labelValue;
    jspContext.setAttribute("labelValue", labelValue);
  }

  public java.lang.String getTitle() {
    return this.title;
  }

  public void setTitle(java.lang.String title) {
    this.title = title;
    jspContext.setAttribute("title", title);
  }

  public java.lang.String getUrl() {
    return this.url;
  }

  public void setUrl(java.lang.String url) {
    this.url = url;
    jspContext.setAttribute("url", url);
  }

  public java.lang.Boolean getChecked() {
    return this.checked;
  }

  public void setChecked(java.lang.Boolean checked) {
    this.checked = checked;
    jspContext.setAttribute("checked", checked);
  }

  public java.lang.String getExtId() {
    return this.extId;
  }

  public void setExtId(java.lang.String extId) {
    this.extId = extId;
    jspContext.setAttribute("extId", extId);
  }

  public java.lang.Boolean getNotAllowSelectRoot() {
    return this.notAllowSelectRoot;
  }

  public void setNotAllowSelectRoot(java.lang.Boolean notAllowSelectRoot) {
    this.notAllowSelectRoot = notAllowSelectRoot;
    jspContext.setAttribute("notAllowSelectRoot", notAllowSelectRoot);
  }

  public java.lang.Boolean getNotAllowSelectParent() {
    return this.notAllowSelectParent;
  }

  public void setNotAllowSelectParent(java.lang.Boolean notAllowSelectParent) {
    this.notAllowSelectParent = notAllowSelectParent;
    jspContext.setAttribute("notAllowSelectParent", notAllowSelectParent);
  }

  public java.lang.String getModule() {
    return this.module;
  }

  public void setModule(java.lang.String module) {
    this.module = module;
    jspContext.setAttribute("module", module);
  }

  public java.lang.Boolean getSelectScopeModule() {
    return this.selectScopeModule;
  }

  public void setSelectScopeModule(java.lang.Boolean selectScopeModule) {
    this.selectScopeModule = selectScopeModule;
    jspContext.setAttribute("selectScopeModule", selectScopeModule);
  }

  public java.lang.String getCssClass() {
    return this.cssClass;
  }

  public void setCssClass(java.lang.String cssClass) {
    this.cssClass = cssClass;
    jspContext.setAttribute("cssClass", cssClass);
  }

  public java.lang.String getCssStyle() {
    return this.cssStyle;
  }

  public void setCssStyle(java.lang.String cssStyle) {
    this.cssStyle = cssStyle;
    jspContext.setAttribute("cssStyle", cssStyle);
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  private void _jspInit(ServletConfig config) {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) config.getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(JspContext.class,jspContext);
    if( getId() != null ) 
      _jspx_page_context.setAttribute("id", getId());
    if( getName() != null ) 
      _jspx_page_context.setAttribute("name", getName());
    if( getValue() != null ) 
      _jspx_page_context.setAttribute("value", getValue());
    if( getLabelName() != null ) 
      _jspx_page_context.setAttribute("labelName", getLabelName());
    if( getLabelValue() != null ) 
      _jspx_page_context.setAttribute("labelValue", getLabelValue());
    if( getTitle() != null ) 
      _jspx_page_context.setAttribute("title", getTitle());
    if( getUrl() != null ) 
      _jspx_page_context.setAttribute("url", getUrl());
    if( getChecked() != null ) 
      _jspx_page_context.setAttribute("checked", getChecked());
    if( getExtId() != null ) 
      _jspx_page_context.setAttribute("extId", getExtId());
    if( getNotAllowSelectRoot() != null ) 
      _jspx_page_context.setAttribute("notAllowSelectRoot", getNotAllowSelectRoot());
    if( getNotAllowSelectParent() != null ) 
      _jspx_page_context.setAttribute("notAllowSelectParent", getNotAllowSelectParent());
    if( getModule() != null ) 
      _jspx_page_context.setAttribute("module", getModule());
    if( getSelectScopeModule() != null ) 
      _jspx_page_context.setAttribute("selectScopeModule", getSelectScopeModule());
    if( getCssClass() != null ) 
      _jspx_page_context.setAttribute("cssClass", getCssClass());
    if( getCssStyle() != null ) 
      _jspx_page_context.setAttribute("cssStyle", getCssStyle());

    try {
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"input-append\">\n");
      out.write("\t<input id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Id\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cssClass}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${value}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"/>\n");
      out.write("\t<input id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Name\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${labelName}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" readonly=\"readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${labelValue}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" maxlength=\"50\"\n");
      out.write("\t\tclass=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cssClass}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" style=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cssStyle}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"/><a id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Button\" href=\"javascript:\" class=\"btn\">选择</a>&nbsp;&nbsp;\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(\"#");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Button\").click(function(){\n");
      out.write("\t\ttop.$.jBox.open(\"iframe:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("/tag/treeselect?url=\"+encodeURIComponent(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\")+\"&module=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("&checked=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checked}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("&extId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${extId}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("&selectIds=\"+$(\"#");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Id\").val(), \"选择");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\", 300, 420, {\n");
      out.write("\t\t\tbuttons:{\"确定\":\"ok\", \"关闭\":true}, submit:function(v, h, f){\n");
      out.write("\t\t\t\tif (v==\"ok\"){\n");
      out.write("\t\t\t\t\tvar tree = h.find(\"iframe\")[0].contentWindow.tree;//h.find(\"iframe\").contents();\n");
      out.write("\t\t\t\t\tvar ids = [], names = [], nodes = [];\n");
      out.write("\t\t\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checked}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" == \"true\"){\n");
      out.write("\t\t\t\t\t\tnodes = tree.getCheckedNodes(true);\n");
      out.write("\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\tnodes = tree.getSelectedNodes();\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\tfor(var i=0; i<nodes.length; i++) {\n");
      out.write("\t\t\t\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${checked}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" == \"true\" && nodes[i].isParent){\n");
      out.write("\t\t\t\t\t\t\tcontinue; // 如果为复选框选择，则过滤掉父节点\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notAllowSelectRoot}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" == \"true\" && nodes[i].level == 0){\n");
      out.write("\t\t\t\t\t\t\ttop.$.jBox.tip(\"不能选择根节点（\"+nodes[i].name+\"）请重新选择。\");\n");
      out.write("\t\t\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notAllowSelectParent}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" == \"true\" && nodes[i].isParent){\n");
      out.write("\t\t\t\t\t\t\ttop.$.jBox.tip(\"不能选择父节点（\"+nodes[i].name+\"）请重新选择。\");\n");
      out.write("\t\t\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\tif (\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" != \"\" && \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${selectScopeModule}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\" == \"true\"){\n");
      out.write("\t\t\t\t\t\t\tif (nodes[i].module == \"\"){\n");
      out.write("\t\t\t\t\t\t\t\ttop.$.jBox.tip(\"不能选择公共模型（\"+nodes[i].name+\"）请重新选择。\");\n");
      out.write("\t\t\t\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t\t\t\t}else if (nodes[i].module != \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"){\n");
      out.write("\t\t\t\t\t\t\t\ttop.$.jBox.tip(\"不能选择当前栏目以外的栏目模型，请重新选择。\");\n");
      out.write("\t\t\t\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\tids.push(nodes[i].id);\n");
      out.write("\t\t\t\t\t\tnames.push(nodes[i].name);\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t$(\"#");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Id\").val(ids);\n");
      out.write("\t\t\t\t\t$(\"#");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("Name\").val(names);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}, loaded:function(h){\n");
      out.write("\t\t\t\t$(\".jbox-content\", top.document).css(\"overflow-y\",\"hidden\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      jspContext.getELContext().putContext(JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
      _jspDestroy();
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/views/include/taglib.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/include/taglib.jsp(9,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}${fns:getAdminPath()}", java.lang.Object.class, (PageContext)this.getJspContext(), _jspx_fnmap_0, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/views/include/taglib.jsp(10,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("ctxStatic");
    // /WEB-INF/views/include/taglib.jsp(10,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}/static", java.lang.Object.class, (PageContext)this.getJspContext(), null, false));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));    // /WEB-INF/views/include/taglib.jsp(11,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("ctxTheme");
    // /WEB-INF/views/include/taglib.jsp(11,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fns:getCache('theme', theme)}", java.lang.Object.class, (PageContext)this.getJspContext(), _jspx_fnmap_1, false));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }
}
