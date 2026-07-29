package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.collections.h0;
import kotlin.coroutines.CoroutineContext;
import kotlin.m0;
import kotlin.s0;
import kotlin.t0;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.t1;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38672a = "kotlinx.coroutines.flow.defaultConcurrency";

    @yt.l
    public static final <T> Object A(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__CollectKt.f(eVar, pVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @t0(expression = "flatMapConcat(mapper)", imports = {}))
    @yt.k
    public static final <T, R> e<R> A0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.l(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> A1(@yt.k e<? extends T> eVar, @yt.k ik.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return FlowKt__TransformKt.j(eVar, qVar);
    }

    @yt.l
    public static final <T> Object B(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__LimitKt.b(eVar, pVar, cVar);
    }

    @s1
    @yt.k
    public static final <T, R> e<R> B0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(eVar, pVar);
    }

    @yt.k
    @t1
    public static final <T> e<T> B1(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__DelayKt.h(eVar, j10);
    }

    @s1
    @yt.k
    public static final <T, R> e<R> C0(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.b(eVar, pVar);
    }

    @yt.k
    @t1
    public static final <T> e<T> C1(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__DelayKt.i(eVar, j10);
    }

    @yt.k
    public static final <T1, T2, R> e<R> D(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.c(eVar, eVar2, qVar);
    }

    @s1
    @yt.k
    public static final <T, R> e<R> D0(@yt.k e<? extends T> eVar, int i10, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.c(eVar, i10, pVar);
    }

    @yt.k
    public static final <T, R> e<R> D1(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__TransformKt.k(eVar, r10, qVar);
    }

    @yt.k
    public static final <T1, T2, T3, R> e<R> E(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @kotlin.b @yt.k ik.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.d(eVar, eVar2, eVar3, rVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @t0(expression = "scan(initial, operation)", imports = {}))
    @yt.k
    public static final <T, R> e<R> E1(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.B(eVar, r10, qVar);
    }

    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> F(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k ik.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        return FlowKt__ZipKt.e(eVar, eVar2, eVar3, eVar4, sVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @t0(expression = "flattenConcat()", imports = {}))
    @yt.k
    public static final <T> e<T> F0(@yt.k e<? extends e<? extends T>> eVar) {
        return FlowKt__MigrationKt.m(eVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @t0(expression = "runningReduce(operation)", imports = {}))
    @yt.k
    public static final <T> e<T> F1(@yt.k e<? extends T> eVar, @yt.k ik.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.C(eVar, qVar);
    }

    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> G(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @yt.k ik.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        return FlowKt__ZipKt.f(eVar, eVar2, eVar3, eVar4, eVar5, tVar);
    }

    @s1
    @yt.k
    public static final <T> e<T> G0(@yt.k e<? extends e<? extends T>> eVar) {
        return FlowKt__MergeKt.e(eVar);
    }

    @yt.k
    public static final <T> n<T> G1(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k r rVar, int i10) {
        return FlowKt__ShareKt.g(eVar, o0Var, rVar, i10);
    }

    @s1
    @yt.k
    public static final <T> e<T> H0(@yt.k e<? extends e<? extends T>> eVar, int i10) {
        return FlowKt__MergeKt.f(eVar, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @t0(expression = "this.combine(other, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, R> e<R> I(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.b(eVar, eVar2, qVar);
    }

    @yt.l
    public static final <T> Object I1(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.j(eVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @t0(expression = "combine(this, other, other2, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, R> e<R> J(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k ik.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        return FlowKt__MigrationKt.c(eVar, eVar2, eVar3, rVar);
    }

    @yt.k
    public static final <T> e<T> J0(@kotlin.b @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.n(pVar);
    }

    @yt.l
    public static final <T> Object J1(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.k(eVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @t0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> K(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k ik.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        return FlowKt__MigrationKt.d(eVar, eVar2, eVar3, eVar4, sVar);
    }

    @hk.h(name = "flowCombine")
    @yt.k
    public static final <T1, T2, R> e<R> K0(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.p(eVar, eVar2, qVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @t0(expression = "drop(count)", imports = {}))
    @yt.k
    public static final <T> e<T> K1(@yt.k e<? extends T> eVar, int i10) {
        return FlowKt__MigrationKt.D(eVar, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @t0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> L(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @yt.k ik.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        return FlowKt__MigrationKt.e(eVar, eVar2, eVar3, eVar4, eVar5, tVar);
    }

    @hk.h(name = "flowCombineTransform")
    @yt.k
    public static final <T1, T2, R> e<R> L0(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @kotlin.b @yt.k ik.r<? super f<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super z1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.q(eVar, eVar2, rVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @t0(expression = "onStart { emit(value) }", imports = {}))
    @yt.k
    public static final <T> e<T> L1(@yt.k e<? extends T> eVar, T t10) {
        return FlowKt__MigrationKt.E(eVar, t10);
    }

    @yt.k
    public static final <T> e<T> M0(T t10) {
        return FlowKt__BuildersKt.o(t10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @t0(expression = "onStart { emitAll(other) }", imports = {}))
    @yt.k
    public static final <T> e<T> M1(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        return FlowKt__MigrationKt.F(eVar, eVar2);
    }

    @yt.k
    public static final <T1, T2, R> e<R> N(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @kotlin.b @yt.k ik.r<? super f<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.c<? super z1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.i(eVar, eVar2, rVar);
    }

    @yt.k
    public static final <T> e<T> N0(@yt.k T... tArr) {
        return FlowKt__BuildersKt.p(tArr);
    }

    @yt.l
    public static final <T> Object N1(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k kotlin.coroutines.c<? super u<? extends T>> cVar) {
        return FlowKt__ShareKt.i(eVar, o0Var, cVar);
    }

    @yt.k
    public static final <T1, T2, T3, R> e<R> O(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @kotlin.b @yt.k ik.s<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super z1>, ? extends Object> sVar) {
        return FlowKt__ZipKt.j(eVar, eVar2, eVar3, sVar);
    }

    @yt.k
    public static final <T> e<T> O0(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        return h.h(eVar, coroutineContext);
    }

    @yt.k
    public static final <T> u<T> O1(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k r rVar, T t10) {
        return FlowKt__ShareKt.j(eVar, o0Var, rVar, t10);
    }

    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> P(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @kotlin.b @yt.k ik.t<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super z1>, ? extends Object> tVar) {
        return FlowKt__ZipKt.k(eVar, eVar2, eVar3, eVar4, tVar);
    }

    @yt.l
    public static final <T, R> Object P0(@yt.k e<? extends T> eVar, R r10, @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        return FlowKt__ReduceKt.e(eVar, r10, qVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void P1(@yt.k e<? extends T> eVar) {
        FlowKt__MigrationKt.G(eVar);
    }

    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> Q(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @kotlin.b @yt.k ik.u<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super z1>, ? extends Object> uVar) {
        return FlowKt__ZipKt.l(eVar, eVar2, eVar3, eVar4, eVar5, uVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @t0(expression = "collect(action)", imports = {}))
    public static final <T> void Q0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.n(eVar, pVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Q1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.H(eVar, pVar);
    }

    public static final int R0() {
        return FlowKt__MergeKt.h();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void R1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k ik.p<? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar2) {
        FlowKt__MigrationKt.I(eVar, pVar, pVar2);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @t0(expression = "let(transformer)", imports = {}))
    @yt.k
    public static final <T, R> e<R> S(@yt.k e<? extends T> eVar, @yt.k ik.l<? super e<? extends T>, ? extends e<? extends R>> lVar) {
        return FlowKt__MigrationKt.f(eVar, lVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @yt.k
    public static final <T> e<T> S1(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.J(eVar, coroutineContext);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @t0(expression = "flatMapConcat(mapper)", imports = {}))
    @yt.k
    public static final <T, R> e<R> T(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, ? extends e<? extends R>> lVar) {
        return FlowKt__MigrationKt.g(eVar, lVar);
    }

    @yt.l
    public static final <T> Object T0(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.g(eVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @t0(expression = "this.flatMapLatest(transform)", imports = {}))
    @yt.k
    public static final <T, R> e<R> T1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.K(eVar, pVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @t0(expression = "onCompletion { emit(value) }", imports = {}))
    @yt.k
    public static final <T> e<T> U(@yt.k e<? extends T> eVar, T t10) {
        return FlowKt__MigrationKt.h(eVar, t10);
    }

    @yt.l
    public static final <T> Object U0(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.h(eVar, cVar);
    }

    @yt.k
    public static final <T> e<T> U1(@yt.k e<? extends T> eVar, int i10) {
        return FlowKt__LimitKt.g(eVar, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @t0(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @yt.k
    public static final <T> e<T> V(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        return FlowKt__MigrationKt.i(eVar, eVar2);
    }

    @yt.k
    public static final <T> c2 V0(@yt.k e<? extends T> eVar, @yt.k o0 o0Var) {
        return FlowKt__CollectKt.h(eVar, o0Var);
    }

    @yt.k
    public static final <T> e<T> V1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.h(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> W(@yt.k e<? extends T> eVar) {
        return h.g(eVar);
    }

    @yt.k
    public static final <T, R> e<R> W0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.f(eVar, pVar);
    }

    @yt.k
    @t1
    public static final <T> e<T> W1(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__DelayKt.j(eVar, j10);
    }

    @yt.k
    public static final <T> e<T> X(@yt.k ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.c(receiveChannel);
    }

    @s1
    @yt.k
    public static final <T, R> e<R> X0(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.k(eVar, pVar);
    }

    @yt.l
    public static final <T, C extends Collection<? super T>> Object X1(@yt.k e<? extends T> eVar, @yt.k C c10, @yt.k kotlin.coroutines.c<? super C> cVar) {
        return FlowKt__CollectionKt.a(eVar, c10, cVar);
    }

    @yt.l
    public static final <T> Object Y(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.a(eVar, pVar, cVar);
    }

    @yt.k
    public static final <T, R> e<R> Y0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.g(eVar, pVar);
    }

    @yt.l
    public static final <T> Object Y1(@yt.k e<? extends T> eVar, @yt.k List<T> list, @yt.k kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return FlowKt__CollectionKt.b(eVar, list, cVar);
    }

    @yt.l
    public static final <T> Object Z(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super Integer> cVar) {
        return FlowKt__CountKt.b(eVar, cVar);
    }

    @yt.k
    public static final <T> e<T> Z0(@yt.k Iterable<? extends e<? extends T>> iterable) {
        return FlowKt__MergeKt.l(iterable);
    }

    @yt.k
    public static final <T> e<T> a(@yt.k ik.a<? extends T> aVar) {
        return FlowKt__BuildersKt.a(aVar);
    }

    @yt.k
    @t1
    public static final <T> e<T> a0(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__DelayKt.a(eVar, j10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @t0(expression = "flattenConcat()", imports = {}))
    @yt.k
    public static final <T> e<T> a1(@yt.k e<? extends e<? extends T>> eVar) {
        return FlowKt__MigrationKt.o(eVar);
    }

    @yt.l
    public static final <T> Object a2(@yt.k e<? extends T> eVar, @yt.k Set<T> set, @yt.k kotlin.coroutines.c<? super Set<? extends T>> cVar) {
        return FlowKt__CollectionKt.d(eVar, set, cVar);
    }

    @yt.k
    public static final <T> e<T> b(@yt.k ik.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar) {
        return FlowKt__BuildersKt.b(lVar);
    }

    @m0
    @yt.k
    @t1
    public static final <T> e<T> b0(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, Long> lVar) {
        return FlowKt__DelayKt.b(eVar, lVar);
    }

    @yt.k
    public static final <T> e<T> b1(@yt.k e<? extends T>... eVarArr) {
        return FlowKt__MergeKt.m(eVarArr);
    }

    @yt.k
    public static final <T> e<T> c(@yt.k Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.c(iterable);
    }

    @yt.k
    @t1
    public static final <T> e<T> c0(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__DelayKt.c(eVar, j10);
    }

    @yt.k
    public static final Void c1() {
        return FlowKt__MigrationKt.p();
    }

    @yt.k
    public static final <T, R> e<R> c2(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.g(eVar, qVar);
    }

    @yt.k
    public static final <T> e<T> d(@yt.k Iterator<? extends T> it2) {
        return FlowKt__BuildersKt.d(it2);
    }

    @hk.h(name = "debounceDuration")
    @m0
    @t1
    @yt.k
    public static final <T> e<T> d0(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, uk.e> lVar) {
        return FlowKt__DelayKt.d(eVar, lVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @yt.k
    public static final <T> e<T> d1(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.q(eVar, coroutineContext);
    }

    @s1
    @yt.k
    public static final <T, R> e<R> d2(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return FlowKt__MergeKt.n(eVar, qVar);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k kotlin.sequences.m<? extends T> mVar) {
        return FlowKt__BuildersKt.e(mVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @t0(expression = "onEach { delay(timeMillis) }", imports = {}))
    @yt.k
    public static final <T> e<T> e0(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__MigrationKt.j(eVar, j10);
    }

    @yt.k
    public static final <T> e<T> e1(@yt.k e<? extends T> eVar, @yt.k ik.q<? super f<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.d(eVar, qVar);
    }

    @yt.k
    public static final <T, R> e<R> e2(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar) {
        return FlowKt__LimitKt.i(eVar, qVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @yt.k
    public static final <T> e<T> f(@yt.k kotlinx.coroutines.channels.d<T> dVar) {
        return FlowKt__ChannelsKt.b(dVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @t0(expression = "onStart { delay(timeMillis) }", imports = {}))
    @yt.k
    public static final <T> e<T> f0(@yt.k e<? extends T> eVar, long j10) {
        return FlowKt__MigrationKt.k(eVar, j10);
    }

    @yt.k
    public static final <T> e<T> f1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__TransformKt.h(eVar, pVar);
    }

    @s0
    @yt.k
    public static final <T, R> e<R> f2(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.h(eVar, qVar);
    }

    @yt.k
    public static final e<Integer> g(@yt.k qk.m mVar) {
        return FlowKt__BuildersKt.f(mVar);
    }

    @yt.k
    public static final <T> e<T> g0(@yt.k e<? extends T> eVar) {
        return FlowKt__DistinctKt.a(eVar);
    }

    @yt.k
    public static final <T> e<T> g1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.e(eVar, pVar);
    }

    @yt.k
    public static final <T> e<h0<T>> g2(@yt.k e<? extends T> eVar) {
        return FlowKt__TransformKt.l(eVar);
    }

    @yt.k
    public static final e<Long> h(@yt.k qk.p pVar) {
        return FlowKt__BuildersKt.g(pVar);
    }

    @yt.k
    public static final <T> e<T> h0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super T, Boolean> pVar) {
        return FlowKt__DistinctKt.b(eVar, pVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @t0(expression = "catch { emitAll(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> h1(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        return FlowKt__MigrationKt.r(eVar, eVar2);
    }

    @yt.k
    public static final <T1, T2, R> e<R> h2(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.s(eVar, eVar2, qVar);
    }

    @yt.k
    public static final e<Integer> i(@yt.k int[] iArr) {
        return FlowKt__BuildersKt.h(iArr);
    }

    @yt.k
    public static final <T, K> e<T> i0(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, ? extends K> lVar) {
        return FlowKt__DistinctKt.c(eVar, lVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @t0(expression = "catch { emitAll(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> i1(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        return FlowKt__MigrationKt.s(eVar, eVar2);
    }

    @yt.k
    public static final e<Long> j(@yt.k long[] jArr) {
        return FlowKt__BuildersKt.i(jArr);
    }

    @yt.k
    public static final <T> e<T> j0(@yt.k e<? extends T> eVar, int i10) {
        return FlowKt__LimitKt.d(eVar, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @t0(expression = "catch { emit(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> j1(@yt.k e<? extends T> eVar, T t10) {
        return FlowKt__MigrationKt.t(eVar, t10);
    }

    @yt.k
    public static final <T> e<T> k(@yt.k T[] tArr) {
        return FlowKt__BuildersKt.j(tArr);
    }

    @yt.k
    public static final <T> e<T> k0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.e(eVar, pVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @t0(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @yt.k
    public static final <T> e<T> k1(@yt.k e<? extends T> eVar, T t10, @yt.k ik.l<? super Throwable, Boolean> lVar) {
        return FlowKt__MigrationKt.u(eVar, t10, lVar);
    }

    @yt.k
    public static final <T> n<T> l(@yt.k i<T> iVar) {
        return FlowKt__ShareKt.a(iVar);
    }

    @yt.l
    public static final <T> Object l0(@yt.k f<? super T> fVar, @yt.k ReceiveChannel<? extends T> receiveChannel, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__ChannelsKt.d(fVar, receiveChannel, cVar);
    }

    @yt.k
    public static final <T> u<T> m(@yt.k j<T> jVar) {
        return FlowKt__ShareKt.b(jVar);
    }

    @yt.l
    public static final <T> Object m0(@yt.k f<? super T> fVar, @yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__CollectKt.g(fVar, eVar, cVar);
    }

    @yt.k
    public static final <T> e<T> m1(@yt.k e<? extends T> eVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.f(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> n0() {
        return FlowKt__BuildersKt.m();
    }

    @yt.k
    public static final <T> n<T> n1(@yt.k n<? extends T> nVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__ShareKt.f(nVar, pVar);
    }

    @yt.k
    public static final <T> e<T> o(@yt.k e<? extends T> eVar, int i10, @yt.k BufferOverflow bufferOverflow) {
        return h.b(eVar, i10, bufferOverflow);
    }

    public static final void o0(@yt.k f<?> fVar) {
        FlowKt__EmittersKt.b(fVar);
    }

    @yt.k
    public static final <T> ReceiveChannel<T> o1(@yt.k e<? extends T> eVar, @yt.k o0 o0Var) {
        return FlowKt__ChannelsKt.f(eVar, o0Var);
    }

    @yt.k
    public static final <T> e<T> p0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.a(eVar, pVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @t0(expression = "this.shareIn(scope, 0)", imports = {}))
    @yt.k
    public static final <T> e<T> p1(@yt.k e<? extends T> eVar) {
        return FlowKt__MigrationKt.w(eVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @t0(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @yt.k
    public static final <T> e<T> q1(@yt.k e<? extends T> eVar, int i10) {
        return FlowKt__MigrationKt.x(eVar, i10);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @t0(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @yt.k
    public static final <T> e<T> r(@yt.k e<? extends T> eVar) {
        return FlowKt__MigrationKt.a(eVar);
    }

    @yt.k
    public static final <R> e<R> r0(@yt.k e<?> eVar, @yt.k kotlin.reflect.d<R> dVar) {
        return FlowKt__TransformKt.c(eVar, dVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @yt.k
    public static final <T> e<T> r1(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.y(eVar, coroutineContext);
    }

    @yt.k
    public static final <T> e<T> s(@kotlin.b @yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.k(pVar);
    }

    @yt.k
    public static final <T> e<T> s0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.d(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> s1(@yt.k ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.g(receiveChannel);
    }

    @yt.k
    public static final <T> e<T> t(@yt.k e<? extends T> eVar) {
        return h.e(eVar);
    }

    @yt.k
    public static final <T> e<T> t0(@yt.k e<? extends T> eVar) {
        return FlowKt__TransformKt.e(eVar);
    }

    @yt.l
    public static final <S, T extends S> Object t1(@yt.k e<? extends T> eVar, @yt.k ik.q<? super S, ? super T, ? super kotlin.coroutines.c<? super S>, ? extends Object> qVar, @yt.k kotlin.coroutines.c<? super S> cVar) {
        return FlowKt__ReduceKt.i(eVar, qVar, cVar);
    }

    @yt.k
    public static final <T> e<T> u(@yt.k e<? extends T> eVar, @yt.k ik.q<? super f<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.a(eVar, qVar);
    }

    @yt.l
    public static final <T> Object u0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.a(eVar, pVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @t0(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @yt.k
    public static final <T> e<T> u1(@yt.k e<? extends T> eVar) {
        return FlowKt__MigrationKt.z(eVar);
    }

    @yt.l
    public static final <T> Object v(@yt.k e<? extends T> eVar, @yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.b(eVar, fVar, cVar);
    }

    @yt.l
    public static final <T> Object v0(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.b(eVar, cVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @t0(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @yt.k
    public static final <T> e<T> v1(@yt.k e<? extends T> eVar, int i10) {
        return FlowKt__MigrationKt.A(eVar, i10);
    }

    @yt.k
    public static final <T> e<T> w(@kotlin.b @yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.l(pVar);
    }

    @yt.l
    public static final <T> Object w0(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.c(eVar, pVar, cVar);
    }

    @yt.k
    public static final <T> e<T> w1(@yt.k e<? extends T> eVar, long j10, @yt.k ik.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__ErrorsKt.e(eVar, j10, pVar);
    }

    @yt.l
    public static final <T> Object x0(@yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return FlowKt__ReduceKt.d(eVar, cVar);
    }

    @yt.l
    public static final Object y(@yt.k e<?> eVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__CollectKt.b(eVar, cVar);
    }

    @yt.k
    public static final ReceiveChannel<z1> y0(@yt.k o0 o0Var, long j10, long j11) {
        return FlowKt__DelayKt.f(o0Var, j10, j11);
    }

    @yt.k
    public static final <T> e<T> y1(@yt.k e<? extends T> eVar, @yt.k ik.r<? super f<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> rVar) {
        return FlowKt__ErrorsKt.g(eVar, rVar);
    }

    @yt.l
    public static final <T> Object z(@yt.k e<? extends T> eVar, @yt.k ik.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return FlowKt__CollectKt.d(eVar, qVar, cVar);
    }

    @yt.k
    public static final <T, R> e<R> z1(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return FlowKt__TransformKt.i(eVar, r10, qVar);
    }
}
