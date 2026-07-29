package com.arialyy.aria.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class BufferedRandomAccessFile extends RandomAccessFile {
    public static final long BuffMask_ = -65536;
    public static final int BuffSz_ = 65536;
    public static final int LogBuffSz_ = 16;
    private byte[] buff_;
    private boolean closed_;
    private long curr_;
    private boolean dirty_;
    private long diskPos_;
    private long hi_;
    private boolean hitEOF_;
    private long lo_;
    private long maxHi_;

    public BufferedRandomAccessFile(File file, String str) throws IOException {
        super(file, str);
        init(0);
    }

    private int fillBuffer() throws IOException {
        int length = this.buff_.length;
        int i10 = 0;
        while (length > 0) {
            int i11 = super.read(this.buff_, i10, length);
            if (i11 < 0) {
                break;
            }
            i10 += i11;
            length -= i11;
        }
        if (i10 < 0) {
            byte[] bArr = this.buff_;
            boolean z10 = i10 < bArr.length;
            this.hitEOF_ = z10;
            if (z10) {
                Arrays.fill(bArr, i10, bArr.length, (byte) -1);
            }
        }
        this.diskPos_ += (long) i10;
        return i10;
    }

    private void flushBuffer() throws IOException {
        if (this.dirty_) {
            long j10 = this.diskPos_;
            long j11 = this.lo_;
            if (j10 != j11) {
                super.seek(j11);
            }
            super.write(this.buff_, 0, (int) (this.curr_ - this.lo_));
            this.diskPos_ = this.curr_;
            this.dirty_ = false;
        }
    }

    private void init(int i10) {
        this.closed_ = false;
        this.dirty_ = false;
        this.hi_ = 0L;
        this.curr_ = 0L;
        this.lo_ = 0L;
        this.buff_ = i10 > 65536 ? new byte[i10] : new byte[65536];
        this.maxHi_ = PlaybackStateCompat.C;
        this.hitEOF_ = false;
        this.diskPos_ = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int writeAtMost(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.curr_
            long r2 = r7.hi_
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L24
            boolean r4 = r7.hitEOF_
            if (r4 == 0) goto L15
            long r4 = r7.maxHi_
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L15
            r7.hi_ = r4
            goto L24
        L15:
            r7.seek(r0)
            long r0 = r7.curr_
            long r2 = r7.hi_
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L24
            long r0 = r7.maxHi_
            r7.hi_ = r0
        L24:
            long r0 = r7.hi_
            long r2 = r7.curr_
            long r0 = r0 - r2
            int r1 = (int) r0
            int r10 = java.lang.Math.min(r10, r1)
            long r0 = r7.curr_
            long r2 = r7.lo_
            long r0 = r0 - r2
            int r1 = (int) r0
            byte[] r0 = r7.buff_
            java.lang.System.arraycopy(r8, r9, r0, r1, r10)
            long r8 = r7.curr_
            long r0 = (long) r10
            long r8 = r8 + r0
            r7.curr_ = r8
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.BufferedRandomAccessFile.writeAtMost(byte[], int, int):int");
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.closed_ = true;
        super.close();
    }

    public void flush() throws IOException {
        flushBuffer();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.curr_;
    }

    @Override // java.io.RandomAccessFile
    public long length() throws IOException {
        return Math.max(this.curr_, super.length());
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        long j10 = this.curr_;
        if (j10 >= this.hi_) {
            if (this.hitEOF_) {
                return -1;
            }
            seek(j10);
            if (this.curr_ == this.hi_) {
                return -1;
            }
        }
        byte[] bArr = this.buff_;
        long j11 = this.curr_;
        byte b10 = bArr[(int) (j11 - this.lo_)];
        this.curr_ = j11 + 1;
        return b10 & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j10) throws IOException {
        if (j10 >= this.hi_ || j10 < this.lo_) {
            flushBuffer();
            long j11 = BuffMask_ & j10;
            this.lo_ = j11;
            this.maxHi_ = ((long) this.buff_.length) + j11;
            if (this.diskPos_ != j11) {
                super.seek(j11);
                this.diskPos_ = this.lo_;
            }
            this.hi_ = this.lo_ + ((long) fillBuffer());
        } else if (j10 < this.curr_) {
            flushBuffer();
        }
        this.curr_ = j10;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i10) throws IOException {
        long j10 = this.curr_;
        long j11 = this.hi_;
        if (j10 >= j11) {
            if (!this.hitEOF_ || j11 >= this.maxHi_) {
                seek(j10);
                long j12 = this.curr_;
                long j13 = this.hi_;
                if (j12 == j13) {
                    this.hi_ = j13 + 1;
                }
            } else {
                this.hi_ = j11 + 1;
            }
        }
        byte[] bArr = this.buff_;
        long j14 = this.curr_;
        bArr[(int) (j14 - this.lo_)] = (byte) i10;
        this.curr_ = j14 + 1;
        this.dirty_ = true;
    }

    public BufferedRandomAccessFile(File file, String str, int i10) throws IOException {
        super(file, str);
        init(i10);
    }

    public BufferedRandomAccessFile(String str, String str2) throws IOException {
        super(str, str2);
        init(0);
    }

    public BufferedRandomAccessFile(String str, String str2, int i10) throws FileNotFoundException {
        super(str, str2);
        init(i10);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = this.curr_;
        if (j10 >= this.hi_) {
            if (this.hitEOF_) {
                return -1;
            }
            seek(j10);
            if (this.curr_ == this.hi_) {
                return -1;
            }
        }
        int iMin = Math.min(i11, (int) (this.hi_ - this.curr_));
        System.arraycopy(this.buff_, (int) (this.curr_ - this.lo_), bArr, i10, iMin);
        this.curr_ += (long) iMin;
        return iMin;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        while (i11 > 0) {
            int iWriteAtMost = writeAtMost(bArr, i10, i11);
            i10 += iWriteAtMost;
            i11 -= iWriteAtMost;
            this.dirty_ = true;
        }
    }
}
