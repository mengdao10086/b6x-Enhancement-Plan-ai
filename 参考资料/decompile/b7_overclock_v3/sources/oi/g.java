package oi;

import io.objectbox.flatbuffers.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends s {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public g g(int i10) {
            return h(new g(), i10);
        }

        public g h(g gVar, int i10) {
            return gVar.v(s.c(a(i10), this.f32704d), this.f32704d);
        }
    }

    public static void A(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(2, i10, 0);
    }

    public static int B(io.objectbox.flatbuffers.i iVar) {
        return iVar.E();
    }

    public static g C(ByteBuffer byteBuffer) {
        return D(byteBuffer, new g());
    }

    public static g D(ByteBuffer byteBuffer, g gVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return gVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void J(io.objectbox.flatbuffers.i iVar) {
        iVar.h0(3);
    }

    public static void u() {
        io.objectbox.flatbuffers.g.a();
    }

    public static void y(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.r(0, i10, 0);
    }

    public static void z(io.objectbox.flatbuffers.i iVar, int i10) {
        iVar.o(1, i10, 0);
    }

    public c E() {
        return F(new c());
    }

    public c F(c cVar) {
        int iD = d(4);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public String G() {
        int iD = d(6);
        if (iD != 0) {
            return h(iD + this.f32762a);
        }
        return null;
    }

    public ByteBuffer H() {
        return m(6, 1);
    }

    public ByteBuffer I(ByteBuffer byteBuffer) {
        return n(byteBuffer, 6, 1);
    }

    public c K() {
        return L(new c());
    }

    public c L(c cVar) {
        int iD = d(8);
        if (iD != 0) {
            return cVar.c(iD + this.f32762a, this.f32763b);
        }
        return null;
    }

    public g v(int i10, ByteBuffer byteBuffer) {
        w(i10, byteBuffer);
        return this;
    }

    public void w(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
    }
}
