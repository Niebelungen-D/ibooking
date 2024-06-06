<template>
  <div id="edit-student">
    <h1>学生信息 {{ student.userId }} 修改</h1>

    <p>
      <router-link :to="{ name: 'all_students' }"
        >返回学生信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="editStudent">
      <div class="form-group">
        <label name="student_id">用户ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="student.userId"
          id="student_id"
        />
      </div>

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
        <label name="student_headimg">用户密码</label>
        <input
          type="text"
          class="form-control"
          v-model="student.password"
          id="student_headimg"
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
        <button class="btn btn-primary">提交</button>
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

  created: function () {
    this.getStudent();
  },

  methods: {
    getStudent: function () {
      this.student = this.$route.params.stu;
    },

    editStudent: function () {
      var url = meta.url + "/auth/update";
      this.$http
        .post(
          url,
          {
            userId:this.student.userId,
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
            console.log(response.body)
            this.notifications.push({
              type: "success",
              message: "学生信息修改成功",
            });
          },
          (response) => {
            this.notifications.push({
              type: "error",
              message: "学生信息修改失败",
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
