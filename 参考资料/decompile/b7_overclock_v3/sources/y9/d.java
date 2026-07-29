package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class d extends c.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f56548m;

    public d(final boolean bigEndian, final f parser) throws IOException {
        this.f56532a = bigEndian;
        this.f56548m = parser;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f56533b = parser.i(byteBufferAllocate, 16L);
        this.f56534c = parser.m(byteBufferAllocate, 28L);
        this.f56535d = parser.m(byteBufferAllocate, 32L);
        this.f56536e = parser.i(byteBufferAllocate, 42L);
        this.f56537f = parser.i(byteBufferAllocate, 44L);
        this.f56538g = parser.i(byteBufferAllocate, 46L);
        this.f56539h = parser.i(byteBufferAllocate, 48L);
        this.f56540i = parser.i(byteBufferAllocate, 50L);
    }

    @Override // y9.c.b
    public c.a a(final long baseOffset, final int index) throws IOException {
        return new a(this.f56548m, this, baseOffset, index);
    }

    @Override // y9.c.b
    public c.AbstractC0667c b(final long index) throws IOException {
        return new g(this.f56548m, this, index);
    }

    @Override // y9.c.b
    public c.d c(final int index) throws IOException {
        return new i(this.f56548m, this, index);
    }
}
