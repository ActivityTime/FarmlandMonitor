package neau.cekong.mapper;

import neau.cekong.pojo.TbIndexProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TbIndexProductMapper {
    @Delete({
        "delete from tb_ip",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_ip (id, index_id, ",
        "product_id)",
        "values (#{id,jdbcType=INTEGER}, #{indexId,jdbcType=INTEGER}, ",
        "#{productId,jdbcType=INTEGER})"
    })
    int insert(TbIndexProduct record);

    @InsertProvider(type=TbIndexProductSqlProvider.class, method="insertSelective")
    int insertSelective(TbIndexProduct record);

    @Select({
        "select",
        "id, index_id, product_id",
        "from tb_ip",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="index_id", property="indexId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER)
    })
    TbIndexProduct selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbIndexProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbIndexProduct record);

    @Update({
        "update tb_ip",
        "set index_id = #{indexId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbIndexProduct record);
}