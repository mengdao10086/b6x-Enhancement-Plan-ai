package a5;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FZUserAccount;
import o5.l;
import o5.m;
import xi.b0;
import xi.c0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f256c = "account_uid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f257d = "account_username";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f258e = "account_sign";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f259f = "account_token";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f260g = "account_regdate";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f261h = "account_avatar";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f262i = "account_phone";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f263j = "account_group_id";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FZUserAccount f264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f265b;

    public class a extends m5.a<FZUserAccount> {
        public a() {
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            n.a("获取账户成功！！！" + f.this.f264a.toString());
        }
    }

    public class b extends m5.a<FZUserAccount> {
        public b() {
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            f fVar = f.this;
            fVar.v(fVar.f264a, true);
        }
    }

    public class c extends m5.a<Object> {
        public c() {
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            f fVar = f.this;
            fVar.v(fVar.f264a, false);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f269a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f i() {
        return d.f269a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(b0 b0Var) throws Exception {
        b0Var.onNext(g());
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(b0 b0Var) throws Exception {
        f();
        b0Var.onNext(new Object());
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(b0 b0Var) throws Exception {
        w(this.f264a);
        b0Var.onComplete();
    }

    public final void f() {
        m.k(DataConstant.SP_ACCOUNT).b(false);
    }

    public final FZUserAccount g() {
        FZUserAccount fZUserAccount = new FZUserAccount();
        this.f264a = fZUserAccount;
        fZUserAccount.uid = this.f265b.q(f256c);
        this.f264a.username = this.f265b.q(f257d);
        this.f264a.sign = this.f265b.q(f258e);
        this.f264a.regdate = this.f265b.q(f260g);
        this.f264a.avatar = this.f265b.q(f261h);
        this.f264a.token = this.f265b.q(f259f);
        this.f264a.phone = this.f265b.q(f262i);
        this.f264a.groupid = this.f265b.q(f263j);
        return this.f264a;
    }

    public FZUserAccount h() {
        return this.f264a;
    }

    public String j() {
        FZUserAccount fZUserAccount = this.f264a;
        return fZUserAccount == null ? "" : d1.l(fZUserAccount.phone);
    }

    public String k() {
        FZUserAccount fZUserAccount = this.f264a;
        return fZUserAccount == null ? "" : d1.l(fZUserAccount.token);
    }

    public String l() {
        FZUserAccount fZUserAccount = this.f264a;
        return fZUserAccount == null ? "" : d1.l(fZUserAccount.uid);
    }

    @SuppressLint({"CheckResult"})
    public final void m() {
        z.r1(new c0() { // from class: a5.d
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f254a.q(b0Var);
            }
        }).s0(m5.c0.t()).s0(l.d()).c(new a());
    }

    public boolean n() {
        FZUserAccount fZUserAccount = this.f264a;
        return fZUserAccount != null && n0.b(fZUserAccount.groupid, "2");
    }

    public boolean o() {
        FZUserAccount fZUserAccount = this.f264a;
        return (fZUserAccount == null || d1.g(fZUserAccount.uid)) ? false : true;
    }

    public boolean p() {
        FZUserAccount fZUserAccount = this.f264a;
        return fZUserAccount != null && n0.b(fZUserAccount.groupid, "3");
    }

    @SuppressLint({"CheckResult"})
    public void t() {
        this.f264a = new FZUserAccount();
        z.r1(new c0() { // from class: a5.c
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f253a.r(b0Var);
            }
        }).s0(l.d()).s0(m5.c0.t()).c(new c());
    }

    @SuppressLint({"CheckResult"})
    public void u(FZUserAccount fzUserAccount) {
        if (fzUserAccount == null || !fzUserAccount.isValid()) {
            n.a("账户类型不合法，保存失败");
        } else {
            this.f264a = fzUserAccount;
            z.r1(new c0() { // from class: a5.e
                @Override // xi.c0
                public final void a(b0 b0Var) throws Exception {
                    this.f255a.s(b0Var);
                }
            }).s0(l.d()).c(new b());
        }
    }

    public final void v(FZUserAccount account, boolean isLogin) {
        Intent intent = new Intent();
        intent.setAction(DataConstant.BROADCAST_RECEIVER_ACTION_LOGIN_STATUS);
        intent.putExtra(DataConstant.EXTRA_KEY_LOGIN_STATUS, isLogin);
        intent.putExtra(DataConstant.EXTRA_KEY_LOGIN_ACCOUNT, account);
        j1.a().sendBroadcast(intent);
    }

    public final void w(FZUserAccount fzUserAccount) {
        this.f265b.C(f256c, fzUserAccount.uid, false);
        this.f265b.C(f257d, fzUserAccount.username, false);
        this.f265b.C(f258e, fzUserAccount.sign, false);
        this.f265b.C(f260g, fzUserAccount.regdate, false);
        this.f265b.C(f261h, fzUserAccount.avatar, false);
        this.f265b.C(f259f, fzUserAccount.token, false);
        this.f265b.C(f262i, fzUserAccount.phone, false);
        this.f265b.C(f263j, fzUserAccount.groupid, false);
    }

    public void x(FZUserAccount mUserAccount) {
        this.f264a = mUserAccount;
    }

    public void y(String groupId) {
        FZUserAccount fZUserAccount = this.f264a;
        fZUserAccount.groupid = groupId;
        w(fZUserAccount);
    }

    public f() {
        this.f264a = new FZUserAccount();
        this.f265b = m.k(DataConstant.SP_ACCOUNT);
        m();
    }
}
