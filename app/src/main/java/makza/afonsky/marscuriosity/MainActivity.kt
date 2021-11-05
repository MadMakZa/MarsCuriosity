package makza.afonsky.marscuriosity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import makza.afonsky.marscuriosity.ui.main.MainFragment
import makza.afonsky.marscuriosity.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = MainActivityBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

    }
}