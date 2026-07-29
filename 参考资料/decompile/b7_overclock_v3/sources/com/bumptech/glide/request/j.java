package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import g.b0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class j implements RequestCoordinator, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final RequestCoordinator f12756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile e f12758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f12759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("requestLock")
    public RequestCoordinator.RequestState f12760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0("requestLock")
    public RequestCoordinator.RequestState f12761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b0("requestLock")
    public boolean f12762g;

    public j(Object obj, @p0 RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f12760e = requestState;
        this.f12761f = requestState;
        this.f12757b = obj;
        this.f12756a = requestCoordinator;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(e eVar) {
        synchronized (this.f12757b) {
            if (!eVar.equals(this.f12758c)) {
                this.f12761f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f12760e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f12756a;
            if (requestCoordinator != null) {
                requestCoordinator.a(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean b() {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = this.f12759d.b() || this.f12758c.b();
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = k() && eVar.equals(this.f12758c) && !b();
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f12757b) {
            this.f12762g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f12760e = requestState;
            this.f12761f = requestState;
            this.f12759d.clear();
            this.f12758c.clear();
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean d(e eVar) {
        if (!(eVar instanceof j)) {
            return false;
        }
        j jVar = (j) eVar;
        if (this.f12758c == null) {
            if (jVar.f12758c != null) {
                return false;
            }
        } else if (!this.f12758c.d(jVar.f12758c)) {
            return false;
        }
        if (this.f12759d == null) {
            if (jVar.f12759d != null) {
                return false;
            }
        } else if (!this.f12759d.d(jVar.f12759d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean e(e eVar) {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = l() && (eVar.equals(this.f12758c) || this.f12760e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean f() {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = this.f12760e == RequestCoordinator.RequestState.CLEARED;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.f12757b) {
            if (eVar.equals(this.f12759d)) {
                this.f12761f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f12760e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.f12756a;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
            if (!this.f12761f.isComplete()) {
                this.f12759d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f12757b) {
            RequestCoordinator requestCoordinator = this.f12756a;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f12757b) {
            this.f12762g = true;
            try {
                if (this.f12760e != RequestCoordinator.RequestState.SUCCESS) {
                    RequestCoordinator.RequestState requestState = this.f12761f;
                    RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.f12761f = requestState2;
                        this.f12759d.h();
                    }
                }
                if (this.f12762g) {
                    RequestCoordinator.RequestState requestState3 = this.f12760e;
                    RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState3 != requestState4) {
                        this.f12760e = requestState4;
                        this.f12758c.h();
                    }
                }
            } finally {
                this.f12762g = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = j() && eVar.equals(this.f12758c) && this.f12760e != RequestCoordinator.RequestState.PAUSED;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = this.f12760e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f12757b) {
            z10 = this.f12760e == RequestCoordinator.RequestState.RUNNING;
        }
        return z10;
    }

    @b0("requestLock")
    public final boolean j() {
        RequestCoordinator requestCoordinator = this.f12756a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @b0("requestLock")
    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f12756a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @b0("requestLock")
    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f12756a;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    public void m(e eVar, e eVar2) {
        this.f12758c = eVar;
        this.f12759d = eVar2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f12757b) {
            if (!this.f12761f.isComplete()) {
                this.f12761f = RequestCoordinator.RequestState.PAUSED;
                this.f12759d.pause();
            }
            if (!this.f12760e.isComplete()) {
                this.f12760e = RequestCoordinator.RequestState.PAUSED;
                this.f12758c.pause();
            }
        }
    }
}
