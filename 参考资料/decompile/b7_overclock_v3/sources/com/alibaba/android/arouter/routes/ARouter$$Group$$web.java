package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.data.DataConstant;
import com.flydigi.web.WebActivity;
import i9.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$web implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        atlas.put(a.f31902d, RouteMeta.build(RouteType.ACTIVITY, WebActivity.class, a.f31902d, "web", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$web.1
            {
                put(DataConstant.WEB_URL, 8);
                put(DataConstant.WEB_TITLE, 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
