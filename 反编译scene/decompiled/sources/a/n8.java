package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n8 extends e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f6886a;

    public n8(Context context, Resources resources) {
        super(resources);
        this.f6886a = new WeakReference<>(context);
    }

    @Override // a.e8, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f6886a.get();
        if (drawable != null && context != null) {
            d8.h().x(context, i, drawable);
        }
        return drawable;
    }
}
