package f0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.os.a;
import bg.c;
import f0.b;
import f0.k0;
import g.n0;
import g.p0;
import g.r0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends h0.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static k f27409i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f27410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f27411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f27412c;

        public a(String[] strArr, Activity activity, int i10) {
            this.f27410a = strArr;
            this.f27411b = activity;
            this.f27412c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f27410a.length];
            PackageManager packageManager = this.f27411b.getPackageManager();
            String packageName = this.f27411b.getPackageName();
            int length = this.f27410a.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f27410a[i10], packageName);
            }
            ((j) this.f27411b).onRequestPermissionsResult(this.f27412c, this.f27410a, iArr);
        }
    }

    /* JADX INFO: renamed from: f0.b$b, reason: collision with other inner class name */
    @v0(16)
    public static class C0318b {
        @g.u
        public static void a(Activity activity) {
            activity.finishAffinity();
        }

        @g.u
        public static void b(Activity activity, Intent intent, int i10, Bundle bundle) {
            activity.startActivityForResult(intent, i10, bundle);
        }

        @g.u
        public static void c(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    @v0(21)
    public static class c {
        @g.u
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @g.u
        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @g.u
        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @g.u
        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @g.u
        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    @v0(22)
    public static class d {
        @g.u
        public static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    @v0(23)
    public static class e {
        @g.u
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @g.u
        public static void b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        @g.u
        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    @v0(28)
    public static class f {
        @g.u
        public static <T> T a(Activity activity, int i10) {
            return (T) activity.requireViewById(i10);
        }
    }

    @v0(30)
    public static class g {
        @g.u
        public static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        @g.u
        public static void b(@n0 Activity activity, @p0 h0.c0 c0Var, @p0 Bundle bundle) {
            activity.setLocusContext(c0Var == null ? null : c0Var.c(), bundle);
        }
    }

    @v0(31)
    public static class h {
        @g.u
        public static boolean a(@n0 Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @g.u
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    @v0(32)
    public static class i {
        @g.u
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface j {
        void onRequestPermissionsResult(int i10, @n0 String[] strArr, @n0 int[] iArr);
    }

    public interface k {
        boolean a(@n0 Activity activity, @g.f0(from = 0) int i10, int i11, @p0 Intent intent);

        boolean b(@n0 Activity activity, @n0 String[] strArr, @g.f0(from = 0) int i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface l {
        void q(int i10);
    }

    @v0(21)
    public static class m extends SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f27413a;

        public m(k0 k0Var) {
            this.f27413a = k0Var;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f27413a.b(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f27413a.c(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f27413a.d(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f27413a.e(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f27413a.f(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f27413a.g(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        @v0(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f27413a.h(list, list2, new k0.a() { // from class: f0.c
                @Override // f0.k0.a
                public final void a() {
                    b.e.a(onSharedElementsReadyListener);
                }
            });
        }
    }

    public static void A(@n0 Activity activity) {
        c.a(activity);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static k B() {
        return f27409i;
    }

    @p0
    public static Uri C(@n0 Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return d.a(activity);
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    @Deprecated
    public static boolean D(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean E(@n0 Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 31 ? h.a(activity) : i10 == 30 ? (g.a(activity) == null || g.a(activity).getDisplayId() == 0) ? false : true : (i10 != 29 || activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) ? false : true;
    }

    public static /* synthetic */ void F(Activity activity) {
        if (activity.isFinishing() || f0.f.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void G(@n0 Activity activity) {
        c.b(activity);
    }

    public static void H(@n0 final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: f0.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.F(activity);
                }
            });
        }
    }

    @p0
    public static androidx.core.view.h I(@n0 Activity activity, @n0 DragEvent dragEvent) {
        return androidx.core.view.h.b(activity, dragEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @r0(markerClass = {a.b.class})
    public static void J(@n0 Activity activity, @n0 String[] strArr, @g.f0(from = 0) int i10) {
        k kVar = f27409i;
        if (kVar == null || !kVar.b(activity, strArr, i10)) {
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (TextUtils.isEmpty(strArr[i11])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (!androidx.core.os.a.k() && TextUtils.equals(strArr[i11], c.a.f9430a)) {
                    hashSet.add(Integer.valueOf(i11));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i12 = 0;
                for (int i13 = 0; i13 < strArr.length; i13++) {
                    if (!hashSet.contains(Integer.valueOf(i13))) {
                        strArr2[i12] = strArr[i13];
                        i12++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof l) {
                    ((l) activity).q(i10);
                }
                e.b(activity, strArr, i10);
            } else if (activity instanceof j) {
                new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i10));
            }
        }
    }

    @n0
    public static <T extends View> T K(@n0 Activity activity, @g.d0 int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) f.a(activity, i10);
        }
        T t10 = (T) activity.findViewById(i10);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void L(@n0 Activity activity, @p0 k0 k0Var) {
        c.c(activity, k0Var != null ? new m(k0Var) : null);
    }

    public static void M(@n0 Activity activity, @p0 k0 k0Var) {
        c.d(activity, k0Var != null ? new m(k0Var) : null);
    }

    public static void N(@n0 Activity activity, @p0 h0.c0 c0Var, @p0 Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            g.b(activity, c0Var, bundle);
        }
    }

    public static void O(@p0 k kVar) {
        f27409i = kVar;
    }

    @r0(markerClass = {a.b.class})
    public static boolean P(@n0 Activity activity, @n0 String str) {
        if (!androidx.core.os.a.k() && TextUtils.equals(c.a.f9430a, str)) {
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 32) {
            return i.a(activity, str);
        }
        if (i10 == 31) {
            return h.b(activity, str);
        }
        if (i10 >= 23) {
            return e.c(activity, str);
        }
        return false;
    }

    public static void Q(@n0 Activity activity, @n0 Intent intent, int i10, @p0 Bundle bundle) {
        C0318b.b(activity, intent, i10, bundle);
    }

    public static void R(@n0 Activity activity, @n0 IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        C0318b.c(activity, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void S(@n0 Activity activity) {
        c.e(activity);
    }

    public static void z(@n0 Activity activity) {
        C0318b.a(activity);
    }
}
