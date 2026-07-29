package na;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements e, g {
    @Override // na.g
    @Deprecated
    public String a(float f10, Entry entry, int i10, xa.l lVar) {
        return h(f10);
    }

    @Override // na.e
    @Deprecated
    public String b(float f10, ka.a aVar) {
        return h(f10);
    }

    public String c(float f10, ka.a aVar) {
        return h(f10);
    }

    public String d(BarEntry barEntry) {
        return h(barEntry.e());
    }

    public String e(float f10, BarEntry barEntry) {
        return h(f10);
    }

    public String f(BubbleEntry bubbleEntry) {
        return h(bubbleEntry.T());
    }

    public String g(CandleEntry candleEntry) {
        return h(candleEntry.V());
    }

    public String h(float f10) {
        return String.valueOf(f10);
    }

    public String i(float f10, PieEntry pieEntry) {
        return h(f10);
    }

    public String j(Entry entry) {
        return h(entry.e());
    }

    public String k(RadarEntry radarEntry) {
        return h(radarEntry.e());
    }
}
