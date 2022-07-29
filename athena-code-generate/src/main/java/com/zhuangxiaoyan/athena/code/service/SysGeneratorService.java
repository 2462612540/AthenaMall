package com.zhuangxiaoyan.athena.code.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhuangxiaoyan.athena.code.config.MongoManager;
import com.zhuangxiaoyan.athena.code.dao.GeneratorDao;
import com.zhuangxiaoyan.athena.code.dao.MongoDBGeneratorDao;
import com.zhuangxiaoyan.athena.code.factory.MongoDBCollectionFactory;
import com.zhuangxiaoyan.athena.code.utils.GenUtils;
import com.zhuangxiaoyan.athena.code.utils.PageUtils;
import com.zhuangxiaoyan.athena.code.utils.Query;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class SysGeneratorService {

    @Qualifier("getGeneratorDao")
    @Autowired
    private GeneratorDao generatorDao;

    /**
     * @description queryList
     * @param: query
     * @date: 2022/7/29 12:13
     * @return: com.zhuangxiaoyan.athena.code.utils.PageUtils
     * @author: xjl
     */
    public PageUtils queryList(Query query) {
        Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Map<String, Object>> list = generatorDao.queryList(query);
        int total = (int) page.getTotal();
        if (generatorDao instanceof MongoDBGeneratorDao) {
            total = MongoDBCollectionFactory.getCollectionTotal(query);
        }
        return new PageUtils(list, total, query.getLimit(), query.getPage());
    }

    /**
     * @description queryTable
     * @param: tableName
     * @date: 2022/7/29 12:54
     * @return: java.util.Map<java.lang.String, java.lang.String>
     * @author: xjl
     */
    public Map<String, String> queryTable(String tableName) {
        return generatorDao.queryTable(tableName);
    }

    /**
     * @description queryColumns
     * @param: tableName
     * @date: 2022/7/29 12:53
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.String>>
     * @author: xjl
     */
    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorDao.queryColumns(tableName);
    }

    /**
     * @description generatorCode
     * @param: tableNames
     * @date: 2022/7/29 12:53
     * @return: byte[]
     * @author: xjl
     */
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        if (MongoManager.isMongo()) {
            GenUtils.generatorMongoCode(tableNames, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
