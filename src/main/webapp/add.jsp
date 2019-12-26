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
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <scrpt src="js/jquery-3.3.1.min.js"></scrpt>
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/Last/question/add">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="title" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>


            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>分类：</label>
                    </div>
                    <div class="field">
                        <select name="type" class="input w50">
                            <option value="恶趣味选择">恶趣味选择</option>
                            <option value="语文">语文</option>
                            <option value="数学">数学</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>答案：</label>
                    </div>
                    <div class="field" style="padding-top:8px;">
                        A <input id="ishome"  name="answer" type="checkbox" value="A"/>
                        B <input id="isvouch" name="answer" type="checkbox" value="B" />
                        C <input id="istop" name="answer" type="checkbox" value="C"/>
                        C <input id="istop" name="answer" type="checkbox" value="D"/>
                    </div>
                </div>
            </if>
            <div class="form-group">
                <div class="label">
                    <label>选项A：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="ca" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>选项：B</label>
                </div>
                <div class="field">
                    <textarea class="input" name="cb" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>选项C：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="cc" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>选项D：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="cd" style=" height:90px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>分数：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="score" style=" height:90px;"></textarea>
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
</script>
</body></html>
