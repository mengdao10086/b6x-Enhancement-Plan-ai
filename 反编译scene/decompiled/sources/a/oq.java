package a;

import a.hn;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pq f7046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SavedStateRegistry f2280a = new SavedStateRegistry();

    public oq(pq pqVar) {
        this.f7046a = pqVar;
    }

    public static oq a(pq pqVar) {
        return new oq(pqVar);
    }

    public SavedStateRegistry b() {
        return this.f2280a;
    }

    public void c(Bundle bundle) {
        hn lifecycle = this.f7046a.getLifecycle();
        if (lifecycle.b() != hn.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f7046a));
        this.f2280a.b(lifecycle, bundle);
    }

    public void d(Bundle bundle) {
        this.f2280a.c(bundle);
    }
}
