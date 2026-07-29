package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.cyberfox.ui.connect.ConnectActivity;
import com.flydigi.cyberfox.ui.upgrade.UpgradeActivity;
import com.flydigi.data.DataConstant;
import i9.a;
import java.util.HashMap;
import java.util.Map;
import q9.c;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$cyberfox implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.c.f31944c, RouteMeta.build(routeType, ConnectActivity.class, a.c.f31944c, c.f47166c, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$cyberfox.1
            {
                put("key_device_code", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.c.f31943b, RouteMeta.build(routeType, UpgradeActivity.class, a.c.f31943b, c.f47166c, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$cyberfox.2
            {
                put("key_device_info", 10);
                put("key_device_code", 8);
                put(DataConstant.DEVICE_KEY_FIRMWARE_INFO, 10);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
