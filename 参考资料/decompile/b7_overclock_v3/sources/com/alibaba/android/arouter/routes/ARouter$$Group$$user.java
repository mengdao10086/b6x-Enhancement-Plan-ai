package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.qiji.ui.about_phone.AboutPhoneActivity;
import com.flydigi.qiji.ui.about_us.AboutActivity;
import com.flydigi.qiji.ui.contact_us.ContactUsActivity;
import com.umeng.analytics.pro.z;
import i9.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$user implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.i.f31989d, RouteMeta.build(routeType, AboutPhoneActivity.class, a.i.f31989d, z.f23807m, null, -1, Integer.MIN_VALUE));
        map.put(a.i.f31987b, RouteMeta.build(routeType, AboutActivity.class, a.i.f31987b, z.f23807m, null, -1, Integer.MIN_VALUE));
        map.put(a.i.f31988c, RouteMeta.build(routeType, ContactUsActivity.class, a.i.f31988c, z.f23807m, null, -1, Integer.MIN_VALUE));
    }
}
