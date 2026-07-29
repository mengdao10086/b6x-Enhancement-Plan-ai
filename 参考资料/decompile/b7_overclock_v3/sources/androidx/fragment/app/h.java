package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    @g.a
    public static int a(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.Q2() : fragment.S2() : z10 ? fragment.b2() : fragment.f2();
    }

    public static a b(@g.n0 Context context, @g.n0 Fragment fragment, boolean z10, boolean z11) {
        int iF2 = fragment.F2();
        int iA = a(fragment, z10, z11);
        boolean z12 = false;
        fragment.b5(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.f5665v1;
        if (viewGroup != null) {
            int i10 = R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.f5665v1.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.f5665v1;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationL3 = fragment.L3(iF2, z10, iA);
        if (animationL3 != null) {
            return new a(animationL3);
        }
        Animator animatorM3 = fragment.M3(iF2, z10, iA);
        if (animatorM3 != null) {
            return new a(animatorM3);
        }
        if (iA == 0 && iF2 != 0) {
            iA = d(context, iF2, z10);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (zEquals) {
                        throw e11;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @g.a
    public static int c(@g.n0 Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @g.a
    public static int d(@g.n0 Context context, int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (i10 == 8194) {
            return z10 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
        }
        if (i10 == 8197) {
            return z10 ? c(context, android.R.attr.activityCloseEnterAnimation) : c(context, android.R.attr.activityCloseExitAnimation);
        }
        if (i10 == 4099) {
            return z10 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
        }
        if (i10 != 4100) {
            return -1;
        }
        return z10 ? c(context, android.R.attr.activityOpenEnterAnimation) : c(context, android.R.attr.activityOpenExitAnimation);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f5973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f5974b;

        public a(Animation animation) {
            this.f5973a = animation;
            this.f5974b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f5973a = null;
            this.f5974b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f5975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f5976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5979e;

        public b(@g.n0 Animation animation, @g.n0 ViewGroup viewGroup, @g.n0 View view) {
            super(false);
            this.f5979e = true;
            this.f5975a = viewGroup;
            this.f5976b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, @g.n0 Transformation transformation) {
            this.f5979e = true;
            if (this.f5977c) {
                return !this.f5978d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f5977c = true;
                androidx.core.view.n0.a(this.f5975a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5977c || !this.f5979e) {
                this.f5975a.endViewTransition(this.f5976b);
                this.f5978d = true;
            } else {
                this.f5979e = false;
                this.f5975a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, @g.n0 Transformation transformation, float f10) {
            this.f5979e = true;
            if (this.f5977c) {
                return !this.f5978d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f5977c = true;
                androidx.core.view.n0.a(this.f5975a, this);
            }
            return true;
        }
    }
}
