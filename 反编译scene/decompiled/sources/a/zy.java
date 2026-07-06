package a;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zy implements bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8107a;

    public zy(float f) {
        this.f8107a = f;
    }

    @Override // a.bz
    public float a(RectF rectF) {
        return this.f8107a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zy) && this.f8107a == ((zy) obj).f8107a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8107a)});
    }
}
