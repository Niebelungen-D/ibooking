<template>
  <div id="add_studyRoom">
    <h1>修改座位信息</h1>

    <p>
      <router-link :to="{ name: 'all_seats' }"
        >返回座位信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="editSeat">
      <div class="form-group">
        <label name="studyroomId">自习室ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.studyroomId"
          id="studyroomId"
        />
      </div>

      <div class="form-group">
        <label name="buildingName">楼栋</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="buildingName"
          id="buildingName"
        />
      </div>

      <div class="form-group">
        <label name="studyroomNumber">自习室号</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="studyroomNumber"
          id="studyroomNumber"
        />
      </div>

      <div class="form-group">
        <label name="seatId">座位id</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.seatId"
          id="seatId"
          required
        />
      </div>

      <div class="form-group">
        <label name="seatId">座位号</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.seatNumber"
          id="seatId"
          required
        />
      </div>

      <div class="form-group">
        <label name="hasSocket">是否有插座:</label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio1"
            value="1"
            v-model="post_data.hasSocket"
          />
          有
        </label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio2"
            value="0"
            v-model="post_data.hasSocket"
          />
          无
        </label>
      </div>

      <div class="form-group">
        <button class="btn btn-primary">修改</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import { meta, studyRoom_store, user_store, seat_store } from "./data.js";

export default {
  data() {
    return {
      buildingName: "",
      studyroomNumber: "",
      post_data: {
        studyroomId: 0,
        seatId: 1,
        hasSocket: 2,
        seatNumber: 0,
      },
      notifications: [],
    };
  },
  created: function () {
    if (user_store.userType != "admin") {
      // alert("权限不够");
      // this.$router.push({name:'index'});
    }
    this.post_data.seatId = seat_store.seatId;
    this.post_data.studyroomId = seat_store.studyroomId;
    this.post_data.isBooking = seat_store.isBooking;
    this.post_data.hasSocket = seat_store.hasSocket;
    this.post_data.seatNumber = seat_store.seatNumber;
    console.log("插座插座插座");
    console.log(this.post_data.hasSocket);
    this.buildingName = studyRoom_store.buildingName;
    this.studyroomNumber = studyRoom_store.studyroomNumber;
  },
  methods: {
    editSeat: function () {
      console.log("add seat pos data=", this.post_data);
      var url = meta.url + "/seat/update";
      console.log(url);
      console.log({
        seatId: this.post_data.seatId,
        hasSocket: this.post_data.hasSocket,
        seatNumber: this.post_data.seatNumber,
        studyroomId: this.post_data.studyroomId,
      });
      this.$http
        .post(url, {
          seatId: this.post_data.seatId,
          hasSocket: this.post_data.hasSocket,
          seatNumber: this.post_data.seatNumber,
          studyroomId: this.post_data.studyroomId,
        })
        .then(
          (response) => {
            console.log("add seat response=", response);
            if (response.body.code == 2000) {
              this.notifications.push({
                type: "success",
                message: "座位修改成功",
              });
            } else {
              this.notifications.push({
                type: "danger",
                message: response.body.msg,
              });
            }
          },
          (response) => {
            console.log("???");
            this.notifications.push({
              type: "danger",
              message: "座位修改失败",
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
