package com.umeng.analytics.pro;

import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ao implements aw<ao, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<e, bi> f23261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f23262l = 420342210744516016L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ca f23263m = new ca("UMEnvelope");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final bq f23264n = new bq(db.d.f26139i, (byte) 11, 1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final bq f23265o = new bq(m7.a.f40701a, (byte) 11, 2);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final bq f23266p = new bq("signature", (byte) 11, 3);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final bq f23267q = new bq("serial_num", (byte) 8, 4);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final bq f23268r = new bq("ts_secs", (byte) 8, 5);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final bq f23269s = new bq(fd.c.f28042f, (byte) 8, 6);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final bq f23270t = new bq("entity", (byte) 11, 7);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final bq f23271u = new bq("guid", (byte) 11, 8);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final bq f23272v = new bq("checksum", (byte) 11, 9);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final bq f23273w = new bq("codex", (byte) 8, 10);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Map<Class<? extends cd>, ce> f23274x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f23275y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f23276z = 1;
    private byte C;
    private e[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f23282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f23283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f23285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23286j;

    public static class a extends cf<ao> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, ao aoVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                byte b10 = bqVarL.f23422b;
                if (b10 == 0) {
                    bvVar.k();
                    if (!aoVar.m()) {
                        throw new bw("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aoVar.p()) {
                        throw new bw("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (aoVar.s()) {
                        aoVar.G();
                        return;
                    }
                    throw new bw("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (bqVarL.f23423c) {
                    case 1:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23277a = bvVar.z();
                            aoVar.a(true);
                        }
                        break;
                    case 2:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23278b = bvVar.z();
                            aoVar.b(true);
                        }
                        break;
                    case 3:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23279c = bvVar.z();
                            aoVar.c(true);
                        }
                        break;
                    case 4:
                        if (b10 != 8) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23280d = bvVar.w();
                            aoVar.d(true);
                        }
                        break;
                    case 5:
                        if (b10 != 8) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23281e = bvVar.w();
                            aoVar.e(true);
                        }
                        break;
                    case 6:
                        if (b10 != 8) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23282f = bvVar.w();
                            aoVar.f(true);
                        }
                        break;
                    case 7:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23283g = bvVar.A();
                            aoVar.g(true);
                        }
                        break;
                    case 8:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23284h = bvVar.z();
                            aoVar.h(true);
                        }
                        break;
                    case 9:
                        if (b10 != 11) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23285i = bvVar.z();
                            aoVar.i(true);
                        }
                        break;
                    case 10:
                        if (b10 != 8) {
                            by.a(bvVar, b10);
                        } else {
                            aoVar.f23286j = bvVar.w();
                            aoVar.j(true);
                        }
                        break;
                    default:
                        by.a(bvVar, b10);
                        break;
                }
                bvVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, ao aoVar) throws bc {
            aoVar.G();
            bvVar.a(ao.f23263m);
            if (aoVar.f23277a != null) {
                bvVar.a(ao.f23264n);
                bvVar.a(aoVar.f23277a);
                bvVar.c();
            }
            if (aoVar.f23278b != null) {
                bvVar.a(ao.f23265o);
                bvVar.a(aoVar.f23278b);
                bvVar.c();
            }
            if (aoVar.f23279c != null) {
                bvVar.a(ao.f23266p);
                bvVar.a(aoVar.f23279c);
                bvVar.c();
            }
            bvVar.a(ao.f23267q);
            bvVar.a(aoVar.f23280d);
            bvVar.c();
            bvVar.a(ao.f23268r);
            bvVar.a(aoVar.f23281e);
            bvVar.c();
            bvVar.a(ao.f23269s);
            bvVar.a(aoVar.f23282f);
            bvVar.c();
            if (aoVar.f23283g != null) {
                bvVar.a(ao.f23270t);
                bvVar.a(aoVar.f23283g);
                bvVar.c();
            }
            if (aoVar.f23284h != null) {
                bvVar.a(ao.f23271u);
                bvVar.a(aoVar.f23284h);
                bvVar.c();
            }
            if (aoVar.f23285i != null) {
                bvVar.a(ao.f23272v);
                bvVar.a(aoVar.f23285i);
                bvVar.c();
            }
            if (aoVar.F()) {
                bvVar.a(ao.f23273w);
                bvVar.a(aoVar.f23286j);
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

    public static class c extends cg<ao> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, ao aoVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(aoVar.f23277a);
            cbVar.a(aoVar.f23278b);
            cbVar.a(aoVar.f23279c);
            cbVar.a(aoVar.f23280d);
            cbVar.a(aoVar.f23281e);
            cbVar.a(aoVar.f23282f);
            cbVar.a(aoVar.f23283g);
            cbVar.a(aoVar.f23284h);
            cbVar.a(aoVar.f23285i);
            BitSet bitSet = new BitSet();
            if (aoVar.F()) {
                bitSet.set(0);
            }
            cbVar.a(bitSet, 1);
            if (aoVar.F()) {
                cbVar.a(aoVar.f23286j);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, ao aoVar) throws bc {
            cb cbVar = (cb) bvVar;
            aoVar.f23277a = cbVar.z();
            aoVar.a(true);
            aoVar.f23278b = cbVar.z();
            aoVar.b(true);
            aoVar.f23279c = cbVar.z();
            aoVar.c(true);
            aoVar.f23280d = cbVar.w();
            aoVar.d(true);
            aoVar.f23281e = cbVar.w();
            aoVar.e(true);
            aoVar.f23282f = cbVar.w();
            aoVar.f(true);
            aoVar.f23283g = cbVar.A();
            aoVar.g(true);
            aoVar.f23284h = cbVar.z();
            aoVar.h(true);
            aoVar.f23285i = cbVar.z();
            aoVar.i(true);
            if (cbVar.b(1).get(0)) {
                aoVar.f23286j = cbVar.w();
                aoVar.j(true);
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
        f23274x = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bi(db.d.f26139i, (byte) 1, new bj((byte) 11)));
        enumMap.put(e.ADDRESS, new bi(m7.a.f40701a, (byte) 1, new bj((byte) 11)));
        enumMap.put(e.SIGNATURE, new bi("signature", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bi("serial_num", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.TS_SECS, new bi("ts_secs", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.LENGTH, new bi(fd.c.f28042f, (byte) 1, new bj((byte) 8)));
        enumMap.put(e.ENTITY, new bi("entity", (byte) 1, new bj((byte) 11, true)));
        enumMap.put(e.GUID, new bi("guid", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.CODEX, new bi("codex", (byte) 2, new bj((byte) 8)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f23261k = mapUnmodifiableMap;
        bi.a(ao.class, mapUnmodifiableMap);
    }

    public ao() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f23285i;
    }

    public void B() {
        this.f23285i = null;
    }

    public boolean C() {
        return this.f23285i != null;
    }

    public int D() {
        return this.f23286j;
    }

    public void E() {
        this.C = at.b(this.C, 3);
    }

    public boolean F() {
        return at.a(this.C, 3);
    }

    public void G() throws bc {
        if (this.f23277a == null) {
            throw new bw("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f23278b == null) {
            throw new bw("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f23279c == null) {
            throw new bw("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f23283g == null) {
            throw new bw("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f23284h == null) {
            throw new bw("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f23285i != null) {
            return;
        }
        throw new bw("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ao deepCopy() {
        return new ao(this);
    }

    public String b() {
        return this.f23277a;
    }

    public void c() {
        this.f23277a = null;
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f23277a = null;
        this.f23278b = null;
        this.f23279c = null;
        d(false);
        this.f23280d = 0;
        e(false);
        this.f23281e = 0;
        f(false);
        this.f23282f = 0;
        this.f23283g = null;
        this.f23284h = null;
        this.f23285i = null;
        j(false);
        this.f23286j = 0;
    }

    public boolean d() {
        return this.f23277a != null;
    }

    public String e() {
        return this.f23278b;
    }

    public void f() {
        this.f23278b = null;
    }

    public boolean g() {
        return this.f23278b != null;
    }

    public String h() {
        return this.f23279c;
    }

    public void i() {
        this.f23279c = null;
    }

    public boolean j() {
        return this.f23279c != null;
    }

    public int k() {
        return this.f23280d;
    }

    public void l() {
        this.C = at.b(this.C, 0);
    }

    public boolean m() {
        return at.a(this.C, 0);
    }

    public int n() {
        return this.f23281e;
    }

    public void o() {
        this.C = at.b(this.C, 1);
    }

    public boolean p() {
        return at.a(this.C, 1);
    }

    public int q() {
        return this.f23282f;
    }

    public void r() {
        this.C = at.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        f23274x.get(bvVar.D()).b().b(bvVar, this);
    }

    public boolean s() {
        return at.a(this.C, 2);
    }

    public byte[] t() {
        a(ax.c(this.f23283g));
        ByteBuffer byteBuffer = this.f23283g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("UMEnvelope(");
        sb2.append("version:");
        String str = this.f23277a;
        if (str == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("address:");
        String str2 = this.f23278b;
        if (str2 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("signature:");
        String str3 = this.f23279c;
        if (str3 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("serial_num:");
        sb2.append(this.f23280d);
        sb2.append(", ");
        sb2.append("ts_secs:");
        sb2.append(this.f23281e);
        sb2.append(", ");
        sb2.append("length:");
        sb2.append(this.f23282f);
        sb2.append(", ");
        sb2.append("entity:");
        ByteBuffer byteBuffer = this.f23283g;
        if (byteBuffer == null) {
            sb2.append(i0.f11859x);
        } else {
            ax.a(byteBuffer, sb2);
        }
        sb2.append(", ");
        sb2.append("guid:");
        String str4 = this.f23284h;
        if (str4 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str4);
        }
        sb2.append(", ");
        sb2.append("checksum:");
        String str5 = this.f23285i;
        if (str5 == null) {
            sb2.append(i0.f11859x);
        } else {
            sb2.append(str5);
        }
        if (F()) {
            sb2.append(", ");
            sb2.append("codex:");
            sb2.append(this.f23286j);
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    public ByteBuffer u() {
        return this.f23283g;
    }

    public void v() {
        this.f23283g = null;
    }

    public boolean w() {
        return this.f23283g != null;
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        f23274x.get(bvVar.D()).b().a(bvVar, this);
    }

    public String x() {
        return this.f23284h;
    }

    public void y() {
        this.f23284h = null;
    }

    public boolean z() {
        return this.f23284h != null;
    }

    public enum e implements bd {
        VERSION(1, db.d.f26139i),
        ADDRESS(2, m7.a.f40701a),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, fd.c.f28042f),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f23297k = new HashMap();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final short f23299l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f23300m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f23297k.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f23299l = s10;
            this.f23300m = str;
        }

        public static e a(int i10) {
            switch (i10) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f23300m;
        }

        public static e a(String str) {
            return f23297k.get(str);
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f23299l;
        }
    }

    public ao a(String str) {
        this.f23277a = str;
        return this;
    }

    public ao b(String str) {
        this.f23278b = str;
        return this;
    }

    public ao c(String str) {
        this.f23279c = str;
        return this;
    }

    public void d(boolean z10) {
        this.C = at.a(this.C, 0, z10);
    }

    public void e(boolean z10) {
        this.C = at.a(this.C, 1, z10);
    }

    public void f(boolean z10) {
        this.C = at.a(this.C, 2, z10);
    }

    public void g(boolean z10) {
        if (z10) {
            return;
        }
        this.f23283g = null;
    }

    public void h(boolean z10) {
        if (z10) {
            return;
        }
        this.f23284h = null;
    }

    public void i(boolean z10) {
        if (z10) {
            return;
        }
        this.f23285i = null;
    }

    public void j(boolean z10) {
        this.C = at.a(this.C, 3, z10);
    }

    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f23277a = null;
    }

    public void b(boolean z10) {
        if (z10) {
            return;
        }
        this.f23278b = null;
    }

    public void c(boolean z10) {
        if (z10) {
            return;
        }
        this.f23279c = null;
    }

    public ao d(String str) {
        this.f23284h = str;
        return this;
    }

    public ao e(String str) {
        this.f23285i = str;
        return this;
    }

    public ao(String str, String str2, String str3, int i10, int i11, int i12, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f23277a = str;
        this.f23278b = str2;
        this.f23279c = str3;
        this.f23280d = i10;
        d(true);
        this.f23281e = i11;
        e(true);
        this.f23282f = i12;
        f(true);
        this.f23283g = byteBuffer;
        this.f23284h = str4;
        this.f23285i = str5;
    }

    public ao a(int i10) {
        this.f23280d = i10;
        d(true);
        return this;
    }

    public ao b(int i10) {
        this.f23281e = i10;
        e(true);
        return this;
    }

    public ao c(int i10) {
        this.f23282f = i10;
        f(true);
        return this;
    }

    public ao d(int i10) {
        this.f23286j = i10;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public ao a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public ao a(ByteBuffer byteBuffer) {
        this.f23283g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public ao(ao aoVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = aoVar.C;
        if (aoVar.d()) {
            this.f23277a = aoVar.f23277a;
        }
        if (aoVar.g()) {
            this.f23278b = aoVar.f23278b;
        }
        if (aoVar.j()) {
            this.f23279c = aoVar.f23279c;
        }
        this.f23280d = aoVar.f23280d;
        this.f23281e = aoVar.f23281e;
        this.f23282f = aoVar.f23282f;
        if (aoVar.w()) {
            this.f23283g = ax.d(aoVar.f23283g);
        }
        if (aoVar.z()) {
            this.f23284h = aoVar.f23284h;
        }
        if (aoVar.C()) {
            this.f23285i = aoVar.f23285i;
        }
        this.f23286j = aoVar.f23286j;
    }
}
