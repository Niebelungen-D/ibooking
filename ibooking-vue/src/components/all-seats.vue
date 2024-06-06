<template>
  <div id="all_seats">
    <h1>自习室 {{ post_data.studyroomId }} 座位预约情况</h1>

    <p>
      <router-link :to="{ name: 'all_studyrooms' }"
        >返回自习室列表页面</router-link
      >
    </p>

    <p v-if="userType == 'admin'">
      <!-- <p> -->
      <router-link :to="{ name: 'add_seat' }" class="btn btn-primary"
        >添加座位</router-link
      >
    </p>

    <form v-on:submit.prevent="AllSeat">
      <div class="form-group">
        <label name="day_id">日期</label>
        <input
          type="text"
          class="form-control"
          v-model="post_data.day"
          id="day_id"
        />
      </div>

      <div class="form-group">
        <label name="buildingName">楼栋信息</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="buildingName"
          id="buildingName"
          required
        />
      </div>

      <div class="form-group">
        <label name="studyroomNumber">自习室信息</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="studyroomNumber"
          id="studyroomNumber"
          required
        />
      </div>

      <div class="form-group">
        <button class="btn btn-primary">提交</button>
      </div>
    </form>

    <template>
      <el-table :data="seats" height="400" border style="width: 100%">
        <el-table-column prop="seatId" sortable label="座位ID">
        </el-table-column>
        <el-table-column prop="seatNumber" label="座位号"> </el-table-column>
        <el-table-column prop="hasSocket" label="有无插座"> </el-table-column>
        <el-table-column
          prop="isBooking"
          label="是否可预约"
          :filters="[
            { text: '是', value: true },
            { text: '否', value: false },
          ]"
          :filter-method="filterMethod"
          filter-placement="bottom-end"
        >
          <template slot-scope="scope">
            <el-tag
              :type="!scope.row.isBooking ? 'primary' : 'success'"
              close-transition
            >
              {{ !scope.row.isBooking ? "是" : "否" }}
            </el-tag>
          </template>
        </el-table-column>

        <el-table-column label="操作" width="200">
          <template scope="scope">
            <el-button
              size="small"
              type="primary"
              :disabled="!scope.row.isBooking === false"
              @click="booking(scope.row)"
              >预约</el-button
            >

            <el-button
              v-if="user_store.userType === 'admin'"
              size="small"
              type="primary"
              @click="editSeat(scope.row)"
              >修改</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>
<script>
import Notification from "./notifications.vue";
import { user_store, studyRoom_store, meta, seat_store } from "./data.js";
import { getDateFormat } from "./utils.js";

export default {
  data() {
    return {
      times: [],
      user_store,
      buildingName: 0,
      post_data: {
        day: "2023/04/04",
        buildingId: 0,
        studyroomId: 0,
      },
      studyroomNumber: "",
      seats: [],
      notifications: [],
    };
  },
  created: function () {
    this.userType = user_store.userType;
    if (user_store.log_status == 0) {
      alert("请先登录");
      this.$router.push({ name: "index" });
    }
    // console.log(user_store)
    user_store.userId = this.$cookies.get("userId");

    for (var i = 0; i < 24; ++i) this.times.push({ start: i, end: i + 1 });
    this.post_data.day = getDateFormat();
    this.buildingName = studyRoom_store.buildingName;
    this.studyroomNumber = studyRoom_store.studyroomNumber;
    this.post_data.buildingId = studyRoom_store.buildingId;
    this.post_data.studyroomId = studyRoom_store.studyroomId;

    // this.AllSeat();
  },

  methods: {

    booking: function (seat) {
      console.log(user_store)
      console.log(seat);
      var url = meta.url + "/reservation/insert";
      console.log("url=", url);
      var that = this;
      console.log({
        startTime: Date.parse(that.post_data.day),
        endTime: Date.parse(that.post_data.day),
        seatId: seat.seatId,
        userId: user_store.userId,
        isCheckin: false,
        buildingId: that.post_data.buildingId,
        studyroomId: that.post_data.studyroomId,
      });
      this.$http
        .post(
          url,
          {
            startTime: Date.parse(that.post_data.day),
            endTime: Date.parse(that.post_data.day),
            seatId: seat.seatId,
            userId: user_store.userId,
            isCheckin: false,
            buildingId: that.post_data.buildingId,
            studyroomId: that.post_data.studyroomId,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then(
          (response) => {
            console.log(response.body);
            var d = response.body.data;
            console.log("all seat response=", d);
            that.seats = d;
            console.log(that.seats);
          },
          (response) => {
            console.log("failed");
          }
        );
    },
    editSeat: function (seat) {
      seat_store.seatId = seat.seatId;
      seat_store.studyroomId = seat.studyroomId;
      seat_store.isBooking = seat.isBooking;
      seat_store.hasSocket = seat.hasSocket;
      seat_store.seatNumber = seat.seatNumber;
      this.$router.push({ name: "edit_seat" });
    },
    deleteSeat: function (seat) {
      studyRoom_store.seatId = seat.seatId;
      studyRoom_store.seatType = seat.seatType;
      this.$router.push({ name: "delete_seat" });
    },

    AllSeat: function () {
      var url = meta.url + "/seat/query";
      console.log("url=", url);
      var that = this;
      this.$http
        .get(
          url,
          {
            params: {
              studyroomId: that.post_data.studyroomId,
              startTime: Date.parse(that.post_data.day),
            },
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then(
          (response) => {
            console.log(response.body);
            var d = response.body.data;
            console.log("all seat response=", d);

            that.seats = d;

            //if (that.seats.length > 0)
            //for (var i = 0; i < that.seats.length; ++i){
            //  var isbooking = that.seats[i].isBooking;
            //  //for (var j = 7; j < 22; ++j)
            //  //  isbooking.push(that.seats[i].isBooking[j]);
            //  that.seats[i].isBooking = isbooking;
            //}
            console.log(that.seats);
          },
          (response) => {
            console.log("failed");
          }
        );
    },
    filterMethod(value, row) {
      return !row.isBooking === value;
    },
  },

  components: {
    notification: Notification,
  },
};
</script>
