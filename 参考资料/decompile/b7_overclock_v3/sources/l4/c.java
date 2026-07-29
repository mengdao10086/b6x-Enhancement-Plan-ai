package l4;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;
import g.n0;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends Drawable> implements s<T>, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f39446a;

    public c(T t10) {
        this.f39446a = (T) m.d(t10);
    }

    public void b() {
        T t10 = this.f39446a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof n4.c) {
            ((n4.c) t10).h().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f39446a.getConstantState();
        return constantState == null ? this.f39446a : (T) constantState.newDrawable();
    }
}
