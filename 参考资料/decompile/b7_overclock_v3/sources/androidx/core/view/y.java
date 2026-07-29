package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class y {

    public static final class a implements kotlin.sequences.m<MenuItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Menu f5148a;

        public a(Menu menu) {
            this.f5148a = menu;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<MenuItem> iterator() {
            return y.i(this.f5148a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n83#2:91\n1#3:92\n*S KotlinDebug\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n*L\n74#1:91\n74#1:92\n*E\n"})
    public static final class b implements Iterator<MenuItem>, jk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Menu f5150b;

        public b(Menu menu) {
            this.f5150b = menu;
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MenuItem next() {
            Menu menu = this.f5150b;
            int i10 = this.f5149a;
            this.f5149a = i10 + 1;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5149a < this.f5150b.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            z1 z1Var;
            Menu menu = this.f5150b;
            int i10 = this.f5149a - 1;
            this.f5149a = i10;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                kotlin.jvm.internal.f0.o(item, "getItem(index)");
                menu.removeItem(item.getItemId());
                z1Var = z1.f38230a;
            } else {
                z1Var = null;
            }
            if (z1Var == null) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public static final boolean a(@yt.k Menu menu, @yt.k MenuItem item) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        kotlin.jvm.internal.f0.p(item, "item");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kotlin.jvm.internal.f0.g(menu.getItem(i10), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void b(@yt.k Menu menu, @yt.k ik.l<? super MenuItem, z1> action) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menu.getItem(i10);
            kotlin.jvm.internal.f0.o(item, "getItem(index)");
            action.i(item);
        }
    }

    public static final void c(@yt.k Menu menu, @yt.k ik.p<? super Integer, ? super MenuItem, z1> action) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            Integer numValueOf = Integer.valueOf(i10);
            MenuItem item = menu.getItem(i10);
            kotlin.jvm.internal.f0.o(item, "getItem(index)");
            action.r0(numValueOf, item);
        }
    }

    @yt.k
    public static final MenuItem d(@yt.k Menu menu, int i10) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        kotlin.jvm.internal.f0.o(item, "getItem(index)");
        return item;
    }

    @yt.k
    public static final kotlin.sequences.m<MenuItem> e(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        return new a(menu);
    }

    public static final int f(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        return menu.size();
    }

    public static final boolean g(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean h(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        return menu.size() != 0;
    }

    @yt.k
    public static final Iterator<MenuItem> i(@yt.k Menu menu) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        return new b(menu);
    }

    public static final void j(@yt.k Menu menu, @yt.k MenuItem item) {
        kotlin.jvm.internal.f0.p(menu, "<this>");
        kotlin.jvm.internal.f0.p(item, "item");
        menu.removeItem(item.getItemId());
    }

    public static final void k(@yt.k Menu menu, int i10) {
        z1 z1Var;
        kotlin.jvm.internal.f0.p(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            menu.removeItem(item.getItemId());
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
