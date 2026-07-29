package h1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import androidx.core.util.o;
import g.f0;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f30195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30197c;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    @v0(19)
    public static class C0356a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f30198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f30199b;

        public C0356a(@n0 EditText editText, boolean z10) {
            this.f30198a = editText;
            g gVar = new g(editText, z10);
            this.f30199b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(h1.b.getInstance());
        }

        @Override // h1.a.b
        public KeyListener a(@p0 KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // h1.a.b
        public boolean b() {
            return this.f30199b.d();
        }

        @Override // h1.a.b
        public InputConnection c(@n0 InputConnection inputConnection, @n0 EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f30198a, inputConnection, editorInfo);
        }

        @Override // h1.a.b
        public void d(int i10) {
            this.f30199b.f(i10);
        }

        @Override // h1.a.b
        public void e(boolean z10) {
            this.f30199b.g(z10);
        }

        @Override // h1.a.b
        public void f(int i10) {
            this.f30199b.h(i10);
        }
    }

    public static class b {
        @p0
        public KeyListener a(@p0 KeyListener keyListener) {
            return keyListener;
        }

        public boolean b() {
            return false;
        }

        public InputConnection c(@n0 InputConnection inputConnection, @n0 EditorInfo editorInfo) {
            return inputConnection;
        }

        public void d(int i10) {
        }

        public void e(boolean z10) {
        }

        public void f(int i10) {
        }
    }

    public a(@n0 EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int a() {
        return this.f30197c;
    }

    @p0
    public KeyListener b(@p0 KeyListener keyListener) {
        return this.f30195a.a(keyListener);
    }

    public int c() {
        return this.f30196b;
    }

    public boolean d() {
        return this.f30195a.b();
    }

    @p0
    public InputConnection e(@p0 InputConnection inputConnection, @n0 EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f30195a.c(inputConnection, editorInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void f(int i10) {
        this.f30197c = i10;
        this.f30195a.d(i10);
    }

    public void g(boolean z10) {
        this.f30195a.e(z10);
    }

    public void h(@f0(from = 0) int i10) {
        o.j(i10, "maxEmojiCount should be greater than 0");
        this.f30196b = i10;
        this.f30195a.f(i10);
    }

    public a(@n0 EditText editText, boolean z10) {
        this.f30196b = Integer.MAX_VALUE;
        this.f30197c = 0;
        o.m(editText, "editText cannot be null");
        this.f30195a = new C0356a(editText, z10);
    }
}
