package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);
    
    //delete from dish where id in (1,2,3)
    void deleteById(@Param("ids") List<Long> ids);

    //select 1 from dish where id in (1,2,3) and status = 1 limit 1
    List<Integer> hasStatusById(@Param("ids") List<Long> ids);

    //
    DishVO getDishVOById(Long id);

    @AutoFill(value = OperationType.UPDATE)
    @Update("update dish set name = #{name}, category_id = #{categoryId}, price = #{price}, status = #{status}, description=#{description}" +
            "where id=#{id}" )
    void updateById(Dish dish);
}
