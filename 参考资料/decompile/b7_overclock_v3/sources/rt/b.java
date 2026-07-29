package rt;

import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Checksum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f49182b = -2128831035;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49183c = 16777619;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49184a = f49182b;

    @Override // java.util.zip.Checksum
    public long getValue() {
        return ((long) this.f49184a) & 4294967295L;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f49184a = f49182b;
    }

    @Override // java.util.zip.Checksum
    public void update(int i10) {
        this.f49184a = ((i10 & 255) ^ this.f49184a) * f49183c;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            this.f49184a = (this.f49184a ^ (bArr[i10] & 255)) * f49183c;
            i10++;
        }
    }
}
