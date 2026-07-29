package gm;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l3 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f29738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29739b;

    public l3(InputStream inputStream, int i10) {
        this.f29738a = inputStream;
        this.f29739b = i10;
    }

    public int a() {
        return this.f29739b;
    }

    public void c(boolean z10) {
        InputStream inputStream = this.f29738a;
        if (inputStream instanceof i3) {
            ((i3) inputStream).f(z10);
        }
    }
}
