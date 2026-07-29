package eb;

import com.google.android.exoplayer2.decoder.DecoderException;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public interface c<I, O, E extends DecoderException> {
    @p0
    O b() throws DecoderException;

    @p0
    I c() throws DecoderException;

    void d(I i10) throws DecoderException;

    void flush();

    String getName();

    void release();
}
