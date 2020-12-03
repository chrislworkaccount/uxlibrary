# uxlibrary

Illustration Components
		 
     I don't care where the illustration comes from I just know which one I want :)
     Kotlin: Android
     val chatsEmptyState = Illustration(Vertical.EDU, Theme.DARK, Key.CHATS_ACTIVITY_EMPTY_STATE)
     
     Swift: iOS
     val chatsEmptyState = Illustration(Vertical.EDU, Theme.DARK, Key.CHATS_ACTIVITY_EMPTY_STATE)
     
     React Native
     val chatsEmptyState = Illustration(Vertical.EDU, Theme.DARK, Key.CHATS_ACTIVITY_EMPTY_STATE)
     
Motion Components
    
    I don't care what the duration, scale factor, alpha transition etc.. is. Just play my animation :)
    Kotlin:Android
    val chatsEmptyStateMotion = Motion(chatsEmptyState)
				 .alpha(MotionType.FADE_IN)
				 .scale(MotionType.SCALE_UP)
				 .blur(MotionType.BLUR_IN)
    
    chatsEmptyStateMotion.play()
    
    I only need one lottie animation?...you tell me how to color it :)
    Lottie: 		 
    val onBoarding = Motion(Key.EDU_FRE_ONBOARDING).withColorFilter(Theme.DARK)

    
    Swift:iOS
    val chatsEmptyStateMotion = Motion(chatsEmptyState)
				 .alpha(MotionType.FADE_IN)
				 .scale(MotionType.SCALE_UP)
				 .blur(MotionType.BLUR_IN)
    
    chatsEmptyStateMotion.play()
    
    Lottie: 		 
    val onBoarding = Motion(Key.EDU_FRE_ONBOARDING).withColorFilter(Theme.DARK)
    
    React Native
    val chatsEmptyStateMotion = Motion(chatsEmptyState)
				 .alpha(MotionType.FADE_IN)
				 .scale(MotionType.SCALE_UP)
				 .blur(MotionType.BLUR_IN)
    
    chatsEmptyStateMotion.play()
    
    Lottie: 		 
    val onBoarding = Motion(Key.EDU_FRE_ONBOARDING).withColorFilter(Theme.DARK)
    
General UX

     UX library you can handle all the optimizations
     Kotlin:Android
     val imageEdges: Edge = Edge(0, 100, 200, 300)
		 val croppedImage = UXUtils().cropImageToEdges(image, imageEdges)
     
     Swift:iOS
     val imageEdges: Edge = Edge(0, 100, 200, 300)
		 val croppedImage = UXUtils().cropImageToEdges(image, imageEdges)
     
     React Native
     val imageEdges: Edge = Edge(0, 100, 200, 300)
		 val croppedImage = UXUtils().cropImageToEdges(image, imageEdges)
