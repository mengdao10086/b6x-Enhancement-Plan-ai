package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import g.b0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements RequestCoordinator, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final RequestCoordinator f12740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile e f12741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f12742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("requestLock")
    public RequestCoordinator.RequestState f12743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0("requestLock")
    public RequestCoordinator.RequestState f12744f;

    public b(Object obj, @p0 RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f12743e = requestState;
        this.f12744f = requestState;
        this.f12739a = obj;
        this.f12740b = requestCoordinator;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(e eVar) {
        synchronized (this.f12739a) {
            if (eVar.equals(this.f12742d)) {
                this.f12744f = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f12740b;
                if (requestCoordinator != null) {
                    requestCoordinator.a(this);
                }
                return;
            }
            this.f12743e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator.RequestState requestState = this.f12744f;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f12744f = requestState2;
                this.f12742d.h();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean b() {
        boolean z10;
        synchronized (this.f12739a) {
            z10 = this.f12741c.b() || this.f12742d.b();
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z10;
        synchronized (this.f12739a) {
            z10 = l() && j(eVar);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f12743e = requestState;
            this.f12741c.clear();
            if (this.f12744f != requestState) {
                this.f12744f = requestState;
                this.f12742d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean d(e eVar) {
        if (!(eVar instanceof b)) {
            return false;
        }
        b bVar = (b) eVar;
        return this.f12741c.d(bVar.f12741c) && this.f12742d.d(bVar.f12742d);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean e(e eVar) {
        boolean z10;
        synchronized (this.f12739a) {
            z10 = m() && j(eVar);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean f() {
        boolean z10;
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = this.f12743e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z10 = requestState == requestState2 && this.f12744f == requestState2;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.f12739a) {
            if (eVar.equals(this.f12741c)) {
                this.f12743e = RequestCoordinator.RequestState.SUCCESS;
            } else if (eVar.equals(this.f12742d)) {
                this.f12744f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f12740b;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f12739a) {
            RequestCoordinator requestCoordinator = this.f12740b;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = this.f12743e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f12743e = requestState2;
                this.f12741c.h();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z10;
        synchronized (this.f12739a) {
            z10 = k() && j(eVar);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z10;
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = this.f12743e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            z10 = requestState == requestState2 || this.f12744f == requestState2;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = this.f12743e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            z10 = requestState == requestState2 || this.f12744f == requestState2;
        }
        return z10;
    }

    @b0("requestLock")
    public final boolean j(e eVar) {
        return eVar.equals(this.f12741c) || (this.f12743e == RequestCoordinator.RequestState.FAILED && eVar.equals(this.f12742d));
    }

    @b0("requestLock")
    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f12740b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @b0("requestLock")
    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f12740b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @b0("requestLock")
    public final boolean m() {
        RequestCoordinator requestCoordinator = this.f12740b;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    public void n(e eVar, e eVar2) {
        this.f12741c = eVar;
        this.f12742d = eVar2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f12739a) {
            RequestCoordinator.RequestState requestState = this.f12743e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f12743e = RequestCoordinator.RequestState.PAUSED;
                this.f12741c.pause();
            }
            if (this.f12744f == requestState2) {
                this.f12744f = RequestCoordinator.RequestState.PAUSED;
                this.f12742d.pause();
            }
        }
    }
}
