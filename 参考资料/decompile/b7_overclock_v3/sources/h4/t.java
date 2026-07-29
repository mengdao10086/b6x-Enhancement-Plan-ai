package h4;

import android.util.Log;
import g.n0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class t implements c4.a<InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30518b = "StreamEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f30519a;

    public t(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f30519a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // c4.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 InputStream inputStream, @n0 File file, @n0 c4.e eVar) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.f30519a.f(65536, byte[].class);
        boolean z10 = false;
        ?? r12 = 0;
        r12 = 0;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
            }
            while (true) {
                try {
                    int i10 = inputStream.read(bArr);
                    r12 = -1;
                    if (i10 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i10);
                } catch (IOException unused3) {
                    r12 = fileOutputStream;
                    Log.isLoggable(f30518b, 3);
                    if (r12 != 0) {
                        r12.close();
                        r12 = r12;
                    }
                    this.f30519a.put(bArr);
                    return z10;
                } catch (Throwable th2) {
                    th = th2;
                    r12 = fileOutputStream;
                    if (r12 != 0) {
                        try {
                            r12.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.f30519a.put(bArr);
                    throw th;
                }
                this.f30519a.put(bArr);
                return z10;
            }
            fileOutputStream.close();
            z10 = true;
            fileOutputStream.close();
            this.f30519a.put(bArr);
            return z10;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
