package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.account.ui.login.LoginActivity;
import com.flydigi.account.ui.logoff.LogoffActivity;
import com.flydigi.account.ui.register.RegisterActivity;
import com.flydigi.account.ui.reset.ResetPasswordActivity;
import i9.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$login implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.C0378a.f31905b, RouteMeta.build(routeType, LoginActivity.class, a.C0378a.f31905b, "login", null, -1, Integer.MIN_VALUE));
        map.put(a.C0378a.f31907d, RouteMeta.build(routeType, LogoffActivity.class, a.C0378a.f31907d, "login", null, -1, Integer.MIN_VALUE));
        map.put(a.C0378a.f31906c, RouteMeta.build(routeType, RegisterActivity.class, a.C0378a.f31906c, "login", null, -1, Integer.MIN_VALUE));
        map.put(a.C0378a.f31909f, RouteMeta.build(routeType, ResetPasswordActivity.class, a.C0378a.f31909f, "login", null, -1, Integer.MIN_VALUE));
    }
}
