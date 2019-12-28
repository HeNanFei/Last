<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/25 0025
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> </strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
                    <button type="button" id="updateQuestion" class="button border-red"><span class="icon-trash-o"></span>修改</button>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center" id="domain">
            <tr>
                <th width="120">ID</th>
                <th>题目</th>
                <th>选项A</th>
                <th>选项B</th>
                <th>选项C</th>
                <th width="25%">选项D</th>
                <th width="120">类型</th>
                <th>操作</th>
            </tr>

           <%-- <tr>
                <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
            </tr>--%>
        </table>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:'/Last/question/getall',
            success:function (msg) {

                $.each(msg,function (i,item) {

                   $('#domain').append('<tr>\n' +
                       '          <td><input type="checkbox" name="tid" value="'+item.tid+'" />\n' +
                       '            '+item.tid+'</td>\n' +
                       '          <td>'+item.title+'</td>\n' +
                       '          <td>'+item.ca+'</td>\n' +
                       '          <td>'+item.cb+'</td>  \n' +
                       '           <td>'+item.cc+'</td>         \n' +
                       '          <td>'+item.cd+'</td>\n' +
                       '          <td>'+item.type+'</td>\n' +
                       '          <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del('+item.tid+')"><span class="icon-trash-o"></span> 删除</a> </div></td>\n' +

                           '          <td><div class="button-group"> <a class="button border-red" href="/Last/question/update?id='+item.tid+'" ><span class="icon-trash-o"></span> 修改</a> </div></td>\n' +
                       '        </tr>');
                })
            }

        })
    })


    function del(id){
        if(confirm("您确定要删除吗?")){


            $.ajax({
                url:'/Last/question/delete',
                data:{id:id},
                success:function (msg) {
                    alert(msg);
                },error:function () {
                  alert('删除成功');
                }

            })
            window.location.reload();
        }
    }




    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body></html>