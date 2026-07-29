package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "TextStreamsKt")
@t0({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1295#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
public final class TextStreamsKt {
    @bk.f
    public static final BufferedReader a(Reader reader, int i10) {
        f0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i10);
    }

    @bk.f
    public static final BufferedWriter b(Writer writer, int i10) {
        f0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i10);
    }

    public static /* synthetic */ BufferedReader c(Reader reader, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        f0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i10);
    }

    public static /* synthetic */ BufferedWriter d(Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        f0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i10);
    }

    public static final long e(@yt.k Reader reader, @yt.k Writer out, int i10) throws IOException {
        f0.p(reader, "<this>");
        f0.p(out, "out");
        char[] cArr = new char[i10];
        int i11 = reader.read(cArr);
        long j10 = 0;
        while (i11 >= 0) {
            out.write(cArr, 0, i11);
            j10 += (long) i11;
            i11 = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return e(reader, writer, i10);
    }

    public static final void g(@yt.k Reader reader, @yt.k ik.l<? super String, z1> action) {
        f0.p(reader, "<this>");
        f0.p(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it2 = h(bufferedReader).iterator();
            while (it2.hasNext()) {
                action.i(it2.next());
            }
            z1 z1Var = z1.f38230a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    @yt.k
    public static final kotlin.sequences.m<String> h(@yt.k BufferedReader bufferedReader) {
        f0.p(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.f(new m(bufferedReader));
    }

    @yt.k
    public static final byte[] i(@yt.k URL url) throws IOException {
        f0.p(url, "<this>");
        InputStream it2 = url.openStream();
        try {
            f0.o(it2, "it");
            byte[] bArrP = a.p(it2);
            b.a(it2, null);
            return bArrP;
        } finally {
        }
    }

    @yt.k
    public static final List<String> j(@yt.k Reader reader) {
        f0.p(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        g(reader, new ik.l<String, z1>() { // from class: kotlin.io.TextStreamsKt$readLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.k String it2) {
                f0.p(it2, "it");
                arrayList.add(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        });
        return arrayList;
    }

    @yt.k
    public static final String k(@yt.k Reader reader) {
        f0.p(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        f(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        f0.o(string, "buffer.toString()");
        return string;
    }

    @bk.f
    public static final String l(URL url, Charset charset) {
        f0.p(url, "<this>");
        f0.p(charset, "charset");
        return new String(i(url), charset);
    }

    public static /* synthetic */ String m(URL url, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(url, "<this>");
        f0.p(charset, "charset");
        return new String(i(url), charset);
    }

    @bk.f
    public static final StringReader n(String str) {
        f0.p(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T o(@yt.k Reader reader, @yt.k ik.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        f0.p(reader, "<this>");
        f0.p(block, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T tI = block.i(h(bufferedReader));
            c0.d(1);
            b.a(bufferedReader, null);
            c0.c(1);
            return tI;
        } finally {
        }
    }
}
