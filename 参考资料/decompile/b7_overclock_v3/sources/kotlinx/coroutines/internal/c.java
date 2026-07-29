package kotlinx.coroutines.internal;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@IgnoreJRERequirement
public final class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f38785a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f38786b = new a();

    public static final class a extends ClassValue<ik.l<? super Throwable, ? extends Throwable>> {
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ik.l<Throwable, Throwable> b(@yt.l Class<?> cls) {
            kotlin.jvm.internal.f0.n(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            return ExceptionsConstructorKt.b(cls);
        }
    }

    @Override // kotlinx.coroutines.internal.j
    @yt.k
    public ik.l<Throwable, Throwable> a(@yt.k Class<? extends Throwable> cls) {
        return (ik.l) f38786b.get(cls);
    }
}
