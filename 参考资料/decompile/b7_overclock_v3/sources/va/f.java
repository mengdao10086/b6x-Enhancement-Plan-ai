package va;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.CombinedChart;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<g> f52831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<ja.e> f52832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<oa.d> f52833i;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52834a;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            f52834a = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52834a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52834a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52834a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52834a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public f(CombinedChart combinedChart, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52831g = new ArrayList(5);
        this.f52833i = new ArrayList();
        this.f52832h = new WeakReference<>(combinedChart);
        l();
    }

    @Override // va.g
    public void b(Canvas canvas) {
        Iterator<g> it2 = this.f52831g.iterator();
        while (it2.hasNext()) {
            it2.next().b(canvas);
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
        Iterator<g> it2 = this.f52831g.iterator();
        while (it2.hasNext()) {
            it2.next().c(canvas);
        }
    }

    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        ja.e eVar = this.f52832h.get();
        if (eVar == null) {
            return;
        }
        for (g gVar : this.f52831g) {
            Object bubbleData = null;
            if (gVar instanceof b) {
                bubbleData = ((b) gVar).f52810h.getBarData();
            } else if (gVar instanceof j) {
                bubbleData = ((j) gVar).f52851i.getLineData();
            } else if (gVar instanceof e) {
                bubbleData = ((e) gVar).f52825i.getCandleData();
            } else if (gVar instanceof p) {
                bubbleData = ((p) gVar).f52890i.getScatterData();
            } else if (gVar instanceof d) {
                bubbleData = ((d) gVar).f52821h.getBubbleData();
            }
            int iIndexOf = bubbleData == null ? -1 : ((la.l) eVar.getData()).Q().indexOf(bubbleData);
            this.f52833i.clear();
            for (oa.d dVar : dVarArr) {
                if (dVar.c() == iIndexOf || dVar.c() == -1) {
                    this.f52833i.add(dVar);
                }
            }
            List<oa.d> list = this.f52833i;
            gVar.d(canvas, (oa.d[]) list.toArray(new oa.d[list.size()]));
        }
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
    }

    @Override // va.g
    public void f(Canvas canvas) {
        Iterator<g> it2 = this.f52831g.iterator();
        while (it2.hasNext()) {
            it2.next().f(canvas);
        }
    }

    @Override // va.g
    public void j() {
        Iterator<g> it2 = this.f52831g.iterator();
        while (it2.hasNext()) {
            it2.next().j();
        }
    }

    public void l() {
        this.f52831g.clear();
        CombinedChart combinedChart = (CombinedChart) this.f52832h.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i10 = a.f52834a[drawOrder.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5 && combinedChart.getScatterData() != null) {
                                this.f52831g.add(new p(combinedChart, this.f52835b, this.f52889a));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.f52831g.add(new e(combinedChart, this.f52835b, this.f52889a));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.f52831g.add(new j(combinedChart, this.f52835b, this.f52889a));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.f52831g.add(new d(combinedChart, this.f52835b, this.f52889a));
                }
            } else if (combinedChart.getBarData() != null) {
                this.f52831g.add(new b(combinedChart, this.f52835b, this.f52889a));
            }
        }
    }

    public g m(int i10) {
        if (i10 >= this.f52831g.size() || i10 < 0) {
            return null;
        }
        return this.f52831g.get(i10);
    }

    public List<g> n() {
        return this.f52831g;
    }

    public void o(List<g> list) {
        this.f52831g = list;
    }
}
