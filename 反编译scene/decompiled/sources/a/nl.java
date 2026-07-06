package a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nl implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yl f6928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f2108a;

    public nl(yl ylVar, ViewGroup viewGroup, Fragment fragment) {
        this.f6928a = ylVar;
        this.f2107a = viewGroup;
        this.f2108a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2107a.post(new ml(this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
