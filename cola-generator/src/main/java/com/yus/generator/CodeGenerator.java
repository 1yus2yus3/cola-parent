package com.yus.generator;

import com.github.abel533.database.DatabaseConfig;
import com.github.abel533.database.Dialect;
import com.github.abel533.database.IntrospectedTable;
import com.github.abel533.database.SimpleDataSource;
import com.github.abel533.utils.DBMetadataUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright (C)
 *
 * @author: Cola
 * @date: 2018/09/28 16:40
 * @description:
 */
public class CodeGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(CodeGenerator.class);

    private String jdbcUrl = "";
    private String jdbcUsername = "";
    private String jdbcPassword = "";

    private static final String TPL = "template_mybatis_plus" + "/";
    //页面模板文件夹
    private String pagePrefixPackage = "";
    //将mybatis的mapper.xml放到resuource文件夹
    private Boolean putMapperIntoResourcesDir = false;
    private String mapperPrefixPath = "";
    //将moduleName添加到url中
    private Boolean putModuleNameIntoUrl = false;


    public CodeGenerator(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    //生成指定代码
    public void generate(Class currentProjctClass, String basePackageName, List<Map<String,List<String>>> moudleTables,GenerateParam todoList){
        //数据源
        SimpleDataSource simpleDataSource = new SimpleDataSource(Dialect.MYSQL,jdbcUrl,jdbcUsername,jdbcPassword);
        DBMetadataUtils dbMetadataUtils = new DBMetadataUtils(simpleDataSource);
        String catalog = null;
        try{
            catalog = simpleDataSource.getConnection().getCatalog();
        }catch (SQLException e){
            LOG.error("数据库连接错误!",e);
            return;
        }
        //遍历
        for (Map<String, List<String>> module:moudleTables) {
            Iterator<String> iterator = module.keySet().iterator();
            while (iterator.hasNext()) {
                String moudule = iterator.next();
                List<String> tables = module.get(moudule);
                LOG.info("待生成表名：" + tables.toArray().toString());

                List<IntrospectedTable> tableInfos = new ArrayList<>();
                for (String tableName : tables) {
                    DatabaseConfig config = new DatabaseConfig(catalog,null,tableName);
                    List<IntrospectedTable> list = null;
                    try {
                        list = dbMetadataUtils.introspectTables(config);
                    }catch (SQLException e){
                        LOG.error("读取表信息错误！",e);
                        return;
                    }
                    //其实这里只会有一个table，因为用的是tableName作为检索条件的
                    IntrospectedTable tableInfo = list.get(0);
                    //下面就要读取模板文件，并调用模板引擎，生成代码
                    LOG.info("数据表名:" + tableName);
                    VelocityEngine ve = new VelocityEngine();
                    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
                    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
                    ve.setProperty(RuntimeConstants.INPUT_ENCODING, "utf-8");
                    ve.setProperty(RuntimeConstants.OUTPUT_ENCODING, "utf-8");
                    ve.init();

                    VelocityContext ctx = new VelocityContext();// 模板里面用到的变量容器
                    ctx.put("tableInfo", tableInfo);
                    tableInfo.getBaseColumns().get(0).isPk();
                    ctx.put("entityPackage", basePackageName + "." +moudule + FileNameRuleEnum.ENTITY.getPackageName());
                    ctx.put("mapperPackage", basePackageName + "." +moudule + FileNameRuleEnum.MAPPER.getPackageName());
                    ctx.put("repoPackage", basePackageName + "." +moudule + FileNameRuleEnum.REPO.getPackageName());
                    ctx.put("servicePackage", basePackageName + "." +moudule + FileNameRuleEnum.SERVICE.getPackageName());
                    ctx.put("serviceImplPackage", basePackageName + "." +moudule + FileNameRuleEnum.SERVICE_IMPL.getPackageName());
                    ctx.put("controllerPackage", basePackageName + "." +moudule + FileNameRuleEnum.CONTROLLER.getPackageName());
                    ctx.put("businessPackage", basePackageName + "." +moudule + FileNameRuleEnum.BUSINESS_SERVICE.getPackageName());
                    ctx.put("businessImplPackage", basePackageName + "." +moudule + FileNameRuleEnum.BUSINESS_SERVICE_IMPL.getPackageName());
                    ctx.put("className", generateClassName(tableName));

                    ctx.put("entityFileSuffix", FileNameRuleEnum.ENTITY.getFileSuffixName());
                    ctx.put("mapperFileSuffix", FileNameRuleEnum.MAPPER.getFileSuffixName());
                    ctx.put("repoFileSuffix", FileNameRuleEnum.REPO.getFileSuffixName());
                    ctx.put("serviceFileSuffix", FileNameRuleEnum.SERVICE.getFileSuffixName());
                    ctx.put("serviceImplFileSuffix", FileNameRuleEnum.SERVICE_IMPL.getFileSuffixName());
                    ctx.put("controllerFileSuffix", FileNameRuleEnum.CONTROLLER.getFileSuffixName());
                    ctx.put("businessServiceFileSuffix", FileNameRuleEnum.BUSINESS_SERVICE.getFileSuffixName());
                    ctx.put("businessServiceImplFileSuffix", FileNameRuleEnum.BUSINESS_SERVICE_IMPL.getFileSuffixName());

                    ctx.put("putModuleNameIntoUrl", putModuleNameIntoUrl);
                    ctx.put("moduleName", moudule);

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    ctx.put("currentTime", simpleDateFormat.format(new Date()));

                    ctx.put("newline", "\n");
//                    tableInfo.getName();
                    if (todoList.isEntity()) {
                        LOG.info("Entity:" + generateClassName(tableName) + FileNameRuleEnum.ENTITY.getFileSuffixName() + "." + FileNameRuleEnum.ENTITY.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "entity.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("entityPackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.ENTITY.getFileSuffixName() + "." + FileNameRuleEnum.ENTITY.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isJpaEntity()) {
                        LOG.info("JpaEntity:" +  generateClassName(tableName) + FileNameRuleEnum.ENTITY.getFileSuffixName() + "." + FileNameRuleEnum.ENTITY.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "jpaentity.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("entityPackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.ENTITY.getFileSuffixName() + "." + FileNameRuleEnum.ENTITY.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isMapper()) {
                        LOG.info("Mapper:" + generateClassName(tableName) + FileNameRuleEnum.MAPPER.getFileSuffixName() + "." + FileNameRuleEnum.MAPPER.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "mapper.vm");
                        String filePath = "";
                        if (putMapperIntoResourcesDir) {
                            //放到resource文件夹
                            filePath = getModuleResourcePath(currentProjctClass) + mapperPrefixPath + "/" + generateClassName(tableName) + FileNameRuleEnum.MAPPER.getFileSuffixName() + "." + FileNameRuleEnum.MAPPER.getFileTypeName();
                        } else {
                            //放到source文件夹
                            filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("mapperPackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.MAPPER.getFileSuffixName() + "." + FileNameRuleEnum.MAPPER.getFileTypeName();
                        }
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isRepo()) {
                        LOG.info("Repo:" + generateClassName(tableName) + FileNameRuleEnum.REPO.getFileSuffixName() + "." + FileNameRuleEnum.REPO.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "repo.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("repoPackage").toString()) + "/" + generateClassName(tableName) +  FileNameRuleEnum.REPO.getFileSuffixName() + "." + FileNameRuleEnum.REPO.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isJpaRepo()) {
                        LOG.info("JpaRepo:" + generateClassName(tableName) +  FileNameRuleEnum.REPO.getFileSuffixName() + "." + FileNameRuleEnum.REPO.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "jparepo.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("repoPackage").toString()) + "/" + generateClassName(tableName) +  FileNameRuleEnum.REPO.getFileSuffixName() + "." + FileNameRuleEnum.REPO.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isService()) {
                        LOG.info("Service:" + generateClassName(tableName) + FileNameRuleEnum.SERVICE.getFileSuffixName() + "." + FileNameRuleEnum.SERVICE.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "service.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("servicePackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.SERVICE.getFileSuffixName() + "." + FileNameRuleEnum.SERVICE.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isServiceImpl()) {
                        LOG.info("ServiceImpl:" + generateClassName(tableName) + FileNameRuleEnum.SERVICE_IMPL.getFileSuffixName() + "." + FileNameRuleEnum.SERVICE_IMPL.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "serviceImpl.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("serviceImplPackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.SERVICE_IMPL.getFileSuffixName() + "." + FileNameRuleEnum.SERVICE_IMPL.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                    if (todoList.isController()) {
                        LOG.info("Controller:" + generateClassName(tableName) + FileNameRuleEnum.CONTROLLER.getFileSuffixName() + "." + FileNameRuleEnum.CONTROLLER.getFileTypeName());
                        Template tpl = ve.getTemplate(TPL + "controller.vm");
                        String filePath = getModuleSourcePath(currentProjctClass) + packageNameToPath(ctx.get("controllerPackage").toString()) + "/" + generateClassName(tableName) + FileNameRuleEnum.CONTROLLER.getFileSuffixName() + "." + FileNameRuleEnum.CONTROLLER.getFileTypeName();
                        merge(tpl, ctx, filePath);
                    }
                }
            }
        }
    }

    /**
     * 生成文件用的
     *
     * @param template
     * @param ctx
     * @param path
     */
    public static void merge(Template template, VelocityContext ctx, String path) {
        PrintWriter writer = null;
        try {
//            String fileDirsPath = FilenameUtils.getPath(path);
            File file = new File(path);
            if (file.exists() == false) {
//            file.mkdirs();
//            file.mkdir();
                if (file.getParentFile().exists() == false) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static String unCaptureName(String str) {
        char[] cs = str.toCharArray();
        if (cs[0] >= 'A' && cs[0] <= 'Z') {
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }

    // BeanFileName BeanClassName
    public static String generateClassName(String cname) {
        StringBuilder jname = new StringBuilder();
        char[] cChars = cname.toCharArray();
        if (cChars != null && cChars.length > 0) {
            for (int i = 0; i < cChars.length; i++) {
                if (i == 0 && cChars[i] >= 'a' && cChars[i] <= 'z') {
                    jname.append((char) (cChars[i] - 32));
                    continue;
                }
                if (cChars[i] == '_' && i != cChars.length - 1) {
                    // 此种情况是遇到了列名中有下划线的情况，此时
                    // 判断该下划线是否是最后一个字符，若不是，则将后一个转换成大写
                    if (cChars[i + 1] >= 'a' && cChars[i + 1] <= 'z')// 检查是否是小写字母，若是，则转换，否则不做处理
                        cChars[i + 1] = (char) (cChars[i + 1] - 32);
                    continue;
                }
                jname.append(cChars[i]);
            }
        }
        return jname.toString();
    }
    /**
     * 获取当前执行的class的src/main/java所在的根路径
     *
     * @return
     */
    public static String getModuleSourcePath(Class currentProject) {
        StringBuilder stringBuilder = new StringBuilder("");
        String rootPath = currentProject.getClassLoader().getResource("").getFile();
        Integer index = StringUtils.indexOf(rootPath, "/target");
        rootPath = StringUtils.substring(rootPath, 0, index);
        stringBuilder.append(rootPath);
        stringBuilder.append(File.separator).append("src").append(File.separator).append("main").append(File.separator).append("java").append(File.separator);
        return stringBuilder.toString();
    }

    /**
     * 获取当前执行的class的src/main/resource所在的根路径
     *
     * @return
     */
    public static String getModuleResourcePath(Class currentProject) {
        StringBuilder stringBuilder = new StringBuilder("");
        String rootPath = currentProject.getClassLoader().getResource("").getFile();
        Integer index = StringUtils.indexOf(rootPath, "/target");
        rootPath = StringUtils.substring(rootPath, 0, index);
        stringBuilder.append(rootPath);
        stringBuilder.append(File.separator).append("src").append(File.separator).append("main").append(File.separator).append("resources").append(File.separator);
        return stringBuilder.toString();
    }

    /**
     * 包名转换为路径
     *
     * @param packageName
     * @return
     */
    public static String packageNameToPath(String packageName) {

        return packageName.replaceAll("\\.", "/");

    }

    public String getPagePrefixPackage() {
        return pagePrefixPackage;
    }

    public void setPagePrefixPackage(String pagePrefixPackage) {
        this.pagePrefixPackage = pagePrefixPackage;
    }

    public Boolean getPutMapperIntoResourcesDir() {
        return putMapperIntoResourcesDir;
    }

    public void setPutMapperIntoResourcesDir(Boolean putMapperIntoResourcesDir) {
        this.putMapperIntoResourcesDir = putMapperIntoResourcesDir;
    }

    public String getMapperPrefixPath() {
        return mapperPrefixPath;
    }

    public void setMapperPrefixPath(String mapperPrefixPath) {
        this.mapperPrefixPath = mapperPrefixPath;
    }

    public Boolean getPutModuleNameIntoUrl() {
        return putModuleNameIntoUrl;
    }

    public void setPutModuleNameIntoUrl(Boolean putModuleNameIntoUrl) {
        this.putModuleNameIntoUrl = putModuleNameIntoUrl;
    }
}
