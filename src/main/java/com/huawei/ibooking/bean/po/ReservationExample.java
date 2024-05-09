package com.huawei.ibooking.bean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservationExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Integer value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andSeatIdIsNull() {
            addCriterion("seat_id is null");
            return (Criteria) this;
        }

        public Criteria andSeatIdIsNotNull() {
            addCriterion("seat_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeatIdEqualTo(Integer value) {
            addCriterion("seat_id =", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdNotEqualTo(Integer value) {
            addCriterion("seat_id <>", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdGreaterThan(Integer value) {
            addCriterion("seat_id >", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seat_id >=", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdLessThan(Integer value) {
            addCriterion("seat_id <", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdLessThanOrEqualTo(Integer value) {
            addCriterion("seat_id <=", value, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdIn(List<Integer> values) {
            addCriterion("seat_id in", values, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdNotIn(List<Integer> values) {
            addCriterion("seat_id not in", values, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdBetween(Integer value1, Integer value2) {
            addCriterion("seat_id between", value1, value2, "seatId");
            return (Criteria) this;
        }

        public Criteria andSeatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seat_id not between", value1, value2, "seatId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsCheckinIsNull() {
            addCriterion("is_checkin is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckinIsNotNull() {
            addCriterion("is_checkin is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckinEqualTo(Boolean value) {
            addCriterion("is_checkin =", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinNotEqualTo(Boolean value) {
            addCriterion("is_checkin <>", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinGreaterThan(Boolean value) {
            addCriterion("is_checkin >", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_checkin >=", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinLessThan(Boolean value) {
            addCriterion("is_checkin <", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinLessThanOrEqualTo(Boolean value) {
            addCriterion("is_checkin <=", value, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinIn(List<Boolean> values) {
            addCriterion("is_checkin in", values, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinNotIn(List<Boolean> values) {
            addCriterion("is_checkin not in", values, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinBetween(Boolean value1, Boolean value2) {
            addCriterion("is_checkin between", value1, value2, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andIsCheckinNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_checkin not between", value1, value2, "isCheckin");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdIsNull() {
            addCriterion("studyroom_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdIsNotNull() {
            addCriterion("studyroom_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdEqualTo(Integer value) {
            addCriterion("studyroom_id =", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdNotEqualTo(Integer value) {
            addCriterion("studyroom_id <>", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdGreaterThan(Integer value) {
            addCriterion("studyroom_id >", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("studyroom_id >=", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdLessThan(Integer value) {
            addCriterion("studyroom_id <", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdLessThanOrEqualTo(Integer value) {
            addCriterion("studyroom_id <=", value, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdIn(List<Integer> values) {
            addCriterion("studyroom_id in", values, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdNotIn(List<Integer> values) {
            addCriterion("studyroom_id not in", values, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdBetween(Integer value1, Integer value2) {
            addCriterion("studyroom_id between", value1, value2, "studyroomId");
            return (Criteria) this;
        }

        public Criteria andStudyroomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("studyroom_id not between", value1, value2, "studyroomId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}