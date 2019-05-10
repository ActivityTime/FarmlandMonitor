package neau.cekong.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public WeatherExample() {
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

        public Criteria andRetimeIsNull() {
            addCriterion("weather.retime is null");
            return (Criteria) this;
        }

        public Criteria andRetimeIsNotNull() {
            addCriterion("weather.retime is not null");
            return (Criteria) this;
        }

        public Criteria andRetimeEqualTo(LocalDateTime value) {
            addCriterion("weather.retime =", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeNotEqualTo(LocalDateTime value) {
            addCriterion("weather.retime <>", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeGreaterThan(LocalDateTime value) {
            addCriterion("weather.retime >", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("weather.retime >=", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeLessThan(LocalDateTime value) {
            addCriterion("weather.retime <", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("weather.retime <=", value, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeIn(List<LocalDateTime> values) {
            addCriterion("weather.retime in", values, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeNotIn(List<LocalDateTime> values) {
            addCriterion("weather.retime not in", values, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("weather.retime between", value1, value2, "retime");
            return (Criteria) this;
        }

        public Criteria andRetimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("weather.retime not between", value1, value2, "retime");
            return (Criteria) this;
        }

        public Criteria andTAIsNull() {
            addCriterion("weather.TA is null");
            return (Criteria) this;
        }

        public Criteria andTAIsNotNull() {
            addCriterion("weather.TA is not null");
            return (Criteria) this;
        }

        public Criteria andTAEqualTo(BigDecimal value) {
            addCriterion("weather.TA =", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTANotEqualTo(BigDecimal value) {
            addCriterion("weather.TA <>", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTAGreaterThan(BigDecimal value) {
            addCriterion("weather.TA >", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTAGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TA >=", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTALessThan(BigDecimal value) {
            addCriterion("weather.TA <", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTALessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TA <=", value, "TA");
            return (Criteria) this;
        }

        public Criteria andTAIn(List<BigDecimal> values) {
            addCriterion("weather.TA in", values, "TA");
            return (Criteria) this;
        }

        public Criteria andTANotIn(List<BigDecimal> values) {
            addCriterion("weather.TA not in", values, "TA");
            return (Criteria) this;
        }

        public Criteria andTABetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TA between", value1, value2, "TA");
            return (Criteria) this;
        }

        public Criteria andTANotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TA not between", value1, value2, "TA");
            return (Criteria) this;
        }

        public Criteria andRHIsNull() {
            addCriterion("weather.RH is null");
            return (Criteria) this;
        }

        public Criteria andRHIsNotNull() {
            addCriterion("weather.RH is not null");
            return (Criteria) this;
        }

        public Criteria andRHEqualTo(BigDecimal value) {
            addCriterion("weather.RH =", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHNotEqualTo(BigDecimal value) {
            addCriterion("weather.RH <>", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHGreaterThan(BigDecimal value) {
            addCriterion("weather.RH >", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RH >=", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHLessThan(BigDecimal value) {
            addCriterion("weather.RH <", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RH <=", value, "RH");
            return (Criteria) this;
        }

        public Criteria andRHIn(List<BigDecimal> values) {
            addCriterion("weather.RH in", values, "RH");
            return (Criteria) this;
        }

        public Criteria andRHNotIn(List<BigDecimal> values) {
            addCriterion("weather.RH not in", values, "RH");
            return (Criteria) this;
        }

        public Criteria andRHBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RH between", value1, value2, "RH");
            return (Criteria) this;
        }

        public Criteria andRHNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RH not between", value1, value2, "RH");
            return (Criteria) this;
        }

        public Criteria andPPMIsNull() {
            addCriterion("weather.PPM is null");
            return (Criteria) this;
        }

        public Criteria andPPMIsNotNull() {
            addCriterion("weather.PPM is not null");
            return (Criteria) this;
        }

        public Criteria andPPMEqualTo(BigDecimal value) {
            addCriterion("weather.PPM =", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMNotEqualTo(BigDecimal value) {
            addCriterion("weather.PPM <>", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMGreaterThan(BigDecimal value) {
            addCriterion("weather.PPM >", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PPM >=", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMLessThan(BigDecimal value) {
            addCriterion("weather.PPM <", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PPM <=", value, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMIn(List<BigDecimal> values) {
            addCriterion("weather.PPM in", values, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMNotIn(List<BigDecimal> values) {
            addCriterion("weather.PPM not in", values, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PPM between", value1, value2, "PPM");
            return (Criteria) this;
        }

        public Criteria andPPMNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PPM not between", value1, value2, "PPM");
            return (Criteria) this;
        }

        public Criteria andWDIsNull() {
            addCriterion("weather.WD is null");
            return (Criteria) this;
        }

        public Criteria andWDIsNotNull() {
            addCriterion("weather.WD is not null");
            return (Criteria) this;
        }

        public Criteria andWDEqualTo(BigDecimal value) {
            addCriterion("weather.WD =", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDNotEqualTo(BigDecimal value) {
            addCriterion("weather.WD <>", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDGreaterThan(BigDecimal value) {
            addCriterion("weather.WD >", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.WD >=", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDLessThan(BigDecimal value) {
            addCriterion("weather.WD <", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.WD <=", value, "WD");
            return (Criteria) this;
        }

        public Criteria andWDIn(List<BigDecimal> values) {
            addCriterion("weather.WD in", values, "WD");
            return (Criteria) this;
        }

        public Criteria andWDNotIn(List<BigDecimal> values) {
            addCriterion("weather.WD not in", values, "WD");
            return (Criteria) this;
        }

        public Criteria andWDBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.WD between", value1, value2, "WD");
            return (Criteria) this;
        }

        public Criteria andWDNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.WD not between", value1, value2, "WD");
            return (Criteria) this;
        }

        public Criteria andPRESSIsNull() {
            addCriterion("weather.PRESS is null");
            return (Criteria) this;
        }

        public Criteria andPRESSIsNotNull() {
            addCriterion("weather.PRESS is not null");
            return (Criteria) this;
        }

        public Criteria andPRESSEqualTo(BigDecimal value) {
            addCriterion("weather.PRESS =", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSNotEqualTo(BigDecimal value) {
            addCriterion("weather.PRESS <>", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSGreaterThan(BigDecimal value) {
            addCriterion("weather.PRESS >", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PRESS >=", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSLessThan(BigDecimal value) {
            addCriterion("weather.PRESS <", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PRESS <=", value, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSIn(List<BigDecimal> values) {
            addCriterion("weather.PRESS in", values, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSNotIn(List<BigDecimal> values) {
            addCriterion("weather.PRESS not in", values, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PRESS between", value1, value2, "PRESS");
            return (Criteria) this;
        }

        public Criteria andPRESSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PRESS not between", value1, value2, "PRESS");
            return (Criteria) this;
        }

        public Criteria andDEPTHIsNull() {
            addCriterion("weather.`DEPTH` is null");
            return (Criteria) this;
        }

        public Criteria andDEPTHIsNotNull() {
            addCriterion("weather.`DEPTH` is not null");
            return (Criteria) this;
        }

        public Criteria andDEPTHEqualTo(BigDecimal value) {
            addCriterion("weather.`DEPTH` =", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHNotEqualTo(BigDecimal value) {
            addCriterion("weather.`DEPTH` <>", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHGreaterThan(BigDecimal value) {
            addCriterion("weather.`DEPTH` >", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.`DEPTH` >=", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHLessThan(BigDecimal value) {
            addCriterion("weather.`DEPTH` <", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.`DEPTH` <=", value, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHIn(List<BigDecimal> values) {
            addCriterion("weather.`DEPTH` in", values, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHNotIn(List<BigDecimal> values) {
            addCriterion("weather.`DEPTH` not in", values, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.`DEPTH` between", value1, value2, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andDEPTHNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.`DEPTH` not between", value1, value2, "DEPTH");
            return (Criteria) this;
        }

        public Criteria andPARIsNull() {
            addCriterion("weather.PAR is null");
            return (Criteria) this;
        }

        public Criteria andPARIsNotNull() {
            addCriterion("weather.PAR is not null");
            return (Criteria) this;
        }

        public Criteria andPAREqualTo(BigDecimal value) {
            addCriterion("weather.PAR =", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARNotEqualTo(BigDecimal value) {
            addCriterion("weather.PAR <>", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARGreaterThan(BigDecimal value) {
            addCriterion("weather.PAR >", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PAR >=", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARLessThan(BigDecimal value) {
            addCriterion("weather.PAR <", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.PAR <=", value, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARIn(List<BigDecimal> values) {
            addCriterion("weather.PAR in", values, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARNotIn(List<BigDecimal> values) {
            addCriterion("weather.PAR not in", values, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PAR between", value1, value2, "PAR");
            return (Criteria) this;
        }

        public Criteria andPARNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.PAR not between", value1, value2, "PAR");
            return (Criteria) this;
        }

        public Criteria andRAIsNull() {
            addCriterion("weather.RA is null");
            return (Criteria) this;
        }

        public Criteria andRAIsNotNull() {
            addCriterion("weather.RA is not null");
            return (Criteria) this;
        }

        public Criteria andRAEqualTo(BigDecimal value) {
            addCriterion("weather.RA =", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRANotEqualTo(BigDecimal value) {
            addCriterion("weather.RA <>", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRAGreaterThan(BigDecimal value) {
            addCriterion("weather.RA >", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRAGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RA >=", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRALessThan(BigDecimal value) {
            addCriterion("weather.RA <", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRALessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RA <=", value, "RA");
            return (Criteria) this;
        }

        public Criteria andRAIn(List<BigDecimal> values) {
            addCriterion("weather.RA in", values, "RA");
            return (Criteria) this;
        }

        public Criteria andRANotIn(List<BigDecimal> values) {
            addCriterion("weather.RA not in", values, "RA");
            return (Criteria) this;
        }

        public Criteria andRABetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RA between", value1, value2, "RA");
            return (Criteria) this;
        }

        public Criteria andRANotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RA not between", value1, value2, "RA");
            return (Criteria) this;
        }

        public Criteria andUV3IsNull() {
            addCriterion("weather.UV3 is null");
            return (Criteria) this;
        }

        public Criteria andUV3IsNotNull() {
            addCriterion("weather.UV3 is not null");
            return (Criteria) this;
        }

        public Criteria andUV3EqualTo(BigDecimal value) {
            addCriterion("weather.UV3 =", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3NotEqualTo(BigDecimal value) {
            addCriterion("weather.UV3 <>", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3GreaterThan(BigDecimal value) {
            addCriterion("weather.UV3 >", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.UV3 >=", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3LessThan(BigDecimal value) {
            addCriterion("weather.UV3 <", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.UV3 <=", value, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3In(List<BigDecimal> values) {
            addCriterion("weather.UV3 in", values, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3NotIn(List<BigDecimal> values) {
            addCriterion("weather.UV3 not in", values, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.UV3 between", value1, value2, "UV3");
            return (Criteria) this;
        }

        public Criteria andUV3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.UV3 not between", value1, value2, "UV3");
            return (Criteria) this;
        }

        public Criteria andNET_RIsNull() {
            addCriterion("weather.NET_R is null");
            return (Criteria) this;
        }

        public Criteria andNET_RIsNotNull() {
            addCriterion("weather.NET_R is not null");
            return (Criteria) this;
        }

        public Criteria andNET_REqualTo(BigDecimal value) {
            addCriterion("weather.NET_R =", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RNotEqualTo(BigDecimal value) {
            addCriterion("weather.NET_R <>", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RGreaterThan(BigDecimal value) {
            addCriterion("weather.NET_R >", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.NET_R >=", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RLessThan(BigDecimal value) {
            addCriterion("weather.NET_R <", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.NET_R <=", value, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RIn(List<BigDecimal> values) {
            addCriterion("weather.NET_R in", values, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RNotIn(List<BigDecimal> values) {
            addCriterion("weather.NET_R not in", values, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.NET_R between", value1, value2, "NET_R");
            return (Criteria) this;
        }

        public Criteria andNET_RNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.NET_R not between", value1, value2, "NET_R");
            return (Criteria) this;
        }

        public Criteria andTS1IsNull() {
            addCriterion("weather.TS1 is null");
            return (Criteria) this;
        }

        public Criteria andTS1IsNotNull() {
            addCriterion("weather.TS1 is not null");
            return (Criteria) this;
        }

        public Criteria andTS1EqualTo(BigDecimal value) {
            addCriterion("weather.TS1 =", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1NotEqualTo(BigDecimal value) {
            addCriterion("weather.TS1 <>", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1GreaterThan(BigDecimal value) {
            addCriterion("weather.TS1 >", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS1 >=", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1LessThan(BigDecimal value) {
            addCriterion("weather.TS1 <", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS1 <=", value, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1In(List<BigDecimal> values) {
            addCriterion("weather.TS1 in", values, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1NotIn(List<BigDecimal> values) {
            addCriterion("weather.TS1 not in", values, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS1 between", value1, value2, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS1 not between", value1, value2, "TS1");
            return (Criteria) this;
        }

        public Criteria andTS2IsNull() {
            addCriterion("weather.TS2 is null");
            return (Criteria) this;
        }

        public Criteria andTS2IsNotNull() {
            addCriterion("weather.TS2 is not null");
            return (Criteria) this;
        }

        public Criteria andTS2EqualTo(BigDecimal value) {
            addCriterion("weather.TS2 =", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2NotEqualTo(BigDecimal value) {
            addCriterion("weather.TS2 <>", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2GreaterThan(BigDecimal value) {
            addCriterion("weather.TS2 >", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS2 >=", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2LessThan(BigDecimal value) {
            addCriterion("weather.TS2 <", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS2 <=", value, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2In(List<BigDecimal> values) {
            addCriterion("weather.TS2 in", values, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2NotIn(List<BigDecimal> values) {
            addCriterion("weather.TS2 not in", values, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS2 between", value1, value2, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS2 not between", value1, value2, "TS2");
            return (Criteria) this;
        }

        public Criteria andTS3IsNull() {
            addCriterion("weather.TS3 is null");
            return (Criteria) this;
        }

        public Criteria andTS3IsNotNull() {
            addCriterion("weather.TS3 is not null");
            return (Criteria) this;
        }

        public Criteria andTS3EqualTo(BigDecimal value) {
            addCriterion("weather.TS3 =", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3NotEqualTo(BigDecimal value) {
            addCriterion("weather.TS3 <>", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3GreaterThan(BigDecimal value) {
            addCriterion("weather.TS3 >", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS3 >=", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3LessThan(BigDecimal value) {
            addCriterion("weather.TS3 <", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS3 <=", value, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3In(List<BigDecimal> values) {
            addCriterion("weather.TS3 in", values, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3NotIn(List<BigDecimal> values) {
            addCriterion("weather.TS3 not in", values, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS3 between", value1, value2, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS3 not between", value1, value2, "TS3");
            return (Criteria) this;
        }

        public Criteria andTS4IsNull() {
            addCriterion("weather.TS4 is null");
            return (Criteria) this;
        }

        public Criteria andTS4IsNotNull() {
            addCriterion("weather.TS4 is not null");
            return (Criteria) this;
        }

        public Criteria andTS4EqualTo(BigDecimal value) {
            addCriterion("weather.TS4 =", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4NotEqualTo(BigDecimal value) {
            addCriterion("weather.TS4 <>", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4GreaterThan(BigDecimal value) {
            addCriterion("weather.TS4 >", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS4 >=", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4LessThan(BigDecimal value) {
            addCriterion("weather.TS4 <", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS4 <=", value, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4In(List<BigDecimal> values) {
            addCriterion("weather.TS4 in", values, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4NotIn(List<BigDecimal> values) {
            addCriterion("weather.TS4 not in", values, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS4 between", value1, value2, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS4 not between", value1, value2, "TS4");
            return (Criteria) this;
        }

        public Criteria andTS5IsNull() {
            addCriterion("weather.TS5 is null");
            return (Criteria) this;
        }

        public Criteria andTS5IsNotNull() {
            addCriterion("weather.TS5 is not null");
            return (Criteria) this;
        }

        public Criteria andTS5EqualTo(BigDecimal value) {
            addCriterion("weather.TS5 =", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5NotEqualTo(BigDecimal value) {
            addCriterion("weather.TS5 <>", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5GreaterThan(BigDecimal value) {
            addCriterion("weather.TS5 >", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS5 >=", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5LessThan(BigDecimal value) {
            addCriterion("weather.TS5 <", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.TS5 <=", value, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5In(List<BigDecimal> values) {
            addCriterion("weather.TS5 in", values, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5NotIn(List<BigDecimal> values) {
            addCriterion("weather.TS5 not in", values, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS5 between", value1, value2, "TS5");
            return (Criteria) this;
        }

        public Criteria andTS5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.TS5 not between", value1, value2, "TS5");
            return (Criteria) this;
        }

        public Criteria andMS1IsNull() {
            addCriterion("weather.MS1 is null");
            return (Criteria) this;
        }

        public Criteria andMS1IsNotNull() {
            addCriterion("weather.MS1 is not null");
            return (Criteria) this;
        }

        public Criteria andMS1EqualTo(BigDecimal value) {
            addCriterion("weather.MS1 =", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1NotEqualTo(BigDecimal value) {
            addCriterion("weather.MS1 <>", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1GreaterThan(BigDecimal value) {
            addCriterion("weather.MS1 >", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS1 >=", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1LessThan(BigDecimal value) {
            addCriterion("weather.MS1 <", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS1 <=", value, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1In(List<BigDecimal> values) {
            addCriterion("weather.MS1 in", values, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1NotIn(List<BigDecimal> values) {
            addCriterion("weather.MS1 not in", values, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS1 between", value1, value2, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS1 not between", value1, value2, "MS1");
            return (Criteria) this;
        }

        public Criteria andMS2IsNull() {
            addCriterion("weather.MS2 is null");
            return (Criteria) this;
        }

        public Criteria andMS2IsNotNull() {
            addCriterion("weather.MS2 is not null");
            return (Criteria) this;
        }

        public Criteria andMS2EqualTo(BigDecimal value) {
            addCriterion("weather.MS2 =", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2NotEqualTo(BigDecimal value) {
            addCriterion("weather.MS2 <>", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2GreaterThan(BigDecimal value) {
            addCriterion("weather.MS2 >", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS2 >=", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2LessThan(BigDecimal value) {
            addCriterion("weather.MS2 <", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS2 <=", value, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2In(List<BigDecimal> values) {
            addCriterion("weather.MS2 in", values, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2NotIn(List<BigDecimal> values) {
            addCriterion("weather.MS2 not in", values, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS2 between", value1, value2, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS2 not between", value1, value2, "MS2");
            return (Criteria) this;
        }

        public Criteria andMS3IsNull() {
            addCriterion("weather.MS3 is null");
            return (Criteria) this;
        }

        public Criteria andMS3IsNotNull() {
            addCriterion("weather.MS3 is not null");
            return (Criteria) this;
        }

        public Criteria andMS3EqualTo(BigDecimal value) {
            addCriterion("weather.MS3 =", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3NotEqualTo(BigDecimal value) {
            addCriterion("weather.MS3 <>", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3GreaterThan(BigDecimal value) {
            addCriterion("weather.MS3 >", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS3 >=", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3LessThan(BigDecimal value) {
            addCriterion("weather.MS3 <", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS3 <=", value, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3In(List<BigDecimal> values) {
            addCriterion("weather.MS3 in", values, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3NotIn(List<BigDecimal> values) {
            addCriterion("weather.MS3 not in", values, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS3 between", value1, value2, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS3 not between", value1, value2, "MS3");
            return (Criteria) this;
        }

        public Criteria andMS4IsNull() {
            addCriterion("weather.MS4 is null");
            return (Criteria) this;
        }

        public Criteria andMS4IsNotNull() {
            addCriterion("weather.MS4 is not null");
            return (Criteria) this;
        }

        public Criteria andMS4EqualTo(BigDecimal value) {
            addCriterion("weather.MS4 =", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4NotEqualTo(BigDecimal value) {
            addCriterion("weather.MS4 <>", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4GreaterThan(BigDecimal value) {
            addCriterion("weather.MS4 >", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS4 >=", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4LessThan(BigDecimal value) {
            addCriterion("weather.MS4 <", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS4 <=", value, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4In(List<BigDecimal> values) {
            addCriterion("weather.MS4 in", values, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4NotIn(List<BigDecimal> values) {
            addCriterion("weather.MS4 not in", values, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS4 between", value1, value2, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS4 not between", value1, value2, "MS4");
            return (Criteria) this;
        }

        public Criteria andMS5IsNull() {
            addCriterion("weather.MS5 is null");
            return (Criteria) this;
        }

        public Criteria andMS5IsNotNull() {
            addCriterion("weather.MS5 is not null");
            return (Criteria) this;
        }

        public Criteria andMS5EqualTo(BigDecimal value) {
            addCriterion("weather.MS5 =", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5NotEqualTo(BigDecimal value) {
            addCriterion("weather.MS5 <>", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5GreaterThan(BigDecimal value) {
            addCriterion("weather.MS5 >", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS5 >=", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5LessThan(BigDecimal value) {
            addCriterion("weather.MS5 <", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.MS5 <=", value, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5In(List<BigDecimal> values) {
            addCriterion("weather.MS5 in", values, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5NotIn(List<BigDecimal> values) {
            addCriterion("weather.MS5 not in", values, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS5 between", value1, value2, "MS5");
            return (Criteria) this;
        }

        public Criteria andMS5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.MS5 not between", value1, value2, "MS5");
            return (Criteria) this;
        }

        public Criteria andWSIsNull() {
            addCriterion("weather.WS is null");
            return (Criteria) this;
        }

        public Criteria andWSIsNotNull() {
            addCriterion("weather.WS is not null");
            return (Criteria) this;
        }

        public Criteria andWSEqualTo(BigDecimal value) {
            addCriterion("weather.WS =", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSNotEqualTo(BigDecimal value) {
            addCriterion("weather.WS <>", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSGreaterThan(BigDecimal value) {
            addCriterion("weather.WS >", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.WS >=", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSLessThan(BigDecimal value) {
            addCriterion("weather.WS <", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.WS <=", value, "WS");
            return (Criteria) this;
        }

        public Criteria andWSIn(List<BigDecimal> values) {
            addCriterion("weather.WS in", values, "WS");
            return (Criteria) this;
        }

        public Criteria andWSNotIn(List<BigDecimal> values) {
            addCriterion("weather.WS not in", values, "WS");
            return (Criteria) this;
        }

        public Criteria andWSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.WS between", value1, value2, "WS");
            return (Criteria) this;
        }

        public Criteria andWSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.WS not between", value1, value2, "WS");
            return (Criteria) this;
        }

        public Criteria andRAINIsNull() {
            addCriterion("weather.RAIN is null");
            return (Criteria) this;
        }

        public Criteria andRAINIsNotNull() {
            addCriterion("weather.RAIN is not null");
            return (Criteria) this;
        }

        public Criteria andRAINEqualTo(BigDecimal value) {
            addCriterion("weather.RAIN =", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINNotEqualTo(BigDecimal value) {
            addCriterion("weather.RAIN <>", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINGreaterThan(BigDecimal value) {
            addCriterion("weather.RAIN >", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RAIN >=", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINLessThan(BigDecimal value) {
            addCriterion("weather.RAIN <", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weather.RAIN <=", value, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINIn(List<BigDecimal> values) {
            addCriterion("weather.RAIN in", values, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINNotIn(List<BigDecimal> values) {
            addCriterion("weather.RAIN not in", values, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RAIN between", value1, value2, "RAIN");
            return (Criteria) this;
        }

        public Criteria andRAINNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weather.RAIN not between", value1, value2, "RAIN");
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