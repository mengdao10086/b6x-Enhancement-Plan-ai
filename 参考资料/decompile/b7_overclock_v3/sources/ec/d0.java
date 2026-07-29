package ec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public interface d0 {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    void a() throws IOException;

    boolean d();

    int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10);

    int o(long j10);
}
