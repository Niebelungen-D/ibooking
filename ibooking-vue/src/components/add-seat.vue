<template>
  <div id="add_studyRoom">
    <h1>添加座位信息</h1>

    <p>
      <router-link :to="{ name: 'all_seats' }"
        >返回座位信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="addSeat">
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
        <label name="studyroomNumber">自习室信息</label>
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
          v-model="post_data.seatId"
          id="seatId"
          required
        />
      </div>

      <div class="form-group">
        <label name="havSocket">是否有插座:</label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio1"
            value="1"
            v-model="post_data.havSocket"
          />
          有
        </label>
        <label class="radio-inline">
          <input
            type="radio"
            name="inlineRadioOptions"
            id="inlineRadio2"
            value="0"
            v-model="post_data.havSocket"
          />
          无
        </label>
      </div>

      <div class="form-group">
        <button class="btn btn-primary">添加</button>
      </div>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";
import {meta, studyRoom_store, user_store, seat_store} from './data.js';

export default {
  data() {
    return {
      buildingName:"",
      studyroomNumber:"",
      post_data: {
          studyroomId:0,
          seatId:1,
          havSocket:2
      },
      notifications: [],
    };
  },
  created: function(){
    if (user_store.userType!="admin"){
      // alert("权限不够");
      // this.$router.push({name:'index'});
    }
    this.post_data.studyroomId = studyRoom_store.studyroomId;
    this.buildingName = studyRoom_store.buildingName;
    this.studyroomNumber = studyRoom_store.studyroomNumber;

},
  methods: {
    addSeat: function () {
      this.post_data.studyroomId = parseInt(this.post_data.studyroomId);
      this.post_data.havSocket = parseInt(this.post_data.havSocket);
      this.post_data.seatId = parseInt(this.post_data.seatId);
      console.log("add seat pos data=", this.post_data)
      var url = meta.url + "/seat/insert";
      console.log(url);
      this.$http
        .post(url, {
          studystudyroomId:parseInt(this.post_data.studyroomId),
          hasSocket:parseInt(this.post_data.havSocket)
        })
        .then(
          (response) => {
            console.log("add seat response=", response);
            this.notifications.push({
              type: "success",
              message: "座位添加成功",
            });
          },
          (response) => {
            console.log("???");
            this.notifications.push({
              type: "danger",
              message: "座位添加失败",
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
