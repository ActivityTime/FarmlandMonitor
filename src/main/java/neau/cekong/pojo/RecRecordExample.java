package neau.cekong.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public RecRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andRec_idIsNull() {
            addCriterion("rec_id is null");
            return (Criteria) this;
        }

        public Criteria andRec_idIsNotNull() {
            addCriterion("rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andRec_idEqualTo(Integer value) {
            addCriterion("rec_id =", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idNotEqualTo(Integer value) {
            addCriterion("rec_id <>", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idGreaterThan(Integer value) {
            addCriterion("rec_id >", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("rec_id >=", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idLessThan(Integer value) {
            addCriterion("rec_id <", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idLessThanOrEqualTo(Integer value) {
            addCriterion("rec_id <=", value, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idIn(List<Integer> values) {
            addCriterion("rec_id in", values, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idNotIn(List<Integer> values) {
            addCriterion("rec_id not in", values, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idBetween(Integer value1, Integer value2) {
            addCriterion("rec_id between", value1, value2, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_idNotBetween(Integer value1, Integer value2) {
            addCriterion("rec_id not between", value1, value2, "rec_id");
            return (Criteria) this;
        }

        public Criteria andRec_nameIsNull() {
            addCriterion("rec_name is null");
            return (Criteria) this;
        }

        public Criteria andRec_nameIsNotNull() {
            addCriterion("rec_name is not null");
            return (Criteria) this;
        }

        public Criteria andRec_nameEqualTo(String value) {
            addCriterion("rec_name =", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameNotEqualTo(String value) {
            addCriterion("rec_name <>", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameGreaterThan(String value) {
            addCriterion("rec_name >", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameGreaterThanOrEqualTo(String value) {
            addCriterion("rec_name >=", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameLessThan(String value) {
            addCriterion("rec_name <", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameLessThanOrEqualTo(String value) {
            addCriterion("rec_name <=", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameLike(String value) {
            addCriterion("rec_name like", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameNotLike(String value) {
            addCriterion("rec_name not like", value, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameIn(List<String> values) {
            addCriterion("rec_name in", values, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameNotIn(List<String> values) {
            addCriterion("rec_name not in", values, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameBetween(String value1, String value2) {
            addCriterion("rec_name between", value1, value2, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_nameNotBetween(String value1, String value2) {
            addCriterion("rec_name not between", value1, value2, "rec_name");
            return (Criteria) this;
        }

        public Criteria andRec_time_startIsNull() {
            addCriterion("rec_time_start is null");
            return (Criteria) this;
        }

        public Criteria andRec_time_startIsNotNull() {
            addCriterion("rec_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andRec_time_startEqualTo(LocalDateTime value) {
            addCriterion("rec_time_start =", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startNotEqualTo(LocalDateTime value) {
            addCriterion("rec_time_start <>", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startGreaterThan(LocalDateTime value) {
            addCriterion("rec_time_start >", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("rec_time_start >=", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startLessThan(LocalDateTime value) {
            addCriterion("rec_time_start <", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("rec_time_start <=", value, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startIn(List<LocalDateTime> values) {
            addCriterion("rec_time_start in", values, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startNotIn(List<LocalDateTime> values) {
            addCriterion("rec_time_start not in", values, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("rec_time_start between", value1, value2, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_startNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("rec_time_start not between", value1, value2, "rec_time_start");
            return (Criteria) this;
        }

        public Criteria andRec_time_endIsNull() {
            addCriterion("rec_time_end is null");
            return (Criteria) this;
        }

        public Criteria andRec_time_endIsNotNull() {
            addCriterion("rec_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andRec_time_endEqualTo(LocalDateTime value) {
            addCriterion("rec_time_end =", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endNotEqualTo(LocalDateTime value) {
            addCriterion("rec_time_end <>", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endGreaterThan(LocalDateTime value) {
            addCriterion("rec_time_end >", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("rec_time_end >=", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endLessThan(LocalDateTime value) {
            addCriterion("rec_time_end <", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("rec_time_end <=", value, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endIn(List<LocalDateTime> values) {
            addCriterion("rec_time_end in", values, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endNotIn(List<LocalDateTime> values) {
            addCriterion("rec_time_end not in", values, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("rec_time_end between", value1, value2, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_time_endNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("rec_time_end not between", value1, value2, "rec_time_end");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameIsNull() {
            addCriterion("rec_character_name is null");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameIsNotNull() {
            addCriterion("rec_character_name is not null");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameEqualTo(String value) {
            addCriterion("rec_character_name =", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameNotEqualTo(String value) {
            addCriterion("rec_character_name <>", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameGreaterThan(String value) {
            addCriterion("rec_character_name >", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameGreaterThanOrEqualTo(String value) {
            addCriterion("rec_character_name >=", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameLessThan(String value) {
            addCriterion("rec_character_name <", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameLessThanOrEqualTo(String value) {
            addCriterion("rec_character_name <=", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameLike(String value) {
            addCriterion("rec_character_name like", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameNotLike(String value) {
            addCriterion("rec_character_name not like", value, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameIn(List<String> values) {
            addCriterion("rec_character_name in", values, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameNotIn(List<String> values) {
            addCriterion("rec_character_name not in", values, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameBetween(String value1, String value2) {
            addCriterion("rec_character_name between", value1, value2, "rec_character_name");
            return (Criteria) this;
        }

        public Criteria andRec_character_nameNotBetween(String value1, String value2) {
            addCriterion("rec_character_name not between", value1, value2, "rec_character_name");
            return (Criteria) this;
        }
    }

    /**
     */
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