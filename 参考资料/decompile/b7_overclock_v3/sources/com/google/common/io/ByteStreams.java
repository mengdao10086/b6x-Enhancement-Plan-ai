package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            Preconditions.checkNotNull(bArr);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Deque<byte[]> deque, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = i10;
        while (i11 > 0) {
            byte[] bArrRemoveFirst = deque.removeFirst();
            int iMin = Math.min(i11, bArrRemoveFirst.length);
            System.arraycopy(bArrRemoveFirst, 0, bArr, i10 - i11, iMin);
            i11 -= iMin;
        }
        return bArr;
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArrCreateBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArrCreateBuffer);
            if (i10 == -1) {
                return j10;
            }
            outputStream.write(bArrCreateBuffer, 0, i10);
            j10 += (long) i10;
        }
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream inputStream) throws IOException {
        byte[] bArrCreateBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            long j11 = inputStream.read(bArrCreateBuffer);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    @Beta
    public static InputStream limit(InputStream inputStream, long j10) {
        return new LimitedInputStream(inputStream, j10);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i12 = 0;
        while (i12 < i11) {
            int i13 = inputStream.read(bArr, i10 + i12, i11 - i12);
            if (i13 == -1) {
                break;
            }
            i12 += i13;
        }
        return i12;
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int i10;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] bArrCreateBuffer = createBuffer();
        do {
            i10 = inputStream.read(bArrCreateBuffer);
            if (i10 == -1) {
                break;
            }
        } while (byteProcessor.processBytes(bArrCreateBuffer, 0, i10));
        return byteProcessor.getResult();
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void skipFully(InputStream inputStream, long j10) throws IOException {
        long jSkipUpTo = skipUpTo(inputStream, j10);
        if (jSkipUpTo >= j10) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + jSkipUpTo + " bytes; " + j10 + " bytes expected");
    }

    private static long skipSafely(InputStream inputStream, long j10) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(iAvailable, j10));
    }

    public static long skipUpTo(InputStream inputStream, long j10) throws IOException {
        byte[] bArrCreateBuffer = createBuffer();
        long j11 = 0;
        while (j11 < j10) {
            long j12 = j10 - j11;
            long jSkipSafely = skipSafely(inputStream, j12);
            if (jSkipSafely == 0) {
                jSkipSafely = inputStream.read(bArrCreateBuffer, 0, (int) Math.min(j12, bArrCreateBuffer.length));
                if (jSkipSafely == -1) {
                    break;
                }
            }
            j11 += jSkipSafely;
        }
        return j11;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Deque<byte[]> deque, int i10) throws IOException {
        int iSaturatedMultiply = 8192;
        while (i10 < 2147483639) {
            int iMin = Math.min(iSaturatedMultiply, 2147483639 - i10);
            byte[] bArr = new byte[iMin];
            deque.add(bArr);
            int i11 = 0;
            while (i11 < iMin) {
                int i12 = inputStream.read(bArr, i11, iMin - i11);
                if (i12 == -1) {
                    return combineBuffers(deque, i10);
                }
                i11 += i12;
                i10 += i12;
            }
            iSaturatedMultiply = IntMath.saturatedMultiply(iSaturatedMultiply, 2);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(deque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        public final DataInput input;

        public ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e10) {
                throw new IllegalStateException(e10);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i10) {
            try {
                return this.input.skipBytes(i10);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) {
            try {
                this.input.readFully(bArr, i10, i11);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        public final ByteArrayOutputStream byteArrayOutputSteam;
        public final DataOutput output;

        public ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputSteam = byteArrayOutputStream;
            this.output = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i10) {
            try {
                this.output.write(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z10) {
            try {
                this.output.writeBoolean(z10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i10) {
            try {
                this.output.writeByte(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i10) {
            try {
                this.output.writeChar(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d10) {
            try {
                this.output.writeDouble(d10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f10) {
            try {
                this.output.writeFloat(f10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i10) {
            try {
                this.output.writeInt(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j10) {
            try {
                this.output.writeLong(j10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i10) {
            try {
                this.output.writeShort(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i10, int i11) {
            try {
                this.output.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr, int i10) {
        Preconditions.checkPositionIndex(i10, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i10, bArr.length - i10));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int i10) {
        if (i10 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i10));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i10)));
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = read(inputStream, bArr, i10, i11);
        if (i12 == i11) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + i12 + " bytes; " + i11 + " bytes expected");
    }

    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        public LimitedInputStream(InputStream inputStream, long j10) {
            super(inputStream);
            this.mark = -1L;
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkArgument(j10 >= 0, "limit must be non-negative");
            this.left = j10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.left--;
            }
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.left = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j10, this.left));
            this.left -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            long j10 = this.left;
            if (j10 == 0) {
                return -1;
            }
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, (int) Math.min(i11, j10));
            if (i12 != -1) {
                this.left -= (long) i12;
            }
            return i12;
        }
    }

    public static byte[] toByteArray(InputStream inputStream, long j10) throws IOException {
        Preconditions.checkArgument(j10 >= 0, "expectedSize (%s) must be non-negative", j10);
        if (j10 <= 2147483639) {
            int i10 = (int) j10;
            byte[] bArr = new byte[i10];
            int i11 = i10;
            while (i11 > 0) {
                int i12 = i10 - i11;
                int i13 = inputStream.read(bArr, i12, i11);
                if (i13 == -1) {
                    return Arrays.copyOf(bArr, i12);
                }
                i11 -= i13;
            }
            int i14 = inputStream.read();
            if (i14 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) i14});
            return toByteArrayInternal(inputStream, arrayDeque, i10 + 1);
        }
        throw new OutOfMemoryError(j10 + " bytes is too large to fit in a byte array");
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long jWrite = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long jPosition = fileChannel.position();
            long j10 = jPosition;
            while (true) {
                long jTransferTo = fileChannel.transferTo(j10, PlaybackStateCompat.K0, writableByteChannel);
                j10 += jTransferTo;
                fileChannel.position(j10);
                if (jTransferTo <= 0 && j10 >= fileChannel.size()) {
                    return j10 - jPosition;
                }
            }
        } else {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(byteBufferWrap) != -1) {
                byteBufferWrap.flip();
                while (byteBufferWrap.hasRemaining()) {
                    jWrite += (long) writableByteChannel.write(byteBufferWrap);
                }
                byteBufferWrap.clear();
            }
            return jWrite;
        }
    }
}
