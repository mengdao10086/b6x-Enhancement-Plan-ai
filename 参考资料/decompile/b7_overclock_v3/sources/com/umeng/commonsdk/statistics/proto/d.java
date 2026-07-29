package com.umeng.commonsdk.statistics.proto;

import com.blankj.utilcode.util.i0;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bs;
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
public class d implements aw<d, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bi> f24329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f24330e = 2846460275012375038L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ca f24331f = new ca("Imprint");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bq f24332g = new bq("property", (byte) 13, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bq f24333h = new bq(db.d.f26139i, (byte) 8, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bq f24334i = new bq("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f24335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f24336k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f24337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24339c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f24340l;

    public static class a extends cf<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, d dVar) throws bc {
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
                        } else if (b10 == 11) {
                            dVar.f24339c = bvVar.z();
                            dVar.c(true);
                        } else {
                            by.a(bvVar, b10);
                        }
                    } else if (b10 == 8) {
                        dVar.f24338b = bvVar.w();
                        dVar.b(true);
                    } else {
                        by.a(bvVar, b10);
                    }
                } else if (b10 == 13) {
                    bs bsVarN = bvVar.n();
                    dVar.f24337a = new HashMap(bsVarN.f23428c * 2);
                    for (int i10 = 0; i10 < bsVarN.f23428c; i10++) {
                        String strZ = bvVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(bvVar);
                        dVar.f24337a.put(strZ, eVar);
                    }
                    bvVar.o();
                    dVar.a(true);
                } else {
                    by.a(bvVar, b10);
                }
                bvVar.m();
            }
            bvVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bw("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, d dVar) throws bc {
            dVar.l();
            bvVar.a(d.f24331f);
            if (dVar.f24337a != null) {
                bvVar.a(d.f24332g);
                bvVar.a(new bs((byte) 11, (byte) 12, dVar.f24337a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24337a.entrySet()) {
                    bvVar.a(entry.getKey());
                    entry.getValue().write(bvVar);
                }
                bvVar.e();
                bvVar.c();
            }
            bvVar.a(d.f24333h);
            bvVar.a(dVar.f24338b);
            bvVar.c();
            if (dVar.f24339c != null) {
                bvVar.a(d.f24334i);
                bvVar.a(dVar.f24339c);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    public static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends cg<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, d dVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(dVar.f24337a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24337a.entrySet()) {
                cbVar.a(entry.getKey());
                entry.getValue().write(cbVar);
            }
            cbVar.a(dVar.f24338b);
            cbVar.a(dVar.f24339c);
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, d dVar) throws bc {
            cb cbVar = (cb) bvVar;
            bs bsVar = new bs((byte) 11, (byte) 12, cbVar.w());
            dVar.f24337a = new HashMap(bsVar.f23428c * 2);
            for (int i10 = 0; i10 < bsVar.f23428c; i10++) {
                String strZ = cbVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cbVar);
                dVar.f24337a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.f24338b = cbVar.w();
            dVar.b(true);
            dVar.f24339c = cbVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    public static class C0266d implements ce {
        private C0266d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        f24335j = map;
        map.put(cf.class, new b());
        map.put(cg.class, new C0266d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bi("property", (byte) 1, new bl((byte) 13, new bj((byte) 11), new bn((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bi(db.d.f26139i, (byte) 1, new bj((byte) 8)));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 1, new bj((byte) 11)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24329d = mapUnmodifiableMap;
        bi.a(d.class, mapUnmodifiableMap);
    }

    public d() {
        this.f24340l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f24337a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f24337a;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f24337a = null;
        b(false);
        this.f24338b = 0;
        this.f24339c = null;
    }

    public void d() {
        this.f24337a = null;
    }

    public boolean e() {
        return this.f24337a != null;
    }

    public int f() {
        return this.f24338b;
    }

    public void g() {
        this.f24340l = at.b(this.f24340l, 0);
    }

    public boolean h() {
        return at.a(this.f24340l, 0);
    }

    public String i() {
        return this.f24339c;
    }

    public void j() {
        this.f24339c = null;
    }

    public boolean k() {
        return this.f24339c != null;
    }

    public void l() throws bc {
        if (this.f24337a == null) {
            throw new bw("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f24339c != null) {
            return;
        }
        throw new bw("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f24335j.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Imprint(");
        sb2.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f24337a;
        if (map == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(map);
        }
        sb2.append(", ");
        sb2.append("version:");
        sb2.append(this.f24338b);
        sb2.append(", ");
        sb2.append("checksum:");
        String str = this.f24339c;
        if (str == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str);
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f24335j.get(bvVar.D()).b().a(bvVar, this);
    }

    public enum e implements bd {
        PROPERTY(1, "property"),
        VERSION(2, db.d.f26139i),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f24344d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f24346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f24347f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f24344d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24346e = s10;
            this.f24347f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return PROPERTY;
            }
            if (i10 == 2) {
                return VERSION;
            }
            if (i10 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f24347f;
        }

        public static e a(String str) {
            return f24344d.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f24346e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f24337a == null) {
            this.f24337a = new HashMap();
        }
        this.f24337a.put(str, eVar);
    }

    public void b(boolean z10) {
        this.f24340l = at.a(this.f24340l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24339c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i10, String str) {
        this();
        this.f24337a = map;
        this.f24338b = i10;
        b(true);
        this.f24339c = str;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f24337a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24337a = null;
    }

    public d a(int i10) {
        this.f24338b = i10;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f24340l = (byte) 0;
        this.f24340l = dVar.f24340l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f24337a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f24337a = map;
        }
        this.f24338b = dVar.f24338b;
        if (dVar.k()) {
            this.f24339c = dVar.f24339c;
        }
    }

    public d a(String str) {
        this.f24339c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24340l = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
