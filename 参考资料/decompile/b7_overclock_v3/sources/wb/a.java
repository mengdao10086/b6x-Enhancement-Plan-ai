package wb;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import hd.c0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import ub.d;
import ub.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    @Override // ub.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        return new Metadata(c(new c0(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(c0 c0Var) {
        return new EventMessage((String) hd.a.g(c0Var.A()), (String) hd.a.g(c0Var.A()), c0Var.I(), c0Var.I(), Arrays.copyOfRange(c0Var.d(), c0Var.e(), c0Var.f()));
    }
}
