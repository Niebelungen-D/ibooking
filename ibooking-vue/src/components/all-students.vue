<template>
  <div id="all_students">
    <h1>学生管理</h1>

    <p>
      <router-link :to="{ name: 'add_student' }" class="btn btn-primary"
        >添加学生信息</router-link
      >
    </p>

    <div class="form-group">
      <input
        type="text"
        name="search"
        v-model="studentSearch"
        placeholder="Search Students"
        class="form-control"
        v-on:keyup="searchStudents"
      />
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <td>用户ID</td>
          <td>用户名</td>
          <td>用户邮箱</td>
          <td>用户头像</td>
          <td>操作</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="student in students">
          <td>{{ student.userId }}</td>
          <td>{{ student.userName }}</td>
          <td>{{ student.userEmail }}</td>
          <td>{{ student.userHeadimg }}</td>
          <td>
            <router-link
              :to="{ name: 'edit_student', params: { stu: student } }"
              class="btn btn-primary"
              >修改</router-link
            >
            <button @click="deleteStudents(student)" class="btn btn-danger">
              删除
            </button>
            <!-- <router-link
              :to="{ name: 'delete_student', params: { stu: student } }"
              class="btn btn-danger"
              >删除</router-link
            > -->
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { user_store, studyRoom_store, meta, seat_store } from "./data.js";
export default {
  data() {
    return {
      students: [],
      originalStudents: [],
      studentSearch: "",
    };
  },

  created: function () {
    this.fetchStudentData();
  },

  methods: {
    fetchStudentData: function () {
      var url = meta.url + "/auth/query";
      var that = this;
      this.$http.get(url, { params: {} }).then(
        (response) => {
          console.log(response.body);
          that.students = response.body.list;
          that.originalStudents = that.students;
        },
        (response) => {}
      );
    },

    searchStudents: function () {
      if (this.studentSearch == "") {
        this.students = this.originalStudents;
        return;
      }

      var searchedStudents = [];
      for (var i = 0; i < this.originalStudents.length; i++) {
        var studentName = this.originalStudents[i]["userName"].toLowerCase();
        if (studentName.indexOf(this.studentSearch.toLowerCase()) >= 0) {
          searchedStudents.push(this.originalStudents[i]);
        }
      }

      this.students = searchedStudents;
    },

    deleteStudents: function (student) {
      this.$confirm("此操作将永久删除此学生信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          var url = meta.url + "/auth/delete";
          console.log(url);
          this.$http
            .post(url, {
              userId: student.userId,
            })
            .then(
              (response) => {
                console.log(response.body);
                this.$message({
                  type: "success",
                  message: "删除成功!",
                });
              },
              (response) => {
                console.log(response)
              }
            );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>
