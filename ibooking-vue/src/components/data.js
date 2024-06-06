export var user_store = {
  userId: "",
  userName: "",
  userEmail: "",
  userHeadimg: "",
  userRole: "",
  log_status: 0,
  userType: "",
};

export var student_store = {
  userId: "",
  userName: "",
  userPwd: "",
  userEmail: "",
  userRole: "",
  userHeadimg: "",
};

export var studyRoom_store = {
  studyroomId: -1,
  buildingId: "",
  buildingName: "",
  studyroomNumber: "",
  seatId: "",
  seatType: "",
  roomStatus: "",
};

export var booking_store = {
  rId: 0,
  startTime: "",
  endTime: "",
};

export var seat_store = {
  seatId: "",
  studyroomId: "",
  isBooking: false,
  hasSocket: 0,
  seatNumber: 0,
};

export var reservationId = 0;

export var meta = {
  url: "http://111.231.21.144:8090/api/v1",
};
