package a;

import android.graphics.Rect;
import android.transition.Transition;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rm extends Transition.EpicenterCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rect f7314a;

    public rm(sm smVar, Rect rect) {
        this.f7314a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f7314a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f7314a;
    }
}
