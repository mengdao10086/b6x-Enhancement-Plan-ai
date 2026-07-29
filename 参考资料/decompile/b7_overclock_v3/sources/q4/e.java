package q4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f47114b = "ManifestParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f47115c = "GlideModule";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f47116a;

    public e(Context context) {
        this.f47116a = context;
    }

    public static c b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e10) {
                c(cls, e10);
            } catch (InstantiationException e11) {
                c(cls, e11);
            } catch (NoSuchMethodException e12) {
                c(cls, e12);
            } catch (InvocationTargetException e13) {
                c(cls, e13);
            }
            if (objNewInstance instanceof c) {
                return (c) objNewInstance;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e14) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e14);
        }
    }

    public static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<c> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f47116a.getPackageManager().getApplicationInfo(this.f47116a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return arrayList;
            }
            if (Log.isLoggable(f47114b, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Got app info metadata: ");
                sb2.append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (f47115c.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(b(str));
                    if (Log.isLoggable(f47114b, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Loaded Glide module: ");
                        sb3.append(str);
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e10);
        }
    }
}
