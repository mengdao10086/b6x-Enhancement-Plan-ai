package va;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f52816g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f52817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f52818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f52819c;

        public a() {
        }

        public void a(pa.b bVar, qa.b bVar2) {
            float fMax = Math.max(0.0f, Math.min(1.0f, c.this.f52835b.h()));
            float lowestVisibleX = bVar.getLowestVisibleX();
            float highestVisibleX = bVar.getHighestVisibleX();
            T tU0 = bVar2.u0(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            T tU02 = bVar2.u0(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            this.f52817a = tU0 == 0 ? 0 : bVar2.t(tU0);
            this.f52818b = tU02 != 0 ? bVar2.t(tU02) : 0;
            this.f52819c = (int) ((r2 - this.f52817a) * fMax);
        }
    }

    public c(ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52816g = new a();
    }

    public boolean l(Entry entry, qa.b bVar) {
        return entry != null && ((float) bVar.t(entry)) < ((float) bVar.e1()) * this.f52835b.h();
    }

    public boolean m(qa.e eVar) {
        return eVar.isVisible() && (eVar.V0() || eVar.C());
    }
}
