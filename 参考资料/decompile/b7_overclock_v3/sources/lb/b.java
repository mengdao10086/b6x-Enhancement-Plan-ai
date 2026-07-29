package lb;

import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import g.p0;
import hd.w;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f39546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f39547b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f39550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f39551d;

        public a(String str, String str2, long j10, long j11) {
            this.f39548a = str;
            this.f39549b = str2;
            this.f39550c = j10;
            this.f39551d = j11;
        }
    }

    public b(long j10, List<a> list) {
        this.f39546a = j10;
        this.f39547b = list;
    }

    @p0
    public MotionPhotoMetadata a(long j10) {
        long j11;
        if (this.f39547b.size() < 2) {
            return null;
        }
        long j12 = j10;
        long j13 = -1;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        boolean z10 = false;
        for (int size = this.f39547b.size() - 1; size >= 0; size--) {
            a aVar = this.f39547b.get(size);
            boolean zEquals = w.f31182f.equals(aVar.f39548a) | z10;
            if (size == 0) {
                j11 = j12 - aVar.f39551d;
                j12 = 0;
            } else {
                long j17 = j12;
                j12 -= aVar.f39550c;
                j11 = j17;
            }
            if (!zEquals || j12 == j11) {
                z10 = zEquals;
            } else {
                j16 = j11 - j12;
                j15 = j12;
                z10 = false;
            }
            if (size == 0) {
                j13 = j12;
                j14 = j11;
            }
        }
        if (j15 == -1 || j16 == -1 || j13 == -1 || j14 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j13, j14, this.f39546a, j15, j16);
    }
}
