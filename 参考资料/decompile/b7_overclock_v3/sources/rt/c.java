package rt;

import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes6.dex */
public class c implements Checksum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f49185b = -3750763034362895579L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f49186c = 1099511628211L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f49187a = f49185b;

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.f49187a;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f49187a = f49185b;
    }

    @Override // java.util.zip.Checksum
    public void update(int i10) {
        this.f49187a = (this.f49187a ^ (((long) i10) & 255)) * f49186c;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            this.f49187a = (this.f49187a ^ (255 & ((long) bArr[i10]))) * f49186c;
            i10++;
        }
    }
}
