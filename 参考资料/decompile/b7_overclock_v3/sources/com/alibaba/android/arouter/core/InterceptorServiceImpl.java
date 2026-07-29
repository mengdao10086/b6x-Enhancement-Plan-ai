package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import g3.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f11200b = new Object();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Postcard f11201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterceptorCallback f11202b;

        public a(Postcard postcard, InterceptorCallback interceptorCallback) {
            this.f11201a = postcard;
            this.f11202b = interceptorCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            i3.a aVar = new i3.a(d.f29004f.size());
            try {
                InterceptorServiceImpl.o(0, aVar, this.f11201a);
                aVar.await(this.f11201a.getTimeout(), TimeUnit.SECONDS);
                if (aVar.getCount() > 0) {
                    this.f11202b.onInterrupt(new HandlerException("The interceptor processing timed out."));
                } else if (this.f11201a.getTag() != null) {
                    this.f11202b.onInterrupt((Throwable) this.f11201a.getTag());
                } else {
                    this.f11202b.onContinue(this.f11201a);
                }
            } catch (Exception e10) {
                this.f11202b.onInterrupt(e10);
            }
        }
    }

    public static class b implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.a f11204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Postcard f11206c;

        public b(i3.a aVar, int i10, Postcard postcard) {
            this.f11204a = aVar;
            this.f11205b = i10;
            this.f11206c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            this.f11204a.countDown();
            InterceptorServiceImpl.o(this.f11205b + 1, this.f11204a, postcard);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            Postcard postcard = this.f11206c;
            if (th2 == null) {
                th2 = new HandlerException("No message.");
            }
            postcard.setTag(th2);
            this.f11204a.a();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11207a;

        public c(Context context) {
            this.f11207a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j3.d.b(d.f29003e)) {
                Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it2 = d.f29003e.entrySet().iterator();
                while (it2.hasNext()) {
                    Class<? extends IInterceptor> value = it2.next().getValue();
                    try {
                        IInterceptor iInterceptorNewInstance = value.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iInterceptorNewInstance.init(this.f11207a);
                        d.f29004f.add(iInterceptorNewInstance);
                    } catch (Exception e10) {
                        throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e10.getMessage() + "]");
                    }
                }
                boolean unused = InterceptorServiceImpl.f11199a = true;
                h3.a.f30402e.info("ARouter::", "ARouter interceptors init over.");
                synchronized (InterceptorServiceImpl.f11200b) {
                    InterceptorServiceImpl.f11200b.notifyAll();
                }
            }
        }
    }

    public static void o(int i10, i3.a aVar, Postcard postcard) {
        if (i10 < d.f29004f.size()) {
            d.f29004f.get(i10).process(postcard, new b(aVar, i10, postcard));
        }
    }

    public static void s() {
        synchronized (f11200b) {
            while (!f11199a) {
                try {
                    f11200b.wait(10000L);
                } catch (InterruptedException e10) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e10.getMessage() + "]");
                }
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        if (!j3.d.b(d.f29003e)) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        s();
        if (f11199a) {
            g3.c.f28996b.execute(new a(postcard, interceptorCallback));
        } else {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        g3.c.f28996b.execute(new c(context));
    }
}
