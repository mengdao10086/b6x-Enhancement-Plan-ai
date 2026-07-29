package com.umeng.commonsdk.statistics.proto;

import com.blankj.utilcode.util.i0;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.br;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class c implements aw<c, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bi> f24311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f24312e = -5764118265293965743L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ca f24313f = new ca("IdTracking");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bq f24314g = new bq("snapshots", (byte) 13, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bq f24315h = new bq("journals", (byte) 15, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bq f24316i = new bq("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f24317j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f24318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f24319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24320c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e[] f24321k;

    public static class a extends cf<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, c cVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                byte b10 = bqVarL.f23422b;
                if (b10 == 0) {
                    bvVar.k();
                    cVar.n();
                    return;
                }
                short s10 = bqVarL.f23423c;
                int i10 = 0;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            by.a(bvVar, b10);
                        } else if (b10 == 11) {
                            cVar.f24320c = bvVar.z();
                            cVar.c(true);
                        } else {
                            by.a(bvVar, b10);
                        }
                    } else if (b10 == 15) {
                        br brVarP = bvVar.p();
                        cVar.f24319b = new ArrayList(brVarP.f23425b);
                        while (i10 < brVarP.f23425b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(bvVar);
                            cVar.f24319b.add(aVar);
                            i10++;
                        }
                        bvVar.q();
                        cVar.b(true);
                    } else {
                        by.a(bvVar, b10);
                    }
                } else if (b10 == 13) {
                    bs bsVarN = bvVar.n();
                    cVar.f24318a = new HashMap(bsVarN.f23428c * 2);
                    while (i10 < bsVarN.f23428c) {
                        String strZ = bvVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(bvVar);
                        cVar.f24318a.put(strZ, bVar);
                        i10++;
                    }
                    bvVar.o();
                    cVar.a(true);
                } else {
                    by.a(bvVar, b10);
                }
                bvVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, c cVar) throws bc {
            cVar.n();
            bvVar.a(c.f24313f);
            if (cVar.f24318a != null) {
                bvVar.a(c.f24314g);
                bvVar.a(new bs((byte) 11, (byte) 12, cVar.f24318a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24318a.entrySet()) {
                    bvVar.a(entry.getKey());
                    entry.getValue().write(bvVar);
                }
                bvVar.e();
                bvVar.c();
            }
            if (cVar.f24319b != null && cVar.j()) {
                bvVar.a(c.f24315h);
                bvVar.a(new br((byte) 12, cVar.f24319b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it2 = cVar.f24319b.iterator();
                while (it2.hasNext()) {
                    it2.next().write(bvVar);
                }
                bvVar.f();
                bvVar.c();
            }
            if (cVar.f24320c != null && cVar.m()) {
                bvVar.a(c.f24316i);
                bvVar.a(cVar.f24320c);
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

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    public static class C0265c extends cg<c> {
        private C0265c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, c cVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(cVar.f24318a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24318a.entrySet()) {
                cbVar.a(entry.getKey());
                entry.getValue().write(cbVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cbVar.a(bitSet, 2);
            if (cVar.j()) {
                cbVar.a(cVar.f24319b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it2 = cVar.f24319b.iterator();
                while (it2.hasNext()) {
                    it2.next().write(cbVar);
                }
            }
            if (cVar.m()) {
                cbVar.a(cVar.f24320c);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, c cVar) throws bc {
            cb cbVar = (cb) bvVar;
            bs bsVar = new bs((byte) 11, (byte) 12, cbVar.w());
            cVar.f24318a = new HashMap(bsVar.f23428c * 2);
            for (int i10 = 0; i10 < bsVar.f23428c; i10++) {
                String strZ = cbVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cbVar);
                cVar.f24318a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = cbVar.b(2);
            if (bitSetB.get(0)) {
                br brVar = new br((byte) 12, cbVar.w());
                cVar.f24319b = new ArrayList(brVar.f23425b);
                for (int i11 = 0; i11 < brVar.f23425b; i11++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cbVar);
                    cVar.f24319b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f24320c = cbVar.z();
                cVar.c(true);
            }
        }
    }

    public static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0265c b() {
            return new C0265c();
        }
    }

    static {
        HashMap map = new HashMap();
        f24317j = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new bi("snapshots", (byte) 1, new bl((byte) 13, new bj((byte) 11), new bn((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new bi("journals", (byte) 2, new bk((byte) 15, new bn((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 2, new bj((byte) 11)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24311d = mapUnmodifiableMap;
        bi.a(c.class, mapUnmodifiableMap);
    }

    public c() {
        this.f24321k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f24318a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f24318a;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f24318a = null;
        this.f24319b = null;
        this.f24320c = null;
    }

    public void d() {
        this.f24318a = null;
    }

    public boolean e() {
        return this.f24318a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f24319b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f24319b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f24319b;
    }

    public void i() {
        this.f24319b = null;
    }

    public boolean j() {
        return this.f24319b != null;
    }

    public String k() {
        return this.f24320c;
    }

    public void l() {
        this.f24320c = null;
    }

    public boolean m() {
        return this.f24320c != null;
    }

    public void n() throws bc {
        if (this.f24318a != null) {
            return;
        }
        throw new bw("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f24317j.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IdTracking(");
        sb2.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f24318a;
        if (map == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(map);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f24319b;
            if (list == null) {
                sb2.append(i0.f11859x);
            } else {
                sb2.append(list);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("checksum:");
            String str = this.f24320c;
            if (str == null) {
                sb2.append(i0.f11859x);
            } else {
                sb2.append(str);
            }
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f24317j.get(bvVar.D()).b().a(bvVar, this);
    }

    public enum e implements bd {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f24325d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f24327e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f24328f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f24325d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f24327e = s10;
            this.f24328f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return SNAPSHOTS;
            }
            if (i10 == 2) {
                return JOURNALS;
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
            return this.f24328f;
        }

        public static e a(String str) {
            return f24325d.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f24327e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f24318a == null) {
            this.f24318a = new HashMap();
        }
        this.f24318a.put(str, bVar);
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f24319b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24320c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f24318a = map;
    }

    public c(c cVar) {
        this.f24321k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f24318a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f24318a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it2 = cVar.f24319b.iterator();
            while (it2.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it2.next()));
            }
            this.f24319b = arrayList;
        }
        if (cVar.m()) {
            this.f24320c = cVar.f24320c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f24318a = map;
        return this;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24318a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f24319b == null) {
            this.f24319b = new ArrayList();
        }
        this.f24319b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f24319b = list;
        return this;
    }

    public c a(String str) {
        this.f24320c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
