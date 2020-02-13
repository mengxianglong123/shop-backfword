package cn.ml.shop_admin.controller.goods;

import cn.ml.shop_admin.pojo.Goods;
import cn.ml.shop_admin.pojo.Result;
import cn.ml.shop_admin.service.goods.GoodsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询所有的商品
     * @param pageNum
     * @return
     */
    @RequestMapping("/selByPage")
    public Result selByPage(int pageNum){
        Result result = this.goodsService.selByPage(pageNum);
        return result;
    }

    /**
     * 按照名字查询商品
     * @param name
     * @return
     */
    @RequestMapping("/selByName")
    public Result selByName(String name){
        Result result = this.goodsService.selByName(name);
        return result;
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @RequestMapping("/updateGoods")
    public Result updateGoods(@RequestBody Goods goods){
        Result result = this.goodsService.updateGoods(goods);
        return result;
    }

    /**
     * 按照id查询商品
     * @param id
     * @return
     */
    @RequestMapping("/selById")
    public Result selById(int id){
        Result result = this.goodsService.selById(id);
        return result;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping("/delGoods")
    public Result delGoods(int id){
        Result result = this.goodsService.delGoods(id);
        return result;
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods){
        System.out.println(goods.toString());
        Result result = this.goodsService.addGoods(goods);
        return result;
    }

    /**
     * 查询商品总数
     * @return
     */
    @RequestMapping("/selNum")
    public Result selNum(){
        Result result = this.goodsService.selNum();
        return result;
    }
}
