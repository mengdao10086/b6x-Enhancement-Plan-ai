package a;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kz implements bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6655a;

    public kz(float f) {
        this.f6655a = f;
    }

    @Override // a.bz
    public float a(RectF rectF) {
        return this.f6655a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kz) && this.f6655a == ((kz) obj).f6655a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f6655a)});
    }
}
