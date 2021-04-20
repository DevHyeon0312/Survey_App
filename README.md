# Survey_App (개발중)

현재 개발 단계 : ✔ 표시

#### 목차
1. WHY? : 언어 및 기술 선정
    - 왜 코틀린을 사용했는가?
    - 왜 MVVM 패턴을 사용했는가?
    - 왜 Koin 을 사용했는가?
    - 왜 Retrofit2 를 사용했는가?
    - 왜 ViewBinding 과 DataBinding 을 사용했는가?

2. Think : 고민하고 또 고민하다..
    - 패키지 구조
    - BottomNavigation + [ FragmLayout(fragment) vs ViewPager2 ]

3. 기능 ✔
    - 설문등록
    - 설문조회
    - 설문상세조회
    - 설문참여
    - 설문결과확인

4. 상황별 이미지

5. 실행 영상

6. 회고

# 1. WHY? : 언어 및 기술 선정
### 왜 코틀린을 사용했는가?
  처음 언어 선정을 Java 와 Kotlin 중 고민을 많이 하였습니다. 빠르게 개발결과를 내기 위해서는 익숙한 Java 를 선택하고 싶은 심정도 없지 않아 있었습니다.
  그러나, Android 공식언어가 Kotlin 인 상황에 언제까지 Java 만 가지고 개발을 할 수는 없다는 생각이 들었고, 완성까지 시간이 걸리더라도 Kotlin 으로 개발하자고 마음먹었습니다.

### 왜 MVVM 패턴을 사용했는가?
  사실 이정도 기능을 하는 앱에서는 이렇다할 패턴이 존재하지 않는 앱으로 개발을 해도 부담이 없는 기능들일꺼라고 생각합니다. 다른 패턴과 비교해본다면,
  MVC 를 사용하여 개발해도 앱 자체가 작기 때문에 유지보수에서 문제가 된다는 단점은 없다고 봐도 무방하였고,
  MVP 를 사용하여 개발해도 역시, 앱이 작기 때문에 View 와 Presenter 의 의존성이 강해져서 발생하는 문제는 없다고 봐도 무방하였습니다.
  어떤 디자인패턴을 사용해도 무방하다면, 익숙하지 않은 Kotlin 으로 시작하는 김에, 익숙하지 않은 MVVM 으로 같이 시작하자고 결론을 내렸습니다.

### 왜 Koin 을 사용했는가?
  Java 를 선택했다면, Dagger2 를 사용하였을 것입니다. Dagger 와 Koin 모두 의존성 주입을 위해 사용하며, Dagger 의 경우가 현재 더 많이 사용되고 있지만 순수 코틀린으로 개발된 Koin 이
  Kotlin 으로 만드는 프로젝트에 더 적합하다고 생각하였습니다.
  Dagger 와 Koin 의 비교는 한번더 공부허여 글을 작성할 계획을 갖고 있습니다.

### 왜 Retrofit2 를 사용했는가?
  retrofit(retrfit~rxrefrofit) 이 현존하는 RestAPI 라이브러리들 중에서 이슈에 대한 대응과 편리성 등이 뛰어나다고 생각하였습니다. 또한 현재 많은 기업들과 API 사용을 하는 프로젝트들을 보아도 엄청나게 많은 곳에서 retrofit 을 사용하는 만큼 큰 고민없이 선정하게 되었습니다.

### 왜 ViewBinding 과 DataBinding 을 사용했는가?
  Java 로 프로젝트를 하던 당시에 Viewvinding 와 DataBinding 을 알게 되었습니다. Kotlin 의 경우 Kotlin extensions 이 존재하지만 이 역시 null 에 safety 하지는 않기 때문에 ViewBinding 과       DataBinding 을 사용하기로 결정하였습니다.


# 2. Think : 고민하고 또 고민하다..
### 패키지 구조
  사실 지금까지도 계속 고민하고 있는 부분입니다...

  <1번>
  ```
  ui
    -main
      -mainActivity
      -mainViewModel
    -login
      -loginActivity
      -loginViewModel
  ```
  <2번>
  ```
  view
    -activity
      -mainActivity
      -loginActivity
    -fragment
  viewmodel
    -mainViewModel
    -loginViewModel
 ```
  과정을 다 담기에는 너무나 길지만, 가장 큰 고민으로 보자면 위의 단계가 시작이였습니다..

  1번의 case 는 상대적으로 눈에 참 잘들어왔습니다. main 에 대한 작업시 패키지를 크게 벗어나기 않고 추가되는 사용되는 viewmodel 이 무엇인지 바로 알 수 있었기 때문입니다.
  그러나, 1번은 MVP 처럼 V 와 P 가 1:1 로 매칭되는 경우라면 참 좋았겠지만... MVVM 에서 V 와 VM 은 1:1의 관계가 아닙니다..
  상황에따라 1:1 이 될수도, 1:n 이 될수도, n:n 이 될수도... 자유롭게 떼었다?붙였다? 하는 만큼 1번과 같은 구조는 좋지 않아 보였습니다.
  따라서, 2번의 구조를 선택! 하려 했으나.. 그랬으면 고민이라고 말하지 않았겠죠 ㅠㅠ

  2번의 case 는 위에서 보면 참 깔끔해보이지만, 막상 안드로이드스튜디오에서 보는순간 data, di, utils 등 수많은 패키지와 그 하위패키지 가 잔뜩 있는 곳에서 파일이 쌓이고 쌓일때마다..
  뿜어져 나오는 아우라를 감당할 자신이 없어보였습니다. 사실 이정도 크기에서 몇 안되는 Activity 와 Fragment, ViewModel 만 가지고 따라가기 힘들다 할 수는 없겠지만, 그렇다고 이정도 크기에서 MVVM 의 장점을 살리길 원하는 것 자체가 무리가 있다고 생각했습니다. ( 디자인패턴은 역시 상황에 따라 맞춰 쓰는게... MVVM 은 이 프로젝트에 적합하지 않은 것 같아요 휴...)

  위의 단계만 고민했다면 그래도 2번을 선택했겠지만,
  Data 의 패지를 만들고, Netwrok 패키지를 만들고, 그 과정에서 너무나 정신없어지는 느낌이 강하게 들어서 1번을 선택하고 진행하였습니다.

  하지만, API 에 대한 ViewModel 은 진짜 이 Activity 저 Activity 나뉘어져 다니기때문에... 그친구는 그냥 따로 밖으로 빼버렸습니다.. (엉망진창이 되어가고 있어요. 이거 끝까지 해도 될까 싶을정도로..)

  * 결론 : 고민하고 고민하고 또 고민한 끝에 그냥 제 눈에 편한걸 선택했습니다. (부끄럽네요...)

### BottomNavigation + [ FragmLayout(fragment) vs ViewPager2 ]
  사실 이 고민은 기술적인 고민은 아니였습니다.
  그저 어떤 것이 사용자측면 에서 더 친근할까? 에 대한 고민이였습니다. ( 그렇게 좌우로 넘기는게 그래도.. 아니야 홈인데? ) 하는 고민을 이어가던 찰나에
  예전 카카오톡이 떠올랐습니다.
  예전에는 뷰페이저를 사용한 듯 한 홈화면으로 제스처로 화면을 넘나들었습니다. (친구목록과 채팅창 등)
  그러나 한번의 패치 이후 해당 동작은 각 Fragment 내부에서 사용되는 ViewPager or ListItem 의 Swipe Event 처리로 변경되었습니다.

  분명 이유가 존재하겠지만, 현 트렌드에 사람들에게 친숙한 느낌은 홈화면에서는 ViewPager를 쓰면 안되겠다고 생각하였고, 결국 FrameLayout 안에 Fragment 를 두는 쪽을 택하였습니다.

# 3. 주요기능
    1. 설문생성
    2. 설문조회
    3. 미참여한 설문 상세보기
    4. 미참여한 설문 참여하기
    5. 참여한 설문 결과보기
# 4. 상황별 간단 설명 및 이미지
    1. 인트로 : 1sec 간 Intro 화면 이후 Login 으로 넘어갑니다.
<img src="https://user-images.githubusercontent.com/72678200/115424582-ccef4300-a239-11eb-8113-68fc79788c6a.png" width="20%" height="20%">

    2. 로그인 : 로그인하는 순간에 ID 를 자동발급하며, 이때는 Device 시간으로 생성합니다.
<img src="https://user-images.githubusercontent.com/72678200/115424544-c4970800-a239-11eb-9124-6ce767c2c721.png" width="20%" height="20%"> <img src="https://user-images.githubusercontent.com/72678200/115425201-5f8fe200-a23a-11eb-918f-eea089d07b25.png" width="20%" height="20%">
      
    3. 홈 : 설문 생성으로 넘어갈 수 있습니다.
<img src="https://user-images.githubusercontent.com/72678200/115425279-733b4880-a23a-11eb-8696-04e130e76f35.png" width="20%" height="20%"> <img src="https://user-images.githubusercontent.com/72678200/115425287-759da280-a23a-11eb-89cc-97ba6b16c091.png" width="20%" height="20%"> 

    4. 설문참여 : 생성된 설문들의 제목을 보여줍니다.
<img src="https://user-images.githubusercontent.com/72678200/115425294-77fffc80-a23a-11eb-88c3-f7f52cac4427.png" width="20%" height="20%">

    5. 설문참여 : 4항목에서 아이템을 클릭한 후에 미참여 설문이면 보여주는 화면입니다.
    6. 참여결과 : 4항목에서 아이템을 클릭한 후에 참여한 설문이면 결과를 보여줍니다.
<img src="https://user-images.githubusercontent.com/72678200/115425786-e218a180-a23a-11eb-9cb7-993a470349f2.png" width="20%" height="20%">

# 5. 실행영상

# 6. 회고



