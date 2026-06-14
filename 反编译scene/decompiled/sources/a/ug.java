package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ug extends wg<Boolean> {
    public ug(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // a.wg
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean c(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }
}
