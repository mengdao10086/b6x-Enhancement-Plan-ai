package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class t72 {
    public static final long a(Reader reader, Writer writer, int i) throws IOException {
        f92.d(reader, "$this$copyTo");
        f92.d(writer, "out");
        char[] cArr = new char[i];
        int i2 = reader.read(cArr);
        long j = 0;
        while (i2 >= 0) {
            writer.write(cArr, 0, i2);
            j += (long) i2;
            i2 = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(reader, writer, i);
    }

    public static final void c(Reader reader, g82<? super String, m42> g82Var) {
        f92.d(reader, "$this$forEachLine");
        f92.d(g82Var, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                g82Var.f(it.next());
            }
            m42 m42Var = m42.f6769a;
            k72.a(bufferedReader, null);
        } finally {
        }
    }

    public static final pa2<String> d(BufferedReader bufferedReader) {
        f92.d(bufferedReader, "$this$lineSequence");
        return ta2.b(new s72(bufferedReader));
    }

    public static final String e(Reader reader) {
        f92.d(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        f92.c(string, "buffer.toString()");
        return string;
    }
}
