package kotlinx.coroutines.selects;

import ik.q;
import kotlin.jvm.internal.c0;
import kotlin.z1;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
public final class SelectKt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39013b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39014c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39015d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39016e = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final q<Object, Object, Object, Object> f39012a = new q() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // ik.q
        @yt.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void A(@yt.k Object obj, @yt.l Object obj2, @yt.l Object obj3) {
            return null;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final o0 f39017f = new o0("STATE_REG");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final o0 f39018g = new o0("STATE_COMPLETED");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final o0 f39019h = new o0("STATE_CANCELLED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final o0 f39020i = new o0("NO_RESULT");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final o0 f39021j = new o0("PARAM_CLAUSE_0");

    @y1
    public static /* synthetic */ void a() {
    }

    @y1
    public static /* synthetic */ void b() {
    }

    @y1
    public static /* synthetic */ void c() {
    }

    public static final TrySelectDetailedResult d(int i10) {
        if (i10 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i10 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i10 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i10 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    @yt.k
    public static final o0 l() {
        return f39021j;
    }

    @yt.l
    public static final <R> Object m(@yt.k ik.l<? super b<? super R>, z1> lVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        SelectImplementation selectImplementation = new SelectImplementation(cVar.b());
        lVar.i(selectImplementation);
        return selectImplementation.R(cVar);
    }

    public static final <R> Object n(ik.l<? super b<? super R>, z1> lVar, kotlin.coroutines.c<? super R> cVar) {
        c0.e(3);
        throw null;
    }

    public static final boolean o(o<? super z1> oVar, ik.l<? super Throwable, z1> lVar) {
        Object objW = oVar.w(z1.f38230a, null, lVar);
        if (objW == null) {
            return false;
        }
        oVar.l0(objW);
        return true;
    }
}
