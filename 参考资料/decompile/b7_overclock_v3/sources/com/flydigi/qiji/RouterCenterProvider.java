package com.flydigi.qiji;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.IProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nRouterCenterProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouterCenterProvider.kt\ncom/flydigi/qiji/RouterCenterProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 CharSequence.kt\nandroidx/core/text/CharSequenceKt\n*L\n1#1,40:1\n215#2:41\n216#2:43\n28#3:42\n*S KotlinDebug\n*F\n+ 1 RouterCenterProvider.kt\ncom/flydigi/qiji/RouterCenterProvider\n*L\n19#1:41\n19#1:43\n20#1:42\n*E\n"})
@Route(path = i9.a.f31903e)
public final class RouterCenterProvider implements IProvider {

    public static final class a implements NavigationCallback {
        @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onArrival(@l Postcard postcard) {
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onFound(@l Postcard postcard) {
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onInterrupt(@l Postcard postcard) {
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onLost(@l Postcard postcard) {
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@l Context context) {
    }

    public final void o(@k String path, @k HashMap<String, String> params) {
        f0.p(path, "path");
        f0.p(params, "params");
        Postcard postcardD = h3.a.j().d(path);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (TextUtils.isDigitsOnly(entry.getValue())) {
                postcardD.withInt(entry.getKey(), Integer.parseInt(entry.getValue()));
            } else {
                postcardD.withString(entry.getKey(), entry.getValue());
            }
        }
        postcardD.navigation((Context) null, new a());
    }
}
