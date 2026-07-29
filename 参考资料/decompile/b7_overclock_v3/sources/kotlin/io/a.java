package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.collections.p;
import kotlin.jvm.internal.f0;
import kotlin.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "ByteStreamsKt")
public final class a {

    /* JADX INFO: renamed from: kotlin.io.a$a, reason: collision with other inner class name */
    public static final class C0432a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37783a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f37785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BufferedInputStream f37786d;

        public C0432a(BufferedInputStream bufferedInputStream) {
            this.f37786d = bufferedInputStream;
        }

        @Override // kotlin.collections.p
        public byte b() throws IOException {
            h();
            if (this.f37785c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b10 = (byte) this.f37783a;
            this.f37784b = false;
            return b10;
        }

        public final boolean d() {
            return this.f37785c;
        }

        public final int e() {
            return this.f37783a;
        }

        public final boolean g() {
            return this.f37784b;
        }

        public final void h() throws IOException {
            if (this.f37784b || this.f37785c) {
                return;
            }
            int i10 = this.f37786d.read();
            this.f37783a = i10;
            this.f37784b = true;
            this.f37785c = i10 == -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            h();
            return !this.f37785c;
        }

        public final void j(boolean z10) {
            this.f37785c = z10;
        }

        public final void k(int i10) {
            this.f37783a = i10;
        }

        public final void l(boolean z10) {
            this.f37784b = z10;
        }
    }

    @bk.f
    public static final BufferedInputStream a(InputStream inputStream, int i10) {
        f0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i10);
    }

    @bk.f
    public static final BufferedOutputStream b(OutputStream outputStream, int i10) {
        f0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i10);
    }

    public static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        f0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i10);
    }

    public static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        f0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i10);
    }

    @bk.f
    public static final BufferedReader e(InputStream inputStream, Charset charset) {
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    public static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @bk.f
    public static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @bk.f
    public static final ByteArrayInputStream i(String str, Charset charset) {
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@yt.k InputStream inputStream, @yt.k OutputStream out, int i10) throws IOException {
        f0.p(inputStream, "<this>");
        f0.p(out, "out");
        byte[] bArr = new byte[i10];
        int i11 = inputStream.read(bArr);
        long j10 = 0;
        while (i11 >= 0) {
            out.write(bArr, 0, i11);
            j10 += (long) i11;
            i11 = inputStream.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return k(inputStream, outputStream, i10);
    }

    @bk.f
    public static final ByteArrayInputStream m(byte[] bArr) {
        f0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @bk.f
    public static final ByteArrayInputStream n(byte[] bArr, int i10, int i11) {
        f0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i10, i11);
    }

    @yt.k
    public static final p o(@yt.k BufferedInputStream bufferedInputStream) {
        f0.p(bufferedInputStream, "<this>");
        return new C0432a(bufferedInputStream);
    }

    @v0(version = "1.3")
    @yt.k
    public static final byte[] p(@yt.k InputStream inputStream) {
        f0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @kotlin.k(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @t0(expression = "readBytes()", imports = {}))
    @kotlin.l(errorSince = "1.5", warningSince = "1.3")
    @yt.k
    public static final byte[] q(@yt.k InputStream inputStream, int i10) {
        f0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i10, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        return q(inputStream, i10);
    }

    @bk.f
    public static final InputStreamReader s(InputStream inputStream, Charset charset) {
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    public static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @bk.f
    public static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
