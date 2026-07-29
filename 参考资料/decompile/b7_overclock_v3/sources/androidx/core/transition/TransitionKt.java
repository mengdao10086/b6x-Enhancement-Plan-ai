package androidx.core.transition;

import android.annotation.SuppressLint;
import android.transition.Transition;
import g.v0;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,86:1\n69#1,16:87\n69#1,16:103\n69#1,16:119\n69#1,16:135\n69#1,16:151\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n31#1:87,16\n39#1:103,16\n47#1:119,16\n55#1:135,16\n63#1:151,16\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
public final class TransitionKt {

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,86:1\n*E\n"})
    public static final class a implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<Transition, z1> f4688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<Transition, z1> f4689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l<Transition, z1> f4690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l<Transition, z1> f4691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l<Transition, z1> f4692e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super Transition, z1> lVar, l<? super Transition, z1> lVar2, l<? super Transition, z1> lVar3, l<? super Transition, z1> lVar4, l<? super Transition, z1> lVar5) {
            this.f4688a = lVar;
            this.f4689b = lVar2;
            this.f4690c = lVar3;
            this.f4691d = lVar4;
            this.f4692e = lVar5;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4691d.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4688a.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4690c.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4689b.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4692e.i(transition);
        }
    }

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,86:1\n70#2:87\n73#3:88\n74#4:89\n71#5:90\n*E\n"})
    public static final class b implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4698a;

        public b(l lVar) {
            this.f4698a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4698a.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
        }
    }

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,86:1\n73#2:87\n74#3:88\n72#4:89\n71#5:90\n*E\n"})
    public static final class c implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4699a;

        public c(l lVar) {
            this.f4699a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4699a.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
        }
    }

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,86:1\n70#2:87\n73#3:88\n72#4:89\n71#5:90\n*E\n"})
    public static final class d implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4700a;

        public d(l lVar) {
            this.f4700a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4700a.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
        }
    }

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,86:1\n70#2:87\n74#3:88\n72#4:89\n71#5:90\n*E\n"})
    public static final class e implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4701a;

        public e(l lVar) {
            this.f4701a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4701a.i(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
        }
    }

    @t0({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n*L\n1#1,86:1\n70#2:87\n73#3:88\n74#4:89\n72#5:90\n*E\n"})
    public static final class f implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4702a;

        public f(l lVar) {
            this.f4702a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@k Transition transition) {
            f0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@k Transition transition) {
            f0.p(transition, "transition");
            this.f4702a.i(transition);
        }
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener a(@k Transition transition, @k l<? super Transition, z1> onEnd, @k l<? super Transition, z1> onStart, @k l<? super Transition, z1> onCancel, @k l<? super Transition, z1> onResume, @k l<? super Transition, z1> onPause) {
        f0.p(transition, "<this>");
        f0.p(onEnd, "onEnd");
        f0.p(onStart, "onStart");
        f0.p(onCancel, "onCancel");
        f0.p(onResume, "onResume");
        f0.p(onPause, "onPause");
        a aVar = new a(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(aVar);
        return aVar;
    }

    public static /* synthetic */ Transition.TransitionListener b(Transition transition, l onEnd, l lVar, l lVar2, l onResume, l onPause, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            onEnd = new l<Transition, z1>() { // from class: androidx.core.transition.TransitionKt$addListener$1
                public final void b(@k Transition it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Transition transition2) {
                    b(transition2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 2) != 0) {
            lVar = new l<Transition, z1>() { // from class: androidx.core.transition.TransitionKt$addListener$2
                public final void b(@k Transition it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Transition transition2) {
                    b(transition2);
                    return z1.f38230a;
                }
            };
        }
        l onStart = lVar;
        if ((i10 & 4) != 0) {
            lVar2 = new l<Transition, z1>() { // from class: androidx.core.transition.TransitionKt$addListener$3
                public final void b(@k Transition it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Transition transition2) {
                    b(transition2);
                    return z1.f38230a;
                }
            };
        }
        l onCancel = lVar2;
        if ((i10 & 8) != 0) {
            onResume = new l<Transition, z1>() { // from class: androidx.core.transition.TransitionKt$addListener$4
                public final void b(@k Transition it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Transition transition2) {
                    b(transition2);
                    return z1.f38230a;
                }
            };
        }
        if ((i10 & 16) != 0) {
            onPause = new l<Transition, z1>() { // from class: androidx.core.transition.TransitionKt$addListener$5
                public final void b(@k Transition it2) {
                    f0.p(it2, "it");
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Transition transition2) {
                    b(transition2);
                    return z1.f38230a;
                }
            };
        }
        f0.p(transition, "<this>");
        f0.p(onEnd, "onEnd");
        f0.p(onStart, "onStart");
        f0.p(onCancel, "onCancel");
        f0.p(onResume, "onResume");
        f0.p(onPause, "onPause");
        a aVar = new a(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(aVar);
        return aVar;
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener c(@k Transition transition, @k l<? super Transition, z1> action) {
        f0.p(transition, "<this>");
        f0.p(action, "action");
        b bVar = new b(action);
        transition.addListener(bVar);
        return bVar;
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener d(@k Transition transition, @k l<? super Transition, z1> action) {
        f0.p(transition, "<this>");
        f0.p(action, "action");
        c cVar = new c(action);
        transition.addListener(cVar);
        return cVar;
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener e(@k Transition transition, @k l<? super Transition, z1> action) {
        f0.p(transition, "<this>");
        f0.p(action, "action");
        d dVar = new d(action);
        transition.addListener(dVar);
        return dVar;
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener f(@k Transition transition, @k l<? super Transition, z1> action) {
        f0.p(transition, "<this>");
        f0.p(action, "action");
        e eVar = new e(action);
        transition.addListener(eVar);
        return eVar;
    }

    @k
    @v0(19)
    public static final Transition.TransitionListener g(@k Transition transition, @k l<? super Transition, z1> action) {
        f0.p(transition, "<this>");
        f0.p(action, "action");
        f fVar = new f(action);
        transition.addListener(fVar);
        return fVar;
    }
}
