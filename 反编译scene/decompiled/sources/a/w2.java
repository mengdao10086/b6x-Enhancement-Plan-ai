package a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w2 extends y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectAnimator f7746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3356a;

    public w2(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        super();
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z ? numberOfFrames - 1 : 0;
        int i2 = z ? 0 : numberOfFrames - 1;
        x2 x2Var = new x2(animationDrawable, z);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
        if (Build.VERSION.SDK_INT >= 18) {
            objectAnimatorOfInt.setAutoCancel(true);
        }
        objectAnimatorOfInt.setDuration(x2Var.a());
        objectAnimatorOfInt.setInterpolator(x2Var);
        this.f3356a = z2;
        this.f7746a = objectAnimatorOfInt;
    }

    @Override // a.y2
    public boolean a() {
        return this.f3356a;
    }

    @Override // a.y2
    public void b() {
        this.f7746a.reverse();
    }

    @Override // a.y2
    public void c() {
        this.f7746a.start();
    }

    @Override // a.y2
    public void d() {
        this.f7746a.cancel();
    }
}
