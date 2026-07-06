package com.omarea.vtools.activities;

import a.b62;
import a.bc2;
import a.d72;
import a.ec2;
import a.f92;
import a.fg2;
import a.g91;
import a.h42;
import a.hz0;
import a.k82;
import a.m42;
import a.n92;
import a.oc2;
import a.pc1;
import a.qc1;
import a.qc2;
import a.qe2;
import a.r62;
import a.rc1;
import a.t61;
import a.u61;
import a.wd2;
import a.x62;
import a.xd2;
import a.yn0;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.ui.BlurViewLinearLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityModuleDetail extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8754a = hz0.f1282a.B0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5351a;

    @x62(c = "com.omarea.vtools.activities.ActivityModuleDetail$onCreate$1", f = "ActivityModuleDetail.kt", l = {57, 69}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8755a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5352a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5354a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5355b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8755a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ActivityModuleDetail.this.new a(this.f8755a, b62Var);
            aVar.f5352a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, com.omarea.model.MagiskModuleUnofficial] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            Object obj2 = this.b;
            try {
            } catch (Exception e) {
                fg2 fg2VarC = qe2.c();
                qc1 qc1Var = new qc1(this, null);
                this.f5354a = obj2;
                this.f5355b = e;
                this.b = 2;
                if (oc2.g(fg2VarC, qc1Var, this) == objC) {
                    return objC;
                }
            }
            if (obj2 == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f5352a;
                n92 n92Var = new n92();
                n92Var.f6891a = new yn0().z((String) this.f8755a.f6891a);
                fg2 fg2VarC2 = qe2.c();
                pc1 pc1Var = new pc1(this, n92Var, null);
                this.f5354a = wd2Var;
                this.f5355b = n92Var;
                this.b = 1;
                obj2 = wd2Var;
                if (oc2.g(fg2VarC2, pc1Var, this) == objC) {
                    return objC;
                }
            } else {
                if (obj2 != 1) {
                    if (obj2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                    return m42.f6769a;
                }
                wd2 wd2Var2 = (wd2) this.f5354a;
                h42.b(obj);
                obj2 = wd2Var2;
            }
            return m42.f6769a;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8756a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MagiskModuleUnofficial f5356a;

        public b(MagiskModuleUnofficial magiskModuleUnofficial, Context context) {
            this.f5356a = magiskModuleUnofficial;
            this.f8756a = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!bc2.x(this.f5356a.getDownloadUrl(), "http", false, 2, null)) {
                Toast.makeText(this.f8756a, "Scene无法识别下载地址", 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5356a.getDownloadUrl()));
            this.f8756a.startActivity(intent);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8757a;

        public c(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8757a = magiskModuleUnofficial;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityModuleDetail activityModuleDetail = ActivityModuleDetail.this;
            String dbId = this.f8757a.getDbId();
            f92.b(dbId);
            activityModuleDetail.n(5, dbId);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8758a;

        public d(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8758a = magiskModuleUnofficial;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityModuleDetail activityModuleDetail = ActivityModuleDetail.this;
            String dbId = this.f8758a.getDbId();
            f92.b(dbId);
            activityModuleDetail.n(1, dbId);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityModuleDetail$rankSend$1", f = "ActivityModuleDetail.kt", l = {}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8759a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5360a;
        public int b;
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, int i, b62 b62Var) {
            super(2, b62Var);
            this.f5360a = str;
            this.c = i;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = ActivityModuleDetail.this.new e(this.f5360a, this.c, b62Var);
            eVar.f8759a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            String str;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            try {
                boolean zB = new yn0().B(this.f5360a, ActivityModuleDetail.this.f8754a, this.c, "");
                Scene.c cVar = Scene.f4798a;
                if (zB) {
                    ActivityModuleDetail.this.setResult(-1);
                    str = "感谢参与评价";
                } else {
                    str = "评分失败";
                }
                Scene.c.p(cVar, str, 0, 2, null);
            } catch (Exception unused) {
                Scene.c.p(Scene.f4798a, "评分失败", 0, 2, null);
            }
            return m42.f6769a;
        }
    }

    public ActivityModuleDetail() {
        new Handler(Looper.getMainLooper());
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5351a == null) {
            this.f5351a = new HashMap();
        }
        View view = (View) this.f5351a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5351a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void m(Context context, MagiskModuleUnofficial magiskModuleUnofficial) {
        TextView textView;
        String description;
        String uid;
        String str;
        boolean z = (magiskModuleUnofficial.getUid().length() > 0) && f92.a(magiskModuleUnofficial.getUid(), hz0.f1282a.B0());
        TextView textView2 = (TextView) _$_findCachedViewById(t61.module_id);
        f92.c(textView2, "module_id");
        textView2.setText(magiskModuleUnofficial.getId());
        TextView textView3 = (TextView) _$_findCachedViewById(t61.module_name);
        f92.c(textView3, "module_name");
        textView3.setText(magiskModuleUnofficial.getName());
        TextView textView4 = (TextView) _$_findCachedViewById(t61.module_author);
        f92.c(textView4, "module_author");
        textView4.setText(magiskModuleUnofficial.getAuthor());
        TextView textView5 = (TextView) _$_findCachedViewById(t61.module_version_name);
        f92.c(textView5, "module_version_name");
        textView5.setText(magiskModuleUnofficial.getVersionName());
        TextView textView6 = (TextView) _$_findCachedViewById(t61.module_version_code);
        f92.c(textView6, "module_version_code");
        textView6.setText(magiskModuleUnofficial.getVersionCode());
        TextView textView7 = (TextView) _$_findCachedViewById(t61.module_download_url);
        f92.c(textView7, "module_download_url");
        textView7.setText(magiskModuleUnofficial.getDownloadUrl());
        if (magiskModuleUnofficial.getDetailContent().length() > 0) {
            textView = (TextView) _$_findCachedViewById(t61.module_description);
            f92.c(textView, "module_description");
            description = magiskModuleUnofficial.getDetailContent();
        } else {
            textView = (TextView) _$_findCachedViewById(t61.module_description);
            f92.c(textView, "module_description");
            description = magiskModuleUnofficial.getDescription();
        }
        textView.setText(description);
        if (ec2.C(magiskModuleUnofficial.getUid(), "@", false, 2, null)) {
            String uid2 = magiskModuleUnofficial.getUid();
            int iN = ec2.N(magiskModuleUnofficial.getUid(), "@", 0, false, 6, null);
            if (uid2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            uid = uid2.substring(0, iN);
            f92.c(uid, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            uid = magiskModuleUnofficial.getUid();
        }
        if (f92.a(magiskModuleUnofficial.getSource(), "official")) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.module_warn);
            f92.c(blurViewLinearLayout, "module_warn");
            blurViewLinearLayout.setVisibility(8);
            str = "★";
        } else {
            str = "";
        }
        TextView textView8 = (TextView) _$_findCachedViewById(t61.module_uid);
        f92.c(textView8, "module_uid");
        textView8.setText(str + uid);
        TextView textView9 = (TextView) _$_findCachedViewById(t61.module_like_count);
        f92.c(textView9, "module_like_count");
        textView9.setText(String.valueOf(magiskModuleUnofficial.getLike()));
        TextView textView10 = (TextView) _$_findCachedViewById(t61.module_dislike_count);
        f92.c(textView10, "module_dislike_count");
        textView10.setText(String.valueOf(magiskModuleUnofficial.getDislike()));
        ((ImageButton) _$_findCachedViewById(t61.module_download)).setOnClickListener(new b(magiskModuleUnofficial, context));
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.module_edit);
        imageView.setVisibility(z ? 0 : 8);
        if (z) {
            imageView.setOnClickListener(new rc1(this, z, magiskModuleUnofficial));
        }
        ((ImageView) _$_findCachedViewById(t61.module_like)).setOnClickListener(new c(magiskModuleUnofficial));
        ((ImageView) _$_findCachedViewById(t61.module_dislike)).setOnClickListener(new d(magiskModuleUnofficial));
    }

    public final void n(int i, String str) {
        String str2 = this.f8754a;
        if (str2 == null || str2.length() == 0) {
            Scene.c.p(Scene.f4798a, "暂不支持非会员提交用户评分", 0, 2, null);
        } else {
            qc2.d(xd2.a(qe2.b()), null, null, new e(str, i, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Object, java.lang.String] */
    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558468);
        setBackArrow();
        String str = this.f8754a;
        if (str == null || str.length() == 0) {
            Toast.makeText(this, getString(u61.module_login_required), 0).show();
            finishAfterTransition();
        }
        n92 n92Var = new n92();
        n92Var.f6891a = "";
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("id")) {
            ?? stringExtra = getIntent().getStringExtra("id");
            f92.b(stringExtra);
            n92Var.f6891a = stringExtra;
        }
        if (((String) n92Var.f6891a).length() > 0) {
            qc2.d(xd2.a(qe2.b()), null, null, new a(n92Var, null), 3, null);
        } else {
            finishAfterTransition();
        }
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_module_upload));
    }
}
