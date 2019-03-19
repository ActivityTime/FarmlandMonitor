package neau.cekong.mapper;

import neau.cekong.pojo.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface DataMapper {
    @Select("select data, time from ${viewName} where product_id = #{0} and time between #{1} and #{2}")
    List<Data> selByPidBwtTime(int productId, Date start, Date end, @Param("viewName") String viewName);


    @Insert("insert into ${viewName} (product_id, time, data) values(#{0}, #{1}, #{2})")
    int insByPid(int productId, Date time, Object data,  @Param("viewName") String viewName);
}
