package a;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class az implements bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bz f160a;

    public az(float f, bz bzVar) {
        while (bzVar instanceof az) {
            bzVar = ((az) bzVar).f160a;
            f += ((az) bzVar).f5655a;
        }
        this.f160a = bzVar;
        this.f5655a = f;
    }

    @Override // a.bz
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f160a.a(rectF) + this.f5655a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        return this.f160a.equals(azVar.f160a) && this.f5655a == azVar.f5655a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f160a, Float.valueOf(this.f5655a)});
    }
}
