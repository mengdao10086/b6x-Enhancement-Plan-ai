package a;

import android.animation.ValueAnimator;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e10 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TabLayout.f f637a;
    public final /* synthetic */ int b;

    public e10(TabLayout.f fVar, int i, int i2) {
        this.f637a = fVar;
        this.f5955a = i;
        this.b = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        TabLayout.f fVar = this.f637a;
        fVar.f(kv.b(fVar.f, this.f5955a, animatedFraction), kv.b(this.f637a.g, this.b, animatedFraction));
    }
}
