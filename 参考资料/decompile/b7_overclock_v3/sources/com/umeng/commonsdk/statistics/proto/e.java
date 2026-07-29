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
public class e implements aw<e, EnumC0267e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0267e, bi> f24348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f24349e = 7501688097813630241L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ca f24350f = new ca("ImprintValue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bq f24351g = new bq("value", (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bq f24352h = new bq("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bq f24353i = new bq("guid", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f24354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f24355k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f24357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24358c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f24359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private EnumC0267e[] f24360m;

    public static class a extends cf<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, e eVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                byte b10 = bqVarL.f23422b;
                if (b10 == 0) {
                    bvVar.k();
                    eVar.k();
                    return;
                }
                short s10 = bqVarL.f23423c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            by.a(bvVar, b10);
                        } else if (b10 == 11) {
                            eVar.f24358c = bvVar.z();
                            eVar.c(true);
                        } else {
                            by.a(bvVar, b10);
                        }
                    } else if (b10 == 10) {
                        eVar.f24357b = bvVar.x();
                        eVar.b(true);
                    } else {
                        by.a(bvVar, b10);
                    }
                } else if (b10 == 11) {
                    eVar.f24356a = bvVar.z();
                    eVar.a(true);
                } else {
                    by.a(bvVar, b10);
                }
                bvVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, e eVar) throws bc {
            eVar.k();
            bvVar.a(e.f24350f);
            if (eVar.f24356a != null && eVar.d()) {
                bvVar.a(e.f24351g);
                bvVar.a(eVar.f24356a);
                bvVar.c();
            }
            if (eVar.g()) {
                bvVar.a(e.f24352h);
                bvVar.a(eVar.f24357b);
                bvVar.c();
            }
            if (eVar.f24358c != null && eVar.j()) {
                bvVar.a(e.f24353i);
                bvVar.a(eVar.f24358c);
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

    public static class c extends cg<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, e eVar) throws bc {
            cb cbVar = (cb) bvVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cbVar.a(bitSet, 3);
            if (eVar.d()) {
                cbVar.a(eVar.f24356a);
            }
            if (eVar.g()) {
                cbVar.a(eVar.f24357b);
            }
            if (eVar.j()) {
                cbVar.a(eVar.f24358c);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, e eVar) throws bc {
            cb cbVar = (cb) bvVar;
            BitSet bitSetB = cbVar.b(3);
            if (bitSetB.get(0)) {
                eVar.f24356a = cbVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.f24357b = cbVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.f24358c = cbVar.z();
                eVar.c(true);
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
        f24354j = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0267e.class);
        enumMap.put(EnumC0267e.VALUE, new bi("value", (byte) 2, new bj((byte) 11)));
        enumMap.put(EnumC0267e.TS, new bi("ts", (byte) 2, new bj((byte) 10)));
        enumMap.put(EnumC0267e.GUID, new bi("guid", (byte) 2, new bj((byte) 11)));
        Map<EnumC0267e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f24348d = mapUnmodifiableMap;
        bi.a(e.class, mapUnmodifiableMap);
    }

    public e() {
        this.f24359l = (byte) 0;
        this.f24360m = new EnumC0267e[]{EnumC0267e.VALUE, EnumC0267e.TS, EnumC0267e.GUID};
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f24356a;
    }

    public void c() {
        this.f24356a = null;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f24356a = null;
        b(false);
        this.f24357b = 0L;
        this.f24358c = null;
    }

    public boolean d() {
        return this.f24356a != null;
    }

    public long e() {
        return this.f24357b;
    }

    public void f() {
        this.f24359l = at.b(this.f24359l, 0);
    }

    public boolean g() {
        return at.a(this.f24359l, 0);
    }

    public String h() {
        return this.f24358c;
    }

    public void i() {
        this.f24358c = null;
    }

    public boolean j() {
        return this.f24358c != null;
    }

    public void k() throws bc {
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f24354j.get(bvVar.D()).b().b(bvVar, this);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("ImprintValue(");
        if (d()) {
            sb2.append("value:");
            String str = this.f24356a;
            if (str == null) {
                sb2.append(i0.f11859x);
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            sb2.append(", ");
        }
        sb2.append("ts:");
        sb2.append(this.f24357b);
        sb2.append(", ");
        sb2.append("guid:");
        String str2 = this.f24358c;
        if (str2 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str2);
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f24354j.get(bvVar.D()).b().a(bvVar, this);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC0267e implements bd {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0267e> f24364d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f24366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f24367f;

        static {
            for (EnumC0267e enumC0267e : EnumSet.allOf(EnumC0267e.class)) {
                f24364d.put(enumC0267e.b(), enumC0267e);
            }
        }

        EnumC0267e(short s10, String str) {
            this.f24366e = s10;
            this.f24367f = str;
        }

        public static EnumC0267e a(int i10) {
            if (i10 == 1) {
                return VALUE;
            }
            if (i10 == 2) {
                return TS;
            }
            if (i10 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0267e b(int i10) {
            EnumC0267e enumC0267eA = a(i10);
            if (enumC0267eA != null) {
                return enumC0267eA;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.f24367f;
        }

        public static EnumC0267e a(String str) {
            return f24364d.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f24366e;
        }
    }

    public e a(String str) {
        this.f24356a = str;
        return this;
    }

    public void b(boolean z10) {
        this.f24359l = at.a(this.f24359l, 0, z10);
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f24358c = null;
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f24356a = null;
    }

    public e b(String str) {
        this.f24358c = str;
        return this;
    }

    public e(long j10, String str) {
        this();
        this.f24357b = j10;
        b(true);
        this.f24358c = str;
    }

    public e a(long j10) {
        this.f24357b = j10;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0267e fieldForId(int i10) {
        return EnumC0267e.a(i10);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public e(e eVar) {
        this.f24359l = (byte) 0;
        this.f24360m = new EnumC0267e[]{EnumC0267e.VALUE, EnumC0267e.TS, EnumC0267e.GUID};
        this.f24359l = eVar.f24359l;
        if (eVar.d()) {
            this.f24356a = eVar.f24356a;
        }
        this.f24357b = eVar.f24357b;
        if (eVar.j()) {
            this.f24358c = eVar.f24358c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f24359l = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
