package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<h> implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f38146a;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f38146a = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.f38146a.f().groupCount() + 1;
    }

    public /* bridge */ boolean b(h hVar) {
        return super.contains(hVar);
    }

    @Override // kotlin.text.j
    @yt.l
    public h c(@yt.k String name) {
        f0.p(name, "name");
        return bk.m.f9497a.c(this.f38146a.f(), name);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof h) {
            return b((h) obj);
        }
        return false;
    }

    @Override // kotlin.text.i
    @yt.l
    public h get(int i10) {
        qk.m mVarJ = RegexKt.j(this.f38146a.f(), i10);
        if (mVarJ.a().intValue() < 0) {
            return null;
        }
        String strGroup = this.f38146a.f().group(i10);
        f0.o(strGroup, "matchResult.group(index)");
        return new h(strGroup, mVarJ);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<h> iterator() {
        return SequencesKt___SequencesKt.k1(CollectionsKt___CollectionsKt.v1(CollectionsKt__CollectionsKt.F(this)), new ik.l<Integer, h>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @yt.l
            public final h b(int i10) {
                return this.this$0.get(i10);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ h i(Integer num) {
                return b(num.intValue());
            }
        }).iterator();
    }
}
