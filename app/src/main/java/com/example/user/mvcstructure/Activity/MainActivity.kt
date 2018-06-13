package com.example.user.mvcstructure.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.user.mvcstructure.R
import com.example.user.mvcstructure.fragment.FragmentSecond
import com.example.user.mvcstructure.fragment.MainFragment
import com.example.user.mvcstructure.util.SceenUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val screenWidth:Int =SceenUtil.getInstance().screenWidth
        //val screenHeight:Int =SceenUtil.getInstance().screenHeght
        //val toast:Toast = Toast.makeText(this,screenWidth,Toast.LENGTH_SHORT)
        //toast.show()

        if (savedInstanceState == null) {

            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer,
                            MainFragment.newInstance(123),
                            "MainFragment")
                    .commit()
            val secondFragment: FragmentSecond = FragmentSecond.newInstance()
            supportFragmentManager.beginTransaction().add(
                    R.id.contentContainer,
                    secondFragment,
                    "SecondFragment").detach(secondFragment).commit()
        }


    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragment: MainFragment =
                    supportFragmentManager
                            .findFragmentByTag("MainFragment")
                            as MainFragment

            fragment.setHelloText("Woo Hoo" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" +
                    "Woo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\nWoo Hoo\n" )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_second_fragment -> {
                val fragment: Fragment = supportFragmentManager
                        .findFragmentById(R.id.contentContainer)
                if ((fragment is FragmentSecond) == false){
                    supportFragmentManager.beginTransaction()
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right)
                            .replace(R.id.contentContainer,
                                    FragmentSecond.newInstance())
                            .addToBackStack(null)
                            .commit()


                    var toast: Toast = Toast.makeText(this, "Second Fragment",
                            Toast.LENGTH_SHORT)
                    toast.show()

                }

                return true
            }
            R.id.action_first_tab -> {
                val mainFragment: MainFragment = supportFragmentManager
                        .findFragmentByTag("MainFragment") as MainFragment
                val secondFragment: FragmentSecond = supportFragmentManager
                        .findFragmentByTag("SecondFragment")  as  FragmentSecond
                supportFragmentManager.beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit()

                return true
            }
            R.id.action_second_tab -> {
                val mainFragment: MainFragment = supportFragmentManager
                        .findFragmentByTag("MainFragment") as MainFragment
                val secondFragment: FragmentSecond = supportFragmentManager
                        .findFragmentByTag("SecondFragment") as FragmentSecond

                supportFragmentManager.beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit()


                return true
            }
            else->{
                var toast: Toast = Toast.makeText(this, "wrong",
                        Toast.LENGTH_SHORT)
                toast.show()
            }

        }



        return super.onOptionsItemSelected(item)
    }
}
