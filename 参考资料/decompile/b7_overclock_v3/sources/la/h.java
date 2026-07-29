package la;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h extends d<BubbleEntry> implements qa.c {
    public float A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f39503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f39504z;

    public h(List<BubbleEntry> list, String str) {
        super(list, str);
        this.f39504z = true;
        this.A = 2.5f;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BubbleEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((BubbleEntry) this.f16633s.get(i10)).z());
        }
        h hVar = new h(arrayList, J());
        V1(hVar);
        return hVar;
    }

    @Override // qa.c
    public float S0() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void K1(BubbleEntry bubbleEntry) {
        super.K1(bubbleEntry);
        float fT = bubbleEntry.T();
        if (fT > this.f39503y) {
            this.f39503y = fT;
        }
    }

    public void V1(h hVar) {
        hVar.A = this.A;
        hVar.f39504z = this.f39504z;
    }

    public void W1(boolean z10) {
        this.f39504z = z10;
    }

    @Override // qa.c
    public float a() {
        return this.f39503y;
    }

    @Override // qa.c
    public boolean f() {
        return this.f39504z;
    }

    @Override // qa.c
    public void i0(float f10) {
        this.A = xa.k.e(f10);
    }
}
