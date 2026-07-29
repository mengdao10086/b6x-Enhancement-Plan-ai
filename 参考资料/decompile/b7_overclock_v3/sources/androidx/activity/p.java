package androidx.activity;

import androidx.lifecycle.y;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    public static final class a extends n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ik.l<n, z1> f1383d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z10, ik.l<? super n, z1> lVar) {
            super(z10);
            this.f1383d = lVar;
        }

        @Override // androidx.activity.n
        public void c() {
            this.f1383d.i(this);
        }
    }

    @yt.k
    public static final n a(@yt.k OnBackPressedDispatcher onBackPressedDispatcher, @yt.l y yVar, boolean z10, @yt.k ik.l<? super n, z1> onBackPressed) {
        f0.p(onBackPressedDispatcher, "<this>");
        f0.p(onBackPressed, "onBackPressed");
        a aVar = new a(z10, onBackPressed);
        if (yVar != null) {
            onBackPressedDispatcher.c(yVar, aVar);
        } else {
            onBackPressedDispatcher.b(aVar);
        }
        return aVar;
    }

    public static /* synthetic */ n b(OnBackPressedDispatcher onBackPressedDispatcher, y yVar, boolean z10, ik.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            yVar = null;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return a(onBackPressedDispatcher, yVar, z10, lVar);
    }
}
