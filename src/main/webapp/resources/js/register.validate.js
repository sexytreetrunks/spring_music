$(function(){
	$("#regist").validate({
		errorPlacement:function(error,element){ 
			error.addClass("invalid")
			$(element).closest("div")
			.find("div[id='"+element.attr("id")+"']")
			.append(error)
		},
		//errorClass:"invalid",
		rules:{
			email:{
				required:true,
				validEmail : true/*,
				remote:{
					url:"checkEmail.do",
					type:"post",
					data:{
						userid:function(){
							return $('#email').val();
						}
					}
				}*/
			},
			name:{
				required:true,
				minlength:2
			},
			password:{
				required:true,
				validPwd : true
			},
			confirmPassword:{
				required : true,
				equalTo:"#password"
			}
		},
		messages:{
			email:{
				remote: "등록된 이메일입니다.",
				required:"이메일은 필수 입력 요소입니다."
			},
			name:{
				required:"이름은 필수 입력 요소입니다.",
				minlength:"이름은 최소 2자리는 입력해야 합니다"
			},
			password:{
				required:"비밀번호는 필수 입력 요소입니다."	
			},
			confirmPassword:{
				required:"비밀번호는 필수 입력 요소입니다."	,
				equalTo:"이전 비밀번호와 다릅니다."
			}
		}
	});	
});
$.validator.addMethod("validPwd",function(value){
	var regPwd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
	return regPwd.test(value);
},"비밀번호는 숫자와 영문자와 특수문자의 조합으로 8~15자리를 사용해야 합니다.");
$.validator.addMethod("validEmail",function(value){
	var regEmail=/^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	return regEmail.test(value);
},'이메일 형식을 확인해 주세요');

