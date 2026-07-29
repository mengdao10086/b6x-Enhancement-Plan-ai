package okio.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d0;
import kotlin.sequences.o;
import kotlin.u0;
import kotlin.z1;
import okio.k0;
import okio.s;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "okio.internal._FileSystemKt$commonDeleteRecursively$sequence$1", f = "-FileSystem.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
@d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/o;", "Lokio/k0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class _FileSystemKt$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements p<o<? super k0>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ k0 $fileOrDirectory;
    public final /* synthetic */ s $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonDeleteRecursively$sequence$1(s sVar, k0 k0Var, kotlin.coroutines.c<? super _FileSystemKt$commonDeleteRecursively$sequence$1> cVar) {
        super(2, cVar);
        this.$this_commonDeleteRecursively = sVar;
        this.$fileOrDirectory = k0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        _FileSystemKt$commonDeleteRecursively$sequence$1 _filesystemkt_commondeleterecursively_sequence_1 = new _FileSystemKt$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, cVar);
        _filesystemkt_commondeleterecursively_sequence_1.L$0 = obj;
        return _filesystemkt_commondeleterecursively_sequence_1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o oVar = (o) this.L$0;
            s sVar = this.$this_commonDeleteRecursively;
            kotlin.collections.i iVar = new kotlin.collections.i();
            k0 k0Var = this.$fileOrDirectory;
            this.label = 1;
            if (_FileSystemKt.a(oVar, sVar, iVar, k0Var, false, true, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o<? super k0> oVar, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((_FileSystemKt$commonDeleteRecursively$sequence$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
