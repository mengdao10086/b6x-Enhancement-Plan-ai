package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/Violation;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/Fragment;", "a", "()Landroidx/fragment/app/Fragment;", "", "violationMessage", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "fragment_release"}, k = 1, mv = {1, 6, 0})
public abstract class Violation extends RuntimeException {

    @k
    private final Fragment fragment;

    public /* synthetic */ Violation(Fragment fragment, String str, int i10, u uVar) {
        this(fragment, (i10 & 2) != 0 ? null : str);
    }

    @k
    public final Fragment a() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(@k Fragment fragment, @l String str) {
        super(str);
        f0.p(fragment, "fragment");
        this.fragment = fragment;
    }
}
