package qg;

import android.graphics.PointF;
import android.view.View;
import mg.k;

/* JADX INFO: loaded from: classes5.dex */
public class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f47361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f47362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47363c = true;

    @Override // mg.k
    public boolean a(View view) {
        k kVar = this.f47362b;
        return kVar != null ? kVar.a(view) : tg.b.b(view, this.f47361a);
    }

    @Override // mg.k
    public boolean b(View view) {
        k kVar = this.f47362b;
        return kVar != null ? kVar.b(view) : tg.b.a(view, this.f47361a, this.f47363c);
    }
}
