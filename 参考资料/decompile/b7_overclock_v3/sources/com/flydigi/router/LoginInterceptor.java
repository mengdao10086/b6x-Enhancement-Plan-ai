package com.flydigi.router;

import a5.f;
import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import i9.a;
import kotlin.jvm.internal.f0;
import tt.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@Interceptor(name = "LoginInterceptor", priority = 6)
public final class LoginInterceptor implements IInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public Postcard f16208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public InterceptorCallback f16209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16210d;

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@k Context context) {
        f0.p(context, "context");
        this.f16207a = context;
        c.f().v(this);
    }

    @tt.l
    public final void onEvent(@k FZAccountLoginChangeEvent event) {
        Postcard postcard;
        InterceptorCallback interceptorCallback;
        f0.p(event, "event");
        if (!event.isLogin() || (postcard = this.f16208b) == null || (interceptorCallback = this.f16209c) == null || interceptorCallback == null) {
            return;
        }
        interceptorCallback.onContinue(postcard);
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(@k Postcard postcard, @k InterceptorCallback callback) {
        f0.p(postcard, "postcard");
        f0.p(callback, "callback");
        Context context = null;
        if ((!n0.b(postcard.getPath(), a.C0378a.f31905b) && !n0.b(postcard.getPath(), a.C0378a.f31906c)) || !this.f16210d) {
            this.f16208b = null;
            this.f16209c = null;
        }
        this.f16210d = false;
        if (postcard.getExtra() != 10000000) {
            callback.onContinue(postcard);
            return;
        }
        if (f.i().o()) {
            callback.onContinue(postcard);
            return;
        }
        this.f16208b = postcard;
        InterceptorCallback interceptorCallback = this.f16209c;
        if (interceptorCallback != null) {
            interceptorCallback.onInterrupt(new Exception(""));
        }
        this.f16209c = callback;
        this.f16210d = true;
        Postcard postcardGreenChannel = h3.a.j().d(a.C0378a.f31905b).greenChannel();
        Context context2 = this.f16207a;
        if (context2 == null) {
            f0.S("mContext");
        } else {
            context = context2;
        }
        postcardGreenChannel.navigation(context);
    }
}
