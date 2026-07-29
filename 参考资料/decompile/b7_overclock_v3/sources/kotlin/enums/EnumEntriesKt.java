package kotlin.enums;

import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.s0;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class EnumEntriesKt {
    @v0(version = "1.8")
    @s0
    @k
    @q
    public static final <E extends Enum<E>> a<E> a(@k ik.a<E[]> entriesProvider) {
        f0.p(entriesProvider, "entriesProvider");
        return new EnumEntriesList(entriesProvider);
    }

    @v0(version = "1.8")
    @s0
    @k
    @q
    public static final <E extends Enum<E>> a<E> b(@k final E[] entries) {
        f0.p(entries, "entries");
        EnumEntriesList enumEntriesList = new EnumEntriesList(new ik.a<E[]>() { // from class: kotlin.enums.EnumEntriesKt$enumEntries$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: ([TE;)V */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()[TE; */
            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Enum[] o() {
                return entries;
            }
        });
        enumEntriesList.size();
        return enumEntriesList;
    }
}
