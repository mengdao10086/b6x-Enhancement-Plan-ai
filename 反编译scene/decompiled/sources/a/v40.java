package a;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v40 extends g92 implements g82<ByteBuffer, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v50 f7657a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v40(v50 v50Var) {
        super(1);
        this.f7657a = v50Var;
    }

    public final int a(ByteBuffer byteBuffer) {
        f92.d(byteBuffer, "readBuffer");
        v50 v50Var = this.f7657a;
        f92.b(v50Var);
        return v50Var.d(byteBuffer);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ Integer f(ByteBuffer byteBuffer) {
        return Integer.valueOf(a(byteBuffer));
    }
}
