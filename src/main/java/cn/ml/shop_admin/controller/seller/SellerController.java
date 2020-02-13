package cn.ml.shop_admin.controller.seller;

import cn.ml.shop_admin.pojo.Result;
import cn.ml.shop_admin.pojo.Seller;
import cn.ml.shop_admin.service.seller.SellerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Resource
    private SellerService sellerService;

    /**
     * 添加商家
     * @param seller
     * @return
     */
    @RequestMapping("/addSeller")
    public Result addSeller(@RequestBody Seller seller){
        Result result = this.sellerService.addSeller(seller);
        return result;
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @RequestMapping("/delSeller")
    public Result delSeller(int id){
        Result result = this.sellerService.delSeller(id);
        return result;
    }

    /**
     * 按照id查询
     * @param id
     * @return
     */
    @RequestMapping("/selById")
    public Result selById(int id){
        Result result = this.sellerService.selById(id);
        return result;
    }

    /**
     * 更新商家信息
     * @param seller
     * @return
     */
    @RequestMapping("/updateSeller")
    public Result updateSeller(@RequestBody Seller seller){
        Result result = this.sellerService.updateSeller(seller);
        return result;
    }

    /**
     * 按照名字模糊查询商家
     * @param name
     * @return
     */
    @RequestMapping("/selByName")
    public Result selByName(String name){
        Result result = this.sellerService.selByName(name);
        return result;
    }

    /**
     * 分页查询商家数据
     * @param pageNum
     * @return
     */
    @RequestMapping("/selByPage")
    public Result selByPage(int pageNum){
        Result result = this.sellerService.selByPage(pageNum);
        return result;
    }

    /**
     * 查询商家总量
     * @return
     */
    @RequestMapping("/selNum")
    public Result selNum(){
        Result result = this.sellerService.selNum();
        return result;
    }
}
