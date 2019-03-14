package neau.cekong.mapper;

import neau.cekong.pojo.TbProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface TbProductMapper {
    @Delete({
        "delete from tb_product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_product (id, product_id, ",
        "product_name)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=VARCHAR}, ",
        "#{productName,jdbcType=VARCHAR})"
    })
    int insert(TbProduct record);

    @InsertProvider(type=TbProductSqlProvider.class, method="insertSelective")
    int insertSelective(TbProduct record);

    @Select({
        "select",
        "id, product_id, product_name",
        "from tb_product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR)
    })
    TbProduct selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbProduct record);

    @Update({
        "update tb_product",
        "set product_id = #{productId,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbProduct record);

    @Select("select * from tb_product")
    List<TbProduct> selAll();
}