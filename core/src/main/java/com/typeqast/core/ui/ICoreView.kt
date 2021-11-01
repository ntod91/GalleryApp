package com.typeqast.core.ui


interface ICoreView {
    /**
     * Provides DataBinding variable name defined in all layouts
     * This has to be define into the Base class of Activity or Fragment
     */
    fun provideBindingId(): Int = 0

    /**
     * Show toast message to the user
     */
    fun showMessage(message: String?)

    /**
     * With define Status in Resource class, here can be handled error messages dialogs
     */
    fun processUIStatus(status: Int)

    /**
     * Implements logic of the custom progress while waiting for the request process to finish
     */
    fun showDialog()

    /**
     * Implements logic of the custom progress when a requested has been finished
     */
    fun dismissDialog()

    /**
     * All api error will trigger this function
     */
    fun processError(error: Throwable?)

    /**
     * Providing the Simple Cass name of the Activity will log if any error occurs while api call executes into the logcat
     */
    fun provideTAG(): String
}