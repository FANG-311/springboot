package alien.learn.ademo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import alien.learn.ademo.entity.USER;

@Mapper
public interface UserMapper {
    // 查询所有用户
    @Select("select * from user")
    public List<USER> show_all();

    // 添加一个用户
    @Insert("insert into user values(#{username},#{password},#{id})")
    public int insert(USER user);

    // 根据id查询用户
    @Select("select * from user where id = #{id}")
    public USER find(int id);

    // 根据name查询用户
    @Select("select * from user where username = #{username}")
    public USER exist(String username);

    // 查询用户所有的活动
    // @Select("select * from user")
    // @Results({
    // @Result(column = "id", property = "id"),
    // @Result(column = "username", property = "username"),
    // @Result(column = "password", property = "password"),
    // @Result(column = "id", property = "active", javaType = List.class, many =
    // @Many(select = ""))
    // })
    // List<USER> selectAllUserAndActive();
}
