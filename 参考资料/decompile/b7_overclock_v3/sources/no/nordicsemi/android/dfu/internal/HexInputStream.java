package no.nordicsemi.android.dfu.internal;

import g.n0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

/* JADX INFO: loaded from: classes5.dex */
public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH;
    private final int MBRSize;
    private final int available;
    private int bytesRead;
    private int lastAddress;
    private final byte[] localBuf;
    private int localPos;
    private int pos;
    private int size;

    public HexInputStream(@n0 final InputStream in2, final int mbrSize) throws IOException {
        super(new BufferedInputStream(in2));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = mbrSize;
        this.available = calculateBinSize(mbrSize);
    }

    private int asciiToInt(final int ascii) {
        if (ascii >= 65) {
            return ascii - 55;
        }
        if (ascii >= 48) {
            return ascii - 48;
        }
        return -1;
    }

    private int calculateBinSize(final int mbrSize) throws IOException {
        int address;
        InputStream inputStream = ((FilterInputStream) this).in;
        inputStream.mark(inputStream.available());
        try {
            int i10 = inputStream.read();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                checkComma(i10);
                int i13 = readByte(inputStream);
                int address2 = readAddress(inputStream);
                int i14 = readByte(inputStream);
                if (i14 != 0) {
                    if (i14 == 1) {
                        return i12;
                    }
                    if (i14 == 2) {
                        address = readAddress(inputStream) << 4;
                        if (i12 > 0 && (address >> 16) != (i11 >> 16) + 1) {
                            return i12;
                        }
                        skip(inputStream, 2L);
                    } else if (i14 == 4) {
                        int address3 = readAddress(inputStream);
                        if (i12 > 0 && address3 != (i11 >> 16) + 1) {
                            return i12;
                        }
                        address = address3 << 16;
                        skip(inputStream, 2L);
                    }
                    i11 = address;
                    while (true) {
                        i10 = inputStream.read();
                        if (i10 != 10 || i10 == 13) {
                        }
                    }
                } else if (address2 + i11 >= mbrSize) {
                    i12 += i13;
                }
                skip(inputStream, (i13 * 2) + 2);
                while (true) {
                    i10 = inputStream.read();
                    if (i10 != 10) {
                    }
                }
            }
        } finally {
            inputStream.reset();
        }
    }

    private void checkComma(final int comma) throws HexFileValidationException {
        if (comma != 58) {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private int readAddress(@n0 final InputStream in2) throws IOException {
        return readByte(in2) | (readByte(in2) << 8);
    }

    private int readByte(@n0 final InputStream in2) throws IOException {
        return asciiToInt(in2.read()) | (asciiToInt(in2.read()) << 4);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        while (true) {
            int i10 = inputStream.read();
            this.pos++;
            if (i10 != 10 && i10 != 13) {
                checkComma(i10);
                int i11 = readByte(inputStream);
                this.pos += 2;
                int address = readAddress(inputStream);
                this.pos += 4;
                int i12 = readByte(inputStream);
                int i13 = this.pos + 2;
                this.pos = i13;
                if (i12 != 0) {
                    if (i12 == 1) {
                        this.pos = -1;
                        return 0;
                    }
                    if (i12 == 2) {
                        int address2 = readAddress(inputStream) << 4;
                        int i14 = this.pos + 4;
                        this.pos = i14;
                        if (this.bytesRead > 0 && (address2 >> 16) != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = address2;
                        this.pos = (int) (((long) i14) + skip(inputStream, 2L));
                    } else if (i12 != 4) {
                        this.pos = (int) (((long) i13) + skip(inputStream, (i11 * 2) + 2));
                    } else {
                        int address3 = readAddress(inputStream);
                        int i15 = this.pos + 4;
                        this.pos = i15;
                        if (this.bytesRead > 0 && address3 != (this.lastAddress >> 16) + 1) {
                            return 0;
                        }
                        this.lastAddress = address3 << 16;
                        this.pos = (int) (((long) i15) + skip(inputStream, 2L));
                    }
                } else if (this.lastAddress + address < this.MBRSize) {
                    this.pos = (int) (((long) i13) + skip(inputStream, (i11 * 2) + 2));
                    i12 = -1;
                }
                if (i12 == 0) {
                    for (int i16 = 0; i16 < this.localBuf.length && i16 < i11; i16++) {
                        int i17 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[i16] = (byte) i17;
                    }
                    this.pos = (int) (((long) this.pos) + skip(inputStream, 2L));
                    this.localPos = 0;
                    return i11;
                }
            }
        }
    }

    private long skip(@n0 final InputStream in2, final long offset) throws IOException {
        long jSkip = in2.skip(offset);
        return jSkip < offset ? jSkip + in2.skip(offset - jSkip) : jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.available - this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(final int readlimit) {
        try {
            super.mark(((FilterInputStream) this).in.available());
        } catch (IOException unused) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int readPacket(@n0 byte[] buffer) throws IOException {
        int i10 = 0;
        while (i10 < buffer.length) {
            int i11 = this.localPos;
            if (i11 < this.size) {
                byte[] bArr = this.localBuf;
                this.localPos = i11 + 1;
                buffer[i10] = bArr[i11];
                i10++;
            } else {
                int i12 = this.bytesRead;
                int line = readLine();
                this.size = line;
                this.bytesRead = i12 + line;
                if (line == 0) {
                    break;
                }
            }
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 128;
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(final int packetSize) {
        int iSizeInBytes = sizeInBytes();
        return (iSizeInBytes / packetSize) + (iSizeInBytes % packetSize > 0 ? 1 : 0);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@n0 byte[] buffer) throws IOException {
        return readPacket(buffer);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@n0 byte[] buffer, int offset, int count) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public HexInputStream(@n0 final byte[] data, final int mbrSize) throws IOException {
        super(new ByteArrayInputStream(data));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = mbrSize;
        this.available = calculateBinSize(mbrSize);
    }
}
