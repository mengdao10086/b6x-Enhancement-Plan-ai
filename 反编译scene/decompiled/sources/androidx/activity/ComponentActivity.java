package androidx.activity;

import a.gb;
import a.hn;
import a.in;
import a.kn;
import a.nn;
import a.oq;
import a.pq;
import a.s;
import a.un;
import a.xn;
import a.yn;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ComponentActivity extends gb implements kn, yn, pq, s {
    public int mContentLayoutId;
    public xn mViewModelStore;
    public final nn mLifecycleRegistry = new nn(this);
    public final oq mSavedStateRegistryController = oq.a(this);
    public final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xn f8133a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f3952a;
    }

    public ComponentActivity() {
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a(new in() { // from class: androidx.activity.ComponentActivity.2
                @Override // a.in
                public void a(kn knVar, hn.a aVar) {
                    if (aVar == hn.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new in() { // from class: androidx.activity.ComponentActivity.3
            @Override // a.in
            public void a(kn knVar, hn.a aVar) {
                if (aVar != hn.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().a();
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (19 > i || i > 23) {
            return;
        }
        getLifecycle().a(new ImmLeaksCleaner(this));
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f3952a;
        }
        return null;
    }

    @Override // a.gb, a.kn
    public hn getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // a.s
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // a.pq
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // a.yn
    public xn getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mViewModelStore == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.mViewModelStore = bVar.f8133a;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new xn();
            }
        }
        return this.mViewModelStore;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    @Override // a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.c(bundle);
        un.e(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        xn xnVar = this.mViewModelStore;
        if (xnVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            xnVar = bVar.f8133a;
        }
        if (xnVar == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f3952a = objOnRetainCustomNonConfigurationInstance;
        bVar2.f8133a = xnVar;
        return bVar2;
    }

    @Override // a.gb, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        hn lifecycle = getLifecycle();
        if (lifecycle instanceof nn) {
            ((nn) lifecycle).p(hn.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
    }
}
