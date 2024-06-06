<template>
  <div id="booking">
    <h1>预约</h1>
    <notification v-bind:notifications="notifications"></notification>
    <form v-on:submit.prevent="booking_seat">
      <div class="form-group">
        <label name="student_number">ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.studentId"
          id="student_number"
          required
        />
      </div>

      <div class="form-group">
        <label name="studyroom_id">自习室ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.studyroomId"
          id="studyroom_id"
          required
        />
      </div>
      <div class="form-group">
        <label name="buildingId">楼栋ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.buildingId"
          id="buildingId"
          required
        />
      </div>

      <div class="form-group">
        <label name="seatId">座位ID</label>
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
        <label name="time">开始时间</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.startTime"
          id="time"
          placeholder="yyyy/mm/dd HH:00:00"
          required
        />
      </div>

      <div class="form-group">
        <label name="time">结束时间</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.endTime"
          id="time"
          placeholder="yyyy/mm/dd HH:00:00"
          required
        />
      </div>

      <div class="form-group">
        <button class="btn btn-primary">添加</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import HistoryBooking from "./history-booking.vue";
import { user_store, studyRoom_store, meta } from "./data.js";
import { checkTimeFormat } from "./utils.js";

export default {
  data() {
    return {
      post_data: {
        studentId: 0,
        studyroomId: 0,
        buildingId: 0,
        seatId: 0,
        startTime: "",
        endTime: "",
      },
      buildingName: "",
      studyroomNumber: "",
      notifications: [],
      user_store,
    };
  },
  created: function () {
    if (user_store.log_status == 0) {
      alert("请先登录");
      this.$router.push({ name: "index" });
    }
    user_store.userId = this.$cookies.get("userId");
    this.post_data.studentId = user_store.userId;
    this.post_data.studyroomId = studyRoom_store.studyroomId;
    this.post_data.buildingId = studyRoom_store.buildingId;
    this.post_data.seatId = studyRoom_store.seatId;
    console.log(this.post_data);
  },

  methods: {
    booking_seat: function () {
      this.post_data.studentId = parseInt(this.post_data.studentId);
      this.post_data.buildingId = parseInt(this.post_data.buildingId);
      this.post_data.studyroomId = parseInt(this.post_data.studyroomId);
      this.post_data.seatId = parseInt(this.post_data.seatId);
      if (!checkTimeFormat(this.post_data.startTime)) {
        alert("开始时间格式错误");
        return;
      }
      if (!checkTimeFormat(this.post_data.endTime)) {
        alert("结束时间格式错误");
        return;
      }
      if (this.post_data.startTime > this.post_data.endTime) {
        alert("时间错误");
        return;
      }
      console.log("booking seat:", this.post_data);

      var url = meta.url + "/api/reserve/makeReservations";
      this.$http
        .post(url, this.post_data, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            console.log(response.body);
            var status = response.body.status;
            if (status == true) {
              this.notifications.push({
                type: "success",
                message: response.body.msg,
              });
              this.$router.push({ name: "history_booking" });
            } else {
              this.notifications.push({
                type: "danger",
                message: response.body.msg,
              });
            }
          },
          (response) => {
            this.notifications.push({
              type: "danger",
              message: "预约失败",
            });
          }
        );
    },
  },

  components: {
    notification: Notification,
    historybooking: HistoryBooking,
  },
};
</script>
