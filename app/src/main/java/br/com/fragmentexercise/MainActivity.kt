package br.com.fragmentexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import br.com.fragmentexercise.fragments.ConsoleFragment
import br.com.fragmentexercise.fragments.GameFragment
import br.com.fragmentexercise.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var gameFragment: GameFragment
    private lateinit var consoleFragment: ConsoleFragment

    private lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        gameFragment = GameFragment()
        consoleFragment = ConsoleFragment()

        bottomNavigationView = findViewById(R.id.botton_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(homeFragment)

    }

    private fun setFragment(fragment: Fragment){
        val fragmentTransAction = supportFragmentManager.beginTransaction()
        fragmentTransAction.replace(R.id.frame_fragments, fragment)
        fragmentTransAction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home ->{
                setFragment(homeFragment)
            }
            R.id.menu_game ->{
                setFragment(gameFragment)
            }
            R.id.menu_console ->{
                setFragment(consoleFragment)
            }
        }
        return true
    }

}