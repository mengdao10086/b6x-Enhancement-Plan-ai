package a;

import android.animation.Animator;
import android.view.animation.Animation;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f7311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Animation f2749a;

    public rl(Animator animator) {
        this.f2749a = null;
        this.f7311a = animator;
        if (animator == null) {
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    public rl(Animation animation) {
        this.f2749a = animation;
        this.f7311a = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }
}
