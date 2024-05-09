package com.huawei.ibooking.bean.po;

import java.util.ArrayList;
import java.util.List;

public class StudyroomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudyroomExample() {
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

        public Criteria andRoomStatusIsNull() {
            addCriterion("room_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("room_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(Boolean value) {
            addCriterion("room_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(Boolean value) {
            addCriterion("room_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(Boolean value) {
            addCriterion("room_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("room_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(Boolean value) {
            addCriterion("room_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("room_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<Boolean> values) {
            addCriterion("room_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<Boolean> values) {
            addCriterion("room_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("room_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("room_status not between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberIsNull() {
            addCriterion("studyroom_number is null");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberIsNotNull() {
            addCriterion("studyroom_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberEqualTo(Integer value) {
            addCriterion("studyroom_number =", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberNotEqualTo(Integer value) {
            addCriterion("studyroom_number <>", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberGreaterThan(Integer value) {
            addCriterion("studyroom_number >", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("studyroom_number >=", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberLessThan(Integer value) {
            addCriterion("studyroom_number <", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberLessThanOrEqualTo(Integer value) {
            addCriterion("studyroom_number <=", value, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberIn(List<Integer> values) {
            addCriterion("studyroom_number in", values, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberNotIn(List<Integer> values) {
            addCriterion("studyroom_number not in", values, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberBetween(Integer value1, Integer value2) {
            addCriterion("studyroom_number between", value1, value2, "studyroomNumber");
            return (Criteria) this;
        }

        public Criteria andStudyroomNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("studyroom_number not between", value1, value2, "studyroomNumber");
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