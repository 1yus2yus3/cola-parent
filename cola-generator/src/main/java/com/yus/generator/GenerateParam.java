package com.yus.generator;

/**
 * Created by Kictto on 2017/4/27.
 */
public class GenerateParam {

    private boolean entity = false;
    private boolean mapper = false;
    private boolean repo = false;
    private boolean service = false;
    private boolean serviceImpl = false;
    private boolean controller = false;
    private boolean listPage = false;
    private boolean listJs = false;
    private boolean editPage = false;
    private boolean editJs = false;
    private boolean business = false;
    private boolean businessImpl = false;

    private boolean vueCompent = false;

    private boolean jpaEntity = false;

    private boolean jpaRepo = false;

    private boolean isVue = false;

    private String vuePath;

    public GenerateParam() {
    }

    public boolean isEntity() {
        return entity;
    }

    public void setEntity(boolean entity) {
        this.entity = entity;
    }

    public boolean isMapper() {
        return mapper;
    }

    public void setMapper(boolean mapper) {
        this.mapper = mapper;
    }

    public boolean isRepo() {
        return repo;
    }

    public void setRepo(boolean repo) {
        this.repo = repo;
    }

    public boolean isService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public boolean isServiceImpl() {
        return serviceImpl;
    }

    public void setServiceImpl(boolean serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public boolean isController() {
        return controller;
    }

    public void setController(boolean controller) {
        this.controller = controller;
    }

    public boolean isListPage() {
        return listPage;
    }

    public void setListPage(boolean listPage) {
        this.listPage = listPage;
    }

    public boolean isEditPage() {
        return editPage;
    }

    public void setEditPage(boolean editPage) {
        this.editPage = editPage;
    }

    public boolean isListJs() {
        return listJs;
    }

    public void setListJs(boolean listJs) {
        this.listJs = listJs;
    }

    public boolean isEditJs() {
        return editJs;
    }

    public void setEditJs(boolean editJs) {
        this.editJs = editJs;
    }

    public boolean isBusiness() {
        return business;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    public boolean isBusinessImpl() {
        return businessImpl;
    }

    public void setBusinessImpl(boolean businessImpl) {
        this.businessImpl = businessImpl;
    }


    public boolean isVueCompent() {
        return vueCompent;
    }

    public void setVueCompent(boolean vueCompent) {
        this.vueCompent = vueCompent;
    }

    public boolean isJpaEntity() {
        return jpaEntity;
    }

    public void setJpaEntity(boolean jpaEntity) {
        this.jpaEntity = jpaEntity;
    }

    public boolean isJpaRepo() {
        return jpaRepo;
    }

    public void setJpaRepo(boolean jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public boolean isVue() {
        return isVue;
    }

    public void setVue(boolean vue) {
        isVue = vue;
    }

    public String getVuePath() {
        return vuePath;
    }

    public void setVuePath(String vuePath) {
        this.vuePath = vuePath;
    }

    @Override
    public String toString() {
        return "ToGenerateContent{" +
                "entity=" + entity +
                ", mapper=" + mapper +
                ", repo=" + repo +
                ", service=" + service +
                ", serviceImpl=" + serviceImpl +
                ", controller=" + controller +
                ", listPage=" + listPage +
                ", listJs=" + listJs +
                ", editPage=" + editPage +
                ", editJs=" + editJs +
                ", business=" + business +
                ", businessImpl=" + businessImpl +
                ", vueCompent=" + vueCompent +
                ", jpaEntity=" + jpaEntity +
                ", jpaRepo=" + jpaRepo +
                '}';
    }
}
