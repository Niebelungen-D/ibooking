package com.huawei.ibooking.bean.po;

import java.util.ArrayList;
import java.util.List;

public class SeatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeatExample() {
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

        public Criteria andHasSocketIsNull() {
            addCriterion("has_socket is null");
            return (Criteria) this;
        }

        public Criteria andHasSocketIsNotNull() {
            addCriterion("has_socket is not null");
            return (Criteria) this;
        }

        public Criteria andHasSocketEqualTo(Byte value) {
            addCriterion("has_socket =", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketNotEqualTo(Byte value) {
            addCriterion("has_socket <>", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketGreaterThan(Byte value) {
            addCriterion("has_socket >", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketGreaterThanOrEqualTo(Byte value) {
            addCriterion("has_socket >=", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketLessThan(Byte value) {
            addCriterion("has_socket <", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketLessThanOrEqualTo(Byte value) {
            addCriterion("has_socket <=", value, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketIn(List<Byte> values) {
            addCriterion("has_socket in", values, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketNotIn(List<Byte> values) {
            addCriterion("has_socket not in", values, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketBetween(Byte value1, Byte value2) {
            addCriterion("has_socket between", value1, value2, "hasSocket");
            return (Criteria) this;
        }

        public Criteria andHasSocketNotBetween(Byte value1, Byte value2) {
            addCriterion("has_socket not between", value1, value2, "hasSocket");
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