package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.data.DataConstant;
import com.flydigi.qiji.ui.about_us.WechatFollowActivity;
import com.flydigi.qiji.ui.customer_service.CustomerServiceActivity;
import com.flydigi.qiji.ui.mall.detail.ProductDetailActivity;
import com.game.motionelf.activity.ActivityStart;
import i9.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$main implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.f.f31976e, RouteMeta.build(routeType, CustomerServiceActivity.class, a.f.f31976e, "main", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$main.1
            {
                put(DataConstant.WEB_URL, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.f.f31974c, RouteMeta.build(routeType, ActivityStart.class, a.f.f31974c, "main", null, -1, Integer.MIN_VALUE));
        map.put(a.f.f31977f, RouteMeta.build(routeType, ProductDetailActivity.class, a.f.f31977f, "main", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$main.2
            {
                put(a.f.f31978g, 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.f.f31973b, RouteMeta.build(routeType, WechatFollowActivity.class, a.f.f31973b, "main", null, -1, Integer.MIN_VALUE));
    }
}
