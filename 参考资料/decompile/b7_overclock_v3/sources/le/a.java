package le;

import android.graphics.RectF;
import g.n0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f39595a;

    public a(float f10) {
        this.f39595a = f10;
    }

    @Override // le.d
    public float a(@n0 RectF rectF) {
        return this.f39595a;
    }

    public float b() {
        return this.f39595a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f39595a == ((a) obj).f39595a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f39595a)});
    }
}
