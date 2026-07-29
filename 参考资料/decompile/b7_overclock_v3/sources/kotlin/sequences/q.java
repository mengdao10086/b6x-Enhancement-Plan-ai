package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38107a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38108b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38109c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38110d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38111e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38112f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SequenceBuilder.kt\nkotlin/sequences/SequencesKt__SequenceBuilderKt\n*L\n1#1,680:1\n26#2:681\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.p f38113a;

        public a(ik.p pVar) {
            this.f38113a = pVar;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            return q.a(this.f38113a);
        }
    }

    @v0(version = "1.3")
    @yt.k
    public static final <T> Iterator<T> a(@kotlin.b @yt.k ik.p<? super o<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        f0.p(block, "block");
        n nVar = new n();
        nVar.m(IntrinsicsKt__IntrinsicsJvmKt.c(block, nVar, nVar));
        return nVar;
    }

    @v0(version = "1.3")
    @yt.k
    public static final <T> m<T> b(@kotlin.b @yt.k ik.p<? super o<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        f0.p(block, "block");
        return new a(block);
    }
}
