package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    public static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c10) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i10) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11 + i10, cArr.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11 + i10, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, charSequence.length());
            return this;
        }
    }

    private CharStreams() {
    }

    @Beta
    public static Writer asWriter(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            return appendable instanceof StringBuilder ? copyReaderToBuilder((Reader) readable, (StringBuilder) appendable) : copyReaderToWriter((Reader) readable, asWriter(appendable));
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        long jRemaining = 0;
        CharBuffer charBufferCreateBuffer = createBuffer();
        while (readable.read(charBufferCreateBuffer) != -1) {
            charBufferCreateBuffer.flip();
            appendable.append(charBufferCreateBuffer);
            jRemaining += (long) charBufferCreateBuffer.remaining();
            charBufferCreateBuffer.clear();
        }
        return jRemaining;
    }

    @CanIgnoreReturnValue
    public static long copyReaderToBuilder(Reader reader, StringBuilder sb2) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb2);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int i10 = reader.read(cArr);
            if (i10 == -1) {
                return j10;
            }
            sb2.append(cArr, 0, i10);
            j10 += (long) i10;
        }
    }

    @CanIgnoreReturnValue
    public static long copyReaderToWriter(Reader reader, Writer writer) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int i10 = reader.read(cArr);
            if (i10 == -1) {
                return j10;
            }
            writer.write(cArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) throws IOException {
        CharBuffer charBufferCreateBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            long j11 = readable.read(charBufferCreateBuffer);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            charBufferCreateBuffer.clear();
        }
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @Beta
    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String line = lineReader.readLine();
            if (line == null) {
                return arrayList;
            }
            arrayList.add(line);
        }
    }

    @Beta
    public static void skipFully(Reader reader, long j10) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j10 > 0) {
            long jSkip = reader.skip(j10);
            if (jSkip == 0) {
                throw new EOFException();
            }
            j10 -= jSkip;
        }
    }

    public static String toString(Readable readable) throws IOException {
        return toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb2);
        } else {
            copy(readable, sb2);
        }
        return sb2;
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String line;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            line = lineReader.readLine();
            if (line == null) {
                break;
            }
        } while (lineProcessor.processLine(line));
        return lineProcessor.getResult();
    }
}
