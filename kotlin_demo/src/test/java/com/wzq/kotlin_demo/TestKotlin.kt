package com.wzq.kotlin_demo

import org.junit.Test

/**
 *
 * 作者：王志强
 * 创建时间：2020/8/3
 * 文件描述：
 */
class TestKotlin {
    interface MInterface {
        fun start()
        fun end()
    }
    /**
     * 从源码let函数的结构来看它是只有一个lambda函数块block作为参数的函数,调用T类型对象的let函数，则该对象为函数的参数。
     * 在函数块内可以通过 it 指代该对象。
     * 返回值为函数块的最后一行或指定return表达式。
     */
    /**
     * 特定的作用域   --->let扩展函数的实际上是一个作用域函数，当你需要去定义一个变量在一个特定的作用域范围内，let函数的是一个不错的选择；
     * 判断null     --->let函数另一个作用就是可以避免写一些判断null的操作。
     * object.let{
    it.todo()//在函数体内使用it替代object对象去访问其公有的属性和方法
    ...
    }

    //另一种用途 判断object为null的操作
    object?.let{//表示object不为null的条件下，才会去执行let函数体
    it.todo()
    }

     */
    @Test
    fun testLet() {
        val result = "testLet".let {
            println(it.length)
            1000
        }
        println(result)
    }
    //------------------------------------------
    //------------------
    /**
     *  with(object){
    //todo
    }
    省去类名重复--> let需要用it, with可以直接用属性和方法
    with函数和前面的几个函数使用方式略有不同，因为它不是以扩展的形式存在的。它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。
    返回值为函数块的最后一行或指定return表达式。
    适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，
    经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
    val item = getItem(position)?: return

    with(item){

    holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
    holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
    holder.tvExtraInf.text = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"

    }
     */
    @Test
    fun testWith() {
        val user = User("Kotlin", 1, "1111111")
        val result1 = with(user, {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        })
        /* val result2 = with(user) {
             println("my name is $name, I am $age years old, my phone number is $phoneNum")
             1000
         }*/
        println("result: $result1")
        //        println("result: $result2")
    }
    // -----------------------
    /**
     * run函数实际上可以说是let和with两个函数的结合体，
     * run函数只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。
     * 适用于let,with函数任何场景。-->
     * 因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，
     * 在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
     */
    @Test
    fun testRun() {
        val user = User("Kotlin", 30, "1560132")
        // 这个对象只能用this来代替
        val result = user.run {
            println("my name is $this.name, I am $age years old, my phone number is $phoneNum ")
            1000
        }
        println("result: $result")
    }
    // -----------------------
    /**
     * 从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，
     * run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。
     * apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，
     * 这种情景非常常见。特别是在我们开发中会有一些数据model向ViewModel转化实例化的过程中需要用到。
     *
     * apply适用于多层判空问题
     */
    @Test
    fun testApply() {
        val user = User("Kotlin", 1, "1111111")
        val result = user.apply {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")
    }
    /*
        给变量赋值
        mSheetDialogView = View.inflate(activity, R.layout.biz_exam_plan_layout_sheet_inner, null).apply{
            course_comment_tv_label.paint.isFakeBoldText = true
            course_comment_tv_score.paint.isFakeBoldText = true
            course_comment_tv_cancel.paint.isFakeBoldText = true
            course_comment_tv_confirm.paint.isFakeBoldText = true
            course_comment_seek_bar.max = 10
            course_comment_seek_bar.progress = 0
    */
    //--------------------------
    /**
     * also函数的inline+lambda结构
     *also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，
     * 如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身,一般可用于多个扩展函数链式调用
     */
    @Test
    fun testAlso() {
        val result = "testLet".also {
            println(it.length)
            1000
        }
        println(result)
    }

    //--------------------------
    /**
     * 满足条件再执行操作
     */
    @Test
    fun testTakeIf() {
        123.takeIf {
            3 > 2
        }.apply {
            print("条件为真")
        }
    }
    //--------------------------

    /**
     * 满足条件再执行操作
     */
    @Test
    fun testUnLess() {
        123.takeIf {
            3 < 2
        }.apply {
            print("条件为假")
        }
    }



    //--------------------------
    /**
     * repeat就是重复做一些什么事情咯,传3就是从0,1,2 每次操作一次list.add(it),it就是那个0,1,2
     */
    @Test
    fun testRepat() {
        val list = mutableListOf<String>()
        repeat(3) {
            list.add("$it--嘿嘿")
        }
        println(list)
    }
}