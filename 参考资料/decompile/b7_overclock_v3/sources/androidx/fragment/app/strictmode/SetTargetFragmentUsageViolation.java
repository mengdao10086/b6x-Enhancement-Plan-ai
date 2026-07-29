package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/strictmode/SetTargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "Landroidx/fragment/app/Fragment;", "targetFragment", "Landroidx/fragment/app/Fragment;", "c", "()Landroidx/fragment/app/Fragment;", "", "requestCode", "I", "b", "()I", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;

    @k
    private final Fragment targetFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(@k Fragment fragment, @k Fragment targetFragment, int i10) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i10 + " for fragment " + fragment);
        f0.p(fragment, "fragment");
        f0.p(targetFragment, "targetFragment");
        this.targetFragment = targetFragment;
        this.requestCode = i10;
    }

    public final int b() {
        return this.requestCode;
    }

    @k
    public final Fragment c() {
        return this.targetFragment;
    }
}
