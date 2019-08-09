package com.yus.generator;

public enum FileNameRuleEnum {
        /**
         * 实体
         */
        ENTITY(".entity","Entity","java"),
        /**
         * MAPPER
         */
        MAPPER(".mapper","Mapper","xml"),
        /**
         * REPO =>直接对应
         */
        REPO(".dao","Dao","java"),

        /***
         *
         */
        SERVICE(".repo","Repo","java"),
        /***
         *
         */
        SERVICE_IMPL(".repo.impl","RepoImpl","java"),
        /***
         *
         */
        BUSINESS_SERVICE(".bussiness","Business","java"),
        /***
         *
         */
        BUSINESS_SERVICE_IMPL(".bussiness.impl","BusinessImpl","java"),
        /***
         *
         */
        CONTROLLER(".controller","Controller","java"),
        ;

        FileNameRuleEnum(String packageName,String fileSuffixName,String fileTypeName) {
            this.fileSuffixName = fileSuffixName;
            this.fileTypeName = fileTypeName;
            this.packageName = packageName;
        }

        String packageName;
        String fileSuffixName;
        String fileTypeName;

        public String getPackageName() {
            return packageName;
        }

        public String getFileSuffixName() {
            return fileSuffixName;
        }

        public String getFileTypeName() {
            return fileTypeName;
        }
    }