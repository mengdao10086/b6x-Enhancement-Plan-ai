package com.just.agentweb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.android.material.snackbar.Snackbar;
import g.n0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xf.c0;
import xf.g0;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21850a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f21851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<Snackbar> f21852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Toast f21853d;

    public a() {
        throw new UnsupportedOperationException("u can't init me");
    }

    public static String A(Context context, Uri uri) {
        String string;
        c0.c(f21850a, "method -> getRealPathBelowVersion " + uri + "   path:" + uri.getPath() + "    getAuthority:" + uri.getAuthority());
        String[] strArr = {"_data"};
        Cursor cursorT = new r1.b(context, uri, strArr, null, null, null).I();
        if (cursorT != null) {
            cursorT.moveToFirst();
            string = cursorT.getString(cursorT.getColumnIndex(strArr[0]));
            cursorT.close();
        } else {
            string = null;
        }
        return string == null ? uri.getPath() : string;
    }

    @Deprecated
    public static void B(Activity activity, String str, String str2) {
        xf.b bVarF;
        if (activity == null || activity.isFinishing() || (bVarF = ((i) activity.findViewById(R.id.web_parent_layout_id)).a()) == null) {
            return;
        }
        bVarF.p(str, str2);
    }

    public static Uri C(Context context, File file) {
        return Build.VERSION.SDK_INT >= 24 ? D(context, file) : Uri.fromFile(file);
    }

    public static Uri D(Context context, File file) {
        return FileProvider.f(context, context.getPackageName() + ".AgentWebFileProvider", file);
    }

    public static i E(WebView webView) {
        if (!(webView.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException("please check webcreator's create method was be called ?");
        }
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        while (viewGroup != null) {
            String str = f21850a;
            c0.c(str, "ViewGroup:" + viewGroup);
            if (viewGroup.getId() == R.id.web_parent_layout_id) {
                i iVar = (i) viewGroup;
                c0.c(str, "found WebParentLayout");
                return iVar;
            }
            ViewParent parent = viewGroup.getParent();
            viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        throw new IllegalStateException("please check webcreator's create method was be called ?");
    }

    public static void F(Context context, Intent intent, Uri uri, boolean z10) {
        int i10 = z10 ? 3 : 1;
        intent.addFlags(i10);
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it2.hasNext()) {
            context.grantUriPermission(it2.next().activityInfo.packageName, uri, i10);
        }
    }

    public static boolean G(@n0 Context context, @n0 List<String> list) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : list) {
            if (h0.d.a(context, str) == -1) {
                return false;
            }
            String strF = f0.j.f(str);
            if (!TextUtils.isEmpty(strF) && f0.j.d(context, strF, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean H(@n0 Context context, @n0 String... strArr) {
        return G(context, Arrays.asList(strArr));
    }

    public static boolean I(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean J(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean K(Map map) {
        return map == null || map.isEmpty();
    }

    public static Method L(Object obj, String str, Class... clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public static boolean M(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean N(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean O(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.startsWith("[")) {
                new JSONArray(str);
            } else {
                new JSONObject(str);
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean P(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean Q(Object obj, String str, String str2, Class... clsArr) {
        c0.c(f21850a, "  methodName:" + str + "   method:" + str2);
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        try {
            z10 = !obj.getClass().getMethod(str, clsArr).toGenericString().contains(str2);
        } catch (Exception e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
        }
        c0.c(f21850a, "isOverriedMethod:" + z10);
        return z10;
    }

    public static boolean R() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String S(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e10) {
            if (!c0.d()) {
                return "";
            }
            e10.printStackTrace();
            return "";
        }
    }

    public static void T(Runnable runnable) {
        if (f21851b == null) {
            f21851b = new Handler(Looper.getMainLooper());
        }
        f21851b.post(runnable);
    }

    public static void U(Context context, Intent intent, File file, boolean z10) {
        if (Build.VERSION.SDK_INT < 24) {
            intent.setData(Uri.fromFile(file));
            return;
        }
        intent.setData(C(context, file));
        intent.addFlags(1);
        if (z10) {
            intent.addFlags(2);
        }
    }

    public static void V(Context context, Intent intent, String str, File file, boolean z10) {
        if (Build.VERSION.SDK_INT < 24) {
            intent.setDataAndType(Uri.fromFile(file), str);
            return;
        }
        intent.setDataAndType(C(context, file), str);
        intent.addFlags(1);
        if (z10) {
            intent.addFlags(2);
        }
    }

    public static void W(View view, CharSequence charSequence, int i10, @g.l int i11, @g.l int i12, CharSequence charSequence2, @g.l int i13, View.OnClickListener onClickListener) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i11), 0, spannableString.length(), 33);
        WeakReference<Snackbar> weakReference = new WeakReference<>(Snackbar.C0(view, spannableString, i10));
        f21852c = weakReference;
        Snackbar snackbar = weakReference.get();
        snackbar.K().setBackgroundColor(i12);
        if (charSequence2 != null && charSequence2.length() > 0 && onClickListener != null) {
            snackbar.G0(i13);
            snackbar.F0(charSequence2, onClickListener);
        }
        snackbar.k0();
    }

    public static boolean X(Activity activity, WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams, g0 g0Var, ValueCallback valueCallback2, String str, Handler.Callback callback) {
        try {
            Object objInvoke = Class.forName("com.just.agentweb.filechooser.a").getDeclaredMethod("newBuilder", Activity.class, WebView.class).invoke(null, activity, webView);
            Class<?> cls = objInvoke.getClass();
            if (valueCallback != null) {
                Method declaredMethod = cls.getDeclaredMethod("setUriValueCallbacks", ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(objInvoke, valueCallback);
            }
            if (fileChooserParams != null) {
                Method declaredMethod2 = cls.getDeclaredMethod("setFileChooserParams", WebChromeClient.FileChooserParams.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(objInvoke, fileChooserParams);
            }
            if (valueCallback2 != null) {
                Method declaredMethod3 = cls.getDeclaredMethod("setUriValueCallback", ValueCallback.class);
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(objInvoke, valueCallback2);
            }
            if (!TextUtils.isEmpty(str)) {
                Method declaredMethod4 = cls.getDeclaredMethod("setAcceptType", String.class);
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(objInvoke, str);
            }
            if (callback != null) {
                Method declaredMethod5 = cls.getDeclaredMethod("setJsChannelCallback", Handler.Callback.class);
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(objInvoke, callback);
            }
            Method declaredMethod6 = cls.getDeclaredMethod("setPermissionInterceptor", g0.class);
            declaredMethod6.setAccessible(true);
            declaredMethod6.invoke(objInvoke, g0Var);
            Method declaredMethod7 = cls.getDeclaredMethod("build", new Class[0]);
            declaredMethod7.setAccessible(true);
            Object objInvoke2 = declaredMethod7.invoke(objInvoke, new Object[0]);
            Method declaredMethod8 = objInvoke2.getClass().getDeclaredMethod("openFileChooser", new Class[0]);
            declaredMethod8.setAccessible(true);
            declaredMethod8.invoke(objInvoke2, new Object[0]);
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
            if (valueCallback != null) {
                c0.c(f21850a, "onReceiveValue empty");
                return false;
            }
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
        return true;
    }

    public static void Y(Context context, String str) {
        Toast toast = f21853d;
        if (toast == null) {
            f21853d = Toast.makeText(context.getApplicationContext(), str, 0);
        } else {
            toast.setText(str);
        }
        f21853d.show();
    }

    public static String[] Z(Activity activity, Uri[] uriArr) {
        if (activity != null && uriArr != null && uriArr.length != 0) {
            try {
                String[] strArr = new String[uriArr.length];
                int length = uriArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    strArr[i11] = w(activity, uriArr[i10]);
                    i10++;
                    i11 = i12;
                }
                return strArr;
            } catch (Throwable th2) {
                if (c0.d()) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static int b(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()
            r0 = 0
            if (r3 != 0) goto L10
            return r0
        L10:
            int r1 = r3.getType()
            if (r1 == 0) goto L22
            r3 = 1
            if (r1 == r3) goto L21
            r2 = 6
            if (r1 == r2) goto L21
            r2 = 9
            if (r1 == r2) goto L21
            return r0
        L21:
            return r3
        L22:
            int r3 = r3.getSubtype()
            switch(r3) {
                case 1: goto L31;
                case 2: goto L31;
                case 3: goto L2f;
                case 4: goto L2f;
                case 5: goto L2f;
                case 6: goto L2f;
                default: goto L29;
            }
        L29:
            switch(r3) {
                case 12: goto L2f;
                case 13: goto L2d;
                case 14: goto L2d;
                case 15: goto L2d;
                default: goto L2c;
            }
        L2c:
            return r0
        L2d:
            r3 = 2
            return r3
        L2f:
            r3 = 3
            return r3
        L31:
            r3 = 4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.just.agentweb.a.b(android.content.Context):int");
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public static void d(Context context) {
        try {
            f(new File(o(context)), 0);
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public static void e(Context context, int i10) {
        String.format("Starting cache prune, deleting files older than %d days", Integer.valueOf(i10));
        String.format("Cache pruning completed, %d files deleted", Integer.valueOf(f(context.getCacheDir(), i10)));
    }

    public static int f(File file, int i10) {
        int iF;
        if (file != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dir:");
            sb2.append(file.getAbsolutePath());
        }
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            iF = 0;
            for (File file2 : file.listFiles()) {
                try {
                    if (file2.isDirectory()) {
                        iF += f(file2, i10);
                    }
                    if (file2.lastModified() < new Date().getTime() - (((long) i10) * 86400000)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("file name:");
                        sb3.append(file2.getName());
                        if (file2.delete()) {
                            iF++;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    String.format("Failed to clean the cache, result %s", e.getMessage());
                    return iF;
                }
            }
        } catch (Exception e11) {
            e = e11;
            iF = 0;
        }
        return iF;
    }

    public static final void g(WebView webView) {
        if (webView != null && Looper.myLooper() == Looper.getMainLooper()) {
            webView.loadUrl("about:blank");
            webView.stopLoading();
            if (webView.getHandler() != null) {
                webView.getHandler().removeCallbacksAndMessages(null);
            }
            webView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
        }
    }

    public static void h(Context context) {
        try {
            i(context, new WebView(context.getApplicationContext()));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void i(Context context, WebView webView) {
        try {
            xf.c.l(null);
            webView.getSettings().setCacheMode(2);
            context.deleteDatabase("webviewCache.db");
            context.deleteDatabase("webview.db");
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            f(new File(xf.c.e(context)), 0);
        } catch (Exception e10) {
            if (xf.c.f55199d) {
                e10.printStackTrace();
            }
        }
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static File k(Context context, String str, boolean z10) throws IOException {
        String strO = o(context);
        if (TextUtils.isEmpty(strO)) {
            return null;
        }
        File file = new File(strO, str);
        if (!file.exists()) {
            file.createNewFile();
        } else if (z10) {
            file.delete();
            file.createNewFile();
        }
        return file;
    }

    public static File l(Context context) {
        try {
            return k(context, String.format("aw_%s.jpg", new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date())), true);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m() {
        WeakReference<Snackbar> weakReference = f21852c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        f21852c.get().x();
        f21852c = null;
    }

    public static int n(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String o(Context context) {
        if (!TextUtils.isEmpty(xf.c.f55198c)) {
            return xf.c.f55198c;
        }
        File file = new File(v(context), xf.c.f55196a);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
            c0.c(f21850a, "create dir exception");
        }
        c0.c(f21850a, "path:" + file.getAbsolutePath() + "  path:" + file.getPath());
        String absolutePath = file.getAbsolutePath();
        xf.c.f55198c = absolutePath;
        return absolutePath;
    }

    public static xf.b p(WebView webView) {
        return E(webView).a();
    }

    public static String q(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static long r() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (RuntimeException unused) {
            return 0L;
        }
    }

    public static Intent s(Context context, File file) {
        Intent action = new Intent().setAction("android.intent.action.VIEW");
        V(context, action, z(file), file, false);
        return action;
    }

    public static String t(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static List<String> u(Activity activity, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (!H(activity, strArr[i10])) {
                arrayList.add(strArr[i10]);
            }
        }
        return arrayList;
    }

    public static String v(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if ("mounted".equals(androidx.core.os.h.a(externalCacheDir))) {
            return externalCacheDir.getAbsolutePath();
        }
        return null;
    }

    @TargetApi(19)
    public static String w(Activity activity, Uri uri) {
        Uri uri2 = null;
        if (activity != null && uri != null) {
            c0.c(f21850a, "getAuthority:" + uri.getAuthority() + "  getHost:" + uri.getHost() + "   getPath:" + uri.getPath() + "  getScheme:" + uri.getScheme() + "  query:" + uri.getQuery());
            if (!DocumentsContract.isDocumentUri(activity, uri)) {
                if (uri.getAuthority().equalsIgnoreCase(activity.getPackageName() + ".AgentWebFileProvider")) {
                    String path = uri.getPath();
                    return o(activity) + File.separator + path.substring(path.lastIndexOf(fh.a.f28350w) + 1, path.length());
                }
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return N(uri) ? uri.getLastPathSegment() : t(activity, uri, null, null);
                }
                if (m7.a.f40702b.equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if (M(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + fh.a.f28350w + strArrSplit[1];
                }
            } else {
                if (I(uri)) {
                    return t(activity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (P(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return t(activity, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        }
        return null;
    }

    public static Intent x(Context context, File file) {
        Intent action = new Intent().setAction("android.intent.action.VIEW");
        V(context, action, "application/vnd.android.package-archive", file, false);
        return action;
    }

    public static Intent y(Context context, File file) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uriC = C(context, file);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("output", uriC);
        return intent;
    }

    public static String z(File file) {
        String name = file.getName();
        String lowerCase = name.substring(name.lastIndexOf(j3.b.f36044h) + 1, name.length()).toLowerCase();
        return lowerCase.equals("pdf") ? "application/pdf" : (lowerCase.equals("m4a") || lowerCase.equals("mp3") || lowerCase.equals("mid") || lowerCase.equals("xmf") || lowerCase.equals("ogg") || lowerCase.equals("wav")) ? "audio/*" : (lowerCase.equals("3gp") || lowerCase.equals("mp4")) ? "video/*" : (lowerCase.equals("jpg") || lowerCase.equals("gif") || lowerCase.equals("png") || lowerCase.equals("jpeg") || lowerCase.equals("bmp")) ? "image/*" : lowerCase.equals("apk") ? "application/vnd.android.package-archive" : (lowerCase.equals("pptx") || lowerCase.equals("ppt")) ? "application/vnd.ms-powerpoint" : (lowerCase.equals("docx") || lowerCase.equals("doc")) ? "application/vnd.ms-word" : (lowerCase.equals("xlsx") || lowerCase.equals("xls")) ? "application/vnd.ms-excel" : "*/*";
    }
}
