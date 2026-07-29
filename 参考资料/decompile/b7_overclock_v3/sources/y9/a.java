package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends c.a {
    public a(final f parser, final c.b header, long baseOffset, final int index) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(header.f56532a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j10 = baseOffset + ((long) (index * 8));
        this.f56527a = parser.m(byteBufferAllocate, j10);
        this.f56528b = parser.m(byteBufferAllocate, j10 + 4);
    }
}
