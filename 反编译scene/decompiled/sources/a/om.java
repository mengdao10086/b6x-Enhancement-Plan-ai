package a;

import android.graphics.Rect;
import android.transition.Transition;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class om extends Transition.EpicenterCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rect f7036a;

    public om(sm smVar, Rect rect) {
        this.f7036a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        return this.f7036a;
    }
}
