package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f37769a = new a(null);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    private final Class<E> f37770c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public EnumEntriesSerializationProxy(@k E[] entries) {
        f0.p(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        f0.m(cls);
        this.f37770c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f37770c.getEnumConstants();
        f0.o(enumConstants, "c.enumConstants");
        return EnumEntriesKt.b(enumConstants);
    }
}
