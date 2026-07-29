package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class h extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f4736b = new StringBuilder(128);

    public h(String str) {
        this.f4735a = str;
    }

    public final void a() {
        if (this.f4736b.length() > 0) {
            this.f4736b.toString();
            StringBuilder sb2 = this.f4736b;
            sb2.delete(0, sb2.length());
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
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f4736b.append(c10);
            }
        }
    }
}
