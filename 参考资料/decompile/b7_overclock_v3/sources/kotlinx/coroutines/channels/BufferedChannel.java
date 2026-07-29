package kotlinx.coroutines.channels;

import com.bumptech.glide.load.engine.GlideException;
import hk.v;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.internal.m0;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.m3;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n218#5:3142\n219#5:3145\n218#5:3146\n219#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
public class BufferedChannel<E> implements g<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final AtomicLongFieldUpdater f38305d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final AtomicLongFieldUpdater f38306e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicLongFieldUpdater f38307f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final AtomicLongFieldUpdater f38308g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38309h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38310i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38311j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38312k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38313l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    @yt.l
    @v
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.l
    public final ik.l<E, z1> f38315b;

    @v
    private volatile long bufferEnd;

    @yt.l
    @v
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final ik.q<kotlinx.coroutines.selects.j<?>, Object, Object, ik.l<Throwable, z1>> f38316c;

    @yt.l
    @v
    private volatile Object closeHandler;

    @v
    private volatile long completedExpandBuffersAndPauseFlag;

    @yt.l
    @v
    private volatile Object receiveSegment;

    @v
    private volatile long receivers;

    @yt.l
    @v
    private volatile Object sendSegment;

    @v
    private volatile long sendersAndCloseStatus;

    @t0({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    public final class a implements ChannelIterator<E>, m3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public Object f38317a = BufferedChannelKt.f38355x;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public kotlinx.coroutines.p<? super Boolean> f38318b;

        public a() {
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @yt.l
        public Object a(@yt.k kotlin.coroutines.c<? super Boolean> cVar) {
            k<E> kVar;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            k<E> kVar2 = (k) BufferedChannel.f38310i.get(bufferedChannel);
            while (!bufferedChannel.e()) {
                long andIncrement = BufferedChannel.f38306e.getAndIncrement(bufferedChannel);
                int i10 = BufferedChannelKt.f38333b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (kVar2.f38812c != j10) {
                    k<E> kVarC0 = bufferedChannel.c0(j10, kVar2);
                    if (kVarC0 == null) {
                        continue;
                    } else {
                        kVar = kVarC0;
                    }
                } else {
                    kVar = kVar2;
                }
                Object objB1 = bufferedChannel.B1(kVar, i11, andIncrement, null);
                if (objB1 == BufferedChannelKt.f38346o) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (objB1 != BufferedChannelKt.f38348q) {
                    if (objB1 == BufferedChannelKt.f38347p) {
                        return h(kVar, i11, andIncrement, cVar);
                    }
                    kVar.b();
                    this.f38317a = objB1;
                    return zj.a.a(true);
                }
                if (andIncrement < bufferedChannel.p0()) {
                    kVar.b();
                }
                kVar2 = kVar;
            }
            return zj.a.a(i());
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @hk.h(name = "next")
        @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object b(kotlin.coroutines.c cVar) {
            return ChannelIterator.DefaultImpls.a(this, cVar);
        }

        @Override // kotlinx.coroutines.m3
        public void g(@yt.k l0<?> l0Var, int i10) {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f38318b;
            if (pVar != null) {
                pVar.g(l0Var, i10);
            }
        }

        public final Object h(k<E> kVar, int i10, long j10, kotlin.coroutines.c<? super Boolean> cVar) {
            Boolean boolA;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            kotlinx.coroutines.p pVarB = kotlinx.coroutines.r.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
            try {
                this.f38318b = pVarB;
                Object objB1 = bufferedChannel.B1(kVar, i10, j10, this);
                if (objB1 == BufferedChannelKt.f38346o) {
                    bufferedChannel.T0(this, kVar, i10);
                } else {
                    ik.l<Throwable, z1> lVarA = null;
                    if (objB1 == BufferedChannelKt.f38348q) {
                        if (j10 < bufferedChannel.p0()) {
                            kVar.b();
                        }
                        k kVar2 = (k) BufferedChannel.f38310i.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.e()) {
                                j();
                                break;
                            }
                            long andIncrement = BufferedChannel.f38306e.getAndIncrement(bufferedChannel);
                            int i11 = BufferedChannelKt.f38333b;
                            long j11 = andIncrement / ((long) i11);
                            int i12 = (int) (andIncrement % ((long) i11));
                            if (kVar2.f38812c != j11) {
                                k kVarC0 = bufferedChannel.c0(j11, kVar2);
                                if (kVarC0 != null) {
                                    kVar2 = kVarC0;
                                }
                            }
                            Object objB12 = bufferedChannel.B1(kVar2, i12, andIncrement, this);
                            if (objB12 == BufferedChannelKt.f38346o) {
                                bufferedChannel.T0(this, kVar2, i12);
                                break;
                            }
                            if (objB12 == BufferedChannelKt.f38348q) {
                                if (andIncrement < bufferedChannel.p0()) {
                                    kVar2.b();
                                }
                            } else {
                                if (objB12 == BufferedChannelKt.f38347p) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                kVar2.b();
                                this.f38317a = objB12;
                                this.f38318b = null;
                                boolA = zj.a.a(true);
                                ik.l<E, z1> lVar = bufferedChannel.f38315b;
                                if (lVar != null) {
                                    lVarA = OnUndeliveredElementKt.a(lVar, objB12, pVarB.b());
                                }
                            }
                        }
                    } else {
                        kVar.b();
                        this.f38317a = objB1;
                        this.f38318b = null;
                        boolA = zj.a.a(true);
                        ik.l<E, z1> lVar2 = bufferedChannel.f38315b;
                        if (lVar2 != null) {
                            lVarA = OnUndeliveredElementKt.a(lVar2, objB1, pVarB.b());
                        }
                    }
                    pVarB.R(boolA, lVarA);
                }
                Object objC = pVarB.C();
                if (objC == yj.b.h()) {
                    zj.f.c(cVar);
                }
                return objC;
            } catch (Throwable th2) {
                pVarB.U();
                throw th2;
            }
        }

        public final boolean i() throws Throwable {
            this.f38317a = BufferedChannelKt.z();
            Throwable thG0 = BufferedChannel.this.g0();
            if (thG0 == null) {
                return false;
            }
            throw n0.o(thG0);
        }

        public final void j() {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f38318b;
            f0.m(pVar);
            this.f38318b = null;
            this.f38317a = BufferedChannelKt.z();
            Throwable thG0 = BufferedChannel.this.g0();
            if (thG0 == null) {
                Result.a aVar = Result.f37633a;
                pVar.x(Result.b(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.f37633a;
                pVar.x(Result.b(u0.a(thG0)));
            }
        }

        public final boolean k(E e10) {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f38318b;
            f0.m(pVar);
            this.f38318b = null;
            this.f38317a = e10;
            Boolean bool = Boolean.TRUE;
            ik.l<E, z1> lVar = BufferedChannel.this.f38315b;
            return BufferedChannelKt.F(pVar, bool, lVar != null ? OnUndeliveredElementKt.a(lVar, e10, pVar.b()) : null);
        }

        public final void l() {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f38318b;
            f0.m(pVar);
            this.f38318b = null;
            this.f38317a = BufferedChannelKt.z();
            Throwable thG0 = BufferedChannel.this.g0();
            if (thG0 == null) {
                Result.a aVar = Result.f37633a;
                pVar.x(Result.b(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.f37633a;
                pVar.x(Result.b(u0.a(thG0)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() throws Throwable {
            E e10 = (E) this.f38317a;
            if (!(e10 != BufferedChannelKt.f38355x)) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.f38317a = BufferedChannelKt.f38355x;
            if (e10 != BufferedChannelKt.z()) {
                return e10;
            }
            throw n0.o(BufferedChannel.this.m0());
        }
    }

    public static final class b implements m3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final kotlinx.coroutines.o<Boolean> f38320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.p<Boolean> f38321b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@yt.k kotlinx.coroutines.o<? super Boolean> oVar) {
            this.f38320a = oVar;
            f0.n(oVar, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f38321b = (kotlinx.coroutines.p) oVar;
        }

        @yt.k
        public final kotlinx.coroutines.o<Boolean> a() {
            return this.f38320a;
        }

        @Override // kotlinx.coroutines.m3
        public void g(@yt.k l0<?> l0Var, int i10) {
            this.f38321b.g(l0Var, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [ik.l<? super E, kotlin.z1>, ik.l<E, kotlin.z1>] */
    public BufferedChannel(int i10, @yt.l ik.l<? super E, z1> lVar) {
        this.f38314a = i10;
        this.f38315b = lVar;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
        }
        this.bufferEnd = BufferedChannelKt.E(i10);
        this.completedExpandBuffersAndPauseFlag = f0();
        k kVar = new k(0L, null, this, 3);
        this.sendSegment = kVar;
        this.receiveSegment = kVar;
        if (C0()) {
            kVar = BufferedChannelKt.f38332a;
            f0.n(kVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = kVar;
        this.f38316c = lVar != 0 ? new ik.q<kotlinx.coroutines.selects.j<?>, Object, Object, ik.l<? super Throwable, ? extends z1>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
            public final /* synthetic */ BufferedChannel<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.this$0 = this;
            }

            @Override // ik.q
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ik.l<Throwable, z1> A(@yt.k final kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj, @yt.l final Object obj2) {
                final BufferedChannel<E> bufferedChannel = this.this$0;
                return new ik.l<Throwable, z1>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(@yt.k Throwable th2) throws IllegalAccessException, InvocationTargetException {
                        if (obj2 != BufferedChannelKt.z()) {
                            OnUndeliveredElementKt.b(bufferedChannel.f38315b, obj2, jVar.b());
                        }
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) throws IllegalAccessException, InvocationTargetException {
                        b(th2);
                        return z1.f38230a;
                    }
                };
            }
        } : null;
        this._closeCause = BufferedChannelKt.A;
    }

    @s1
    public static /* synthetic */ void B0() {
    }

    private final void E0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static /* synthetic */ <E> Object Z0(BufferedChannel<E> bufferedChannel, kotlin.coroutines.c<? super E> cVar) throws Throwable {
        k<E> kVar = (k) f38310i.get(bufferedChannel);
        while (!bufferedChannel.e()) {
            long andIncrement = f38306e.getAndIncrement(bufferedChannel);
            int i10 = BufferedChannelKt.f38333b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (kVar.f38812c != j10) {
                k<E> kVarC0 = bufferedChannel.c0(j10, kVar);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar = kVarC0;
                }
            }
            Object objB1 = bufferedChannel.B1(kVar, i11, andIncrement, null);
            if (objB1 == BufferedChannelKt.f38346o) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objB1 != BufferedChannelKt.f38348q) {
                if (objB1 == BufferedChannelKt.f38347p) {
                    return bufferedChannel.f1(kVar, i11, andIncrement, cVar);
                }
                kVar.b();
                return objB1;
            }
            if (andIncrement < bufferedChannel.p0()) {
                kVar.b();
            }
        }
        throw n0.o(bufferedChannel.m0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object a1(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.c<? super kotlinx.coroutines.channels.j<? extends E>> r15) throws java.lang.Throwable {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L18:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = yj.b.h()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.u0.n(r15)
            kotlinx.coroutines.channels.j r15 = (kotlinx.coroutines.channels.j) r15
            java.lang.Object r14 = r15.o()
            goto Lb6
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            kotlin.u0.n(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f()
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.k r1 = (kotlinx.coroutines.channels.k) r1
        L47:
            boolean r3 = r14.e()
            if (r3 == 0) goto L59
            kotlinx.coroutines.channels.j$b r15 = kotlinx.coroutines.channels.j.f38377b
            java.lang.Throwable r14 = r14.g0()
            java.lang.Object r14 = r15.a(r14)
            goto Lb6
        L59:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = k()
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.f38812c
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L79
            kotlinx.coroutines.channels.k r7 = a(r14, r7, r1)
            if (r7 != 0) goto L77
            goto L47
        L77:
            r13 = r7
            goto L7a
        L79:
            r13 = r1
        L7a:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = O(r7, r8, r9, r10, r12)
            kotlinx.coroutines.internal.o0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.r()
            if (r1 == r7) goto Lb7
            kotlinx.coroutines.internal.o0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.h()
            if (r1 != r7) goto L9c
            long r7 = r14.p0()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L9a
            r13.b()
        L9a:
            r1 = r13
            goto L47
        L9c:
            kotlinx.coroutines.internal.o0 r15 = kotlinx.coroutines.channels.BufferedChannelKt.s()
            if (r1 != r15) goto Lad
            r6.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.b1(r2, r3, r4, r6)
            if (r14 != r0) goto Lb6
            return r0
        Lad:
            r13.b()
            kotlinx.coroutines.channels.j$b r14 = kotlinx.coroutines.channels.j.f38377b
            java.lang.Object r14 = r14.c(r1)
        Lb6:
            return r14
        Lb7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.a1(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object d1(BufferedChannel bufferedChannel, Object obj, ik.l lVar, ik.q qVar, ik.a aVar, ik.q qVar2, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i10 & 16) != 0) {
            qVar2 = new ik.q() { // from class: kotlinx.coroutines.channels.BufferedChannel$receiveImpl$1
                @Override // ik.q
                public /* bridge */ /* synthetic */ Object A(Object obj3, Object obj4, Object obj5) {
                    return b((k) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                }

                @yt.k
                public final Void b(@yt.k k<E> kVar, int i11, long j10) {
                    throw new IllegalStateException("unexpected".toString());
                }
            };
        }
        k kVar = (k) f38310i.get(bufferedChannel);
        while (!bufferedChannel.e()) {
            long andIncrement = f38306e.getAndIncrement(bufferedChannel);
            int i11 = BufferedChannelKt.f38333b;
            long j10 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (kVar.f38812c != j10) {
                k kVarC0 = bufferedChannel.c0(j10, kVar);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar = kVarC0;
                }
            }
            Object objB1 = bufferedChannel.B1(kVar, i12, andIncrement, obj);
            if (objB1 == BufferedChannelKt.f38346o) {
                m3 m3Var = obj instanceof m3 ? (m3) obj : null;
                if (m3Var != null) {
                    bufferedChannel.T0(m3Var, kVar, i12);
                }
                return qVar.A(kVar, Integer.valueOf(i12), Long.valueOf(andIncrement));
            }
            if (objB1 != BufferedChannelKt.f38348q) {
                if (objB1 == BufferedChannelKt.f38347p) {
                    return qVar2.A(kVar, Integer.valueOf(i12), Long.valueOf(andIncrement));
                }
                kVar.b();
                return lVar.i(objB1);
            }
            if (andIncrement < bufferedChannel.p0()) {
                kVar.b();
            }
        }
        return aVar.o();
    }

    public static /* synthetic */ void h0() {
    }

    public static /* synthetic */ void i0() {
    }

    public static /* synthetic */ void j0() {
    }

    public static /* synthetic */ void k0() {
    }

    public static /* synthetic */ void l0() {
    }

    public static /* synthetic */ <E> Object m1(BufferedChannel<E> bufferedChannel, E e10, kotlin.coroutines.c<? super z1> cVar) throws IllegalAccessException, InvocationTargetException {
        k<E> kVar = (k) f38309h.get(bufferedChannel);
        while (true) {
            long andIncrement = f38305d.getAndIncrement(bufferedChannel);
            long j10 = 1152921504606846975L & andIncrement;
            boolean zZ0 = bufferedChannel.z0(andIncrement);
            int i10 = BufferedChannelKt.f38333b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (kVar.f38812c != j11) {
                k<E> kVarD0 = bufferedChannel.d0(j11, kVar);
                if (kVarD0 != null) {
                    kVar = kVarD0;
                } else if (zZ0) {
                    Object objP0 = bufferedChannel.P0(e10, cVar);
                    if (objP0 == yj.b.h()) {
                        return objP0;
                    }
                }
            }
            int iD1 = bufferedChannel.D1(kVar, i11, e10, j10, null, zZ0);
            if (iD1 == 0) {
                kVar.b();
                break;
            }
            if (iD1 == 1) {
                break;
            }
            if (iD1 != 2) {
                if (iD1 == 3) {
                    Object objS1 = bufferedChannel.s1(kVar, i11, e10, j10, cVar);
                    if (objS1 == yj.b.h()) {
                        return objS1;
                    }
                } else if (iD1 == 4) {
                    if (j10 < bufferedChannel.n0()) {
                        kVar.b();
                    }
                    Object objP02 = bufferedChannel.P0(e10, cVar);
                    if (objP02 == yj.b.h()) {
                        return objP02;
                    }
                } else if (iD1 == 5) {
                    kVar.b();
                }
            } else if (zZ0) {
                kVar.r();
                Object objP03 = bufferedChannel.P0(e10, cVar);
                if (objP03 == yj.b.h()) {
                    return objP03;
                }
            }
        }
        return z1.f38230a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
    
        r0 = kotlin.Result.f37633a;
        r9.x(kotlin.Result.b(zj.a.a(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object o1(kotlinx.coroutines.channels.BufferedChannel<E> r18, E r19, kotlin.coroutines.c<? super java.lang.Boolean> r20) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.o1(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object q1(BufferedChannel bufferedChannel, Object obj, Object obj2, ik.a aVar, ik.p pVar, ik.a aVar2, ik.r rVar, int i10, Object obj3) {
        k kVar;
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        ik.r rVar2 = (i10 & 32) != 0 ? new ik.r() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
            @Override // ik.r
            public /* bridge */ /* synthetic */ Object N(Object obj4, Object obj5, Object obj6, Object obj7) {
                return b((k) obj4, ((Number) obj5).intValue(), obj6, ((Number) obj7).longValue());
            }

            @yt.k
            public final Void b(@yt.k k<E> kVar2, int i11, E e10, long j10) {
                throw new IllegalStateException("unexpected".toString());
            }
        } : rVar;
        k kVar2 = (k) f38309h.get(bufferedChannel);
        while (true) {
            long andIncrement = f38305d.getAndIncrement(bufferedChannel);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zZ0 = bufferedChannel.z0(andIncrement);
            int i11 = BufferedChannelKt.f38333b;
            long j11 = j10 / ((long) i11);
            int i12 = (int) (j10 % ((long) i11));
            if (kVar2.f38812c != j11) {
                k kVarD0 = bufferedChannel.d0(j11, kVar2);
                if (kVarD0 != null) {
                    kVar = kVarD0;
                } else if (zZ0) {
                    return aVar2.o();
                }
            } else {
                kVar = kVar2;
            }
            int iD1 = bufferedChannel.D1(kVar, i12, obj, j10, obj2, zZ0);
            if (iD1 == 0) {
                kVar.b();
                return aVar.o();
            }
            if (iD1 == 1) {
                return aVar.o();
            }
            if (iD1 == 2) {
                if (zZ0) {
                    kVar.r();
                    return aVar2.o();
                }
                m3 m3Var = obj2 instanceof m3 ? (m3) obj2 : null;
                if (m3Var != null) {
                    bufferedChannel.U0(m3Var, kVar, i12);
                }
                return pVar.r0(kVar, Integer.valueOf(i12));
            }
            if (iD1 == 3) {
                return rVar2.N(kVar, Integer.valueOf(i12), obj, Long.valueOf(j10));
            }
            if (iD1 == 4) {
                if (j10 < bufferedChannel.n0()) {
                    kVar.b();
                }
                return aVar2.o();
            }
            if (iD1 == 5) {
                kVar.b();
            }
            kVar2 = kVar;
        }
    }

    public static /* synthetic */ void s0(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bufferedChannel.r0(j10);
    }

    @s1
    public static /* synthetic */ void w0() {
    }

    @s1
    public static /* synthetic */ void y0() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.l
    public Object A(@yt.k kotlin.coroutines.c<? super E> cVar) {
        return Z0(this, cVar);
    }

    public boolean A0() {
        return false;
    }

    public final boolean A1(k<E> kVar, int i10, long j10) {
        while (true) {
            Object objY = kVar.y(i10);
            if (objY instanceof m3) {
                if (j10 < f38306e.get(this)) {
                    if (kVar.t(i10, objY, new t((m3) objY))) {
                        return true;
                    }
                } else if (kVar.t(i10, objY, BufferedChannelKt.f38340i)) {
                    if (x1(objY, kVar, i10)) {
                        kVar.C(i10, BufferedChannelKt.f38337f);
                        return true;
                    }
                    kVar.C(i10, BufferedChannelKt.f38343l);
                    kVar.z(i10, false);
                    return false;
                }
            } else {
                if (objY == BufferedChannelKt.f38343l) {
                    return false;
                }
                if (objY == null) {
                    if (kVar.t(i10, objY, BufferedChannelKt.f38338g)) {
                        return true;
                    }
                } else {
                    if (objY == BufferedChannelKt.f38337f || objY == BufferedChannelKt.f38341j || objY == BufferedChannelKt.f38342k || objY == BufferedChannelKt.f38344m || objY == BufferedChannelKt.z()) {
                        return true;
                    }
                    if (objY != BufferedChannelKt.f38339h) {
                        throw new IllegalStateException(("Unexpected cell state: " + objY).toString());
                    }
                }
            }
        }
    }

    public final Object B1(k<E> kVar, int i10, long j10, Object obj) {
        Object objY = kVar.y(i10);
        if (objY == null) {
            if (j10 >= (f38305d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.f38347p;
                }
                if (kVar.t(i10, objY, obj)) {
                    a0();
                    return BufferedChannelKt.f38346o;
                }
            }
        } else if (objY == BufferedChannelKt.f38337f && kVar.t(i10, objY, BufferedChannelKt.f38342k)) {
            a0();
            return kVar.A(i10);
        }
        return C1(kVar, i10, j10, obj);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean C(@yt.l Throwable th2) {
        return V(th2, false);
    }

    public final boolean C0() {
        long jF0 = f0();
        return jF0 == 0 || jF0 == Long.MAX_VALUE;
    }

    public final Object C1(k<E> kVar, int i10, long j10, Object obj) {
        while (true) {
            Object objY = kVar.y(i10);
            if (objY == null || objY == BufferedChannelKt.f38338g) {
                if (j10 < (f38305d.get(this) & 1152921504606846975L)) {
                    if (kVar.t(i10, objY, BufferedChannelKt.f38341j)) {
                        a0();
                        return BufferedChannelKt.f38348q;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.f38347p;
                    }
                    if (kVar.t(i10, objY, obj)) {
                        a0();
                        return BufferedChannelKt.f38346o;
                    }
                }
            } else {
                if (objY != BufferedChannelKt.f38337f) {
                    if (objY != BufferedChannelKt.f38343l && objY != BufferedChannelKt.f38341j) {
                        if (objY == BufferedChannelKt.z()) {
                            a0();
                            return BufferedChannelKt.f38348q;
                        }
                        if (objY != BufferedChannelKt.f38340i && kVar.t(i10, objY, BufferedChannelKt.f38339h)) {
                            boolean z10 = objY instanceof t;
                            if (z10) {
                                objY = ((t) objY).f38389a;
                            }
                            if (x1(objY, kVar, i10)) {
                                kVar.C(i10, BufferedChannelKt.f38342k);
                                a0();
                                return kVar.A(i10);
                            }
                            kVar.C(i10, BufferedChannelKt.f38343l);
                            kVar.z(i10, false);
                            if (z10) {
                                a0();
                            }
                            return BufferedChannelKt.f38348q;
                        }
                    }
                    return BufferedChannelKt.f38348q;
                }
                if (kVar.t(i10, objY, BufferedChannelKt.f38342k)) {
                    a0();
                    return kVar.A(i10);
                }
            }
        }
    }

    public final void D0(AtomicLongFieldUpdater atomicLongFieldUpdater, ik.l<? super Long, z1> lVar, Object obj) {
        while (true) {
            lVar.i(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final int D1(k<E> kVar, int i10, E e10, long j10, Object obj, boolean z10) {
        kVar.D(i10, e10);
        if (z10) {
            return E1(kVar, i10, e10, j10, obj, z10);
        }
        Object objY = kVar.y(i10);
        if (objY == null) {
            if (Q(j10)) {
                if (kVar.t(i10, null, BufferedChannelKt.f38337f)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (kVar.t(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (objY instanceof m3) {
            kVar.u(i10);
            if (w1(objY, e10)) {
                kVar.C(i10, BufferedChannelKt.f38342k);
                R0();
                return 0;
            }
            if (kVar.v(i10, BufferedChannelKt.f38344m) != BufferedChannelKt.f38344m) {
                kVar.z(i10, true);
            }
            return 5;
        }
        return E1(kVar, i10, e10, j10, obj, z10);
    }

    public final int E1(k<E> kVar, int i10, E e10, long j10, Object obj, boolean z10) {
        while (true) {
            Object objY = kVar.y(i10);
            if (objY == null) {
                if (!Q(j10) || z10) {
                    if (z10) {
                        if (kVar.t(i10, null, BufferedChannelKt.f38343l)) {
                            kVar.z(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (kVar.t(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (kVar.t(i10, null, BufferedChannelKt.f38337f)) {
                    return 1;
                }
            } else {
                if (objY != BufferedChannelKt.f38338g) {
                    if (objY == BufferedChannelKt.f38344m) {
                        kVar.u(i10);
                        return 5;
                    }
                    if (objY == BufferedChannelKt.f38341j) {
                        kVar.u(i10);
                        return 5;
                    }
                    if (objY == BufferedChannelKt.z()) {
                        kVar.u(i10);
                        Y();
                        return 4;
                    }
                    kVar.u(i10);
                    if (objY instanceof t) {
                        objY = ((t) objY).f38389a;
                    }
                    if (w1(objY, e10)) {
                        kVar.C(i10, BufferedChannelKt.f38342k);
                        R0();
                        return 0;
                    }
                    if (kVar.v(i10, BufferedChannelKt.f38344m) != BufferedChannelKt.f38344m) {
                        kVar.z(i10, true);
                    }
                    return 5;
                }
                if (kVar.t(i10, objY, BufferedChannelKt.f38337f)) {
                    return 1;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        return kotlinx.coroutines.channels.j.f38377b.c(kotlin.z1.f38230a);
     */
    @Override // kotlinx.coroutines.channels.s
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object F(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.f38305d
            long r0 = r0.get(r14)
            boolean r0 = r14.t1(r0)
            if (r0 == 0) goto L13
            kotlinx.coroutines.channels.j$b r15 = kotlinx.coroutines.channels.j.f38377b
            java.lang.Object r15 = r15.b()
            return r15
        L13:
            kotlinx.coroutines.internal.o0 r8 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.k r0 = (kotlinx.coroutines.channels.k) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = m()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = n(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f38812c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L4e
            kotlinx.coroutines.channels.k r1 = b(r14, r2, r0)
            if (r1 != 0) goto L4c
            if (r11 == 0) goto L21
            goto L8e
        L4c:
            r13 = r1
            goto L4f
        L4e:
            r13 = r0
        L4f:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = P(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb0
            r1 = 1
            if (r0 == r1) goto Lb3
            r1 = 2
            if (r0 == r1) goto L89
            r1 = 3
            if (r0 == r1) goto L7d
            r1 = 4
            if (r0 == r1) goto L71
            r1 = 5
            if (r0 == r1) goto L6c
            goto L6f
        L6c:
            r13.b()
        L6f:
            r0 = r13
            goto L21
        L71:
            long r0 = r14.n0()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L8e
            r13.b()
            goto L8e
        L7d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L89:
            if (r11 == 0) goto L99
            r13.r()
        L8e:
            kotlinx.coroutines.channels.j$b r15 = kotlinx.coroutines.channels.j.f38377b
            java.lang.Throwable r0 = r14.o0()
            java.lang.Object r15 = r15.a(r0)
            goto Lbb
        L99:
            boolean r15 = r8 instanceof kotlinx.coroutines.m3
            if (r15 == 0) goto La0
            kotlinx.coroutines.m3 r8 = (kotlinx.coroutines.m3) r8
            goto La1
        La0:
            r8 = 0
        La1:
            if (r8 == 0) goto La6
            z(r14, r8, r13, r12)
        La6:
            r13.r()
            kotlinx.coroutines.channels.j$b r15 = kotlinx.coroutines.channels.j.f38377b
            java.lang.Object r15 = r15.b()
            goto Lbb
        Lb0:
            r13.b()
        Lb3:
            kotlinx.coroutines.channels.j$b r15 = kotlinx.coroutines.channels.j.f38377b
            kotlin.z1 r0 = kotlin.z1.f38230a
            java.lang.Object r15 = r15.c(r0)
        Lbb:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.F(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        r9 = (kotlinx.coroutines.channels.k) r9.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long F0(kotlinx.coroutines.channels.k<E> r9) {
        /*
            r8 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3d
            long r3 = r9.f38812c
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r8.n0()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L1b
            return r1
        L1b:
            java.lang.Object r1 = r9.y(r0)
            if (r1 == 0) goto L2d
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L28
            goto L2d
        L28:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.f38337f
            if (r1 != r2) goto L3a
            return r3
        L2d:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r9.t(r0, r1, r2)
            if (r1 == 0) goto L1b
            r9.r()
        L3a:
            int r0 = r0 + (-1)
            goto L4
        L3d:
            kotlinx.coroutines.internal.f r9 = r9.g()
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            if (r9 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.F0(kotlinx.coroutines.channels.k):long");
    }

    public final void F1(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38306e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
        } while (!f38306e.compareAndSet(this, j11, j10));
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return m1(this, e10, cVar);
    }

    public final void G0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38305d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, BufferedChannelKt.w(1152921504606846975L & j10, 1)));
    }

    public final void G1(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38305d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = 1152921504606846975L & j11;
            if (j12 >= j10) {
                return;
            }
        } while (!f38305d.compareAndSet(this, j11, BufferedChannelKt.w(j12, (int) (j11 >> 60))));
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean H() {
        return z0(f38305d.get(this));
    }

    public final void H0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38305d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, BufferedChannelKt.w(1152921504606846975L & j10, 3)));
    }

    public final void H1(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        if (C0()) {
            return;
        }
        while (f0() <= j10) {
        }
        int i10 = BufferedChannelKt.f38334c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jF0 = f0();
            if (jF0 == (f38308g.get(this) & 4611686018427387903L) && jF0 == f0()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f38308g;
        do {
            j11 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, BufferedChannelKt.v(j11 & 4611686018427387903L, true)));
        while (true) {
            long jF02 = f0();
            atomicLongFieldUpdater = f38308g;
            long j13 = atomicLongFieldUpdater.get(this);
            long j14 = j13 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j13) != 0;
            if (jF02 == j14 && jF02 == f0()) {
                break;
            } else if (!z10) {
                atomicLongFieldUpdater.compareAndSet(this, j13, BufferedChannelKt.v(j14, true));
            }
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, BufferedChannelKt.v(j12 & 4611686018427387903L, false)));
    }

    public final void I0() {
        long j10;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38305d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = BufferedChannelKt.w(j10 & 1152921504606846975L, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = BufferedChannelKt.w(j10 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jW));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0(long j10, k<E> kVar) {
        boolean z10;
        k<E> kVar2;
        k<E> kVar3;
        while (kVar.f38812c < j10 && (kVar3 = (k) kVar.e()) != null) {
            kVar = kVar3;
        }
        while (true) {
            if (!kVar.h() || (kVar2 = (k) kVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38311j;
                while (true) {
                    l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (l0Var.f38812c >= kVar.f38812c) {
                        break;
                    }
                    if (!kVar.s()) {
                        z10 = false;
                        break;
                    } else if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, kVar)) {
                        if (l0Var.o()) {
                            l0Var.l();
                        }
                    } else if (kVar.o()) {
                        kVar.l();
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                kVar = kVar2;
            }
        }
    }

    public void K0() {
    }

    public final void L0(kotlinx.coroutines.o<? super j<? extends E>> oVar) {
        Result.a aVar = Result.f37633a;
        oVar.x(Result.b(j.b(j.f38377b.a(g0()))));
    }

    public final void M0(kotlinx.coroutines.o<? super E> oVar) {
        Result.a aVar = Result.f37633a;
        oVar.x(Result.b(u0.a(m0())));
    }

    public final void N0(kotlinx.coroutines.selects.j<?> jVar) {
        jVar.r(BufferedChannelKt.z());
    }

    public final void O0(E e10, kotlinx.coroutines.selects.j<?> jVar) throws IllegalAccessException, InvocationTargetException {
        ik.l<E, z1> lVar = this.f38315b;
        if (lVar != null) {
            OnUndeliveredElementKt.b(lVar, e10, jVar.b());
        }
        jVar.r(BufferedChannelKt.z());
    }

    public final Object P0(E e10, kotlin.coroutines.c<? super z1> cVar) throws IllegalAccessException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionD;
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        ik.l<E, z1> lVar = this.f38315b;
        if (lVar == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) == null) {
            Throwable thO0 = o0();
            Result.a aVar = Result.f37633a;
            pVar.x(Result.b(u0.a(thO0)));
        } else {
            kotlin.o.a(undeliveredElementExceptionD, o0());
            Result.a aVar2 = Result.f37633a;
            pVar.x(Result.b(u0.a(undeliveredElementExceptionD)));
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    public final boolean Q(long j10) {
        return j10 < f0() || j10 < n0() + ((long) this.f38314a);
    }

    public final void Q0(E e10, kotlinx.coroutines.o<? super z1> oVar) throws IllegalAccessException, InvocationTargetException {
        ik.l<E, z1> lVar = this.f38315b;
        if (lVar != null) {
            OnUndeliveredElementKt.b(lVar, e10, oVar.b());
        }
        Throwable thO0 = o0();
        Result.a aVar = Result.f37633a;
        oVar.x(Result.b(u0.a(thO0)));
    }

    public boolean R(@yt.l Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return V(th2, true);
    }

    public void R0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(k<E> kVar, long j10) {
        Object objC = kotlinx.coroutines.internal.o.c(null, 1, null);
        loop0: while (kVar != null) {
            for (int i10 = BufferedChannelKt.f38333b - 1; -1 < i10; i10--) {
                if ((kVar.f38812c * ((long) BufferedChannelKt.f38333b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object objY = kVar.y(i10);
                    if (objY != null && objY != BufferedChannelKt.f38338g) {
                        if (!(objY instanceof t)) {
                            if (!(objY instanceof m3)) {
                                break;
                            }
                            if (kVar.t(i10, objY, BufferedChannelKt.z())) {
                                objC = kotlinx.coroutines.internal.o.h(objC, objY);
                                kVar.z(i10, true);
                                break;
                            }
                        } else {
                            if (kVar.t(i10, objY, BufferedChannelKt.z())) {
                                objC = kotlinx.coroutines.internal.o.h(objC, ((t) objY).f38389a);
                                kVar.z(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (kVar.t(i10, objY, BufferedChannelKt.z())) {
                            kVar.r();
                            break;
                        }
                    }
                }
            }
            kVar = (k) kVar.g();
        }
        if (objC != null) {
            if (!(objC instanceof ArrayList)) {
                j1((m3) objC);
                return;
            }
            f0.n(objC, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objC;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                j1((m3) arrayList.get(size));
            }
        }
    }

    public void S0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.T():void");
    }

    public final void T0(m3 m3Var, k<E> kVar, int i10) {
        S0();
        m3Var.g(kVar, i10);
    }

    public final k<E> U() {
        Object obj = f38311j.get(this);
        k kVar = (k) f38309h.get(this);
        if (kVar.f38812c > ((k) obj).f38812c) {
            obj = kVar;
        }
        k kVar2 = (k) f38310i.get(this);
        if (kVar2.f38812c > ((k) obj).f38812c) {
            obj = kVar2;
        }
        return (k) kotlinx.coroutines.internal.e.d((kotlinx.coroutines.internal.f) obj);
    }

    public final void U0(m3 m3Var, k<E> kVar, int i10) {
        m3Var.g(kVar, i10 + BufferedChannelKt.f38333b);
    }

    public boolean V(@yt.l Throwable th2, boolean z10) {
        if (z10) {
            G0();
        }
        boolean zA = al.o.a(f38312k, this, BufferedChannelKt.A, th2);
        if (z10) {
            H0();
        } else {
            I0();
        }
        Y();
        K0();
        if (zA) {
            t0();
        }
        return zA;
    }

    public final Object V0(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        throw m0();
    }

    public final void W(long j10) throws IllegalAccessException, InvocationTargetException {
        i1(X(j10));
    }

    public final Object W0(Object obj, Object obj2) {
        return j.b(obj2 == BufferedChannelKt.z() ? j.f38377b.a(g0()) : j.f38377b.c(obj2));
    }

    public final k<E> X(long j10) {
        k<E> kVarU = U();
        if (A0()) {
            long jF0 = F0(kVarU);
            if (jF0 != -1) {
                Z(jF0);
            }
        }
        S(kVarU, j10);
        return kVarU;
    }

    public final Object X0(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        if (g0() == null) {
            return null;
        }
        throw m0();
    }

    public final void Y() {
        H();
    }

    public final Object Y0(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return this;
        }
        throw o0();
    }

    public final void Z(long j10) {
        UndeliveredElementException undeliveredElementExceptionD;
        k<E> kVar = (k) f38310i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f38306e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(((long) this.f38314a) + j11, f0())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = BufferedChannelKt.f38333b;
                long j12 = j11 / ((long) i10);
                int i11 = (int) (j11 % ((long) i10));
                if (kVar.f38812c != j12) {
                    k<E> kVarC0 = c0(j12, kVar);
                    if (kVarC0 == null) {
                        continue;
                    } else {
                        kVar = kVarC0;
                    }
                }
                Object objB1 = B1(kVar, i11, j11, null);
                if (objB1 != BufferedChannelKt.f38348q) {
                    kVar.b();
                    ik.l<E, z1> lVar = this.f38315b;
                    if (lVar != null && (undeliveredElementExceptionD = OnUndeliveredElementKt.d(lVar, objB1, null, 2, null)) != null) {
                        throw undeliveredElementExceptionD;
                    }
                } else if (j11 < p0()) {
                    kVar.b();
                }
            }
        }
    }

    public final void a0() {
        if (C0()) {
            return;
        }
        k<E> kVar = (k) f38311j.get(this);
        while (true) {
            long andIncrement = f38307f.getAndIncrement(this);
            int i10 = BufferedChannelKt.f38333b;
            long j10 = andIncrement / ((long) i10);
            if (p0() <= andIncrement) {
                if (kVar.f38812c < j10 && kVar.e() != 0) {
                    J0(j10, kVar);
                }
                s0(this, 0L, 1, null);
                return;
            }
            if (kVar.f38812c != j10) {
                k<E> kVarB0 = b0(j10, kVar, andIncrement);
                if (kVarB0 == null) {
                    continue;
                } else {
                    kVar = kVarB0;
                }
            }
            if (z1(kVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                s0(this, 0L, 1, null);
                return;
            }
            s0(this, 0L, 1, null);
        }
    }

    public final k<E> b0(long j10, k<E> kVar, long j11) {
        Object objG;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38311j;
        ik.p pVar = (ik.p) BufferedChannelKt.y();
        do {
            objG = kotlinx.coroutines.internal.e.g(kVar, j10, pVar);
            if (m0.h(objG)) {
                break;
            }
            l0 l0VarF = m0.f(objG);
            while (true) {
                l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                if (l0Var.f38812c >= l0VarF.f38812c) {
                    break;
                }
                if (!l0VarF.s()) {
                    z10 = false;
                    break;
                }
                if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, l0VarF)) {
                    if (l0Var.o()) {
                        l0Var.l();
                    }
                } else if (l0VarF.o()) {
                    l0VarF.l();
                }
            }
            z10 = true;
        } while (!z10);
        if (m0.h(objG)) {
            Y();
            J0(j10, kVar);
            s0(this, 0L, 1, null);
            return null;
        }
        k<E> kVar2 = (k) m0.f(objG);
        long j12 = kVar2.f38812c;
        if (j12 <= j10) {
            return kVar2;
        }
        int i10 = BufferedChannelKt.f38333b;
        if (f38307f.compareAndSet(this, j11 + 1, ((long) i10) * j12)) {
            r0((kVar2.f38812c * ((long) i10)) - j11);
            return null;
        }
        s0(this, 0L, 1, null);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(kotlinx.coroutines.channels.k<E> r11, int r12, long r13, kotlin.coroutines.c<? super kotlinx.coroutines.channels.j<? extends E>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.b1(kotlinx.coroutines.channels.k, int, long, kotlin.coroutines.c):java.lang.Object");
    }

    public final k<E> c0(long j10, k<E> kVar) {
        Object objG;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38310i;
        ik.p pVar = (ik.p) BufferedChannelKt.y();
        do {
            objG = kotlinx.coroutines.internal.e.g(kVar, j10, pVar);
            if (!m0.h(objG)) {
                l0 l0VarF = m0.f(objG);
                while (true) {
                    l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (l0Var.f38812c >= l0VarF.f38812c) {
                        break;
                    }
                    if (!l0VarF.s()) {
                        z10 = false;
                        break;
                    }
                    if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, l0VarF)) {
                        if (l0Var.o()) {
                            l0Var.l();
                        }
                    } else if (l0VarF.o()) {
                        l0VarF.l();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        if (m0.h(objG)) {
            Y();
            if (kVar.f38812c * ((long) BufferedChannelKt.f38333b) >= p0()) {
                return null;
            }
            kVar.b();
            return null;
        }
        k<E> kVar2 = (k) m0.f(objG);
        if (!C0() && j10 <= f0() / ((long) BufferedChannelKt.f38333b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f38311j;
            while (true) {
                l0 l0Var2 = (l0) atomicReferenceFieldUpdater2.get(this);
                if (l0Var2.f38812c >= kVar2.f38812c || !kVar2.s()) {
                    break;
                }
                if (al.o.a(atomicReferenceFieldUpdater2, this, l0Var2, kVar2)) {
                    if (l0Var2.o()) {
                        l0Var2.l();
                    }
                } else if (kVar2.o()) {
                    kVar2.l();
                }
            }
        }
        long j11 = kVar2.f38812c;
        if (j11 <= j10) {
            return kVar2;
        }
        int i10 = BufferedChannelKt.f38333b;
        F1(j11 * ((long) i10));
        if (kVar2.f38812c * ((long) i10) >= p0()) {
            return null;
        }
        kVar2.b();
        return null;
    }

    public final <R> R c1(Object obj, ik.l<? super E, ? extends R> lVar, ik.q<? super k<E>, ? super Integer, ? super Long, ? extends R> qVar, ik.a<? extends R> aVar, ik.q<? super k<E>, ? super Integer, ? super Long, ? extends R> qVar2) {
        k kVar = (k) f38310i.get(this);
        while (!e()) {
            long andIncrement = f38306e.getAndIncrement(this);
            int i10 = BufferedChannelKt.f38333b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (kVar.f38812c != j10) {
                k kVarC0 = c0(j10, kVar);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar = kVarC0;
                }
            }
            o0 o0Var = (Object) B1(kVar, i11, andIncrement, obj);
            if (o0Var == BufferedChannelKt.f38346o) {
                m3 m3Var = obj instanceof m3 ? (m3) obj : null;
                if (m3Var != null) {
                    T0(m3Var, kVar, i11);
                }
                return qVar.A(kVar, Integer.valueOf(i11), Long.valueOf(andIncrement));
            }
            if (o0Var != BufferedChannelKt.f38348q) {
                if (o0Var == BufferedChannelKt.f38347p) {
                    return qVar2.A(kVar, Integer.valueOf(i11), Long.valueOf(andIncrement));
                }
                kVar.b();
                return lVar.i(o0Var);
            }
            if (andIncrement < p0()) {
                kVar.b();
            }
        }
        return aVar.o();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        R(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean d(@yt.l Throwable th2) {
        return R(th2);
    }

    public final k<E> d0(long j10, k<E> kVar) {
        Object objG;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38309h;
        ik.p pVar = (ik.p) BufferedChannelKt.y();
        do {
            objG = kotlinx.coroutines.internal.e.g(kVar, j10, pVar);
            if (!m0.h(objG)) {
                l0 l0VarF = m0.f(objG);
                while (true) {
                    l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (l0Var.f38812c >= l0VarF.f38812c) {
                        break;
                    }
                    if (!l0VarF.s()) {
                        z10 = false;
                        break;
                    }
                    if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, l0VarF)) {
                        if (l0Var.o()) {
                            l0Var.l();
                        }
                    } else if (l0VarF.o()) {
                        l0VarF.l();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        if (m0.h(objG)) {
            Y();
            if (kVar.f38812c * ((long) BufferedChannelKt.f38333b) >= n0()) {
                return null;
            }
            kVar.b();
            return null;
        }
        k<E> kVar2 = (k) m0.f(objG);
        long j11 = kVar2.f38812c;
        if (j11 <= j10) {
            return kVar2;
        }
        int i10 = BufferedChannelKt.f38333b;
        G1(j11 * ((long) i10));
        if (kVar2.f38812c * ((long) i10) >= n0()) {
            return null;
        }
        kVar2.b();
        return null;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean e() {
        return x0(f38305d.get(this));
    }

    public final Object e0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!al.o.a(atomicReferenceFieldUpdater, obj, obj2, lVar.i(obj2)));
        return obj2;
    }

    public final void e1(k<E> kVar, int i10, long j10, m3 m3Var, ik.l<? super E, z1> lVar, ik.a<z1> aVar) {
        o0 o0Var = (Object) B1(kVar, i10, j10, m3Var);
        if (o0Var == BufferedChannelKt.f38346o) {
            T0(m3Var, kVar, i10);
            return;
        }
        if (o0Var != BufferedChannelKt.f38348q) {
            kVar.b();
            lVar.i(o0Var);
            return;
        }
        if (j10 < p0()) {
            kVar.b();
        }
        k kVar2 = (k) f38310i.get(this);
        while (!e()) {
            long andIncrement = f38306e.getAndIncrement(this);
            int i11 = BufferedChannelKt.f38333b;
            long j11 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (kVar2.f38812c != j11) {
                k kVarC0 = c0(j11, kVar2);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar2 = kVarC0;
                }
            }
            o0 o0Var2 = (Object) B1(kVar2, i12, andIncrement, m3Var);
            if (o0Var2 == BufferedChannelKt.f38346o) {
                if (!(m3Var instanceof m3)) {
                    m3Var = null;
                }
                if (m3Var != null) {
                    T0(m3Var, kVar2, i12);
                }
                z1 z1Var = z1.f38230a;
                return;
            }
            if (o0Var2 != BufferedChannelKt.f38348q) {
                if (o0Var2 == BufferedChannelKt.f38347p) {
                    throw new IllegalStateException("unexpected".toString());
                }
                kVar2.b();
                lVar.i(o0Var2);
                return;
            }
            if (andIncrement < p0()) {
                kVar2.b();
            }
        }
        aVar.o();
    }

    public final long f0() {
        return f38307f.get(this);
    }

    public final Object f1(k<E> kVar, int i10, long j10, kotlin.coroutines.c<? super E> cVar) {
        kotlinx.coroutines.p pVarB = kotlinx.coroutines.r.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            Object objB1 = B1(kVar, i10, j10, pVarB);
            if (objB1 == BufferedChannelKt.f38346o) {
                T0(pVarB, kVar, i10);
            } else {
                ik.l<Throwable, z1> lVarA = null;
                lVarA = null;
                if (objB1 == BufferedChannelKt.f38348q) {
                    if (j10 < p0()) {
                        kVar.b();
                    }
                    k kVar2 = (k) f38310i.get(this);
                    while (true) {
                        if (e()) {
                            M0(pVarB);
                            break;
                        }
                        long andIncrement = f38306e.getAndIncrement(this);
                        int i11 = BufferedChannelKt.f38333b;
                        long j11 = andIncrement / ((long) i11);
                        int i12 = (int) (andIncrement % ((long) i11));
                        if (kVar2.f38812c != j11) {
                            k kVarC0 = c0(j11, kVar2);
                            if (kVarC0 != null) {
                                kVar2 = kVarC0;
                            }
                        }
                        objB1 = B1(kVar2, i12, andIncrement, pVarB);
                        if (objB1 == BufferedChannelKt.f38346o) {
                            kotlinx.coroutines.p pVar = pVarB instanceof m3 ? pVarB : null;
                            if (pVar != null) {
                                T0(pVar, kVar2, i12);
                            }
                        } else if (objB1 == BufferedChannelKt.f38348q) {
                            if (andIncrement < p0()) {
                                kVar2.b();
                            }
                        } else {
                            if (objB1 == BufferedChannelKt.f38347p) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            kVar2.b();
                            ik.l<E, z1> lVar = this.f38315b;
                            if (lVar != null) {
                                lVarA = OnUndeliveredElementKt.a(lVar, objB1, pVarB.b());
                            }
                        }
                    }
                } else {
                    kVar.b();
                    ik.l<E, z1> lVar2 = this.f38315b;
                    if (lVar2 != null) {
                        lVarA = OnUndeliveredElementKt.a(lVar2, objB1, pVarB.b());
                    }
                }
                pVarB.R(objB1, lVarA);
            }
            Object objC = pVarB.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objC;
        } catch (Throwable th2) {
            pVarB.U();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.channels.s
    public void g(@yt.k ik.l<? super Throwable, z1> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38313l;
        if (al.o.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != BufferedChannelKt.f38356y) {
                if (obj == BufferedChannelKt.f38357z) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!al.o.a(f38313l, this, BufferedChannelKt.f38356y, BufferedChannelKt.f38357z));
        lVar.i(g0());
    }

    @yt.l
    public final Throwable g0() {
        return (Throwable) f38312k.get(this);
    }

    public final void g1(kotlinx.coroutines.selects.j<?> jVar, Object obj) {
        k kVar = (k) f38310i.get(this);
        while (!e()) {
            long andIncrement = f38306e.getAndIncrement(this);
            int i10 = BufferedChannelKt.f38333b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (kVar.f38812c != j10) {
                k kVarC0 = c0(j10, kVar);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar = kVarC0;
                }
            }
            Object objB1 = B1(kVar, i11, andIncrement, jVar);
            if (objB1 == BufferedChannelKt.f38346o) {
                m3 m3Var = jVar instanceof m3 ? (m3) jVar : null;
                if (m3Var != null) {
                    T0(m3Var, kVar, i11);
                    return;
                }
                return;
            }
            if (objB1 != BufferedChannelKt.f38348q) {
                if (objB1 == BufferedChannelKt.f38347p) {
                    throw new IllegalStateException("unexpected".toString());
                }
                kVar.b();
                jVar.r(objB1);
                return;
            }
            if (andIncrement < p0()) {
                kVar.b();
            }
        }
        N0(jVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void h(@yt.l CancellationException cancellationException) {
        R(cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        r14.r(kotlin.z1.f38230a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h1(@yt.k kotlinx.coroutines.selects.j<?> r14, @yt.l java.lang.Object r15) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l()
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.k r0 = (kotlinx.coroutines.channels.k) r0
        La:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = m()
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = n(r13, r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            long r5 = (long) r2
            long r5 = r3 / r5
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.f38812c
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 == 0) goto L35
            kotlinx.coroutines.channels.k r5 = b(r13, r5, r0)
            if (r5 != 0) goto L34
            if (r1 == 0) goto La
            goto L73
        L34:
            r0 = r5
        L35:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = P(r5, r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L85
            r6 = 1
            if (r5 == r6) goto L88
            r6 = 2
            if (r5 == r6) goto L6e
            r1 = 3
            if (r5 == r1) goto L62
            r1 = 4
            if (r5 == r1) goto L56
            r1 = 5
            if (r5 == r1) goto L52
            goto La
        L52:
            r0.b()
            goto La
        L56:
            long r1 = r13.n0()
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L73
            r0.b()
            goto L73
        L62:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L6e:
            if (r1 == 0) goto L77
            r0.r()
        L73:
            r13.O0(r15, r14)
            goto L8d
        L77:
            boolean r15 = r14 instanceof kotlinx.coroutines.m3
            if (r15 == 0) goto L7e
            kotlinx.coroutines.m3 r14 = (kotlinx.coroutines.m3) r14
            goto L7f
        L7e:
            r14 = 0
        L7f:
            if (r14 == 0) goto L8d
            z(r13, r14, r0, r2)
            goto L8d
        L85:
            r0.b()
        L88:
            kotlin.z1 r15 = kotlin.z1.f38230a
            r14.r(r15)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.h1(kotlinx.coroutines.selects.j, java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
    
        r13 = (kotlinx.coroutines.channels.k) r13.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i1(kotlinx.coroutines.channels.k<E> r13) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.i1(kotlinx.coroutines.channels.k):void");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (e() || q0()) {
            return false;
        }
        return !e();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public ChannelIterator<E> iterator() {
        return new a();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<E> j() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.f38322c;
        f0.n(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        ik.q qVar = (ik.q) w0.q(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.f38323c;
        f0.n(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, qVar, (ik.q) w0.q(bufferedChannel$onReceive$2, 3), this.f38316c);
    }

    public final void j1(m3 m3Var) {
        l1(m3Var, true);
    }

    public final void k1(m3 m3Var) {
        l1(m3Var, false);
    }

    public final void l1(m3 m3Var, boolean z10) {
        if (m3Var instanceof b) {
            kotlinx.coroutines.o<Boolean> oVarA = ((b) m3Var).a();
            Result.a aVar = Result.f37633a;
            oVarA.x(Result.b(Boolean.FALSE));
            return;
        }
        if (m3Var instanceof kotlinx.coroutines.o) {
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) m3Var;
            Result.a aVar2 = Result.f37633a;
            cVar.x(Result.b(u0.a(z10 ? m0() : o0())));
        } else if (m3Var instanceof r) {
            kotlinx.coroutines.p<j<? extends E>> pVar = ((r) m3Var).f38388a;
            Result.a aVar3 = Result.f37633a;
            pVar.x(Result.b(j.b(j.f38377b.a(g0()))));
        } else if (m3Var instanceof a) {
            ((a) m3Var).l();
        } else {
            if (m3Var instanceof kotlinx.coroutines.selects.j) {
                ((kotlinx.coroutines.selects.j) m3Var).n(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + m3Var).toString());
        }
    }

    public final Throwable m0() {
        Throwable thG0 = g0();
        return thG0 == null ? new ClosedReceiveChannelException(l.f38383a) : thG0;
    }

    public final long n0() {
        return f38306e.get(this);
    }

    @yt.l
    public Object n1(E e10, @yt.k kotlin.coroutines.c<? super Boolean> cVar) {
        return o1(this, e10, cVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<j<E>> o() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.f38324c;
        f0.n(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        ik.q qVar = (ik.q) w0.q(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.f38325c;
        f0.n(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, qVar, (ik.q) w0.q(bufferedChannel$onReceiveCatching$2, 3), this.f38316c);
    }

    @yt.k
    public final Throwable o0() {
        Throwable thG0 = g0();
        return thG0 == null ? new ClosedSendChannelException(l.f38383a) : thG0;
    }

    @Override // kotlinx.coroutines.channels.s
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.t0(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return g.a.c(this, e10);
    }

    public final long p0() {
        return f38305d.get(this) & 1152921504606846975L;
    }

    public final <R> R p1(E e10, @yt.l Object obj, @yt.k ik.a<? extends R> aVar, @yt.k ik.p<? super k<E>, ? super Integer, ? extends R> pVar, @yt.k ik.a<? extends R> aVar2, @yt.k ik.r<? super k<E>, ? super Integer, ? super E, ? super Long, ? extends R> rVar) {
        k kVar;
        k kVar2 = (k) f38309h.get(this);
        while (true) {
            long andIncrement = f38305d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zZ0 = z0(andIncrement);
            int i10 = BufferedChannelKt.f38333b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (kVar2.f38812c != j11) {
                k kVarD0 = d0(j11, kVar2);
                if (kVarD0 != null) {
                    kVar = kVarD0;
                } else if (zZ0) {
                    return aVar2.o();
                }
            } else {
                kVar = kVar2;
            }
            int iD1 = D1(kVar, i11, e10, j10, obj, zZ0);
            if (iD1 == 0) {
                kVar.b();
                return aVar.o();
            }
            if (iD1 == 1) {
                return aVar.o();
            }
            if (iD1 == 2) {
                if (zZ0) {
                    kVar.r();
                    return aVar2.o();
                }
                m3 m3Var = obj instanceof m3 ? (m3) obj : null;
                if (m3Var != null) {
                    U0(m3Var, kVar, i11);
                }
                return pVar.r0(kVar, Integer.valueOf(i11));
            }
            if (iD1 == 3) {
                return rVar.N(kVar, Integer.valueOf(i11), e10, Long.valueOf(j10));
            }
            if (iD1 == 4) {
                if (j10 < n0()) {
                    kVar.b();
                }
                return aVar2.o();
            }
            if (iD1 == 5) {
                kVar.b();
            }
            kVar2 = kVar;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.t0(expression = "tryReceive().getOrNull()", imports = {}))
    @yt.l
    public E poll() {
        return (E) g.a.d(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<E> q() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.f38326c;
        f0.n(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        ik.q qVar = (ik.q) w0.q(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.f38327c;
        f0.n(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, qVar, (ik.q) w0.q(bufferedChannel$onReceiveOrNull$2, 3), this.f38316c);
    }

    public final boolean q0() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38310i;
            k<E> kVarC0 = (k) atomicReferenceFieldUpdater.get(this);
            long jN0 = n0();
            if (p0() <= jN0) {
                return false;
            }
            int i10 = BufferedChannelKt.f38333b;
            long j10 = jN0 / ((long) i10);
            if (kVarC0.f38812c == j10 || (kVarC0 = c0(j10, kVarC0)) != null) {
                kVarC0.b();
                if (u0(kVarC0, (int) (jN0 % ((long) i10)), jN0)) {
                    return true;
                }
                f38306e.compareAndSet(this, jN0, jN0 + 1);
            } else if (((k) atomicReferenceFieldUpdater.get(this)).f38812c < j10) {
                return false;
            }
        }
    }

    public final void r0(long j10) {
        if ((f38308g.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
            } while ((f38308g.get(this) & 4611686018427387904L) != 0);
        }
    }

    public final void r1(k<E> kVar, int i10, E e10, long j10, m3 m3Var, ik.a<z1> aVar, ik.a<z1> aVar2) {
        k kVar2;
        m3 m3Var2 = m3Var;
        int iD1 = D1(kVar, i10, e10, j10, m3Var, false);
        if (iD1 == 0) {
            kVar.b();
            aVar.o();
            return;
        }
        if (iD1 == 1) {
            aVar.o();
            return;
        }
        if (iD1 == 2) {
            U0(m3Var2, kVar, i10);
            return;
        }
        if (iD1 == 4) {
            if (j10 < n0()) {
                kVar.b();
            }
            aVar2.o();
            return;
        }
        if (iD1 != 5) {
            throw new IllegalStateException("unexpected".toString());
        }
        kVar.b();
        k kVar3 = (k) f38309h.get(this);
        while (true) {
            long andIncrement = f38305d.getAndIncrement(this);
            long j11 = andIncrement & 1152921504606846975L;
            boolean zZ0 = z0(andIncrement);
            int i11 = BufferedChannelKt.f38333b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (kVar3.f38812c != j12) {
                k kVarD0 = d0(j12, kVar3);
                if (kVarD0 != null) {
                    kVar2 = kVarD0;
                } else if (zZ0) {
                    aVar2.o();
                    return;
                }
            } else {
                kVar2 = kVar3;
            }
            k kVar4 = kVar2;
            int iD12 = D1(kVar2, i12, e10, j11, m3Var, zZ0);
            if (iD12 == 0) {
                kVar4.b();
                aVar.o();
                return;
            }
            if (iD12 == 1) {
                aVar.o();
                return;
            }
            if (iD12 == 2) {
                if (zZ0) {
                    kVar4.r();
                    aVar2.o();
                    return;
                }
                if (!(m3Var2 instanceof m3)) {
                    m3Var2 = null;
                }
                if (m3Var2 != null) {
                    U0(m3Var2, kVar4, i12);
                }
                z1 z1Var = z1.f38230a;
                return;
            }
            if (iD12 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iD12 == 4) {
                if (j11 < n0()) {
                    kVar4.b();
                }
                aVar2.o();
                return;
            } else {
                if (iD12 == 5) {
                    kVar4.b();
                }
                kVar3 = kVar4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public Object s() {
        k kVar;
        long j10 = f38306e.get(this);
        long j11 = f38305d.get(this);
        if (x0(j11)) {
            return j.f38377b.a(g0());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return j.f38377b.b();
        }
        Object obj = BufferedChannelKt.f38344m;
        k kVar2 = (k) f38310i.get(this);
        while (!e()) {
            long andIncrement = f38306e.getAndIncrement(this);
            int i10 = BufferedChannelKt.f38333b;
            long j12 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (kVar2.f38812c != j12) {
                k kVarC0 = c0(j12, kVar2);
                if (kVarC0 == null) {
                    continue;
                } else {
                    kVar = kVarC0;
                }
            } else {
                kVar = kVar2;
            }
            Object objB1 = B1(kVar, i11, andIncrement, obj);
            if (objB1 == BufferedChannelKt.f38346o) {
                m3 m3Var = obj instanceof m3 ? (m3) obj : null;
                if (m3Var != null) {
                    T0(m3Var, kVar, i11);
                }
                H1(andIncrement);
                kVar.r();
                return j.f38377b.b();
            }
            if (objB1 != BufferedChannelKt.f38348q) {
                if (objB1 == BufferedChannelKt.f38347p) {
                    throw new IllegalStateException("unexpected".toString());
                }
                kVar.b();
                return j.f38377b.c(objB1);
            }
            if (andIncrement < p0()) {
                kVar.b();
            }
            kVar2 = kVar;
        }
        return j.f38377b.a(g0());
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s1(kotlinx.coroutines.channels.k<E> r21, int r22, E r23, long r24, kotlin.coroutines.c<? super kotlin.z1> r26) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.s1(kotlinx.coroutines.channels.k, int, java.lang.Object, long, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.t0(expression = "receiveCatching().getOrNull()", imports = {}))
    @yt.l
    @bk.h
    public Object t(@yt.k kotlin.coroutines.c<? super E> cVar) {
        return g.a.e(this, cVar);
    }

    public final void t0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38313l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!al.o.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.f38356y : BufferedChannelKt.f38357z));
        if (obj == null) {
            return;
        }
        ((ik.l) obj).i(g0());
    }

    public final boolean t1(long j10) {
        if (z0(j10)) {
            return false;
        }
        return !Q(j10 & 1152921504606846975L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e0, code lost:
    
        r3 = (kotlinx.coroutines.channels.k) r3.e();
     */
    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final boolean u0(k<E> kVar, int i10, long j10) {
        Object objY;
        do {
            objY = kVar.y(i10);
            if (objY != null && objY != BufferedChannelKt.f38338g) {
                if (objY == BufferedChannelKt.f38337f) {
                    return true;
                }
                if (objY == BufferedChannelKt.f38343l || objY == BufferedChannelKt.z() || objY == BufferedChannelKt.f38342k || objY == BufferedChannelKt.f38341j) {
                    return false;
                }
                if (objY == BufferedChannelKt.f38340i) {
                    return true;
                }
                return objY != BufferedChannelKt.f38339h && j10 == n0();
            }
        } while (!kVar.t(i10, objY, BufferedChannelKt.f38341j));
        a0();
        return false;
    }

    public boolean u1() {
        return t1(f38305d.get(this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.l
    public Object v(@yt.k kotlin.coroutines.c<? super j<? extends E>> cVar) {
        return a1(this, cVar);
    }

    public final boolean v0(long j10, boolean z10) throws IllegalAccessException, InvocationTargetException {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            X(j10 & 1152921504606846975L);
            if (z10 && q0()) {
                return false;
            }
        } else {
            if (i10 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i10).toString());
            }
            W(j10 & 1152921504606846975L);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public final String v1() {
        String strValueOf;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("S=");
        sb3.append(p0());
        sb3.append(",R=");
        sb3.append(n0());
        sb3.append(",B=");
        sb3.append(f0());
        sb3.append(",B'=");
        sb3.append(f38308g.get(this));
        sb3.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38305d;
        sb3.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb3.append(',');
        sb2.append(sb3.toString());
        int i10 = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i10 == 1) {
            sb2.append("CANCELLATION_STARTED,");
        } else if (i10 == 2) {
            sb2.append("CLOSED,");
        } else if (i10 == 3) {
            sb2.append("CANCELLED,");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38309h;
        sb4.append(r0.b(atomicReferenceFieldUpdater.get(this)));
        sb4.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f38310i;
        sb4.append(r0.b(atomicReferenceFieldUpdater2.get(this)));
        sb2.append(sb4.toString());
        if (!C0()) {
            sb2.append(",EB_SEGM=" + r0.b(f38311j.get(this)));
        }
        sb2.append(GlideException.a.f12263d);
        List listL = CollectionsKt__CollectionsKt.L(atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), f38311j.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listL) {
            if (((k) obj) != BufferedChannelKt.f38332a) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it2.next();
        if (it2.hasNext()) {
            long j10 = ((k) next).f38812c;
            do {
                Object next2 = it2.next();
                long j11 = ((k) next2).f38812c;
                if (j10 > j11) {
                    next = next2;
                    j10 = j11;
                }
            } while (it2.hasNext());
        }
        k kVar = (k) next;
        do {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(r0.b(kVar));
            sb5.append("=[");
            sb5.append(kVar.h() ? "*" : "");
            sb5.append(kVar.f38812c);
            sb5.append(",prev=");
            k kVar2 = (k) kVar.g();
            sb5.append(kVar2 != null ? r0.b(kVar2) : null);
            sb5.append(',');
            sb2.append(sb5.toString());
            int i11 = BufferedChannelKt.f38333b;
            for (int i12 = 0; i12 < i11; i12++) {
                Object objY = kVar.y(i12);
                Object objX = kVar.x(i12);
                if (objY instanceof kotlinx.coroutines.o) {
                    strValueOf = "cont";
                } else if (objY instanceof kotlinx.coroutines.selects.j) {
                    strValueOf = "select";
                } else if (objY instanceof r) {
                    strValueOf = "receiveCatching";
                } else if (objY instanceof b) {
                    strValueOf = "send(broadcast)";
                } else if (objY instanceof t) {
                    strValueOf = "EB(" + objY + ')';
                } else {
                    strValueOf = String.valueOf(objY);
                }
                sb2.append('[' + i12 + "]=(" + strValueOf + ',' + objX + "),");
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("next=");
            k kVar3 = (k) kVar.e();
            sb6.append(kVar3 != null ? r0.b(kVar3) : null);
            sb6.append("]  ");
            sb2.append(sb6.toString());
            kVar = (k) kVar.e();
        } while (kVar != null);
        return sb2.toString();
    }

    public final boolean w1(Object obj, E e10) {
        if (obj instanceof kotlinx.coroutines.selects.j) {
            return ((kotlinx.coroutines.selects.j) obj).n(this, e10);
        }
        if (obj instanceof r) {
            f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            r rVar = (r) obj;
            kotlinx.coroutines.p<j<? extends E>> pVar = rVar.f38388a;
            j jVarB = j.b(j.f38377b.c(e10));
            ik.l<E, z1> lVar = this.f38315b;
            return BufferedChannelKt.F(pVar, jVarB, lVar != null ? OnUndeliveredElementKt.a(lVar, e10, rVar.f38388a.b()) : null);
        }
        if (obj instanceof a) {
            f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).k(e10);
        }
        if (obj instanceof kotlinx.coroutines.o) {
            f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.o oVar = (kotlinx.coroutines.o) obj;
            ik.l<E, z1> lVar2 = this.f38315b;
            return BufferedChannelKt.F(oVar, e10, lVar2 != null ? OnUndeliveredElementKt.a(lVar2, e10, oVar.b()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean x0(long j10) {
        return v0(j10, true);
    }

    public final boolean x1(Object obj, k<E> kVar, int i10) {
        if (obj instanceof kotlinx.coroutines.o) {
            f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.G((kotlinx.coroutines.o) obj, z1.f38230a, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.j) {
            f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultH0 = ((SelectImplementation) obj).h0(this, z1.f38230a);
            if (trySelectDetailedResultH0 == TrySelectDetailedResult.REREGISTER) {
                kVar.u(i10);
            }
            return trySelectDetailedResultH0 == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof b) {
            return BufferedChannelKt.G(((b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.k
    public kotlinx.coroutines.selects.g<E, BufferedChannel<E>> y() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.f38328c;
        f0.n(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        ik.q qVar = (ik.q) w0.q(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.f38329c;
        f0.n(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, qVar, (ik.q) w0.q(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    public final void y1(AtomicLongFieldUpdater atomicLongFieldUpdater, ik.l<? super Long, Long> lVar, Object obj) {
        long j10;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lVar.i(Long.valueOf(j10)).longValue()));
    }

    public final boolean z0(long j10) {
        return v0(j10, false);
    }

    public final boolean z1(k<E> kVar, int i10, long j10) {
        Object objY = kVar.y(i10);
        if (!(objY instanceof m3) || j10 < f38306e.get(this) || !kVar.t(i10, objY, BufferedChannelKt.f38340i)) {
            return A1(kVar, i10, j10);
        }
        if (x1(objY, kVar, i10)) {
            kVar.C(i10, BufferedChannelKt.f38337f);
            return true;
        }
        kVar.C(i10, BufferedChannelKt.f38343l);
        kVar.z(i10, false);
        return false;
    }

    public /* synthetic */ BufferedChannel(int i10, ik.l lVar, int i11, u uVar) {
        this(i10, (i11 & 2) != 0 ? null : lVar);
    }
}
