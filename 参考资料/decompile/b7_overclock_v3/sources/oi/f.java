package oi;

import io.objectbox.flatbuffers.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends s {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public f g(int i10) {
            return h(new f(), i10);
        }

        public f h(f fVar, int i10) {
            return fVar.v(s.c(a(i10), this.f32704d), this.f32704d);
        }
    }

    public static void A(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(4, i10, 0);
    }

    public static void B(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(8, (int) j10, 0);
    }

    public static void C(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(1, i10, 0);
    }

    public static void D(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(7, i10, 0);
    }

    public static void E(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(5, i10, 0);
    }

    public static void F(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.p(2, (short) i10, 0);
    }

    public static void G(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(6, i10, 0);
    }

    public static int H(io.objectbox.flatbuffers.i iVar) {
        return iVar.E();
    }

    public static f J(ByteBuffer byteBuffer) {
        return K(byteBuffer, new f());
    }

    public static f K(ByteBuffer byteBuffer, f fVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return fVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void W(io.objectbox.flatbuffers.i iVar) {
        iVar.h0(9);
    }

    public static void u() {
        io.objectbox.flatbuffers.g.a();
    }

    public static void y(io.objectbox.flatbuffers.i iVar, long j10) {
        iVar.k(3, (int) j10, 0);
    }

    public static void z(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(0, i10, 0);
    }

    public long I() {
        int iD = d(10);
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
        int iD = d(12);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public long P() {
        int iD = d(20);
        if (iD != 0) {
            return ((long) this.f32763b.getInt(iD + this.f32762a)) & 4294967295L;
        }
        return 0L;
    }

    public String Q() {
        int iD = d(6);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer R() {
        return m(6, 1);
    }

    public ByteBuffer S(ByteBuffer byteBuffer) {
        return n(byteBuffer, 6, 1);
    }

    public String T() {
        int iD = d(18);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer U() {
        return m(18, 1);
    }

    public ByteBuffer V(ByteBuffer byteBuffer) {
        return n(byteBuffer, 18, 1);
    }

    public String X() {
        int iD = d(14);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer Y() {
        return m(14, 1);
    }

    public ByteBuffer Z(ByteBuffer byteBuffer) {
        return n(byteBuffer, 14, 1);
    }

    public int a0() {
        int iD = d(8);
        if (iD != 0) {
            return this.f32763b.getShort(iD + this.f32762a) & v1.f38215d;
        }
        return 0;
    }

    public String b0() {
        int iD = d(16);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer c0() {
        return m(16, 1);
    }

    public ByteBuffer d0(ByteBuffer byteBuffer) {
        return n(byteBuffer, 16, 1);
    }

    public f v(int i10, ByteBuffer byteBuffer) {
        w(i10, byteBuffer);
        return this;
    }

    public void w(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
    }
}
