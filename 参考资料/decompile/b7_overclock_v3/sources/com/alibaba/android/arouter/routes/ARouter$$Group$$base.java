package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.base.ui.image_preview.ImagePreviewActivity;
import i9.a;
import java.util.HashMap;
import java.util.Map;
import xc.d;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$base implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(a.f31901c, RouteMeta.build(RouteType.ACTIVITY, ImagePreviewActivity.class, a.f31901c, d.W, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$base.1
            {
                put("main_image_urls", 9);
                put("main_image_current_position", 3);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
