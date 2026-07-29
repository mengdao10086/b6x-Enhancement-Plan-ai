package gm;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f29755a = Runtime.getRuntime().maxMemory();

    public static int a(InputStream inputStream) {
        if (inputStream instanceof l3) {
            return ((l3) inputStream).a();
        }
        if (inputStream instanceof s) {
            return ((s) inputStream).k();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j10 = f29755a;
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }
}
