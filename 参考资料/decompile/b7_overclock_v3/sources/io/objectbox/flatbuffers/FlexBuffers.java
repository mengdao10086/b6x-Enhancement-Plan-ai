package io.objectbox.flatbuffers;

import com.blankj.utilcode.util.i0;
import java.nio.ByteBuffer;
import kotlin.text.y;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
public class FlexBuffers {
    public static final int A = 26;
    public static final int B = 36;
    public static final n C = new io.objectbox.flatbuffers.a(new byte[]{0}, 1);
    public static final /* synthetic */ boolean D = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32652a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f32653b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f32654c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32655d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f32656e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f32657f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f32658g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f32659h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f32660i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f32661j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f32662k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f32663l = 11;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f32664m = 12;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f32665n = 13;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f32666o = 14;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f32667p = 15;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f32668q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f32669r = 17;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f32670s = 18;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f32671t = 19;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f32672u = 20;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f32673v = 21;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f32674w = 22;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f32675x = 23;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f32676y = 24;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f32677z = 25;

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class a extends g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f32678e = new a(FlexBuffers.C, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f32679f = false;

        public a(n nVar, int i10, int i11) {
            super(nVar, i10, i11);
        }

        public static a d() {
            return f32678e;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append(y.f38188b);
            sb2.append(this.f32684a.h(this.f32685b, b()));
            sb2.append(y.f38188b);
            return sb2;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.g
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public ByteBuffer c() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f32684a.g());
            byteBufferWrap.position(this.f32685b);
            byteBufferWrap.limit(this.f32685b + b());
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte e(int i10) {
            return this.f32684a.get(this.f32685b + i10);
        }

        public byte[] f() {
            int iB = b();
            byte[] bArr = new byte[iB];
            for (int i10 = 0; i10 < iB; i10++) {
                bArr[i10] = this.f32684a.get(this.f32685b + i10);
            }
            return bArr;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public String toString() {
            return this.f32684a.h(this.f32685b, b());
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f32680d = new b(FlexBuffers.C, 0, 0);

        public b(n nVar, int i10, int i11) {
            super(nVar, i10, i11);
        }

        public static b d() {
            return f32680d;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        public int c(byte[] bArr) {
            byte b10;
            byte b11;
            int i10 = this.f32685b;
            int i11 = 0;
            do {
                b10 = this.f32684a.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    return b10 - b11;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f32685b == this.f32685b && bVar.f32686c == this.f32686c;
        }

        public int hashCode() {
            return this.f32685b ^ this.f32686c;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public String toString() {
            int i10 = this.f32685b;
            while (this.f32684a.get(i10) != 0) {
                i10++;
            }
            int i11 = this.f32685b;
            return this.f32684a.h(i11, i10 - i11);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f32681a;

        public c(h hVar) {
            this.f32681a = hVar;
        }

        public b a(int i10) {
            if (i10 >= b()) {
                return b.f32680d;
            }
            h hVar = this.f32681a;
            int i11 = hVar.f32685b + (i10 * hVar.f32686c);
            h hVar2 = this.f32681a;
            n nVar = hVar2.f32684a;
            return new b(nVar, FlexBuffers.i(nVar, i11, hVar2.f32686c), 1);
        }

        public int b() {
            return this.f32681a.b();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i10 = 0; i10 < this.f32681a.b(); i10++) {
                this.f32681a.d(i10).z(sb2);
                if (i10 != this.f32681a.b() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class d extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f32682g = new d(FlexBuffers.C, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f32683f;

        public d(n nVar, int i10, int i11) {
            super(nVar, i10, i11);
            this.f32683f = new byte[4];
        }

        public static d j() {
            return f32682g;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.j, io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append("{ ");
            c cVarM = m();
            int iB = b();
            j jVarN = n();
            for (int i10 = 0; i10 < iB; i10++) {
                sb2.append(y.f38188b);
                sb2.append(cVarM.a(i10).toString());
                sb2.append("\" : ");
                sb2.append(jVarN.d(i10).toString());
                if (i10 != iB - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public final int f(CharSequence charSequence) {
            int i10 = this.f32693d - 1;
            int i11 = this.f32685b;
            int i12 = this.f32686c;
            int i13 = i11 - (i12 * 3);
            int i14 = FlexBuffers.i(this.f32684a, i13, i12);
            n nVar = this.f32684a;
            int i15 = this.f32686c;
            int iN = FlexBuffers.n(nVar, i13 + i15, i15);
            int i16 = 0;
            while (i16 <= i10) {
                int i17 = (i16 + i10) >>> 1;
                int i18 = i(FlexBuffers.i(this.f32684a, (i17 * iN) + i14, iN), charSequence);
                if (i18 < 0) {
                    i16 = i17 + 1;
                } else {
                    if (i18 <= 0) {
                        return i17;
                    }
                    i10 = i17 - 1;
                }
            }
            return -(i16 + 1);
        }

        public final int g(byte[] bArr) {
            int i10 = this.f32693d - 1;
            int i11 = this.f32685b;
            int i12 = this.f32686c;
            int i13 = i11 - (i12 * 3);
            int i14 = FlexBuffers.i(this.f32684a, i13, i12);
            n nVar = this.f32684a;
            int i15 = this.f32686c;
            int iN = FlexBuffers.n(nVar, i13 + i15, i15);
            int i16 = 0;
            while (i16 <= i10) {
                int i17 = (i16 + i10) >>> 1;
                int iH = h(this.f32684a, FlexBuffers.i(this.f32684a, (i17 * iN) + i14, iN), bArr);
                if (iH < 0) {
                    i16 = i17 + 1;
                } else {
                    if (iH <= 0) {
                        return i17;
                    }
                    i10 = i17 - 1;
                }
            }
            return -(i16 + 1);
        }

        public final int h(n nVar, int i10, byte[] bArr) {
            byte b10;
            byte b11;
            int i11 = 0;
            do {
                b10 = nVar.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    return b10 - b11;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final int i(int i10, CharSequence charSequence) {
            int iA = this.f32684a.a();
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                byte bCharAt = charSequence.charAt(i11);
                if (bCharAt >= 128) {
                    break;
                }
                byte b10 = this.f32684a.get(i10);
                if (b10 == 0) {
                    return -bCharAt;
                }
                if (b10 < 0) {
                    break;
                }
                if (((char) b10) != bCharAt) {
                    return b10 - bCharAt;
                }
                i10++;
                i11++;
            }
            while (i10 < iA) {
                int iC = Utf8.c(charSequence, i11, this.f32683f);
                if (iC == 0) {
                    return this.f32684a.get(i10);
                }
                int i12 = 0;
                while (i12 < iC) {
                    int i13 = i10 + 1;
                    byte b11 = this.f32684a.get(i10);
                    byte b12 = this.f32683f[i12];
                    if (b11 == 0) {
                        return -b12;
                    }
                    if (b11 != b12) {
                        return b11 - b12;
                    }
                    i12++;
                    i10 = i13;
                }
                i11 += iC == 4 ? 2 : 1;
            }
            return 0;
        }

        public f k(String str) {
            int iF = f(str);
            return (iF < 0 || iF >= this.f32693d) ? f.f32687f : d(iF);
        }

        public f l(byte[] bArr) {
            int iG = g(bArr);
            return (iG < 0 || iG >= this.f32693d) ? f.f32687f : d(iG);
        }

        public c m() {
            int i10 = this.f32685b - (this.f32686c * 3);
            n nVar = this.f32684a;
            int i11 = FlexBuffers.i(nVar, i10, this.f32686c);
            n nVar2 = this.f32684a;
            int i12 = this.f32686c;
            return new c(new h(nVar, i11, FlexBuffers.n(nVar2, i10 + i12, i12), 4));
        }

        public j n() {
            return new j(this.f32684a, this.f32685b, this.f32686c);
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f32684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32686c;

        public e(n nVar, int i10, int i11) {
            this.f32684a = nVar;
            this.f32685b = i10;
            this.f32686c = i11;
        }

        public abstract StringBuilder a(StringBuilder sb2);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f32687f = new f(FlexBuffers.C, 0, 1, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f32688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f32691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32692e;

        public f(n nVar, int i10, int i11, int i12) {
            this(nVar, i10, i11, 1 << (i12 & 3), i12 >> 2);
        }

        public a b() {
            if (!m() && !v()) {
                return a.d();
            }
            n nVar = this.f32688a;
            return new a(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
        }

        public boolean c() {
            return n() ? this.f32688a.get(this.f32689b) != 0 : j() != 0;
        }

        public double d() {
            int i10 = this.f32692e;
            if (i10 == 3) {
                return FlexBuffers.m(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 1) {
                return FlexBuffers.n(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 != 2) {
                if (i10 == 5) {
                    return Double.parseDouble(i());
                }
                if (i10 == 6) {
                    n nVar = this.f32688a;
                    return FlexBuffers.n(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
                }
                if (i10 == 7) {
                    n nVar2 = this.f32688a;
                    return FlexBuffers.p(nVar2, FlexBuffers.i(nVar2, this.f32689b, this.f32690c), this.f32691d);
                }
                if (i10 == 8) {
                    n nVar3 = this.f32688a;
                    return FlexBuffers.m(nVar3, FlexBuffers.i(nVar3, this.f32689b, this.f32690c), this.f32691d);
                }
                if (i10 == 10) {
                    return k().b();
                }
                if (i10 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.p(this.f32688a, this.f32689b, this.f32690c);
        }

        public int e() {
            long jP;
            int i10 = this.f32692e;
            if (i10 == 1) {
                return FlexBuffers.n(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 2) {
                jP = FlexBuffers.p(this.f32688a, this.f32689b, this.f32690c);
            } else {
                if (i10 == 3) {
                    return (int) FlexBuffers.m(this.f32688a, this.f32689b, this.f32690c);
                }
                if (i10 == 5) {
                    return Integer.parseInt(i());
                }
                if (i10 == 6) {
                    n nVar = this.f32688a;
                    return FlexBuffers.n(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
                }
                if (i10 != 7) {
                    if (i10 == 8) {
                        n nVar2 = this.f32688a;
                        return (int) FlexBuffers.m(nVar2, FlexBuffers.i(nVar2, this.f32689b, this.f32690c), this.f32691d);
                    }
                    if (i10 == 10) {
                        return k().b();
                    }
                    if (i10 != 26) {
                        return 0;
                    }
                    return FlexBuffers.n(this.f32688a, this.f32689b, this.f32690c);
                }
                n nVar3 = this.f32688a;
                jP = FlexBuffers.p(nVar3, FlexBuffers.i(nVar3, this.f32689b, this.f32690c), this.f32690c);
            }
            return (int) jP;
        }

        public b f() {
            if (!r()) {
                return b.d();
            }
            n nVar = this.f32688a;
            return new b(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
        }

        public long g() {
            int i10 = this.f32692e;
            if (i10 == 1) {
                return FlexBuffers.o(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 2) {
                return FlexBuffers.p(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.m(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 5) {
                try {
                    return Long.parseLong(i());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i10 == 6) {
                n nVar = this.f32688a;
                return FlexBuffers.o(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
            }
            if (i10 == 7) {
                n nVar2 = this.f32688a;
                return FlexBuffers.p(nVar2, FlexBuffers.i(nVar2, this.f32689b, this.f32690c), this.f32690c);
            }
            if (i10 == 8) {
                n nVar3 = this.f32688a;
                return (long) FlexBuffers.m(nVar3, FlexBuffers.i(nVar3, this.f32689b, this.f32690c), this.f32691d);
            }
            if (i10 == 10) {
                return k().b();
            }
            if (i10 != 26) {
                return 0L;
            }
            return FlexBuffers.n(this.f32688a, this.f32689b, this.f32690c);
        }

        public d h() {
            if (!s()) {
                return d.j();
            }
            n nVar = this.f32688a;
            return new d(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
        }

        public String i() {
            if (v()) {
                int i10 = FlexBuffers.i(this.f32688a, this.f32689b, this.f32690c);
                n nVar = this.f32688a;
                int i11 = this.f32691d;
                return this.f32688a.h(i10, (int) FlexBuffers.p(nVar, i10 - i11, i11));
            }
            if (!r()) {
                return "";
            }
            int i12 = FlexBuffers.i(this.f32688a, this.f32689b, this.f32691d);
            int i13 = i12;
            while (this.f32688a.get(i13) != 0) {
                i13++;
            }
            return this.f32688a.h(i12, i13 - i12);
        }

        public long j() {
            int i10 = this.f32692e;
            if (i10 == 2) {
                return FlexBuffers.p(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 1) {
                return FlexBuffers.o(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.m(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 10) {
                return k().b();
            }
            if (i10 == 26) {
                return FlexBuffers.n(this.f32688a, this.f32689b, this.f32690c);
            }
            if (i10 == 5) {
                return Long.parseLong(i());
            }
            if (i10 == 6) {
                n nVar = this.f32688a;
                return FlexBuffers.o(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
            }
            if (i10 == 7) {
                n nVar2 = this.f32688a;
                return FlexBuffers.p(nVar2, FlexBuffers.i(nVar2, this.f32689b, this.f32690c), this.f32691d);
            }
            if (i10 != 8) {
                return 0L;
            }
            n nVar3 = this.f32688a;
            return (long) FlexBuffers.m(nVar3, FlexBuffers.i(nVar3, this.f32689b, this.f32690c), this.f32690c);
        }

        public j k() {
            if (y()) {
                n nVar = this.f32688a;
                return new j(nVar, FlexBuffers.i(nVar, this.f32689b, this.f32690c), this.f32691d);
            }
            int i10 = this.f32692e;
            if (i10 == 15) {
                n nVar2 = this.f32688a;
                return new h(nVar2, FlexBuffers.i(nVar2, this.f32689b, this.f32690c), this.f32691d, 4);
            }
            if (!FlexBuffers.k(i10)) {
                return j.c();
            }
            n nVar3 = this.f32688a;
            return new h(nVar3, FlexBuffers.i(nVar3, this.f32689b, this.f32690c), this.f32691d, FlexBuffers.r(this.f32692e));
        }

        public int l() {
            return this.f32692e;
        }

        public boolean m() {
            return this.f32692e == 25;
        }

        public boolean n() {
            return this.f32692e == 26;
        }

        public boolean o() {
            int i10 = this.f32692e;
            return i10 == 3 || i10 == 8;
        }

        public boolean p() {
            int i10 = this.f32692e;
            return i10 == 1 || i10 == 6;
        }

        public boolean q() {
            return p() || x();
        }

        public boolean r() {
            return this.f32692e == 4;
        }

        public boolean s() {
            return this.f32692e == 9;
        }

        public boolean t() {
            return this.f32692e == 0;
        }

        public String toString() {
            return z(new StringBuilder(128)).toString();
        }

        public boolean u() {
            return q() || o();
        }

        public boolean v() {
            return this.f32692e == 5;
        }

        public boolean w() {
            return FlexBuffers.k(this.f32692e);
        }

        public boolean x() {
            int i10 = this.f32692e;
            return i10 == 2 || i10 == 7;
        }

        public boolean y() {
            int i10 = this.f32692e;
            return i10 == 10 || i10 == 9;
        }

        public StringBuilder z(StringBuilder sb2) {
            int i10 = this.f32692e;
            if (i10 != 36) {
                switch (i10) {
                    case 0:
                        sb2.append(i0.f11859x);
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(g());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(j());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(d());
                        return sb2;
                    case 4:
                        b bVarF = f();
                        sb2.append(y.f38188b);
                        StringBuilder sbA = bVarF.a(sb2);
                        sbA.append(y.f38188b);
                        return sbA;
                    case 5:
                        sb2.append(y.f38188b);
                        sb2.append(i());
                        sb2.append(y.f38188b);
                        return sb2;
                    case 9:
                        return h().a(sb2);
                    case 10:
                        return k().a(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.f32692e);
                    case 25:
                        return b().a(sb2);
                    case 26:
                        sb2.append(c());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(k());
            return sb2;
        }

        public f(n nVar, int i10, int i11, int i12, int i13) {
            this.f32688a = nVar;
            this.f32689b = i10;
            this.f32690c = i11;
            this.f32691d = i12;
            this.f32692e = i13;
        }
    }

    public static abstract class g extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32693d;

        public g(n nVar, int i10, int i11) {
            super(nVar, i10, i11);
            this.f32693d = (int) FlexBuffers.p(this.f32684a, i10 - i11, i11);
        }

        public int b() {
            return this.f32693d;
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f32694g = new h(FlexBuffers.C, 1, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32695f;

        public h(n nVar, int i10, int i11, int i12) {
            super(nVar, i10, i11);
            this.f32695f = i12;
        }

        public static h f() {
            return f32694g;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.j
        public f d(int i10) {
            if (i10 >= b()) {
                return f.f32687f;
            }
            return new f(this.f32684a, this.f32685b + (i10 * this.f32686c), this.f32686c, 1, this.f32695f);
        }

        public int g() {
            return this.f32695f;
        }

        public boolean h() {
            return this == f32694g;
        }
    }

    public static class i {
        public static int a(byte b10) {
            return b10 & 255;
        }

        public static long b(int i10) {
            return ((long) i10) & 4294967295L;
        }

        public static int c(short s10) {
            return s10 & v1.f38215d;
        }
    }

    public static class j extends g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final j f32696e = new j(FlexBuffers.C, 1, 1);

        public j(n nVar, int i10, int i11) {
            super(nVar, i10, i11);
        }

        public static j c() {
            return f32696e;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public StringBuilder a(StringBuilder sb2) {
            sb2.append("[ ");
            int iB = b();
            for (int i10 = 0; i10 < iB; i10++) {
                d(i10).z(sb2);
                if (i10 != iB - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.g
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public f d(int i10) {
            long jB = b();
            long j10 = i10;
            if (j10 >= jB) {
                return f.f32687f;
            }
            return new f(this.f32684a, this.f32685b + (i10 * this.f32686c), this.f32686c, i.a(this.f32684a.get((int) (((long) this.f32685b) + (jB * ((long) this.f32686c)) + j10))));
        }

        public boolean e() {
            return this == f32696e;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.e
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static f g(n nVar) {
        int iA = nVar.a() - 1;
        byte b10 = nVar.get(iA);
        int i10 = iA - 1;
        return new f(nVar, i10 - b10, b10, i.a(nVar.get(i10)));
    }

    @Deprecated
    public static f h(ByteBuffer byteBuffer) {
        return g(byteBuffer.hasArray() ? new io.objectbox.flatbuffers.a(byteBuffer.array(), byteBuffer.limit()) : new io.objectbox.flatbuffers.d(byteBuffer));
    }

    public static int i(n nVar, int i10, int i11) {
        return (int) (((long) i10) - p(nVar, i10, i11));
    }

    public static boolean j(int i10) {
        return i10 <= 3 || i10 == 26;
    }

    public static boolean k(int i10) {
        return (i10 >= 11 && i10 <= 15) || i10 == 36;
    }

    public static boolean l(int i10) {
        return (i10 >= 1 && i10 <= 4) || i10 == 26;
    }

    public static double m(n nVar, int i10, int i11) {
        if (i11 == 4) {
            return nVar.getFloat(i10);
        }
        if (i11 != 8) {
            return -1.0d;
        }
        return nVar.getDouble(i10);
    }

    public static int n(n nVar, int i10, int i11) {
        return (int) o(nVar, i10, i11);
    }

    public static long o(n nVar, int i10, int i11) {
        int i12;
        if (i11 == 1) {
            i12 = nVar.get(i10);
        } else if (i11 == 2) {
            i12 = nVar.getShort(i10);
        } else {
            if (i11 != 4) {
                if (i11 != 8) {
                    return -1L;
                }
                return nVar.getLong(i10);
            }
            i12 = nVar.getInt(i10);
        }
        return i12;
    }

    public static long p(n nVar, int i10, int i11) {
        if (i11 == 1) {
            return i.a(nVar.get(i10));
        }
        if (i11 == 2) {
            return i.c(nVar.getShort(i10));
        }
        if (i11 == 4) {
            return i.b(nVar.getInt(i10));
        }
        if (i11 != 8) {
            return -1L;
        }
        return nVar.getLong(i10);
    }

    public static int q(int i10, int i11) {
        if (i11 == 0) {
            return (i10 - 1) + 11;
        }
        if (i11 == 2) {
            return (i10 - 1) + 16;
        }
        if (i11 == 3) {
            return (i10 - 1) + 19;
        }
        if (i11 != 4) {
            return 0;
        }
        return (i10 - 1) + 22;
    }

    public static int r(int i10) {
        return (i10 - 11) + 1;
    }
}
