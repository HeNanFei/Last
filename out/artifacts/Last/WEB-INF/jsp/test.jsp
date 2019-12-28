<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/25 0025
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>远程教育考试平台_在线考试</title>
    <link href="../../Last/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../../Last/css/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="../../Last/css/test.css" rel="stylesheet" type="text/css"/>
    <script src="../../Last/js/jquery-3.3.1.min.js"></script>
    <script src="../../Last/js/jquery-1.11.3.min.js"></script>
    <script src="../../Last/js/jquery.easy-pie-chart.js"></script>
    <!--时间js-->
    <script src="../../Last/time/jquery.countdown.js"></script>
    <style>
        .hasBeenAnswer {
            background: #5d9cec;
            color: #fff;
        }

    </style>
</head>

<body>
<div class="main">
    <!--nr start-->
    <div class="test_main">
        <div class="nr_left">
            <div class="test">
                <form action="/Last/question/getquestions" id="formTable" method="post">
                    <div class="test_title">
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
                        </p>
<%--  应急按钮                      --%>
<%--
                        <font><input type="submit" name="test_jiaojuan" value="交卷"></font>
--%>
                        <font><input type="button" id="testButton" name="test_jiaojuan" value="交卷"></font>
                    </div>

                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="totaltitle"></i><span>题，</span><span>合计</span><i
                                    class="content_fs" id="totalscores"></i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul name="titles" id="titles">

                        </ul>
                    </div>




                </form>
            </div>

        </div>
        <div class="nr_right">
            <div class="nr_rt_main">
                <div class="rt_nr1">
                    <div class="rt_nr1_title">
                        <h1>
                            <i class="icon iconfont">&#xe692;</i>答题卡
                        </h1>
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
                        </p>
                    </div>

                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="secondTotal"></i><span>题</span>
                            </p>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="titleList">



                            </ul>
                        </div>
                    </div>



                </div>

            </div>
        </div>
    </div>
    <!--nr end-->
    <div class="foot"></div>
</div>
<script type="text/javascript">
    var some;

    function formUpload(strings){

        $.ajax({
            url:'/Last/question/getformdata',
            data:{strings:strings},
            success:function () {
                window.location.href = "/Last/question/getformdata?strings="+strings;
            },error:function () {
                alert('呵，没答完就交，你怕是想挂科~~');
            }
        })
    }

    $(function () {

        getTotal();



        $('#testButton').click(function () {
            var strings = [];
            var strings2;
            var formData = $('#formTable').serializeArray();

            some = JSON.stringify(formData);
            $.each(formData,function (i,item) {
                strings.push(item.value);

            })
            strings2 = strings.toString();
            formUpload(strings2);
        })


        $.ajax({
            url: '/Last/question/findall',
            dataType: 'json',
            success: function (msg) {
                $.each(msg, function (i, item) {
                    $('#titles').append(' <li id="qu_0_59">\n' +
                        '                                <div class="test_content_nr_tt">\n' +
                        '                                    <i>'+returnInt(i)+'</i><span>('+item.score+')</span><font>"'+item.title+'"（ ）</font><b\n' +
                        '                                        class="icon iconfont">&#xe881;</b>\n' +
                        '                                </div>\n' +
                        '\n' +
                        '                                <div class="test_content_nr_main">\n' +
                        '                                    <ul>\n' +
                        '\n' +
                        '                                        <li class="option">\n' +
                        '\n' +
                        '                                            <input type="radio" class="radioOrCheck" name="answer'+i+'"\n' +
                        '                                                value="A"   id="0_answer_60_option_1"\n' +
                        '                                            />\n' +
                        '\n' +
                        '\n' +
                        '                                            <label for="0_answer_60_option_1">\n' +
                        '                                                A.\n' +
                        '                                                <p class="ue" style="display: inline;">'+item.ca+'</p>\n' +
                        '                                            </label>\n' +
                        '                                        </li>\n' +
                        '\n' +
                        '                                        <li class="option">\n' +
                        '\n' +
                        '                                            <input type="radio" class="radioOrCheck" name="answer'+i+'"\n' +
                        '                                                  value="B"  id="0_answer_60_option_2"\n' +
                        '                                            />\n' +
                        '\n' +
                        '\n' +
                        '                                            <label for="0_answer_60_option_2">\n' +
                        '                                                B.\n' +
                        '                                                <p class="ue" style="display: inline;">'+item.cb+'</p>\n' +
                        '                                            </label>\n' +
                        '                                        </li>\n' +
                        '\n' +
                        '                                        <li class="option">\n' +
                        '\n' +
                        '                                            <input type="radio" class="radioOrCheck" name="answer'+i+'"\n' +
                        '                                                 value="C"   id="0_answer_60_option_44"\n' +
                        '                                            />\n' +
                        '\n' +
                        '\n' +
                        '                                            <label for="0_answer_60_option_2">\n' +
                        '                                                C.\n' +
                        '                                                <p class="ue" style="display: inline;">'+item.cc+'</p>\n' +
                        '                                            </label>\n' +
                        '                                        </li>\n' +
                        '\n' +
                        '                                        <li class="option">\n' +
                        '\n' +
                        '                                            <input type="radio" class="radioOrCheck" name="answer'+i+'"\n' +
                        '                                                  value="D"  id="0_answer_60_option_55"\n' +
                        '                                            />\n' +
                        '\n' +
                        '\n' +
                        '                                            <label for="0_answer_60_option_2">\n' +
                        '                                                D.\n' +
                        '                                                <p class="ue" style="display: inline;">'+item.cd+'</p>\n' +
                        '                                            </label>\n' +
                        '                                        </li>')
                })
            },
            error: function () {
                alert('method is failed');
            }

        })
    })

    function getTotal() {
        $.ajax({
            url:'/Last/question/gettotal',
            success:function (msg) {

                $('#totalscores').append(msg.score);
                $('#totaltitle').append(msg.titles);
                $('#secondTotal').append(msg.titles);
                var t = msg.titles;
                var number = parseInt(t);
                for(var i=0;i<t;i++){
                    $('#titleList').append('<li><a href="#qu_0_0">'+returnInt(i)+'</a></li>');
                }

            }
        })
    }



    function returnInt(i) {

        return i+1;
    }
</script>
<script>
    window.jQuery(function ($) {
        "use strict";

        $('time').countDown({
            with_separators: false
        });
        $('.alt-1').countDown({
            css_class: 'countdown-alt-1'
        });
        $('.alt-2').countDown({
            css_class: 'countdown-alt-2'
        });

    });

    $(function () {

        $('li.option label').click(function () {
        debugger;
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
            // 设置已答题
            if (!cardLi.hasClass('hasBeenAnswer')) {
                cardLi.addClass('hasBeenAnswer');
            }

        });
    });
</script>

<div style="text-align:center;">

</div>

</body>

</html>