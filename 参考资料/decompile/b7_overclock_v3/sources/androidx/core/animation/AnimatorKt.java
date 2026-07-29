package androidx.core.animation;

import android.animation.Animator;
import g.v0;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,136:1\n95#1,14:137\n95#1,14:151\n95#1,14:165\n95#1,14:179\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n32#1:137,14\n43#1:151,14\n54#1:165,14\n64#1:179,14\n*E\n"})
public final class AnimatorKt {

    @t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4575d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super Animator, z1> lVar, l<? super Animator, z1> lVar2, l<? super Animator, z1> lVar3, l<? super Animator, z1> lVar4) {
            this.f4572a = lVar;
            this.f4573b = lVar2;
            this.f4574c = lVar3;
            this.f4575d = lVar4;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4574c.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4573b.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4572a.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4575d.i(animator);
        }
    }

    public static final class b implements Animator.AnimatorPauseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<Animator, z1> f4583b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l<? super Animator, z1> lVar, l<? super Animator, z1> lVar2) {
            this.f4582a = lVar;
            this.f4583b = lVar2;
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4582a.i(animator);
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4583b.i(animator);
        }
    }

    @t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n99#2:137\n96#3:138\n97#4:139\n*E\n"})
    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4584a;

        public c(l lVar) {
            this.f4584a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4584a.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@k Animator animator) {
            f0.p(animator, "animator");
        }
    }

    @t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n99#2:137\n98#3:138\n97#4:139\n*E\n"})
    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4585a;

        public d(l lVar) {
            this.f4585a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4585a.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@k Animator animator) {
            f0.p(animator, "animator");
        }
    }

    @t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n96#2:137\n98#3:138\n97#4:139\n*E\n"})
    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4586a;

        public e(l lVar) {
            this.f4586a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4586a.i(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@k Animator animator) {
            f0.p(animator, "animator");
        }
    }

    @t0({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n*L\n1#1,136:1\n99#2:137\n96#3:138\n98#4:139\n*E\n"})
    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4587a;

        public f(l lVar) {
            this.f4587a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@k Animator animator) {
            f0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@k Animator animator) {
            f0.p(animator, "animator");
            this.f4587a.i(animator);
        }
    }

    @k
    public static final Animator.AnimatorListener a(@k Animator animator, @k l<? super Animator, z1> onEnd, @k l<? super Animator, z1> onStart, @k l<? super Animator, z1> onCancel, @k l<? super Animator, z1> onRepeat) {
        f0.p(animator, "<this>");
        f0.p(onEnd, "onEnd");
        f0.p(onStart, "onStart");
        f0.p(onCancel, "onCancel");
        f0.p(onRepeat, "onRepeat");
        a aVar = new a(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(aVar);
        return aVar;
    }

    public static /* synthetic */ Animator.AnimatorListener b(Animator animator, l onEnd, l onStart, l onCancel, l onRepeat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            onEnd = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 2) != 0) {
            onStart = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 4) != 0) {
            onCancel = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 8) != 0) {
            onRepeat = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        f0.p(animator, "<this>");
        f0.p(onEnd, "onEnd");
        f0.p(onStart, "onStart");
        f0.p(onCancel, "onCancel");
        f0.p(onRepeat, "onRepeat");
        a aVar = new a(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(aVar);
        return aVar;
    }

    @k
    @v0(19)
    public static final Animator.AnimatorPauseListener c(@k Animator animator, @k l<? super Animator, z1> onResume, @k l<? super Animator, z1> onPause) {
        f0.p(animator, "<this>");
        f0.p(onResume, "onResume");
        f0.p(onPause, "onPause");
        b bVar = new b(onPause, onResume);
        androidx.core.animation.a.a(animator, bVar);
        return bVar;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener d(Animator animator, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$1
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 2) != 0) {
            lVar2 = new l<Animator, z1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$2
                public final void b(@k Animator it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Animator animator2) {
                    b(animator2);
                    return z1.f38230a;
                }
            };
        }
        return c(animator, lVar, lVar2);
    }

    @k
    public static final Animator.AnimatorListener e(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        c cVar = new c(action);
        animator.addListener(cVar);
        return cVar;
    }

    @k
    public static final Animator.AnimatorListener f(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        d dVar = new d(action);
        animator.addListener(dVar);
        return dVar;
    }

    @k
    @v0(19)
    public static final Animator.AnimatorPauseListener g(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        return d(animator, null, action, 1, null);
    }

    @k
    public static final Animator.AnimatorListener h(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        e eVar = new e(action);
        animator.addListener(eVar);
        return eVar;
    }

    @k
    @v0(19)
    public static final Animator.AnimatorPauseListener i(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        return d(animator, action, null, 2, null);
    }

    @k
    public static final Animator.AnimatorListener j(@k Animator animator, @k l<? super Animator, z1> action) {
        f0.p(animator, "<this>");
        f0.p(action, "action");
        f fVar = new f(action);
        animator.addListener(fVar);
        return fVar;
    }
}
