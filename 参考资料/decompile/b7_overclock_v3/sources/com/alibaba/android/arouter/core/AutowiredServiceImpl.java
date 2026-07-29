package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import j3.b;
import java.util.ArrayList;
import java.util.List;
import l4.f;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache<String, ISyringe> f11197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f11198b;

    @Override // com.alibaba.android.arouter.facade.service.AutowiredService
    public void autowire(Object obj) {
        o(obj, null);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        this.f11197a = new LruCache<>(50);
        this.f11198b = new ArrayList();
    }

    public final void o(Object obj, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        ISyringe iSyringeP = p(cls);
        if (iSyringeP != null) {
            iSyringeP.inject(obj);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass.getName().startsWith(f.f39447b)) {
            return;
        }
        o(obj, superclass);
    }

    public final ISyringe p(Class<?> cls) {
        String name = cls.getName();
        try {
            if (this.f11198b.contains(name)) {
                return null;
            }
            ISyringe iSyringe = this.f11197a.get(name);
            if (iSyringe == null) {
                iSyringe = (ISyringe) Class.forName(cls.getName() + b.f36043g).getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            this.f11197a.put(name, iSyringe);
            return iSyringe;
        } catch (Exception unused) {
            this.f11198b.add(name);
            return null;
        }
    }
}
