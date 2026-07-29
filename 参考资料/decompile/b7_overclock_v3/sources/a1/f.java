package a1;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityRecord f144a;

    @v0(15)
    public static class a {
        @u
        public static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        @u
        public static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        @u
        public static void c(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollX(i10);
        }

        @u
        public static void d(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollY(i10);
        }
    }

    @v0(16)
    public static class b {
        @u
        public static void a(AccessibilityRecord accessibilityRecord, View view, int i10) {
            accessibilityRecord.setSource(view, i10);
        }
    }

    @Deprecated
    public f(Object obj) {
        this.f144a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static f A(f fVar) {
        return new f(AccessibilityRecord.obtain(fVar.f144a));
    }

    public static void N(@n0 AccessibilityRecord accessibilityRecord, int i10) {
        a.c(accessibilityRecord, i10);
    }

    public static void P(@n0 AccessibilityRecord accessibilityRecord, int i10) {
        a.d(accessibilityRecord, i10);
    }

    public static void Y(@n0 AccessibilityRecord accessibilityRecord, @p0 View view, int i10) {
        b.a(accessibilityRecord, view, i10);
    }

    public static int j(@n0 AccessibilityRecord accessibilityRecord) {
        return a.a(accessibilityRecord);
    }

    public static int l(@n0 AccessibilityRecord accessibilityRecord) {
        return a.b(accessibilityRecord);
    }

    @Deprecated
    public static f z() {
        return new f(AccessibilityRecord.obtain());
    }

    @Deprecated
    public void B() {
        this.f144a.recycle();
    }

    @Deprecated
    public void C(int i10) {
        this.f144a.setAddedCount(i10);
    }

    @Deprecated
    public void D(CharSequence charSequence) {
        this.f144a.setBeforeText(charSequence);
    }

    @Deprecated
    public void E(boolean z10) {
        this.f144a.setChecked(z10);
    }

    @Deprecated
    public void F(CharSequence charSequence) {
        this.f144a.setClassName(charSequence);
    }

    @Deprecated
    public void G(CharSequence charSequence) {
        this.f144a.setContentDescription(charSequence);
    }

    @Deprecated
    public void H(int i10) {
        this.f144a.setCurrentItemIndex(i10);
    }

    @Deprecated
    public void I(boolean z10) {
        this.f144a.setEnabled(z10);
    }

    @Deprecated
    public void J(int i10) {
        this.f144a.setFromIndex(i10);
    }

    @Deprecated
    public void K(boolean z10) {
        this.f144a.setFullScreen(z10);
    }

    @Deprecated
    public void L(int i10) {
        this.f144a.setItemCount(i10);
    }

    @Deprecated
    public void M(int i10) {
        N(this.f144a, i10);
    }

    @Deprecated
    public void O(int i10) {
        P(this.f144a, i10);
    }

    @Deprecated
    public void Q(Parcelable parcelable) {
        this.f144a.setParcelableData(parcelable);
    }

    @Deprecated
    public void R(boolean z10) {
        this.f144a.setPassword(z10);
    }

    @Deprecated
    public void S(int i10) {
        this.f144a.setRemovedCount(i10);
    }

    @Deprecated
    public void T(int i10) {
        this.f144a.setScrollX(i10);
    }

    @Deprecated
    public void U(int i10) {
        this.f144a.setScrollY(i10);
    }

    @Deprecated
    public void V(boolean z10) {
        this.f144a.setScrollable(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void W(View view) {
        this.f144a.setSource(view);
    }

    @Deprecated
    public void X(View view, int i10) {
        Y(this.f144a, view, i10);
    }

    @Deprecated
    public void Z(int i10) {
        this.f144a.setToIndex(i10);
    }

    @Deprecated
    public int a() {
        return this.f144a.getAddedCount();
    }

    @Deprecated
    public CharSequence b() {
        return this.f144a.getBeforeText();
    }

    @Deprecated
    public CharSequence c() {
        return this.f144a.getClassName();
    }

    @Deprecated
    public CharSequence d() {
        return this.f144a.getContentDescription();
    }

    @Deprecated
    public int e() {
        return this.f144a.getCurrentItemIndex();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityRecord accessibilityRecord = this.f144a;
        return accessibilityRecord == null ? fVar.f144a == null : accessibilityRecord.equals(fVar.f144a);
    }

    @Deprecated
    public int f() {
        return this.f144a.getFromIndex();
    }

    @Deprecated
    public Object g() {
        return this.f144a;
    }

    @Deprecated
    public int h() {
        return this.f144a.getItemCount();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f144a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public int i() {
        return j(this.f144a);
    }

    @Deprecated
    public int k() {
        return l(this.f144a);
    }

    @Deprecated
    public Parcelable m() {
        return this.f144a.getParcelableData();
    }

    @Deprecated
    public int n() {
        return this.f144a.getRemovedCount();
    }

    @Deprecated
    public int o() {
        return this.f144a.getScrollX();
    }

    @Deprecated
    public int p() {
        return this.f144a.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public d q() {
        return d.h2(this.f144a.getSource());
    }

    @Deprecated
    public List<CharSequence> r() {
        return this.f144a.getText();
    }

    @Deprecated
    public int s() {
        return this.f144a.getToIndex();
    }

    @Deprecated
    public int t() {
        return this.f144a.getWindowId();
    }

    @Deprecated
    public boolean u() {
        return this.f144a.isChecked();
    }

    @Deprecated
    public boolean v() {
        return this.f144a.isEnabled();
    }

    @Deprecated
    public boolean w() {
        return this.f144a.isFullScreen();
    }

    @Deprecated
    public boolean x() {
        return this.f144a.isPassword();
    }

    @Deprecated
    public boolean y() {
        return this.f144a.isScrollable();
    }
}
