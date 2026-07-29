package le;

import android.graphics.RectF;
import androidx.annotation.RestrictTo;
import g.n0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f39596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f39597b;

    public b(float f10, @n0 d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f39596a;
            f10 += ((b) dVar).f39597b;
        }
        this.f39596a = dVar;
        this.f39597b = f10;
    }

    @Override // le.d
    public float a(@n0 RectF rectF) {
        return Math.max(0.0f, this.f39596a.a(rectF) + this.f39597b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f39596a.equals(bVar.f39596a) && this.f39597b == bVar.f39597b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39596a, Float.valueOf(this.f39597b)});
    }
}
