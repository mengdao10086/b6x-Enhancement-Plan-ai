package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.umeng.analytics.pro.z;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$app implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("main", ARouter$$Group$$main.class);
        map.put("router", ARouter$$Group$$router.class);
        map.put(z.f23807m, ARouter$$Group$$user.class);
    }
}
