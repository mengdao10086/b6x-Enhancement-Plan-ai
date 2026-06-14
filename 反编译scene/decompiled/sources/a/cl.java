package a;

import a.hn;
import a.va;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cl extends ComponentActivity implements va.a, va.c {
    public static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    public static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    public static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    public static final String TAG = "FragmentActivity";
    public boolean mCreated;
    public int mNextCandidateRequestIndex;
    public ja<String> mPendingFragmentActivityResults;
    public boolean mRequestedPermissionsFromFragment;
    public boolean mResumed;
    public boolean mStartedActivityFromFragment;
    public boolean mStartedIntentSenderFromFragment;
    public final el mFragments = el.b(new a());
    public final nn mFragmentLifecycleRegistry = new nn(this);
    public boolean mStopped = true;

    public class a extends gl<cl> implements yn, s {
        public a() {
            super(cl.this);
        }

        @Override // a.dl
        public View b(int i) {
            return cl.this.findViewById(i);
        }

        @Override // a.dl
        public boolean c() {
            Window window = cl.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // a.gl
        public void g(Fragment fragment) {
            cl.this.onAttachFragment(fragment);
        }

        @Override // a.kn
        public hn getLifecycle() {
            return cl.this.mFragmentLifecycleRegistry;
        }

        @Override // a.s
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return cl.this.getOnBackPressedDispatcher();
        }

        @Override // a.yn
        public xn getViewModelStore() {
            return cl.this.getViewModelStore();
        }

        @Override // a.gl
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            cl.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // a.gl
        public LayoutInflater j() {
            return cl.this.getLayoutInflater().cloneInContext(cl.this);
        }

        @Override // a.gl
        public int k() {
            Window window = cl.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // a.gl
        public boolean l() {
            return cl.this.getWindow() != null;
        }

        @Override // a.gl
        public boolean m(Fragment fragment) {
            return !cl.this.isFinishing();
        }

        @Override // a.gl
        public void n(Fragment fragment, Intent intent, int i, Bundle bundle) {
            cl.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        @Override // a.gl
        public void o() {
            cl.this.supportInvalidateOptionsMenu();
        }

        @Override // a.gl
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public cl i() {
            return cl.this;
        }
    }

    public static void e(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public static boolean g(jl jlVar, hn.b bVar) {
        boolean zG = false;
        for (Fragment fragment : jlVar.f()) {
            if (fragment != null) {
                if (fragment.getLifecycle().b().a(hn.b.STARTED)) {
                    fragment.f4254a.p(bVar);
                    zG = true;
                }
                if (fragment.v() != null) {
                    zG |= g(fragment.o(), bVar);
                }
            }
        }
        return zG;
    }

    public final int d(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.l() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.g(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.j(i, fragment.f4267a);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.w(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            zn.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.u().b(str, fileDescriptor, printWriter, strArr);
    }

    public final void f() {
        while (g(getSupportFragmentManager(), hn.b.CREATED)) {
        }
    }

    public jl getSupportFragmentManager() {
        return this.mFragments.u();
    }

    @Deprecated
    public zn getSupportLoaderManager() {
        return zn.b(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.v();
        int i3 = i >> 16;
        if (i3 == 0) {
            va.b bVarJ = va.j();
            if (bVarJ == null || !bVarJ.b(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String strE = this.mPendingFragmentActivityResults.e(i4);
        this.mPendingFragmentActivityResults.k(i4);
        if (strE == null) {
            Log.w(TAG, "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment fragmentT = this.mFragments.t(strE);
        if (fragmentT != null) {
            fragmentT.Z(i & 65535, i2, intent);
            return;
        }
        Log.w(TAG, "Activity result no fragment exists for who: " + strE);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.v();
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mFragments.a(null);
        if (bundle != null) {
            this.mFragments.x(bundle.getParcelable(FRAGMENTS_TAG));
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new ja<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.j(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new ja<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(hn.a.ON_CREATE);
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.i(hn.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.j(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.i(hn.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.n(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, a.va.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.v();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strE = this.mPendingFragmentActivityResults.e(i3);
            this.mPendingFragmentActivityResults.k(i3);
            if (strE == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentT = this.mFragments.t(strE);
            if (fragmentT != null) {
                fragmentT.y0(i & 65535, strArr, iArr);
                return;
            }
            Log.w(TAG, "Activity result no fragment exists for who: " + strE);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.v();
        this.mFragments.s();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(hn.a.ON_RESUME);
        this.mFragments.p();
    }

    @Override // androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f();
        this.mFragmentLifecycleRegistry.i(hn.a.ON_STOP);
        Parcelable parcelableY = this.mFragments.y();
        if (parcelableY != null) {
            bundle.putParcelable(FRAGMENTS_TAG, parcelableY);
        }
        if (this.mPendingFragmentActivityResults.l() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.l()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.l()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.l(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.i(i);
                strArr[i] = this.mPendingFragmentActivityResults.m(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.v();
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.i(hn.a.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.v();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        f();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.i(hn.a.ON_STOP);
    }

    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            va.m(this, strArr, i);
            return;
        }
        e(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            va.m(this, strArr, ((d(fragment) + 1) << 16) + (i & 65535));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(wb wbVar) {
        va.n(this, wbVar);
    }

    public void setExitSharedElementCallback(wb wbVar) {
        va.o(this, wbVar);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            e(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            e(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        try {
            if (i == -1) {
                va.p(this, intent, -1, bundle);
            } else {
                e(i);
                va.p(this, intent, ((d(fragment) + 1) << 16) + (i & 65535), bundle);
            }
        } finally {
            this.mStartedActivityFromFragment = false;
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            e(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            e(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        try {
            if (i == -1) {
                va.q(this, intentSender, i, intent, i2, i3, i4, bundle);
            } else {
                e(i);
                va.q(this, intentSender, ((d(fragment) + 1) << 16) + (i & 65535), intent, i2, i3, i4, bundle);
            }
        } finally {
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        va.i(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        va.k(this);
    }

    public void supportStartPostponedEnterTransition() {
        va.r(this);
    }

    @Override // a.va.c
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment || i == -1) {
            return;
        }
        e(i);
    }
}
