package a;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z7 extends ga<Integer, PorterDuffColorFilter> {
    public z7(int i) {
        super(i);
    }

    public static int h(int i, PorterDuff.Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    public PorterDuffColorFilter i(int i, PorterDuff.Mode mode) {
        return c(Integer.valueOf(h(i, mode)));
    }

    public PorterDuffColorFilter j(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return d(Integer.valueOf(h(i, mode)), porterDuffColorFilter);
    }
}
