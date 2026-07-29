package okio.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "okio.internal._FileSystemKt", f = "-FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {113, 132, 142}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
@d0(k = 3, mv = {1, 5, 1}, xi = 48)
public final class _FileSystemKt$collectRecursively$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public boolean Z$0;
    public boolean Z$1;
    public int label;
    public /* synthetic */ Object result;

    public _FileSystemKt$collectRecursively$1(kotlin.coroutines.c<? super _FileSystemKt$collectRecursively$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return _FileSystemKt.a(null, null, null, null, false, false, this);
    }
}
