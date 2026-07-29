package com.flydigi.account.ui.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ThreadUtils;
import com.flydigi.account.R;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.data.LoginBaseResponse;
import com.flydigi.data.bean.CommunityImageYouPaiYunBean;
import com.flydigi.data.bean.FZUserAccount;
import f.b;
import hd.w;
import i9.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m5.c0;
import okhttp3.d0;
import okhttp3.e0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public final class ProfileNewActivity extends com.flydigi.base.common.p {

    @yt.k
    public static final a F7 = new a(null);
    public static final int G7 = 3;
    public static final int H7 = 4;
    public static final int I7 = 5;

    @yt.k
    public final androidx.activity.result.g<Intent> E7;
    public d5.d K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        public final void a(@yt.k Context context) {
            f0.p(context, "context");
            context.startActivity(new Intent(context, (Class<?>) ProfileNewActivity.class));
        }
    }

    public static final class b extends ThreadUtils.d<Boolean> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ e0 f13260o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ ProfileNewActivity f13261p;

        public b(e0 e0Var, ProfileNewActivity profileNewActivity) {
            this.f13260o = e0Var;
            this.f13261p = profileNewActivity;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public /* bridge */ /* synthetic */ void l(Object obj) {
            r(((Boolean) obj).booleanValue());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @yt.k
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            boolean z10;
            try {
                Object objH = com.blankj.utilcode.util.e0.h(this.f13260o.string(), CommunityImageYouPaiYunBean.class);
                f0.o(objH, "fromJson(\n              …                        )");
                CommunityImageYouPaiYunBean communityImageYouPaiYunBean = (CommunityImageYouPaiYunBean) objH;
                if (communityImageYouPaiYunBean.getCode() == 200) {
                    this.f13261p.z4(DataConstant.UPYUN_COMMUNITY_URI + communityImageYouPaiYunBean.getUrl());
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            } catch (IOException unused) {
                return Boolean.FALSE;
            }
        }

        public void r(boolean z10) {
            if (z10) {
                return;
            }
            com.flydigi.base.common.o.E(this.f13261p.getString(R.string.account_upload_failed));
        }
    }

    public ProfileNewActivity() {
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.account.ui.user.m
            @Override // androidx.activity.result.a
            public final void a(Object obj) throws FileNotFoundException {
                ProfileNewActivity.J4(this.f13277a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.E7 = gVarP1;
    }

    public static final void A4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void B4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void E4(ProfileNewActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (a5.f.i().o()) {
            this$0.L4();
        }
    }

    public static final void F4(ProfileNewActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (a5.f.i().o()) {
            com.blankj.utilcode.util.a.S0(this$0, NicknameEditActivity.j4(this$0), 3);
        }
    }

    public static final void G4(ProfileNewActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (a5.f.i().o()) {
            h3.a.j().d(a.C0378a.f31909f).navigation(this$0);
        }
    }

    public static final void H4(ProfileNewActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.M4();
    }

    public static final void I4(ProfileNewActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (a5.f.i().o()) {
            h3.a.j().d(a.C0378a.f31907d).navigation(this$0, 4);
        }
    }

    public static final void J4(ProfileNewActivity this$0, ActivityResult activityResult) throws FileNotFoundException {
        Intent intentA;
        Uri data;
        f0.p(this$0, "this$0");
        if (activityResult.b() != -1 || (intentA = activityResult.a()) == null || (data = intentA.getData()) == null) {
            return;
        }
        r.a(data, this$0);
    }

    @hk.m
    public static final void K4(@yt.k Context context) {
        F7.a(context);
    }

    public static final void N4(DialogFragment obj) {
        f0.p(obj, "obj");
        obj.I5();
    }

    public static final void O4(final ProfileNewActivity this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        z zVarS0 = ((c5.b) m5.f0.i().k().g(c5.b.class)).n().s0(c0.r()).s0(c0.t()).s0(o5.l.d()).s0(this$0.y1());
        final ik.l<BaseResponse<Object>, z1> lVar = new ik.l<BaseResponse<Object>, z1>() { // from class: com.flydigi.account.ui.user.ProfileNewActivity$showExitDialog$dialog$2$1
            {
                super(1);
            }

            public final void b(BaseResponse<Object> baseResponse) {
                a5.f.i().t();
                this.this$0.finish();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<Object> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.account.ui.user.f
            @Override // dj.g
            public final void accept(Object obj) {
                ProfileNewActivity.P4(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.user.ProfileNewActivity$showExitDialog$dialog$2$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                a5.f.i().t();
                this.this$0.finish();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.account.ui.user.p
            @Override // dj.g
            public final void accept(Object obj) {
                ProfileNewActivity.Q4(lVar2, obj);
            }
        });
    }

    public static final void P4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void Q4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void S4(ProfileNewActivity this$0, boolean z10, d0 d0Var, Exception exc) {
        e0 e0VarL;
        f0.p(this$0, "this$0");
        if (!z10) {
            com.flydigi.base.common.o.E(this$0.getString(R.string.account_upload_failed));
        } else {
            if (d0Var == null || (e0VarL = d0Var.L()) == null) {
                return;
            }
            ThreadUtils.U(new b(e0VarL, this$0));
        }
    }

    public final void C4(FZUserAccount fZUserAccount) {
        com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.H(this).t(fZUserAccount.avatar);
        int i10 = R.drawable.main_ic_default_avatar;
        com.bumptech.glide.h hVarO0 = hVarT.E0(i10).x(i10).g().O0(true);
        d5.d dVar = this.K2;
        d5.d dVar2 = null;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        hVarO0.s1(dVar.f26027c);
        d5.d dVar3 = this.K2;
        if (dVar3 == null) {
            f0.S("viewBinding");
        } else {
            dVar2 = dVar3;
        }
        dVar2.f26030f.Q(fZUserAccount.username);
    }

    public final void D4() {
        d5.d dVar = this.K2;
        d5.d dVar2 = null;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        com.blankj.utilcode.util.o.r(dVar.f26028d, new View.OnClickListener() { // from class: com.flydigi.account.ui.user.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNewActivity.E4(this.f13269a, view);
            }
        });
        d5.d dVar3 = this.K2;
        if (dVar3 == null) {
            f0.S("viewBinding");
            dVar3 = null;
        }
        com.blankj.utilcode.util.o.r(dVar3.f26030f, new View.OnClickListener() { // from class: com.flydigi.account.ui.user.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNewActivity.F4(this.f13275a, view);
            }
        });
        d5.d dVar4 = this.K2;
        if (dVar4 == null) {
            f0.S("viewBinding");
            dVar4 = null;
        }
        com.blankj.utilcode.util.o.r(dVar4.f26029e, new View.OnClickListener() { // from class: com.flydigi.account.ui.user.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNewActivity.G4(this.f13273a, view);
            }
        });
        d5.d dVar5 = this.K2;
        if (dVar5 == null) {
            f0.S("viewBinding");
            dVar5 = null;
        }
        com.blankj.utilcode.util.o.r(dVar5.f26031g, new View.OnClickListener() { // from class: com.flydigi.account.ui.user.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNewActivity.H4(this.f13274a, view);
            }
        });
        d5.d dVar6 = this.K2;
        if (dVar6 == null) {
            f0.S("viewBinding");
        } else {
            dVar2 = dVar6;
        }
        com.blankj.utilcode.util.o.r(dVar2.f26026b, new View.OnClickListener() { // from class: com.flydigi.account.ui.user.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNewActivity.I4(this.f13276a, view);
            }
        });
    }

    public final void L4() {
        com.github.drjacky.imagepicker.b.f16526a.d(this).l(new String[]{"image/png", "image/jpg", w.C0}).f(new ik.l<Intent, z1>() { // from class: com.flydigi.account.ui.user.ProfileNewActivity$openPhoto$1
            {
                super(1);
            }

            public final void b(@yt.k Intent it2) {
                f0.p(it2, "it");
                this.this$0.E7.b(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Intent intent) {
                b(intent);
                return z1.f38230a;
            }
        });
    }

    public final void M4() {
        Fragment fragmentB = com.blankj.utilcode.util.d0.B(n3(), "exit");
        if (fragmentB != null) {
            com.blankj.utilcode.util.d0.c0(fragmentB);
        }
        FZDialog.a aVar = new FZDialog.a();
        int i10 = R.string.account_logout;
        aVar.t(getString(i10)).j(getString(R.string.account_logout_notice)).g(getString(i10)).d(getString(R.string.cancel)).b(Boolean.FALSE).c(new FZDialog.c() { // from class: com.flydigi.account.ui.user.o
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ProfileNewActivity.N4(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: com.flydigi.account.ui.user.n
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ProfileNewActivity.O4(this.f13278a, dialogFragment);
            }
        }).a().Z5(n3(), "exit");
    }

    public final void R4(File file) {
        u9.k.e(file, DataConstant.UPYUN_COMMUNITY_BUCKET, new gh.b() { // from class: com.flydigi.account.ui.user.h
            @Override // gh.b
            public final void a(boolean z10, d0 d0Var, Exception exc) {
                ProfileNewActivity.S4(this.f13272a, z10, d0Var, exc);
            }
        }, null);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.account_fragment_profile;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @yt.l Intent intent) throws FileNotFoundException {
        Uri data;
        Uri uri;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1) {
            if (i10 == 3) {
                FZUserAccount fZUserAccountH = a5.f.i().h();
                f0.o(fZUserAccountH, "getInstance().fzUserAccount");
                C4(fZUserAccountH);
                return;
            }
            if (i10 == 4) {
                finish();
                return;
            }
            if (i10 == 5) {
                if (intent == null || (data = intent.getData()) == null) {
                    return;
                }
                f0.o(data, "data");
                r.a(data, this);
                return;
            }
            if (i10 != 69 || intent == null || (uri = com.yalantis.ucrop.a.e(intent)) == null) {
                return;
            }
            f0.o(uri, "uri");
            R4(u0.f.a(uri));
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.account_personal_information);
        D4();
        FZUserAccount fZUserAccountH = a5.f.i().h();
        f0.o(fZUserAccountH, "getInstance().fzUserAccount");
        C4(fZUserAccountH);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        d5.d dVarC = d5.d.c(getLayoutInflater());
        f0.o(dVarC, "inflate(layoutInflater)");
        this.K2 = dVarC;
        if (dVarC == null) {
            f0.S("viewBinding");
            dVarC = null;
        }
        setContentView(dVarC.getRoot());
    }

    public final void z4(final String str) {
        z zVarS0 = ((c5.b) m5.f0.i().k().g(c5.b.class)).r(a5.f.i().l(), "3", str).s0(c0.q()).s0(c0.t()).s0(o5.l.d()).s0(y1());
        final ik.l<LoginBaseResponse<Object>, z1> lVar = new ik.l<LoginBaseResponse<Object>, z1>() { // from class: com.flydigi.account.ui.user.ProfileNewActivity$httpSetAvatar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LoginBaseResponse<Object> loginBaseResponse) {
                FZUserAccount fzUserAccount = a5.f.i().h();
                fzUserAccount.avatar = str;
                a5.f.i().u(fzUserAccount);
                ProfileNewActivity profileNewActivity = this;
                f0.o(fzUserAccount, "fzUserAccount");
                profileNewActivity.C4(fzUserAccount);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LoginBaseResponse<Object> loginBaseResponse) {
                b(loginBaseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.account.ui.user.g
            @Override // dj.g
            public final void accept(Object obj) {
                ProfileNewActivity.A4(lVar, obj);
            }
        };
        final ProfileNewActivity$httpSetAvatar$2 profileNewActivity$httpSetAvatar$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.user.ProfileNewActivity$httpSetAvatar$2
            public final void b(@yt.k Throwable throwable) {
                f0.p(throwable, "throwable");
                String message = throwable.getMessage();
                f0.m(message);
                com.flydigi.base.common.o.E(message);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.account.ui.user.q
            @Override // dj.g
            public final void accept(Object obj) {
                ProfileNewActivity.B4(profileNewActivity$httpSetAvatar$2, obj);
            }
        });
    }
}
