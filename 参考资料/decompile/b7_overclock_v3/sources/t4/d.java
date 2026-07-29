package t4;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public class d implements f<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50874b;

    public d(int i10, boolean z10) {
        this.f50873a = i10;
        this.f50874b = z10;
    }

    @Override // t4.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable drawableE = aVar.e();
        if (drawableE == null) {
            drawableE = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableE, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f50874b);
        transitionDrawable.startTransition(this.f50873a);
        aVar.d(transitionDrawable);
        return true;
    }
}
