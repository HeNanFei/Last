<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24 0024
  Time: 20:13
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
    <link rel="stylesheet" href="../../Last/css/pintuer.css">
    <link rel="stylesheet" href="../../Last/css/admin.css">
    <script src="../../Last/js/jquery.js"></script>
    <script src="../../Last/js/pintuer.js"></script>
    <script src="../../Last/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/Last/question/realupdate">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" id="title" name="title" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>


            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>分类：</label>
                    </div>
                    <div class="field">
                        <select name="cid" class="input w50">
                            <option value="">单选题</option>
                            <option value="">多选题</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>答案：</label>
                    </div>
                    <div class="field" style="padding-top:8px;">
                        A <input id="A"  type="radio" />
                        B <input id="B"  type="radio" />
                        C <input id="C"  type="radio" />
                        D <input id="D"  type="radio" />
                    </div>
                </div>
            </if>
            <div class="form-group">
                <div class="label">
                    <label>选项A：</label>
                </div>
                <div class="field">
                    <textarea class="input" id="ca" name="ca" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>选项：B</label>
                </div>
                <div class="field">
                    <textarea class="input" id="cb" name="cb" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>选项C：</label>
                </div>
                <div class="field">
                    <textarea class="input" id="cc" name="cc" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>选项D：</label>
                </div>
                <div class="field">
                    <textarea class="input" id="cd" name="cd" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>分数：</label>
                </div>
                <div class="field">
                    <textarea class="input" id="score" name="score" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>

        </form>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:'/Last/question/return',
            success:function (msg) {

                $('#ca').val(msg.ca);
                $('#cb').val(msg.cb);
                $('#cc').val(msg.cc);
                $('#cd').val(msg.cd);
                $('#score').val(msg.score);
                $('#title').val(msg.title);
                if (msg.answer=='A'){
                    $('#A').attr('checked',true);
                }
                if (msg.answer=='B'){
                    $('#B').attr('checked',true);
                }
                if (msg.answer=='C'){
                    $('#C').attr('checked',true);
                }if (msg.answer=='D'){
                    $('#D').attr('checked',true);
                }

            }

        })
    })

</script>
</body></html>
