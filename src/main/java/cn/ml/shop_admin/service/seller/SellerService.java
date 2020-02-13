package cn.ml.shop_admin.service.seller;

import cn.ml.shop_admin.mapper.seller.SellerMapper;
import cn.ml.shop_admin.pojo.Result;
import cn.ml.shop_admin.pojo.Seller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SellerService {
    @Resource
    private SellerMapper sellerMapper;

    /**
     * 添加商家
     * @param seller
     * @return
     */
    public Result addSeller(Seller seller){
        Result result = new Result();
        int x = this.sellerMapper.addSeller(seller);
        if (x != 0)
        {
            result.setStatus(200);
            result.setMessage("添加成功");
            return result;
        }
        result.setStatus(500);
        result.setMessage("添加失败");
        return result;
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    public Result delSeller(int id){
        Result result = new Result();
        int x = this.sellerMapper.delSeller(id);
        if (x != 0)
        {
            result.setStatus(200);
            result.setMessage("删除成功");
            return result;
        }
        result.setStatus(500);
        result.setMessage("删除失败");
        return result;
    }

    /**
     * 按照id查询商家
     * @param id
     * @return
     */
    public Result selById(int id){
        Result result = new Result();
        Seller seller = this.sellerMapper.selById(id);
        if (seller != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(seller);
            return result;
        }
        result.setStatus(404);
        result.setMessage("未找到相关信息");
        return result;
    }

    /**
     * 更新商家信息
     * @param seller
     * @return
     */
    public Result updateSeller(Seller seller){
        Result result = new Result();
        int x = this.sellerMapper.updateSeller(seller);
        if (x != 0)
        {
            result.setStatus(200);
            result.setMessage("更新成功");
            return result;
        }
        result.setStatus(500);
        result.setMessage("更新失败");
        return result;
    }

    /**
     * 按名字模糊查询商家
     * @param name
     * @return
     */
    public Result selByName(String name){
        Result result = new Result();
        List<Seller> sellers = this.sellerMapper.selByName(name);
        if (sellers != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(sellers);
            return result;
        }
        result.setStatus(404);
        result.setMessage("未找到相关信息");
        return result;
    }

    /**
     * 分页查询商家信息
     * @param pageNum
     * @return
     */
    public Result selByPage(int pageNum){
        Result result = new Result();
        pageNum = (pageNum - 1) * 5;
        List<Seller> sellers = this.sellerMapper.selByPage(pageNum);
        if (sellers != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(sellers);
            return result;
        }
        result.setStatus(404);
        result.setMessage("查询失败");
        return result;
    }

    /**
     * 查询商家总数量
     * @return
     */
    public Result selNum(){
        Result result = new Result();
        int x = this.sellerMapper.selNum();
        result.setStatus(200);
        result.setMessage("查询成功");
        result.setData(x);
        return result;
    }
}
