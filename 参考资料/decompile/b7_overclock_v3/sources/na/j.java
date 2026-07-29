package na;

import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class j extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f42013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ja.g f42014b;

    public j() {
        this.f42013a = new DecimalFormat("###,###,##0.0");
    }

    @Override // na.l
    public String h(float f10) {
        return this.f42013a.format(f10) + " %";
    }

    @Override // na.l
    public String i(float f10, PieEntry pieEntry) {
        ja.g gVar = this.f42014b;
        return (gVar == null || !gVar.q0()) ? this.f42013a.format(f10) : h(f10);
    }

    public j(ja.g gVar) {
        this();
        this.f42014b = gVar;
    }
}
