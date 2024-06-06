<template>
  <div id="login">
    <h1>登录</h1>
    <notification v-bind:notifications="notifications"></notification>
    <form v-on:submit.prevent="login">
      <div class="form-group">
        <label name="student_name">姓名</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.userName"
          id="student_name"
          required
        />
      </div>

      <div class="form-group">
        <label name="password">密码</label>
        <input
          type="password"
          class="form-control"
          v-model="post_data.userPwd"
          id="password"
          required
        />
      </div>

      <div class="form-group">
        <button class="btn btn-primary">登录</button>
        <router-link to="/register" class="btn btn-primary">注册</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import Vue from "vue";
import VueCookies from "vue-cookies";

Vue.use(VueCookies);
import { user_store, meta } from "./data.js";

export default {
  data() {
    return {
      post_data: {
        userName: "",
        userPwd: "",
      },
      notifications: [],
    };
  },
  methods: {
    login: function () {
      var url = meta.url + "/auth/login";
      var that = this;
      console.log({
        username: this.post_data.userName,
        password: this.post_data.userPwd,
      });
      this.$http
        .post(
          url,
          {
            userName: this.post_data.userName,
            password: this.post_data.userPwd,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then(
          (response) => {
            console.log("login response=", response);
            if (response.body.code == "2000") {
              var data = response.body.data;
              if (data.userRole == 1) {
                user_store.userType = "admin";
              } else {
                user_store.userType = "student";
              }
              user_store.userId = data.userId;
              user_store.name = that.post_data.userName;
              user_store.password = that.post_data.userPwd;
              user_store.email = data.userEmail;
              this.notifications.push({
                type: "success",
                message: "登录成功",
              });
              console.log(user_store)
              that.$cookies.set("userId", user_store.userId);
              that.$cookies.set("email", user_store.email);
              that.$cookies.set("userName", that.post_data.userName);
              that.$cookies.set("userType", user_store.userType);
              user_store.log_status = 1;
              this.$router.push({ name: "index" });
            } else {
              var msg = response.body.msg;
              this.notifications.push({ type: "danger", message: msg });
            }
          },
          (response) => {
            this.notifications.push({
              type: "danger",
              message: "登录失败",
            });
          }
        );
    },
  },

  components: {
    notification: Notification,
  },
};
</script>
