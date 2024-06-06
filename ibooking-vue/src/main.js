import Vue from 'vue'

import VueRouter from 'vue-router'
Vue.use(VueRouter)

import VueResource from 'vue-resource';
Vue.use(VueResource);

import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);
const Index = require('./components/index.vue')

const AllStudents = require('./components/all-students.vue');
const AddStudent = require('./components/add-student.vue');
const EditStudent = require('./components/edit-student.vue');
const DeleteStudent = require('./components/delete-student.vue');

const AllStudyRooms = require('./components/all-studyrooms.vue');
const AddStudyRoom = require('./components/add-studyRoom.vue');
const EditStudyRoom = require('./components/edit-studyRoom.vue');
const Login = require('./components/login.vue');
const Register = require('./components/register.vue');

const HistoryBooking = require("./components/history-booking.vue");
// const CancelBooking = require("./components/cancel-booking.vue");
// const UpdateBooking = require("./components/update_booking.vue");
const DefaultRecords = require("./components/default-records.vue")

const AddSeat = require('./components/add-seat.vue');
const EditSeat = require('./components/edit-seat.vue');

const Booking = require('./components/booking.vue');

const AllSeats = require('./components/all-seats.vue');

const Checkin = require('./components/checkin.vue');

const routes = [
    {
        name: 'index',
        path: '/',
        component: Index,
    },
    {
        name: 'login',
        path: '/login',
        component: Login
    },
    {
        name: 'register',
        path: '/register',
        component: Register
    },
    {
        name: 'all_students',
        path: '/all_students',
        component: AllStudents
    },
    {
        name: 'add_student',
        path: '/student/add-student',
        component: AddStudent
    },
    {
        name: 'edit_student',
        path: '/student/edit/:stu',
        component: EditStudent
    },
    {
        name: 'delete_student',
        path: '/student/delete/:stu',
        component: DeleteStudent
    },
    {
        name: 'all_studyrooms',
        path: '/all_studyrooms',
        component: AllStudyRooms
    },
    {
        name: 'add_studyroom',
        path: '/studyroom/add',
        component: AddStudyRoom
    },
    {
        name: 'edit_studyroom',
        path: '/studyroom/edit',
        component: EditStudyRoom
    },
    {
        name: 'history_booking',
        path: '/history_booking',
        component: HistoryBooking
    },
    // {
    //     name: 'update_booking',
    //     path: '/update_booking',
    //     component: UpdateBooking
    // },
    // {
    //     name: 'cancel_booking',
    //     path: '/cancel_booking',
    //     component: CancelBooking
    // },
    {
        name: 'default_records',
        path: '/default_records',
        component: DefaultRecords
    },
    {
        name: 'booking',
        path: '/booking',
        component: Booking
    },
    {
        name: 'all_seats',
        path: '/seat',
        component: AllSeats,
    },
    {
        name: 'add_seat',
        path: '/seat/add',
        component: AddSeat
    },
    {
        name: 'checkin',
        path: '/checkin',
        component: Checkin
    },
    {
        name: 'edit_seat',
        path: '/seat/edit',
        component: EditSeat
    }
];
var router = new VueRouter({ routes: routes, mode: 'history' });
new Vue(Vue.util.extend({ router }, App)).$mount('#app');