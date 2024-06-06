<template>
  <div id="all_studyrooms">
    <h1>自习室管理</h1>

    <!-- <p> -->
    <p v-if="userType == 'admin'">
      <router-link :to="{ name: 'add_studyroom' }" class="btn btn-primary"
        >添加自习室</router-link
      >
    </p>

    <div class="form-group">
      <input
        type="text"
        name="search"
        v-model="studyRoomSearch"
        placeholder="Search Study Room"
        class="form-control"
        v-on:keyup="searchStudyRooms"
      />
    </div>

    <!-- <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>楼栋信息</td>
          <td>自习室信息</td>
          <td>开闭状态</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="studyRoom in studyRooms">
          <td>{{ studyRoom.studyroomId }}</td>
          <td>{{ studyRoom.buildingName }}</td>
          <td>{{ studyRoom.studyroomNumber }}</td>
          <td v-if="studyRoom.roomStatus == 0">关闭</td>
          <td v-if="studyRoom.roomStatus == 1">
            开放
            <button class="btn btn-primary" @click="searchSeat(studyRoom)">
              查看座位
            </button>
          </td> -->
    <!-- <template v-if="userType == 'admin'"> -->
    <!-- <template>
            <button class="btn btn-primary" @click="editStudyRoom(studyRoom)">
              修改
            </button> -->
    <!-- <button class="btn btn-danger" @click="deleteStudyRoom(studyRoom)">删除</button> -->
    <!-- </template>
        </tr>
      </tbody>
    </table> -->

    <template>
      <el-table
        :data="studyRooms"
        height="400"
        border
        style="width: 100%"
        :default-sort="{ prop: 'studyroomId', order: 'ascending' }"
      >
        <el-table-column prop="studyroomId" sortable label="ID">
        </el-table-column>
        <el-table-column
          prop="buildingId"
          label="楼栋编号"
          :filters="buildingIdFilters"
          :filter-method="filterBuildingId"
          filter-placement="bottom-end"
        >
        </el-table-column>
        <el-table-column prop="studyroomNumber" label="自习室房间号">
        </el-table-column>
        <el-table-column
          prop="roomStatus"
          label="开闭状态"
          :filters="[
            { text: '开放', value: true },
            { text: '关闭', value: false },
          ]"
          :filter-method="filterMethod"
          filter-placement="bottom-end"
        >
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.roomStatus ? 'primary' : 'success'"
              close-transition
            >
              {{ scope.row.roomStatus ? "开放" : "关闭" }}
            </el-tag>
          </template>
        </el-table-column>

        <el-table-column label="操作">
          <template scope="scope">
            <el-button
              size="small"
              type="primary"
              :disabled="scope.row.roomStatus === false"
              @click="searchSeat(scope.row)"
              >查看座位</el-button
            >
            <el-button
              v-if="userType === 'admin'"
              size="small"
              type="success"
              @click="editStudyRoom(scope.row)"
              >修改</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
import { studyRoom_store, meta, user_store } from "./data.js";

export default {
  data() {
    return {
      studyRooms: [],
      originalStudyRooms: [],
      studyRoomsSearch: "",
      userType: "",
      buildingIdFilters: [],
    };
  },

  created: function () {
    this.userType = user_store.userType;
    console.log(this.userType);
    this.fetchStudyRoom();
  },

  methods: {
    // 查看座位功能跳转
    searchSeat: function (studyRoom) {
      studyRoom_store.studyroomId = studyRoom.studyroomId;
      studyRoom_store.buildingId = studyRoom.buildingId;
      studyRoom_store.buildingName = studyRoom.buildingName;
      studyRoom_store.studyroomNumber = studyRoom.studyroomNumber;
      this.$router.push({ name: "all_seats" });
    },
    // 修改座位
    editStudyRoom: function (studyRoom) {
      studyRoom_store.studyroomId = studyRoom.studyroomId;
      studyRoom_store.roomStatus = studyRoom.roomStatus;
      studyRoom_store.buildingId = studyRoom.buildingId;
      studyRoom_store.buildingName = studyRoom.buildingName;
      studyRoom_store.studyroomNumber = studyRoom.studyroomNumber;
      this.$router.push({ name: "edit_studyroom" });
    },
    // deleteStudyRoom: function (studyRoom) {
    //   studyRoom_store.studyroomId = studyRoom.studyroomId;
    //   studyRoom_store.roomStatus = studyRoom.roomStatus;
    //   studyRoom_store.buildingId = studyRoom.buildingId;
    //   studyRoom_store.buildingName = studyRoom.buildingName;
    //   studyRoom_store.studyroomNumber = studyRoom.studyroomNumber;
    //   this.$router.push({ name: "delete_studyroom" });
    // },
    fetchStudyRoom: function () {
      var url = meta.url + "/studyroom/query";
      var that = this;
      console.log(url);
      this.$http
        .get(url, {
          params: {
            roomStatus: "",
            studyroomNumber: "",
            buildingId: "",
            pageNum: "1",
            pageSize: "100",
            sort: "studyroom_number DESC",
          },
        })
        .then(
          (response) => {
            //this.studyRooms = response.body;
            console.log(response.body.data);
            var data = response.body.data;
            console.log("all_studyrooms=", data);
            that.studyRooms = [];
            let tmpbuildingIdFilters = new Set();
            for (var i = 0; i < data.list.length; ++i) {
              that.studyRooms.push({
                studyroomId: data.list[i].studyroomId,
                studyroomNumber: data.list[i].studyroomNumber,
                buildingName: data.list[i].buildingId,
                buildingId: data.list[i].buildingId,
                roomStatus: data.list[i].roomStatus,
              });
              tmpbuildingIdFilters.add(data.list[i].buildingId);
            }
            console.log(tmpbuildingIdFilters);
            const sortedArray1 = Array.from(tmpbuildingIdFilters).sort(
              (a, b) => {
                if (a < b) return -1; // 如果要按从小到大排序，则改为 a > b 返回 1
                if (a > b) return 1; // 如果要按从小到大排序，则改为 a < b 返回 -1
                return 0;
              }
            );
            sortedArray1.forEach((item) => {
              this.buildingIdFilters.push({
                text: item,
                value: item,
              });
            });
            this.originalStudyRooms = this.studyRooms;
            console.log(this.studyRooms);
          },
          (response) => {}
        );
    },
    searchStudyRooms: function () {
      if (this.studyRoomSearch == "") {
        this.studyRooms = this.originalStudyRooms;
        return;
      }
      var searchedStudyRooms = [];
      for (var i = 0; i < this.originalStudyRooms.length; i++) {
        var studyroomNumber = this.originalStudyRooms[i]["studyroomNumber"]
          .toString()
          .toLowerCase();
        if (studyroomNumber.indexOf(this.studyRoomSearch.toLowerCase()) >= 0) {
          searchedStudyRooms.push(this.originalStudyRooms[i]);
        }
      }

      this.studyRooms = searchedStudyRooms;
    },
    filterMethod(value, row) {
      return row.roomStatus === value;
    },
    filterBuildingId(value, row) {
      // 返回该行数据的楼栋编号是否匹配筛选值
      return row.buildingId === value;
    },
  },
};
</script>
