package oi;

import io.objectbox.flatbuffers.r;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends r {

    public static final class a extends io.objectbox.flatbuffers.b {
        public a f(int i10, int i11, ByteBuffer byteBuffer) {
            b(i10, i11, byteBuffer);
            return this;
        }

        public c g(int i10) {
            return h(new c(), i10);
        }

        public c h(c cVar, int i10) {
            return cVar.c(a(i10), this.f32704d);
        }
    }

    public static int e(io.objectbox.flatbuffers.i iVar, long j10, long j11) {
        iVar.U(8, 16);
        iVar.a0(j11);
        iVar.T(4);
        iVar.Z((int) j10);
        return iVar.S();
    }

    public c c(int i10, ByteBuffer byteBuffer) {
        d(i10, byteBuffer);
        return this;
    }

    public void d(int i10, ByteBuffer byteBuffer) {
        b(i10, byteBuffer);
    }

    public long f() {
        return ((long) this.f32761b.getInt(this.f32760a + 0)) & 4294967295L;
    }

    public long g() {
        return this.f32761b.getLong(this.f32760a + 8);
    }
}
