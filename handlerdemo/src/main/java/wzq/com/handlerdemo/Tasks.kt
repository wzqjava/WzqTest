package wzq.com.handlerdemo

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

/**
 * 一些任务：需要运行在进程的UI主线程，或者运行在进程的HandlerThread
 */
object Tasks {

    private var sMainHandler: Handler? = null

    private val sLock = Any()

    private var sThreadHandler: Handler? = null


    fun post2UI(r: Runnable): Boolean {
        return sMainHandler!!.post(r)
    }


    fun postDelayed2UI(r: Runnable, delayMillis: Long): Boolean {
        return sMainHandler!!.postDelayed(r, delayMillis)
    }

    /**
     * 取消UI线程任务
     */
    fun cancelTask(r: Runnable) {
        initThread()
        sMainHandler!!.removeCallbacks(r)
    }


    fun post2Thread(r: Runnable): Boolean {
        initThread()
        return sThreadHandler!!.post(r)
    }


    fun postDelayed2Thread(r: Runnable, delayMillis: Long): Boolean {
        initThread()
        return sThreadHandler!!.postDelayed(r, delayMillis)
    }

    /**
     * 取消后台线程任务
     */
    fun cancelThreadTask(r: Runnable) {
        initThread()
        sThreadHandler!!.removeCallbacks(r)
    }

    /**
     * 内部接口
     */
    fun init() {
        sMainHandler = Handler(Looper.getMainLooper())
    }

    private fun initThread() {
            // todo 添加锁;
//        synchronized(sLock) {}
            if (sThreadHandler == null) {
                val handlerThread = HandlerThread("daemon-handler-thread")
                handlerThread.start()
                sThreadHandler = Handler(handlerThread.looper)
            }
        }

}
