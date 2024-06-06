<template>
  <div id="app">
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button
            type="button"
            class="navbar-toggle collapsed"
            data-toggle="collapse"
            data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false"
          >
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <router-link to="/" class="navbar-brand"
            >自习室签到预约系统</router-link
          >
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><router-link to="/">首页</router-link></li>
            <li>
              <router-link
                v-if="user_store.userType === 'admin'"
                to="/all_students"
                >学生管理</router-link
              >
            </li>
            <li><router-link to="/all_studyrooms">自习室查看</router-link></li>
            <li><router-link v-if="user_store.userType === 'student' "  to="/history_booking">历史预约</router-link></li>
            <li><router-link v-if="user_store.userType === 'student' "  to="/default_records">违约记录</router-link></li>
            <li><router-link v-if="user_store.userType === 'student' "  to="/checkin" >签到</router-link></li>

          </ul>
          <ul class="nav navbar-nav navbar-right">
            <template v-if="user_store.log_status == 0">
              <li><router-link to="/login">登录</router-link></li>
              <li><router-link to="/register">注册</router-link></li>
            </template>
            <template v-if="user_store.log_status == 1">
              <p class="navbar-text">用户{{ user_store.name }}</p>
              <button class="btn btn-danger navbar-btn" @click="logout()">
                登出
              </button>
            </template>
          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>

    <div class="container">
      <router-view></router-view>
    </div>
  </div>
</template>

<style>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter,
.fade-leave-active {
  opacity: 0;
}
#app {
  margin-top: 25px;
}
.container {
  margin-top: 25px;
}
</style>

<script>
import { user_store } from "./components/data.js";

export default {
  name: "app",
  data() {
    return {
      user_store,
    };
  },
  created: function () {
    user_store.userId = this.$cookies.get("userId");
    user_store.userType = this.$cookies.get("userType");
    user_store.name = this.$cookies.get("userName");
    console.log(user_store.userId);
    if (user_store.userId != "" && user_store.userId != null) {
      user_store.log_status = 1;
    }
    console.log("log_status=", user_store.log_status);
  },
  methods: {
    logout: function () {
      user_store.userId = "";
      user_store.userType = "";
      user_store.name = "";
      this.$cookies.remove("userId");
      this.$cookies.remove("userType");
      this.$cookies.remove("userName");
      user_store.log_status = 0;
    },
  },
};
</script>
