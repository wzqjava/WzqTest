package com.wzq.tablayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * https://github.com/H07000223/FlycoTabLayout
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2.adapter = MyAdapter(supportFragmentManager)
        tabLayout.setViewPager(viewPager2)

    }

    class MyAdapter : FragmentPagerAdapter {
        var fragments: MutableList<Fragment> = ArrayList()

        constructor(fm: FragmentManager) : super(fm) {
            fragments.add(BlankFragment1())
            fragments.add(BlankFragment2())
            fragments.add(BlankFragment3())
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int = fragments.size
        override fun getPageTitle(position: Int): CharSequence? {
            return "xxxxx"
        }
    }


}
