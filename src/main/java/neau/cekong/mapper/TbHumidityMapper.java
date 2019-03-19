package neau.cekong.mapper;

import neau.cekong.pojo.TbHumidity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TbHumidityMapper {
    @Delete({
            "delete from tb_humidity",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into tb_humidity (id, product_id, ",
            "humidity, time)",
            "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
            "#{humidity,jdbcType=DOUBLE}, #{time,jdbcType=TIMESTAMP})"
    })
    int insert(TbHumidity record);

    @InsertProvider(type = TbHumiditySqlProvider.class, method = "insertSelective")
    int insertSelective(TbHumidity record);

    @Select({
            "select",
            "id, product_id, humidity, time",
            "from tb_humidity",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "humidity", property = "humidity", jdbcType = JdbcType.DOUBLE),
            @Result(column = "time", property = "time", jdbcType = JdbcType.TIMESTAMP)
    })
    TbHumidity selectByPrimaryKey(Integer id);

    @UpdateProvider(type = TbHumiditySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbHumidity record);

    @Update({
            "update tb_humidity",
            "set product_id = #{productId,jdbcType=INTEGER},",
            "humidity = #{humidity,jdbcType=DOUBLE},",
            "time = #{time,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbHumidity record);

    @Select("select * from tb_humidity where product_id = #{0} ORDER BY id DESC LIMIT #{1}")
    List<TbHumidity> selectHumidByProductIDLimit(int productId, int limit);

    @Select("select time, humidity from tb_humidity where product_id = #{0} and time between #{1} and #{2}")
    Map<String, String> selectByPidBwtTime(int productId, Date start, Date end);
}