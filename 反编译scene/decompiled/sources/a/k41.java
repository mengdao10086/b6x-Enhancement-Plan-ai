package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj0 f6572a = new vj0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f1605a = {5, 10, 15, 30, 45, 60, 90, 120, 150, 250, 300, 450, 600, 900, 1200, 1800, 2400};

    public final vj0 a() {
        return this.f6572a;
    }

    public final j41 b(double d) {
        int iY = u42.y(this.f1605a);
        int i = 0;
        if (d <= iY) {
            int[] iArr = this.f1605a;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                int i3 = iArr[i2];
                if (d <= i3) {
                    i = i3;
                    break;
                }
                i2++;
            }
        } else {
            do {
                iY += 600;
            } while (iY < d);
            i = iY;
        }
        if (i == 0) {
            i = (int) d;
        }
        return i != 5 ? i != 15 ? i != 30 ? i != 45 ? i != 60 ? i != 90 ? i != 120 ? new j41(i, 10, 2, 4) : new j41(i, 12, 3, 6) : new j41(i, 18, 3, 6) : new j41(i, 12, 2, 4) : new j41(i, 9, 2, 2) : new j41(i, 12, 2, 4) : new j41(i, 15, 5, 5) : new j41(i, 10, 2, 2);
    }
}
