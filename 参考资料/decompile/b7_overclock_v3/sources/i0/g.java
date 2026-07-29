package i0;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.o;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import i0.e;
import i0.f;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31528a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31529b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31530c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31531d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i1
    public static final String f31532e = "com.android.launcher.action.INSTALL_SHORTCUT";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i1
    public static final String f31533f = "com.android.launcher.permission.INSTALL_SHORTCUT";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31534g = 96;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31535h = 48;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f31536i = "android.intent.extra.shortcut.ID";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile f<?> f31537j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile List<d> f31538k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f31539l = "androidx.core.content.pm.SHORTCUT_LISTENER";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f31540m = "androidx.core.content.pm.shortcut_listener_impl";

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentSender f31541a;

        public a(IntentSender intentSender) {
            this.f31541a = intentSender;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f31541a.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    @v0(25)
    public static class b {
        public static String a(@n0 List<ShortcutInfo> list) {
            int rank = -1;
            String id2 = null;
            for (ShortcutInfo shortcutInfo : list) {
                if (shortcutInfo.getRank() > rank) {
                    id2 = shortcutInfo.getId();
                    rank = shortcutInfo.getRank();
                }
            }
            return id2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    @i1
    public static void A(List<d> list) {
        f31538k = list;
    }

    @i1
    public static void B(f<Void> fVar) {
        f31537j = fVar;
    }

    public static boolean C(@n0 Context context, @n0 List<e> list) {
        List<e> listW = w(list, 1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            c(context, listW);
        }
        if (i10 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it2 = listW.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().H());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(listW);
        Iterator<d> it3 = n(context).iterator();
        while (it3.hasNext()) {
            it3.next().d(list);
        }
        return true;
    }

    public static boolean a(@n0 Context context, @n0 List<e> list) {
        List<e> listW = w(list, 1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            c(context, listW);
        }
        if (i10 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it2 = listW.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().H());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(listW);
        Iterator<d> it3 = n(context).iterator();
        while (it3.hasNext()) {
            it3.next().b(list);
        }
        return true;
    }

    @i1
    public static boolean b(@n0 Context context, @n0 e eVar) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = eVar.f31505i;
        if (iconCompat == null) {
            return false;
        }
        int i10 = iconCompat.f4629a;
        if (i10 != 6 && i10 != 4) {
            return true;
        }
        InputStream inputStreamF = iconCompat.F(context);
        if (inputStreamF == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamF)) == null) {
            return false;
        }
        eVar.f31505i = i10 == 6 ? IconCompat.q(bitmapDecodeStream) : IconCompat.t(bitmapDecodeStream);
        return true;
    }

    @i1
    public static void c(@n0 Context context, @n0 List<e> list) {
        for (e eVar : new ArrayList(list)) {
            if (!b(context, eVar)) {
                list.remove(eVar);
            }
        }
    }

    @n0
    public static Intent d(@n0 Context context, @n0 e eVar) {
        Intent intentCreateShortcutResultIntent = Build.VERSION.SDK_INT >= 26 ? ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(eVar.H()) : null;
        if (intentCreateShortcutResultIntent == null) {
            intentCreateShortcutResultIntent = new Intent();
        }
        return eVar.a(intentCreateShortcutResultIntent);
    }

    public static void e(@n0 Context context, @n0 List<String> list, @p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        o(context).d(list);
        Iterator<d> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().c(list);
        }
    }

    public static void f(@n0 Context context, @n0 List<e> list) {
        List<e> listW = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<e> it2 = listW.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().f31498b);
            }
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        o(context).a(listW);
        Iterator<d> it3 = n(context).iterator();
        while (it3.hasNext()) {
            it3.next().b(list);
        }
    }

    @n0
    public static List<e> g(@n0 Context context) {
        if (Build.VERSION.SDK_INT < 25) {
            try {
                return o(context).b();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        List<ShortcutInfo> dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator<ShortcutInfo> it2 = dynamicShortcuts.iterator();
        while (it2.hasNext()) {
            arrayList.add(new e.b(context, it2.next()).c());
        }
        return arrayList;
    }

    public static int h(@n0 Context context, boolean z10) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
        int iMax = Math.max(1, activityManager == null || activityManager.isLowRamDevice() ? 48 : 96);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (iMax * ((z10 ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    public static int i(@n0 Context context) {
        o.l(context);
        return Build.VERSION.SDK_INT >= 25 ? ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight() : h(context, false);
    }

    public static int j(@n0 Context context) {
        o.l(context);
        return Build.VERSION.SDK_INT >= 25 ? ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth() : h(context, true);
    }

    public static int k(@n0 Context context) {
        o.l(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    @i1
    public static List<d> l() {
        return f31538k;
    }

    public static String m(@n0 List<e> list) {
        int iV = -1;
        String strK = null;
        for (e eVar : list) {
            if (eVar.v() > iV) {
                strK = eVar.k();
                iV = eVar.v();
            }
        }
        return strK;
    }

    public static List<d> n(Context context) {
        Bundle bundle;
        String string;
        if (f31538k == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(f31539l);
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it2 = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it2.hasNext()) {
                ActivityInfo activityInfo = it2.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString(f31540m)) != null) {
                    try {
                        arrayList.add((d) Class.forName(string, false, g.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f31538k == null) {
                f31538k = arrayList;
            }
        }
        return f31538k;
    }

    public static f<?> o(Context context) {
        if (f31537j == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    f31537j = (f) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, g.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (f31537j == null) {
                f31537j = new f.a();
            }
        }
        return f31537j;
    }

    @n0
    public static List<e> p(@n0 Context context, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            return e.c(context, ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(i10));
        }
        if (i11 < 25) {
            if ((i10 & 2) != 0) {
                try {
                    return o(context).b();
                } catch (Exception unused) {
                }
            }
            return Collections.emptyList();
        }
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        ArrayList arrayList = new ArrayList();
        if ((i10 & 1) != 0) {
            arrayList.addAll(shortcutManager.getManifestShortcuts());
        }
        if ((i10 & 2) != 0) {
            arrayList.addAll(shortcutManager.getDynamicShortcuts());
        }
        if ((i10 & 4) != 0) {
            arrayList.addAll(shortcutManager.getPinnedShortcuts());
        }
        return e.c(context, arrayList);
    }

    public static boolean q(@n0 Context context) {
        o.l(context);
        return Build.VERSION.SDK_INT >= 25 ? ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive() : p(context, 3).size() == k(context);
    }

    public static boolean r(@n0 Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (h0.d.a(context, f31533f) != 0) {
            return false;
        }
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryBroadcastReceivers(new Intent(f31532e), 0).iterator();
        while (it2.hasNext()) {
            String str = it2.next().activityInfo.permission;
            if (TextUtils.isEmpty(str) || f31533f.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(@n0 Context context, @n0 e eVar) {
        o.l(context);
        o.l(eVar);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 32 && eVar.E(1)) {
            Iterator<d> it2 = n(context).iterator();
            while (it2.hasNext()) {
                it2.next().b(Collections.singletonList(eVar));
            }
            return true;
        }
        int iK = k(context);
        if (iK == 0) {
            return false;
        }
        if (i10 <= 29) {
            b(context, eVar);
        }
        if (i10 >= 30) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(eVar.H());
        } else if (i10 >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRateLimitingActive()) {
                return false;
            }
            List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= iK) {
                shortcutManager.removeDynamicShortcuts(Arrays.asList(b.a(dynamicShortcuts)));
            }
            shortcutManager.addDynamicShortcuts(Arrays.asList(eVar.H()));
        }
        f<?> fVarO = o(context);
        try {
            List<e> listB = fVarO.b();
            if (listB.size() >= iK) {
                fVarO.d(Arrays.asList(m(listB)));
            }
            fVarO.a(Arrays.asList(eVar));
            Iterator<d> it3 = n(context).iterator();
            while (it3.hasNext()) {
                it3.next().b(Collections.singletonList(eVar));
            }
            x(context, eVar.k());
            return true;
        } catch (Exception unused) {
            Iterator<d> it4 = n(context).iterator();
            while (it4.hasNext()) {
                it4.next().b(Collections.singletonList(eVar));
            }
            x(context, eVar.k());
            return false;
        } catch (Throwable th2) {
            Iterator<d> it5 = n(context).iterator();
            while (it5.hasNext()) {
                it5.next().b(Collections.singletonList(eVar));
            }
            x(context, eVar.k());
            throw th2;
        }
    }

    public static void t(@n0 Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        o(context).c();
        Iterator<d> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public static void u(@n0 Context context, @n0 List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        o(context).d(list);
        Iterator<d> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().c(list);
        }
    }

    public static void v(@n0 Context context, @n0 List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            u(context, list);
            return;
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        o(context).d(list);
        Iterator<d> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().c(list);
        }
    }

    @n0
    public static List<e> w(@n0 List<e> list, int i10) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (e eVar : list) {
            if (eVar.E(i10)) {
                arrayList.remove(eVar);
            }
        }
        return arrayList;
    }

    public static void x(@n0 Context context, @n0 String str) {
        o.l(context);
        o.l(str);
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
        }
        Iterator<d> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().e(Collections.singletonList(str));
        }
    }

    public static boolean y(@n0 Context context, @n0 e eVar, @p0 IntentSender intentSender) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 32 && eVar.E(1)) {
            return false;
        }
        if (i10 >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(eVar.H(), intentSender);
        }
        if (!r(context)) {
            return false;
        }
        Intent intentA = eVar.a(new Intent(f31532e));
        if (intentSender == null) {
            context.sendBroadcast(intentA);
            return true;
        }
        context.sendOrderedBroadcast(intentA, null, new a(intentSender), null, -1, null, null);
        return true;
    }

    public static boolean z(@n0 Context context, @n0 List<e> list) {
        o.l(context);
        o.l(list);
        List<e> listW = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(listW.size());
            Iterator<e> it2 = listW.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().H());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).c();
        o(context).a(listW);
        for (d dVar : n(context)) {
            dVar.a();
            dVar.b(list);
        }
        return true;
    }
}
