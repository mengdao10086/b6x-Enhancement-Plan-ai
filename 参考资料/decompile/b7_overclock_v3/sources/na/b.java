package na;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f42003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42004b;

    public b(int i10) {
        this.f42004b = i10;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0) {
                stringBuffer.append(j3.b.f36044h);
            }
            stringBuffer.append("0");
        }
        this.f42003a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // na.l
    public String h(float f10) {
        return this.f42003a.format(f10);
    }

    public int l() {
        return this.f42004b;
    }
}
