package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AtomicReference<Object> f6081a = new AtomicReference<>();

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;


        @yt.k
        public static final a Companion = new a(null);

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.Lifecycle$Event$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0052a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f6082a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f6082a = iArr;
                }
            }

            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }

            @hk.m
            @yt.l
            public final Event a(@yt.k State state) {
                kotlin.jvm.internal.f0.p(state, "state");
                int i10 = C0052a.f6082a[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i10 == 2) {
                    return Event.ON_STOP;
                }
                if (i10 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            @hk.m
            @yt.l
            public final Event b(@yt.k State state) {
                kotlin.jvm.internal.f0.p(state, "state");
                int i10 = C0052a.f6082a[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_STOP;
                }
                if (i10 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i10 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            @hk.m
            @yt.l
            public final Event c(@yt.k State state) {
                kotlin.jvm.internal.f0.p(state, "state");
                int i10 = C0052a.f6082a[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_START;
                }
                if (i10 == 2) {
                    return Event.ON_RESUME;
                }
                if (i10 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            @hk.m
            @yt.l
            public final Event d(@yt.k State state) {
                kotlin.jvm.internal.f0.p(state, "state");
                int i10 = C0052a.f6082a[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_CREATE;
                }
                if (i10 == 2) {
                    return Event.ON_START;
                }
                if (i10 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6083a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f6083a = iArr;
            }
        }

        @hk.m
        @yt.l
        public static final Event downFrom(@yt.k State state) {
            return Companion.a(state);
        }

        @hk.m
        @yt.l
        public static final Event downTo(@yt.k State state) {
            return Companion.b(state);
        }

        @hk.m
        @yt.l
        public static final Event upFrom(@yt.k State state) {
            return Companion.c(state);
        }

        @hk.m
        @yt.l
        public static final Event upTo(@yt.k State state) {
            return Companion.d(state);
        }

        @yt.k
        public final State getTargetState() {
            switch (b.f6083a[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(@yt.k State state) {
            kotlin.jvm.internal.f0.p(state, "state");
            return compareTo(state) >= 0;
        }
    }

    @g.k0
    public abstract void a(@yt.k x xVar);

    @g.k0
    @yt.k
    public abstract State b();

    @yt.k
    public final AtomicReference<Object> c() {
        return this.f6081a;
    }

    @g.k0
    public abstract void d(@yt.k x xVar);

    public final void e(@yt.k AtomicReference<Object> atomicReference) {
        kotlin.jvm.internal.f0.p(atomicReference, "<set-?>");
        this.f6081a = atomicReference;
    }
}
