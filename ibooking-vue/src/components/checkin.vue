<template>
  <div id="Checkin">
    <h1>签到</h1>
    <notification v-bind:notifications="notifications"></notification>
    <form v-on:submit.prevent="checkin_seat">
      <div class="form-group">
        <label name="checkTime">当前时间</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.checkTime"
          id="checkTime"
          required
          disabled
        />
      </div>
      <div class="form-group">
        <label name="rId">预约编号</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="post_data.reservationId"
          id="rId"
          required
        />
      </div>
      <div class="form-group">
        <button class="btn btn-primary">签到</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import { user_store, meta, booking_store } from "./data.js";
import { getDateFormat } from "./utils.js";

export default {
  data() {
    return {
      post_data: {
        checkTime: "2023/05/08 19:35:00",
        reservationId: "0",
        userId: 1,
      },
      notifications: [],
    };
  },
  props: {},
  created: function () {
    if (user_store.log_status == 0) {
      alert("请先登录");
      this.$router.push({ name: "index" });
    }
    user_store.userId = this.$cookies.get("userId");
    this.post_data.checkTime = getDateFormat();

    this.post_data.userId = user_store.userId;

    this.post_data.reservationId = booking_store.rId;
  },

  methods: {
    checkin_seat: function () {
      var url = meta.url + "/check/signin";
      console.log({
        userId: this.post_data.userId,
        reservationId: this.post_data.reservationId,
      });
      this.$http
        .post(url, {
          userId: this.post_data.userId,
          reservationId: this.post_data.reservationId,
        })
        .then(
          (response) => {
            console.log("add seat response=", response);
            if (response.body.code == 2000) {
              this.notifications.push({
                type: "success",
                message: "签到成功",
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
              message: "签到失败",
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
