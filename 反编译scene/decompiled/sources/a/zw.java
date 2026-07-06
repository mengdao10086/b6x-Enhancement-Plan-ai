package a;

import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zw extends Property<View, Float> {
    public zw(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(View view) {
        return Float.valueOf(view.getLayoutParams().height);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(View view, Float f) {
        view.getLayoutParams().height = f.intValue();
        view.requestLayout();
    }
}
