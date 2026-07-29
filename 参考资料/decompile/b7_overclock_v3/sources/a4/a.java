package a4;

import android.graphics.Bitmap;
import g.n0;
import g.p0;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f165a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f166b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f167c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f168d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f169e = 0;

    /* JADX INFO: renamed from: a4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0009a {
        @n0
        Bitmap a(int i10, int i11, @n0 Bitmap.Config config);

        @n0
        int[] b(int i10);

        void c(@n0 Bitmap bitmap);

        void d(@n0 byte[] bArr);

        @n0
        byte[] e(int i10);

        void f(@n0 int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @p0
    Bitmap a();

    void b();

    int c();

    void clear();

    int d();

    void e(@n0 c cVar, @n0 byte[] bArr);

    void f(@n0 Bitmap.Config config);

    int g(int i10);

    @n0
    ByteBuffer getData();

    int getHeight();

    int getWidth();

    void h();

    int i();

    int j();

    int k();

    int l(@p0 InputStream inputStream, int i10);

    void m(@n0 c cVar, @n0 ByteBuffer byteBuffer);

    int n();

    int o();

    void p(@n0 c cVar, @n0 ByteBuffer byteBuffer, int i10);

    @Deprecated
    int q();

    int read(@p0 byte[] bArr);
}
