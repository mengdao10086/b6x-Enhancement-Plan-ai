package com.flydigi.account.ui.reset;

import com.blankj.utilcode.util.j1;
import com.flydigi.account.R;
import com.flydigi.account.ui.reset.a;
import com.flydigi.base.net.ApiException;
import com.flydigi.data.LoginBaseResponse;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public final class ResetPasswordPresenter implements a.InterfaceC0131a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a.b f13245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f13246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final c5.a f13247c;

    public ResetPasswordPresenter(@yt.k a.b mView) {
        f0.p(mView, "mView");
        this.f13245a = mView;
        this.f13246b = new io.reactivex.disposables.a();
        this.f13247c = new c5.a();
    }

    public static final void i0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void k0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.account.ui.reset.a.InterfaceC0131a
    public void c(@yt.k String account) {
        f0.p(account, "account");
        z zVarS0 = this.f13247c.b(account).s0(c0.t()).s0(o5.l.d());
        final ik.l<LoginBaseResponse<?>, z1> lVar = new ik.l<LoginBaseResponse<?>, z1>() { // from class: com.flydigi.account.ui.reset.ResetPasswordPresenter$getVerifyCode$1
            {
                super(1);
            }

            public final void b(LoginBaseResponse<?> loginBaseResponse) {
                this.this$0.f13245a.k();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LoginBaseResponse<?> loginBaseResponse) {
                b(loginBaseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.account.ui.reset.k
            @Override // dj.g
            public final void accept(Object obj) {
                ResetPasswordPresenter.i0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.reset.ResetPasswordPresenter$getVerifyCode$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                String string;
                if (!(th2 instanceof ApiException)) {
                    a.b bVar = this.this$0.f13245a;
                    String message = th2.getMessage();
                    if (message == null) {
                        message = j1.a().getString(R.string.net_state_error);
                        f0.o(message, "getApp().getString(R.string.net_state_error)");
                    }
                    bVar.f(message, true);
                    return;
                }
                a.b bVar2 = this.this$0.f13245a;
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
        this.f13246b.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.account.ui.reset.l
            @Override // dj.g
            public final void accept(Object obj) {
                ResetPasswordPresenter.j0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.account.ui.reset.a.InterfaceC0131a
    public void m(@yt.k String account, @yt.k String password, @yt.k String code) {
        f0.p(account, "account");
        f0.p(password, "password");
        f0.p(code, "code");
        z zVarS0 = this.f13247c.d(account, password, code).s0(c0.t()).s0(o5.l.d());
        final ik.l<LoginBaseResponse<?>, z1> lVar = new ik.l<LoginBaseResponse<?>, z1>() { // from class: com.flydigi.account.ui.reset.ResetPasswordPresenter$resetPassword$1
            {
                super(1);
            }

            public final void b(LoginBaseResponse<?> loginBaseResponse) {
                this.this$0.f13245a.Y1();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LoginBaseResponse<?> loginBaseResponse) {
                b(loginBaseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.account.ui.reset.j
            @Override // dj.g
            public final void accept(Object obj) {
                ResetPasswordPresenter.k0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.reset.ResetPasswordPresenter$resetPassword$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                String string;
                if (!(th2 instanceof ApiException)) {
                    a.b bVar = this.this$0.f13245a;
                    String message = th2.getMessage();
                    if (message == null) {
                        message = j1.a().getString(R.string.net_state_error);
                        f0.o(message, "getApp().getString(R.string.net_state_error)");
                    }
                    bVar.f(message, true);
                    return;
                }
                a.b bVar2 = this.this$0.f13245a;
                switch (((ApiException) th2).a()) {
                    case c5.d.f9755b /* 20001 */:
                        string = j1.a().getString(R.string.account_phone_number_not_valid);
                        break;
                    case c5.d.f9756c /* 20002 */:
                        string = j1.a().getString(R.string.account_was_exist);
                        break;
                    case c5.d.f9757d /* 20003 */:
                    case 20005:
                    default:
                        string = th2.getMessage();
                        if (string == null) {
                            string = j1.a().getString(R.string.net_state_error);
                            f0.o(string, "getApp().getString(R.string.net_state_error)");
                        }
                        break;
                    case c5.d.f9758e /* 20004 */:
                        string = j1.a().getString(R.string.account_verify_code_error);
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
        this.f13246b.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.account.ui.reset.i
            @Override // dj.g
            public final void accept(Object obj) {
                ResetPasswordPresenter.l0(lVar2, obj);
            }
        }));
    }
}
