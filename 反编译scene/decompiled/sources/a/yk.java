package a;

import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yk extends dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f7989a;

    public yk(Fragment fragment) {
        this.f7989a = fragment;
    }

    @Override // a.dl
    public View b(int i) {
        View view = this.f7989a.f4263a;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + this + " does not have a view");
    }

    @Override // a.dl
    public boolean c() {
        return this.f7989a.f4263a != null;
    }
}
