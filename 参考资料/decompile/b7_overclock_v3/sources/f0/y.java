package f0;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import f0.v;
import g.v0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@v0(16)
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27889a = "NotificationCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27890b = "android.support.dataRemoteInputs";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27891c = "android.support.allowGeneratedReplies";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27892d = "icon";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27893e = "title";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27894f = "actionIntent";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27895g = "extras";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27896h = "remoteInputs";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f27897i = "dataOnlyRemoteInputs";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f27898j = "resultKey";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f27899k = "label";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f27900l = "choices";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f27901m = "allowFreeFormInput";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f27902n = "allowedDataTypes";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f27903o = "semanticAction";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f27904p = "showsUserInterface";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static Field f27906r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f27907s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static Field f27909u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Field f27910v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static Field f27911w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Field f27912x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f27913y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f27905q = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f27908t = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    public static boolean b() {
        if (f27913y) {
            return false;
        }
        try {
            if (f27909u == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                f27910v = cls.getDeclaredField("icon");
                f27911w = cls.getDeclaredField("title");
                f27912x = cls.getDeclaredField(f27894f);
                Field declaredField = Notification.class.getDeclaredField(v.z.f27858y);
                f27909u = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException unused) {
            f27913y = true;
        } catch (NoSuchFieldException unused2) {
            f27913y = true;
        }
        return true ^ f27913y;
    }

    public static h0 c(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f27902n);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return new h0(bundle.getString(f27898j), bundle.getCharSequence("label"), bundle.getCharSequenceArray(f27900l), bundle.getBoolean(f27901m), 0, bundle.getBundle("extras"), hashSet);
    }

    public static h0[] d(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        h0[] h0VarArr = new h0[bundleArr.length];
        for (int i10 = 0; i10 < bundleArr.length; i10++) {
            h0VarArr[i10] = c(bundleArr[i10]);
        }
        return h0VarArr;
    }

    public static v.b e(Notification notification, int i10) {
        SparseArray sparseParcelableArray;
        synchronized (f27908t) {
            try {
                try {
                    Object[] objArrH = h(notification);
                    if (objArrH != null) {
                        Object obj = objArrH[i10];
                        Bundle bundleK = k(notification);
                        return l(f27910v.getInt(obj), (CharSequence) f27911w.get(obj), (PendingIntent) f27912x.get(obj), (bundleK == null || (sparseParcelableArray = bundleK.getSparseParcelableArray(x.f27887e)) == null) ? null : (Bundle) sparseParcelableArray.get(i10));
                    }
                } catch (IllegalAccessException unused) {
                    f27913y = true;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static int f(Notification notification) {
        int length;
        synchronized (f27908t) {
            Object[] objArrH = h(notification);
            length = objArrH != null ? objArrH.length : 0;
        }
        return length;
    }

    public static v.b g(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        return new v.b(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(f27894f), bundle.getBundle("extras"), d(i(bundle, f27896h)), d(i(bundle, f27897i)), bundle2 != null ? bundle2.getBoolean(f27891c, false) : false, bundle.getInt(f27903o), bundle.getBoolean(f27904p), false, false);
    }

    public static Object[] h(Notification notification) {
        synchronized (f27908t) {
            if (!b()) {
                return null;
            }
            try {
                return (Object[]) f27909u.get(notification);
            } catch (IllegalAccessException unused) {
                f27913y = true;
                return null;
            }
        }
    }

    public static Bundle[] i(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    public static Bundle j(v.b bVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatF = bVar.f();
        bundle.putInt("icon", iconCompatF != null ? iconCompatF.A() : 0);
        bundle.putCharSequence("title", bVar.j());
        bundle.putParcelable(f27894f, bVar.a());
        Bundle bundle2 = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
        bundle2.putBoolean(f27891c, bVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray(f27896h, n(bVar.g()));
        bundle.putBoolean(f27904p, bVar.i());
        bundle.putInt(f27903o, bVar.h());
        return bundle;
    }

    public static Bundle k(Notification notification) {
        synchronized (f27905q) {
            if (f27907s) {
                return null;
            }
            try {
                if (f27906r == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        f27907s = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f27906r = declaredField;
                }
                Bundle bundle = (Bundle) f27906r.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f27906r.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                f27907s = true;
                return null;
            }
        }
    }

    public static v.b l(int i10, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        h0[] h0VarArrD;
        h0[] h0VarArrD2;
        boolean z10;
        if (bundle != null) {
            h0VarArrD = d(i(bundle, x.f27888f));
            h0VarArrD2 = d(i(bundle, f27890b));
            z10 = bundle.getBoolean(f27891c);
        } else {
            h0VarArrD = null;
            h0VarArrD2 = null;
            z10 = false;
        }
        return new v.b(i10, charSequence, pendingIntent, bundle, h0VarArrD, h0VarArrD2, z10, 0, true, false, false);
    }

    public static Bundle m(h0 h0Var) {
        Bundle bundle = new Bundle();
        bundle.putString(f27898j, h0Var.o());
        bundle.putCharSequence("label", h0Var.n());
        bundle.putCharSequenceArray(f27900l, h0Var.h());
        bundle.putBoolean(f27901m, h0Var.f());
        bundle.putBundle("extras", h0Var.m());
        Set<String> setG = h0Var.g();
        if (setG != null && !setG.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setG.size());
            Iterator<String> it2 = setG.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            bundle.putStringArrayList(f27902n, arrayList);
        }
        return bundle;
    }

    public static Bundle[] n(h0[] h0VarArr) {
        if (h0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[h0VarArr.length];
        for (int i10 = 0; i10 < h0VarArr.length; i10++) {
            bundleArr[i10] = m(h0VarArr[i10]);
        }
        return bundleArr;
    }

    public static Bundle o(Notification.Builder builder, v.b bVar) {
        IconCompat iconCompatF = bVar.f();
        builder.addAction(iconCompatF != null ? iconCompatF.A() : 0, bVar.j(), bVar.a());
        Bundle bundle = new Bundle(bVar.d());
        if (bVar.g() != null) {
            bundle.putParcelableArray(x.f27888f, n(bVar.g()));
        }
        if (bVar.c() != null) {
            bundle.putParcelableArray(f27890b, n(bVar.c()));
        }
        bundle.putBoolean(f27891c, bVar.b());
        return bundle;
    }
}
