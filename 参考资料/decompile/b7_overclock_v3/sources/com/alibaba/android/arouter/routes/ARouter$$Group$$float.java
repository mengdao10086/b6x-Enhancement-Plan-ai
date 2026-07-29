package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.android.motionelf.provider.RemoteProvider;
import i9.a;
import java.util.Map;
import w.w;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$float implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(a.g.f31983b, RouteMeta.build(RouteType.PROVIDER, RemoteProvider.class, a.g.f31983b, w.b.f53667c, null, -1, Integer.MIN_VALUE));
    }
}
