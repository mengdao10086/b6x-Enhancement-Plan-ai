package bd;

import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.Format;
import g.p0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    public interface a {
        d a(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException;

        boolean b(String str);

        d c(String str, String str2) throws IOException;
    }

    int a(Format format);

    void b(int i10, ByteBuffer byteBuffer, boolean z10, long j10);

    void c(boolean z10);

    boolean d(@p0 String str);
}
