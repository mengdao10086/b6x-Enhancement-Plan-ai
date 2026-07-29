package androidx.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6411a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6412b = 101010256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6413c = 16384;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6415b;
    }

    public static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j10 = aVar.f6415b;
        randomAccessFile.seek(aVar.f6414a);
        byte[] bArr = new byte[16384];
        int i10 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j10));
        while (i10 != -1) {
            crc32.update(bArr, 0, i10);
            j10 -= (long) i10;
            if (j10 == 0) {
                break;
            }
            i10 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j10));
        }
        return crc32.getValue();
    }

    public static a b(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j10 = length - PlaybackStateCompat.C;
        long j11 = j10 >= 0 ? j10 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.f6415b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                aVar.f6414a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return aVar;
            }
            length--;
        } while (length >= j11);
        throw new ZipException("End Of Central Directory signature not found");
    }

    public static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, SsManifestParser.e.J);
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
