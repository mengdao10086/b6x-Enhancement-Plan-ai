package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class b extends c.a {
    public b(final f parser, final c.b header, long baseOffset, final int index) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(header.f56532a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j10 = baseOffset + ((long) (index * 16));
        this.f56527a = parser.k(byteBufferAllocate, j10);
        this.f56528b = parser.k(byteBufferAllocate, j10 + 8);
    }
}
