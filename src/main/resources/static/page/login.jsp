<!-- login.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js" type="text/javascript"></script>
    <script src="/js/index.js" type="text/javascript"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js" type="text/javascript"></script>
    <link href="/static/css/index.css" rel="external nofollow" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="app">
    <el-input v-model="uname" placeholder="请输入用户名"></el-input>
    <el-input v-model="pwd" placeholder="请输入密码"></el-input>
    <el-button @click="submit" type="primary">登录</el-button>
</div>

<script>
    new Vue({
        el: "#app",
        data: {
            uname: '',
            pwd: ''
        },
        methods: {
            submit: function () {
                // 获取用户名和密码
                var uname = this.uname;
                var pwd = this.pwd;
                // 发送http请求
                axios.get("do-login", {params: {uname: uname, pwd: pwd}})
                    .then(function (response) {
                        if(response.status == 200) {
                            location.href = "/success";
                        } else {
                            location.href = "/error";
                        }
                    })
                    .catch(function (error) {
                        alert("error--" + error);
                    })
            }
        }
    });
</script>
</body>
</html>