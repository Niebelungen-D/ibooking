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
        </div>
      </form>
    </div>
</template>

<script>

import Notification from "./notifications.vue";

import { user_store, meta } from "./data.js"

export default {
    data(){
        return {
            post_data:{
                userName:"",
                userPwd:"",
            },
            notifications:[]
        }
    },
    methods: {
    login: function () {
      var url = meta.url + "/api/login";
      var that = this;
      this.$http
        .post(url, this.post_data, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log("login response=", response);
            if (response.body.status == true){
              var data = response.body.data;
              if (data.userPermission == "user"){
                user_store.userType = 'student';
              }
              else{
                user_store.userType = 'admin';
              }
              user_store.id = data.userId;
              user_store.name = that.post_data.userName;
              user_store.password = that.post_data.userPwd;
              this.notifications.push({
                type: 'success',
                message: "登录成功",
              });
              //console.log("headers=", response.headers);
              that.$cookies.set("id", user_store.id);
              that.$cookies.set("userName", that.post_data.userName);
              that.$cookies.set("userType", user_store.userType);
              user_store.log_status = 1;
              this.$router.push({name:'index'});
            }
            else{
              var msg = response.body.msg;
              this.notifications.push({type: "danger", message:msg});
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