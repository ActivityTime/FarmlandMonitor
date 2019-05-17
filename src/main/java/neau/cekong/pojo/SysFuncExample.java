package neau.cekong.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public SysFuncExample() {
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

        public Criteria andFunc_idIsNull() {
            addCriterion("sys_func.func_id is null");
            return (Criteria) this;
        }

        public Criteria andFunc_idIsNotNull() {
            addCriterion("sys_func.func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_idEqualTo(Integer value) {
            addCriterion("sys_func.func_id =", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotEqualTo(Integer value) {
            addCriterion("sys_func.func_id <>", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idGreaterThan(Integer value) {
            addCriterion("sys_func.func_id >", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_func.func_id >=", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idLessThan(Integer value) {
            addCriterion("sys_func.func_id <", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idLessThanOrEqualTo(Integer value) {
            addCriterion("sys_func.func_id <=", value, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idIn(List<Integer> values) {
            addCriterion("sys_func.func_id in", values, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotIn(List<Integer> values) {
            addCriterion("sys_func.func_id not in", values, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idBetween(Integer value1, Integer value2) {
            addCriterion("sys_func.func_id between", value1, value2, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_func.func_id not between", value1, value2, "func_id");
            return (Criteria) this;
        }

        public Criteria andFunc_nameIsNull() {
            addCriterion("sys_func.func_name is null");
            return (Criteria) this;
        }

        public Criteria andFunc_nameIsNotNull() {
            addCriterion("sys_func.func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_nameEqualTo(String value) {
            addCriterion("sys_func.func_name =", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameNotEqualTo(String value) {
            addCriterion("sys_func.func_name <>", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameGreaterThan(String value) {
            addCriterion("sys_func.func_name >", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_func.func_name >=", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameLessThan(String value) {
            addCriterion("sys_func.func_name <", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameLessThanOrEqualTo(String value) {
            addCriterion("sys_func.func_name <=", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameLike(String value) {
            addCriterion("sys_func.func_name like", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameNotLike(String value) {
            addCriterion("sys_func.func_name not like", value, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameIn(List<String> values) {
            addCriterion("sys_func.func_name in", values, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameNotIn(List<String> values) {
            addCriterion("sys_func.func_name not in", values, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameBetween(String value1, String value2) {
            addCriterion("sys_func.func_name between", value1, value2, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_nameNotBetween(String value1, String value2) {
            addCriterion("sys_func.func_name not between", value1, value2, "func_name");
            return (Criteria) this;
        }

        public Criteria andFunc_urlIsNull() {
            addCriterion("sys_func.func_url is null");
            return (Criteria) this;
        }

        public Criteria andFunc_urlIsNotNull() {
            addCriterion("sys_func.func_url is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_urlEqualTo(String value) {
            addCriterion("sys_func.func_url =", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlNotEqualTo(String value) {
            addCriterion("sys_func.func_url <>", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlGreaterThan(String value) {
            addCriterion("sys_func.func_url >", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlGreaterThanOrEqualTo(String value) {
            addCriterion("sys_func.func_url >=", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlLessThan(String value) {
            addCriterion("sys_func.func_url <", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlLessThanOrEqualTo(String value) {
            addCriterion("sys_func.func_url <=", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlLike(String value) {
            addCriterion("sys_func.func_url like", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlNotLike(String value) {
            addCriterion("sys_func.func_url not like", value, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlIn(List<String> values) {
            addCriterion("sys_func.func_url in", values, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlNotIn(List<String> values) {
            addCriterion("sys_func.func_url not in", values, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlBetween(String value1, String value2) {
            addCriterion("sys_func.func_url between", value1, value2, "func_url");
            return (Criteria) this;
        }

        public Criteria andFunc_urlNotBetween(String value1, String value2) {
            addCriterion("sys_func.func_url not between", value1, value2, "func_url");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("sys_func.pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("sys_func.pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("sys_func.pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("sys_func.pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("sys_func.pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_func.pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("sys_func.pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("sys_func.pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("sys_func.pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("sys_func.pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("sys_func.pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_func.pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andFunc_typeIsNull() {
            addCriterion("sys_func.func_type is null");
            return (Criteria) this;
        }

        public Criteria andFunc_typeIsNotNull() {
            addCriterion("sys_func.func_type is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_typeEqualTo(String value) {
            addCriterion("sys_func.func_type =", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeNotEqualTo(String value) {
            addCriterion("sys_func.func_type <>", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeGreaterThan(String value) {
            addCriterion("sys_func.func_type >", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_func.func_type >=", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeLessThan(String value) {
            addCriterion("sys_func.func_type <", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeLessThanOrEqualTo(String value) {
            addCriterion("sys_func.func_type <=", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeLike(String value) {
            addCriterion("sys_func.func_type like", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeNotLike(String value) {
            addCriterion("sys_func.func_type not like", value, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeIn(List<String> values) {
            addCriterion("sys_func.func_type in", values, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeNotIn(List<String> values) {
            addCriterion("sys_func.func_type not in", values, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeBetween(String value1, String value2) {
            addCriterion("sys_func.func_type between", value1, value2, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_typeNotBetween(String value1, String value2) {
            addCriterion("sys_func.func_type not between", value1, value2, "func_type");
            return (Criteria) this;
        }

        public Criteria andFunc_codeIsNull() {
            addCriterion("sys_func.func_code is null");
            return (Criteria) this;
        }

        public Criteria andFunc_codeIsNotNull() {
            addCriterion("sys_func.func_code is not null");
            return (Criteria) this;
        }

        public Criteria andFunc_codeEqualTo(String value) {
            addCriterion("sys_func.func_code =", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeNotEqualTo(String value) {
            addCriterion("sys_func.func_code <>", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeGreaterThan(String value) {
            addCriterion("sys_func.func_code >", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_func.func_code >=", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeLessThan(String value) {
            addCriterion("sys_func.func_code <", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeLessThanOrEqualTo(String value) {
            addCriterion("sys_func.func_code <=", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeLike(String value) {
            addCriterion("sys_func.func_code like", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeNotLike(String value) {
            addCriterion("sys_func.func_code not like", value, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeIn(List<String> values) {
            addCriterion("sys_func.func_code in", values, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeNotIn(List<String> values) {
            addCriterion("sys_func.func_code not in", values, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeBetween(String value1, String value2) {
            addCriterion("sys_func.func_code between", value1, value2, "func_code");
            return (Criteria) this;
        }

        public Criteria andFunc_codeNotBetween(String value1, String value2) {
            addCriterion("sys_func.func_code not between", value1, value2, "func_code");
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