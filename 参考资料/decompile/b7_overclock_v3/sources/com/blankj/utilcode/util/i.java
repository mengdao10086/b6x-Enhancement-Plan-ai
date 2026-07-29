package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements w3.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f11807j = Long.MAX_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11808k = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11809l = "cdu_";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11810m = "by_";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11811n = "st_";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f11812o = "jo_";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f11813p = "ja_";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f11814q = "bi_";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f11815r = "dr_";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f11816s = "pa_";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f11817t = "se_";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Map<String, i> f11818u = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f11820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f11821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f11823i;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11824a = 14;

        public static byte[] d(byte[] bArr, int i10, int i11) {
            int i12 = i11 - i10;
            if (i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                System.arraycopy(bArr, i10, bArr2, 0, Math.min(bArr.length - i10, i12));
                return bArr2;
            }
            throw new IllegalArgumentException(i10 + " > " + i11);
        }

        public static String e(int i10) {
            return String.format(Locale.getDefault(), "_$%010d$_", Long.valueOf((System.currentTimeMillis() / 1000) + ((long) i10)));
        }

        public static byte[] f(byte[] bArr) {
            return h(bArr) ? d(bArr, 14, bArr.length) : bArr;
        }

        public static long g(byte[] bArr) {
            if (h(bArr)) {
                try {
                    return Long.parseLong(new String(d(bArr, 2, 12))) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
            return -1L;
        }

        public static boolean h(byte[] bArr) {
            return bArr != null && bArr.length >= 14 && bArr[0] == 95 && bArr[1] == 36 && bArr[12] == 36 && bArr[13] == 95;
        }

        public static boolean i(byte[] bArr) {
            long jG = g(bArr);
            return jG != -1 && System.currentTimeMillis() > jG;
        }

        public static byte[] j(int i10, byte[] bArr) {
            byte[] bytes = e(i10).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f11825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f11826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<File, Long> f11829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final File f11830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Thread f11831g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f11832a;

            /* JADX INFO: renamed from: com.blankj.utilcode.util.i$c$a$a, reason: collision with other inner class name */
            public class C0117a implements FilenameFilter {
                public C0117a() {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.startsWith(i.f11809l);
                }
            }

            public a(File file) {
                this.f11832a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = this.f11832a.listFiles(new C0117a());
                if (fileArrListFiles != null) {
                    int length = 0;
                    int i10 = 0;
                    for (File file : fileArrListFiles) {
                        length = (int) (((long) length) + file.length());
                        i10++;
                        c.this.f11829e.put(file, Long.valueOf(file.lastModified()));
                    }
                    c.this.f11825a.getAndAdd(length);
                    c.this.f11826b.getAndAdd(i10);
                }
            }
        }

        public class b implements FilenameFilter {
            public b() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(i.f11809l);
            }
        }

        public final boolean l() {
            File[] fileArrListFiles = this.f11830f.listFiles(new b());
            boolean z10 = true;
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    if (file.delete()) {
                        this.f11825a.addAndGet(-file.length());
                        this.f11826b.addAndGet(-1);
                        this.f11829e.remove(file);
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    this.f11829e.clear();
                    this.f11825a.set(0L);
                    this.f11826b.set(0);
                }
            }
            return z10;
        }

        public final int m() {
            v();
            return this.f11826b.get();
        }

        public final String n(String str) {
            return i.f11809l + str.substring(0, 3) + str.substring(3).hashCode();
        }

        public final long o() {
            v();
            return this.f11825a.get();
        }

        public final File p(String str) {
            v();
            File file = new File(this.f11830f, n(str));
            if (file.exists()) {
                this.f11826b.addAndGet(-1);
                this.f11825a.addAndGet(-file.length());
            }
            return file;
        }

        public final File q(String str) {
            File file = new File(this.f11830f, n(str));
            if (file.exists()) {
                return file;
            }
            return null;
        }

        public final void r(File file) {
            this.f11826b.addAndGet(1);
            this.f11825a.addAndGet(file.length());
            while (true) {
                if (this.f11826b.get() <= this.f11828d && this.f11825a.get() <= this.f11827c) {
                    return;
                }
                this.f11825a.addAndGet(-t());
                this.f11826b.addAndGet(-1);
            }
        }

        public final boolean s(String str) {
            File fileQ = q(str);
            if (fileQ == null) {
                return true;
            }
            if (!fileQ.delete()) {
                return false;
            }
            this.f11825a.addAndGet(-fileQ.length());
            this.f11826b.addAndGet(-1);
            this.f11829e.remove(fileQ);
            return true;
        }

        public final long t() {
            if (this.f11829e.isEmpty()) {
                return 0L;
            }
            Long l10 = Long.MAX_VALUE;
            File key = null;
            Set<Map.Entry<File, Long>> setEntrySet = this.f11829e.entrySet();
            synchronized (this.f11829e) {
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    Long value = entry.getValue();
                    if (value.longValue() < l10.longValue()) {
                        key = entry.getKey();
                        l10 = value;
                    }
                }
            }
            if (key == null) {
                return 0L;
            }
            long length = key.length();
            if (!key.delete()) {
                return 0L;
            }
            this.f11829e.remove(key);
            return length;
        }

        public final void u(File file) {
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.f11829e.put(file, lValueOf);
        }

        public final void v() {
            try {
                this.f11831g.join();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }

        public c(File file, long j10, int i10) {
            this.f11829e = Collections.synchronizedMap(new HashMap());
            this.f11830f = file;
            this.f11827c = j10;
            this.f11828d = i10;
            this.f11825a = new AtomicLong();
            this.f11826b = new AtomicInteger();
            Thread thread = new Thread(new a(file));
            this.f11831g = thread;
            thread.start();
        }
    }

    public i(String str, File file, long j10, int i10) {
        this.f11819e = str;
        this.f11820f = file;
        this.f11821g = j10;
        this.f11822h = i10;
    }

    public static i k() {
        return p("", Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static i l(long j10, int i10) {
        return p("", j10, i10);
    }

    public static i m(@g.n0 File file) {
        Objects.requireNonNull(file, "Argument 'cacheDir' of type File (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return n(file, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static i n(@g.n0 File file, long j10, int i10) {
        Objects.requireNonNull(file, "Argument 'cacheDir' of type File (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str = file.getAbsoluteFile() + "_" + j10 + "_" + i10;
        Map<String, i> map = f11818u;
        i iVar = map.get(str);
        if (iVar == null) {
            synchronized (i.class) {
                iVar = map.get(str);
                if (iVar == null) {
                    i iVar2 = new i(str, file, j10, i10);
                    map.put(str, iVar2);
                    iVar = iVar2;
                }
            }
        }
        return iVar;
    }

    public static i o(String str) {
        return p(str, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static i p(String str, long j10, int i10) {
        if (l1.C0(str)) {
            str = "cacheUtils";
        }
        return n(new File(j1.a().getCacheDir(), str), j10, i10);
    }

    public void A(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B(str, bitmap, -1);
    }

    public void B(@g.n0 String str, Bitmap bitmap, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11814q + str, l1.f(bitmap), i10);
    }

    public void C(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D(str, drawable, -1);
    }

    public void D(@g.n0 String str, Drawable drawable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11815r + str, l1.y(drawable), i10);
    }

    public void E(@g.n0 String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        F(str, parcelable, -1);
    }

    public void F(@g.n0 String str, Parcelable parcelable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11816s + str, l1.J0(parcelable), i10);
    }

    public void G(@g.n0 String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        H(str, serializable, -1);
    }

    public void H(@g.n0 String str, Serializable serializable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11817t + str, l1.W0(serializable), i10);
    }

    public void I(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        J(str, str2, -1);
    }

    public void J(@g.n0 String str, String str2, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11811n + str, l1.Z0(str2), i10);
    }

    public void K(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        L(str, jSONArray, -1);
    }

    public void L(@g.n0 String str, JSONArray jSONArray, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11813p + str, l1.E0(jSONArray), i10);
    }

    public void M(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        N(str, jSONObject, -1);
    }

    public void N(@g.n0 String str, JSONObject jSONObject, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11812o + str, l1.F0(jSONObject), i10);
    }

    public void O(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        P(str, bArr, -1);
    }

    public void P(@g.n0 String str, byte[] bArr, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(f11810m + str, bArr, i10);
    }

    public final byte[] Q(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R(str, null);
    }

    public final byte[] R(@g.n0 String str, byte[] bArr) {
        File fileQ;
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        c cVarH = h();
        if (cVarH == null || (fileQ = cVarH.q(str)) == null) {
            return bArr;
        }
        byte[] bArrO0 = l1.O0(fileQ);
        if (b.i(bArrO0)) {
            cVarH.s(str);
            return bArr;
        }
        cVarH.u(fileQ);
        return b.f(bArrO0);
    }

    public final void S(String str, byte[] bArr, int i10) {
        c cVarH;
        if (bArr == null || (cVarH = h()) == null) {
            return;
        }
        if (i10 >= 0) {
            bArr = b.j(i10, bArr);
        }
        File fileP = cVarH.p(str);
        l1.g1(fileP, bArr);
        cVarH.u(fileP);
        cVarH.r(fileP);
    }

    public boolean T(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        c cVarH = h();
        if (cVarH == null) {
            return true;
        }
        if (cVarH.s(f11810m + str)) {
            if (cVarH.s(f11811n + str)) {
                if (cVarH.s(f11812o + str)) {
                    if (cVarH.s(f11813p + str)) {
                        if (cVarH.s(f11814q + str)) {
                            if (cVarH.s(f11815r + str)) {
                                if (cVarH.s(f11816s + str)) {
                                    if (cVarH.s(f11817t + str)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean a() {
        c cVarH = h();
        if (cVarH == null) {
            return true;
        }
        return cVarH.l();
    }

    public Bitmap b(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return c(str, null);
    }

    public Bitmap c(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11814q + str);
        return bArrQ == null ? bitmap : l1.j(bArrQ);
    }

    public byte[] d(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return e(str, null);
    }

    public byte[] e(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R(f11810m + str, bArr);
    }

    public int f() {
        c cVarH = h();
        if (cVarH == null) {
            return 0;
        }
        return cVarH.m();
    }

    public long g() {
        c cVarH = h();
        if (cVarH == null) {
            return 0L;
        }
        return cVarH.o();
    }

    public final c h() {
        if (this.f11820f.exists()) {
            if (this.f11823i == null) {
                this.f11823i = new c(this.f11820f, this.f11821g, this.f11822h);
            }
        } else if (this.f11820f.mkdirs()) {
            this.f11823i = new c(this.f11820f, this.f11821g, this.f11822h);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("can't make dirs in ");
            sb2.append(this.f11820f.getAbsolutePath());
        }
        return this.f11823i;
    }

    public Drawable i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(str, null);
    }

    public Drawable j(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11815r + str);
        return bArrQ == null ? drawable : l1.k(bArrQ);
    }

    public JSONArray q(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return r(str, null);
    }

    public JSONArray r(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11813p + str);
        return bArrQ == null ? jSONArray : l1.m(bArrQ);
    }

    public JSONObject s(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(str, null);
    }

    public JSONObject t(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11812o + str);
        return bArrQ == null ? jSONObject : l1.n(bArrQ);
    }

    public String toString() {
        return this.f11819e + "@" + Integer.toHexString(hashCode());
    }

    public <T> T u(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) v(str, creator, null);
    }

    public <T> T v(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11816s + str);
        return bArrQ == null ? t10 : (T) l1.p(bArrQ, creator);
    }

    public Object w(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return x(str, null);
    }

    public Object x(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11817t + str);
        return bArrQ == null ? obj : l1.o(bArrQ);
    }

    public String y(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return z(str, null);
    }

    public String z(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArrQ = Q(f11811n + str);
        return bArrQ == null ? str2 : l1.q(bArrQ);
    }
}
