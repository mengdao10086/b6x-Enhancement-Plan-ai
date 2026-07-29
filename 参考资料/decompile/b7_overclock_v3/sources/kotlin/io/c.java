package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "ConsoleKt")
public final class c {
    @bk.f
    public static final void a(byte b10) {
        System.out.print(Byte.valueOf(b10));
    }

    @bk.f
    public static final void b(char c10) {
        System.out.print(c10);
    }

    @bk.f
    public static final void c(double d10) {
        System.out.print(d10);
    }

    @bk.f
    public static final void d(float f10) {
        System.out.print(f10);
    }

    @bk.f
    public static final void e(int i10) {
        System.out.print(i10);
    }

    @bk.f
    public static final void f(long j10) {
        System.out.print(j10);
    }

    @bk.f
    public static final void g(Object obj) {
        System.out.print(obj);
    }

    @bk.f
    public static final void h(short s10) {
        System.out.print(Short.valueOf(s10));
    }

    @bk.f
    public static final void i(boolean z10) {
        System.out.print(z10);
    }

    @bk.f
    public static final void j(char[] message) {
        f0.p(message, "message");
        System.out.print(message);
    }

    @bk.f
    public static final void k() {
        System.out.println();
    }

    @bk.f
    public static final void l(byte b10) {
        System.out.println(Byte.valueOf(b10));
    }

    @bk.f
    public static final void m(char c10) {
        System.out.println(c10);
    }

    @bk.f
    public static final void n(double d10) {
        System.out.println(d10);
    }

    @bk.f
    public static final void o(float f10) {
        System.out.println(f10);
    }

    @bk.f
    public static final void p(int i10) {
        System.out.println(i10);
    }

    @bk.f
    public static final void q(long j10) {
        System.out.println(j10);
    }

    @bk.f
    public static final void r(Object obj) {
        System.out.println(obj);
    }

    @bk.f
    public static final void s(short s10) {
        System.out.println(Short.valueOf(s10));
    }

    @bk.f
    public static final void t(boolean z10) {
        System.out.println(z10);
    }

    @bk.f
    public static final void u(char[] message) {
        f0.p(message, "message");
        System.out.println(message);
    }

    @yt.l
    public static final String v() {
        l lVar = l.f37813a;
        InputStream inputStream = System.in;
        f0.o(inputStream, "`in`");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        f0.o(charsetDefaultCharset, "defaultCharset()");
        return lVar.d(inputStream, charsetDefaultCharset);
    }

    @v0(version = "1.6")
    @yt.k
    public static final String w() {
        String strX = x();
        if (strX != null) {
            return strX;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @v0(version = "1.6")
    @yt.l
    public static final String x() {
        return v();
    }
}
