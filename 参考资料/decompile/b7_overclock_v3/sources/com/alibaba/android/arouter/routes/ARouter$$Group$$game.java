package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.data.DataConstant;
import com.flydigi.game.GameCenterProvider;
import com.flydigi.game.ui.download.DownloadStatusActivity;
import com.flydigi.game.ui.game_detail.GameDetailActivity;
import com.flydigi.game.ui.search.SearchActivity;
import i9.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$game implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.e.f31969e, RouteMeta.build(routeType, GameDetailActivity.class, a.e.f31969e, "game", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$game.1
            {
                put(DataConstant.KEY_GAME_ID, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.e.f31970f, RouteMeta.build(routeType, DownloadStatusActivity.class, a.e.f31970f, "game", null, -1, Integer.MIN_VALUE));
        map.put(a.e.f31966b, RouteMeta.build(RouteType.PROVIDER, GameCenterProvider.class, a.e.f31966b, "game", null, -1, Integer.MIN_VALUE));
        map.put(a.e.f31971g, RouteMeta.build(routeType, SearchActivity.class, a.e.f31971g, "game", null, -1, Integer.MIN_VALUE));
    }
}
