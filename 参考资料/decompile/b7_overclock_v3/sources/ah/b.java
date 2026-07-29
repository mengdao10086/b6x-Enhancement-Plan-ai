package ah;

import android.view.View;
import com.trello.rxlifecycle3.OutsideLifecycleException;
import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.android.FragmentEvent;
import dj.o;
import g.j;
import g.n0;
import xi.z;
import zg.d;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<ActivityEvent, ActivityEvent> f707a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o<FragmentEvent, FragmentEvent> f708b = new C0012b();

    public static class a implements o<ActivityEvent, ActivityEvent> {
        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityEvent apply(ActivityEvent activityEvent) throws Exception {
            switch (c.f709a[activityEvent.ordinal()]) {
                case 1:
                    return ActivityEvent.DESTROY;
                case 2:
                    return ActivityEvent.STOP;
                case 3:
                    return ActivityEvent.PAUSE;
                case 4:
                    return ActivityEvent.STOP;
                case 5:
                    return ActivityEvent.DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + activityEvent + " not yet implemented");
            }
        }
    }

    /* JADX INFO: renamed from: ah.b$b, reason: collision with other inner class name */
    public static class C0012b implements o<FragmentEvent, FragmentEvent> {
        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentEvent apply(FragmentEvent fragmentEvent) throws Exception {
            switch (c.f710b[fragmentEvent.ordinal()]) {
                case 1:
                    return FragmentEvent.DETACH;
                case 2:
                    return FragmentEvent.DESTROY;
                case 3:
                    return FragmentEvent.DESTROY_VIEW;
                case 4:
                    return FragmentEvent.STOP;
                case 5:
                    return FragmentEvent.PAUSE;
                case 6:
                    return FragmentEvent.STOP;
                case 7:
                    return FragmentEvent.DESTROY_VIEW;
                case 8:
                    return FragmentEvent.DESTROY;
                case 9:
                    return FragmentEvent.DETACH;
                case 10:
                    throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + fragmentEvent + " not yet implemented");
            }
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f710b;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            f710b = iArr;
            try {
                iArr[FragmentEvent.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f710b[FragmentEvent.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f710b[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f710b[FragmentEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f710b[FragmentEvent.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f710b[FragmentEvent.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f710b[FragmentEvent.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f710b[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f710b[FragmentEvent.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f710b[FragmentEvent.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[ActivityEvent.values().length];
            f709a = iArr2;
            try {
                iArr2[ActivityEvent.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f709a[ActivityEvent.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f709a[ActivityEvent.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f709a[ActivityEvent.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f709a[ActivityEvent.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f709a[ActivityEvent.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public b() {
        throw new AssertionError("No instances");
    }

    @j
    @n0
    public static <T> zg.c<T> a(@n0 z<ActivityEvent> zVar) {
        return d.b(zVar, f707a);
    }

    @j
    @n0
    public static <T> zg.c<T> b(@n0 z<FragmentEvent> zVar) {
        return d.b(zVar, f708b);
    }

    @j
    @n0
    public static <T> zg.c<T> c(@n0 View view) {
        dh.a.a(view, "view == null");
        return d.a(z.r1(new ah.c(view)));
    }
}
