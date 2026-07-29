package na;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class k extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f42016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DecimalFormat f42017c;

    public k(boolean z10, String str, int i10) {
        this.f42015a = z10;
        this.f42016b = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0) {
                stringBuffer.append(j3.b.f36044h);
            }
            stringBuffer.append("0");
        }
        this.f42017c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // na.l
    public String e(float f10, BarEntry barEntry) {
        float[] fArrB0;
        if (this.f42015a || (fArrB0 = barEntry.b0()) == null) {
            return this.f42017c.format(f10) + this.f42016b;
        }
        if (fArrB0[fArrB0.length - 1] != f10) {
            return "";
        }
        return this.f42017c.format(barEntry.e()) + this.f42016b;
    }
}
