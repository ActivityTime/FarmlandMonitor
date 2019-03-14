package neau.cekong.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import neau.cekong.pojo.TbIndex;

public class TbIndexSqlProvider {

    public String insertSelective(TbIndex record) {
        BEGIN();
        INSERT_INTO("tb_index");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getIndexName() != null) {
            VALUES("index_name", "#{indexName,jdbcType=VARCHAR}");
        }
        
        if (record.getIndexFarther() != null) {
            VALUES("index_farther", "#{indexFarther,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TbIndex record) {
        BEGIN();
        UPDATE("tb_index");
        
        if (record.getIndexName() != null) {
            SET("index_name = #{indexName,jdbcType=VARCHAR}");
        }
        
        if (record.getIndexFarther() != null) {
            SET("index_farther = #{indexFarther,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}