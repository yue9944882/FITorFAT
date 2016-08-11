package com.kimmin.ms.dao.impl;

import com.kimmin.ms.dao.DIDAO;
import com.kimmin.ms.entity.DI;
import org.springframework.stereotype.Repository;

/**
 * Created by t-mijin on 8/11/2016.
 */
@Repository
public class DIDAOImpl extends GeneralDAOImpl<DI> implements DIDAO {
    public DIDAOImpl(){
        super(DI.class);
    }
}
