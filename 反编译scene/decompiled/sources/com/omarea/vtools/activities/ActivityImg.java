package com.omarea.vtools.activities;

import a.a70;
import a.b60;
import a.b90;
import a.bc2;
import a.bl0;
import a.e60;
import a.ec2;
import a.f92;
import a.g91;
import a.i52;
import a.kc1;
import a.mc1;
import a.n30;
import a.n50;
import a.n92;
import a.nc1;
import a.oc1;
import a.p80;
import a.q92;
import a.qc2;
import a.qe2;
import a.s60;
import a.s80;
import a.t61;
import a.tj0;
import a.u61;
import a.u90;
import a.um0;
import a.x60;
import a.xd2;
import a.z42;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityImg extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8719a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f8720a;

        public a(Runnable runnable) {
            this.f8720a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8720a.run();
        }
    }

    public static final class b implements s80 {
        public b() {
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            if (list.size() > 0) {
                ActivityImg.this.s((n30) i52.A(list));
            }
        }
    }

    public static final class c implements s80 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5328a;

        public c(String str) {
            this.f5328a = str;
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            if (!list.isEmpty()) {
                ActivityImg.this.t(this.f5328a, (n30) i52.A(list));
            }
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n30 f8723a;

        public d(n30 n30Var) {
            this.f8723a = n30Var;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, a.u90] */
        @Override // java.lang.Runnable
        public final void run() {
            n92 n92Var = new n92();
            ?? u90Var = new u90(ActivityImg.this, null, 2, null);
            n92Var.f6891a = u90Var;
            ((u90) u90Var).d("Running, Please wait……");
            qc2.d(xd2.a(qe2.b()), null, null, new kc1(this, n92Var, null), 3, null);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n30 f8724a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5331a;

        public e(String str, n30 n30Var) {
            this.f5331a = str;
            this.f8724a = n30Var;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, a.u90] */
        @Override // java.lang.Runnable
        public final void run() {
            n92 n92Var = new n92();
            ?? u90Var = new u90(ActivityImg.this, null, 2, null);
            n92Var.f6891a = u90Var;
            ((u90) u90Var).d("Flashing, Please wait……");
            qc2.d(xd2.a(qe2.b()), null, null, new mc1(this, n92Var, null), 3, null);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityImg.this.o(new nc1(this));
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityImg.this.q();
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityImg.this.o(new oc1(this));
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8719a == null) {
            this.f8719a = new HashMap();
        }
        View view = (View) this.f8719a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8719a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void o(Runnable runnable) {
        String strF = a70.f(false);
        boolean z = strF != null && (f92.a(strF, "mqsas") || f92.a(strF, "xsu"));
        boolean zC = ec2.C(s60.f7366a.a("id"), "gid=1000(system)", false, 2, null);
        if (z || zC) {
            p80.f2403a.M(this, (16 & 2) != 0 ? "" : "危险操作", (16 & 4) != 0 ? "" : "你的设备可能未解锁BL，修改系统分区会导致无法开机，确定要继续吗？", (16 & 8) != 0 ? null : new a(runnable), (16 & 16) != 0 ? null : null);
        } else {
            runnable.run();
        }
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        String string;
        String string2;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || intent == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            string = new b60().f(this, intent.getData());
            if (string != null) {
                if (!bc2.o(string, ".img", false, 2, null)) {
                    string2 = getString(u61.img_file_invalid);
                }
                r(string);
                return;
            }
            string2 = getString(u61.img_file_not_found);
        } else {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("file")) {
                Bundle extras2 = intent.getExtras();
                f92.b(extras2);
                string = extras2.getString("file");
                f92.b(string);
                f92.c(string, "data.extras!!.getString(\"file\")!!");
                r(string);
                return;
            }
            string2 = getString(u61.img_file_not_found);
        }
        Toast.makeText(this, string2, 0).show();
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558452);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_img));
    }

    public final void onViewCreated() {
        StringBuilder sb;
        String str;
        String strA = um0.f7612a.a("ro.boot.slot_suffix");
        if (strA.length() == 0) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.slot_view);
            f92.c(linearLayout, "slot_view");
            linearLayout.setVisibility(8);
        } else {
            TextView textView = (TextView) _$_findCachedViewById(t61.slot);
            f92.c(textView, "slot");
            textView.setText(strA);
        }
        long jU = u();
        TextView textView2 = (TextView) _$_findCachedViewById(t61.space);
        f92.c(textView2, "space");
        if (jU > 8192) {
            sb = new StringBuilder();
            sb.append(String.valueOf(jU / ((long) 1024)));
            str = "GB";
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(jU));
            str = "MB";
        }
        sb.append(str);
        textView2.setText(sb.toString());
        String strA2 = um0.f7612a.a("ro.build.version.incremental");
        TextView textView3 = (TextView) _$_findCachedViewById(t61.os_incremental);
        f92.c(textView3, "os_incremental");
        textView3.setText(tj0.f7508a.c(Build.VERSION.SDK_INT) + "   " + strA2);
        String strD = x60.f7856a.d("/proc/version");
        TextView textView4 = (TextView) _$_findCachedViewById(t61.kernel_version);
        f92.c(textView4, "kernel_version");
        textView4.setText(strD);
        ((Button) _$_findCachedViewById(t61.choose_img_flash)).setOnClickListener(new f());
        ((Button) _$_findCachedViewById(t61.choose_partition_export)).setOnClickListener(new g());
        Button button = (Button) _$_findCachedViewById(t61.twrp_injector);
        f92.c(button, "twrp_injector");
        button.setEnabled(e60.f698a.b());
        ((Button) _$_findCachedViewById(t61.twrp_injector)).setOnClickListener(new h());
    }

    public final void p() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 30) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
        } else {
            intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            intent.putExtra("extension", "img");
        }
        startActivityForResult(intent, 1);
    }

    public final void q() {
        ArrayList<n50> arrayList;
        ArrayList<n50> arrayListA = new bl0(this).a();
        if (arrayListA != null) {
            arrayList = new ArrayList();
            for (Object obj : arrayListA) {
                n50 n50Var = (n50) obj;
                if ((f92.a(n50Var.d(), "data") ^ true) && (f92.a(n50Var.d(), "userdata") ^ true)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            p80.a aVar = p80.f2403a;
            String string = getString(u61.device_unsupport);
            f92.c(string, "getString(R.string.device_unsupport)");
            p80.a.C(aVar, this, string, null, 4, null);
            return;
        }
        Context context = getContext();
        boolean zA = getThemeMode().a();
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        for (n50 n50Var2 : arrayList) {
            n30 n30Var = new n30();
            n30Var.j(n50Var2.b());
            n30Var.i(n50Var2.d());
            arrayList2.add(n30Var);
        }
        b90 b90Var = new b90(zA, new ArrayList(arrayList2), false, new b(), 0, 16, null);
        String string2 = context.getString(u61.img_choose_partition);
        f92.c(string2, "context.getString(R.string.img_choose_partition)");
        b90Var.K1(string2);
        b90Var.B1(getSupportFragmentManager(), "partitions-chooser");
    }

    public final void r(String str) {
        ArrayList<n50> arrayList;
        ArrayList<n50> arrayListA = new bl0(this).a();
        if (arrayListA != null) {
            arrayList = new ArrayList();
            for (Object obj : arrayListA) {
                n50 n50Var = (n50) obj;
                if ((f92.a(n50Var.d(), "data") ^ true) && (f92.a(n50Var.d(), "userdata") ^ true)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        int iS = ec2.S(str, "/", 0, false, 6, null) + 1;
        int iS2 = ec2.S(str, ".", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iS, iS2);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strSubstring.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (arrayList == null) {
            p80.a aVar = p80.f2403a;
            String string = getString(u61.device_unsupport);
            f92.c(string, "getString(R.string.device_unsupport)");
            p80.a.C(aVar, this, string, null, 4, null);
            return;
        }
        Context context = getContext();
        boolean zA = getThemeMode().a();
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        for (n50 n50Var2 : arrayList) {
            n30 n30Var = new n30();
            n30Var.j(n50Var2.b());
            n30Var.i(n50Var2.d());
            n30Var.h(f92.a(n50Var2.d(), lowerCase));
            arrayList2.add(n30Var);
        }
        b90 b90Var = new b90(zA, new ArrayList(arrayList2), false, new c(str), 0, 16, null);
        String string2 = context.getString(u61.img_choose_partition);
        f92.c(string2, "context.getString(R.string.img_choose_partition)");
        b90Var.K1(string2);
        b90Var.I1("IMG File: " + str);
        b90Var.B1(getSupportFragmentManager(), "partitions-chooser");
    }

    public final void s(n30 n30Var) {
        p80.a aVar = p80.f2403a;
        String string = getString(u61.img_export_confirm);
        f92.c(string, "getString(R.string.img_export_confirm)");
        q92 q92Var = q92.f7191a;
        String string2 = getString(u61.img_export_warn);
        f92.c(string2, "getString(R.string.img_export_warn)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{n30Var.d(), n30Var.d()}, 2));
        f92.c(str, "java.lang.String.format(format, *args)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new d(n30Var), (16 & 16) != 0 ? null : null);
    }

    public final void t(String str, n30 n30Var) {
        p80.a aVar = p80.f2403a;
        String string = getString(u61.img_flash_confirm);
        f92.c(string, "getString(R.string.img_flash_confirm)");
        q92 q92Var = q92.f7191a;
        String string2 = getString(u61.img_flash_warn);
        f92.c(string2, "getString(R.string.img_flash_warn)");
        String str2 = String.format(string2, Arrays.copyOf(new Object[]{str, n30Var.d()}, 2));
        f92.c(str2, "java.lang.String.format(format, *args)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str2, (16 & 8) != 0 ? null : new e(str, n30Var), (16 & 16) != 0 ? null : null);
    }

    public final long u() {
        File dataDirectory = Environment.getDataDirectory();
        f92.c(dataDirectory, "Environment.getDataDirectory()");
        long j = 1024;
        return (new StatFs(dataDirectory.getPath()).getAvailableBytes() / j) / j;
    }
}
