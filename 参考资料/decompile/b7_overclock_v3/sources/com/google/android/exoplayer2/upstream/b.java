package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.blankj.utilcode.util.i0;
import com.tencent.connect.common.Constants;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19085l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f19086m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19087n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f19088o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f19089p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f19090q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f19091r = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f19092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final byte[] f19095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f19096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f19097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f19098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f19099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final String f19100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f19101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final Object f19102k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.b$b, reason: collision with other inner class name */
    public static final class C0198b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public Uri f19103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public byte[] f19106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f19107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f19108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f19109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public String f19110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public Object f19112j;

        public b a() {
            hd.a.l(this.f19103a, "The uri must be set.");
            return new b(this.f19103a, this.f19104b, this.f19105c, this.f19106d, this.f19107e, this.f19108f, this.f19109g, this.f19110h, this.f19111i, this.f19112j);
        }

        public C0198b b(@p0 Object obj) {
            this.f19112j = obj;
            return this;
        }

        public C0198b c(int i10) {
            this.f19111i = i10;
            return this;
        }

        public C0198b d(@p0 byte[] bArr) {
            this.f19106d = bArr;
            return this;
        }

        public C0198b e(int i10) {
            this.f19105c = i10;
            return this;
        }

        public C0198b f(Map<String, String> map) {
            this.f19107e = map;
            return this;
        }

        public C0198b g(@p0 String str) {
            this.f19110h = str;
            return this;
        }

        public C0198b h(long j10) {
            this.f19109g = j10;
            return this;
        }

        public C0198b i(long j10) {
            this.f19108f = j10;
            return this;
        }

        public C0198b j(Uri uri) {
            this.f19103a = uri;
            return this;
        }

        public C0198b k(String str) {
            this.f19103a = Uri.parse(str);
            return this;
        }

        public C0198b l(long j10) {
            this.f19104b = j10;
            return this;
        }

        public C0198b() {
            this.f19105c = 1;
            this.f19107e = Collections.emptyMap();
            this.f19109g = -1L;
        }

        public C0198b(b bVar) {
            this.f19103a = bVar.f19092a;
            this.f19104b = bVar.f19093b;
            this.f19105c = bVar.f19094c;
            this.f19106d = bVar.f19095d;
            this.f19107e = bVar.f19096e;
            this.f19108f = bVar.f19098g;
            this.f19109g = bVar.f19099h;
            this.f19110h = bVar.f19100i;
            this.f19111i = bVar.f19101j;
            this.f19112j = bVar.f19102k;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public static String c(int i10) {
        if (i10 == 1) {
            return Constants.HTTP_GET;
        }
        if (i10 == 2) {
            return Constants.HTTP_POST;
        }
        if (i10 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public C0198b a() {
        return new C0198b();
    }

    public final String b() {
        return c(this.f19094c);
    }

    public boolean d(int i10) {
        return (this.f19101j & i10) == i10;
    }

    public b e(long j10) {
        long j11 = this.f19099h;
        return f(j10, j11 != -1 ? j11 - j10 : -1L);
    }

    public b f(long j10, long j11) {
        return (j10 == 0 && this.f19099h == j11) ? this : new b(this.f19092a, this.f19093b, this.f19094c, this.f19095d, this.f19096e, this.f19098g + j10, j11, this.f19100i, this.f19101j, this.f19102k);
    }

    public b g(Map<String, String> map) {
        HashMap map2 = new HashMap(this.f19096e);
        map2.putAll(map);
        return new b(this.f19092a, this.f19093b, this.f19094c, this.f19095d, map2, this.f19098g, this.f19099h, this.f19100i, this.f19101j, this.f19102k);
    }

    public b h(Map<String, String> map) {
        return new b(this.f19092a, this.f19093b, this.f19094c, this.f19095d, map, this.f19098g, this.f19099h, this.f19100i, this.f19101j, this.f19102k);
    }

    public b i(Uri uri) {
        return new b(uri, this.f19093b, this.f19094c, this.f19095d, this.f19096e, this.f19098g, this.f19099h, this.f19100i, this.f19101j, this.f19102k);
    }

    public String toString() {
        return "DataSpec[" + b() + i0.f11861z + this.f19092a + ", " + this.f19098g + ", " + this.f19099h + ", " + this.f19100i + ", " + this.f19101j + "]";
    }

    public b(Uri uri) {
        this(uri, 0L, -1L);
    }

    public b(Uri uri, long j10, long j11) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j10, j11, null, 0, null);
    }

    @Deprecated
    public b(Uri uri, int i10) {
        this(uri, 0L, -1L, null, i10);
    }

    @Deprecated
    public b(Uri uri, long j10, long j11, @p0 String str) {
        this(uri, j10, j10, j11, str, 0);
    }

    @Deprecated
    public b(Uri uri, long j10, long j11, @p0 String str, int i10) {
        this(uri, j10, j10, j11, str, i10);
    }

    @Deprecated
    public b(Uri uri, long j10, long j11, @p0 String str, int i10, Map<String, String> map) {
        this(uri, 1, null, j10, j10, j11, str, i10, map);
    }

    @Deprecated
    public b(Uri uri, long j10, long j11, long j12, @p0 String str, int i10) {
        this(uri, null, j10, j11, j12, str, i10);
    }

    @Deprecated
    public b(Uri uri, @p0 byte[] bArr, long j10, long j11, long j12, @p0 String str, int i10) {
        this(uri, bArr != null ? 2 : 1, bArr, j10, j11, j12, str, i10);
    }

    @Deprecated
    public b(Uri uri, int i10, @p0 byte[] bArr, long j10, long j11, long j12, @p0 String str, int i11) {
        this(uri, i10, bArr, j10, j11, j12, str, i11, Collections.emptyMap());
    }

    @Deprecated
    public b(Uri uri, int i10, @p0 byte[] bArr, long j10, long j11, long j12, @p0 String str, int i11, Map<String, String> map) {
        this(uri, j10 - j11, i10, bArr, map, j11, j12, str, i11, null);
    }

    public b(Uri uri, long j10, int i10, @p0 byte[] bArr, Map<String, String> map, long j11, long j12, @p0 String str, int i11, @p0 Object obj) {
        byte[] bArr2 = bArr;
        long j13 = j10 + j11;
        boolean z10 = true;
        hd.a.a(j13 >= 0);
        hd.a.a(j11 >= 0);
        if (j12 <= 0 && j12 != -1) {
            z10 = false;
        }
        hd.a.a(z10);
        this.f19092a = uri;
        this.f19093b = j10;
        this.f19094c = i10;
        this.f19095d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f19096e = Collections.unmodifiableMap(new HashMap(map));
        this.f19098g = j11;
        this.f19097f = j13;
        this.f19099h = j12;
        this.f19100i = str;
        this.f19101j = i11;
        this.f19102k = obj;
    }
}
