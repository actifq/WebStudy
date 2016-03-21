/**
 * 
 */

<script type="text/javascript >


window.fbAsyncInit = function() {   //페이지 로딩시 기본적으로 fb 세팅을 하는겁니다
  FB.init({   //기본 init 
   appId  : '/*사용하는 페북 앱의 id값 넣는곳... 이건 다른곳 찾아봐도 자세하게 나옵니다.*/', 
   status : true, // check login status
   cookie : true, // enable cookies to allow the server to access the session
   xfbml  : true, // parse XFBML
   oauth  : true // enable OAuth 2.0   기본세팅입니다. 그냥 따라 쓰면 됩니다. 
<!-- API가 번전업이 됬다는 소리입니다. 꼭 넣어 주세요 -->
 });
 };
 
 (function(d){
    var js, id = 'facebook-jssdk'; if (d.getElementById(id)) {return;}
    js = d.createElement('script'); js.id = id; js.async = true;
    js.src = "//connect.facebook.net/en_US/all.js";
    d.getElementsByTagName('head')[0].appendChild(js);
  }(document));   //기본적으로 페이스북과 연동하는 세팅 입니다. 같이 써주면 됩니다.
 
 function loginFB(){
 
 
FB.login(function(response) {
if (response.authResponse) {
     // callback 영역입니다. 자신의 브라우저가 페북에 연동되면 여기로직을 처리 하게 되죠
} else {
     //오류가 났거나 연동이 실패 했을때 처리 하는부분..... 
       }
     }
 , {scope: "user_about_me,publish_stream,read_friendlists,offline_access,email,user_birthday"} 
);
}
 
var FBtoken = "";
function loginFB(){
 
FB.login(function(response) {
if (response.authResponse) {
   FBtoken =  response.authResponse.accessToken;
} else {    
       }
     }
 , {scope: "user_about_me,publish_stream,read_friendlists,offline_access,email,user_birthday"} 
);
} 
 

var fabceloginChk = 0;
function loginFB(){
if(fabceloginChk == 0){
 
FB.login(function(response) {
if (response.authResponse) {
 fabceloginChk  = 1;
} else {   
alert('로그인에 실패했습니다!!!');
fabceloginChk  = 0;
       }
     }
 , {scope: "user_about_me,publish_stream,read_friendlists,offline_access,email,user_birthday"} 
);
}
} 
 
 function getMyProfile(){
FB.api('/me',function(user){
var myName= user.name ;
          var myEmail = user.email;
                  var myId = user.id;
 });
FB.api('/me/picture?type=large',function(data){
var myImg = data.data.url;
});
 
 
}

FB.api(
{
   method: 'fql.query'
 , query: 'SELECT uid, name, email, birthday, pic_square, online_presence  FROM user WHERE uid IN (SELECT uid2 FROM friend WHERE uid1 = me())' 
}
  ,function(response) {
      for(var i=0; i < response.length; i++){
     //솰랴솰랴~ 리스트 작업~
     //위의 쿼리의 컬럼에 맞춰서 response[i].name 이렇게 가져와서 디자인에 맞게 꾸미면 됩니다~   
}
}
 
}
</script>