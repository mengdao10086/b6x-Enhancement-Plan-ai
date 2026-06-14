package a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sl extends AnimationSet implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewGroup f2903a;
    public boolean b;
    public boolean c;
    public boolean d;

    public sl(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.d = true;
        this.f2903a = viewGroup;
        this.f7410a = view;
        addAnimation(animation);
        this.f2903a.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        this.d = true;
        if (this.b) {
            return !this.c;
        }
        if (!super.getTransformation(j, transformation)) {
            this.b = true;
            og.a(this.f2903a, this);
        }
        return true;
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.d = true;
        if (this.b) {
            return !this.c;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.b = true;
            og.a(this.f2903a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b || !this.d) {
            this.f2903a.endViewTransition(this.f7410a);
            this.c = true;
        } else {
            this.d = false;
            this.f2903a.post(this);
        }
    }
}
