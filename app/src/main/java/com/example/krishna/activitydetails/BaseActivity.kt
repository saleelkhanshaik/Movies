package com.example.krishna.activitydetails

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity


 open class BaseActivity: AppCompatActivity() {
    protected var activityManager: ActivityManager? = null
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activityManager == null) {
            activityManager =
                getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        }
    }
    protected fun getAppTaskState(): String? {
        val stringBuilder = StringBuilder()
        val totalNumberOfTasks =
            activityManager!!.getRunningTasks(10).size //Returns total number of tasks - stacks
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo =
            activityManager!!.getRunningTasks(10) //returns List of RunningTaskInfo - corresponding to tasks - stacks
        for (info in taskInfo) {
            stringBuilder.append("Task Id: " + info.id + ", Number of Activities : " + info.numActivities + "\n") //Number of Activities in task - stack
            // Display the root Activity of task-stack
            stringBuilder.append(
                "TopActivity: " + info.topActivity!!.className.replace(
                    "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                    ""
                ) + "\n"
            )
            // Display the top Activity of task-stack
            stringBuilder.append(
                "BaseActivity:" + info.baseActivity!!.className.replace(
                    "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                    ""
                ) + "\n"
            )
            stringBuilder.append("\n\n")
        }
        return stringBuilder.toString()
    }

    open protected fun getNumberOfTasks(): Int {
        return activityManager!!.appTasks.size
    }
}