package a;

import androidx.activity.OnBackPressedDispatcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f7255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ OnBackPressedDispatcher f2668a;

    public r(OnBackPressedDispatcher onBackPressedDispatcher, q qVar) {
        this.f2668a = onBackPressedDispatcher;
        this.f7255a = qVar;
    }

    @Override // a.p
    public void cancel() {
        this.f2668a.f3955a.remove(this.f7255a);
        this.f7255a.e(this);
    }
}
