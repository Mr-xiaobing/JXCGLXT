<%-- Created by IntelliJ IDEA. --%> <%@ page
        contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>我</title>
  <link rel="stylesheet" type="text/css" href="js/esayUI/themes/default/easyui.css"/>
  <link rel="stylesheet" type="text/css" href="js/esayUI/themes/icon.css" />
  <link rel="stylesheet" type="text/css" href="js/esayUI/themes/color.css" />
</head>
<style>
  * {
    margin: 0px;
    padding: 0px;
  }
  #show_table {
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
  }
  .datagrid {
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    width: 90% !important;
  }
</style>
<body>
<div id="cc" class="easyui-layout" style="height: 100%; width: 100%;">
  <%-- 上半部分 --%>
  <div
          data-options="region:'north',title:'标题',split:true"
          style="height: 100px;"
  >
    <h1 style="text-align: center; line-height: 63px !important;">
      进销存管理系统
    </h1>
  </div>
<%--  &lt;%&ndash; 底层部分 &ndash;%&gt;--%>
<%--  <div--%>
<%--          data-options="region:'south',title:'底层标题',split:true"--%>
<%--          style="height: 100px;"--%>
<%--  ></div>--%>
  <%-- 右边部分 --%>
<%--  <div--%>
<%--          data-options="region:'east',title:'右边菜单栏',split:true"--%>
<%--          style="width: 20%;"--%>
<%--  ></div>--%>
  <%-- 左边部分 --%>
  <div
          data-options="region:'west',title:'左边菜单栏',split:true"
          style="width: 20%;"
  >

    <div class="easyui-accordion" data-options="fit:true,border:false" >
      <%--    用户管理--%>
      <div title="用户管理" style="padding:10px;" style="overflow: auto"   selected="false">
        <a id="btn1" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,"
           onclick="open_menu('用户管理','user-list.html')">用户管理
        </a>
        <br>
        <a id="btn2" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true"
           onclick="open_menu('角色管理','role-list.html')">角色管理
        </a>
      </div>
<%--    采购管理  --%>
      <div title="采购管理"  style="padding:10px;" selected="false">
        <div title="采购管理" style="padding:10px;" style="overflow: auto" >
          <a id="btn3" href="javascript:void(0);" class="easyui-linkbutton"
            data-options="plain:true,"
            onclick="open_menu('用户管理','user-list.html')">订单管理
          </a>
          <br>
          <a id="btn4" href="javascript:void(0);" class="easyui-linkbutton"
            data-options="plain:true"
            onclick="open_menu('角色管理','role-list.html')">订单退款
          </a>
        </div>
      </div>

    </div>
  </div>
  <%-- 中间内容 --%>
  <div
          data-options="region:'center'"
          style="padding: 5px; background: #eee; width: 60%;"
  >
    <div id="mytag" class="easyui-tabs" fit="true" tools="#tab-tools">
      <div title="首页" style="text-align: center;font-size: 20px">
        <%-- 表格 --%>
        <table
                id="mytable"
                class="easyui-datagrid"
                toolbar="#head"
                id="show_table"
                style="width: 60%;"

                url="http://localhost:8080/data/mytable.json"
                pagination="true"
                idField="name"
        >
          <thead>
          <tr>
            <th field="ck" checkbox="true" width="8%"></th>
            <th
                    data-options="field:'name',align:'center',editor:'numberbox'"
                    width="33%"
            >
              Name
            </th>
            <th
                    data-options="field:'password',align:'center' ,editor:'numberbox'"
                    width="30%"
            >
              password
            </th>
            <th data-options="field:'sex',align:'center'  ,editor:'numberbox'" width="31%">
              sex
            </th>
          </tr>
          </thead>
        </table>
        <%-- 一些增删操作 --%>
        <div id="head">
          <a
                  href="#"
                  class="easyui-linkbutton"
                  data-options="iconCls:'icon-add',plain:true"
                  onclick="add_data()"
          >新增</a>
          <a
                  href="#"
                  class="easyui-linkbutton"
                  data-options="iconCls:'icon-edit',plain:true"
                  onclick="update_message()">修改</a>
          <a
                  href="#"
                  class="easyui-linkbutton"
                  data-options="iconCls:'icon-remove',plain:true" onclick="delete_data()">删除</a>
        </div>
        <%-- 弹出框---修改框 --%>
        <div
                class="easyui-dialog"
                id="user_dg1"
                style="width: 400px; height: 400px;"
                closed="true"
                buttons="#user_dlg-buttons"
        >
          <div class="ftitle">修改</div>
          <form id="user_fm" method="post">
            <div class="fitem">
              <label>name：</label>
              <input
                      type="text"
                      name="name"
                      class="easyui-textbox"
                      required="true"
              />
            </div>
            <div class="fitem">
              <label>password：</label>
              <input type="text" name="password" class="easyui-textbox" required="true"/>
            </div>
            <div class="fitem">
              <label>sex：</label>
              <input type="text" name="sex" class="easyui-textbox" required="true"/>
            </div>
          </form>
        </div>
        <%--弹出框 添加框--%>
        <div
                class="easyui-dialog"
                id="user_dg2"
                style="width: 400px; height: 400px;"
                closed="true"
                buttons="#user_dlg-buttons"
        >
          <div class="ftitle">修改</div>
          <form id="user_from" method="post">
            <div class="fitem">
              <label>name：</label>
              <input
                      type="text"
                      name="name"
                      class="easyui-textbox"
                      required="true"
              />
            </div>
            <div class="fitem">
              <label>password：</label>
              <input type="text" name="password" class="easyui-textbox" required="true"/>
            </div>
            <div class="fitem">
              <label>sex：</label>
              <input type="text" name="sex" class="easyui-textbox" required="true"/>
            </div>
          </form>
        </div>
        <%-- 确定与取消按钮--%>
        <div id="user_dlg-buttons">
          <a href="#" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#user_dg').dialog('close')">取消</a>
        </div>
      </div>

    </div>

  </div>
<%--    标签的样式 --%>
  <div id="tab-tools">
      <a href="javascript:void(0)" class="easyui-linkbutton"
         data-options="plain:true,iconCls:'icon-reload'"
         onclick="reload()"></a>
      <a href="javascript:void(0)" class="easyui-linkbutton"
         data-options="plain:true,iconCls:'icon-delete'"
         onclick="closecur()"></a>
  </div>
</div>
</body>
<script type="text/javascript" src="js/esayUI/jquery.min.js"></script>
<script type="text/javascript" src="js/esayUI/jquery.easyui.min.js"></script>
<script>
  // $(function () {
  //   $('#mytable').edatagrid({
  //     url: 'http://localhost:8080/data/mytable.json',
  //   });
  // })

  function update_message() {
    var row = $("#mytable").datagrid("getSelected");
    if (row) {
      $("#user_dg1").dialog("open").dialog("setTitle", "修改用户");
      $("#user_fm").form("load", row);
      console.log("12356");
    }
  }
  //删除值
  function delete_data(){
    var row = $("#mytable").datagrid("getSelected");
  //   直接 打印结果如下    所以可以 直接 获取 对应 的数值
  //   fk      : false
  //   name    : " 小李1 "
  //   password: " 789123 "
  //   sex     : " 男 "
  }
  //添加数据
  function add_data(){
   // var row =$("#mytable").datagrid("getSelected");
   $("#user_dg2").dialog("open").dialog("setTitle","新增用户")
  }
  //  左边的点击
  function open_menu(titleName, menuUrl) {
    if ($("#mytag").tabs("exists", titleName)) {
      $("#mytag").tabs("select", titleName);
    } else {
      $('#mytag').tabs('add', {
        title : titleName,
        href : menuUrl,
        closable : true
      });
    }
  }
</script>
</html>
