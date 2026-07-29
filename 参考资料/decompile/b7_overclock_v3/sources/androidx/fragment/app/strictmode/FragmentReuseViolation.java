package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentReuseViolation;", "Landroidx/fragment/app/strictmode/Violation;", "", "previousFragmentId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentReuseViolation extends Violation {

    @k
    private final String previousFragmentId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(@k Fragment fragment, @k String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        f0.p(fragment, "fragment");
        f0.p(previousFragmentId, "previousFragmentId");
        this.previousFragmentId = previousFragmentId;
    }

    @k
    public final String b() {
        return this.previousFragmentId;
    }
}
