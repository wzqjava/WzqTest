package wzq.com.handlerdemo

import android.app.Application

/**
 *
 * 作者：wzq
 *
 *
 *
 * 创建时间：2019-10-01
 *
 *
 *
 * 文件描述：
 *
 *
 */
class MApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Tasks.init()
    }
}
