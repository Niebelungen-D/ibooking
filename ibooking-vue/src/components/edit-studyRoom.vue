<template>
  <div id="edit-studyroom">
    <h1>自习室 {{ post_data.studyroomId }} 修改</h1>

    <p>
      <router-link :to="{ name: 'all_studyrooms' }"
        >返回自习室信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="editStudyRoom">
      <div class="form-group">
        <label name="id">自习室ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.studyroomId"
          id="id1"
        />
      </div>
          <div class="form-group">
        <label name="id">楼栋信息</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.buildingId"
          id="id2"
        />
      </div>
      <div class="form-group">
        <label name="studyroom_roomStatus">自习室状态</label>
        <label class="radio-inline">
          <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="true" v-model="post_data.roomStatus"> 开放
        </label>
        <label class="radio-inline">
          <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="false" v-model="post_data.roomStatus"> 关闭
        </label>
      </div>

      <!-- <div class="form-group">
        <label name="buildingId">楼栋ID</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.buildingId"
          id="buildingId"
          required
        />
      </div>

      <div class="form-group">
        <label name="studyroomNumber">自习室信息</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.studyroomNumber"
          id="studyroomNumber"
          required
        />
      </div> -->


      <div class="form-group">
        <button class="btn btn-primary">提交</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import { studyRoom_store, meta } from "./data.js"

export default {
  data() {
    return {
      post_data: {
        id:"",
        roomStatus: 1,
        buildingId: "",
        studyroomNumber: ""
      },
      notifications: [],
    };
  },


  created: function () {
    this.post_data.studyroomId  = studyRoom_store.studyroomId;
    this.post_data.roomStatus  = studyRoom_store.roomStatus;
    this.post_data.buildingId  = studyRoom_store.buildingId;
    this.post_data.studyroomNumber  = studyRoom_store.studyroomNumber;
  },

  methods: {

    editStudyRoom: function () {

      this.post_data.studyroomId  = parseInt(this.post_data.studyroomId);
      // this.post_data.roomStatus  = parseInt(this.post_data.roomStatus);
      // this.post_data.buildingId  = parseInt(this.post_data.buildingId);
      // this.post_data.studyroomNumber  = parseInt(this.post_data.studyroomNumber);
      // console.log("edit study room post data=", this.post_data);
      var url = meta.url + '/studyroom/switch';
      console.log(url);
      console.log({
          studyroomId:this.post_data.studyroomId,
          roomStatus:this.post_data.roomStatus
        })
      this.$http
        .post(url, {
          studyroomId:this.post_data.studyroomId,
          roomStatus:this.post_data.roomStatus
        }, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log(response.data)
            if (response.data.code == 2000){
              this.notifications.push({
                type: "success",
                message: "自习室信息修改成功",
              });
            } else {
              this.notifications.push({
                type: "danger",
                message: "自习室信息修改失败",
              });
            }
          },
          (response) => {
            this.notifications.push({
              type: "danger",
              message: "自习室信息修改失败",
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
