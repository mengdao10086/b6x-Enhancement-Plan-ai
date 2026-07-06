package a;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$getDaemonConnectHandler$1$exit$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class r30 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s30 f7266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2705a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r30(s30 s30Var, b62 b62Var) {
        super(2, b62Var);
        this.f7266a = s30Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        r30 r30Var = new r30(this.f7266a, b62Var);
        r30Var.f2705a = (wd2) obj;
        return r30Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((r30) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            e42 e42Var = g42.f6169a;
            SocketChannel socketChannel = this.f7266a.f7358a;
            e50 e50Var = e50.f677a;
            byte[] bytes = "@signal:exit".getBytes(bb2.f5692a);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            socketChannel.write(e50Var.p1(bytes));
            SocketChannel socketChannel2 = this.f7266a.f7358a;
            Charset charsetDefaultCharset = Charset.defaultCharset();
            f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
            byte[] bytes2 = ";".getBytes(charsetDefaultCharset);
            f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
            g42.a(t62.e(socketChannel2.write(ByteBuffer.wrap(bytes2))));
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        return m42.f6769a;
    }
}
