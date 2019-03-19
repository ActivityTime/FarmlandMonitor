package neau.cekong.mapper;

import neau.cekong.pojo.TbTemperature;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TbTemperatureMapper {
    @Delete({
        "delete from tb_temperature",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_temperature (id, product_id, ",
        "time, temperature)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{temperature,jdbcType=DOUBLE})"
    })
    int insert(TbTemperature record);

    @InsertProvider(type=TbTemperatureSqlProvider.class, method="insertSelective")
    int insertSelective(TbTemperature record);

    @Select({
        "select",
        "id, product_id, time, temperature",
        "from tb_temperature",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="temperature", property="temperature", jdbcType=JdbcType.DOUBLE)
    })
    TbTemperature selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbTemperatureSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbTemperature record);

    @Update({
        "update tb_temperature",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "temperature = #{temperature,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbTemperature record);

    @Select("select * from tb_temperature where product_id = #{0} ORDER BY id DESC LIMIT #{1}")
    List<TbTemperature> selectTempByProductIDLimit(int productId, int limit);

    @Select("select time, temperature from tb_temperature where product_id = #{0} and time between #{1} and #{2}")
    Map<String, String> selectByPidBwtTime(int productId, Date start, Date end);

}