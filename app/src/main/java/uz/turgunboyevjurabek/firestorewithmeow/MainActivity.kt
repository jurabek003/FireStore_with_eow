package uz.turgunboyevjurabek.firestorewithmeow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import uz.turgunboyevjurabek.firestorewithmeow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        val bottomNavigation =binding.bottomNavigation
        val navHostController=supportFragmentManager.findFragmentById(R.id.my_navigation_host) as NavHostFragment
        val navController=navHostController.navController
        val bottomNavigationItems = mutableListOf(
            CurvedBottomNavigation.Model(R.id.homeFragment, getString(R.string.home), R.drawable.ic_home),
            CurvedBottomNavigation.Model(R.id.settingsFragment, getString(R.string.offers), R.drawable.ic_settings),
            CurvedBottomNavigation.Model(R.id.addFragment, getString(R.string.sections), R.drawable.ic_add),
        )
        bottomNavigation.apply {
            bottomNavigationItems.forEach { add(it) }
            setOnClickMenuListener {
                navController.navigate(it.id)
            }
            setupNavController(navController)
        }
//        for (i in bottomNavigationItems){
//            navController.navigate(bottomNavigationItems[i])
//        }
//        bottomNavigation.setupNavController()
    }
}