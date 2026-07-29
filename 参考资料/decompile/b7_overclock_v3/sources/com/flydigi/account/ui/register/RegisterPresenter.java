package com.flydigi.account.ui.register;

import com.blankj.utilcode.util.j1;
import com.flydigi.account.R;
import com.flydigi.account.ui.register.a;
import com.flydigi.base.net.ApiException;
import com.flydigi.data.LoginBaseResponse;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class RegisterPresenter implements a.InterfaceC0129a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final io.reactivex.disposables.a f13225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final c5.a f13226c;

    public static final class a extends c5.c<LoginBaseResponse<?>> {
        public a() {
        }

        @Override // c5.c
        public void a(@l String str, int i10) {
            a.b bVar = RegisterPresenter.this.f13224a;
            switch (i10) {
                case c5.d.f9755b /* 20001 */:
                    str = j1.a().getString(R.string.account_phone_number_not_valid);
                    break;
                case c5.d.f9756c /* 20002 */:
                    str = j1.a().getString(R.string.account_was_exist);
                    break;
                case c5.d.f9757d /* 20003 */:
                case 20005:
                default:
                    if (str == null) {
                        str = j1.a().getString(R.string.net_state_error);
                        f0.o(str, "getApp().getString(R.string.net_state_error)");
                    }
                    break;
                case c5.d.f9758e /* 20004 */:
                    str = j1.a().getString(R.string.account_verify_code_error);
                    break;
                case c5.d.f9759f /* 20006 */:
                    str = j1.a().getString(R.string.account_register_failed);
                    break;
                case c5.d.f9760g /* 20007 */:
                    str = j1.a().getString(R.string.account_not_exist);
                    break;
            }
            f0.o(str, "when (stateCode) {\n     …                        }");
            bVar.f(str, true);
        }

        @Override // c5.c
        public void c(boolean z10) {
        }

        @Override // c5.c
        public void d(@k LoginBaseResponse<?> loginBaseResponse) {
            f0.p(loginBaseResponse, "loginBaseResponse");
            RegisterPresenter.this.f13224a.I(loginBaseResponse);
        }
    }

    public RegisterPresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13224a = mView;
        this.f13225b = new io.reactivex.disposables.a();
        this.f13226c = new c5.a();
    }

    public static final void g0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void h0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.account.ui.register.a.InterfaceC0129a
    public void c(@k String account) {
        f0.p(account, "account");
        z zVarS0 = this.f13226c.a(account).s0(c0.t()).s0(o5.l.d());
        final ik.l<LoginBaseResponse<?>, z1> lVar = new ik.l<LoginBaseResponse<?>, z1>() { // from class: com.flydigi.account.ui.register.RegisterPresenter$getVerifyCode$1
            {
                super(1);
            }

            public final void b(LoginBaseResponse<?> loginBaseResponse) {
                this.this$0.f13224a.k();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LoginBaseResponse<?> loginBaseResponse) {
                b(loginBaseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.account.ui.register.i
            @Override // dj.g
            public final void accept(Object obj) {
                RegisterPresenter.g0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.register.RegisterPresenter$getVerifyCode$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                String string;
                if (!(th2 instanceof ApiException)) {
                    a.b bVar = this.this$0.f13224a;
                    String message = th2.getMessage();
                    if (message == null) {
                        message = j1.a().getString(R.string.net_state_error);
                        f0.o(message, "getApp().getString(R.string.net_state_error)");
                    }
                    bVar.f(message, true);
                    return;
                }
                a.b bVar2 = this.this$0.f13224a;
                switch (((ApiException) th2).a()) {
                    case c5.d.f9755b /* 20001 */:
                        string = j1.a().getString(R.string.account_phone_number_not_valid);
                        break;
                    case c5.d.f9756c /* 20002 */:
                        string = j1.a().getString(R.string.account_was_exist);
                        break;
                    case c5.d.f9757d /* 20003 */:
                        string = j1.a().getString(R.string.account_verify_code_send_failed);
                        break;
                    case c5.d.f9758e /* 20004 */:
                        string = j1.a().getString(R.string.account_verify_code_error);
                        break;
                    case 20005:
                    default:
                        string = th2.getMessage();
                        if (string == null) {
                            string = j1.a().getString(R.string.net_state_error);
                            f0.o(string, "getApp().getString(R.string.net_state_error)");
                        }
                        break;
                    case c5.d.f9759f /* 20006 */:
                        string = j1.a().getString(R.string.account_register_failed);
                        break;
                    case c5.d.f9760g /* 20007 */:
                        string = j1.a().getString(R.string.account_not_exist);
                        break;
                }
                f0.o(string, "when (it.code) {\n       …                        }");
                bVar2.f(string, true);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13225b.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.account.ui.register.j
            @Override // dj.g
            public final void accept(Object obj) {
                RegisterPresenter.h0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.account.ui.register.a.InterfaceC0129a
    public void h(@k String account, @k String password, @k String code) {
        f0.p(account, "account");
        f0.p(password, "password");
        f0.p(code, "code");
        this.f13226c.c(account, password, code).s0(o5.l.d()).c(new a());
    }
}
