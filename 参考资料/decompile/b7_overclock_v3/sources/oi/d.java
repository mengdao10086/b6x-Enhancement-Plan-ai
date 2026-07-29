package oi;

import io.objectbox.flatbuffers.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import oi.e;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends s {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public d g(int i10) {
            return h(new d(), i10);
        }

        public d h(d dVar, int i10) {
            return dVar.v(s.c(a(i10), this.f32704d), this.f32704d);
        }
    }

    public static void A(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(4, i10, 0);
    }

    public static void B(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(5, i10, 0);
    }

    public static void C(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(7, i10, 0);
    }

    public static void D(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(6, i10, 0);
    }

    public static void E(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(0, (int) j10, 0);
    }

    public static void F(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(1, i10, 0);
    }

    public static void G(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.l(2, j10, 0L);
    }

    public static int H(io.objectbox.flatbuffers.i iVar, int[] iArr) {
        iVar.i0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            iVar.n(iArr[length]);
        }
        return iVar.F();
    }

    public static int I(io.objectbox.flatbuffers.i iVar, ByteBuffer byteBuffer) {
        return iVar.t(byteBuffer);
    }

    public static int J(io.objectbox.flatbuffers.i iVar, byte[] bArr) {
        return iVar.u(bArr);
    }

    public static int K(io.objectbox.flatbuffers.i iVar) {
        return iVar.E();
    }

    public static void Q(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.G(i10);
    }

    public static void R(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.K(i10);
    }

    public static d S(ByteBuffer byteBuffer) {
        return T(byteBuffer, new d());
    }

    public static d T(ByteBuffer byteBuffer, d dVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return dVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void m0(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.i0(4, i10, 4);
    }

    public static void n0(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.i0(1, i10, 1);
    }

    public static void o0(io.objectbox.flatbuffers.i iVar) {
        iVar.h0(9);
    }

    public static void u() {
        io.objectbox.flatbuffers.g.a();
    }

    public static void y(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(3, i10, 0);
    }

    public static void z(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(8, i10, 0);
    }

    public e L(int i10) {
        return M(new e(), i10);
    }

    public e M(e eVar, int i10) {
        int iD = d(10);
        if (iD != 0) {
            return eVar.v(b(l(iD) + (i10 * 4)), this.f32763b);
        }
        return null;
    }

    public int N() {
        int iD = d(10);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public e.a O() {
        return P(new e.a());
    }

    public e.a P(e.a aVar) {
        int iD = d(10);
        if (iD != 0) {
            return aVar.f(l(iD), 4, this.f32763b);
        }
        return null;
    }

    public int U(int i10) {
        int iD = d(20);
        if (iD != 0) {
            return this.f32763b.get(l(iD) + (i10 * 1)) & 255;
        }
        return 0;
    }

    public ByteBuffer V() {
        return m(20, 1);
    }

    public ByteBuffer W(ByteBuffer byteBuffer) {
        return n(byteBuffer, 20, 1);
    }

    public int X() {
        int iD = d(20);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public io.objectbox.flatbuffers.f Y() {
        return Z(new io.objectbox.flatbuffers.f());
    }

    public io.objectbox.flatbuffers.f Z(io.objectbox.flatbuffers.f fVar) {
        int iD = d(20);
        if (iD != 0) {
            return fVar.f(l(iD), this.f32763b);
        }
        return null;
    }

    public c a0() {
        return b0(new c());
    }

    public c b0(c cVar) {
        int iD = d(12);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public c c0() {
        return d0(new c());
    }

    public c d0(c cVar) {
        int iD = d(14);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public c e0() {
        return f0(new c());
    }

    public c f0(c cVar) {
        int iD = d(18);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public c g0() {
        return h0(new c());
    }

    public c h0(c cVar) {
        int iD = d(16);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public long i0() {
        int iD = d(4);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public String j0() {
        int iD = d(6);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer k0() {
        return m(6, 1);
    }

    public ByteBuffer l0(ByteBuffer byteBuffer) {
        return n(byteBuffer, 6, 1);
    }

    public long p0() {
        int iD = d(8);
        if (iD != 0) {
            return this.f32763b.getLong(iD + this.f32762a);
        }
        return 0L;
    }

    public d v(int i10, ByteBuffer byteBuffer) {
        w(i10, byteBuffer);
        return this;
    }

    public void w(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
    }
}
