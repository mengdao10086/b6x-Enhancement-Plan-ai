package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.c2;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n1#2:327\n1#2:329\n52#3:328\n1295#4,2:330\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n202#1:329\n202#1:328\n202#1:330,2\n*E\n"})
public class n {
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path A(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        f0.p(options, "options");
        Path pathWrite = Files.write(path, SequencesKt___SequencesKt.N(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathWrite, "write(this, lines.asIterable(), charset, *options)");
        return pathWrite;
    }

    public static /* synthetic */ Path B(Path path, Iterable lines, Charset charset, OpenOption[] options, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        f0.p(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathWrite, "write(this, lines, charset, *options)");
        return pathWrite;
    }

    public static /* synthetic */ Path C(Path path, kotlin.sequences.m lines, Charset charset, OpenOption[] options, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        f0.p(options, "options");
        Path pathWrite = Files.write(path, SequencesKt___SequencesKt.N(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathWrite, "write(this, lines.asIterable(), charset, *options)");
        return pathWrite;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static final void D(@yt.k Path path, @yt.k CharSequence text, @yt.k Charset charset, @yt.k OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        f0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final OutputStreamWriter F(Path path, Charset charset, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    public static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] options, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final void a(Path path, byte[] array) throws IOException {
        f0.p(path, "<this>");
        f0.p(array, "array");
        Files.write(path, array, StandardOpenOption.APPEND);
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path b(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        f0.o(pathWrite, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path c(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset) throws IOException {
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        Path pathWrite = Files.write(path, SequencesKt___SequencesKt.N(lines), charset, StandardOpenOption.APPEND);
        f0.o(pathWrite, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    public static /* synthetic */ Path d(Path path, Iterable lines, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        f0.o(pathWrite, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    public static /* synthetic */ Path e(Path path, kotlin.sequences.m lines, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        Path pathWrite = Files.write(path, SequencesKt___SequencesKt.N(lines), charset, StandardOpenOption.APPEND);
        f0.o(pathWrite, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static final void f(@yt.k Path path, @yt.k CharSequence text, @yt.k Charset charset) throws IOException {
        f0.p(path, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, StandardOpenOption.APPEND);
        f0.o(outputStreamNewOutputStream, "newOutputStream(this, StandardOpenOption.APPEND)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f(path, charSequence, charset);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final BufferedReader h(Path path, Charset charset, int i10, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i10);
    }

    public static /* synthetic */ BufferedReader i(Path path, Charset charset, int i10, OpenOption[] options, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i10);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final BufferedWriter j(Path path, Charset charset, int i10, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i10);
    }

    public static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i10, OpenOption[] options, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i10);
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final void l(Path path, Charset charset, ik.l<? super String, z1> action) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        f0.o(bufferedReaderNewBufferedReader, "newBufferedReader(this, charset)");
        try {
            Iterator<String> it2 = TextStreamsKt.h(bufferedReaderNewBufferedReader).iterator();
            while (it2.hasNext()) {
                action.i(it2.next());
            }
            z1 z1Var = z1.f38230a;
            c0.d(1);
            kotlin.io.b.a(bufferedReaderNewBufferedReader, null);
            c0.c(1);
        } finally {
        }
    }

    public static /* synthetic */ void m(Path path, Charset charset, ik.l action, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        f0.o(bufferedReaderNewBufferedReader, "newBufferedReader(this, charset)");
        try {
            Iterator<String> it2 = TextStreamsKt.h(bufferedReaderNewBufferedReader).iterator();
            while (it2.hasNext()) {
                action.i(it2.next());
            }
            z1 z1Var = z1.f38230a;
            c0.d(1);
            kotlin.io.b.a(bufferedReaderNewBufferedReader, null);
            c0.c(1);
        } finally {
        }
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final InputStream n(Path path, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(inputStreamNewInputStream, "newInputStream(this, *options)");
        return inputStreamNewInputStream;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final OutputStream o(Path path, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return outputStreamNewOutputStream;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final byte[] p(Path path) throws IOException {
        f0.p(path, "<this>");
        byte[] allBytes = Files.readAllBytes(path);
        f0.o(allBytes, "readAllBytes(this)");
        return allBytes;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final List<String> q(Path path, Charset charset) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        f0.o(allLines, "readAllLines(this, charset)");
        return allLines;
    }

    public static /* synthetic */ List r(Path path, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        f0.o(allLines, "readAllLines(this, charset)");
        return allLines;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    @yt.k
    public static final String s(@yt.k Path path, @yt.k Charset charset) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String strK = TextStreamsKt.k(inputStreamReader);
            kotlin.io.b.a(inputStreamReader, null);
            return strK;
        } finally {
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        return s(path, charset);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final InputStreamReader u(Path path, Charset charset, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    public static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] options, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final <T> T w(Path path, Charset charset, ik.l<? super kotlin.sequences.m<String>, ? extends T> block) throws IOException {
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(block, "block");
        BufferedReader it2 = Files.newBufferedReader(path, charset);
        try {
            f0.o(it2, "it");
            T tI = block.i(TextStreamsKt.h(it2));
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
            return tI;
        } finally {
        }
    }

    public static /* synthetic */ Object x(Path path, Charset charset, ik.l block, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(path, "<this>");
        f0.p(charset, "charset");
        f0.p(block, "block");
        BufferedReader it2 = Files.newBufferedReader(path, charset);
        try {
            f0.o(it2, "it");
            Object objI = block.i(TextStreamsKt.h(it2));
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
            return objI;
        } finally {
        }
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final void y(Path path, byte[] array, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(array, "array");
        f0.p(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path z(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(lines, "lines");
        f0.p(charset, "charset");
        f0.p(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathWrite, "write(this, lines, charset, *options)");
        return pathWrite;
    }
}
