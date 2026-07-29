package b2;

import androidx.annotation.RestrictTo;
import g.n0;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class i {
    @n0
    public static UUID a(@n0 byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    @n0
    public static byte[] b(@n0 UUID uuid) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        return byteBufferWrap.array();
    }
}
