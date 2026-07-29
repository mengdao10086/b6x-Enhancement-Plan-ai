package okio.internal;

import ik.p;
import java.util.Iterator;
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
@zj.d(c = "okio.internal._FileSystemKt$commonListRecursively$1", f = "-FileSystem.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
@d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/o;", "Lokio/k0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class _FileSystemKt$commonListRecursively$1 extends RestrictedSuspendLambda implements p<o<? super k0>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ k0 $dir;
    public final /* synthetic */ boolean $followSymlinks;
    public final /* synthetic */ s $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonListRecursively$1(k0 k0Var, s sVar, boolean z10, kotlin.coroutines.c<? super _FileSystemKt$commonListRecursively$1> cVar) {
        super(2, cVar);
        this.$dir = k0Var;
        this.$this_commonListRecursively = sVar;
        this.$followSymlinks = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, cVar);
        _filesystemkt_commonlistrecursively_1.L$0 = obj;
        return _filesystemkt_commonlistrecursively_1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1;
        o oVar;
        kotlin.collections.i iVar;
        Iterator<k0> it2;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o oVar2 = (o) this.L$0;
            kotlin.collections.i iVar2 = new kotlin.collections.i();
            iVar2.addLast(this.$dir);
            _filesystemkt_commonlistrecursively_1 = this;
            oVar = oVar2;
            iVar = iVar2;
            it2 = this.$this_commonListRecursively.x(this.$dir).iterator();
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it2 = (Iterator) this.L$2;
            kotlin.collections.i iVar3 = (kotlin.collections.i) this.L$1;
            o oVar3 = (o) this.L$0;
            u0.n(obj);
            _filesystemkt_commonlistrecursively_1 = this;
            iVar = iVar3;
            oVar = oVar3;
        }
        while (it2.hasNext()) {
            k0 next = it2.next();
            s sVar = _filesystemkt_commonlistrecursively_1.$this_commonListRecursively;
            boolean z10 = _filesystemkt_commonlistrecursively_1.$followSymlinks;
            _filesystemkt_commonlistrecursively_1.L$0 = oVar;
            _filesystemkt_commonlistrecursively_1.L$1 = iVar;
            _filesystemkt_commonlistrecursively_1.L$2 = it2;
            _filesystemkt_commonlistrecursively_1.label = 1;
            if (_FileSystemKt.a(oVar, sVar, iVar, next, z10, false, _filesystemkt_commonlistrecursively_1) == objH) {
                return objH;
            }
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o<? super k0> oVar, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((_FileSystemKt$commonListRecursively$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
