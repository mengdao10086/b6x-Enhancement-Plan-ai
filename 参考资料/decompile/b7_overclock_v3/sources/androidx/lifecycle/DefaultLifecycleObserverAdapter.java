package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultLifecycleObserverAdapter implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final j f6069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final v f6070b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6071a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f6071a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(@yt.k j defaultLifecycleObserver, @yt.l v vVar) {
        kotlin.jvm.internal.f0.p(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f6069a = defaultLifecycleObserver;
        this.f6070b = vVar;
    }

    @Override // androidx.lifecycle.v
    public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(event, "event");
        switch (a.f6071a[event.ordinal()]) {
            case 1:
                this.f6069a.b(source);
                break;
            case 2:
                this.f6069a.g(source);
                break;
            case 3:
                this.f6069a.a(source);
                break;
            case 4:
                this.f6069a.d(source);
                break;
            case 5:
                this.f6069a.e(source);
                break;
            case 6:
                this.f6069a.f(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        v vVar = this.f6070b;
        if (vVar != null) {
            vVar.c(source, event);
        }
    }
}
