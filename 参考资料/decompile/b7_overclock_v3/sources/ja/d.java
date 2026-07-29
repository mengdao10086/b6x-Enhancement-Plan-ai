package ja;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes3.dex */
public class d extends b<la.i> implements pa.d {
    public d(Context context) {
        super(context);
    }

    @Override // ja.b, ja.e
    public void H() {
        super.H();
        this.f36264r = new va.e(this, this.f36267u, this.f36266t);
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    @Override // pa.d
    public la.i getCandleData() {
        return (la.i) this.f36247b;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
