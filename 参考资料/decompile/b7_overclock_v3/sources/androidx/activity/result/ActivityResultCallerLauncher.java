package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.z;
import kotlin.z1;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityResultCallerLauncher<I, O> extends g<z1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final g<I> f1386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final f.a<I, O> f1387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final I f1388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final z f1389d;

    public ActivityResultCallerLauncher(@yt.k g<I> launcher, @yt.k f.a<I, O> callerContract, I i10) {
        f0.p(launcher, "launcher");
        f0.p(callerContract, "callerContract");
        this.f1386a = launcher;
        this.f1387b = callerContract;
        this.f1388c = i10;
        this.f1389d = b0.a(new ik.a<ActivityResultCallerLauncher$resultContract$2.a>(this) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            public final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            /* JADX INFO: Add missing generic type declarations: [O] */
            public static final class a<O> extends f.a<z1, O> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ActivityResultCallerLauncher<I, O> f1390a;

                public a(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
                    this.f1390a = activityResultCallerLauncher;
                }

                @Override // f.a
                public O c(int i10, @l Intent intent) {
                    return (O) this.f1390a.e().c(i10, intent);
                }

                @Override // f.a
                @yt.k
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Intent a(@yt.k Context context, @yt.k z1 input) {
                    f0.p(context, "context");
                    f0.p(input, "input");
                    return this.f1390a.e().a(context, this.f1390a.f());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a o() {
                return new a(this.this$0);
            }
        });
    }

    @Override // androidx.activity.result.g
    @yt.k
    public f.a<z1, ?> a() {
        return h();
    }

    @Override // androidx.activity.result.g
    public void d() {
        this.f1386a.d();
    }

    @yt.k
    public final f.a<I, O> e() {
        return this.f1387b;
    }

    public final I f() {
        return this.f1388c;
    }

    @yt.k
    public final g<I> g() {
        return this.f1386a;
    }

    @yt.k
    public final f.a<z1, O> h() {
        return (f.a) this.f1389d.getValue();
    }

    @Override // androidx.activity.result.g
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(@yt.k z1 input, @l f0.e eVar) {
        f0.p(input, "input");
        this.f1386a.c(this.f1388c, eVar);
    }
}
