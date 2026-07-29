package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.Map;
import w.w;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$remote implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(w.b.f53667c, ARouter$$Group$$float.class);
    }
}
