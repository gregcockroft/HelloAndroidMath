package com.agog.hellomath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.agog.hellomath.R.layout.activity_main
import com.agog.mathdisplay.MTMathView
import com.agog.mathdisplay.parse.MTParseError
import com.agog.mathdisplay.parse.MTParseErrors
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        // We are going to not display parse errors visibly
        mathview.displayErrorInline = false

        mathview.latex = "x = \\frac{-b \\pm \\sqrt{b^2-4ac}}{2a}"
        mathview.fontSize = MTMathView.convertDpToPixel(28.0f)

        // Check to make sure the latex string was well formatted
        assertEquals("Parse Error", MTParseErrors.ErrorNone, mathview.lastError.errorcode)

    }
}
