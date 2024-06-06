<template>
  <div id="hisory-booking">
    <h2>历史预约</h2>

    <template>
      <el-table
        :data="bookings"
        height="400"
        border
        style="width: 100%"
        :default-sort="{ prop: 'rId', order: 'ascending' }"
      >
        <el-table-column prop="rId" sortable label="预约编号">
        </el-table-column>
        <el-table-column prop="buildingId" label="楼栋ID"> </el-table-column>
        <el-table-column prop="studyroomId" label="房间ID"> </el-table-column
        ><el-table-column prop="seatId" label="座位ID"> </el-table-column>
        <el-table-column prop="timet" label="预约时间"> </el-table-column>
        <el-table-column
          prop="isCheckin"
          label="是否签到"
          :filters="[
            { text: '已签到', value: true },
            { text: '未签到', value: false },
          ]"
          :filter-method="filterMethod"
          filter-placement="bottom-end"
        >
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.isCheckin ? 'primary' : 'success'"
              close-transition
            >
              {{ scope.row.isCheckin ? "已签到" : "未签到" }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template scope="scope">
            <el-button
              size="small"
              type="primary"
              :disabled="!scope.row.isCheckin === false"
              @click="cancelBooking(scope.row)"
              >删除预约</el-button
            >

            <el-button
              size="small"
              type="primary"
              :disabled="!scope.row.isCheckin === false"
              @click="checkin(scope.row)"
              >签到</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
import { user_store, meta, booking_store } from "./data.js";
import { getTimeFormat } from "./utils.js";

export default {
  data() {
    return {
      post_data: {
        userId: 1,
      },
      user_store,
      bookings: [],
    };
  },

  created: function () {
    console.log(11111111);
    if (user_store.log_status == 0) {
      alert("请先登录");
      this.$router.push({ name: "index" });
    }
    user_store.userId = this.$cookies.get("userId");
    this.post_data.userId = user_store.userId;

    this.fetchBookingData();
  },

  methods: {
    cancelBooking: function (booking) {
      this.$confirm("此操作将永久删除此预约, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          var url = meta.url + "/reservation/cancel";

          this.$http
            .post(url, {
              userId: this.post_data.userId,
              reservationId: booking.rId,
            })
            .then(
              (response) => {
                console.log(response.body);
                this.$message({
                  type: "success",
                  message: "删除成功!",
                });
              },
              (response) => {}
            );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    checkin: function (booking) {
      booking_store.rId = booking.rId;
      booking_store.seatId = booking.seatId;
      booking_store.timet = booking.timet;
      (booking_store.isCheckin = booking.isCheckin),
        (booking_store.buildingId = booking.buildingId);
      booking_store.studyroomId = booking.studyroomId;
      // booking_store = JSON.parse(JSON.stringify(booking));
      this.$router.push({ name: "checkin" });
    },
    fetchBookingData: function () {
      console.log(111111111);
      this.post_data.userId = parseInt(this.post_data.userId);
      var url = meta.url + "/reservation/query";

      this.$http
        .get(url, {
          params: {
            seatId: "",
            userId: this.post_data.userId,
            isCheckin: "",
            buildingId: "",
            studyroomId: "",
            pageNum: "",
            PageSize: "",
          },
        })
        .then(
          (response) => {
            console.log(response.body);
            this.bookings = [];
            console.log(this.bookings);
            response.body.list.forEach((element) => {
              this.bookings.push({
                rId: element.rId,
                seatId: element.seatId,
                timet: element.startTime.substring(0, 10),

                isCheckin: element.isCheckin,
                buildingId: element.buildingId,
                studyroomId: element.studyroomId,
              });
              console.log(this.bookings);
            });
            console.log(this.bookings);
          },
          (response) => {}
        );
    },
    filterMethod(value, row) {
      return !row.isCheckin === value;
    },
  },
};
</script>
