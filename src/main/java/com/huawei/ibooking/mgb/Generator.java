package com.huawei.ibooking.mgb;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Generator {
    public static void main(String[] args) throws Exception {
        // 记录mybatis generator执行过程中的警告信息
        List<String> warnings = new ArrayList<>();
        // 覆盖重复代码
        boolean overwrite = true;
        // 读取配置文件
        InputStream is = Generator.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建generator
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String warning : warnings) {
            log.warn(warning);
        }
    }
}
