package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    //select 1 from setmeal_dish where dish_id in (1,2,3) limit 1
    List<Integer> hasByDishId(List<Long> ids);
}
