package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,496:1\n193#2:497\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n435#1:497\n*E\n"})
public final /* synthetic */ class FlowKt__MigrationKt {
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.t0(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @yt.k
    public static final <T> e<T> A(@yt.k e<? extends T> eVar, int i10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @kotlin.t0(expression = "scan(initial, operation)", imports = {}))
    @yt.k
    public static final <T, R> e<R> B(@yt.k e<? extends T> eVar, R r10, @kotlin.b @yt.k ik.q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @kotlin.t0(expression = "runningReduce(operation)", imports = {}))
    @yt.k
    public static final <T> e<T> C(@yt.k e<? extends T> eVar, @yt.k ik.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar) {
        return g.A1(eVar, qVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @kotlin.t0(expression = "drop(count)", imports = {}))
    @yt.k
    public static final <T> e<T> D(@yt.k e<? extends T> eVar, int i10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @kotlin.t0(expression = "onStart { emit(value) }", imports = {}))
    @yt.k
    public static final <T> e<T> E(@yt.k e<? extends T> eVar, T t10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @kotlin.t0(expression = "onStart { emitAll(other) }", imports = {}))
    @yt.k
    public static final <T> e<T> F(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@yt.k e<? extends T> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k ik.p<? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar2) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @yt.k
    public static final <T> e<T> J(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @kotlin.t0(expression = "this.flatMapLatest(transform)", imports = {}))
    @yt.k
    public static final <T, R> e<R> K(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        return g.d2(eVar, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(pVar, null));
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @kotlin.t0(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @yt.k
    public static final <T> e<T> a(@yt.k e<? extends T> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.t0(expression = "this.combine(other, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, R> e<R> b(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return g.D(eVar, eVar2, qVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.t0(expression = "combine(this, other, other2, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, R> e<R> c(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k ik.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.c<? super R>, ? extends Object> rVar) {
        return g.E(eVar, eVar2, eVar3, rVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.t0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, T4, R> e<R> d(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k ik.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.c<? super R>, ? extends Object> sVar) {
        return g.F(eVar, eVar2, eVar3, eVar4, sVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.t0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @yt.k
    public static final <T1, T2, T3, T4, T5, R> e<R> e(@yt.k e<? extends T1> eVar, @yt.k e<? extends T2> eVar2, @yt.k e<? extends T3> eVar3, @yt.k e<? extends T4> eVar4, @yt.k e<? extends T5> eVar5, @yt.k ik.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.c<? super R>, ? extends Object> tVar) {
        return g.G(eVar, eVar2, eVar3, eVar4, eVar5, tVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @kotlin.t0(expression = "let(transformer)", imports = {}))
    @yt.k
    public static final <T, R> e<R> f(@yt.k e<? extends T> eVar, @yt.k ik.l<? super e<? extends T>, ? extends e<? extends R>> lVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @kotlin.t0(expression = "flatMapConcat(mapper)", imports = {}))
    @yt.k
    public static final <T, R> e<R> g(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, ? extends e<? extends R>> lVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @kotlin.t0(expression = "onCompletion { emit(value) }", imports = {}))
    @yt.k
    public static final <T> e<T> h(@yt.k e<? extends T> eVar, T t10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @kotlin.t0(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @yt.k
    public static final <T> e<T> i(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @kotlin.t0(expression = "onEach { delay(timeMillis) }", imports = {}))
    @yt.k
    public static final <T> e<T> j(@yt.k e<? extends T> eVar, long j10) {
        return g.f1(eVar, new FlowKt__MigrationKt$delayEach$1(j10, null));
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @kotlin.t0(expression = "onStart { delay(timeMillis) }", imports = {}))
    @yt.k
    public static final <T> e<T> k(@yt.k e<? extends T> eVar, long j10) {
        return g.m1(eVar, new FlowKt__MigrationKt$delayFlow$1(j10, null));
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @kotlin.t0(expression = "flatMapConcat(mapper)", imports = {}))
    @yt.k
    public static final <T, R> e<R> l(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @kotlin.t0(expression = "flattenConcat()", imports = {}))
    @yt.k
    public static final <T> e<T> m(@yt.k e<? extends e<? extends T>> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @kotlin.t0(expression = "collect(action)", imports = {}))
    public static final <T> void n(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @kotlin.t0(expression = "flattenConcat()", imports = {}))
    @yt.k
    public static final <T> e<T> o(@yt.k e<? extends e<? extends T>> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @yt.k
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @yt.k
    public static final <T> e<T> q(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.t0(expression = "catch { emitAll(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> r(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.t0(expression = "catch { emitAll(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> s(@yt.k e<? extends T> eVar, @yt.k e<? extends T> eVar2) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @kotlin.t0(expression = "catch { emit(fallback) }", imports = {}))
    @yt.k
    public static final <T> e<T> t(@yt.k e<? extends T> eVar, T t10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @kotlin.t0(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @yt.k
    public static final <T> e<T> u(@yt.k e<? extends T> eVar, T t10, @yt.k ik.l<? super Throwable, Boolean> lVar) {
        return g.u(eVar, new FlowKt__MigrationKt$onErrorReturn$2(lVar, t10, null));
    }

    public static /* synthetic */ e v(e eVar, Object obj, ik.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = new ik.l<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$1
                @Override // ik.l
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Boolean i(@yt.k Throwable th2) {
                    return Boolean.TRUE;
                }
            };
        }
        return g.k1(eVar, obj, lVar);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.t0(expression = "this.shareIn(scope, 0)", imports = {}))
    @yt.k
    public static final <T> e<T> w(@yt.k e<? extends T> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.t0(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @yt.k
    public static final <T> e<T> x(@yt.k e<? extends T> eVar, int i10) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @yt.k
    public static final <T> e<T> y(@yt.k e<? extends T> eVar, @yt.k CoroutineContext coroutineContext) {
        g.c1();
        throw new KotlinNothingValueException();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.t0(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @yt.k
    public static final <T> e<T> z(@yt.k e<? extends T> eVar) {
        g.c1();
        throw new KotlinNothingValueException();
    }
}
