package cn.ml.shop_admin.mapper.goods;

import cn.ml.shop_admin.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * 按照id查询商品
     * @param id
     * @return
     */
    Goods selById(@Param("id") int id);

    /**
     * 按照id更新商品信息
     * @param goods
     * @return
     */
    int updateById(@Param("goods")Goods goods);

    /**
     * 分页查询所有商品
     * @param pageNum 页号
     * @return
     */
    List<Goods> selByPage(@Param("pageNum")int pageNum);

    /**
     * 按名字模糊查询商品
     * @param name
     * @return
     */
    List<Goods> selByName(@Param("name")String name);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    int addGoods(@Param("goods")Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delGoods(@Param("id")int id);

    /**
     * 查询商品总个数
     * @return
     */
    int selNum();
}
