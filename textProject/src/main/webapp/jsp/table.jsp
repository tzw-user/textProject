<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../layui/layui.js"></script>
<link rel="stylesheet" href="../layui/css/layui.css">
<title>layuiTable</title>
</head>
<body>
 <div class="layui-body">
    <!-- 内容主体区域 -->
	<table id="table" lay-filter="table"></table>
  </div>
</body>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#table'
    ,height: 315
    ,url: '/Merchant/getMerchants/' //数据接口
    ,cols: [[ //表头
      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'carno', title: '车牌号', width:80}
      ,{field: 'ownername', title: '公司名称', width:80, sort: true}
      ,{field: 'ownerphone', title: '电话', width:80} 
      ,{field: 'devid', title: 'DevId', width: 177}
    ]]
  });
});
</script>
</html>