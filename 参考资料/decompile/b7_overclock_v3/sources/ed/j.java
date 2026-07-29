package ed;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface j {

    public interface a {
        j a();
    }

    void a(com.google.android.exoplayer2.upstream.b bVar) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;
}
