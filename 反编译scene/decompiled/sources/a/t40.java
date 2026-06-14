package a;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$socketSendRequest$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class t40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ByteBuffer f2950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SocketChannel f2951a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t40(SocketChannel socketChannel, ByteBuffer byteBuffer, b62 b62Var) {
        super(2, b62Var);
        this.f2951a = socketChannel;
        this.f2950a = byteBuffer;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        t40 t40Var = new t40(this.f2951a, this.f2950a, b62Var);
        t40Var.f7463a = (wd2) obj;
        return t40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((t40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50 e50Var = e50.f677a;
        synchronized (e50.f683a) {
            this.f2951a.write(this.f2950a);
            m42 m42Var = m42.f6769a;
        }
        return m42.f6769a;
    }
}
