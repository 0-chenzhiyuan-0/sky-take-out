package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DishFlavorMapper {


    void insertBatch(@Param("flavors") List<DishFlavor> flavors);

    //delete from dish_flavor where dish_id in (?,?,?)
    void deleteByDishId(@Param("dishIds") List<Long> dishIds);

    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteAllById(Long dishId);
}
