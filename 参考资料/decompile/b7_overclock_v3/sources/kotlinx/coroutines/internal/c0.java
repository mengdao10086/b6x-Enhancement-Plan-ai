package kotlinx.coroutines.internal;

import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class c0 extends m2 implements kotlinx.coroutines.w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final Throwable f38787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final String f38788d;

    public /* synthetic */ c0(Throwable th2, String str, int i10, kotlin.jvm.internal.u uVar) {
        this(th2, (i10 & 2) != 0 ? null : str);
    }

    @Override // kotlinx.coroutines.w0
    @yt.k
    public g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
        p2();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean j2(@yt.k CoroutineContext coroutineContext) {
        p2();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.m2, kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        p2();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.w0
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @yt.l
    public Object m1(long j10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return w0.a.a(this, j10, cVar);
    }

    @Override // kotlinx.coroutines.m2
    @yt.k
    public m2 m2() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    /* JADX INFO: renamed from: o2, reason: merged with bridge method [inline-methods] */
    public Void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        p2();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Void p2() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f38787c
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f38788d
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f38787c
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.b0.e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.c0.p2():java.lang.Void");
    }

    @Override // kotlinx.coroutines.w0
    @yt.k
    /* JADX INFO: renamed from: q2, reason: merged with bridge method [inline-methods] */
    public Void i(long j10, @yt.k kotlinx.coroutines.o<? super z1> oVar) {
        p2();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.m2, kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f38787c != null) {
            str = ", cause=" + this.f38787c;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    public c0(@yt.l Throwable th2, @yt.l String str) {
        this.f38787c = th2;
        this.f38788d = str;
    }
}
