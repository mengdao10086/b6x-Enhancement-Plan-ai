package com.arialyy.aria.http;

import com.arialyy.aria.util.ALog;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ChunkedInputStream extends InputStream {
    private static final String TAG = "ChunkedInputStream";
    private DataInputStream din;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f11434id;
    private int unreadBytes = 0;
    private byte[] singleByte = new byte[1];
    private boolean endOfData = false;

    public ChunkedInputStream(InputStream inputStream, String str) {
        this.din = new DataInputStream(inputStream);
        this.f11434id = str;
        ALog.d(TAG, String.format("Creating chunked input for %s", str));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ALog.d(TAG, String.format("%s: Closing chunked input.", this.f11434id));
        this.din.close();
    }

    public boolean isEndOfData() {
        return this.endOfData;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByte, 0, 1) == -1) {
            return -1;
        }
        return this.singleByte[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 < 0) {
            throw new IllegalArgumentException(this.f11434id + ": Negative read length");
        }
        if (i11 == 0) {
            return 0;
        }
        if (this.unreadBytes == 0) {
            try {
                int i12 = this.din.readInt();
                this.unreadBytes = i12;
                ALog.d(TAG, String.format("%s: Chunk size %s", this.f11434id, Integer.valueOf(i12)));
                if (this.unreadBytes == 0) {
                    ALog.d(TAG, String.format("%s: Hit end of data", this.f11434id));
                    this.endOfData = true;
                    return -1;
                }
            } catch (IOException e10) {
                throw new IOException(this.f11434id + ": Error while attempting to read chunk length", e10);
            }
        }
        int iMin = Math.min(i11, this.unreadBytes);
        try {
            this.din.readFully(bArr, i10, iMin);
            this.unreadBytes -= iMin;
            return 0 + iMin;
        } catch (IOException e11) {
            throw new IOException(this.f11434id + ": Error while attempting to read " + iMin + " bytes from current chunk", e11);
        }
    }
}
