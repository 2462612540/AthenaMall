

package com.zhunagxiaoyan.athena.admin.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhunagxiaoyan.athena.admin.common.utils.PageUtils;
import com.zhunagxiaoyan.athena.admin.common.utils.Query;
import com.zhunagxiaoyan.athena.admin.modules.oss.dao.SysOssDao;
import com.zhunagxiaoyan.athena.admin.modules.oss.entity.SysOssEntity;
import com.zhunagxiaoyan.athena.admin.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysOssEntity> page = this.page(
                new Query<SysOssEntity>().getPage(params)
        );

        return new PageUtils(page);
    }

}