package cn.ml.shop_admin.mapper.seller;

import cn.ml.shop_admin.pojo.Seller;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerMapper {
    /**
     * 添加商家
     * @param seller
     * @return
     */
    int addSeller(@Param("seller") Seller seller);

    /**
     * 删除商家
     * @param id
     * @return
     */
    int delSeller(@Param("id") int id);

    /**
     * 按照id查询商家
     * @param id
     * @return
     */
    Seller selById(@Param("id") int id);

    /**
     * 更新商家信息
     * @param seller
     * @return
     */
    int updateSeller(@Param("seller") Seller seller);

    /**
     * 按名字模糊查询
     * @param name
     * @return
     */
    List<Seller> selByName(@Param("name") String name);

    /**
     * 分页查询商家
     * @param pageNum
     * @return
     */
    List<Seller> selByPage(@Param("pageNum") int pageNum);

    /**
     * 查询商家
     * @return
     */
    int selNum();
}
