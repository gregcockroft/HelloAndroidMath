package com.agog.hellomath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agog.hellomath.databinding.ActivityMainBinding
import com.agog.mathdisplay.MTMathView
import com.agog.mathdisplay.parse.MTParseErrors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // We are going to not display parse errors visibly
        binding.mathview.displayErrorInline = false

        binding.mathview.latex = "x = \\frac{-b \\pm \\sqrt{b^2-4ac}}{2a}"
        binding.mathview.fontSize = MTMathView.convertDpToPixel(28.0f)

        // Check to make sure the latex string was well formatted
        check(binding.mathview.lastError.errorcode == MTParseErrors.ErrorNone) { "Parse Error" }
    }
}
