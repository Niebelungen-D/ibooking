<template>
    <div id="register">
        <h1>注册</h1>
        <notification v-bind:notifications="notifications"></notification>
        <form v-on:submit.prevent="register">
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
          <label name="password_again">再次输入密码</label>
          <input
            type="password"
            class="form-control"
            v-model="post_data.userPwdAgain"
            id="password"
            required
          />
        </div>
  
        <div class="form-group">
          <button class="btn btn-primary">注册</button>
          <router-link to="/login" class="btn btn-primary">返回登录</router-link>
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
                userPwdAgain:""
            },
            notifications:[]
        }
    },
    methods: {
    register: function () {
      if (this.post_data.userPwdAgain != this.post_data.userPwd){
          this.notifications.push({
            type: "danger",
            message: "两次密码输入不同",
          });
        return
      }
      var url = meta.url + "/api/register";
      var that = this;
      this.$http
        .post(url, {username:this.post_data.userName,password:this.post_data.userPwd}, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log("register response=", response);
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
                message: "注册成功",
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
              message: "注册失败",
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