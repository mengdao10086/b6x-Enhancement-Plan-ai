package so;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class f0 implements r0, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f50164d = 32768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f50165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f50166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f50167c;

    public f0(gm.y yVar, File file, int i10) {
        this.f50165a = yVar;
        this.f50166b = file;
        this.f50167c = i10;
    }

    public f0(File file) {
        this(file, 32768);
    }

    public f0(File file, int i10) {
        this(mm.k.I2, file, i10);
    }

    @Override // so.r0
    public gm.y a() {
        return this.f50165a;
    }

    @Override // so.d0
    public Object b() {
        return this.f50166b;
    }

    @Override // so.h0
    public InputStream c() throws CMSException, IOException {
        return new BufferedInputStream(new FileInputStream(this.f50166b), this.f50167c);
    }

    @Override // so.d0
    public void d(OutputStream outputStream) throws CMSException, IOException {
        FileInputStream fileInputStream = new FileInputStream(this.f50166b);
        kt.c.c(fileInputStream, outputStream, this.f50167c);
        fileInputStream.close();
    }
}
