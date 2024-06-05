package com.huawei.ibooking.bean.po;

import java.util.ArrayList;
import java.util.List;

public class TblStudyRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblStudyRoomExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBuildingnumIsNull() {
            addCriterion("buildingNum is null");
            return (Criteria) this;
        }

        public Criteria andBuildingnumIsNotNull() {
            addCriterion("buildingNum is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingnumEqualTo(String value) {
            addCriterion("buildingNum =", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumNotEqualTo(String value) {
            addCriterion("buildingNum <>", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumGreaterThan(String value) {
            addCriterion("buildingNum >", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumGreaterThanOrEqualTo(String value) {
            addCriterion("buildingNum >=", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumLessThan(String value) {
            addCriterion("buildingNum <", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumLessThanOrEqualTo(String value) {
            addCriterion("buildingNum <=", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumLike(String value) {
            addCriterion("buildingNum like", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumNotLike(String value) {
            addCriterion("buildingNum not like", value, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumIn(List<String> values) {
            addCriterion("buildingNum in", values, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumNotIn(List<String> values) {
            addCriterion("buildingNum not in", values, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumBetween(String value1, String value2) {
            addCriterion("buildingNum between", value1, value2, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andBuildingnumNotBetween(String value1, String value2) {
            addCriterion("buildingNum not between", value1, value2, "buildingnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumIsNull() {
            addCriterion("classRoomNum is null");
            return (Criteria) this;
        }

        public Criteria andClassroomnumIsNotNull() {
            addCriterion("classRoomNum is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomnumEqualTo(String value) {
            addCriterion("classRoomNum =", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumNotEqualTo(String value) {
            addCriterion("classRoomNum <>", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumGreaterThan(String value) {
            addCriterion("classRoomNum >", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumGreaterThanOrEqualTo(String value) {
            addCriterion("classRoomNum >=", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumLessThan(String value) {
            addCriterion("classRoomNum <", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumLessThanOrEqualTo(String value) {
            addCriterion("classRoomNum <=", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumLike(String value) {
            addCriterion("classRoomNum like", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumNotLike(String value) {
            addCriterion("classRoomNum not like", value, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumIn(List<String> values) {
            addCriterion("classRoomNum in", values, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumNotIn(List<String> values) {
            addCriterion("classRoomNum not in", values, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumBetween(String value1, String value2) {
            addCriterion("classRoomNum between", value1, value2, "classroomnum");
            return (Criteria) this;
        }

        public Criteria andClassroomnumNotBetween(String value1, String value2) {
            addCriterion("classRoomNum not between", value1, value2, "classroomnum");
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