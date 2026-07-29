package com.arialyy.aria.core.common;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes2.dex */
public enum RequestEnum {
    GET(Constants.HTTP_GET),
    POST(Constants.HTTP_POST);

    public String name;

    RequestEnum(String str) {
        this.name = str;
    }
}
