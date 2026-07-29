package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.android.motionelf.provider.RemoteProvider;
import i9.a;
import java.util.Map;
import w.w;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$remote implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.flydigi.baseProvider.IRemoteProvider", RouteMeta.build(RouteType.PROVIDER, RemoteProvider.class, a.g.f31983b, w.b.f53667c, null, -1, Integer.MIN_VALUE));
    }
}
