package kotlin.io.path;

import ik.p;
import java.nio.file.Path;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n98#1:178,15\n*E\n"})
@zj.d(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
public final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements p<kotlin.sequences.o<? super Path>, kotlin.coroutines.c<? super z1>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public final /* synthetic */ PathTreeWalk this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, kotlin.coroutines.c<? super PathTreeWalk$bfsIterator$1> cVar) {
        super(2, cVar);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, cVar);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00f2 -> B:11:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f4 -> B:11:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlin.sequences.o<? super Path> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((PathTreeWalk$bfsIterator$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
