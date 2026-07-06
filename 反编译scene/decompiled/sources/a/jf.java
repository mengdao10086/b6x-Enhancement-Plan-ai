package a;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@Deprecated
public class jf extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StringBuilder f1532a = new StringBuilder(128);

    public jf(String str) {
        this.f6505a = str;
    }

    public final void a() {
        if (this.f1532a.length() > 0) {
            Log.d(this.f6505a, this.f1532a.toString());
            StringBuilder sb = this.f1532a;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.f1532a.append(c);
            }
        }
    }
}
