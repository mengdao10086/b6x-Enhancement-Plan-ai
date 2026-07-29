package com.umeng.commonsdk.statistics.proto;

import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class b implements aw<b, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bi> f24291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f24292e = -6496538196005191531L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ca f24293f = new ca("IdSnapshot");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bq f24294g = new bq(HlsPlaylistParser.S, (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bq f24295h = new bq("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bq f24296i = new bq(db.d.f26139i, (byte) 8, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f24297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f24298k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f24299l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f24301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24302c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte f24303m;

    public static class a extends cf<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, b bVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                byte b10 = bqVarL.f23422b;
                if (b10 == 0) {
                    break;
                }
                short s10 = bqVarL.f23423c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            by.a(bvVar, b10);
                        } else if (b10 == 8) {
                            bVar.f24302c = bvVar.w();
                            bVar.c(true);
                        } else {
                            by.a(bvVar, b10);
                        }
                    } else if (b10 == 10) {
                        bVar.f24301b = bvVar.x();
                        bVar.b(true);
                    } else {
                        by.a(bvVar, b10);
                    }
                } else if (b10 == 11) {
                    bVar.f24300a = bvVar.z();
                    bVar.a(true);
                } else {
                    by.a(bvVar, b10);
                }
                bvVar.m();
            }
            bvVar.k();
            if (!bVar.g()) {
                throw new bw("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new bw("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, b bVar) throws bc {
            bVar.k();
            bvVar.a(b.f24293f);
            if (bVar.f24300a != null) {
                bvVar.a(b.f24294g);
                bvVar.a(bVar.f24300a);
                bvVar.c();
            }
            bvVar.a(b.f24295h);
            bvVar.a(bVar.f24301b);
            bvVar.c();
            bvVar.a(b.f24296i);
            bvVar.a(bVar.f24302c);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    public static class C0264b implements ce {
        private C0264b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends cg<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, b bVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(bVar.f24300a);
            cbVar.a(bVar.f24301b);
            cbVar.a(bVar.f24302c);
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, b bVar) throws bc {
            cb cbVar = (cb) bvVar;
            bVar.f24300a = cbVar.z();
            bVar.a(true);
            bVar.f24301b = cbVar.x();
            bVar.b(true);
            bVar.f24302c = cbVar.w();
            bVar.c(true);
        }
    }

    public static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        f24297j = map;
        map.put(cf.class, new C0264b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bi(HlsPlaylistParser.S, (byte) 1, new bj((byte) 11)));
        enumMap.put(e.TS, new bi("ts", (byte) 1, new bj((byte) 10)));
        enumMap.put(e.VERSION, new bi(db.d.f26139i, (byte) 1, new bj((byte) 8)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24291d = mapUnmodifiableMap;
        bi.a(b.class, mapUnmodifiableMap);
    }

    public b() {
        this.f24303m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f24300a;
    }

    public void c() {
        this.f24300a = null;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f24300a = null;
        b(false);
        this.f24301b = 0L;
        c(false);
        this.f24302c = 0;
    }

    public boolean d() {
        return this.f24300a != null;
    }

    public long e() {
        return this.f24301b;
    }

    public void f() {
        this.f24303m = at.b(this.f24303m, 0);
    }

    public boolean g() {
        return at.a(this.f24303m, 0);
    }

    public int h() {
        return this.f24302c;
    }

    public void i() {
        this.f24303m = at.b(this.f24303m, 1);
    }

    public boolean j() {
        return at.a(this.f24303m, 1);
    }

    public void k() throws bc {
        if (this.f24300a != null) {
            return;
        }
        throw new bw("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f24297j.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdSnapshot(");
        sb2.append("identity:");
        String str = this.f24300a;
        if (str == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("ts:");
        sb2.append(this.f24301b);
        sb2.append(", ");
        sb2.append("version:");
        sb2.append(this.f24302c);
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f24297j.get(bvVar.D()).b().a(bvVar, this);
    }

    public enum e implements bd {
        IDENTITY(1, HlsPlaylistParser.S),
        TS(2, "ts"),
        VERSION(3, db.d.f26139i);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f24307d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f24309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f24310f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f24307d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24309e = s10;
            this.f24310f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return IDENTITY;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i10) {
            e eVarA = a(i10);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.f24310f;
        }

        public static e a(String str) {
            return f24307d.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f24309e;
        }
    }

    public b a(String str) {
        this.f24300a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f24303m = at.a(this.f24303m, 0, z10);
    }

    public void c(boolean z10) {
        this.f24303m = at.a(this.f24303m, 1, z10);
    }

    public b(String str, long j10, int i10) {
        this();
        this.f24300a = str;
        this.f24301b = j10;
        b(true);
        this.f24302c = i10;
        c(true);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24300a = null;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public b a(long j10) {
        this.f24301b = j10;
        b(true);
        return this;
    }

    public b a(int i10) {
        this.f24302c = i10;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public b(b bVar) {
        this.f24303m = (byte) 0;
        this.f24303m = bVar.f24303m;
        if (bVar.d()) {
            this.f24300a = bVar.f24300a;
        }
        this.f24301b = bVar.f24301b;
        this.f24302c = bVar.f24302c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24303m = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
