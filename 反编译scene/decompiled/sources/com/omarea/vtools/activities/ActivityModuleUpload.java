package com.omarea.vtools.activities;

import a.b62;
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
import a.qc2;
import a.qe2;
import a.qi0;
import a.r62;
import a.rh0;
import a.sc1;
import a.t61;
import a.tc1;
import a.u61;
import a.u90;
import a.wd2;
import a.x62;
import a.xc1;
import a.xd2;
import a.yn0;
import a.zc1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.ui.BlurEditText;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityModuleUpload extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f8760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5361a = hz0.f1282a.B0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5362a;

    @x62(c = "com.omarea.vtools.activities.ActivityModuleUpload$onCreate$1", f = "ActivityModuleUpload.kt", l = {54, 66}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8761a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5363a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5365a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5366b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8761a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ActivityModuleUpload.this.new a(this.f8761a, b62Var);
            aVar.f5363a = (wd2) obj;
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
                tc1 tc1Var = new tc1(this, null);
                this.f5365a = obj2;
                this.f5366b = e;
                this.b = 2;
                if (oc2.g(fg2VarC, tc1Var, this) == objC) {
                    return objC;
                }
            }
            if (obj2 == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f5363a;
                n92 n92Var = new n92();
                n92Var.f6891a = new yn0().z((String) this.f8761a.f6891a);
                fg2 fg2VarC2 = qe2.c();
                sc1 sc1Var = new sc1(this, n92Var, null);
                this.f5365a = wd2Var;
                this.f5366b = n92Var;
                this.b = 1;
                obj2 = wd2Var;
                if (oc2.g(fg2VarC2, sc1Var, this) == objC) {
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
                wd2 wd2Var2 = (wd2) this.f5365a;
                h42.b(obj);
                obj2 = wd2Var2;
            }
            return m42.f6769a;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8762a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MagiskModuleUnofficial f5367a;

        public b(MagiskModuleUnofficial magiskModuleUnofficial, Context context) {
            this.f5367a = magiskModuleUnofficial;
            this.f8762a = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f5367a.getId().length() == 0) {
                Toast.makeText(this.f8762a, ActivityModuleUpload.this.getString(u61.module_id_required), 0).show();
                return;
            }
            String versionName = this.f5367a.getVersionName();
            if (versionName == null || versionName.length() == 0) {
                this.f5367a.setVersionName("1.0.0");
            }
            String versionCode = this.f5367a.getVersionCode();
            if (versionCode == null || versionCode.length() == 0) {
                this.f5367a.setVersionCode("1");
            }
            String name = this.f5367a.getName();
            if (name == null || name.length() == 0) {
                MagiskModuleUnofficial magiskModuleUnofficial = this.f5367a;
                magiskModuleUnofficial.setName(magiskModuleUnofficial.getId());
            }
            if (this.f5367a.getDownloadUrl().length() == 0) {
                Toast.makeText(this.f8762a, ActivityModuleUpload.this.getString(u61.module_download_url_required), 0).show();
                return;
            }
            this.f5367a.setUid(f92.i(ActivityModuleUpload.this.n(), ""));
            if (ActivityModuleUpload.this.f8760a == null) {
                ActivityModuleUpload.this.f8760a = new u90(ActivityModuleUpload.this, null, 2, null);
            }
            u90 u90Var = ActivityModuleUpload.this.f8760a;
            if (u90Var != null) {
                u90.e(u90Var, null, 1, null);
            }
            qc2.d(xd2.a(qe2.b()), null, null, new zc1(this, null), 3, null);
        }
    }

    public static final class c implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8763a;

        public c(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8763a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            return this.f8763a.getId();
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8763a.setId(ec2.r0(str).toString());
        }
    }

    public static final class d implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8764a;

        public d(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8764a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String name = this.f8764a.getName();
            return name != null ? name : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8764a.setName(ec2.r0(str).toString());
        }
    }

    public static final class e implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8765a;

        public e(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8765a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String author = this.f8765a.getAuthor();
            return author != null ? author : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8765a.setAuthor(ec2.r0(str).toString());
        }
    }

    public static final class f implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8766a;

        public f(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8766a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String versionName = this.f8766a.getVersionName();
            return versionName != null ? versionName : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8766a.setVersionName(ec2.r0(str).toString());
        }
    }

    public static final class g implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8767a;

        public g(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8767a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String versionCode = this.f8767a.getVersionCode();
            return versionCode != null ? versionCode : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8767a.setVersionCode(ec2.r0(str).toString());
        }
    }

    public static final class h implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8768a;

        public h(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8768a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String downloadUrl = this.f8768a.getDownloadUrl();
            return downloadUrl != null ? downloadUrl : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8768a.setDownloadUrl(ec2.r0(str).toString());
        }
    }

    public static final class i implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8769a;

        public i(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8769a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String description = this.f8769a.getDescription();
            return description != null ? description : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8769a.setDescription(str);
        }
    }

    public static final class j implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagiskModuleUnofficial f8770a;

        public j(MagiskModuleUnofficial magiskModuleUnofficial) {
            this.f8770a = magiskModuleUnofficial;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            String detailContent = this.f8770a.getDetailContent();
            return detailContent != null ? detailContent : "";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            this.f8770a.setDetailContent(str);
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityModuleUpload.this.finishAfterTransition();
        }
    }

    public ActivityModuleUpload() {
        new Handler(Looper.getMainLooper());
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5362a == null) {
            this.f5362a = new HashMap();
        }
        View view = (View) this.f5362a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5362a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final void m() {
        o(this, new MagiskModuleUnofficial());
    }

    public final String n() {
        return this.f5361a;
    }

    public final void o(Context context, MagiskModuleUnofficial magiskModuleUnofficial) {
        qi0 qi0Var = new qi0(qi0.f7214a.a());
        BlurEditText blurEditText = (BlurEditText) _$_findCachedViewById(t61.module_id);
        f92.c(blurEditText, "module_id");
        qi0Var.f(blurEditText, new c(magiskModuleUnofficial));
        BlurEditText blurEditText2 = (BlurEditText) _$_findCachedViewById(t61.module_name);
        f92.c(blurEditText2, "module_name");
        qi0Var.f(blurEditText2, new d(magiskModuleUnofficial));
        BlurEditText blurEditText3 = (BlurEditText) _$_findCachedViewById(t61.module_author);
        f92.c(blurEditText3, "module_author");
        qi0Var.f(blurEditText3, new e(magiskModuleUnofficial));
        BlurEditText blurEditText4 = (BlurEditText) _$_findCachedViewById(t61.module_version_name);
        f92.c(blurEditText4, "module_version_name");
        qi0Var.f(blurEditText4, new f(magiskModuleUnofficial));
        BlurEditText blurEditText5 = (BlurEditText) _$_findCachedViewById(t61.module_version_code);
        f92.c(blurEditText5, "module_version_code");
        qi0Var.f(blurEditText5, new g(magiskModuleUnofficial));
        BlurEditText blurEditText6 = (BlurEditText) _$_findCachedViewById(t61.module_download_url);
        f92.c(blurEditText6, "module_download_url");
        qi0Var.f(blurEditText6, new h(magiskModuleUnofficial));
        BlurEditText blurEditText7 = (BlurEditText) _$_findCachedViewById(t61.module_description);
        f92.c(blurEditText7, "module_description");
        qi0Var.f(blurEditText7, new i(magiskModuleUnofficial));
        BlurEditText blurEditText8 = (BlurEditText) _$_findCachedViewById(t61.module_detail_content);
        f92.c(blurEditText8, "module_detail_content");
        qi0Var.f(blurEditText8, new j(magiskModuleUnofficial));
        ((Button) _$_findCachedViewById(t61.btn_cancel)).setOnClickListener(new k());
        ((Button) _$_findCachedViewById(t61.btn_confirm)).setOnClickListener(new b(magiskModuleUnofficial, context));
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.module_delete);
        String dbId = magiskModuleUnofficial.getDbId();
        imageView.setVisibility(dbId == null || dbId.length() == 0 ? 8 : 0);
        imageView.setOnClickListener(new xc1(this, magiskModuleUnofficial));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Object, java.lang.String] */
    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558469);
        setBackArrow();
        String str = this.f5361a;
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
            m();
        }
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_module_upload));
    }
}
