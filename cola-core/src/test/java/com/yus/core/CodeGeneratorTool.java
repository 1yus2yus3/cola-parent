package com.yus.core;

import com.github.abel533.database.DatabaseConfig;
import com.github.abel533.database.Dialect;
import com.github.abel533.database.IntrospectedTable;
import com.github.abel533.database.SimpleDataSource;
import com.github.abel533.utils.DBMetadataUtils;
import com.yus.generator.CodeGenerator;
import com.yus.generator.GenerateParam;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Copyright (C)
 *
 * @author: Cola
 * @date: 2018/09/28 16:40
 * @description:
 */
public class CodeGeneratorTool {

    public static void main(String[] args) {
        System.out.println("确认生成代码？(y/n) :");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if (!inputString.equals("y") && !inputString.equals("Y")) {
            return;
        }

        InputStream in = CodeGeneratorTool.class.getClassLoader().getResourceAsStream("dbconfig.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("资源文件读取错误，配置文件的位置不正确");
        }

        CodeGenerator codeGenerator = new CodeGenerator(
                properties.getProperty("jdbc.url")
                , properties.getProperty("jdbc.user")
                , properties.getProperty("jdbc.password")
        );

        //各项文件的叶子包路径
        //以下为默认值
        codeGenerator.setPutMapperIntoResourcesDir(true);
        codeGenerator.setMapperPrefixPath("mybatis/mappers");


        String basePackage = "com.yus";
        //设置模块和表名
        //List<Map<模块名,List<表名>>>
        List<Map<String, List<String>>> moduleTables = new ArrayList<>();
        Map<String, List<String>> module = new HashMap<>();
        List<String> tables = new ArrayList<>();
        tables.add("mkt_event");

        module.put("core", tables);



        moduleTables.add(module);

        //设置待生成的内容
        GenerateParam toduList = new GenerateParam();
        toduList.setEntity(true);
        toduList.setMapper(true);
        toduList.setRepo(true);
        toduList.setService(true);
        toduList.setServiceImpl(true);
        /**toduList.setBusiness(true);
         toduList.setBusinessImpl(true);
         toduList.setController(true);*/
        codeGenerator.generate(CodeGeneratorTool.class, basePackage, moduleTables, toduList);
    }
}
