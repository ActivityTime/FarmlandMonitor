package neau.cekong.pojo;

import java.util.ArrayList;
import java.util.List;

public class RecColValExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public RecColValExample() {
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

        public Criteria andKey_idIsNull() {
            addCriterion("key_id is null");
            return (Criteria) this;
        }

        public Criteria andKey_idIsNotNull() {
            addCriterion("key_id is not null");
            return (Criteria) this;
        }

        public Criteria andKey_idEqualTo(Integer value) {
            addCriterion("key_id =", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotEqualTo(Integer value) {
            addCriterion("key_id <>", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idGreaterThan(Integer value) {
            addCriterion("key_id >", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_id >=", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idLessThan(Integer value) {
            addCriterion("key_id <", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idLessThanOrEqualTo(Integer value) {
            addCriterion("key_id <=", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idIn(List<Integer> values) {
            addCriterion("key_id in", values, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotIn(List<Integer> values) {
            addCriterion("key_id not in", values, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idBetween(Integer value1, Integer value2) {
            addCriterion("key_id between", value1, value2, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotBetween(Integer value1, Integer value2) {
            addCriterion("key_id not between", value1, value2, "key_id");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("`value` is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("`value` is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("`value` =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("`value` <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("`value` >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("`value` >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("`value` <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("`value` <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("`value` like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("`value` not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("`value` in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("`value` not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("`value` between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("`value` not between", value1, value2, "value");
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