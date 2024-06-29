package com.tlba.tregueux.dialect;

public class MariaDBDialect extends org.hibernate.dialect.MariaDBDialect {
    @Override
    public String getTableTypeString() {
        return super.getTableTypeString() + " ROW_FORMAT=DYNAMIC";
    }


}