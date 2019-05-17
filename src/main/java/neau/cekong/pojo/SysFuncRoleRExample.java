package neau.cekong.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysFuncRoleRExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public SysFuncRoleRExample() {
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

        public Criteria andRf_idIsNull() {
            addCriterion("sys_func_role_r.rf_id is null");
            return (Criteria) this;
        }

        public Criteria andRf_idIsNotNull() {
            addCriterion("sys_func_role_r.rf_id is not null");
            return (Criteria) this;
        }

        public Criteria andRf_idEqualTo(Integer value) {
            addCriterion("sys_func_role_r.rf_id =", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idNotEqualTo(Integer value) {
            addCriterion("sys_func_role_r.rf_id <>", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idGreaterThan(Integer value) {
            addCriterion("sys_func_role_r.rf_id >", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.rf_id >=", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idLessThan(Integer value) {
            addCriterion("sys_func_role_r.rf_id <", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idLessThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.rf_id <=", value, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idIn(List<Integer> values) {
            addCriterion("sys_func_role_r.rf_id in", values, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idNotIn(List<Integer> values) {
            addCriterion("sys_func_role_r.rf_id not in", values, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.rf_id between", value1, value2, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRf_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.rf_id not between", value1, value2, "rf_id");
            return (Criteria) this;
        }

        public Criteria andRole_idIsNull() {
            addCriterion("sys_func_role_r.role_id is null");
            return (Criteria) this;
        }

        public Criteria andRole_idIsNotNull() {
            addCriterion("sys_func_role_r.role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRole_idEqualTo(Integer value) {
            addCriterion("sys_func_role_r.role_id =", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotEqualTo(Integer value) {
            addCriterion("sys_func_role_r.role_id <>", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThan(Integer value) {
            addCriterion("sys_func_role_r.role_id >", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.role_id >=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThan(Integer value) {
            addCriterion("sys_func_role_r.role_id <", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idLessThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.role_id <=", value, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idIn(List<Integer> values) {
            addCriterion("sys_func_role_r.role_id in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotIn(List<Integer> values) {
            addCriterion("sys_func_role_r.role_id not in", values, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.role_id between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andRole_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.role_id not between", value1, value2, "role_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idIsNull() {
            addCriterion("sys_func_role_r.func_id is null");
            return (Criteria) this;
        }

        public Criteria andFunc_idIsNotNull() {
            addCriterion("sys_func_role_r.func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_idEqualTo(Integer value) {
            addCriterion("sys_func_role_r.func_id =", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotEqualTo(Integer value) {
            addCriterion("sys_func_role_r.func_id <>", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idGreaterThan(Integer value) {
            addCriterion("sys_func_role_r.func_id >", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.func_id >=", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idLessThan(Integer value) {
            addCriterion("sys_func_role_r.func_id <", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idLessThanOrEqualTo(Integer value) {
            addCriterion("sys_func_role_r.func_id <=", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idIn(List<Integer> values) {
            addCriterion("sys_func_role_r.func_id in", values, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotIn(List<Integer> values) {
            addCriterion("sys_func_role_r.func_id not in", values, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.func_id between", value1, value2, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_func_role_r.func_id not between", value1, value2, "func_id");
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