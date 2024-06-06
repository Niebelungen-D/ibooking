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
          <label name="student_email">邮箱</label>
          <input
            type="text"
            class="form-control"
            v-model="post_data.userEmail"
            id="student_email"
            required
          />
        </div>

        <div class="form-group">
          <label name="student_headimg">上传头像</label>
          <input
            type="text"
            class="form-control"
            v-model="post_data.userHeadimg"
            id="student_headimg"
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
            id="password_again"
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
                userPwdAgain:"",
                userEmail:"",
                userHeadimg:""
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
      var url = meta.url + "/auth/register";
      var that = this;
      console.log({
          username:this.post_data.userName,
          password:this.post_data.userPwd,
          userEmail:this.post_data.userEmail,
          userHeadimg:this.post_data.userHeadimg
          })
      this.$http
        .post(url, {
          userName:this.post_data.userName,
          password:this.post_data.userPwd,
          userEmail:this.post_data.userEmail,
          userHeadimg:this.post_data.userHeadimg
          }, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log("register response=", response);
            
            if (response.body.code == "2001"){
              var data = response.body.data;
              this.notifications.push({
                type: 'success',
                message: "注册成功",
              });
              this.$router.push({name:'login'});
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