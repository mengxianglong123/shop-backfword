package cn.ml.shop_admin.service.goods;

import cn.ml.shop_admin.mapper.goods.GoodsMapper;
import cn.ml.shop_admin.pojo.Goods;
import cn.ml.shop_admin.pojo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 分页查询所有商品
     * @param pageNum
     * @return
     */
    public Result selByPage(int pageNum){
        Result result = new Result();
        pageNum = (pageNum - 1) * 5;
        List<Goods> goods = this.goodsMapper.selByPage(pageNum);
        if (goods != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(goods);
            return result;
        }
        result.setStatus(404);
        result.setMessage("查询失败或未找到相关数据");
        return result;
    }

    /**
     * 按照名字模糊查询商品
     * @param name
     * @return
     */
    public Result selByName(String name){
        Result result = new Result();
        List<Goods> goods = this.goodsMapper.selByName(name);
        if (goods != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(goods);
            return result;
        }
        result.setStatus(404);
        result.setMessage("未找到相关数据");
        return result;
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    public Result updateGoods(Goods goods){
        Result result = new Result();
        int x = this.goodsMapper.updateById(goods);
        if (x != 0)
        {
            result.setStatus(200);
            result.setMessage("更新成功");
            result.setData(goods);
            return result;
        }
        result.setStatus(500);
        result.setMessage("更新失败");
        return result;
    }

    /**
     * 按照id查询商品
     * @param id
     * @return
     */
    public Result selById(int id){
        Result result =  new Result();
        Goods goods = this.goodsMapper.selById(id);
        if (goods != null)
        {
            result.setStatus(200);
            result.setMessage("查询成功");
            result.setData(goods);
            return result;
        }
        result.setStatus(404);
        result.setMessage("未找到相关数据");
        return result;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    public Result delGoods(int id){
        Result result = new Result();
        int x = this.goodsMapper.delGoods(id);
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
     * 添加商品
     * @param goods
     * @return
     */
    public Result addGoods(Goods goods){
        Result result = new Result();
        int x = this.goodsMapper.addGoods(goods);
        if (x != 0)
        {
            result.setStatus(200);
            result.setMessage("添加商品成功");
            return result;
        }
        result.setStatus(500);
        result.setMessage("添加失败");
        return result;
    }

    public Result selNum(){
        Result result = new Result();
        int x = this.goodsMapper.selNum();
        result.setMessage("查询成功");
        result.setStatus(200);
        result.setData(x);
        return result;
    }
}
