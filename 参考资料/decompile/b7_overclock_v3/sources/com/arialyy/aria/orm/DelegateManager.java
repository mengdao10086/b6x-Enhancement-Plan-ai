package com.arialyy.aria.orm;

import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
class DelegateManager {
    private static volatile DelegateManager INSTANCE;
    private final String TAG = "ModuleFactory";
    private SparseArray<AbsDelegate> mDelegates = new SparseArray<>();

    private DelegateManager() {
    }

    public static DelegateManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DelegateManager.class) {
                INSTANCE = new DelegateManager();
            }
        }
        return INSTANCE;
    }

    public <M extends AbsDelegate> M getDelegate(Class<M> cls) {
        M mNewInstance;
        M m10 = (M) this.mDelegates.get(cls.hashCode());
        if (m10 == null) {
            try {
                Constructor<M> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                mNewInstance = declaredConstructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e10) {
                e = e10;
            } catch (InstantiationException e11) {
                e = e11;
            } catch (NoSuchMethodException e12) {
                e = e12;
            } catch (InvocationTargetException e13) {
                e = e13;
            }
            try {
                this.mDelegates.put(cls.hashCode(), mNewInstance);
                return mNewInstance;
            } catch (IllegalAccessException e14) {
                e = e14;
                m10 = mNewInstance;
                e.printStackTrace();
                return m10;
            } catch (InstantiationException e15) {
                e = e15;
                m10 = mNewInstance;
                e.printStackTrace();
                return m10;
            } catch (NoSuchMethodException e16) {
                e = e16;
                m10 = mNewInstance;
                e.printStackTrace();
                return m10;
            } catch (InvocationTargetException e17) {
                e = e17;
                m10 = mNewInstance;
                e.printStackTrace();
                return m10;
            }
        }
        return m10;
    }
}
