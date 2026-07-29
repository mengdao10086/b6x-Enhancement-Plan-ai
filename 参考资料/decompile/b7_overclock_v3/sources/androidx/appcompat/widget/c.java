package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends DataSetObservable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f2365n = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f2367p = "historical-records";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f2368q = "historical-record";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f2369r = "activity";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f2370s = "time";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2371t = "weight";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f2372u = "activity_choser_model_history.xml";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2373v = 50;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2374w = 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final float f2375x = 1.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f2376y = ".xml";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f2377z = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f2381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f2383f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f2390m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f2366o = c.class.getSimpleName();
    public static final Object A = new Object();
    public static final Map<String, c> B = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2378a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f2379b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f2380c = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InterfaceC0034c f2384g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2385h = 50;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2386i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2387j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2388k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2389l = false;

    public interface a {
        void setActivityChooserModel(c cVar);
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f2391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2392b;

        public b(ResolveInfo resolveInfo) {
            this.f2391a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Float.floatToIntBits(bVar.f2392b) - Float.floatToIntBits(this.f2392b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && Float.floatToIntBits(this.f2392b) == Float.floatToIntBits(((b) obj).f2392b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2392b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f2391a.toString() + "; weight:" + new BigDecimal(this.f2392b) + "]";
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    public interface InterfaceC0034c {
        void a(Intent intent, List<b> list, List<e> list2);
    }

    public static final class d implements InterfaceC0034c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f2393b = 0.95f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<ComponentName, b> f2394a = new HashMap();

        @Override // androidx.appcompat.widget.c.InterfaceC0034c
        public void a(Intent intent, List<b> list, List<e> list2) {
            Map<ComponentName, b> map = this.f2394a;
            map.clear();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = list.get(i10);
                bVar.f2392b = 0.0f;
                ActivityInfo activityInfo = bVar.f2391a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), bVar);
            }
            float f10 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                e eVar = list2.get(size2);
                b bVar2 = map.get(eVar.f2395a);
                if (bVar2 != null) {
                    bVar2.f2392b += eVar.f2397c * f10;
                    f10 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f2395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f2397c;

        public e(String str, long j10, float f10) {
            this(ComponentName.unflattenFromString(str), j10, f10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            ComponentName componentName = this.f2395a;
            if (componentName == null) {
                if (eVar.f2395a != null) {
                    return false;
                }
            } else if (!componentName.equals(eVar.f2395a)) {
                return false;
            }
            return this.f2396b == eVar.f2396b && Float.floatToIntBits(this.f2397c) == Float.floatToIntBits(eVar.f2397c);
        }

        public int hashCode() {
            ComponentName componentName = this.f2395a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j10 = this.f2396b;
            return ((((iHashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Float.floatToIntBits(this.f2397c);
        }

        public String toString() {
            return "[; activity:" + this.f2395a + "; time:" + this.f2396b + "; weight:" + new BigDecimal(this.f2397c) + "]";
        }

        public e(ComponentName componentName, long j10, float f10) {
            this.f2395a = componentName;
            this.f2396b = j10;
            this.f2397c = f10;
        }
    }

    public interface f {
        boolean a(c cVar, Intent intent);
    }

    public final class g extends AsyncTask<Object, Void, Void> {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.g.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    public c(Context context, String str) {
        this.f2381d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(f2376y)) {
            this.f2382e = str;
            return;
        }
        this.f2382e = str + f2376y;
    }

    public static c d(Context context, String str) {
        c cVar;
        synchronized (A) {
            Map<String, c> map = B;
            cVar = map.get(str);
            if (cVar == null) {
                cVar = new c(context, str);
                map.put(str, cVar);
            }
        }
        return cVar;
    }

    public final boolean a(e eVar) {
        boolean zAdd = this.f2380c.add(eVar);
        if (zAdd) {
            this.f2388k = true;
            n();
            m();
            v();
            notifyChanged();
        }
        return zAdd;
    }

    public Intent b(int i10) {
        synchronized (this.f2378a) {
            if (this.f2383f == null) {
                return null;
            }
            c();
            ActivityInfo activityInfo = this.f2379b.get(i10).f2391a.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.f2383f);
            intent.setComponent(componentName);
            if (this.f2390m != null) {
                if (this.f2390m.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new e(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final void c() {
        boolean zL = l() | o();
        n();
        if (zL) {
            v();
            notifyChanged();
        }
    }

    public ResolveInfo e(int i10) {
        ResolveInfo resolveInfo;
        synchronized (this.f2378a) {
            c();
            resolveInfo = this.f2379b.get(i10).f2391a;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f2378a) {
            c();
            size = this.f2379b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f2378a) {
            c();
            List<b> list = this.f2379b;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (list.get(i10).f2391a == resolveInfo) {
                    return i10;
                }
            }
            return -1;
        }
    }

    public ResolveInfo h() {
        synchronized (this.f2378a) {
            c();
            if (this.f2379b.isEmpty()) {
                return null;
            }
            return this.f2379b.get(0).f2391a;
        }
    }

    public int i() {
        int i10;
        synchronized (this.f2378a) {
            i10 = this.f2385h;
        }
        return i10;
    }

    public int j() {
        int size;
        synchronized (this.f2378a) {
            c();
            size = this.f2380c.size();
        }
        return size;
    }

    public Intent k() {
        Intent intent;
        synchronized (this.f2378a) {
            intent = this.f2383f;
        }
        return intent;
    }

    public final boolean l() {
        if (!this.f2389l || this.f2383f == null) {
            return false;
        }
        this.f2389l = false;
        this.f2379b.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f2381d.getPackageManager().queryIntentActivities(this.f2383f, 0);
        int size = listQueryIntentActivities.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f2379b.add(new b(listQueryIntentActivities.get(i10)));
        }
        return true;
    }

    public final void m() {
        if (!this.f2387j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f2388k) {
            this.f2388k = false;
            if (TextUtils.isEmpty(this.f2382e)) {
                return;
            }
            new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f2380c), this.f2382e);
        }
    }

    public final void n() {
        int size = this.f2380c.size() - this.f2385h;
        if (size <= 0) {
            return;
        }
        this.f2388k = true;
        for (int i10 = 0; i10 < size; i10++) {
            this.f2380c.remove(0);
        }
    }

    public final boolean o() {
        if (!this.f2386i || !this.f2388k || TextUtils.isEmpty(this.f2382e)) {
            return false;
        }
        this.f2386i = false;
        this.f2387j = true;
        p();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r10 = this;
            java.lang.String r0 = "Error reading historical recrod file: "
            android.content.Context r1 = r10.f2381d     // Catch: java.io.FileNotFoundException -> Lac
            java.lang.String r2 = r10.f2382e     // Catch: java.io.FileNotFoundException -> Lac
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> Lac
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r3 = "UTF-8"
            r2.setInput(r1, r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            r3 = 0
        L14:
            r4 = 1
            if (r3 == r4) goto L1f
            r5 = 2
            if (r3 == r5) goto L1f
            int r3 = r2.next()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            goto L14
        L1f:
            java.lang.String r3 = "historical-records"
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            if (r3 == 0) goto L7b
            java.util.List<androidx.appcompat.widget.c$e> r3 = r10.f2380c     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            r3.clear()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
        L30:
            int r5 = r2.next()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            if (r5 != r4) goto L3c
            if (r1 == 0) goto La5
        L38:
            r1.close()     // Catch: java.io.IOException -> La5
            goto La5
        L3c:
            r6 = 3
            if (r5 == r6) goto L30
            r6 = 4
            if (r5 != r6) goto L43
            goto L30
        L43:
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r6 = "historical-record"
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            if (r5 == 0) goto L73
            java.lang.String r5 = "activity"
            r6 = 0
            java.lang.String r5 = r2.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r7 = "time"
            java.lang.String r7 = r2.getAttributeValue(r6, r7)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r9 = "weight"
            java.lang.String r6 = r2.getAttributeValue(r6, r9)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            androidx.appcompat.widget.c$e r9 = new androidx.appcompat.widget.c$e     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            r9.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            r3.add(r9)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            goto L30
        L73:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r3 = "Share records file not well-formed."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            throw r2     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
        L7b:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            java.lang.String r3 = "Share records file does not start with historical-records tag."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
            throw r2     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85 org.xmlpull.v1.XmlPullParserException -> L95
        L83:
            r0 = move-exception
            goto La6
        L85:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L83
            r2.append(r0)     // Catch: java.lang.Throwable -> L83
            java.lang.String r0 = r10.f2382e     // Catch: java.lang.Throwable -> L83
            r2.append(r0)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto La5
            goto L38
        L95:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L83
            r2.append(r0)     // Catch: java.lang.Throwable -> L83
            java.lang.String r0 = r10.f2382e     // Catch: java.lang.Throwable -> L83
            r2.append(r0)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto La5
            goto L38
        La5:
            return
        La6:
            if (r1 == 0) goto Lab
            r1.close()     // Catch: java.io.IOException -> Lab
        Lab:
            throw r0
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.p():void");
    }

    public void q(InterfaceC0034c interfaceC0034c) {
        synchronized (this.f2378a) {
            if (this.f2384g == interfaceC0034c) {
                return;
            }
            this.f2384g = interfaceC0034c;
            if (v()) {
                notifyChanged();
            }
        }
    }

    public void r(int i10) {
        synchronized (this.f2378a) {
            c();
            b bVar = this.f2379b.get(i10);
            b bVar2 = this.f2379b.get(0);
            float f10 = bVar2 != null ? (bVar2.f2392b - bVar.f2392b) + 5.0f : 1.0f;
            ActivityInfo activityInfo = bVar.f2391a.activityInfo;
            a(new e(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f10));
        }
    }

    public void s(int i10) {
        synchronized (this.f2378a) {
            if (this.f2385h == i10) {
                return;
            }
            this.f2385h = i10;
            n();
            if (v()) {
                notifyChanged();
            }
        }
    }

    public void t(Intent intent) {
        synchronized (this.f2378a) {
            if (this.f2383f == intent) {
                return;
            }
            this.f2383f = intent;
            this.f2389l = true;
            c();
        }
    }

    public void u(f fVar) {
        synchronized (this.f2378a) {
            this.f2390m = fVar;
        }
    }

    public final boolean v() {
        if (this.f2384g == null || this.f2383f == null || this.f2379b.isEmpty() || this.f2380c.isEmpty()) {
            return false;
        }
        this.f2384g.a(this.f2383f, this.f2379b, Collections.unmodifiableList(this.f2380c));
        return true;
    }
}
