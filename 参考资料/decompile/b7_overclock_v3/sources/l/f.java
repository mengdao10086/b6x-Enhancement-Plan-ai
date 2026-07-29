package l;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.collection.l;
import java.util.ArrayList;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f39280b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f39281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f39282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f39283c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l<Menu, Menu> f39284d = new l<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f39282b = context;
            this.f39281a = callback;
        }

        @Override // l.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f39281a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // l.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f39281a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // l.b.a
        public void c(b bVar) {
            this.f39281a.onDestroyActionMode(e(bVar));
        }

        @Override // l.b.a
        public boolean d(b bVar, MenuItem menuItem) {
            return this.f39281a.onActionItemClicked(e(bVar), new m.c(this.f39282b, (r0.c) menuItem));
        }

        public ActionMode e(b bVar) {
            int size = this.f39283c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f39283c.get(i10);
                if (fVar != null && fVar.f39280b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f39282b, bVar);
            this.f39283c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f39284d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            m.e eVar = new m.e(this.f39282b, (r0.a) menu);
            this.f39284d.put(menu, eVar);
            return eVar;
        }
    }

    public f(Context context, b bVar) {
        this.f39279a = context;
        this.f39280b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f39280b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f39280b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new m.e(this.f39279a, (r0.a) this.f39280b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f39280b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f39280b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f39280b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f39280b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f39280b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f39280b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f39280b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f39280b.n(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f39280b.p(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f39280b.q(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f39280b.s(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f39280b.t(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f39280b.o(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f39280b.r(i10);
    }
}
