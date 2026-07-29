package l4;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends c<Drawable> {
    public e(Drawable drawable) {
        super(drawable);
    }

    @p0
    public static s<Drawable> f(@p0 Drawable drawable) {
        if (drawable != null) {
            return new e(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return Math.max(1, this.f39446a.getIntrinsicWidth() * this.f39446a.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<Drawable> d() {
        return this.f39446a.getClass();
    }
}
