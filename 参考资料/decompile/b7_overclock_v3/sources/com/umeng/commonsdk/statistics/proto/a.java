package com.umeng.commonsdk.statistics.proto;

import com.blankj.utilcode.util.i0;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class a implements aw<a, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<e, bi> f24268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f24269f = 9132678615281394583L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ca f24270g = new ca("IdJournal");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bq f24271h = new bq("domain", (byte) 11, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bq f24272i = new bq("old_id", (byte) 11, 2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final bq f24273j = new bq("new_id", (byte) 11, 3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bq f24274k = new bq("ts", (byte) 10, 4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f24275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f24276m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f24278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f24280d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f24281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private e[] f24282o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    public static class C0263a extends cf<a> {
        private C0263a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, a aVar) throws bc {
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
                            if (s10 != 4) {
                                by.a(bvVar, b10);
                            } else if (b10 == 10) {
                                aVar.f24280d = bvVar.x();
                                aVar.d(true);
                            } else {
                                by.a(bvVar, b10);
                            }
                        } else if (b10 == 11) {
                            aVar.f24279c = bvVar.z();
                            aVar.c(true);
                        } else {
                            by.a(bvVar, b10);
                        }
                    } else if (b10 == 11) {
                        aVar.f24278b = bvVar.z();
                        aVar.b(true);
                    } else {
                        by.a(bvVar, b10);
                    }
                } else if (b10 == 11) {
                    aVar.f24277a = bvVar.z();
                    aVar.a(true);
                } else {
                    by.a(bvVar, b10);
                }
                bvVar.m();
            }
            bvVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new bw("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, a aVar) throws bc {
            aVar.n();
            bvVar.a(a.f24270g);
            if (aVar.f24277a != null) {
                bvVar.a(a.f24271h);
                bvVar.a(aVar.f24277a);
                bvVar.c();
            }
            if (aVar.f24278b != null && aVar.g()) {
                bvVar.a(a.f24272i);
                bvVar.a(aVar.f24278b);
                bvVar.c();
            }
            if (aVar.f24279c != null) {
                bvVar.a(a.f24273j);
                bvVar.a(aVar.f24279c);
                bvVar.c();
            }
            bvVar.a(a.f24274k);
            bvVar.a(aVar.f24280d);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    public static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0263a b() {
            return new C0263a();
        }
    }

    public static class c extends cg<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, a aVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(aVar.f24277a);
            cbVar.a(aVar.f24279c);
            cbVar.a(aVar.f24280d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cbVar.a(bitSet, 1);
            if (aVar.g()) {
                cbVar.a(aVar.f24278b);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, a aVar) throws bc {
            cb cbVar = (cb) bvVar;
            aVar.f24277a = cbVar.z();
            aVar.a(true);
            aVar.f24279c = cbVar.z();
            aVar.c(true);
            aVar.f24280d = cbVar.x();
            aVar.d(true);
            if (cbVar.b(1).get(0)) {
                aVar.f24278b = cbVar.z();
                aVar.b(true);
            }
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
        f24275l = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bi("domain", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.OLD_ID, new bi("old_id", (byte) 2, new bj((byte) 11)));
        enumMap.put(e.NEW_ID, new bi("new_id", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.TS, new bi("ts", (byte) 1, new bj((byte) 10)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24268e = mapUnmodifiableMap;
        bi.a(a.class, mapUnmodifiableMap);
    }

    public a() {
        this.f24281n = (byte) 0;
        this.f24282o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f24277a;
    }

    public void c() {
        this.f24277a = null;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f24277a = null;
        this.f24278b = null;
        this.f24279c = null;
        d(false);
        this.f24280d = 0L;
    }

    public boolean d() {
        return this.f24277a != null;
    }

    public String e() {
        return this.f24278b;
    }

    public void f() {
        this.f24278b = null;
    }

    public boolean g() {
        return this.f24278b != null;
    }

    public String h() {
        return this.f24279c;
    }

    public void i() {
        this.f24279c = null;
    }

    public boolean j() {
        return this.f24279c != null;
    }

    public long k() {
        return this.f24280d;
    }

    public void l() {
        this.f24281n = at.b(this.f24281n, 0);
    }

    public boolean m() {
        return at.a(this.f24281n, 0);
    }

    public void n() throws bc {
        if (this.f24277a == null) {
            throw new bw("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f24279c != null) {
            return;
        }
        throw new bw("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f24275l.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdJournal(");
        sb2.append("domain:");
        String str = this.f24277a;
        if (str == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("old_id:");
            String str2 = this.f24278b;
            if (str2 == null) {
                sb2.append(i0.f11859x);
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("new_id:");
        String str3 = this.f24279c;
        if (str3 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("ts:");
        sb2.append(this.f24280d);
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f24275l.get(bvVar.D()).b().a(bvVar, this);
    }

    public enum e implements bd {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f24287e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final short f24289f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f24290g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f24287e.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24289f = s10;
            this.f24290g = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return DOMAIN;
            }
            if (i10 == 2) {
                return OLD_ID;
            }
            if (i10 == 3) {
                return NEW_ID;
            }
            if (i10 != 4) {
                return null;
            }
            return TS;
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
            return this.f24290g;
        }

        public static e a(String str) {
            return f24287e.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f24289f;
        }
    }

    public a a(String str) {
        this.f24277a = str;
        return this;
    }

    public a b(String str) {
        this.f24278b = str;
        return this;
    }

    public a c(String str) {
        this.f24279c = str;
        return this;
    }

    public void d(boolean z10) {
        this.f24281n = at.a(this.f24281n, 0, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24277a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f24278b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24279c = null;
    }

    public a(String str, String str2, long j10) {
        this();
        this.f24277a = str;
        this.f24279c = str2;
        this.f24280d = j10;
        d(true);
    }

    public a a(long j10) {
        this.f24280d = j10;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public a(a aVar) {
        this.f24281n = (byte) 0;
        this.f24282o = new e[]{e.OLD_ID};
        this.f24281n = aVar.f24281n;
        if (aVar.d()) {
            this.f24277a = aVar.f24277a;
        }
        if (aVar.g()) {
            this.f24278b = aVar.f24278b;
        }
        if (aVar.j()) {
            this.f24279c = aVar.f24279c;
        }
        this.f24280d = aVar.f24280d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24281n = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
