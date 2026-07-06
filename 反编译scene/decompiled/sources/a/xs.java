package a;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xs extends Property<View, Rect> {
    public xs(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect get(View view) {
        return eh.r(view);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(View view, Rect rect) {
        eh.p0(view, rect);
    }
}
