package qc;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import eb.f;
import g.p0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends eb.g<i, j, SubtitleDecoderException> implements g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f47265n;

    public d(String str) {
        super(new i[2], new j[2]);
        this.f47265n = str;
        u(1024);
    }

    public abstract f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException;

    @Override // qc.g
    public void a(long j10) {
    }

    @Override // eb.c
    public final String getName() {
        return this.f47265n;
    }

    @Override // eb.g
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final i g() {
        return new i();
    }

    @Override // eb.g
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final j h() {
        return new e(new f.a() { // from class: qc.c
            @Override // eb.f.a
            public final void a(eb.f fVar) {
                this.f47264a.r((j) fVar);
            }
        });
    }

    @Override // eb.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException i(Throwable th2) {
        return new SubtitleDecoderException("Unexpected decode error", th2);
    }

    @Override // eb.g
    @p0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException j(i iVar, j jVar, boolean z10) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(iVar.f16960c);
            jVar.q(iVar.f16962e, A(byteBuffer.array(), byteBuffer.limit(), z10), iVar.f47268l);
            jVar.i(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e10) {
            return e10;
        }
    }
}
