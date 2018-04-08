<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function jsonValue() {
            var data = {'empNo': 110, 'firstName': 'lan', 'lastName': 'xu'};
            $.ajax({
                       type: "POST",
                       url: "post-test/jsonValue",
                       dataType: "json",
                       //contentType:"application/json", //不能添加这个头
                       data: data //这里不能进行JSON.stringify,发送请求的数据在:form data

                   });
        }

        function json2str() {
            var data = {'empNo': 110, 'firstName': 'lan', 'lastName': 'xu'};
            $.ajax({
                       type: "POST",
                       url: "post-test/json2str",
                       dataType: "json",
                       contentType: "application/json", //需添加这个头
                       data: JSON.stringify(data) //发送请求的数据在request payload
                   });
        }
    </script>
</head>
<body>
<div>
    <div id="connect-container">
        <div>
            <button id="jsonValue" onclick="jsonValue();">传json单值或对象</button>
            <button id="json2str" onclick="json2str();">json对象转成字符串后传值</button>
        </div>
    </div>
</div>

</body>
</html>