package com.cursosandroidant.mdc

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosandroidant.mdc.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar

/****
 * Project: MDC
 * From: com.cursosandroidant.mdc
 * Created by Alain Nicolás Tello on 27/01/23 at 14:45
 * All rights reserved 2023.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_scrolling)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }*/
        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show()
        }

        binding.content.btnSkip.setOnClickListener { binding.content.cvAd.visibility = View.GONE }

        binding.content.btnBuy.setOnClickListener {
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go) {
                    Toast.makeText(this, R.string.card_historial, Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        loadImage()

        binding.content.cbEnablePass.setOnClickListener{
            binding.content.tilPassword.isEnabled = !binding.content.tilPassword.isEnabled
        }

        binding.content.cbEnablePass.isChecked

        binding.content.etUrl.onFocusChangeListener = View.OnFocusChangeListener { _, focused ->
            var errorStr: String? = null
            val url = binding.content.etUrl.text.toString()

            if (!focused){
                when {
                    url.isEmpty() -> {
                        //errorStr = getString(R.string.card_required)
                        binding.content.tilUrl.error = getString(R.string.card_required)
                    }
                    URLUtil.isValidUrl(url) -> {
                        loadImage(url)
                    }
                    else -> {
                        errorStr = getString(R.string.card_invalid_url)
                    }
                }
            }

            binding.content.tilUrl.error = errorStr
        }

        binding.content.toogleButton.addOnButtonCheckedListener { _, checkedId, _ ->
            binding.content.root.setBackgroundColor(
                when(checkedId){
                    R.id.btnRed -> Color.RED
                    R.id.btnBlue -> Color.BLUE
                    else -> Color.GREEN
                }
            )
        }

        binding.content.swFab.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked){
                button.text = getString(R.string.card_hide_fab)
                binding.fab.show()
            } else {
                button.text = getString(R.string.card_show_fab)
                binding.fab.hide()
            }
        }

        binding.content.sldVol.addOnChangeListener { slider, value, fromUser ->
            binding.content.tvSubtitle.text = "Vol: $value"
        }

        binding.content.cpEmail.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked){
                Toast.makeText(this, "${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }
        binding.content.cpEmail.setOnCloseIconClickListener {
            binding.content.cpEmail.visibility = View.GONE
        }
    }

    private fun loadImage(url: String = "https://i.ytimg.com/vi/uNhAHzUpsXQ/hqdefault.jpg"){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.content.imgCover)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}