package com.example.drawingline

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.BLACK
import android.graphics.Color.RED
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingLine(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val mainPaint: Paint
    init {
        mainPaint=Paint()
        mainPaint.color= BLACK
    }

    var startX=10f
    var startY=70f
    var stopX=10000000f
    var stopY=100000000f

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(startX,startY,stopX,stopY,mainPaint)
    }
   /*C'est un peu fatiguant de déplacer une droite avec le onTouchEvent
   * car on doit pouvoir déplacer le point de départ et le point d'arrivée
   * dans la meme méthode et donc détecter lorsque c'est le point de départ
   * qu'il faut déplacer ou lorsque c'est le point d'arriveé */

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action==MotionEvent.ACTION_DOWN){
            startX= event!!.x
            startY= event.y
            invalidate()
            return true
        }
        else if (event!!.action==MotionEvent.ACTION_MOVE){
            startX= event!!.x
            startY= event.y
            invalidate()
            return true
        }
        else{return false}

    }

}