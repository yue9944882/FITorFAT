package com.kimmin.ms.config;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by kimmin on 6/30/16.
 */
public class MySQL5DialectUTF8 extends MySQL5Dialect {

    public MySQL5DialectUTF8(){
        super();
    }

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

}
