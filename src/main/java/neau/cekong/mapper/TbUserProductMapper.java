package neau.cekong.mapper;

import neau.cekong.pojo.TbUserProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TbUserProductMapper {
    @Delete({
        "delete from tb_up",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_up (id, userid, ",
        "proid)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{proid,jdbcType=INTEGER})"
    })
    int insert(TbUserProduct record);

    @InsertProvider(type=TbUserProductSqlProvider.class, method="insertSelective")
    int insertSelective(TbUserProduct record);

    @Select({
        "select",
        "id, userid, proid",
        "from tb_up",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="proid", property="proid", jdbcType=JdbcType.INTEGER)
    })
    TbUserProduct selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbUserProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbUserProduct record);

    @Update({
        "update tb_up",
        "set userid = #{userid,jdbcType=INTEGER},",
          "proid = #{proid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbUserProduct record);
}