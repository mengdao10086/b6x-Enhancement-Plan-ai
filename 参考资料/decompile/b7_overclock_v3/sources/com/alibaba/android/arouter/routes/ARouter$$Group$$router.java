package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.qiji.RouterCenterProvider;
import i9.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$router implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(a.f31903e, RouteMeta.build(RouteType.PROVIDER, RouterCenterProvider.class, a.f31903e, "router", null, -1, Integer.MIN_VALUE));
    }
}
