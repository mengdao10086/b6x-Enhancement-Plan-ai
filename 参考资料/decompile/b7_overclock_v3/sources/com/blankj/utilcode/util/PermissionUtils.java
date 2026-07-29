package com.blankj.utilcode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.MotionEvent;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.blankj.utilcode.util.j1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionUtils {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static PermissionUtils f11507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static e f11508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static e f11509o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f11510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f11511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f11512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f11513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f11514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f11515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f11516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set<String> f11517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f11518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f11519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f11520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f11521l;

    @g.v0(api = 23)
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f11522a = "TYPE";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11523b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11524c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11525d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f11526e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static PermissionActivityImpl f11527f = new PermissionActivityImpl();

        public static class a implements j1.b<Intent> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f11528a;

            public a(int i10) {
                this.f11528a = i10;
            }

            @Override // com.blankj.utilcode.util.j1.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra(PermissionActivityImpl.f11522a, this.f11528a);
            }
        }

        public class b implements c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UtilsTransActivity f11529a;

            public b(UtilsTransActivity utilsTransActivity) {
                this.f11529a = utilsTransActivity;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.c.a
            public void a(boolean z10) {
                if (z10) {
                    PermissionActivityImpl.this.q(this.f11529a);
                } else {
                    this.f11529a.finish();
                }
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UtilsTransActivity f11531a;

            public c(UtilsTransActivity utilsTransActivity) {
                this.f11531a = utilsTransActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11531a.requestPermissions((String[]) PermissionUtils.f11507m.f11518i.toArray(new String[0]), 1);
            }
        }

        public static void r(int i10) {
            UtilsTransActivity.c4(new a(i10), f11527f);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean a(@g.n0 UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void b(@g.n0 UtilsTransActivity utilsTransActivity, int i10, int i11, Intent intent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void d(@g.n0 UtilsTransActivity utilsTransActivity, @g.p0 Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra(f11522a, -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    f11526e = 2;
                    PermissionUtils.P(utilsTransActivity, 2);
                    return;
                } else if (intExtra != 3) {
                    utilsTransActivity.finish();
                    return;
                } else {
                    f11526e = 3;
                    PermissionUtils.N(utilsTransActivity, 3);
                    return;
                }
            }
            if (PermissionUtils.f11507m == null) {
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f11507m.f11518i == null) {
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f11507m.f11518i.size() <= 0) {
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f11507m.f11516g != null) {
                PermissionUtils.f11507m.f11516g.a(utilsTransActivity);
            }
            if (PermissionUtils.f11507m.f11511b == null) {
                q(utilsTransActivity);
            } else {
                PermissionUtils.f11507m.f11511b.a(utilsTransActivity, PermissionUtils.f11507m.f11518i, new b(utilsTransActivity));
                PermissionUtils.f11507m.f11511b = null;
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void f(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            int i10 = f11526e;
            if (i10 != -1) {
                p(i10);
                f11526e = -1;
            }
            super.f(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void i(@g.n0 UtilsTransActivity utilsTransActivity, int i10, @g.n0 String[] strArr, @g.n0 int[] iArr) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            if (PermissionUtils.f11507m == null || PermissionUtils.f11507m.f11518i == null) {
                return;
            }
            PermissionUtils.f11507m.D(utilsTransActivity);
        }

        public final void p(int i10) {
            if (i10 == 2) {
                if (PermissionUtils.f11508n == null) {
                    return;
                }
                if (PermissionUtils.B()) {
                    PermissionUtils.f11508n.a();
                } else {
                    PermissionUtils.f11508n.b();
                }
                e unused = PermissionUtils.f11508n = null;
                return;
            }
            if (i10 != 3 || PermissionUtils.f11509o == null) {
                return;
            }
            if (PermissionUtils.A()) {
                PermissionUtils.f11509o.a();
            } else {
                PermissionUtils.f11509o.b();
            }
            e unused2 = PermissionUtils.f11509o = null;
        }

        public final void q(UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f11507m.M(utilsTransActivity, new c(utilsTransActivity))) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f11507m.f11518i.toArray(new String[0]), 1);
        }
    }

    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UtilsTransActivity f11534b;

        public a(Runnable runnable, UtilsTransActivity utilsTransActivity) {
            this.f11533a = runnable;
            this.f11534b = utilsTransActivity;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.d.a
        public void a(boolean z10) {
            if (!z10) {
                this.f11534b.finish();
                PermissionUtils.this.J();
                return;
            }
            PermissionUtils.this.f11520k = new ArrayList();
            PermissionUtils.this.f11521l = new ArrayList();
            this.f11533a.run();
        }
    }

    public interface b {
        void a(@g.n0 List<String> list);

        void b(@g.n0 List<String> list, @g.n0 List<String> list2);
    }

    public interface c {

        public interface a {
            void a(boolean z10);
        }

        void a(@g.n0 UtilsTransActivity utilsTransActivity, @g.n0 List<String> list, @g.n0 a aVar);
    }

    public interface d {

        public interface a {
            void a(boolean z10);
        }

        void a(@g.n0 UtilsTransActivity utilsTransActivity, @g.n0 a aVar);
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
        void a(boolean z10, @g.n0 List<String> list, @g.n0 List<String> list2, @g.n0 List<String> list3);
    }

    public interface g {
        void a(@g.n0 Activity activity);
    }

    public PermissionUtils(String... strArr) {
        this.f11510a = strArr;
        f11507m = this;
    }

    @g.v0(api = 23)
    public static boolean A() {
        return Settings.canDrawOverlays(j1.a());
    }

    @g.v0(api = 23)
    public static boolean B() {
        return Settings.System.canWrite(j1.a());
    }

    public static void C() {
        Intent intentX = l1.X(j1.a().getPackageName(), true);
        if (l1.x0(intentX)) {
            j1.a().startActivity(intentX);
        }
    }

    public static PermissionUtils E(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public static PermissionUtils F(String... strArr) {
        return E(strArr);
    }

    @g.v0(api = 23)
    public static void K(e eVar) {
        if (!A()) {
            f11509o = eVar;
            PermissionActivityImpl.r(3);
        } else if (eVar != null) {
            eVar.a();
        }
    }

    @g.v0(api = 23)
    public static void L(e eVar) {
        if (!B()) {
            f11508n = eVar;
            PermissionActivityImpl.r(2);
        } else if (eVar != null) {
            eVar.a();
        }
    }

    @TargetApi(23)
    public static void N(Activity activity, int i10) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + j1.a().getPackageName()));
        if (l1.x0(intent)) {
            activity.startActivityForResult(intent, i10);
        } else {
            C();
        }
    }

    @TargetApi(23)
    public static void P(Activity activity, int i10) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + j1.a().getPackageName()));
        if (l1.x0(intent)) {
            activity.startActivityForResult(intent, i10);
        } else {
            C();
        }
    }

    public static List<String> u() {
        return v(j1.a().getPackageName());
    }

    public static List<String> v(String str) {
        try {
            String[] strArr = j1.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Pair<List<String>, List<String>> x(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listU = u();
        for (String str : strArr) {
            boolean z10 = false;
            for (String str2 : w3.c.a(str)) {
                if (listU.contains(str2)) {
                    arrayList.add(str2);
                    z10 = true;
                }
            }
            if (!z10) {
                arrayList2.add(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("U should add the permission of ");
                sb2.append(str);
                sb2.append(" in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    public static boolean y(String str) {
        return Build.VERSION.SDK_INT < 23 || h0.d.a(j1.a(), str) == 0;
    }

    public static boolean z(String... strArr) {
        Pair<List<String>, List<String>> pairX = x(strArr);
        if (!((List) pairX.second).isEmpty()) {
            return false;
        }
        Iterator it2 = ((List) pairX.first).iterator();
        while (it2.hasNext()) {
            if (!y((String) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public final void D(Activity activity) {
        w(activity);
        J();
    }

    public final void G(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        w(utilsTransActivity);
        this.f11512c.a(utilsTransActivity, new a(runnable, utilsTransActivity));
    }

    public PermissionUtils H(d dVar) {
        this.f11512c = dVar;
        return this;
    }

    public void I() {
        String[] strArr = this.f11510a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f11517h = new LinkedHashSet();
        this.f11518i = new ArrayList();
        this.f11519j = new ArrayList();
        this.f11520k = new ArrayList();
        this.f11521l = new ArrayList();
        Pair<List<String>, List<String>> pairX = x(this.f11510a);
        this.f11517h.addAll((Collection) pairX.first);
        this.f11520k.addAll((Collection) pairX.second);
        if (Build.VERSION.SDK_INT < 23) {
            this.f11519j.addAll(this.f11517h);
            J();
            return;
        }
        for (String str : this.f11517h) {
            if (y(str)) {
                this.f11519j.add(str);
            } else {
                this.f11518i.add(str);
            }
        }
        if (this.f11518i.isEmpty()) {
            J();
        } else {
            O();
        }
    }

    public final void J() {
        f fVar = this.f11513d;
        if (fVar != null) {
            fVar.a(this.f11520k.isEmpty(), this.f11519j, this.f11521l, this.f11520k);
            this.f11513d = null;
        }
        if (this.f11514e != null) {
            if (this.f11520k.isEmpty()) {
                this.f11514e.a();
            } else {
                this.f11514e.b();
            }
            this.f11514e = null;
        }
        if (this.f11515f != null) {
            if (this.f11518i.size() == 0 || this.f11519j.size() > 0) {
                this.f11515f.a(this.f11519j);
            }
            if (!this.f11520k.isEmpty()) {
                this.f11515f.b(this.f11521l, this.f11520k);
            }
            this.f11515f = null;
        }
        this.f11512c = null;
        this.f11516g = null;
    }

    @g.v0(api = 23)
    public final boolean M(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z10 = false;
        if (this.f11512c != null) {
            Iterator<String> it2 = this.f11518i.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (utilsTransActivity.shouldShowRequestPermissionRationale(it2.next())) {
                    G(utilsTransActivity, runnable);
                    z10 = true;
                    break;
                }
            }
            this.f11512c = null;
        }
        return z10;
    }

    @g.v0(api = 23)
    public final void O() {
        PermissionActivityImpl.r(1);
    }

    public PermissionUtils Q(g gVar) {
        this.f11516g = gVar;
        return this;
    }

    public PermissionUtils q(b bVar) {
        this.f11515f = bVar;
        return this;
    }

    public PermissionUtils r(e eVar) {
        this.f11514e = eVar;
        return this;
    }

    public PermissionUtils s(f fVar) {
        this.f11513d = fVar;
        return this;
    }

    public PermissionUtils t(c cVar) {
        this.f11511b = cVar;
        return this;
    }

    public final void w(Activity activity) {
        for (String str : this.f11518i) {
            if (y(str)) {
                this.f11519j.add(str);
            } else {
                this.f11520k.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f11521l.add(str);
                }
            }
        }
    }
}
