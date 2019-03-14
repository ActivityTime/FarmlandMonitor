package neau.cekong.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import neau.cekong.pojo.TbIndexProduct;

public class TbIndexProductSqlProvider {

    public String insertSelective(TbIndexProduct record) {
        BEGIN();
        INSERT_INTO("tb_ip");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getIndexId() != null) {
            VALUES("index_id", "#{indexId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TbIndexProduct record) {
        BEGIN();
        UPDATE("tb_ip");
        
        if (record.getIndexId() != null) {
            SET("index_id = #{indexId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}