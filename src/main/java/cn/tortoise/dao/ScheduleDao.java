package cn.tortoise.dao;

import cn.tortoise.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleDao {
    Schedule getScheduleById(long id);

    List<Schedule> getAllSchedule();

    List<Schedule> getScheduleListUsingOffsetAndLimit(@Param("offset")int offset, @Param("limit")int limit);

    int insertSchedule(Schedule sc);
}
