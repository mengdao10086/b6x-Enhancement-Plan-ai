package com.app.hubert.guide.model;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f11419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s3.a f11420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r3.c f11421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11422d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f11423a = new b();

        public b a() {
            return this.f11423a;
        }

        public a b(boolean z10) {
            this.f11423a.f11422d = z10;
            return this;
        }

        public a c(View.OnClickListener onClickListener) {
            this.f11423a.f11419a = onClickListener;
            return this;
        }

        public a d(r3.c cVar) {
            this.f11423a.f11421c = cVar;
            return this;
        }

        public a e(s3.a aVar) {
            this.f11423a.f11420b = aVar;
            return this;
        }
    }
}
