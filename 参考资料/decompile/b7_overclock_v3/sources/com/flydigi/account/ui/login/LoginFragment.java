package com.flydigi.account.ui.login;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.i0;
import com.blankj.utilcode.util.r0;
import com.flydigi.account.R;
import com.flydigi.account.ui.login.LoginFragment;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.o;
import com.flydigi.data.DataConstant;
import com.flydigi.data.LoginBaseResponse;
import com.flydigi.data.bean.FZUserAccount;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import g.p0;
import g.v;
import i9.a;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m5.c0;
import m5.f0;
import o5.p;
import p5.t;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class LoginFragment extends FZFragment {
    public io.reactivex.disposables.b A8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public d5.c f13182p8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public String f13184r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public String f13185s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public EditText f13186t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public EditText f13187u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public TextView f13188v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public Button f13189w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public ImageView f13190x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public ImageButton f13191y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public Dialog f13192z8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f13181o8 = false;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f13183q8 = false;

    public class a extends t {
        public a() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.l7(loginFragment.f13186t8, R.drawable.account_ic_phone_black);
            } else {
                LoginFragment loginFragment2 = LoginFragment.this;
                loginFragment2.l7(loginFragment2.f13186t8, R.drawable.account_ic_phone_gray);
            }
        }
    }

    public class b extends t {
        public b() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.l7(loginFragment.f13187u8, R.drawable.account_ic_system_code_black);
            } else {
                LoginFragment loginFragment2 = LoginFragment.this;
                loginFragment2.l7(loginFragment2.f13187u8, R.drawable.account_ic_system_code_gray);
            }
        }
    }

    public class c extends c5.c<LoginBaseResponse<FZUserAccount>> {
        public c() {
        }

        @Override // c5.c
        public void a(String str, int i10) {
            LoginFragment.this.E0();
            o.E(str);
        }

        @Override // c5.c
        public void d(LoginBaseResponse<FZUserAccount> loginBaseResponse) {
            if (loginBaseResponse.data != null) {
                com.flydigi.base.common.n.a(getClass().getSimpleName() + i0.f11861z + loginBaseResponse.data);
                a5.f.i().u(loginBaseResponse.data);
                LoginFragment.this.f13317d8.finish();
            } else {
                o.w(LoginFragment.this.c3(R.string.api_error_notice));
            }
            if (LoginFragment.this.f13192z8 != null) {
                LoginFragment.this.f13192z8.dismiss();
            }
            LoginFragment.this.E0();
        }
    }

    public class d extends c5.c<LoginBaseResponse> {
        public d() {
        }

        @Override // c5.c
        public void a(String str, int i10) {
            LoginFragment.this.o7(str);
            if (LoginFragment.this.A8 == null || LoginFragment.this.A8.isDisposed()) {
                return;
            }
            LoginFragment.this.A8.dispose();
            LoginFragment.this.k7();
        }

        @Override // c5.c
        public void d(LoginBaseResponse loginBaseResponse) {
        }
    }

    public class e extends m5.a<Long> {
        public e() {
        }

        @Override // m5.a, xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long l10) {
            LoginFragment.this.f13188v8.setClickable(false);
            LoginFragment.this.f13188v8.setText(String.format(LoginFragment.this.f13317d8.getString(R.string.account_countdown_simple), l10));
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            LoginFragment.this.k7();
        }

        @Override // m5.a, xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            super.onSubscribe(bVar);
            LoginFragment.this.A8 = bVar;
        }
    }

    public class f extends t {
        public f() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                LoginFragment.this.f13182p8.f26016h.setVisibility(0);
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.l7(loginFragment.f13182p8.f26014f, R.drawable.account_ic_account_black);
            } else {
                LoginFragment.this.f13182p8.f26016h.setVisibility(8);
            }
            LoginFragment.this.M6();
        }
    }

    public class g extends t {
        public g() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                LoginFragment.this.f13182p8.f26017i.setVisibility(0);
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.l7(loginFragment.f13182p8.f26015g, R.drawable.account_ic_password_black);
            } else {
                LoginFragment.this.f13182p8.f26017i.setVisibility(8);
            }
            LoginFragment.this.M6();
        }
    }

    public class h extends ClickableSpan {
        public h() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=818&hideTop=1" : "https://bbs.flydigi.com/reads/1035&hideTop=1").withString(DataConstant.WEB_TITLE, LoginFragment.this.c3(R.string.account_title_user_agreement)).navigation();
        }
    }

    public class i extends ClickableSpan {
        public i() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=1008&hideTop=1" : "https://bbs.flydigi.com/reads/1034&hideTop=1").withString(DataConstant.WEB_TITLE, LoginFragment.this.c3(R.string.account_title_privacy_policy)).navigation();
        }
    }

    public class j extends c5.c<LoginBaseResponse<FZUserAccount>> {
        public j() {
        }

        @Override // c5.c
        public void a(String str, int i10) {
            LoginFragment.this.f13183q8 = false;
            LoginFragment.this.o7(str);
            LoginFragment.this.M6();
        }

        @Override // c5.c
        public void d(LoginBaseResponse<FZUserAccount> loginBaseResponse) {
            FZUserAccount fZUserAccount = loginBaseResponse.data;
            if (fZUserAccount == null || TextUtils.isEmpty(fZUserAccount.uid)) {
                LoginFragment.this.M6();
                LoginFragment.this.f13183q8 = false;
                o.w(LoginFragment.this.c3(R.string.api_error_notice));
            } else {
                a5.f.i().u(loginBaseResponse.data);
                LoginFragment.this.f13317d8.setResult(-1);
                LoginFragment.this.f13317d8.finish();
            }
        }
    }

    public class k implements UMAuthListener {
        public k() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA share_media, int i10) {
            LoginFragment.this.E0();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA share_media, int i10, Map<String, String> map) {
            String str = map.get("openid");
            String str2 = map.get(UMSSOHandler.GENDER);
            String str3 = map.get("name");
            String str4 = map.get(UMSSOHandler.ICON);
            String str5 = map.get(UMSSOHandler.PROVINCE);
            String str6 = map.get(UMSSOHandler.CITY);
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.f13184r8 = loginFragment.q7(str, str2, str3, str4, str5, str6);
            LoginFragment.this.h7();
            LoginFragment.this.E0();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA share_media, int i10, Throwable th2) {
            LoginFragment.this.E0();
            o.E(LoginFragment.this.f13317d8.getString(R.string.account_login_failed));
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA share_media) {
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.x(loginFragment.c3(R.string.account_please_wait_login), true);
        }
    }

    public class l implements UMAuthListener {
        public l() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA share_media, int i10) {
            LoginFragment.this.E0();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA share_media, int i10, Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(entry.getKey());
                sb2.append(ag.c.f654g);
                sb2.append(entry.getValue());
            }
            String str = map.get("openid");
            String str2 = map.get(UMSSOHandler.GENDER);
            String str3 = map.get("name");
            String str4 = map.get(UMSSOHandler.ICON);
            String str5 = map.get(UMSSOHandler.PROVINCE);
            String str6 = map.get(UMSSOHandler.CITY);
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.f13184r8 = loginFragment.q7(str, str2, str3, str4, str5, str6);
            LoginFragment.this.h7();
            LoginFragment.this.E0();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA share_media, int i10, Throwable th2) {
            LoginFragment.this.E0();
            o.E(LoginFragment.this.f13317d8.getString(R.string.account_login_failed));
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA share_media) {
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.x(loginFragment.c3(R.string.account_please_wait_login), true);
        }
    }

    public class m extends c5.c<LoginBaseResponse<FZUserAccount>> {
        public m() {
        }

        @Override // c5.c
        public void a(String str, int i10) {
            o.E(str);
        }

        @Override // c5.c
        public void c(boolean z10) {
        }

        @Override // c5.c
        public void d(LoginBaseResponse<FZUserAccount> loginBaseResponse) {
            FZUserAccount fZUserAccount = loginBaseResponse.data;
            if (fZUserAccount == null) {
                o.w(LoginFragment.this.c3(R.string.api_error_notice));
                return;
            }
            FZUserAccount fZUserAccount2 = fZUserAccount;
            if (TextUtils.isEmpty(fZUserAccount2.uid) || fZUserAccount2.uid.equals("0")) {
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.m7(loginFragment.f13317d8);
            } else {
                a5.f.i().u(loginBaseResponse.data);
                LoginFragment.this.f13317d8.finish();
            }
        }
    }

    public class n extends t {
        public n() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.l7(loginFragment.f13186t8, R.drawable.account_ic_phone_black);
                LoginFragment.this.f13191y8.setVisibility(0);
                LoginFragment.this.f13188v8.setEnabled(true);
                return;
            }
            LoginFragment loginFragment2 = LoginFragment.this;
            loginFragment2.l7(loginFragment2.f13186t8, R.drawable.account_ic_phone_gray);
            LoginFragment.this.f13191y8.setVisibility(8);
            LoginFragment.this.f13188v8.setEnabled(false);
        }
    }

    public static LoginFragment N6() {
        return new LoginFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R6(io.reactivex.disposables.b bVar) throws Exception {
        KeyboardUtils.j(P4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S6(View view) {
        g7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T6(View view) {
        i7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U6(View view) {
        this.f13182p8.f26014f.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V6(View view) {
        this.f13182p8.f26015g.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W6(View view) {
        if (this.f13181o8) {
            this.f13182p8.f26019k.setImageResource(R.drawable.account_ic_password_visible);
            this.f13182p8.f26015g.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f13182p8.f26019k.setImageResource(R.drawable.account_ic_password_invisible);
            this.f13182p8.f26015g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        this.f13181o8 = !this.f13181o8;
        EditText editText = this.f13182p8.f26015g;
        editText.setSelection(editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X6(View view) {
        h3.a.j().d(a.C0378a.f31909f).navigation(this.f13317d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y6(View view) {
        h3.a.j().d(a.C0378a.f31906c).navigation(this.f13317d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z6(View view) {
        j7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a7(View view) {
        if (this.f13192z8 != null) {
            L6();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b7(Context context, View view) {
        O6(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c7(View view) {
        Dialog dialog = this.f13192z8;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d7(View view) {
        this.f13186t8.setText("");
    }

    public static /* synthetic */ Long e7(int i10, Long l10) throws Exception {
        return Long.valueOf(((long) i10) - l10.longValue());
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.account_fragment_login;
    }

    public final void L6() {
        String strTrim = this.f13186t8.getText().toString().trim();
        if (!r0.n(strTrim)) {
            o.E(this.f13317d8.getString(R.string.account_phone_number_not_valid));
            l7(this.f13186t8, R.drawable.account_ic_phone_red);
            return;
        }
        String strTrim2 = this.f13187u8.getText().toString().trim();
        if (!d1.g(strTrim2)) {
            P6(strTrim, strTrim2);
        } else {
            o.E(c3(R.string.account_please_input_verify_code));
            l7(this.f13187u8, R.drawable.account_ic_system_code_red);
        }
    }

    public final void M6() {
        this.f13182p8.f26012d.setEnabled((d1.g(this.f13182p8.f26014f.getText().toString().trim()) || d1.g(this.f13182p8.f26015g.getText().toString().trim())) ? false : true);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @p0
    @yt.l
    public View O3(@yt.k LayoutInflater layoutInflater, @p0 @yt.l ViewGroup viewGroup, @p0 @yt.l Bundle bundle) {
        d5.c cVarD = d5.c.d(layoutInflater, viewGroup, false);
        this.f13182p8 = cVarD;
        return cVarD.getRoot();
    }

    public final void O6(Context context) {
        String strTrim = this.f13186t8.getText().toString().trim();
        if (r0.n(strTrim)) {
            p7();
            ((c5.b) f0.i().k().g(c5.b.class)).o(m5.b.d(strTrim), this.f13184r8, this.f13185s8).s0(c0.t()).s0(o5.l.d()).c(new d());
        } else {
            o7(context.getString(R.string.account_phone_number_not_valid));
            l7(this.f13186t8, R.drawable.account_ic_phone_red);
        }
    }

    public final void P6(String str, String str2) {
        ((c5.b) f0.i().k().g(c5.b.class)).s(m5.b.d(str), str2, this.f13184r8, this.f13185s8).s0(c0.t()).s0(o5.l.d()).c(new c());
    }

    public final void Q6() {
        String strC3 = c3(R.string.account_title_user_agreement);
        String strC32 = c3(R.string.account_title_privacy_policy);
        String strD3 = d3(R.string.account_user_agreement_and_policy, strC3, strC32);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strD3);
        int iIndexOf = strD3.indexOf(strC3);
        if (iIndexOf < 0) {
            iIndexOf = 8;
        }
        int length = strC3.length() + iIndexOf;
        int iIndexOf2 = strD3.indexOf(strC32);
        if (iIndexOf2 < 0) {
            iIndexOf2 = 16;
        }
        int length2 = strC32.length() + iIndexOf2;
        int i10 = R.color.colorPrimary;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.blankj.utilcode.util.t.a(i10)), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.blankj.utilcode.util.t.a(i10)), iIndexOf2, length2, 18);
        spannableStringBuilder.setSpan(new h(), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new i(), iIndexOf2, length2, 18);
        this.f13182p8.f26024p.setMovementMethod(LinkMovementMethod.getInstance());
        this.f13182p8.f26024p.setText(spannableStringBuilder);
        this.f13182p8.f26024p.setHighlightColor(0);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        E0();
    }

    public final void f7(String str, String str2) {
        if (this.f13183q8) {
            return;
        }
        this.f13183q8 = true;
        this.f13182p8.f26012d.setEnabled(false);
        ((c5.b) f0.i().k().g(c5.b.class)).q(m5.b.d(str), m5.b.c(str2), "2", "").s0(o5.l.d()).s0(c0.t()).Z1(new dj.g() { // from class: f5.d
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f27972a.R6((io.reactivex.disposables.b) obj);
            }
        }).c(new j());
    }

    public void g7() {
        if (!this.f13182p8.f26013e.isChecked()) {
            o7(d3(R.string.account_please_agree_user_policy, c3(R.string.account_title_user_agreement), c3(R.string.account_title_privacy_policy)));
            n7();
            return;
        }
        UMShareAPI uMShareAPI = UMShareAPI.get(P4());
        androidx.fragment.app.g gVarP4 = P4();
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(gVarP4, share_media)) {
            o.E(this.f13317d8.getString(R.string.account_third_qq_error));
        }
        this.f13185s8 = "1";
        UMShareAPI.get(P4()).setShareConfig(new UMShareConfig());
        UMShareAPI.get(P4()).getPlatformInfo(P4(), share_media, new l());
    }

    public final void h7() {
        ((c5.b) f0.i().k().g(c5.b.class)).p(this.f13184r8, this.f13185s8).s0(c0.t()).s0(o5.l.d()).c(new m());
    }

    public void i7() {
        if (!this.f13182p8.f26013e.isChecked()) {
            o7(d3(R.string.account_please_agree_user_policy, c3(R.string.account_title_user_agreement), c3(R.string.account_title_privacy_policy)));
            n7();
            return;
        }
        UMShareAPI uMShareAPI = UMShareAPI.get(P4());
        androidx.fragment.app.g gVarP4 = P4();
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(gVarP4, share_media)) {
            o.E(this.f13317d8.getString(R.string.account_third_wechat_error));
        }
        this.f13185s8 = "2";
        UMShareAPI.get(P4()).setShareConfig(new UMShareConfig());
        UMShareAPI.get(P4()).getPlatformInfo(P4(), share_media, new k());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        com.blankj.utilcode.util.o.r(this.f13182p8.f26018j, new View.OnClickListener() { // from class: f5.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27975a.S6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.f13182p8.f26020l, new View.OnClickListener() { // from class: f5.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27980a.T6(view2);
            }
        });
        this.f13182p8.f26014f.addTextChangedListener(new f());
        com.blankj.utilcode.util.o.r(this.f13182p8.f26016h, new View.OnClickListener() { // from class: f5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27968a.U6(view2);
            }
        });
        this.f13182p8.f26015g.addTextChangedListener(new g());
        com.blankj.utilcode.util.o.r(this.f13182p8.f26017i, new View.OnClickListener() { // from class: f5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27974a.V6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.f13182p8.f26019k, new View.OnClickListener() { // from class: f5.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27977a.W6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.f13182p8.f26022n, new View.OnClickListener() { // from class: f5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27979a.X6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.f13182p8.f26023o, new View.OnClickListener() { // from class: f5.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27978a.Y6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.f13182p8.f26012d, new View.OnClickListener() { // from class: f5.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f27982a.Z6(view2);
            }
        });
        Q6();
    }

    public final void j7() {
        String strTrim = this.f13182p8.f26014f.getText().toString().trim();
        String strTrim2 = this.f13182p8.f26015g.getText().toString().trim();
        if (this.f13182p8.f26013e.isChecked()) {
            f7(strTrim, strTrim2);
            return;
        }
        o7(d3(R.string.account_please_agree_user_policy, c3(R.string.account_title_user_agreement), c3(R.string.account_title_privacy_policy)));
        n7();
    }

    public final void k7() {
        this.f13188v8.setClickable(true);
        this.f13188v8.setText(R.string.account_get_verify_code);
    }

    public final void l7(EditText editText, @v int i10) {
        editText.setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
    }

    public void m7(final Context context) {
        e.a aVar = new e.a(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.account_dialog_bind_phone, (ViewGroup) null);
        this.f13186t8 = (EditText) viewInflate.findViewById(R.id.et_account);
        this.f13187u8 = (EditText) viewInflate.findViewById(R.id.et_verify_code);
        this.f13188v8 = (TextView) viewInflate.findViewById(R.id.tv_get_verify_code);
        this.f13189w8 = (Button) viewInflate.findViewById(R.id.btn_register);
        this.f13190x8 = (ImageView) viewInflate.findViewById(R.id.iv_close);
        this.f13191y8 = (ImageButton) viewInflate.findViewById(R.id.iv_clear_phone);
        androidx.appcompat.app.e eVarCreate = aVar.create();
        this.f13192z8 = eVarCreate;
        eVarCreate.show();
        this.f13192z8.getWindow().setContentView(viewInflate);
        this.f13192z8.getWindow().clearFlags(131072);
        this.f13186t8.addTextChangedListener(new n());
        this.f13191y8.setOnClickListener(new View.OnClickListener() { // from class: f5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f27976a.d7(view);
            }
        });
        this.f13189w8.setOnClickListener(new View.OnClickListener() { // from class: f5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f27981a.a7(view);
            }
        });
        this.f13186t8.addTextChangedListener(new a());
        this.f13187u8.addTextChangedListener(new b());
        this.f13188v8.setOnClickListener(new View.OnClickListener() { // from class: f5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f27970a.b7(context, view);
            }
        });
        this.f13190x8.setOnClickListener(new View.OnClickListener() { // from class: f5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f27969a.c7(view);
            }
        });
    }

    public final void n7() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f13182p8.f26021m, (Property<LinearLayout, Float>) View.TRANSLATION_X, 0.0f, 100.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new BounceInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.start();
    }

    public final void o7(String str) {
        o.G(str, 1, 17);
    }

    public final void p7() {
        final int i10 = 120;
        z.e3(0L, 1L, TimeUnit.SECONDS).a6(120).A3(new dj.o() { // from class: f5.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return LoginFragment.e7(i10, (Long) obj);
            }
        }).s0(c0.t()).s0(o5.l.d()).c(new e());
        this.f13327n8.b(this.A8);
    }

    public final String q7(String str, String str2, String str3, String str4, String str5, String str6) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userID", str);
        jsonObject.addProperty(UMSSOHandler.GENDER, str2);
        jsonObject.addProperty(UMTencentSSOHandler.NICKNAME, str3);
        jsonObject.addProperty("avatar", str4);
        jsonObject.addProperty(UMSSOHandler.PROVINCE, str5);
        jsonObject.addProperty(UMSSOHandler.CITY, str6);
        return new Gson().toJson((JsonElement) jsonObject);
    }
}
