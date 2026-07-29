package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.flydigi.router.LoginInterceptor;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Interceptors$$data implements IInterceptorGroup {
    @Override // com.alibaba.android.arouter.facade.template.IInterceptorGroup
    public void loadInto(Map<Integer, Class<? extends IInterceptor>> interceptors) {
        interceptors.put(6, LoginInterceptor.class);
    }
}
