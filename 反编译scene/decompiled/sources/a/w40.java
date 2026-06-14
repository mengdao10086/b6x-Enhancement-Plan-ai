package a;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w40 extends g92 implements g82<ByteBuffer, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SocketChannel f7754a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w40(SocketChannel socketChannel) {
        super(1);
        this.f7754a = socketChannel;
    }

    public final int a(ByteBuffer byteBuffer) {
        f92.d(byteBuffer, "readBuffer");
        SocketChannel socketChannel = this.f7754a;
        f92.b(socketChannel);
        return socketChannel.read(byteBuffer);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ Integer f(ByteBuffer byteBuffer) {
        return Integer.valueOf(a(byteBuffer));
    }
}
