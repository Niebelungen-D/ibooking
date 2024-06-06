<template>
  <div id="default-records">
    <h2>用户 {{ user_store.name }} 违约记录</h2>
    <table class="table table-hover">
      <thead>
        <tr>
          <td>预约ID</td>
          <td>楼栋ID</td>
          <td>自习室ID</td>
          <td>座位编号</td>
          <td>预约时间</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="default_record in default_records">
          <td>{{ default_record.rId }}</td>
          <td>{{ default_record.buildingId }}</td>
          <td>{{ default_record.studyroomId }}</td>
          <td>{{ default_record.seatId }}</td>
          <td>{{ default_record.startTime.substring(0, 10) }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { user_store, meta } from "./data.js";
export default {
  data() {
    return {
      user_store,
      post_data: {
        userId: 1,
      },
      default_records: [],
    };
  },

  created: function () {
    if (user_store.log_status == 0) alert("请先登录");
    else {
      this.post_data.userId = user_store.userId;
      console.log("default init=", this.post_data);
      this.fetchDefaultRecords();
    }
  },

  methods: {
    fetchDefaultRecords: function () {
      this.post_data.userId = parseInt(this.post_data.userId);
      var url = meta.url + "/violation/query";
      console.log("default-record=", this.post_data);
      var that = this;
      this.$http.get(url, { params: { userId: user_store.userId } }).then(
        (response) => {
          console.log(response.body);
          // if (response.body.code == 2000) {
          this.default_records = response.body.list;
          // }
        },
        (response) => {}
      );
    },
  },
};
</script>
