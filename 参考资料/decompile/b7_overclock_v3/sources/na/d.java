package na;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f42005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42006b;

    public d(int i10) {
        m(i10);
    }

    @Override // na.l
    public String h(float f10) {
        return this.f42005a.format(f10);
    }

    public int l() {
        return this.f42006b;
    }

    public void m(int i10) {
        this.f42006b = i10;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0) {
                stringBuffer.append(j3.b.f36044h);
            }
            stringBuffer.append("0");
        }
        this.f42005a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
