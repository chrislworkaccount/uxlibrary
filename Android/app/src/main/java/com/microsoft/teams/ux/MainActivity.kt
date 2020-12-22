package com.microsoft.teams.ux

//import com.example.ux.motion.Motion
//import com.example.ux.motion.MotionType
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
	  super.onCreate(savedInstanceState)
	  setContentView(R.layout.activity_main)
	  //setSupportActionBar(findViewById(R.id.toolbar))
	   //findViewById<LottieAnimationView>(R.id.animation).playAnimation()
//
//	  findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//		 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//				 .setAction("Action", null).show()
//		 val onBoarding = Illustration(Vertical.EDU, Theme.DARK, Key.EDU_FRE_ONBOARDING)
//		 val welcomeStreen = Illustration(Vertical.EDU, Theme.DARK, Key.EDU_FRE_WELCOME_SCREEN)
//		 val chatsEmptyState = Illustration(Vertical.EDU, Theme.DARK, Key.CHATS_ACTIVITY_EMPTY_STATE)
//		  val view : View = View(this)
//
//		 val chatsEmptyStateMotion = ConstraintSet.Motion(chatsEmptyState)
//				 .alpha(MotionType.FADE_IN)
//				 .scale(MotionType.SCALE_UP)
//				 .blur(MotionType.BLUR_IN)
//
//		 val overlayMotionView : View = View(this)
//
//		 val onBoarding = ConstraintSet.Motion(Key.EDU_FRE_ONBOARDING).withColorFilter(Theme.DARK)
//		 ConstraintSet.Motion.disableAnimation()
//		 ConstraintSet.Motion.enabledAnimation()
//
//		  val croppedGif: Bitmap? = UXUtils().cropImageToRect(bubbleGif, edges)
//		  val croppedView: View? = UXUtils().cropViewToRect(viewToCrop, edges)
//		  val rotatedView: View? = UXUtils().rotateViewByDegrees(croppedView, -180)
//
//
//		  val motionPlayer = ConstraintSet.Motion()
//			  .applyTo(overlayMotionView, MotionType.SCALE_DOWN, MotionType.FADE_OUT)
//			  .applyTo(chatsEmptyState, MotionType.BLUR_OUT)
//			  .onEnd(Runnable {
//				  createNewChat()
//			  })
//			  .syncronizeWithKeyboard().build()
//		  motionPlayer.play()
//
//	  }
   }

	fun createNewChat(){}
   override fun onCreateOptionsMenu(menu: Menu): Boolean {
	  // Inflate the menu; this adds items to the action bar if it is present.
	  menuInflater.inflate(R.menu.menu_main, menu)
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