package c5;

import com.flydigi.data.LoginBaseResponse;
import m5.c0;
import m5.f0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f9753a = (b) f0.i().k().g(b.class);

    @k
    public final z<LoginBaseResponse<?>> a(@k String account) {
        kotlin.jvm.internal.f0.p(account, "account");
        z zVarS0 = this.f9753a.c(account).s0(c0.q());
        kotlin.jvm.internal.f0.o(zVarS0, "api.getVerifyCode(accoun…mer.checkLoginResponse())");
        return zVarS0;
    }

    @k
    public final z<LoginBaseResponse<?>> b(@k String account) {
        kotlin.jvm.internal.f0.p(account, "account");
        z zVarS0 = this.f9753a.u(account, "").s0(c0.q());
        kotlin.jvm.internal.f0.o(zVarS0, "api.getResetVerifyCode(a…mer.checkLoginResponse())");
        return zVarS0;
    }

    @k
    public final z<LoginBaseResponse<?>> c(@k String account, @k String password, @k String code) {
        kotlin.jvm.internal.f0.p(account, "account");
        kotlin.jvm.internal.f0.p(password, "password");
        kotlin.jvm.internal.f0.p(code, "code");
        z zVarS0 = this.f9753a.h(account, code, password).s0(c0.q());
        kotlin.jvm.internal.f0.o(zVarS0, "api.register(account, co…mer.checkLoginResponse())");
        return zVarS0;
    }

    @k
    public final z<LoginBaseResponse<?>> d(@k String account, @k String password, @k String code) {
        kotlin.jvm.internal.f0.p(account, "account");
        kotlin.jvm.internal.f0.p(password, "password");
        kotlin.jvm.internal.f0.p(code, "code");
        z zVarS0 = this.f9753a.m(account, code, password).s0(c0.q());
        kotlin.jvm.internal.f0.o(zVarS0, "api.resetPassword(accoun…mer.checkLoginResponse())");
        return zVarS0;
    }
}
