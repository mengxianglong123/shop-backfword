package cn.ml.shop_admin.mapper.shiro;

import cn.ml.shop_admin.pojo.Admin;

public interface ShiroMapper {
    Admin selByAccount(String account);
}
