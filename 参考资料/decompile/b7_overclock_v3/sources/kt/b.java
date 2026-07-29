package kt;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10}, 0, 1);
    }
}
