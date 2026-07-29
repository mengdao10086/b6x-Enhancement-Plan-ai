package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class x0 extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f2732b;

    public x0(@g.n0 Context context, @g.n0 Resources resources) {
        super(resources);
        this.f2732b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.o0, android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable drawableA = a(i10);
        Context context = this.f2732b.get();
        if (drawableA != null && context != null) {
            n0.h().x(context, i10, drawableA);
        }
        return drawableA;
    }
}
