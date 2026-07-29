package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.j1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public a() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Drawable A(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return B(activity.getComponentName());
    }

    public static void A0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, str, str2, bundle2);
    }

    public static boolean A1(Intent intent, Fragment fragment, int i10, @g.p0 Bundle bundle) {
        if (!W(intent)) {
            return false;
        }
        if (fragment.w1() == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment ");
            sb2.append(fragment);
            sb2.append(" not attached to Activity");
            return false;
        }
        if (bundle != null) {
            fragment.A5(intent, i10, bundle);
            return true;
        }
        fragment.z5(intent, i10);
        return true;
    }

    public static Drawable B(@g.n0 ComponentName componentName) {
        Objects.requireNonNull(componentName, "Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return j1.a().getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void B0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, str, str2, L(activity, viewArr));
    }

    public static boolean B1(Fragment fragment, Bundle bundle, String str, String str2, int i10, @g.p0 Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return A1(intent, fragment, i10, bundle2);
    }

    public static Drawable C(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return B(new ComponentName(j1.a(), cls));
    }

    public static void C0(@g.n0 Bundle bundle, @g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, bundle, contextQ.getPackageName(), cls.getName(), null);
    }

    public static void C1() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        O0(intent);
    }

    public static List<Activity> D() {
        return l1.J();
    }

    public static void D0(@g.n0 Bundle bundle, @g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, bundle, contextQ.getPackageName(), cls.getName(), M(contextQ, i10, i11));
    }

    public static void D1() {
        E1(j1.a().getPackageName());
    }

    public static Drawable E(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return F(activity.getComponentName());
    }

    public static void E0(@g.n0 Bundle bundle, @g.n0 Class<? extends Activity> cls, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, bundle, contextQ.getPackageName(), cls.getName(), bundle2);
    }

    public static void E1(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String strI = I(str);
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        L0(str, strI);
    }

    public static Drawable F(@g.n0 ComponentName componentName) {
        Objects.requireNonNull(componentName, "Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return j1.a().getPackageManager().getActivityLogo(componentName);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void F0(@g.n0 Bundle bundle, @g.n0 String str, @g.n0 String str2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(Q(), bundle, str, str2, null);
    }

    public static Drawable G(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return F(new ComponentName(j1.a(), cls));
    }

    public static void G0(@g.n0 Bundle bundle, @g.n0 String str, @g.n0 String str2, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, bundle, str, str2, M(contextQ, i10, i11));
    }

    public static String H() {
        return I(j1.a().getPackageName());
    }

    public static void H0(@g.n0 Bundle bundle, @g.n0 String str, @g.n0 String str2, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(Q(), bundle, str, str2, bundle2);
    }

    public static String I(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (l1.C0(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = j1.a().getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? "" : listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static void I0(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, null, contextQ.getPackageName(), cls.getName(), null);
    }

    public static List<String> J() {
        return K(j1.a().getPackageName());
    }

    public static void J0(@g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, null, contextQ.getPackageName(), cls.getName(), M(contextQ, i10, i11));
    }

    public static List<String> K(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = j1.a().getPackageManager().queryIntentActivities(intent, 0);
        int size = listQueryIntentActivities.size();
        if (size == 0) {
            return arrayList;
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = listQueryIntentActivities.get(i10);
            if (resolveInfo.activityInfo.processName.equals(str)) {
                arrayList.add(resolveInfo.activityInfo.name);
            }
        }
        return arrayList;
    }

    public static void K0(@g.n0 Class<? extends Activity> cls, @g.p0 Bundle bundle) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, null, contextQ.getPackageName(), cls.getName(), bundle);
    }

    public static Bundle L(Activity activity, View[] viewArr) {
        int length;
        if (viewArr == null || (length = viewArr.length) <= 0) {
            return null;
        }
        androidx.core.util.k[] kVarArr = new androidx.core.util.k[length];
        for (int i10 = 0; i10 < length; i10++) {
            kVarArr[i10] = androidx.core.util.k.a(viewArr[i10], viewArr[i10].getTransitionName());
        }
        return f0.e.g(activity, kVarArr).l();
    }

    public static void L0(@g.n0 String str, @g.n0 String str2) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(Q(), null, str, str2, null);
    }

    public static Bundle M(Context context, int i10, int i11) {
        return f0.e.d(context, i10, i11).l();
    }

    public static void M0(@g.n0 String str, @g.n0 String str2, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        t0(contextQ, null, str, str2, M(contextQ, i10, i11));
    }

    public static Bundle N(Fragment fragment, int i10, int i11) {
        androidx.fragment.app.g gVarW1 = fragment.w1();
        if (gVarW1 == null) {
            return null;
        }
        return f0.e.d(gVarW1, i10, i11).l();
    }

    public static void N0(@g.n0 String str, @g.n0 String str2, @g.p0 Bundle bundle) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(Q(), null, str, str2, bundle);
    }

    public static Bundle O(Fragment fragment, View[] viewArr) {
        androidx.fragment.app.g gVarW1 = fragment.w1();
        if (gVarW1 == null) {
            return null;
        }
        return L(gVarW1, viewArr);
    }

    public static boolean O0(@g.n0 Intent intent) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Q0(intent, Q(), null);
    }

    public static Activity P() {
        return l1.h0();
    }

    public static boolean P0(@g.n0 Intent intent, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        return Q0(intent, contextQ, M(contextQ, i10, i11));
    }

    public static Context Q() {
        if (!l1.r0()) {
            return j1.a();
        }
        Activity activityP = P();
        return activityP == null ? j1.a() : activityP;
    }

    public static boolean Q0(Intent intent, Context context, Bundle bundle) {
        if (!W(intent)) {
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            context.startActivity(intent, bundle);
            return true;
        }
        context.startActivity(intent);
        return true;
    }

    public static boolean R(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean R0(@g.n0 Intent intent, @g.p0 Bundle bundle) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Q0(intent, Q(), bundle);
    }

    public static boolean S(Context context) {
        return R(x(context));
    }

    public static void S0(@g.n0 Activity activity, @g.n0 Intent intent, int i10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z1(intent, activity, i10, null);
    }

    public static boolean T(@g.n0 String str, @g.n0 String str2) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        PackageManager packageManager = j1.a().getPackageManager();
        return (packageManager.resolveActivity(intent, 0) == null || intent.resolveActivity(packageManager) == null || packageManager.queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static void T0(@g.n0 Activity activity, @g.n0 Intent intent, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z1(intent, activity, i10, M(activity, i11, i12));
    }

    public static boolean U(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Activity> it2 = l1.J().iterator();
        while (it2.hasNext()) {
            if (it2.next().equals(activity)) {
                return true;
            }
        }
        return false;
    }

    public static void U0(@g.n0 Activity activity, @g.n0 Intent intent, int i10, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z1(intent, activity, i10, bundle);
    }

    public static boolean V(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Activity> it2 = l1.J().iterator();
        while (it2.hasNext()) {
            if (it2.next().getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public static void V0(@g.n0 Activity activity, @g.n0 Intent intent, int i10, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z1(intent, activity, i10, L(activity, viewArr));
    }

    public static boolean W(Intent intent) {
        return j1.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void W0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, null, activity.getPackageName(), cls.getName(), i10, null);
    }

    public static void X(Activity activity) {
        l1.Q0(activity);
    }

    public static void X0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, null, activity.getPackageName(), cls.getName(), i10, M(activity, i11, i12));
    }

    public static void Y(Activity activity, j1.a aVar) {
        l1.R0(activity, aVar);
    }

    public static void Y0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, null, activity.getPackageName(), cls.getName(), i10, bundle);
    }

    public static void Z(j1.a aVar) {
        l1.S0(aVar);
    }

    public static void Z0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, null, activity.getPackageName(), cls.getName(), i10, L(activity, viewArr));
    }

    public static void a(Activity activity, j1.a aVar) {
        l1.a(activity, aVar);
    }

    public static void a0(@g.n0 Activity activity, @g.n0 Intent[] intentArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(intentArr, activity, null);
    }

    public static void a1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, activity.getPackageName(), cls.getName(), i10, null);
    }

    public static void b(j1.a aVar) {
        l1.b(aVar);
    }

    public static void b0(@g.n0 Activity activity, @g.n0 Intent[] intentArr, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(intentArr, activity, M(activity, i10, i11));
    }

    public static void b1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, activity.getPackageName(), cls.getName(), i10, M(activity, i11, i12));
    }

    public static void c(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        e(activity, false);
    }

    public static void c0(@g.n0 Activity activity, @g.n0 Intent[] intentArr, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(intentArr, activity, bundle);
    }

    public static void c1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, activity.getPackageName(), cls.getName(), i10, bundle2);
    }

    public static void d(@g.n0 Activity activity, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.finish();
        activity.overridePendingTransition(i10, i11);
    }

    public static void d0(@g.n0 Intent[] intentArr) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(intentArr, Q(), null);
    }

    public static void d1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, int i10, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, activity.getPackageName(), cls.getName(), i10, L(activity, viewArr));
    }

    public static void e(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.finish();
        if (z10) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void e0(@g.n0 Intent[] intentArr, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context contextQ = Q();
        f0(intentArr, contextQ, M(contextQ, i10, i11));
    }

    public static void e1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, int i10) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, str, str2, i10, null);
    }

    public static void f(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h(cls, false);
    }

    public static void f0(Intent[] intentArr, Context context, @g.p0 Bundle bundle) {
        if (!(context instanceof Activity)) {
            for (Intent intent : intentArr) {
                intent.addFlags(268435456);
            }
        }
        if (bundle != null) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
    }

    public static void f1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, str, str2, i10, M(activity, i11, i12));
    }

    public static void g(@g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                activity.overridePendingTransition(i10, i11);
            }
        }
    }

    public static void g0(@g.n0 Intent[] intentArr, @g.p0 Bundle bundle) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(intentArr, Q(), bundle);
    }

    public static void g1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, int i10, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, str, str2, i10, bundle2);
    }

    public static void h(@g.n0 Class<? extends Activity> cls, boolean z10) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                if (!z10) {
                    activity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void h0(@g.n0 Activity activity, @g.n0 Intent intent) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q0(intent, activity, null);
    }

    public static void h1(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, int i10, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y1(activity, bundle, str, str2, i10, L(activity, viewArr));
    }

    public static void i() {
        k(false);
    }

    public static void i0(@g.n0 Activity activity, @g.n0 Intent intent, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q0(intent, activity, M(activity, i10, i11));
    }

    public static void i1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, j1.a().getPackageName(), cls.getName(), i10, null);
    }

    public static void j(@g.a int i10, @g.a int i11) {
        for (Activity activity : l1.J()) {
            activity.finish();
            activity.overridePendingTransition(i10, i11);
        }
    }

    public static void j0(@g.n0 Activity activity, @g.n0 Intent intent, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q0(intent, activity, bundle);
    }

    public static void j1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, j1.a().getPackageName(), cls.getName(), i10, N(fragment, i11, i12));
    }

    public static void k(boolean z10) {
        for (Activity activity : l1.J()) {
            activity.finish();
            if (!z10) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    public static void k0(@g.n0 Activity activity, @g.n0 Intent intent, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q0(intent, activity, L(activity, viewArr));
    }

    public static void k1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, j1.a().getPackageName(), cls.getName(), i10, bundle2);
    }

    public static void l() {
        n(false);
    }

    public static void l0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, activity.getPackageName(), cls.getName(), null);
    }

    public static void l1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, j1.a().getPackageName(), cls.getName(), i10, O(fragment, viewArr));
    }

    public static void m(@g.a int i10, @g.a int i11) {
        List<Activity> listJ = l1.J();
        for (int i12 = 1; i12 < listJ.size(); i12++) {
            d(listJ.get(i12), i10, i11);
        }
    }

    public static void m0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, activity.getPackageName(), cls.getName(), M(activity, i10, i11));
    }

    public static void m1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 String str, @g.n0 String str2, int i10) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, str, str2, i10, null);
    }

    public static void n(boolean z10) {
        List<Activity> listJ = l1.J();
        for (int i10 = 1; i10 < listJ.size(); i10++) {
            e(listJ.get(i10), z10);
        }
    }

    public static void n0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, activity.getPackageName(), cls.getName(), bundle);
    }

    public static void n1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 String str, @g.n0 String str2, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, str, str2, i10, N(fragment, i11, i12));
    }

    public static void o(@g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        q(cls, false);
    }

    public static void o0(@g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, activity.getPackageName(), cls.getName(), L(activity, viewArr));
    }

    public static void o1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 String str, @g.n0 String str2, int i10, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, str, str2, i10, bundle2);
    }

    public static void p(@g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (!activity.getClass().equals(cls)) {
                d(activity, i10, i11);
            }
        }
    }

    public static void p0(@g.n0 Activity activity, @g.n0 String str, @g.n0 String str2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, str, str2, null);
    }

    public static void p1(@g.n0 Bundle bundle, @g.n0 Fragment fragment, @g.n0 String str, @g.n0 String str2, int i10, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, bundle, str, str2, i10, O(fragment, viewArr));
    }

    public static void q(@g.n0 Class<? extends Activity> cls, boolean z10) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (!activity.getClass().equals(cls)) {
                e(activity, z10);
            }
        }
    }

    public static void q0(@g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, str, str2, M(activity, i10, i11));
    }

    public static void q1(@g.n0 Fragment fragment, @g.n0 Intent intent, int i10) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A1(intent, fragment, i10, null);
    }

    public static boolean r(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(activity, z10, false);
    }

    public static void r0(@g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, str, str2, bundle);
    }

    public static void r1(@g.n0 Fragment fragment, @g.n0 Intent intent, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A1(intent, fragment, i10, N(fragment, i11, i12));
    }

    public static boolean s(@g.n0 Activity activity, boolean z10, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity2 : l1.J()) {
            if (activity2.equals(activity)) {
                if (!z10) {
                    return true;
                }
                d(activity2, i10, i11);
                return true;
            }
            d(activity2, i10, i11);
        }
        return false;
    }

    public static void s0(@g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, null, str, str2, L(activity, viewArr));
    }

    public static void s1(@g.n0 Fragment fragment, @g.n0 Intent intent, int i10, @g.p0 Bundle bundle) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A1(intent, fragment, i10, bundle);
    }

    public static boolean t(@g.n0 Activity activity, boolean z10, boolean z11) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity2 : l1.J()) {
            if (activity2.equals(activity)) {
                if (!z10) {
                    return true;
                }
                e(activity2, z11);
                return true;
            }
            e(activity2, z11);
        }
        return false;
    }

    public static void t0(Context context, Bundle bundle, String str, String str2, @g.p0 Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        Q0(intent, context, bundle2);
    }

    public static void t1(@g.n0 Fragment fragment, @g.n0 Intent intent, int i10, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A1(intent, fragment, i10, O(fragment, viewArr));
    }

    public static boolean u(@g.n0 Class<? extends Activity> cls, boolean z10) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w(cls, z10, false);
    }

    public static void u0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, activity.getPackageName(), cls.getName(), null);
    }

    public static void u1(@g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, null, j1.a().getPackageName(), cls.getName(), i10, null);
    }

    public static boolean v(@g.n0 Class<? extends Activity> cls, boolean z10, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (activity.getClass().equals(cls)) {
                if (!z10) {
                    return true;
                }
                d(activity, i10, i11);
                return true;
            }
            d(activity, i10, i11);
        }
        return false;
    }

    public static void v0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, activity.getPackageName(), cls.getName(), M(activity, i10, i11));
    }

    public static void v1(@g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, @g.a int i11, @g.a int i12) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, null, j1.a().getPackageName(), cls.getName(), i10, N(fragment, i11, i12));
    }

    public static boolean w(@g.n0 Class<? extends Activity> cls, boolean z10, boolean z11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : l1.J()) {
            if (activity.getClass().equals(cls)) {
                if (!z10) {
                    return true;
                }
                e(activity, z11);
                return true;
            }
            e(activity, z11);
        }
        return false;
    }

    public static void w0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, @g.p0 Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, activity.getPackageName(), cls.getName(), bundle2);
    }

    public static void w1(@g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, @g.p0 Bundle bundle) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, null, j1.a().getPackageName(), cls.getName(), i10, bundle);
    }

    public static Activity x(Context context) {
        Activity activityY = y(context);
        if (R(activityY)) {
            return activityY;
        }
        return null;
    }

    public static void x0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 Class<? extends Activity> cls, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, activity.getPackageName(), cls.getName(), L(activity, viewArr));
    }

    public static void x1(@g.n0 Fragment fragment, @g.n0 Class<? extends Activity> cls, int i10, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B1(fragment, null, j1.a().getPackageName(), cls.getName(), i10, O(fragment, viewArr));
    }

    public static Activity y(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (!(context instanceof Activity)) {
                Activity activityZ = z(context);
                if (activityZ == null) {
                    arrayList.add(context);
                    context = ((ContextWrapper) context).getBaseContext();
                    if (context == null || arrayList.contains(context)) {
                        break;
                    }
                } else {
                    return activityZ;
                }
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    public static void y0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, str, str2, null);
    }

    public static boolean y1(Activity activity, Bundle bundle, String str, String str2, int i10, @g.p0 Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return z1(intent, activity, i10, bundle2);
    }

    public static Activity z(Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void z0(@g.n0 Bundle bundle, @g.n0 Activity activity, @g.n0 String str, @g.n0 String str2, @g.a int i10, @g.a int i11) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(activity, bundle, str, str2, M(activity, i10, i11));
    }

    public static boolean z1(Intent intent, Activity activity, int i10, @g.p0 Bundle bundle) {
        if (!W(intent)) {
            return false;
        }
        if (bundle != null) {
            activity.startActivityForResult(intent, i10, bundle);
            return true;
        }
        activity.startActivityForResult(intent, i10);
        return true;
    }
}
