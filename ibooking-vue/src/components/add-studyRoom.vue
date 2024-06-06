<template>
  <div id="add_studyRoom">
    <h1>添加自习室信息</h1>

    <p>
      <router-link :to="{ name: 'all_studyrooms' }"
        >返回自习室信息列表页面</router-link>
    </p>

    <notification v-bind:notifications="notifications"></notification>

      <div class="form-group">
        <label name="studyroom_buildingId">自习室状态</label>
        <label class="radio-inline">
          <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1" v-model="post_data.roomStatus"> 开放
        </label>
        <label class="radio-inline">
          <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="0" v-model="post_data.roomStatus"> 关闭
        </label>
      </div>

    <form v-on:submit.prevent="addStudyRoom">
      <div class="form-group">
        <label name="studyroom_id">自习室ID</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.studyroomNumber"
          id="studyroom_id"
        />
      </div>



      <div class="form-group">
        <label name="studyroom_buildingId">楼栋ID</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.buildingId"
          id="studyroom_number"
          required
        />
      </div>

      <!-- <div class="form-group">
        <label name="studyRoom_name">自习室信息</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.studyroomNumber"
          id="studyroomNumber"
          required
        />
      </div> -->

      <div class="form-group">
        <button class="btn btn-primary">添加</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import { meta, user_store } from "./data.js"

export default {
  data() {
    return {
      post_data:{
        studyroomNumber:"",
        roomStatus:1,
        buildingId:""
      },
      notifications: [],
    };
  },
  created:function(){
    // if (user_store.userType!="admin"){
    if (1==2){
      alert("权限不够");
      this.$router.push({name:'index'});
    }
  },

  methods: {
    addStudyRoom: function () {
      // this.post_data.studyroomId = parseInt(this.post_data.studyroomId);
      this.post_data.roomStatus = this.post_data.roomStatus
      // this.post_data.roomStatus = 8;
      this.post_data.studyroomNumber = parseInt(this.post_data.studyroomNumber);
      this.post_data.buildingId = parseInt(this.post_data.buildingId);
      var url = meta.url + '/studyroom/insert';
      this.$http
        .post(url, this.post_data, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log("add-studyroom response=", response.body);
            if (response.body.code == 2000){
              this.notifications.push({
                type: "success",
                message: "自习室信息添加成功",
              });
            } else {
              this.notifications.push({
                type: "danger",
                message: "自习室信息添加失败",
              });
            }
          },
          (response) => {
            this.notifications.push({
              type: "danger",
              message: "自习室信息添加失败",
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
