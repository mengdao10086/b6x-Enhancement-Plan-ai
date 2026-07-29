package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.flydigi.qiji.RouterCenterProvider;
import i9.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$app implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.flydigi.qiji.RouterCenterProvider", RouteMeta.build(RouteType.PROVIDER, RouterCenterProvider.class, a.f31903e, "router", null, -1, Integer.MIN_VALUE));
    }
}
