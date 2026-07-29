package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements ik.l<Iterable<? extends R>, Iterator<? extends R>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 f38047c = new SequencesKt___SequencesKt$flatMapIndexed$1();

    public SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // ik.l
    @yt.k
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final Iterator<R> i(@yt.k Iterable<? extends R> p02) {
        f0.p(p02, "p0");
        return p02.iterator();
    }
}
