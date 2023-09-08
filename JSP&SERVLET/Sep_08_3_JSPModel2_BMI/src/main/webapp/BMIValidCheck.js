     function BMIcheckValid(){
        	 
    		//document.form이름.input이름
    		let name = document.pig.NAME
    		let height = document.pig.HEIGHT;
    		let weight = document.pig.WEIGHT;
    		let photo = document.pig.PHOTO;
    		const MAXSIZE=10*1024*1024;	
				
    		
    		//입력 여부 검사
    		if(isEmpty(name)){
    			alert("이름을 입력해주세요");
    			name.focus(); 
    			return false;
    		}
    		
    		if(isEmpty(height)){
    			alert("신장을 입력해주세요");
    			height.focus(); 
    			return false;
    		}
    		
    		if(isEmpty(weight)){
    			alert("체중을 입력해주세요");
    			weight.focus(); 
    			return false;
    		}
    		
			if(isEmpty(photo)){
				alert("사진을 첨부해주세요");
				photo.focus();
				return false;
			}
    		
    		//사진의 용량검사
    		if(photo.files[0].size > MAXSIZE){
			alert("10mb 이하의 사진만 업로드 가능합니다.");
			photo.focus();
			 return false;	
    		}
    		
			//키와 몸무게가 음수가 아닌지 검사     	
    		if(height.value<0){
			alert("신장는 자연수만 입력가능합니다.");
			weight.focus();
			return false;
			}
    		
    		if(weight.value<0){
			alert("몸무게는 자연수만 입력가능합니다.");
			weight.focus();
			return false;
			}
    		
    		//키 몸무게가 숫자인지 검사
    		if(isNotNumber(height)){
				alert("신장은 숫자로 입력해주세요");
    			height.focus(); 
    			return false;
			}
			
			if(isNotNumber(weight)){
				alert("몸무게는 숫자로 입력해주세요");
    			weight.focus(); 
    			return false;
			}
			
    
    				
    		//이름이 문자인지 검사
			const checkEng = /[a-zA-Z]/;
			const checkKor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

			if(!checkKor.test(name.value)&& !checkEng.test(name.value)){
				alert("이름은 한글과 영어만 입력 가능합니다.");
				name.focus();
				return false;
			}
			
		
			return true;
    	  } 