package neau.cekong.mapper;

import neau.cekong.pojo.TbIndex;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TbIndexMapper {
    @Delete({
        "delete from tb_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_index (id, index_name, ",
        "index_farther)",
        "values (#{id,jdbcType=INTEGER}, #{indexName,jdbcType=VARCHAR}, ",
        "#{indexFarther,jdbcType=INTEGER})"
    })
    int insert(TbIndex record);

    @InsertProvider(type=TbIndexSqlProvider.class, method="insertSelective")
    int insertSelective(TbIndex record);

    @Select({
        "select",
        "id, index_name, index_farther",
        "from tb_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="index_name", property="indexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="index_farther", property="indexFarther", jdbcType=JdbcType.INTEGER)
    })
    TbIndex selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbIndexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbIndex record);

    @Update({
        "update tb_index",
        "set index_name = #{indexName,jdbcType=VARCHAR},",
          "index_farther = #{indexFarther,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbIndex record);
}