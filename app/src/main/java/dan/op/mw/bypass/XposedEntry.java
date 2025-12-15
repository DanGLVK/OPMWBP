package dan.op.mw.bypass;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedEntry implements IXposedHookLoadPackage{

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam)
            throws Throwable {

        // x3.r hook
        try {
            XposedHelpers.findAndHookMethod(
                    "x3.r",
                    lpparam.classLoader,
                    "g",
                    String.class,
                    XC_MethodReplacement.returnConstant(true)
            );

            XposedBridge.log("[PocketStudioUnlock] x3.r whitelist bypassed");

        } catch (Throwable t) {
            XposedBridge.log("[PocketStudioUnlock] x3.r hook failed");
            XposedBridge.log(t);
        }

        // v1.r hook
        try {
            XposedHelpers.findAndHookMethod(
                    "v1.r",
                    lpparam.classLoader,
                    "g",
                    String.class,
                    XC_MethodReplacement.returnConstant(true)
            );

            XposedBridge.log("[PocketStudioUnlock] v1.r whitelist bypassed");

        } catch (Throwable t) {
            XposedBridge.log("[PocketStudioUnlock] v1.r hook failed");
            XposedBridge.log(t);
        }
    }
}
