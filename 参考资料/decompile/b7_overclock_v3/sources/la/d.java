package la;

import android.graphics.Color;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T extends Entry> extends DataSet<T> implements qa.b<T> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f39481x;

    public d(List<T> list, String str) {
        super(list, str);
        this.f39481x = Color.rgb(255, mb.e.f41031i2, 115);
    }

    public void S1(d dVar) {
        super.O1(dVar);
        dVar.f39481x = this.f39481x;
    }

    public void T1(int i10) {
        this.f39481x = i10;
    }

    @Override // qa.b
    public int Y0() {
        return this.f39481x;
    }
}
