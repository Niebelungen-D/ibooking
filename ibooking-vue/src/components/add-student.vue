<template>
  <div id="add_student">
    <h1>添加学生信息</h1>

    <p>
      <router-link :to="{ name: 'all_students' }"
        >返回学生信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="addStudent">
      <!-- <div class="form-group">
        <label name="student_id">ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="student.id"
          id="student_id"
        />
      </div> -->

      <div class="form-group">
        <label name="student_number">用户名</label>
        <input
          type="text"
          class="form-control"
          v-model="student.userName"
          id="student_number"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_email">用户邮箱</label>
        <input
          type="text"
          class="form-control"
          v-model="student.userEmail"
          id="student_email"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_headimg">用户头像</label>
        <input
          type="text"
          class="form-control"
          v-model="student.userHeadimg"
          id="student_headimg"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_pwd">用户密码</label>
        <input
          type="text"
          class="form-control"
          v-model="student.password"
          id="student_pwd"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_role">用户角色</label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio1"
            value="1"
            v-model="student.userRole"
          />
          管理员
        </label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio2"
            value="0"
            v-model="student.userRole"
          />
          普通用户
        </label>
      </div>

      <div class="form-group">
        <button class="btn btn-primary">添加</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import { user_store, studyRoom_store, meta, seat_store } from "./data.js";
export default {
  data() {
    return {
      student: {},
      notifications: [],
    };
  },

  methods: {
    addStudent: function () {
      var url = meta.url + "/auth/insert";
      this.$http
        .post(
          url,
          {
            userName: this.student.userName,
            userEmail: this.student.userEmail,
            userHeadimg: this.student.userHeadimg,
            password: this.student.password,
            userRole: this.student.userRole,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then(
          (response) => {
            this.notifications.push({
              type: "success",
              message: "学生信息添加成功",
            });
          },
          (response) => {
            this.notifications.push({
              type: "error",
              message: "学生信息添加失败",
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
