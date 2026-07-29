package kotlin.reflect;

import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public interface KParameter extends b {

    public enum Kind {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    public static final class a {
        @v0(version = "1.1")
        public static /* synthetic */ void a() {
        }
    }

    boolean M0();

    int S();

    boolean T();

    @yt.l
    String getName();

    @yt.k
    r getType();

    @yt.k
    Kind q0();
}
