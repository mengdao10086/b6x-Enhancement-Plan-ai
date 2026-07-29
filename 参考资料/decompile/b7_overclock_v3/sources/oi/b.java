package oi;

import io.objectbox.flatbuffers.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends s {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public b g(int i10) {
            return h(new b(), i10);
        }

        public b h(b bVar, int i10) {
            return bVar.v(s.c(a(i10), this.f32704d), this.f32704d);
        }
    }

    public static void A(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(3, (int) j10, 0);
    }

    public static void B(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.l(2, j10, 0L);
    }

    public static void C(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(4, (int) j10, 0);
    }

    public static void D(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(1, i10, 0);
    }

    public static void E(io.objectbox.flatbuffers.i iVar, boolean z10) {
        iVar.b(13, z10, false);
    }

    public static void F(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.p(7, (short) i10, 0);
    }

    public static void G(io.objectbox.flatbuffers.i iVar, boolean z10) {
        iVar.b(11, z10, false);
    }

    public static void H(io.objectbox.flatbuffers.i iVar, boolean z10) {
        iVar.b(8, z10, false);
    }

    public static void I(io.objectbox.flatbuffers.i iVar, boolean z10) {
        iVar.b(9, z10, false);
    }

    public static void J(io.objectbox.flatbuffers.i iVar, boolean z10) {
        iVar.b(10, z10, false);
    }

    public static void K(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.p(5, (short) i10, 0);
    }

    public static void L(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.l(6, j10, 0L);
    }

    public static int M(io.objectbox.flatbuffers.i iVar, int i10, int i11, long j10, long j11, long j12, int i12, long j13, int i13, boolean z10, boolean z11, boolean z12, boolean z13, long j14, boolean z14) {
        iVar.h0(14);
        L(iVar, j13);
        B(iVar, j10);
        y(iVar, j14);
        C(iVar, j12);
        A(iVar, j11);
        D(iVar, i11);
        z(iVar, i10);
        F(iVar, i13);
        K(iVar, i12);
        E(iVar, z14);
        G(iVar, z13);
        J(iVar, z12);
        I(iVar, z11);
        H(iVar, z10);
        return T(iVar);
    }

    public static int N(io.objectbox.flatbuffers.i iVar, ByteBuffer byteBuffer) {
        return iVar.t(byteBuffer);
    }

    public static int O(io.objectbox.flatbuffers.i iVar, byte[] bArr) {
        return iVar.u(bArr);
    }

    public static int T(io.objectbox.flatbuffers.i iVar) {
        return iVar.E();
    }

    public static void V(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.G(i10);
    }

    public static void W(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.K(i10);
    }

    public static b X(ByteBuffer byteBuffer) {
        return Y(byteBuffer, new b());
    }

    public static b Y(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void l0(io.objectbox.flatbuffers.i iVar) {
        iVar.h0(14);
    }

    public static void m0(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.i0(1, i10, 1);
    }

    public static void u() {
        io.objectbox.flatbuffers.g.a();
    }

    public static void y(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(12, (int) j10, 0);
    }

    public static void z(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(0, i10, 0);
    }

    public long P() {
        int iD = d(28);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public String Q() {
        int iD = d(4);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer R() {
        return m(4, 1);
    }

    public ByteBuffer S(ByteBuffer byteBuffer) {
        return n(byteBuffer, 4, 1);
    }

    public long U() {
        int iD = d(10);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public long Z() {
        int iD = d(8);
        if (iD != 0) {
            return this.f32763b.getLong(iD + this.f32762a);
        }
        return 0L;
    }

    public long a0() {
        int iD = d(12);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public int b0(int i10) {
        int iD = d(6);
        if (iD != 0) {
            return this.f32763b.get(l(iD) + (i10 * 1)) & 255;
        }
        return 0;
    }

    public ByteBuffer c0() {
        return m(6, 1);
    }

    public ByteBuffer d0(ByteBuffer byteBuffer) {
        return n(byteBuffer, 6, 1);
    }

    public int e0() {
        int iD = d(6);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public io.objectbox.flatbuffers.f f0() {
        return g0(new io.objectbox.flatbuffers.f());
    }

    public io.objectbox.flatbuffers.f g0(io.objectbox.flatbuffers.f fVar) {
        int iD = d(6);
        if (iD != 0) {
            return fVar.f(l(iD), this.f32763b);
        }
        return null;
    }

    public boolean h0() {
        int iD = d(30);
        return (iD == 0 || this.f32763b.get(iD + this.f32762a) == 0) ? false : true;
    }

    public int i0() {
        int iD = d(18);
        if (iD != 0) {
            return this.f32763b.getShort(iD + this.f32762a) & v1.f38215d;
        }
        return 0;
    }

    public boolean j0() {
        int iD = d(26);
        return (iD == 0 || this.f32763b.get(iD + this.f32762a) == 0) ? false : true;
    }

    public boolean k0() {
        int iD = d(20);
        return (iD == 0 || this.f32763b.get(iD + this.f32762a) == 0) ? false : true;
    }

    public boolean n0() {
        int iD = d(22);
        return (iD == 0 || this.f32763b.get(iD + this.f32762a) == 0) ? false : true;
    }

    public boolean o0() {
        int iD = d(24);
        return (iD == 0 || this.f32763b.get(iD + this.f32762a) == 0) ? false : true;
    }

    public int p0() {
        int iD = d(14);
        if (iD != 0) {
            return this.f32763b.getShort(iD + this.f32762a) & v1.f38215d;
        }
        return 0;
    }

    public long q0() {
        int iD = d(16);
        if (iD != 0) {
            return this.f32763b.getLong(iD + this.f32762a);
        }
        return 0L;
    }

    public b v(int i10, ByteBuffer byteBuffer) {
        w(i10, byteBuffer);
        return this;
    }

    public void w(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
    }
}
