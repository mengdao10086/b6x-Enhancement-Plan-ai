package oi;

import io.objectbox.flatbuffers.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import oi.f;
import oi.g;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends s {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public e g(int i10) {
            return h(new e(), i10);
        }

        public e h(e eVar, int i10) {
            return eVar.v(s.c(a(i10), this.f32704d), this.f32704d);
        }
    }

    public static void A(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(3, i10, 0);
    }

    public static void B(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(1, i10, 0);
    }

    public static void C(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(6, i10, 0);
    }

    public static void D(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(2, i10, 0);
    }

    public static void E(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(4, i10, 0);
    }

    public static int F(io.objectbox.flatbuffers.i iVar, int[] iArr) {
        iVar.i0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            iVar.n(iArr[length]);
        }
        return iVar.F();
    }

    public static int G(io.objectbox.flatbuffers.i iVar, int[] iArr) {
        iVar.i0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            iVar.n(iArr[length]);
        }
        return iVar.F();
    }

    public static int H(io.objectbox.flatbuffers.i iVar) {
        return iVar.E();
    }

    public static e J(ByteBuffer byteBuffer) {
        return K(byteBuffer, new e());
    }

    public static e K(ByteBuffer byteBuffer, e eVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return eVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void f0(io.objectbox.flatbuffers.i iVar) {
        iVar.h0(7);
    }

    public static void g0(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.i0(4, i10, 4);
    }

    public static void h0(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.i0(4, i10, 4);
    }

    public static void u() {
        io.objectbox.flatbuffers.g.a();
    }

    public static void y(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(5, (int) j10, 0);
    }

    public static void z(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(0, i10, 0);
    }

    public long I() {
        int iD = d(14);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public c L() {
        return M(new c());
    }

    public c M(c cVar) {
        int iD = d(4);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public c N() {
        return O(new c());
    }

    public c O(c cVar) {
        int iD = d(10);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public String P() {
        int iD = d(6);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer Q() {
        return m(6, 1);
    }

    public ByteBuffer R(ByteBuffer byteBuffer) {
        return n(byteBuffer, 6, 1);
    }

    public String S() {
        int iD = d(16);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer T() {
        return m(16, 1);
    }

    public ByteBuffer U(ByteBuffer byteBuffer) {
        return n(byteBuffer, 16, 1);
    }

    public f V(int i10) {
        return W(new f(), i10);
    }

    public f W(f fVar, int i10) {
        int iD = d(8);
        if (iD != 0) {
            return fVar.v(b(l(iD) + (i10 * 4)), this.f32763b);
        }
        return null;
    }

    public int X() {
        int iD = d(8);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public f.a Y() {
        return Z(new f.a());
    }

    public f.a Z(f.a aVar) {
        int iD = d(8);
        if (iD != 0) {
            return aVar.f(l(iD), 4, this.f32763b);
        }
        return null;
    }

    public g a0(int i10) {
        return b0(new g(), i10);
    }

    public g b0(g gVar, int i10) {
        int iD = d(12);
        if (iD != 0) {
            return gVar.v(b(l(iD) + (i10 * 4)), this.f32763b);
        }
        return null;
    }

    public int c0() {
        int iD = d(12);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public g.a d0() {
        return e0(new g.a());
    }

    public g.a e0(g.a aVar) {
        int iD = d(12);
        if (iD != 0) {
            return aVar.f(l(iD), 4, this.f32763b);
        }
        return null;
    }

    public e v(int i10, ByteBuffer byteBuffer) {
        w(i10, byteBuffer);
        return this;
    }

    public void w(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
    }
}
